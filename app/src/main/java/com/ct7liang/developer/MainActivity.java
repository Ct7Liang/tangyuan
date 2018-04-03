package com.ct7liang.developer;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

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
        //用于实现沉浸式状态栏
    }

    @Override
    public void findView() {
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
    }

    @Override
    public void onClick(View v) {
        //点击事件处理
    }

    @Override
    public void exitApp() {
        super.exitApp();
        //退出应用提示 销毁所有的Activity
    }

    @Override
    public void showProgressDialog() {
        //显示加载框
        super.showProgressDialog();
    }

    @Override
    public void cancelProgress() {
        //关闭加载框
        super.cancelProgress();
    }

}