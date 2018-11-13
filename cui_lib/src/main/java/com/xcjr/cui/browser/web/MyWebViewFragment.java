package com.xcjr.cui.browser.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.xcjr.cui.R;
import com.xcjr.cui.helper.WebViewHelper;


/**
 * WebView的简单封装。公共使用
 * <p>
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class MyWebViewFragment extends Fragment {

    private String url;

    private WebView webView;
    private ImageView webBack;
    private ImageView goForward;
    private ImageView reload;

    /**
     * 实例化。
     *
     * @param url webView加载的网页地址
     */
    public static MyWebViewFragment newInstance(String url) {
        MyWebViewFragment fragment = new MyWebViewFragment();

        // 初始化参数包
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        url = getArguments().getString("url") == null ? "" : getArguments().getString("url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_browser, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.webView);
        webBack = view.findViewById(R.id.web_back);
        goForward = view.findViewById(R.id.web_goForward);
        reload = view.findViewById(R.id.web_reload);

        // progressbar = (ProgressBar)view.findViewById(R.id.progressbar);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new WebViewHelper(getActivity(), webView, url, goForward, webBack, reload);
    }
}
