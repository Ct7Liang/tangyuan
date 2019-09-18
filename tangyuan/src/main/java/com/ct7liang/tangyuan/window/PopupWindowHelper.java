package com.ct7liang.tangyuan.window;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class PopupWindowHelper {

    /**
     * @param activity Activity
     * @param layoutID 布局id
     * @param focusable 是否返回键有效
     * @param touchable 是否点击外部有效
     * @param windowAlpha 背景透明度
     * @param listener 弹窗点击监听
     */
    public static PopupWindow create(final Activity activity, @LayoutRes int layoutID, boolean focusable, boolean touchable, final float windowAlpha, OnPopupWindowInitListener listener){
        if (windowAlpha != 1f){
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.alpha = windowAlpha;//调节透明度
            activity.getWindow().setAttributes(lp);
        }
        View view = View.inflate(activity, layoutID, null);
        PopupWindow popupWindow = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(focusable);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(touchable);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (windowAlpha != 1f){
                    WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                    lp.alpha = 1f;//调节透明度
                    activity.getWindow().setAttributes(lp);
                }
            }
        });
        if (listener!=null){
            listener.onComplete(popupWindow, view);
        }
        return popupWindow;
    }

    /**
     * @param activity Activity
     * @param layoutID 布局id
     * @param width 宽度
     * @param height 高度
     * @param focusable 是否返回键有效
     * @param touchable 是否点击外部有效
     * @param windowAlpha 背景透明度
     * @param listener 弹窗点击监听
     */
    public static PopupWindow create(final Activity activity, @LayoutRes int layoutID, int width, int height, boolean focusable, boolean touchable, final float windowAlpha, OnPopupWindowInitListener listener){
        if (windowAlpha != 1f){
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.alpha = windowAlpha;//调节透明度
            activity.getWindow().setAttributes(lp);
        }
        View view = View.inflate(activity, layoutID, null);
        PopupWindow popupWindow = new PopupWindow(view, width, height);
        popupWindow.setFocusable(focusable);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(touchable);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (windowAlpha != 1f){
                    WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                    lp.alpha = 1f;//调节透明度
                    activity.getWindow().setAttributes(lp);
                }
            }
        });
        if (listener!=null){
            listener.onComplete(popupWindow, view);
        }
        return popupWindow;
    }

}
