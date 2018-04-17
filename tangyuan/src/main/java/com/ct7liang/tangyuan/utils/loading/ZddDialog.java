package com.ct7liang.tangyuan.utils.loading;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Administrator on 2018-04-17.
 *  继承自Dialog后可以设置宽度和高度, 背景可变灰可不变灰
 */
public class ZddDialog extends Dialog {

    public ZddDialog(Context context) {
        super(context);
    }

    public ZddDialog(Context context, int theme) {
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
