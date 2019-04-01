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
    compile 'com.github.Ct7Liang:tangyuan:2.0.1'
}
```
##### 建议修改
```
compileSdkVersion 27
compile 'com.android.support:appcompat-v7:27.1.1'
```


[details](https://github.com/Ct7Liang/tangyuan/blob/master/DETAIL.md)
