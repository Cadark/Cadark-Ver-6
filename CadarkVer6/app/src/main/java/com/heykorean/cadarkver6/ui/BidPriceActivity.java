package com.heykorean.cadarkver6.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.heykorean.cadarkver6.R;


/**
 * Created by Hey.Hung on 3/4/2016.
 */
public class BidPriceActivity extends Activity {

    FrameLayout backBtnNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_car);

        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
