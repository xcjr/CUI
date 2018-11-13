package com.xcjr.cui.util;

import android.content.Context;
import android.graphics.Typeface;


/**
 * 字体加载处理工具
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class FontsLoaderUtil {

    private static boolean fontsLoaded = false;
    private static Typeface font;

    //
    private static boolean fontsLoadedMedium = false;
    private static Typeface fontMedium;

    private FontsLoaderUtil() {
    }

    public static Typeface getTypeface(Context context) {
        if (!fontsLoaded) {
            loadFonts(context);
        }
        return font;
    }

    public static Typeface getTypefaceMedium(Context context) {
        if (!fontsLoadedMedium) {
            loadFontsMedium(context);
        }
        return fontMedium;
    }

    private static void loadFonts(Context context) {
        font = Typeface.createFromAsset(context.getAssets(), "app_font.otf");
        fontsLoaded = true;
    }

    private static void loadFontsMedium(Context context) {
        fontMedium = Typeface.createFromAsset(context.getAssets(), "app_font.otf");
        fontsLoadedMedium = true;
    }
}
