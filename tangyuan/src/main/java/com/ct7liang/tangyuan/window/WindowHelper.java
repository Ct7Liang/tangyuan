package com.ct7liang.tangyuan.window;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.ct7liang.tangyuan.R;

public class WindowHelper {

    public static void create(Activity activity, @LayoutRes int layoutResId, @StyleRes int themeResId, OnWindowInitListener contentViewInitListener){
        Dialog dialog = new Dialog(activity, themeResId);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View contentView = View.inflate(activity, layoutResId, null);
        if (contentViewInitListener != null){
            contentViewInitListener.onComplete(dialog, contentView);
        }
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialog.addContentView(contentView, lp);
        try {
            dialog.show();
        }catch (Exception e){
            Log.i("WindowHelper","弹出框打开失败:" + e.getMessage());
        }
    }

    public static void create(Activity activity, @LayoutRes int layoutResId, OnWindowInitListener contentViewInitListener){
        Dialog dialog = new Dialog(activity, R.style.dialog_bg);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View contentView = View.inflate(activity, layoutResId, null);
        if (contentViewInitListener != null){
            contentViewInitListener.onComplete(dialog, contentView);
        }
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialog.addContentView(contentView, lp);
        try {
            dialog.show();
        }catch (Exception e){
            Log.i("WindowHelper","弹出框打开失败:" + e.getMessage());
        }
    }

    public static void create(Activity activity, @LayoutRes int layoutResId, int width, int height, OnWindowInitListener contentViewInitListener){
        Dialog dialog = new Dialog(activity, R.style.dialog_bg);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View contentView = View.inflate(activity, layoutResId, null);
        if (contentViewInitListener != null){
            contentViewInitListener.onComplete(dialog, contentView);
        }
        width = width==0?RelativeLayout.LayoutParams.MATCH_PARENT:width;
        height = height==0?RelativeLayout.LayoutParams.WRAP_CONTENT:height;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width, height);
        dialog.addContentView(contentView, lp);
        try {
            dialog.show();
        }catch (Exception e){
            Log.i("WindowHelper","弹出框打开失败:" + e.getMessage());
        }
    }

    public static void create(Activity activity, @LayoutRes int layoutResId, @StyleRes int themeResId, int width, int height, OnWindowInitListener contentViewInitListener){
        Dialog dialog = new Dialog(activity, themeResId);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View contentView = View.inflate(activity, layoutResId, null);
        if (contentViewInitListener != null){
            contentViewInitListener.onComplete(dialog, contentView);
        }
        width = width==0?RelativeLayout.LayoutParams.MATCH_PARENT:width;
        height = height==0?RelativeLayout.LayoutParams.WRAP_CONTENT:height;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width, height);
        dialog.addContentView(contentView, lp);
        try {
            dialog.show();
        }catch (Exception e){
            Log.i("WindowHelper","弹出框打开失败:" + e.getMessage());
        }
    }

}