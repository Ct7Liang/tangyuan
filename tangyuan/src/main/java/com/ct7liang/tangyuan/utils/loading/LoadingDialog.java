package com.ct7liang.tangyuan.utils.loading;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import com.ct7liang.tangyuan.R;

/**
 * Created by Administrator on 2018-04-13.
 *  等待加载进度窗口
 */
public class LoadingDialog {

    /**
     * 显示一个默认等待窗口
     * @param context ""
     * @param cancelable 点击除了返回键任何位置是否可以消失
     * @param msg 窗口显示文字
     * @param onBackPressed 点击返回键的监听(可用来在窗口消失的时候做一些取消处理)
     */
    public static void show(Context context, boolean cancelable, @Nullable String msg, @Nullable ZddProgressDialog.OnBackPressed onBackPressed, @Nullable ProgressDialog.OnDismissListener onDismiss){
        ZddProgressDialog zddProgressDialog = new ZddProgressDialog(context);
        zddProgressDialog.setCanceledOnTouchOutside(cancelable);
        if (onBackPressed!=null){
            zddProgressDialog.setBackListener(onBackPressed);
        }
        if (onDismiss!=null){
            zddProgressDialog.setOnDismissListener(onDismiss);
        }
        zddProgressDialog.setMessage(msg);
        zddProgressDialog.show();
    }

    /**
     * 显示一个指定布局的等待窗口 背景不变灰色
     * @param context ""
     * @param layoutResource 布局资源
     * @param cancelable 点击除了返回键任何位置是否可以消失
     * @param onBackPressed 点击返回键的监听(可用来在窗口消失的时候做一些取消处理)
     */
    public static void show(Context context, int layoutResource, boolean cancelable, @Nullable ZddProgressDialog.OnBackPressed onBackPressed, @Nullable ProgressDialog.OnDismissListener onDismiss){
        ZddProgressDialog zddProgressDialog = new ZddProgressDialog(context, R.style.dialog_not_gray_back_ground);
        zddProgressDialog.setCanceledOnTouchOutside(cancelable);
        if (onBackPressed!=null){
            zddProgressDialog.setBackListener(onBackPressed);
        }
        if (onDismiss!=null){
            zddProgressDialog.setOnDismissListener(onDismiss);
        }
        zddProgressDialog.show();
        zddProgressDialog.setContentView(layoutResource);
    }

    /**
     * 显示一个指定布局的等待窗口 背景变灰色
     * @param context ""
     * @param isGrayBg 背景是否显示灰色
     * @param layoutResource 布局资源
     * @param cancelable 点击除了返回键任何位置是否可以消失
     * @param width 宽度
     * @param height 高度
     * @param onBackPressed 点击返回键的监听(可用来在窗口消失的时候做一些取消处理)
     */
    public static void show(Context context, boolean isGrayBg, int layoutResource, boolean cancelable, int width, int height, @Nullable ZddDialog.OnBackPressed onBackPressed, @Nullable Dialog.OnDismissListener onDismiss){
        ZddDialog zddDialog = new ZddDialog(context, isGrayBg?R.style.dialog_gray_back_ground:R.style.dialog_not_gray_back_ground);
        zddDialog.setCanceledOnTouchOutside(cancelable);
        if (onBackPressed!=null){
            zddDialog.setBackListener(onBackPressed);
        }
        if (onDismiss!=null){
            zddDialog.setOnDismissListener(onDismiss);
        }
        zddDialog.show();
        zddDialog.setContentView(layoutResource);
        if (width==0||height==0){
            zddDialog.setContentView(layoutResource);
        }else{
            zddDialog.setContentView(View.inflate(context, layoutResource, null), new LinearLayout.LayoutParams(width, height));
        }
    }
}
