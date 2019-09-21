package com.ternakkita.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ternakkita.R;
import com.ternakkita.presenter.presenterRegister;
import com.ternakkita.sharedPreferences.spRegister;
import com.ternakkita.view.interfaceRegister;

import static com.ternakkita.sharedPreferences.spRegister.ID_CUSTOMER;

public class cls_register extends AppCompatActivity implements interfaceRegister {

    presenterRegister presenter;
    spRegister spRegister;

    Button btnRegister;
    EditText etUsername,etPassword;
    //progress dialog
    ProgressDialog loading;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_register);


        mContext = this;

        presenter  = new presenterRegister(this);
        spRegister = new spRegister(this);

        btnRegister = (Button) findViewById(R.id.btnLogin);
        etUsername = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPass);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = etUsername.getText().toString();
                String p = etPassword.getText().toString();
                presenter.register(u,p);
            }
        });
    }

    @Override
    public void showProgress() {
        loading = ProgressDialog.show(mContext, null, "Please Wait...", true, false);
    }

    @Override
    public void hideProgress() {
        loading.dismiss();
    }

    @Override
    public void onAddSuccess(String idUser) {
        // save ke dalam sharedPreferences
        spRegister.saveStringSP(ID_CUSTOMER,idUser);
        // Menampilkan Toast
        Toast.makeText(mContext,"Akun Berhasil Di Buat",Toast.LENGTH_LONG).show();
        // Ke halaman selanjutnya
        Intent regUdata = new Intent(cls_register.this,cls_userdata.class);
        startActivity(regUdata);

    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

}
