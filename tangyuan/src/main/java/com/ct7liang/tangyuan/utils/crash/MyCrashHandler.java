package com.ct7liang.tangyuan.utils.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ct7liang.tangyuan.utils.LogUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * @author user
 */
public class MyCrashHandler implements UncaughtExceptionHandler {

    //系统默认的UncaughtException处理类
    private UncaughtExceptionHandler mDefaultHandler;

    //程序的Context对象
    private Context mContext;

    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<>();

    //用于格式化日期,作为日志文件名的一部分
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private File fileFolder;
    private boolean isShowToast = true;
    private String content = "";

    //CrashHandler实例
    private static MyCrashHandler INSTANCE = new MyCrashHandler();
    /** 保证只有一个CrashHandler实例 */
    private MyCrashHandler() {}
    /** 获取CrashHandler实例 ,单例模式 */  
    public static MyCrashHandler getInstance() {
        return INSTANCE;  
    }

    /** 
     * 初始化
     */  
    public void init(Context context, @NonNull File folder, boolean isShowToast, @NonNull String content) {
        mContext = context;
        if (folder==null){
            throw new NullPointerException("CrashHandler初始化文件夹不能为空");
        }else{
            fileFolder = folder;
        }
        this.isShowToast = isShowToast;
        this.content = content;
        //获取系统默认的UncaughtException处理器  
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();  
        //设置该CrashHandler为程序的默认处理器  
        Thread.setDefaultUncaughtExceptionHandler(this);  
    }

    /** 
     * 当UncaughtException发生时会转入该函数来处理 
     */  
    @Override  
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                LogUtils.write("错误信息: " + e.toString());
            }
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
  
    /** 
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     * @param ex Throwable
     * @return true:如果处理了该异常信息;否则返回false. 
     */  
    private boolean handleException(Throwable ex) {  
        if (ex == null)  {
            return false;  
        }  
        //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                if (isShowToast){
                    Toast.makeText(mContext, content, Toast.LENGTH_LONG).show();
                }
                Looper.loop();
            }
        }.start();
        //收集设备参数信息   
        collectDeviceInfo(mContext);  
        //保存日志文件   
        saveCrashInfo2File(ex);  
        return true;  
    }  

    /** 
     * 收集设备参数信息 
     * @param ctx 
     */  
    public void collectDeviceInfo(Context ctx) {  
        try {  
            PackageManager pm = ctx.getPackageManager();  
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);  
            if (pi != null) {  
                String versionName = pi.versionName == null ? "null" : pi.versionName;  
                String versionCode = pi.versionCode + "";  
                infos.put("versionName", versionName);  
                infos.put("versionCode", versionCode);  
            }  
        } catch (NameNotFoundException e) {
            LogUtils.write("收集包文件信息时出错: " + e.toString());
        }  
        Field[] fields = Build.class.getDeclaredFields();  
        for (Field field : fields) {  
            try {  
                field.setAccessible(true);  
                infos.put(field.getName(), field.get(null).toString());
//                LogUtils.write(field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                LogUtils.write("收集错误日志时出错: " + e.toString());
            }
        }
    }
  
    /** 
     * 保存错误信息到文件中
     * @param ex 
     * @return  返回文件名称,便于将文件传送到服务器 
     */  
    private String saveCrashInfo2File(Throwable ex) {
        if (ex == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();  
        for (Map.Entry<String, String> entry : infos.entrySet()) {  
            String key = entry.getKey();  
            String value = entry.getValue();  
            sb.append(key + "=" + value + "\n");  
        }
        Writer writer = new StringWriter();  
        PrintWriter printWriter = new PrintWriter(writer);  
        ex.printStackTrace(printWriter);  
        Throwable cause = ex.getCause();  
        while (cause != null) {  
            cause.printStackTrace(printWriter);  
            cause = cause.getCause();  
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        try {
//            long timestamp = System.currentTimeMillis();
            String time = formatter.format(new Date());  
//            String fileName = "crash-" + time + "-" + timestamp + ".log";
            String fileName = "crash - " + time + ".log";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//                String path = "/sdcard/crash/";
//                File dir = new File(path);
                if (!fileFolder.exists()) {
                    fileFolder.mkdirs();
                }  
                FileOutputStream fos = new FileOutputStream(fileFolder.getAbsoluteFile() + "/" + fileName);
                fos.write(sb.toString().getBytes());
                fos.close();
            }  
            return fileName;  
        } catch (Exception e) {  
            LogUtils.write("记录崩溃日志时出错: " + e.toString());
        }  
        return null;  
    }  
}  