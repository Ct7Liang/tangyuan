package com.ct7liang.developer.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 手机信息 & MAC地址 & 开机时间
 *
 * @author MaTianyu
 * @date 2014-09-25
 */
public class AndroidUtil {
    private static final String TAG = AndroidUtil.class.getSimpleName();
    //Ethernet Mac Address
    private static final String ETH0_MAC_ADDRESS = "/sys/class/net/eth0/address";

    /**
     * 获取 Wifi MAC 地址
     * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
     */
    @Deprecated
    public static String getMacAddress(Context context) {
        return getWifiMacAddress(context);
    }

    /**
     * 获取 Wifi MAC 地址
     * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
     */
    public static String getWifiMacAddress(Context context) {
        //wifi mac地址
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String mac = info.getMacAddress();
        return mac;
    }


//    /**
//     * 获取 以太网 MAC 地址
//     */
//    public static String getEthernetMacAddress() {
//        try {
//            String mac = FileUtils.readFileToString(new File(ETH0_MAC_ADDRESS));
//            return mac;
//        } catch (IOException e) {
//            Log.e(TAG, "IO Exception when getting eth0 mac address", e);
//            e.printStackTrace();
//            return "unknown";
//        }
//    }

    /**
     * 获取 ANDROID_ID
     */
    public static String getAndroidId(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }

    /**
     * 获取 开机时间
     */
    public static String getBootTimeString() {
        long ut = SystemClock.elapsedRealtime() / 1000;
        int h = (int) ((ut / 3600));
        int m = (int) ((ut / 60) % 60);
        return h + ":" + m;
    }

    public static String printSystemInfo() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        StringBuilder sb = new StringBuilder();
        sb.append("_______  系统信息  ").append(time).append(" ______________");
        sb.append("\nID                 :").append(Build.ID);
        sb.append("\nBRAND              :").append(Build.BRAND);
        sb.append("\nMODEL              :").append(Build.MODEL);
        sb.append("\nRELEASE            :").append(Build.VERSION.RELEASE);
        sb.append("\nSDK                :").append(Build.VERSION.SDK);

        sb.append("\n_______ OTHER _______");
        sb.append("\nBOARD              :").append(Build.BOARD);
        sb.append("\nPRODUCT            :").append(Build.PRODUCT);
        sb.append("\nDEVICE             :").append(Build.DEVICE);
        sb.append("\nFINGERPRINT        :").append(Build.FINGERPRINT);
        sb.append("\nHOST               :").append(Build.HOST);
        sb.append("\nTAGS               :").append(Build.TAGS);
        sb.append("\nTYPE               :").append(Build.TYPE);
        sb.append("\nTIME               :").append(Build.TIME);
        sb.append("\nINCREMENTAL        :").append(Build.VERSION.INCREMENTAL);

        sb.append("\n_______ CUPCAKE-3 _______");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            sb.append("\nDISPLAY            :").append(Build.DISPLAY);
        }

        sb.append("\n_______ DONUT-4 _______");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
            sb.append("\nSDK_INT            :").append(Build.VERSION.SDK_INT);
            sb.append("\nMANUFACTURER       :").append(Build.MANUFACTURER);
            sb.append("\nBOOTLOADER         :").append(Build.BOOTLOADER);
            sb.append("\nCPU_ABI            :").append(Build.CPU_ABI);
            sb.append("\nCPU_ABI2           :").append(Build.CPU_ABI2);
            sb.append("\nHARDWARE           :").append(Build.HARDWARE);
            sb.append("\nUNKNOWN            :").append(Build.UNKNOWN);
            sb.append("\nCODENAME           :").append(Build.VERSION.CODENAME);
        }

        sb.append("\n_______ GINGERBREAD-9 _______");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sb.append("\nSERIAL             :").append(Build.SERIAL);
        }
        Log.i(TAG, sb.toString());
        return sb.toString();
    }

    /**
     * 判断本应用是否位于栈顶
     * 需要权限<uses-permission android:name="android.permission.GET_TASKS"/>
     */
    public static boolean isAppOnForeground(Context ctx) {
        ActivityManager mActivityManager = ((ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE));
        String mPackageName = ctx.getPackageName();
        List<ActivityManager.RunningTaskInfo> tasksInfo = mActivityManager.getRunningTasks(1);
        if (tasksInfo.size() > 0) {
            // 应用程序位于堆栈的顶层
            if (mPackageName.equals(tasksInfo.get(0).topActivity.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得栈顶的包名
     * @param mContext
     * @return
     */
    public static String getTaskPackname(Context mContext) {
        ActivityManager.RunningAppProcessInfo currentInfo = null;
        Field field = null;
        int START_TASK_TO_FRONT = 2;
        String currentApp = "CurrentNULL";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            try {
                field = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e) {
                e.printStackTrace();
            }
            ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appList = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo app : appList) {
                if (app.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    Integer state = null;
                    try {
                        state = field.getInt(app);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (state != null && state == START_TASK_TO_FRONT) {
                        currentInfo = app;
                        break;
                    }
                }
            }
            if (currentInfo != null) {
                currentApp = currentInfo.processName;
            }
        } else {
            ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
            currentApp = tasks.get(0).processName;
        }
        Log.e("TAG", "Current App in foreground is: " + currentApp);
        return currentApp;
    }



    /** 
     * 获取手机IMEI(需要权限<uses-permission android:name="android.permission.READ_PHONE_STATE"/>) 
     * @return 手机IMEI
     */
    public static String getIMEI(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getDeviceId();
        }
        return null;
    }

    /**
     * 检测当前网络的类型 是否是wifi
     *
     * @param context
     * @return
     */
    public static int checkedNetWorkType(Context context) {
        if (!checkedNetWork(context)) {
            return 0;//无网络
        }
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting()) {
            return 1;//wifi
        } else {
            return 2;//非wifi
        }
    }

    /**
     * 检查是否连接网络
     *
     * @param context
     * @return
     */
    public static boolean checkedNetWork(Context context) {
        // 获得连接设备管理器
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;        /**
         * 获取网络连接对象
         */
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return false;
        }        return true;
    }
}