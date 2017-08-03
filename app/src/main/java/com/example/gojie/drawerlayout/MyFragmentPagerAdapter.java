package com.example.gojie.drawerlayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by leyi on 2017/8/3.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{"消息","联系人","动态"};
    private Context context;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    public MyFragmentPagerAdapter(FragmentManager fm,Context context){
        super(fm);

        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return CommonFragment.newInstance(titles[position]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
