package com.ct7liang.tangyuan.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/28.
 *
 */

public class JsonUtils {
    public static String getCode(String json) throws JSONException {
        return new JSONObject(json).getString("code");
    }
    public static String getMsg(String json) throws JSONException {
        return new JSONObject(json).getString("msg");
    }
    public static String getData(String json) throws JSONException {
        return new JSONObject(json).getString("data");
    }
}