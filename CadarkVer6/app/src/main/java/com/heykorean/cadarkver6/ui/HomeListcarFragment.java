package com.heykorean.cadarkver6.ui;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.heykorean.cadarkver6.R;
import com.heykorean.cadarkver6.adapter.RFAdapterListCarHome;
import com.heykorean.cadarkver6.api_retrofit.RFApi;
import com.heykorean.cadarkver6.models.CarListHome;

import java.util.ArrayList;

/**
 * Created by Hey.Hung on 2/25/2016.
 */
public class HomeListcarFragment extends Fragment {
    private static final String TAG = "HomeListcarFragment";
    private ListView listViewCar;
    private RFAdapterListCarHome adapterContact;
    ArrayList<CarListHome> arrListCar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapterContact = new RFAdapterListCarHome(getActivity(), R.layout.item_list_car, arrListCar);
        listViewCar.setAdapter(adapterContact);
    }

    private void initView(View v) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Log.i(TAG, "vào đây");
        arrListCar = RFApi.getContact();
        listViewCar = (ListView) v.findViewById(R.id.listViewCar);
        listViewCar.setDescendantFocusability(ListView.FOCUS_BLOCK_DESCENDANTS);

        listViewCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "11111", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
