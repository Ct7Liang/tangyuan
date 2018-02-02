package com.ct7liang.tangyuan.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ct7liang.tangyuan.R;

/**
 * Created by Administrator on 2017/9/17.
 *
 */
public class BottomWindow {

    private BottomWindow(){}
    private static BottomWindow mBottomWindow;
    public static BottomWindow getInstance(){
        if (mBottomWindow == null){
            mBottomWindow = new BottomWindow();
        }
        return mBottomWindow;
    }

    public void show(Activity act, int layoutResource, int height, ViewSetting viewSetting){
        Dialog mDetailWindow = new Dialog(act, R.style.dialog_bottom_full);
        mDetailWindow.setCanceledOnTouchOutside(true);
        mDetailWindow.setCancelable(true);
        Window window = mDetailWindow.getWindow();
        if (window != null){
            window.setGravity(Gravity.BOTTOM);
        }
        mDetailWindow.getWindow().setWindowAnimations(R.style.share_animation);
        View view = View.inflate(act, layoutResource, null);
        viewSetting.onSetting(mDetailWindow, view);
        mDetailWindow.getWindow().setContentView(view);
        mDetailWindow.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, height);//设置横向全屏
        mDetailWindow.show();
    }
    public interface ViewSetting{
        void onSetting(Dialog dialog, View view);
    }
}