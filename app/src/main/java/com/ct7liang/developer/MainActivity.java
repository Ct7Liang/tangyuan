package com.ct7liang.developer;

import android.os.Bundle;
import android.view.View;

import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.FileUtils;
import com.ct7liang.tangyuan.utils.ScreenUtil;
import com.ct7liang.tangyuan.utils.ToastUtils;

import java.io.File;

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
        setOrientation(true);
        //用于实现沉浸式状态栏
        findViewById(R.id.title_back_ground).setPadding(0, ScreenUtil.getUtils().getStatusHeight(this), 0, 0);
    }

    @Override
    public void findView() {
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

        FileUtils.write(AppFolder.get().getPath()+"/readme.txt", "每次写入都清除了上次的记录吗?", true);

        String read = FileUtils.read(new File(AppFolder.get(), "readme.txt"));
        ToastUtils.showStatic(this, read);
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

}