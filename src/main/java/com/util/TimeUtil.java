package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * 进行时间和时间戳之间的转换
 */
public class TimeUtil {

    public static String TimeStamp2Date(String timestampString) {
        String formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        //Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    public static String TimeStamp2Year(String timestampString) {
        String formats = "yyyy-MM-dd";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        //Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    public static String Date2TimeStamp(String dateStr) {
        String format = "yyyy-MM-dd HH:mm:ss";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
            //return String.valueOf(sdf.parse(dateStr).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        //String nowTimeStamp = String.valueOf(time);
        return nowTimeStamp;
    }

    public static void main(String[] args){
        long year12 = Long.parseLong(TimeUtil.Date2TimeStamp("2014-12-12 15:10:10"));
        long year13 = Long.parseLong(TimeUtil.Date2TimeStamp("2015-12-12 15:10:10"));
        System.out.println(year13 - year12);
    }

}
