package com.example.android_instagramclone_java.adapter;

import android.util.MutableLong;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> managers = new  ArrayList<Fragment>();
    public ViewPagerAdapter(@NonNull FragmentManager manager) {
        super(manager);
    }

    public ViewPagerAdapter(@NonNull FragmentManager manager, int behavior) {
        super(manager, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return managers.get(position);
    }

    @Override
    public int getCount() {
        return managers.size();
    }

    public void addFragment(Fragment fragment) {
        managers.add(fragment);
    }
}
