package com.ct7liang.developer;

import android.os.Bundle;
import android.view.View;

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
    public void findView() {
        findViewById(R.id.btn).setOnClickListener(this);
        initStatusBar();
        //查找控件
    }

    @Override
    public void initData() {
        //初始化数据
    }

    @Override
    public void initView() {
        //初始化设置控件
    }

    @Override
    public void initFinish() {
        //初始化完成
//        startActivity(new Intent(this, LoadingDialogActivity.class));
//        startActivity(new Intent(this, TitlebarTestActivity.class));
        int length = string.length();
//        Toast.makeText(getApplicationContext(), "1234567890", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        //点击事件处理
        switch (v.getId()){
            case R.id.btn:
                int length = string.length();
                break;
        }
    }

    @Override
    public void exitApp() {
        super.exitApp();
        //退出应用提示 销毁所有的Activity
    }

}