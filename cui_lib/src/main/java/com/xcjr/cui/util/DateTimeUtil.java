package com.xcjr.cui.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * author: Created by 闹闹 on 2018-03-17
 * version: 1.0.0
 */
public class DateTimeUtil {

    /**
     * 解析日期对象返回日期字符串
     */
    public static String formatBirthday(Long date) {
        return parseString("yyyy-MM-dd", date);
    }

    public static String parseString(String pattern, long milliseconds) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTimeInMillis(milliseconds);
        return sf.format(c.getTime());
    }

    /**
     * 解析字符串返回日期
     */
    public static Date parseBirthday(String string) {
        if (TextUtils.isEmpty(string))
            return null;
        return parseDate("yyyy-MM-dd", string);
    }

    // Date 语法格式日期时间
    public static Date parseDate(String pattern, String date) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        try {
            return sf.parse(date);
        } catch (ParseException e) {

        }
        return null;
    }
}

