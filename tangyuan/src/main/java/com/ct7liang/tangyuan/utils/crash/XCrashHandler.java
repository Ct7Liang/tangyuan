package com.ct7liang.tangyuan.utils.crash;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by Administrator on 2018-05-30.
 *
 */

public class XCrashHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler defaultUncaught;
    private Context context;

    public void init(Context context){
        defaultUncaught = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        long id = Thread.currentThread().getId();
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, "1234567890", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
    }


}
