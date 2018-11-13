package com.xcjr.cui.app;

import android.os.Environment;


/**
 * 平台app共用一些常量
 * <p>
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class IConstant {

    /************** 时间*****************************/
    public static final String DEFAULT_TIME_STRING = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String TIME_STRING_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_STRING_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String TIME_STRING_DAY = "yyyy-MM-dd";

    /**
     * 公司所有app应用文件夹根目录。
     */
    public final static String SAVE_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public final static String FILE_SAVEPATH = SAVE_FILE_PATH.concat("com.shuzhan");


    public final static String SAVE_CAMERA_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/DCIM" + "/Camera/";


    //存储日志
    public static final String SAVE_LOG_PATH = SAVE_FILE_PATH.concat("/log");


    /************** 网络访问相关***************/
    public final static String NET_IS_SUCCESS = "isSuccess";
    public final static String NET_CODE = "code";
    public final static String NET_DESCRIPTION = "description";
    public final static String NET_DATA = "data";

    /**
     * 网络请求接口key
     */
    public static final class Net {
        public final static String STATUS = "isSuccess";
        public final static String MESSAGE = "description";
        public final static String DATA = "data";
        public final static String TIME = "time";
        public final static String TOKEN = "token";
        public final static String SIGN = "sign";

        //查询列表相关。
        public final static String NET_PAGE_NO = "pageNo";  //页码
        public final static String NET_PAGE_SIZE = "pageSize";  //每页总条数
        public final static String NET_PAGE_COUNT = "pageCount";    //满足查询条件的总页数
        public final static String NET_TOTAL = "total"; //满足查询条件的总条数
        public final static String NET_DATA_LIST = "dataList";  //列表key


        public final static String NET_ERROR_HINT = "服务异常，稍后再试！";
    }

    public static class PERMISSIONS {
        public static final int ALL = 0;
        public static final int CAMERA = 1;
    }
}
