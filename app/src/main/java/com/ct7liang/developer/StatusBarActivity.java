package com.ct7liang.developer;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

public class StatusBarActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_status_bar;
    }

    @Override
    public void findView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
        }
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.right_text)).setText("更多");
        findViewById(R.id.right).setOnClickListener(this);
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
            case R.id.left_image:
                finish();
                break;
            case R.id.right:
                startActivity(new Intent(this, StatusBar01Activity.class));
                break;
        }
    }
}