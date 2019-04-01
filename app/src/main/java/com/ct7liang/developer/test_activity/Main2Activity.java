package com.ct7liang.developer.test_activity;

import android.view.View;
import com.ct7liang.developer.BaseActivity;
import com.ct7liang.developer.R;
import com.ct7liang.tangyuan.utils.LogUtils;

public class Main2Activity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void initSurface() {
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.write("Main2Activity.destroy()");
    }
}