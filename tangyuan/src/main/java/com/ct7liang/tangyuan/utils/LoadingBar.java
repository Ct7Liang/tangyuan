package com.ct7liang.tangyuan.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018-04-09.
 */

public class LoadingBar extends ProgressDialog {

    private static LoadingBar loadingBar;

    public LoadingBar(Context context) {
        super(context);
    }

    public static void run(Context context, String content, boolean cancelable){
        loadingBar = new LoadingBar(context);
        loadingBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingBar.show(context, null, content, true, cancelable);
    }

    public static void run(Context context, int resource, int width, boolean cancelable){
        loadingBar = new LoadingBar(context);
        loadingBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingBar.addContentView(View.inflate(context, resource, null), new LinearLayout.LayoutParams(width, width));
        loadingBar.setCanceledOnTouchOutside(cancelable);
        loadingBar.show();
    }

    public static void run(Context context, int resource, int width, int height, boolean cancelable){
        loadingBar = new LoadingBar(context);
        loadingBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingBar.addContentView(View.inflate(context, resource, null), new LinearLayout.LayoutParams(width, height));
        loadingBar.setCanceledOnTouchOutside(cancelable);
        loadingBar.show();
    }
}