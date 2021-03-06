package com.xcjr.cui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

/**
 * actionBar的滚动标题，超过长度可滚动显示
 *
 * @author marco
 *         Workaround to be able to scroll text inside a TextView without it required
 *         to be focused. For some strange reason there isn't an easy way to do this
 *         natively.
 *         <p>
 *         Original code written by Evan Cummings:
 *         http://androidbears.stellarpc.net/?p=185
 */
public class ScrollingTextView extends android.support.v7.widget.AppCompatTextView {

    public ScrollingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ScrollingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollingTextView(Context context) {
        super(context);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        if (focused) {
            super.onWindowFocusChanged(focused);
        }
    }

    /**
     * 覆盖该方法，实现跑马灯效果
     */
    @Override
    public boolean isFocused() {
        return true;
    }
}
