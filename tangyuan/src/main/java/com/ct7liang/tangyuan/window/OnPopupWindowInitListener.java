package com.ct7liang.tangyuan.window;

import android.view.View;
import android.widget.PopupWindow;

public interface OnPopupWindowInitListener {
    void onComplete(PopupWindow popupWindow, View contentView);
}