package com.xcjr.cui.browser.image;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xcjr.cui.R;
import com.xcjr.cui.widget.XViewPager;

import uk.co.senab.photoview.PhotoView;


/**
 * 图片浏览器
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class ImgBrowseFragment extends Fragment implements View.OnClickListener {

    private static String[] mImgUrl;
    private static int[] mImgResId;
    private static String[] mImgFilePath;
    private static int currentPosition;

    private XViewPager viewPager;
    private ImageButton imgBtn_back;
    private TextView tv_title;

    /**
     * 使用注意：三个图片只能其中一个不null
     *
     * @param imgUrl      网络图片路径
     * @param imgResId    本地图片资源id
     * @param imgFilePath 文件对象，可以是本地的也可以是网络下载来的。
     */
    public static ImgBrowseFragment newInstance(String[] imgUrl, int[] imgResId, String[] imgFilePath, int showCurrentPosition) {
        mImgUrl = imgUrl;
        mImgResId = imgResId;
        mImgFilePath = imgFilePath;
        currentPosition = showCurrentPosition;
        return new ImgBrowseFragment();
    }

    @Override
    public void onClick(View v) {
        if (v == imgBtn_back) {
            getActivity().finish();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_img_browser, container, false);
        return rootView;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        imgBtn_back = view.findViewById(R.id.imgBtn_back);
        tv_title = view.findViewById(R.id.tv_title);

        imgBtn_back.setOnClickListener(this);

        tv_title.setText("图片(" + 1 + "/" + getImgCount() + ")");

        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                tv_title.setText("图片(" + (position + 1) + "/" + getImgCount() + ")");
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImgShowPagerAdapter adapter = new ImgShowPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPosition);
        adapter.notifyDataSetChanged();
    }

    /**
     * 显示图片的个数
     */
    private int getImgCount() {
        int size = 0;
        if (mImgUrl != null) {
            size = mImgUrl.length;
        } else if (mImgResId != null) {
            size = mImgResId.length;
        } else {
            size = mImgFilePath.length;
        }
        return size;
    }

    class ImgShowPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mImgUrl != null) {
                return mImgUrl.length;
            } else if (mImgResId != null) {
                return mImgResId.length;
            } else {
                return mImgFilePath.length;
            }
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.photo_view, null);
            PhotoView photoView = view.findViewById(R.id.photoView);

            if (mImgUrl != null) {
                Picasso.with(getActivity()).load(mImgUrl[position])
//                        .placeholder(R.anim.progress_hud_spinner)
                        .error(R.drawable.ic_img_error)
                        .into(photoView);
            } else if (mImgResId != null) {
                Picasso.with(getActivity()).load(mImgResId[position])
                        .error(R.drawable.ic_img_error)
                        .into(photoView);
            } else {
                Picasso.with(getActivity()).load(mImgFilePath[position])
//                        .placeholder(R.anim.progress_hud_spinner)
                        .error(R.drawable.ic_img_error)
                        .into(photoView);
            }

            // 添加 PhotoView到 ViewPager并返回它
            container.addView(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
