package com.ct7liang.tangyuan.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ct7liang.tangyuan.R;
import com.ct7liang.tangyuan.utils.DpPxUtils;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

/**
 * Created by Administrator on 2018-05-22.
 *   自定义控件: 组合控件
 *   1.创建需要的布局界面
 *   2.创建封装类来实现该布局功能
 *   3.在需要的地方调用
 */

public class TitleBarView extends LinearLayout {

    private ImageView img_left;
    private TextView tv_center;
    private TextView tv_right;
    private ImageView img_right;
    private View backGround;

    public static String layout_center;
    public static String layout_start;

    public TitleBarView(Context context) {
        super(context);
    }

    public TitleBarView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBarView);
        int left_img_src = typedArray.getResourceId(R.styleable.TitleBarView_left_img_src, R.drawable.title_back);
        int left_img_padding = (int) typedArray.getDimension(R.styleable.TitleBarView_left_img_padding, DpPxUtils.sp2px(context, 12));
        String title = typedArray.getString(R.styleable.TitleBarView_title);
        float title_size = typedArray.getDimension(R.styleable.TitleBarView_title_text_size, DpPxUtils.sp2px(context, 17));
        int title_color = typedArray.getColor(R.styleable.TitleBarView_title_text_color, Color.WHITE);
        int gravity = typedArray.getInt(R.styleable.TitleBarView_title_gravity, 0);
        int right_img_src = typedArray.getResourceId(R.styleable.TitleBarView_right_img_src, 0);
        int right_img_padding = (int) typedArray.getDimension(R.styleable.TitleBarView_right_img_padding, DpPxUtils.sp2px(context, 12));
        String right_text = typedArray.getString(R.styleable.TitleBarView_right_text);
        float right_text_size = typedArray.getDimension(R.styleable.TitleBarView_right_text_size, DpPxUtils.sp2px(context, 15));
        int right_text_color = typedArray.getColor(R.styleable.TitleBarView_right_text_color, Color.WHITE);
        int bgcolor = typedArray.getColor(R.styleable.TitleBarView_title_bar_bg, Color.BLUE);

        //初始化布局
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);

        img_left = (ImageView) findViewById(R.id.left_image);
        img_left.setImageResource(left_img_src);
        img_left.setPadding(left_img_padding, left_img_padding, left_img_padding, left_img_padding);
        img_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLeftImgClick!=null){
                    onLeftImgClick.onClick(v);
                }else{
                    if (context instanceof Activity){
                        ((Activity) context).finish();
                    }
                }
            }
        });

        tv_center = (TextView) findViewById(R.id.center_text);
        tv_center.setText(title==null?"":title);
        tv_center.setTextColor(title_color);
        tv_center.setTextSize(TypedValue.COMPLEX_UNIT_PX, title_size);
        tv_center.setGravity(gravity==0?Gravity.CENTER:Gravity.START);  // TODO: 2018-05-22  flag

        tv_right = (TextView) findViewById(R.id.right_text);
        tv_right.setText(right_text==null?"":right_text);
        tv_right.setTextColor(right_text_color);
        tv_right.setTextSize(TypedValue.COMPLEX_UNIT_PX, right_text_size);

        img_right = (ImageView) findViewById(R.id.right_image);
        if (right_img_src!=0){
            img_right.setImageResource(right_img_src);
            img_right.setPadding(right_img_padding, right_img_padding, right_img_padding, right_img_padding);
        }
        findViewById(R.id.right).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightImgClick!=null){
                    onRightImgClick.onClick(v);
                }
            }
        });

        backGround = findViewById(R.id.title_back_ground);
        backGround.setBackgroundColor(bgcolor);
    }

    /**
     * 设置左侧返回图标样式
     * @param resource 资源文件
     * @param padding 内边距
     */
    public void setLeftImgResource(@DrawableRes int resource, int padding){
        if (img_left != null) {
            img_left.setImageResource(resource);
            img_left.setPadding(padding, padding, padding, padding);
        }
    }

    /**
     * 设置返回键监听
     * @param leftImgClick 监听者
     */
    public void setOnLeftImgClick(@NonNull OnLeftImgClick leftImgClick){
        this.onLeftImgClick = leftImgClick;
    }
    private OnLeftImgClick onLeftImgClick;
    public interface OnLeftImgClick{
        void onClick(View v);
    }

    /**
     * 设置标题文字
     * @param title 标题 为空则不显示文字
     * @param color 颜色 为空则默认为白色
     * @param sp_size 大小 为零则使用默认大小
     */
    public void setTitleText(@Nullable String title, @Nullable String color, float sp_size, boolean isCenter){
        if (tv_center==null){
            return;
        }
        if (title!=null){
            tv_center.setText(title);
        }
        if (color!=null){
            tv_center.setTextColor(Color.parseColor(color));
        }
        if (sp_size != 0){
            tv_center.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp_size);
        }
        tv_center.setGravity(isCenter?Gravity.CENTER:Gravity.START);
    }

    /**
     * 设置右侧图片
     * @param resource 图片资源
     * @param padding 图片内边距
     */
    public void setRightImgResource(@DrawableRes int resource, int padding){
        if (img_right==null){
            return;
        }
        img_left.setImageResource(resource);
        img_right.setPadding(padding, padding, padding, padding);
    }

    /**
     * 设置右侧图片监听
     * @param rightImgClick 监听者
     */
    public void setOnRightImgClick(@NonNull OnRightImgClick rightImgClick){
        this.onRightImgClick = rightImgClick;
    }
    private OnRightImgClick onRightImgClick;
    public interface OnRightImgClick{
        void onClick(View v);
    }


    /**
     * 设置右侧文字
     * @param text 标题 为空则不显示文字
     * @param color 颜色 为空则默认为白色
     * @param sp_size 大小 为零则使用默认大小
     */
    public void setRightText(@Nullable String text, @Nullable String color, float sp_size){
        if (tv_right==null){
            return;
        }
        if (text!=null){
            tv_right.setText(text);
        }
        if (color!=null){
            tv_right.setTextColor(Color.parseColor(color));
        }
        if (sp_size != 0){
            tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp_size);
        }
    }

    /**
     * 设置标题栏背景
     * @param resid
     */
    public void setTitleBarBgColor(int resid){
        if (backGround==null){
            return;
        }
        backGround.setBackgroundResource(resid);
    }

    /**
     * 设置标题栏状态栏适应
     * @param context
     */
    public void setStatusbar(Context context){
        backGround.setPadding(0, ScreenInfoUtil.getStatusHeight(context), 0 , 0);
    }
}