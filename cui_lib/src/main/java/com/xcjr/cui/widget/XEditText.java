package com.xcjr.cui.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.xcjr.cui.util.FontsLoaderUtil;
import com.xcjr.cui.util.LayoutAttributeUtil;


/**
 * XEditText
 * <p>
 * author: Created by 闹闹 on 2017/4/28
 * version: 1.0.0
 */
public class XEditText extends android.support.v7.widget.AppCompatEditText {
    public XEditText(Context context) {
        super(context, null);
        setupFont(context, null);
    }

    public XEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupFont(context, attrs);
    }

    public XEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupFont(context, attrs);
    }

    void setupFont(Context context, AttributeSet attrs) {
        if (attrs != null) {
            LayoutAttributeUtil ua = new LayoutAttributeUtil(context, attrs);
            setTypeface(ua.getIntegerAttribute(
                    ua.getNSXCSQJR(), "bold", -1) == -1
                    ? FontsLoaderUtil.getTypeface(getContext())
                    : FontsLoaderUtil.getTypefaceMedium(getContext()));
        } else {
            setTypeface(FontsLoaderUtil.getTypeface(getContext()));
        }
        setIncludeFontPadding(false);
    }
}
