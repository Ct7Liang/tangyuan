package com.ct7liang.tangyuan.utils.loading;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2018-04-13.
 *  继承自ProgressDialog后设置宽度没有效果, 只能通过构造方法设置一个样式,
 *  使ProgressDialog的背景变为透明, 并且在显示的时候背景不会变灰
 */
public class ZddProgressDialog extends ProgressDialog {

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