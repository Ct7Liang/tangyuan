package com.ct7liang.tangyuan.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017-12-04.
 *  获取屏幕相关信息
 */
public class ScreenInfoUtil {

    /**
     * 获取屏幕状态栏高度
     * @param context 方法一：系统提供了一个Resource类，通过这个类可以获取资源文件，借此可以获取 到status_bar_height
     */
    public static int getStatusHeight(Context context){
        if (context==null){
            return 0;
        }
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取相应的尺寸值
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            return statusBarHeight;
        }else{
            return getStatusBarHeightByReflex(context);
        }
    }

    /**
     * @param context 方法二 Android的所有资源都会有惟一标识在R类中作为引用。我们也可以通过反射获取R类的实例域，然后找 status_bar_height
     */
    public static int getStatusBarHeightByReflex(Context context){
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            return context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取屏幕宽高
     * @param context
     * @return
     */
    public static int[] getScreenWH(Context context){
        if (context == null){
            return new int[]{0, 0};
        }
//        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
//        WindowManager windowManager = ((Activity) context).getWindowManager(); //context必须为Activity才能调用
//        windowManager.getDefaultDisplay().getWidth(); //方法已经过时
//        windowManager.getDefaultDisplay().getHeight(); //方法已经过时

//        Resources resources = context.getResources();
//        DisplayMetrics metrics = resources.getDisplayMetrics();
//        metrics.widthPixels; 1080
//        metrics.heightPixels; 1920
//        metrics.density; 3.0
//        metrics.scaledDensity; 3.0
//        metrics.xdpi; 403.411
//        metrics.ydpi; 403.041
//        metrics.densityDpi; 480

        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
//        WindowManager windowManager = ((Activity)context).getWindowManager(); //context必须为Activity才能调用
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
//        metrics.widthPixels; 1080
//        metrics.heightPixels; 1920
//        metrics.density; 3.0
//        metrics.scaledDensity; 3.0
//        metrics.xdpi; 403.411
//        metrics.ydpi; 403.041
//        metrics.densityDpi; 480
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }
}
