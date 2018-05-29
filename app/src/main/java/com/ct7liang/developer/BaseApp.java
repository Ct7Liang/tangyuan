package com.ct7liang.developer;

import android.app.Application;

import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.SpUtils;
import com.ct7liang.tangyuan.utils.ToastUtils;

/**
 * Created by Administrator on 2018-02-02.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SpUtils.init(this);//初始化SharedPreferences

        ToastUtils.setIsShowTestEnable(true); //是否显示用于测试的Toast 默认为true

//        LogUtils.setTag("设置自定义的TAG,便于查看控制台");
        LogUtils.setLogEnable(true); //后台日志 默认为true
        LogUtils.setShowLocationEnable(false); //打印日志的时候是否打印位置信息 默认为false

        AppFolder.createAppFolder("App文件夹名称");

    }

}