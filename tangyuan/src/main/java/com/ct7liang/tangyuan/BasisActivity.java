package com.ct7liang.tangyuan;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ct7liang.tangyuan.receiver.AppExitReceiver;
import com.ct7liang.tangyuan.utils.ToastUtils;

/**
 * Created by Administrator on 2017/6/28.
 *  setLayout(); 设置布局
 *  setStatusBar(); 设置状态栏
 *  findView(); 查找控件
 *  initData(); 初始化数据
 *  initView(); 初始化View
 *  initFinish(); 初始化完成
 */
public abstract class BasisActivity extends FragmentActivity implements View.OnClickListener {

    public Activity mAct;
    public AppExitReceiver exitReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去掉系统自带的ActionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getOnCreateParams(savedInstanceState);

        mAct = this;
        exitReceiver = new AppExitReceiver();
        setContentView(setLayout());

//        initStatusBar();
        findView();
        initData();
        initView();
        initFinish();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Constant.RECEIVER_FILTER);
        registerReceiver(exitReceiver, filter);
    }

    public void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setStatusBar();
//            toolbar.setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
//            findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
//            findViewById(R.id.title_back_ground).setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    public void getOnCreateParams(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exitReceiver);
    }

    /**
     * 设置布局
     */
    public abstract int setLayout();

    protected void setStatusBar(){

    }

    /**
     * 查找控件
     */
    public abstract void findView();

    /**
     * 数据初始化中
     */
    public abstract void initData();

    /**
     * 设置控件(各种监听事件)
     */
    public abstract void initView();

    /**
     * 数据初始化完成
     */
    public abstract void initFinish();

    public long currentTime;
    public long lastTime;
    /**
     * 提示用户, 直接退出应用, 清理所有页面
     */
    public void exitApp() {
        currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < 2000){
            lastTime = currentTime;
            Intent intent = new Intent();
            intent.setAction(Constant.RECEIVER_FILTER);
            sendBroadcast(intent);
        }else {
            ToastUtils.showStatic(mAct, "再按一次退出");
            lastTime = currentTime;
        }
    }

    private ProgressDialog pd;
    public void showProgressDialog(){
        pd = new ProgressDialog(this);
        pd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pd = ProgressDialog.show(this, "", getProgressContent(), true, false);
    }
    public void cancelProgress(){
        if (pd!=null){
            pd.dismiss();
        }
    }
    private String getProgressContent(){
        return progressContent[(int) (Math.random()*progressContent.length)];
    }
    private String[] progressContent = { "正在玩儿命连接网络...", "疯狂请求数据中...", "请稍后"};

}