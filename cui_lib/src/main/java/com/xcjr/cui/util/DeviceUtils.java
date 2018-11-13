package com.xcjr.cui.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * 设备工具类
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class DeviceUtils {

    //设置竖屏
    public static void setScreenPortrait(Activity act) {
        if (!isOriatationPortrait(act)) {
            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    public static boolean isOriatationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static int checkNetworkConnection(Context context) {
        byte flg = 0;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            boolean wifiConnected = activeInfo.getType() == 1;
            boolean mobileConnected = activeInfo.getType() == 0;
            if (wifiConnected) {
                flg = 2;
            } else if (mobileConnected) {
                flg = 1;
            }
        }

        return flg;
    }

    public static void hideWindowActionBar(Activity act) {
        act.requestWindowFeature(1);
    }

    public static void hideWindowStatesBar(Activity act) {
        act.getWindow().setFlags(1024, 1024);
    }

    public static void setFullScreen(Activity act) {
        hideWindowActionBar(act);
        hideWindowStatesBar(act);
    }
}
