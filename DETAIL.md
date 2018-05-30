##### 准备工作
```
创建App类 初始化 SpUtils, LogUtils, AppFolder
创建抽象BaseActivity类继承BasisActivity.class, 开发中的Activity继承BaseActivity后重写方法即可
如需使状态栏透明, 则需要在initView()方法中调用initStatusBar(), 然后重写setStatusBar()方法,适配透明状态栏
```

##### SpUtils - (SharedPreferences工具)
```
SpUtils.init(Context context);
SpUtils.init(Context context, String spName);
```

##### LogUtils - (Log工具)
```
LogUtils.setTag("TAG"); //设置日志标签
LogUtils.setLogEnable(boolean true); //后台日志 默认为true
LogUtils.write(String msg); //用法
LogUtils.setShowLocationEnable(boolean false); //打印日志的时候是否打印位置信息 默认为false
```

##### ToastUtils - (Toast工具)
```
ToastUtils.showStatic(Context context, String msg) //常用Toast
ToastUtils.showTest(Context context, String msg) //测试Toast
ToastUtils.setIsShowTestEnable(boolean show) //设置是否打印测试Toast, 默认为false,不打印
```

##### AppFolder - (App文件夹创建工具)
```
AppFolder.createAppFolder(String folderName) //创建文件夹
AppFolder.get() //获取App文件夹
```

##### CrashUtils - (崩溃日志记录工具)
```
//使用默认文件夹存储日志,此方法需要AppFolder首先创建文件夹
CrashUtils.init(Context applicationContext, boolean isShowToast, @NonNull String content)
//自定义文件夹存储崩溃日志
CrashUtils.init(Context applicationContext, @NonNull File folder,  boolean isShowToast, @NonNull String content)
```

##### ScreenUtil - (屏幕相关)
```
ScreenUtil.getUtils().getStatusHeight(Context context) //获取状态栏高度
ScreenUtil.getUtils().getScreenWidth(Context context) //获取屏幕宽度
ScreenUtil.getUtils().getScreenHeight(Context context) //获取屏幕高度
```

##### DPSTransform - (尺寸转换工具)
```
DPSTransform.dp2Px(ApplicationContext context, float dp)
DPSTransform.px2Dp(ApplicationContext context, float px)
DPSTransform.sp2Px(ApplicationContext context, float sp)
DPSTransform.px2Sp(ApplicationContext context, float px)
```

##### FileUtils - (文件写入写出工具)
```
FileUtils.write(String filePath, String content, boolean append); //数据写入本地
String read = FileUtils.read(File file); //读取本地数据
```

##### Base64Utils - (Base64转换工具)
```
Base64Utils.base64ToString()
Base64Utils.base64ToFile()
Base64Utils.base64ToBitmap()
Base64Utils.stringToBase64()
Base64Utils.fileToBase64()
Base64Utils.bitmapToBase64()
```

##### FormatCheckUtils - (格式验证工具)目前仅支持判断:
```
isPhoneNumber(String phoneNumber) //是否是手机号码
isEmail(String email) //是否是邮箱地址
```

##### JsonUtils - (Json数据解析工具)
```
getJsonData(String json, String keyName) //根据对应字段,返回值
getJsonData(String json, String keyName, T t) //根据对应字段以及所提供的实体类对象,返回转换后的对象
```

##### TitleBarView - (自定义标题栏)
```
.xml
<com.ct7liang.tangyuan.view_titlebar.TitleBarView
    android:id="@+id/title_bar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:left_img_src="@mipmap/ic_launcher_round"  //左侧图标
    app:left_img_padding="12dp"                   //左侧图标padding值
    app:title="自定义"                             //标题栏文字
    app:title_text_color="#DD4E40"                //标题栏文字颜色
    app:title_text_size="18sp"                    //标题栏文字大小
    app:title_gravity="center"                    //标题栏文字位置(居中/居左)
    app:right_text="列表"                          //右侧文字
    app:right_text_color="#DD4E40"                //右侧文字颜色
    app:right_text_size="14sp"                    //右侧文字大小
    app:title_bar_bg="@color/colorPrimary">       //右侧图标
</com.ct7liang.tangyuan.view_titlebar.TitleBarView>

.java
//设置左侧图标
setLeftImgResource(@DrawableRes int resource, int padding)
//设置左侧点击事件
setOnLeftImgClick(OnLeftImgClick leftImgClick)
//设置标题栏文字
setTitleText(@Nullable String title, @Nullable String color, float sp_size, boolean isCenter)
//设置右侧图标
setRightImgResource(@DrawableRes int resource, int padding)
//设置右侧点击事件
setOnRightImgClick(@NonNull OnRightImgClick rightImgClick)
//设置右侧文字
setRightText(@Nullable String text, @Nullable String color, float sp_size)
//设置标题蓝背景颜色
setTitleBarBgColor(int resid)
//状态栏透明后,设置标题栏适配
setStatusBar(Context context)
```

[返回](https://github.com/Ct7Liang/tangyuan)