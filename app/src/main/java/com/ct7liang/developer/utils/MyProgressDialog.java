package com.ct7liang.developer.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2018-04-13.
 */

public class MyProgressDialog extends ProgressDialog{

    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    public void onBackPressed() {
        onBackPressed.onBackPressed();
        super.onBackPressed();
    }

    public void setBackListener(OnBackPressed onBackPressed){
        this.onBackPressed = onBackPressed;
    }
    public OnBackPressed onBackPressed;
    public interface OnBackPressed{
        void onBackPressed();
    }

}