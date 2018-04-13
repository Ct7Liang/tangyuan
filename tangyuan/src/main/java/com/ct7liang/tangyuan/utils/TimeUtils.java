package com.ct7liang.tangyuan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/7/27.
 *  毫秒时间转换工具
 *  
 *  SimpleDateFormat函数语法：
 *      G 年代标志符
 *      y 年
 *      M 月
 *      d 日
 *      h 时 在上午或下午 (1~12)
 *      H 时 在一天中 (0~23)
 *      m 分
 *      s 秒
 *      S 毫秒
 *      E 星期
 *      D 一年中的第几天
 *      F 一月中第几个星期几
 *      w 一年中第几个星期
 *      W 一月中第几个星期
 *      a 上午 / 下午 标记符
 *      k 时 在一天中 (1~24)
 *      K 时 在上午或下午 (0~11)
 *      z 时区
 */
public class TimeUtils {
    
    private static final String format_standard = "yyyy-MM-dd";
    private static final String format_today = "今天 H点m";
    private static final String format_yesterday = "昨天 H点m";
    private static final String format_before_yesterday = "前天 H点m";
    private static final String format_present_month = "d号 H点m";
    private static final String format_present_year = "M月d号 H点m";
    private static final String format_else = "yyyy年M月d号 H点m分";
    private static final String format_yMd = "yyyy年M月d号";
    private static final String format_EHm = "E H点m分";


    /**
     * SimpleDateFormat(format_today, Locale.CHINA)
     * 把电脑设置为英语环境下，就会有区别，locale对象根据用户的国家，地区文化差异格式化，
     * 不会改变系统时间，只是表达方式改变而已，这个方法不常用，因为不能覆盖所有语言环境.
     */
    

    /**
     * 将毫秒值转换为指定格式的时间字符串
     * @param millions 毫秒值
     * @return 指定格式的时间字符串
     */
    public String parseTime(long millions){
        switch (isToday(millions)){
            case 0:
                return new SimpleDateFormat(format_today, Locale.CHINA).format(new Date(millions));
            case 1:
                return new SimpleDateFormat(format_yesterday, Locale.CHINA).format(new Date(millions));
            case 2:
                return new SimpleDateFormat(format_before_yesterday, Locale.CHINA).format(new Date(millions));
            case 3:
                return new SimpleDateFormat(format_present_month, Locale.CHINA).format(new Date(millions));
            case 4:
                return new SimpleDateFormat(format_present_year, Locale.CHINA).format(new Date(millions));
            default:
                // case 5:
                return new SimpleDateFormat(format_else, Locale.CHINA).format(new Date(millions));
        }
    }

    /**
     * 将毫秒值转换为标准格式的时间字符串
     * @param millions 毫秒值
     * @return 标准格式的时间字符串  yyyy年M月d号 H时m分
     */
    public String parseTimeNormal(long millions){
        return new SimpleDateFormat(format_else, Locale.CHINA).format(new Date(millions));
    }

    /**
     *  将毫秒值转换为指定格式的时间字符串
     * @param millions 毫秒值
     * @return 指定格式的时间字符串 yyyy年M月d号
     */
    public String parseTime_yMd(long millions){
        return new SimpleDateFormat(format_yMd, Locale.CHINA).format(new Date(millions));
    }

    /**
     *  将毫秒值转换为指定格式的时间字符串
     * @param millions 毫秒值
     * @return 指定格式的时间字符串 周E H点m分
     */
    public String parseTime_EHm(long millions){
        return new SimpleDateFormat(format_EHm, Locale.CHINA).format(new Date(millions));
    }

    /**
     * 获取转换后的时间信息数组{yy,MM,dd}
     * @param millions 时间毫秒值
     * @return 分割后的字符串数组
     */
    private String[] getTime(long millions) {
        return new SimpleDateFormat(format_standard, Locale.CHINA).format(new Date(millions)).split("-");
    }

    /**
     * 是否是今天
     * @return
     * 0 表示今天
     * 1 表示昨天
     * 2 表示前天
     * 3 表示本月
     * 4 表示本年
     * 5 表示其他 今年以前
     */
    private int isToday(long millions){
        if (getTime(System.currentTimeMillis())[0].equals(getTime(millions)[0])) {
            //是本年 判断是否是 本月
            if (getTime(System.currentTimeMillis())[1].equals(getTime(millions)[1])) {
                //是本月 判断是否是 今天
                int i = Integer.valueOf(getTime(System.currentTimeMillis())[2]) - Integer.valueOf(getTime(millions)[2]);
                switch (i){
                    case 0:
                        // 今天
                        return 0;
                    case 1:
                        // 昨天
                        return 1;
                    case 2:
                        // 前天
                        return 2;
                    default:
                        return 3;
                }
            }else{
                //本年
                return 4;
            }

        }else{
            //不是本年
            return 5;
        }
    }
}