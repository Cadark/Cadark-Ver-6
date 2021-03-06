package com.heykorean.cadarkver6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.heykorean.cadarkver6.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private FrameLayout noticeArea, flMenu;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_upload,
            R.drawable.ic_car,
            R.drawable.ic_guide
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        flMenu = (FrameLayout) findViewById(R.id.fl_menu);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        noticeArea = (FrameLayout) findViewById(R.id.fl_notification);
        noticeArea.setOnClickListener(this);
        //   flMenu.setOnClickListener(this);
    }

    private void setupTabIcons() {
        //Tab Home
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        //Tab Upload
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        //Tab Selling
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        //Tab Guide
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.addFrag(new HomeListcarFragment(), "Home");
        adapter.addFrag(new PostCarFragment(), "Upload");
        adapter.addFrag(new SellingCarFragment(), "Selling");
        adapter.addFrag(new GuideFragment(), "Guide");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_notification:
                JumpToNoticeScreen();
//                Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_menu:
                Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.i(TAG,""+position);
            return mFragmentTitleList.get(position);
            // return null;
        }
    }

    public void JumpToNoticeScreen() {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
}