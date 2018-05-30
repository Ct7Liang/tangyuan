### ***tangyuan***

***project build.gradle***
```
allprojects {
    repositories {
    	...
    	maven { url 'https://jitpack.io' }
    }
}
```
***app* *build.gradle***
```
dependencies {
    compile 'com.github.Ct7Liang:tangyuan:1.1.5'
}
```


```
Log日志工具
LogUtils.setTag("TAG"); //设置日志标签
LogUtils.setLogEnable(boolean true); //后台日志 默认为true
LogUtils.write(String msg); //用法
LogUtils.setShowLocationEnable(boolean false); //打印日志的时候是否打印位置信息 默认为false

ToastUtils工具
ToastUtils.showStatic(Context context, String msg) //常用Toast
ToastUtils.setIsShowTestEnable(boolean show) //设置是否打印测试Toast, 默认为false,不打印
ToastUtils.showTest(Context context, String msg) //测试Toast

屏幕相关类
ScreenUtil.getUtils().getStatusHeight(Context context) //获取状态栏高度
ScreenUtil.getUtils().getScreenWidth(Context context) //获取屏幕宽度
ScreenUtil.getUtils().getScreenHeight(Context context) //获取屏幕高度

尺寸转换工具类
DPSTransform.dp2Px(ApplicationContext context, float dp)
DPSTransform.px2Dp(ApplicationContext context, float px)
DPSTransform.sp2Px(ApplicationContext context, float sp)
DPSTransform.px2Sp(ApplicationContext context, float px)

FileUtils
FileUtils.write(String filePath, String content, boolean append); //数据写入本地
String read = FileUtils.read(File file); //读取本地数据

Base64Utils
Base64Utils.base64ToString()
Base64Utils.base64ToFile()
Base64Utils.base64ToBitmap()
Base64Utils.stringToBase64()
Base64Utils.fileToBase64()
Base64Utils.bitmapToBase64()

FormatCheckUtils
目前仅支持判断:
isPhoneNumber(String phoneNumber) //是否是手机号码
isEmail(String email) //是否是邮箱地址

JsonUtils
getJsonData(String json, String keyName) //根据对应字段,返回值
getJsonData(String json, String keyName, T t) //根据对应字段以及所提供的实体类对象,返回转换后的对象


```
