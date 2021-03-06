package com.xcjr.cui.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

import java.util.ArrayList;

/**
 * 电话相关操作类
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class TelephoneUtil {
    /**
     * 直接拨打电话
     */
    public static void callPhone(Context context, String phoneNum) {
        Intent intent = null;
        if (phoneNum != null && phoneNum.trim().length() > 0) {
            intent = new Intent(Intent.ACTION_CALL);
            Uri uri = Uri.parse("tel:" + phoneNum);
            intent.setData(uri);
        }
        context.startActivity(intent);
    }

    /**
     * 跳转到拨号界面
     */
    public static void CallSysDial(Context context, String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + phoneNum);
        intent.setData(uri);
        context.startActivity(intent);
    }

    /**
     * 跳转到系统的短信编辑界面
     */
    public static void sendMessage(Context context, String phoneNum, String content) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("smsto:" + phoneNum);
        intent.setData(uri);
        intent.putExtra("sms_body", content);
        context.startActivity(intent);
    }

    /**
     * 直接发送短信，无界面
     */
    public static void sendHideMessage(Context context, String phoneNum, String content) {
        if (phoneNum != null && phoneNum.trim().length() > 0) {
            SmsManager manager = SmsManager.getDefault();
            // 消息内容大于70就对消息进行拆分
            if (content.length() > 70) {
                ArrayList<String> arrayList = manager.divideMessage(content);
                for (String message : arrayList) {
                    manager.sendTextMessage(phoneNum, null, message, null, null);
                }
            } else {
                manager.sendTextMessage(phoneNum, null, content, null, null);
            }
        }
    }
}
