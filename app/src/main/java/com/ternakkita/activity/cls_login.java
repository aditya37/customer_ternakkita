package com.ternakkita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ternakkita.R;
import com.ternakkita.presenter.presenterLogin;
import com.ternakkita.presenter.presenterRegister;
import com.ternakkita.sharedPreferences.spLogin;
import com.ternakkita.view.interfaceLogin;

import static com.ternakkita.sharedPreferences.spRegister.ID_CUSTOMER;

public class cls_login extends AppCompatActivity implements interfaceLogin {

    presenterLogin presenter;
    spLogin spLogin;

    EditText etUsername,etPassword;
    TextView textView6;
    Button login;
    ProgressDialog loading;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        mContext =this;
        presenter = new presenterLogin(this);
        spLogin   = new spLogin(mContext);

        etUsername = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPass);
        login      = (Button) findViewById(R.id.btnLogin);
        textView6  = (TextView) findViewById(R.id.textView6);

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(mContext,cls_register.class);
                startActivity(register);
            }
        });

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

    @Override
    public void loginBerhasil(String pesan, String idCustomer) {
        spLogin.creteSession(ID_CUSTOMER,idCustomer);
        Intent landingPage = new Intent(cls_login.this,cls_landingPage.class);
        landingPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // menutup activity yang di belakang
        landingPage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(landingPage);
    }
}
