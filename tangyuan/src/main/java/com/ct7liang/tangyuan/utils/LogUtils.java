package com.ct7liang.tangyuan.utils;

import android.util.Log;

/**
 * Created by Administrator on 2018/1/24.
 *  日志打印工具类
 */
public class LogUtils {

    private static String TAG = "Ct7";
    private static boolean isDoLog = true;
    private static boolean isShowLocation = false;

    public static void setTag(String tag){
        TAG = tag;
    }

    public static void setLogEnable(boolean isWriteLog){
        isDoLog = isWriteLog;
    }

    public static void setShowLocationEnable(boolean isWriteLocation){
        isShowLocation = isWriteLocation;
    }

    public static void write(String string){
        if (!isDoLog){
            return;
        }
        if (isShowLocation){
            StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
            String caller = "<unknown>";
            for (int i = 2; i < trace.length; i++) {
                Class<?> clazz = trace[i].getClass();
                if (!clazz.equals(LogUtils.class)) {
                    String callingClass = trace[i].getClassName();
                    callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                    caller = callingClass + "." + trace[i].getMethodName();
                    break;
                }
            }
            Log.i(TAG, caller + ": " + string);
        }else{
            Log.i(TAG, string);
        }
    }
}