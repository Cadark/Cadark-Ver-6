package com.heykorean.cadarkver6.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.heykorean.cadarkver6.R;


/**
 * Created by Hey.Hung on 3/4/2016.
 */
public class BidPriceActivity extends Activity implements View.OnClickListener {
    private LinearLayout llProfileBid;
    FrameLayout backBtnNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_car);
        llProfileBid = (LinearLayout) findViewById(R.id.ll_item_bid);
        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llProfileBid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item_bid:
                startActivity(new Intent(this,UserProfileBidActivity.class));
                break;
        }
    }
}
