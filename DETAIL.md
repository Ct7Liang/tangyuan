##### SpUtils(SharedPreferences工具)
```
SpUtils.init(Context context);
SpUtils.init(Context context, String spName);
```

LogUtils(Log工具)
LogUtils.setTag("TAG"); //设置日志标签
LogUtils.setLogEnable(boolean true); //后台日志 默认为true
LogUtils.write(String msg); //用法
LogUtils.setShowLocationEnable(boolean false); //打印日志的时候是否打印位置信息 默认为false


ToastUtils(Toast工具)
ToastUtils.showStatic(Context context, String msg) //常用Toast
ToastUtils.showTest(Context context, String msg) //测试Toast
ToastUtils.setIsShowTestEnable(boolean show) //设置是否打印测试Toast, 默认为false,不打印


ScreenUtil(屏幕相关)
ScreenUtil.getUtils().getStatusHeight(Context context) //获取状态栏高度
ScreenUtil.getUtils().getScreenWidth(Context context) //获取屏幕宽度
ScreenUtil.getUtils().getScreenHeight(Context context) //获取屏幕高度


###DPSTransform(尺寸转换工具)
DPSTransform.dp2Px(ApplicationContext context, float dp)
DPSTransform.px2Dp(ApplicationContext context, float px)
DPSTransform.sp2Px(ApplicationContext context, float sp)
DPSTransform.px2Sp(ApplicationContext context, float px)


FileUtils(文件写入写出工具)
FileUtils.write(String filePath, String content, boolean append); //数据写入本地
String read = FileUtils.read(File file); //读取本地数据


Base64Utils(Base64转换工具)
Base64Utils.base64ToString()
Base64Utils.base64ToFile()
Base64Utils.base64ToBitmap()
Base64Utils.stringToBase64()
Base64Utils.fileToBase64()
Base64Utils.bitmapToBase64()


FormatCheckUtils(格式验证工具)目前仅支持判断:
isPhoneNumber(String phoneNumber) //是否是手机号码
isEmail(String email) //是否是邮箱地址


JsonUtils(Json数据解析工具)
getJsonData(String json, String keyName) //根据对应字段,返回值
getJsonData(String json, String keyName, T t) //根据对应字段以及所提供的实体类对象,返回转换后的对象

```
[返回](https://github.com/Ct7Liang/tangyuan)