package com.example.android_instagramclone_java.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.adapter.ViewPagerAdapter;
import com.example.android_instagramclone_java.fragments.FavoriteFragment;
import com.example.android_instagramclone_java.fragments.HomeFragment;
import com.example.android_instagramclone_java.fragments.ProfileFragment;
import com.example.android_instagramclone_java.fragments.SearchFragment;
import com.example.android_instagramclone_java.fragments.UploadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * It contains view pager with 5 fragments in MainActivity,
 * and pages can be controlled by BottomNavigationView
 * **/

public class MainActivity extends BaseActivity {
    private String TAG = MainActivity.class.toString();
    int index = 0;
    HomeFragment homeFragment = new HomeFragment();
    UploadFragment uploadFragment = new UploadFragment();
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home : {
                        viewPager.setCurrentItem(0);break;
                    }
                    case  R.id.navigation_search : {
                        viewPager.setCurrentItem(1);break;
                    }
                    case  R.id.navigation_upload : {
                        viewPager.setCurrentItem(2);break;
                    }
                    case  R.id.navigation_favorite : {
                        viewPager.setCurrentItem(3);break;
                    }
                    case  R.id.navigation_profile : {
                        viewPager.setCurrentItem(4);break;
                    }
                }
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
                bottomNavigationView.getMenu().getItem(index).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Home and Upload Fragments are global for communication purpose

        homeFragment = new  HomeFragment();
        uploadFragment = new UploadFragment();
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment);
        adapter.addFragment(new SearchFragment());
        adapter.addFragment(uploadFragment);
        adapter.addFragment(new FavoriteFragment());
        adapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(adapter);
    }
}