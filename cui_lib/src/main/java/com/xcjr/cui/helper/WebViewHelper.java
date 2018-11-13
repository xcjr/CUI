package com.xcjr.cui.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.xcjr.cui.R;

/**
 * 网页加载
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebViewHelper {

    private Context mContext;

    private WebView webView;
    private String url;

    private ImageView reload;
    private ImageView goForward;
    private ImageView web_back;

    /**
     * 构造函数
     */
    public WebViewHelper(Context mContext, WebView webView, String url, ImageView forward, ImageView back, ImageView reload) {
        this.mContext = mContext;
        this.webView = webView;
        this.url = url;

        this.reload = reload;
        goForward = forward;
        web_back = back;

        setWebView();
    }

    private void setWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);

        webView.setWebViewClient(new WebViewClient() { // 通过webView打开链接，不调用系统浏览器

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                loadUrl(view, url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                // 下载完，关闭进度条
                AnimHelper.stopViewAnim(reload);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });

        loadUrl(webView, url);

        web_back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

        goForward.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });

        reload.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                AnimHelper.startRotateAnim(mContext, R.anim.loading_browser_rotate_anim, reload);
                webView.reload();
            }
        });
    }

    private void loadUrl(WebView webView, String url) {
        if (null != url) {
            webView.loadUrl(url);
            // 出现进度条
            AnimHelper.startViewAnim(mContext, R.anim.loading_browser_rotate_anim, reload);
        }
    }
}
