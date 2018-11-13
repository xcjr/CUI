package com.xcjr.cui.helper;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;


import com.xcjr.cui.widget.WaveView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Created by 闹闹 on 2018-06-22
 * version: 1.0.0
 */
public class WaveHelper {

    private WaveView mWaveView;

    private AnimatorSet mAnimatorSet;

    public WaveHelper(WaveView waveView) {
        mWaveView = waveView;
        initAnimation();
    }

    public void start() {
        mWaveView.setShowWave(true);
        if (mAnimatorSet != null) {
            mAnimatorSet.start();
        }
    }

    private void initAnimation() {
        List<Animator> animators = new ArrayList<>();

        // horizontal animation.
        // wave waves infinitely.
        // 波形一直向右移动，效果就是波形一直在波动。
        ObjectAnimator waveShiftAnim = ObjectAnimator.ofFloat(
                mWaveView, "waveShiftRatio", 0f, 1f);
        waveShiftAnim.setRepeatCount(ValueAnimator.INFINITE);
        waveShiftAnim.setDuration(1000);
        waveShiftAnim.setInterpolator(new LinearInterpolator());
        animators.add(waveShiftAnim);

        // vertical animation.
        // water level increases from 0 to center of WaveView
        // 让水位从0逐渐涨到WaveView高度的一半。
        ObjectAnimator waterLevelAnim = ObjectAnimator.ofFloat(
                mWaveView, "waterLevelRatio", 0f, 0.1f);
        waterLevelAnim.setDuration(10000);
        waterLevelAnim.setInterpolator(new DecelerateInterpolator());
        animators.add(waterLevelAnim);

        // amplitude animation.
        // wave grows big then grows small, repeatedly
        // 波浪的大小从大变小，再从小变大。
        ObjectAnimator amplitudeAnim = ObjectAnimator.ofFloat(
                mWaveView, "amplitudeRatio", 0.0001f, 0.05f);
        amplitudeAnim.setRepeatCount(ValueAnimator.INFINITE);
        amplitudeAnim.setRepeatMode(ValueAnimator.REVERSE);
        amplitudeAnim.setDuration(10000);
        amplitudeAnim.setInterpolator(new LinearInterpolator());
        animators.add(amplitudeAnim);

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(animators);
    }

    public void cancel() {
        if (mAnimatorSet != null) {
//            mAnimatorSet.cancel();
            mAnimatorSet.end();
        }
    }
}
