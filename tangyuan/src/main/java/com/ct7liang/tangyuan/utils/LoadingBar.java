package com.ct7liang.tangyuan.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018-04-09.
 *
 */
public class LoadingBar extends ProgressDialog {

    private static LoadingBar loadingBar;

    public LoadingBar(Context context) {
        super(context);
    }

    public static void run(Context context, String content, boolean cancelable, OnBackPressed onBackPressed){
        loadingBar = new LoadingBar(context);
        loadingBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingBar.setCanceledOnTouchOutside(cancelable);
        loadingBar.setListener(onBackPressed);
        loadingBar.show(context, null, content);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (onBackPress!=null){
            onBackPress.onPressed(loadingBar);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (onBackPress!=null){
                onBackPress.onPressed(loadingBar);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setListener(OnBackPressed onBackPress){
        this.onBackPress = onBackPress;
    }
    public OnBackPressed onBackPress;
    public interface OnBackPressed{
        void onPressed(LoadingBar loadingBar);
    }

}