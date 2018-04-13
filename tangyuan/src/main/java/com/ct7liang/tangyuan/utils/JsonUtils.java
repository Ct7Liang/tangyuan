package com.ct7liang.tangyuan.utils;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/28.
 * Json解析工具类
 */
public class JsonUtils {

    @Nullable
    public static String getJsonData(String json, String keyName){
        try {
            return new JSONObject(json).getString(keyName);
        } catch (JSONException e) {
            LogUtils.write("json数据解析异常: " + e.toString());
            return null;
        }
    }

    @Nullable
    public static <T>T getJsonData(String json, String keyName, T t){
        try {
            String string = new JSONObject(json).getString(keyName);
            t = (T) new Gson().fromJson(string, t.getClass());
            return t;
        } catch (JSONException e) {
            LogUtils.write("json数据解析异常: " + e.toString());
            return null;
        }
    }
}