package com.ct7liang.tangyuan.window;

import android.app.Dialog;
import android.view.View;

public interface OnWindowInitListener {
    void onComplete(final Dialog dialog, View contentView);
}