package com.ct7liang.tangyuan.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017-12-04.
 *  获取屏幕相关信息
 */
public class ScreenUtil {

    private static ScreenUtil screenUtil;
    private ScreenUtil(){}
    public static ScreenUtil getUtils(){
        if (screenUtil == null){
            screenUtil = new ScreenUtil();
        }
        return screenUtil;
    }

    private int StatusBarHeight;
    private int ScreenWidth;
    private int ScreenHeight;

    /**
     * 获取状态栏高度
     */
    public int getStatusHeight(Context context){
        //判断是否已经测量过了状态栏的高度
        if (StatusBarHeight!=0){
            return StatusBarHeight;
        }
        return getStatusBarHeightByResource(context);
    }

    /**
     * 获取屏幕宽度
     */
    public int getScreenWidth(Context context){
        if (ScreenWidth != 0) {
            return ScreenWidth;
        }
        if (context == null){
            return 0;
        }
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        ScreenWidth = metrics.widthPixels;
        return ScreenWidth;
    }

    /**
     * 获取屏幕高度
     */
    public int getScreenHeight(Context context){
        if (ScreenHeight != 0){
            return ScreenHeight;
        }
        if (context == null){
            return 0;
        }
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        ScreenHeight = metrics.heightPixels;
        return ScreenHeight;
    }



    /**
     * 获取屏幕状态栏高度
     * @param context 方法一：系统提供了一个Resource类，通过这个类可以获取资源文件，借此可以获取 到status_bar_height
     */
    private int getStatusBarHeightByResource(Context context){
        if (context==null){
            return 0;
        }
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取相应的尺寸值
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            StatusBarHeight = statusBarHeight;
            return StatusBarHeight;
        }else{
            return getStatusBarHeightByReflex(context);
        }
    }

    /**
     * @param context 方法二 Android的所有资源都会有惟一标识在R类中作为引用。我们也可以通过反射获取R类的实例域，然后找 status_bar_height
     */
    private int getStatusBarHeightByReflex(Context context){
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            StatusBarHeight = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            return context.getResources().getDimensionPixelSize(StatusBarHeight);
        } catch (Exception e) {
            e.printStackTrace();
            StatusBarHeight = 0;
            return StatusBarHeight;
        }
    }

    private void getScreenWHByContext(Context context){
        LogUtils.write("获取屏幕宽高:方法一");
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getWidth(); //方法已经过时 宽
        windowManager.getDefaultDisplay().getHeight(); //方法已经过时 高
    }
    private void getScreenWHByActivity(Activity activity){
        LogUtils.write("获取屏幕宽高:方法二");
        WindowManager windowManager = ((Activity) activity).getWindowManager(); //context必须为Activity才能调用
        windowManager.getDefaultDisplay().getWidth(); //方法已经过时 宽
        windowManager.getDefaultDisplay().getHeight(); //方法已经过时 高
    }
    private void getScreenWHByResource(Context context){
        LogUtils.write("获取屏幕宽高:方法三");
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        LogUtils.write(metrics.widthPixels + " = 1080");
        LogUtils.write(metrics.heightPixels + " = 1920");
        LogUtils.write(metrics.density + " = 3.0");
        LogUtils.write(metrics.scaledDensity + " = 3.0");
        LogUtils.write(metrics.xdpi + " = 403.411");
        LogUtils.write(metrics.ydpi + " = 403.041");
        LogUtils.write(metrics.densityDpi + " = 480");
    }


}
