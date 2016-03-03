package com.heykorean.cadarkver6.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.heykorean.cadarkver6.R;

/**
 * Created by Hey.Hung on 2/25/2016.
 */
public class ManagerCarsFragment extends Fragment implements View.OnClickListener {
    private LinearLayout llEditProfile;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manager_cars, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        llEditProfile = (LinearLayout) v.findViewById(R.id.ll_edit_profile);
        llEditProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_edit_profile:
                break;
        }
    }
}
