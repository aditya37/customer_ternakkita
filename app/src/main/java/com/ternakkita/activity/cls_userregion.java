package com.ternakkita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ternakkita.R;
import com.ternakkita.presenter.presenterLogin;
import com.ternakkita.presenter.presenterRegister;
import com.ternakkita.presenter.presenterRegregion;
import com.ternakkita.sharedPreferences.spRegister;
import com.ternakkita.view.interfaceRegregion;

public class cls_userregion extends AppCompatActivity implements interfaceRegregion {


    presenterRegregion presenter;
    spRegister spRegister;

    Context mContext;

    ProgressDialog loading;
    EditText etUser;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_userregion);

        mContext =this;
        presenter  = new presenterRegregion(this);
        spRegister = new spRegister(this);

        etUser = (EditText) findViewById(R.id.etAdmin1);
        etUser.setText(spRegister.getIdCustomer());

        btnSimpan = (Button) findViewById(R.id.btnRegion);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = spRegister.getIdCustomer();
                presenter.regRegion("Jawa Timur",
                        "Bojonegoro",
                        "Dander",
                        "Mojoranu",
                        "Jln KH Subakir",
                        "621717",
                         id);
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
    public void onAddSuccess(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();

        Intent pergi = new Intent(cls_userregion.this,cls_login.class);
        startActivity(pergi);
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }
}
