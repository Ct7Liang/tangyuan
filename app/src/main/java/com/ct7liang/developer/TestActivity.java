package com.ct7liang.developer;

import android.view.View;
import android.widget.TextView;

public class TestActivity extends BaseActivity {

    private TextView info;

    @Override
    public int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void findView() {
        info = (TextView) findViewById(R.id.info);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {
//        info.setText(SystemUtils.printSystemInfo());
    }

    @Override
    public void onClick(View v) {

    }
}
