package com.heykorean.cadarkver6.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.heykorean.cadarkver6.R;
import com.heykorean.cadarkver6.ui.SplashActivity;

/**
 * Created by Hey!TheAnh on 1/22/2016.
 */
public class NoNetworkDialog extends Dialog implements View.OnClickListener {
    private Button btnQuit;
    private SplashActivity splashActivity;
    public NoNetworkDialog(Context context,SplashActivity splashActivity) {
        super(context);
        this.splashActivity = splashActivity;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_no_network);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        btnQuit = (Button) findViewById(R.id.btn_quit);
        btnQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        splashActivity.finish();
    }
}
