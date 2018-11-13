package com.xcjr.cui.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.xcjr.cui.util.FontsLoaderUtil;


/**
 * 自定义字体
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class XTextView extends android.support.v7.widget.AppCompatTextView {

    public XTextView(Context context) {
        super(context);
        setupFont();
    }

    public XTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupFont();
    }

    public XTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupFont();
    }

    void setupFont() {
        setTypeface(FontsLoaderUtil.getTypeface(getContext()));
        setIncludeFontPadding(false);
    }
}
