package com.ct7liang.tangyuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * yyyy-MM-dd HH:mm:ss
 */
public class TimeFormater {

    /**
     * 时间毫秒值转换为时间字符串
     * @param time 时间毫秒值
     * @param pattern 字符串格式
     * @return 时间字符串
     */
    public static String Ms2String(long time, String pattern){

        Date d = new Date(time);

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);

        return sdf.format(d);
    }

    /**
     * 时间字符串转换为时间毫秒值
     * @param time 时间字符串
     * @param pattern 字符串格式
     * @return 时间毫秒值
     */
    public static long String2Ms(String time, String pattern){

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);

        try {
            return sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 时间字符串转换为Date
     * @param time 时间字符串
     * @param pattern 字符串格式
     * @return Date
     */
    public static Date String2Date(String time, String pattern){

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);

        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
