package com.example.gojie.drawerlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leyi on 2017/8/3.
 */

public class CommonFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private String contents;

    public static CommonFragment newInstance(String string) {

        Bundle args = new Bundle();
        args.putString(ARGS_PAGE,string);
        CommonFragment fragment = new CommonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contents = getArguments().getString(ARGS_PAGE);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText(contents+"FRAGMENEt");
        return tv;

    }
}
