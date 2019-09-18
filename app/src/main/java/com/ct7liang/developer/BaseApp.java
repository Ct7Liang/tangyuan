package com.ct7liang.developer;

import android.app.Application;

import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.SpUtils;
import com.ct7liang.tangyuan.crash.CrashUtils;

/**
 * Created by Administrator on 2018-02-02.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SpUtils.init(this);//初始化SharedPreferences


        LogUtils.setTag("Ct7");
        LogUtils.setLogEnable(true); //后台日志 默认为true

        AppFolder.createAppFolder("App文件夹名称");

        CrashUtils.init(getApplicationContext(), true, null);
    }

}