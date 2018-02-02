package com.ct7liang.tangyuan.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2018-02-01.
 *
 */
public class AppExitReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (context instanceof Activity){
            ((Activity)context).finish();
        }
    }
}
