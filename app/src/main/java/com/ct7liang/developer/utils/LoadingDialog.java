package com.ct7liang.developer.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2018-04-13.
 */

public class LoadingDialog {

    public static class ZddProgressDialog extends ProgressDialog {
        public ZddProgressDialog(Context context) {
            super(context);
        }
        public ZddProgressDialog(Context context, int theme) {
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

    public static void show(Context context, boolean cancelable, String msg, ZddProgressDialog.OnBackPressed onBackPressed){
        ZddProgressDialog zddProgressDialog = new ZddProgressDialog(context);
        zddProgressDialog.setCanceledOnTouchOutside(cancelable);
        if (onBackPressed!=null){
            zddProgressDialog.setBackListener(onBackPressed);
        }
        zddProgressDialog.show();
    }
}
