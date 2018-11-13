package com.xcjr.cui.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.xcjr.cui.app.IConstant;


/**
 * 权限工具类
 * <p>
 * author: Created by 闹闹 on 2018-03-25
 * version: 1.0.0
 */
public class PermissionUtil {

    Activity mActivity;

    public PermissionUtil(Activity activity) {
        this.mActivity = activity;
    }

    // 请求网络权限
    public static boolean requestInternet(Activity act) {
        if (ContextCompat.checkSelfPermission(act, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(act, Manifest.permission.INTERNET)) {
            // Show Rationale
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.INTERNET}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.INTERNET}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 请求摄像权限
    public static boolean requestCamera(Activity act) {
        if (ContextCompat.checkSelfPermission(act, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(act, Manifest.permission.CAMERA)) {
            // Show Rationale
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.CAMERA}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.CAMERA}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    public boolean requestCamera() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.CAMERA)) {
            // Show Rationale
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 存储权限
    public boolean requestStore() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // Show Rationale
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 存储权限
    public static boolean requestPhoneState(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)) {
            // Show Rationale
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 录音权限
    public boolean requestRecorder() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.RECORD_AUDIO)) {
            // Show Rationale
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.RECORD_AUDIO}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.RECORD_AUDIO}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 定位权限
    public boolean requestLocation() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            // Show Rationale
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // 读取联系人
    public static boolean requestContact(Activity act) {
        if (ContextCompat.checkSelfPermission(act, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(act, Manifest.permission.READ_CONTACTS)) {
            // Show Rationale
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.READ_CONTACTS}, IConstant.PERMISSIONS.ALL);
        } else {
            //
            ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.READ_CONTACTS}, IConstant.PERMISSIONS.ALL);
        }
        return false;
    }

    // Support V4 Fragment Activity Permission Result
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == IConstant.PERMISSIONS.ALL) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int grantResult = grantResults[i];
                // Permission Type
                if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        // Agree
                    } else {
                        // Reject
                    }
                }
            }
        }
    }
}

