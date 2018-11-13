package com.xcjr.cui.util;



/**
 * Base64加密/解密
 * author: Created by 闹闹 on 2018-08-14
 * version: 1.0.0
 */
public class Base64Utils {
    // 加密
    public static String getBase64(String str) {
        String result = "";
        if (str != null) {
            result = Base64.getEncoder().encodeToString(str.getBytes());
        }
        return result;
    }
}
