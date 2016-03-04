package com.heykorean.cadarkver6.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.heykorean.cadarkver6.R;

/**
 * Created by Hey.Hung on 2/25/2016.
 */
public class UserProfileBidActivity extends Activity implements View.OnClickListener {
    private FrameLayout flBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        initView();
    }

    private void initView() {
        flBack = (FrameLayout) findViewById(R.id.fl_back);
        flBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_back:
                finish();
                break;
        }
    }
}
