package com.ternakkita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ternakkita.R;
import com.ternakkita.presenter.presenterLogin;
import com.ternakkita.presenter.presenterRegister;
import com.ternakkita.view.interfaceLogin;

public class cls_login extends AppCompatActivity implements interfaceLogin {

    presenterLogin presenter;

    EditText etUsername,etPassword;
    Button login;
    ProgressDialog loading;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        mContext =this;
        presenter = new presenterLogin(this);

        etUsername = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPass);
        login      = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  u = etUsername.getText().toString();
                String  p = etPassword.getText().toString();
                presenter.actionLogin(u,p);
            }
        });
    }

    @Override
    public void showProgress() {
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
    }

    @Override
    public void hideProgress() {
        loading.dismiss();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }
}
