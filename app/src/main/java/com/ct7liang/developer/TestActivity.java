package com.ct7liang.developer;

import android.view.View;

import com.ct7liang.developer.utils.MyProgressDialog;
import com.ct7liang.tangyuan.utils.ToastUtils;

public class TestActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void findView() {
        initStatusBar();
        findViewById(R.id.btn).setOnClickListener(this);
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
//                LoadingBar.run(this, "稍等...", false, new LoadingBar.OnBackPressed() {
//                    @Override
//                    public void onPressed(LoadingBar loadingBar) {
//                        loadingBar.dismiss();
//                        ToastUtils.showStatic(mAct, "取消操作");
//                    }
//                });
//                LoadingBar.run(this, R.layout.progress_bar, ScreenInfoUtil.getScreenWH(this)[0]/3, false);
                create();
                break;
        }
    }

    public void create(){
        MyProgressDialog progressDialog = new MyProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setBackListener(new MyProgressDialog.OnBackPressed() {
            @Override
            public void onBackPressed() {
                ToastUtils.showStatic(mAct, "我是progressDialog的onBackPressed()方法");
            }
        });
        progressDialog.show();

//        ProgressDialog.show(this, null, "请稍后...");
    }

    @Override
    public void onBackPressed() {
        ToastUtils.showStatic(this, "Hello World!");
    }
}
