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
    compile 'com.github.Ct7Liang:tangyuan:1.1.4'
}
```
