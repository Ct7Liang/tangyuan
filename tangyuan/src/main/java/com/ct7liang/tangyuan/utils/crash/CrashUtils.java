package com.ct7liang.tangyuan.utils.crash;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ct7liang.tangyuan.AppFolder;

import java.io.File;

/**
 * Created by Administrator on 2018-05-07.
 *
 */
public class CrashUtils {

    public static void init(Context applicationContext, boolean isShowToast, String content){
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(applicationContext, new File(AppFolder.get()+"/crash_log"), isShowToast, content);
    }

    public static void init(Context applicationContext, @NonNull File folder,  boolean isShowToast, String content){
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(applicationContext, folder, isShowToast, content);
    }
}