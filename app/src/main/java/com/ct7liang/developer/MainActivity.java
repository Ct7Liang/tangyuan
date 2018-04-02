package com.ct7liang.developer;

import android.view.View;
import android.widget.TextView;
import com.ct7liang.tangyuan.utils.ToastUtils;

public class MainActivity extends BaseActivity {

    @Override
    public int setLayout() {
        //提供布局文件
        return R.layout.activity_main;
    }

    @Override
    public void findView() {
        //查找控件
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("首页");
        ((TextView)findViewById(R.id.right_text)).setText("更多");
//        ((TextView)findViewById(R.id.left_text)).setText("关于");
        findViewById(R.id.right).setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.left_image:
                exitApp();
                break;
            case R.id.right:
                ToastUtils.showStatic(mAct, "Hello World!");
                break;
        }
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