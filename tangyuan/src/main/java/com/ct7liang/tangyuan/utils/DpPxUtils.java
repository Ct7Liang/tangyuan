package com.ct7liang.tangyuan.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/6/13.
 *
 */
public class DpPxUtils {

    public static int Dp2Px(Context appContext, float dp) {
        final float scale = appContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int Px2Dp(Context appContext, float px) {
        final float scale = appContext.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}