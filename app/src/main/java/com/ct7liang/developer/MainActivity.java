package com.ct7liang.developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ct7liang.developer.test_activity.Main2Activity;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.ScreenUtil;

public class MainActivity extends BaseActivity {

    String string;

    @Override
    public int setLayout() {
        //提供布局文件
        return R.layout.activity_main;
    }

    @Override
    public void getOnCreateParams(Bundle savedInstanceState) {

    }

    @Override
    protected void setStatusBar() {
        setOrientation(true);
        //用于实现沉浸式状态栏
        findViewById(R.id.title_back_ground).setPadding(0, ScreenUtil.getUtils().getStatusHeight(this), 0, 0);
    }

    @Override
    public void initSurface() {
        findViewById(R.id.btn).setOnClickListener(this);
        initStatusBar();
    }

    @Override
    public void onClick(View v) {
        //点击事件处理
        switch (v.getId()){
            case R.id.btn:
                startActivity(new Intent(this, Main2Activity.class));
                finish();
                break;
        }
    }

    @Override
    public void exitApp() {
        super.exitApp();
        //退出应用提示 销毁所有的Activity
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.write("MainActivity.destroy()");
    }
}