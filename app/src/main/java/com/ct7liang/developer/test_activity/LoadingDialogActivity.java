package com.ct7liang.developer.test_activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ct7liang.developer.BaseActivity;
import com.ct7liang.developer.R;
import com.ct7liang.tangyuan.utils.DPSTransform;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.utils.loading.LoadingDialog;
import com.ct7liang.tangyuan.utils.loading.ZddDialog;
import com.ct7liang.tangyuan.utils.loading.ZddProgressDialog;

public class LoadingDialogActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void findView() {
        initStatusBar();
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                LoadingDialog.show(this, false, "请稍后", new ZddProgressDialog.OnBackPressed() {
                    @Override
                    public void onBackPressed() {
                        ToastUtils.showStatic(mAct, "我是ProgressDialog的onBackPress方法");
                    }
                },null);
                break;
            case R.id.btn2:
                LoadingDialog.show(this, R.layout.progress_bar, false, new ZddProgressDialog.OnBackPressed() {
                    @Override
                    public void onBackPressed() {
                        ToastUtils.showStatic(mAct, "我是ProgressDialog的onBackPress方法");
                    }
                },null);
                break;
            case R.id.btn3:
                LoadingDialog.show(this, false, R.layout.progress_bar, false, DPSTransform.dp2Px(this, 100), DPSTransform.dp2Px(this, 100), new ZddDialog.OnBackPressed() {
                    @Override
                    public void onBackPressed() {
                        ToastUtils.showStatic(mAct, "我是ProgressDialog的onBackPress方法");
                    }
                },null);
                break;
            case R.id.btn4:
                LoadingDialog.show(this, true, R.layout.progress_bar, false, DPSTransform.dp2Px(this, 100), DPSTransform.dp2Px(this, 100), new ZddDialog.OnBackPressed() {
                    @Override
                    public void onBackPressed() {
                        ToastUtils.showStatic(mAct, "我是ProgressDialog的onBackPress方法");
                    }
                },null);
                handler.sendEmptyMessageDelayed(0, 3000);
                break;
            case R.id.close:
                LoadingDialog.dismiss();
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        LoadingDialog.dismiss();
        ToastUtils.showStatic(this, "Hello World!");
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LoadingDialog.dismiss();
        }
    };
}
