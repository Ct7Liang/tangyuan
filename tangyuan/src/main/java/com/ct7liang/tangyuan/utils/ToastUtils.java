package com.ct7liang.tangyuan.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/31.
 *
 */
public class ToastUtils {

    private static boolean isShowTest = true;
    //静态Toast
    private static Toast mToast;

    /**
     * 弹出静态toast
     * @param msg 内容
     */
    public static void showStatic(Context context, String msg){   /*1. 第一次调用时  2.toast消失*/
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }



    public static void setShowEnable(boolean show){
        isShowTest = show;
    }

    public static void ShowTest(Context context, String msg){
        if (isShowTest){
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            }
            mToast.setText(msg);
            mToast.show();
        }
    }
}