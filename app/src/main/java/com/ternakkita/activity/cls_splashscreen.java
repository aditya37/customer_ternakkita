package com.ternakkita.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.ternakkita.R;
import com.ternakkita.sharedPreferences.spLogin;

public class cls_splashscreen extends AppCompatActivity {

    spLogin spLogin;

    private int interval = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.a_splashscreen);

        spLogin = new spLogin(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(cls_splashscreen.this, cls_login.class);
                startActivity(login);
                spLogin.checkLogin();
                finish();

            }
        },interval);
    }
}
