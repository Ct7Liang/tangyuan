package com.ct7liang.tangyuan.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/6/6.
 * SP文件存储工具
 */
public class SpUtils {

    private static SharedPreferences sp;

    public static void init(Context context){
        sp = context.getSharedPreferences("this_app_configs", Context.MODE_PRIVATE);
    }

    private static SpUtils mSpUtils;
    private SpUtils(){}
    public static SpUtils start(){
        if (mSpUtils == null){
            mSpUtils = new SpUtils();
        }
        return mSpUtils;
    }

    public void saveString(String key, String value){
        sp.edit().putString(key, value).apply();
    }
    public String getString(String key, String defaultValue){
        return sp.getString(key, defaultValue);
    }
    public String getString(String key){
        return sp.getString(key, null);
    }

    public void saveInt(String key, int value){
        sp.edit().putInt(key, value).apply();
    }
    public int getInt(String key, int defaultValue){
        return sp.getInt(key, defaultValue);
    }
    public int getInt(String key){
        return sp.getInt(key, 0);
    }

    public void saveBoolean(String key, boolean value){
        sp.edit().putBoolean(key, value).apply();
    }
    public boolean getBoolean(String key, boolean defaultValue){
        return sp.getBoolean(key, defaultValue);
    }
    public boolean getBoolean(String key){
        return sp.getBoolean(key, false);
    }

    public void saveFloat(String key, float value){
        sp.edit().putFloat(key, value).apply();
    }
    public float getFloat(String key, float defaultValue){
        return sp.getFloat(key, defaultValue);
    }
    public float getFloat(String key){
        return sp.getFloat(key, 0);
    }

    public void saveLong(String key, long value){
        sp.edit().putLong(key, value).apply();
    }
    public long getLong(String key, long defaultValue){
        return sp.getLong(key, defaultValue);
    }
    public long getLong(String key){
        return sp.getLong(key, 0);
    }

}