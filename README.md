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
    compile 'com.github.Ct7Liang:tangyuan:1.1.8'
}
```
#####建议修改
```
compileSdkVersion 25
compile 'com.android.support:appcompat-v7:25.3.1'
```


[details](https://github.com/Ct7Liang/tangyuan/blob/master/DETAIL.md)
