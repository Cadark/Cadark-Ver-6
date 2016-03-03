package com.heykorean.cadarkver6.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.heykorean.cadarkver6.R;
import com.heykorean.cadarkver6.adapter.RFAdapterNotificationList;
import com.heykorean.cadarkver6.api_retrofit.RFApi;
import com.heykorean.cadarkver6.api_retrofit.RFNotification;
import com.heykorean.cadarkver6.models.NotificaionList;

import java.util.ArrayList;

public class NotificationActivity extends Activity {

    private ListView listViewNotification;
    private RFAdapterNotificationList adapterNotificationt;
    private ArrayList<NotificaionList> arrayList;

    FrameLayout backBtnNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        arrayList = RFNotification.getNotificationList();
        listViewNotification = (ListView) findViewById(R.id.listNotification);
        adapterNotificationt = new RFAdapterNotificationList(this, R.layout.notification_item, arrayList);
        listViewNotification.setAdapter(adapterNotificationt);
    }

    private void initView() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
