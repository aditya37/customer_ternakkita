package com.ternakkita.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.ternakkita.R;

public class cls_splashscreen extends AppCompatActivity {

    private int interval = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.a_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(cls_splashscreen.this, cls_login.class);
                startActivity(login);
                finish();

            }
        },interval);
    }
}
