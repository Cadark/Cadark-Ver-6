package com.heykorean.cadarkver6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.heykorean.cadarkver6.R;
import com.heykorean.cadarkver6.ui.HomeListcarFragment;
import com.heykorean.cadarkver6.ui.PostCarFragment;
import com.heykorean.cadarkver6.ui.ManagerCarsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout noticeArea;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_upload,
            R.drawable.ic_car,
            R.drawable.ic_guide
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(123456);
        setupTabIcons();
        noticeArea = (FrameLayout) findViewById(R.id.fl_notification);
        noticeArea.setOnClickListener(this);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeListcarFragment(), "ONE");
        adapter.addFrag(new PostCarFragment(), "TWO");
        adapter.addFrag(new ManagerCarsFragment(), "THREE");
        adapter.addFrag(new ManagerCarsFragment(), "FOUR");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_notification:
                JumpToNoticeScreen();
                Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
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
            if(position==1){
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
            return mFragmentTitleList.get(position);
           // return null;
        }
    }

    public void JumpToNoticeScreen() {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
}