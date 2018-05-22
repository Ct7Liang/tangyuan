package com.ct7liang.tangyuan;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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

        setContentView(setLayout());

        findView();
        initData();
        initView();
        initFinish();

        // Activity初始化完成,注册广播, 以便于在广播中对Activity进行销毁, 注意要在onDestroy()中解除注册
        exitReceiver = new AppExitReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constant.RECEIVER_FILTER);
        registerReceiver(exitReceiver, filter);
    }

    /**
     * 该方法设置了状态栏为透明状态栏, 使用时在findView()方法中调用即可
     * 根据实际使用情景,需要重写setStatusBar()方法去设置状态栏
     */
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

    /**
     * 在onCreate()方法中首先被调用 获得onCreate方法中的Bundle参数
     * @param savedInstanceState onCreate方法中的Bundle参数
     */
    public void getOnCreateParams(Bundle savedInstanceState) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exitReceiver);
    }

    /**
     * 设置布局
     */
    public abstract int setLayout();

    /**
     * 再调用了initStatusBar方法后,根据实际使用情景,在该方法中对状态栏及其他控件做相应的调整,已达到沉浸式状态栏的效果
     */
    protected void setStatusBar(){}

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

    /**
     * 设置当前窗体为全屏显示
     */
    public void setFullScreen(){
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
    }

    /**
     * 设置屏幕方向
     * @param isVertical true为竖直方向 false为横向方向
     */
    public void setOrientation(boolean isVertical) {
        if (isVertical){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

//    private ProgressDialog pd;
//    public void showProgressDialog(){
//        pd = new ProgressDialog(this);
//        pd.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        pd = ProgressDialog.show(this, "", getProgressContent(), true, false);
//    }
//    public void cancelProgress(){
//        if (pd!=null){
//            pd.dismiss();
//        }
//    }
//    private String getProgressContent(){
//        return progressContent[(int) (Math.random()*progressContent.length)];
//    }
//    private String[] progressContent = { "正在玩儿命连接网络...", "疯狂请求数据中...", "请稍后"};

}