package com.ct7liang.developer.test_activity;

import android.view.View;

import com.ct7liang.developer.BaseActivity;
import com.ct7liang.developer.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view.TitleBarView;

public class TitlebarTestActivity extends BaseActivity {

    private TitleBarView titleBarView;

    @Override
    public int setLayout() {
        return R.layout.activity_titlebar_test;
    }

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
        titleBarView = (TitleBarView) findViewById(R.id.title_bar);

//        titleBarView.setLeftImgResource(R.mipmap.ic_launcher_round, 12);
//        titleBarView.setOnLeftImgClick(new TitleBarView.OnLeftImgClick() {
//            @Override
//            public void onClick(View v) {
//                ToastUtils.showStatic(mAct, "点击了左边的图片");
//            }
//        });
//        titleBarView.setTitleText("这是一个标题栏", "#DD4E40", 16, true);
//        titleBarView.setTitleBarBgColor(R.color.colorAccent);
        titleBarView.setOnRightImgClick(new TitleBarView.OnRightImgClick() {
            @Override
            public void onClick(View v) {
                ToastUtils.showStatic(mAct, "点击了右边的图片");
            }
        });
//        titleBarView.setRightText("选项", "#FFAA00", 14);
        titleBarView.setStatusBar(this);
//        initStatusBar();
    }

    @Override
    public void findView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initStatusBar();
    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View v) {

    }
}
