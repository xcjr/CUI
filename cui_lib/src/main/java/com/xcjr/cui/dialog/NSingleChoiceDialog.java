package com.xcjr.cui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.xcjr.cui.R;
import com.xcjr.cui.adapter.NArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;


/**
 * 列表单选对话框
 * author: Created by 闹闹 on 2018/6/26
 * version: 1.0.0
 */
public class NSingleChoiceDialog extends DialogFragment implements View.OnClickListener {

    public interface DialogCallback extends NDialogBaseActionCallback {

        /**
         * 列表选定回调
         *
         * @param selectedData 选定的列表项数据
         * @param position     选定的列表位置
         */
        void listItemClick(String selectedData, int position);
    }

    private static NSingleChoiceDialog dialog;

    private static DialogCallback callback;

    private static String mTitleStr;
    private static ArrayList<String> mlistData;

    private Button cancelBtn;
    private ListView listView;

    private TextView titleTv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mu_single_choice_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleTv = view.findViewById(R.id.titleTv);
        cancelBtn = view.findViewById(R.id.cancelBtn);
        listView = view.findViewById(R.id.listView);
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);

        cancelBtn.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view,
                                    int position, long arg3) {
                callback.listItemClick(mlistData.get(position), position);
                dialog.dismiss();
            }
        });

        if (!TextUtils.isEmpty(mTitleStr)) {
            titleTv.setText(mTitleStr);
        }

        MyAdapter adapter = new MyAdapter(getActivity(), mlistData);
        listView.setAdapter(adapter);
    }

    /**
     * 创建并显示对话框
     *
     * @param act           上下文
     * @param titleStr      标题
     * @param listDataResId 数据源
     * @param mCallback     返回值
     */
    public static NSingleChoiceDialog show(FragmentActivity act, String titleStr, int listDataResId, DialogCallback mCallback) {
        mTitleStr = titleStr;
        if (listDataResId != 0) {
            mlistData = new ArrayList<String>();
            String[] strs = act.getResources().getStringArray(listDataResId);
            Collections.addAll(mlistData, strs);
        }

        FragmentTransaction ft = act.getSupportFragmentManager().beginTransaction();
        Fragment prev = act.getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create the dialog.
        dialog = new NSingleChoiceDialog();
        dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog_Them);

        dialog.show(ft, "dialog");

        callback = mCallback;

        return dialog;
    }

    public class MyAdapter extends NArrayAdapter {

        /**
         * 构造函数
         *
         * @param context 上下文
         * @param data    数据
         */
        MyAdapter(Context context, ArrayList<String> data) {
            super(context, data);
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * com.linan.logistics.widget.mudialog.adapter.AbstractMuDialogAdapter
         * #getListItemView(int, android.view.View, android.view.ViewGroup)
         */
        @Override
        public View getListItemView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.mu_single_choice_dialog_listitem, null, false);
                viewHolder = new ViewHolder();

                // 初始化空间
                viewHolder.itemDataTv = convertView.findViewById(R.id.itemDataTv);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // 设置数据
            if (mData != null && !mData.isEmpty()) {
                viewHolder.itemDataTv.setText(mData.get(position).toString());
            }
            return convertView;
        }

        class ViewHolder {
            TextView itemDataTv;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == cancelBtn) {
            callback.cancel(v);
            dialog.dismiss();
        }
    }
}

