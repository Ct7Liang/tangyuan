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

ToastUtils工具
ToastUtils.showStatic(Context context, String msg) 常用Toast
ToastUtils.setIsShowTestEnable(boolean show) 设置是否打印测试Toast, 默认为false,不打印
ToastUtils.showTest(Context context, String msg) 测试Toast

屏幕相关类
ScreenUtil.getUtils().getStatusHeight(Context context) 获取状态栏高度
ScreenUtil.getUtils().getScreenWidth(Context context) 获取屏幕宽度
ScreenUtil.getUtils().getScreenHeight(Context context) 获取屏幕高度

尺寸转换工具类
DPSTransform.dp2Px(ApplicationContext context, float dp)
DPSTransform.px2Dp(ApplicationContext context, float px)
DPSTransform.sp2Px(ApplicationContext context, float sp)
DPSTransform.px2Sp(ApplicationContext context, float px)
```
