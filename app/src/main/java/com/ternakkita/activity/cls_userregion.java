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
    EditText etAdmin1,etAdmin2,etAdmin3,etAdmin4,etAlamat,etPos;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_userregion);

        mContext   = this;
        presenter  = new presenterRegregion(this);
        spRegister = new spRegister(this);

        etAdmin1 = (EditText) findViewById(R.id.etAdmin1);
        etAdmin2 = (EditText) findViewById(R.id.etAdmin2);
        etAdmin3 = (EditText) findViewById(R.id.etAdmin3);
        etAdmin4 = (EditText) findViewById(R.id.etAdmin4);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        etPos    = (EditText) findViewById(R.id.etPos);

        btnSimpan = (Button) findViewById(R.id.btnRegion);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = spRegister.getIdCustomer();
                presenter.regRegion(etAdmin1.getText().toString(),
                        etAdmin2.getText().toString(),
                        etAdmin3.getText().toString(),
                        etAdmin4.getText().toString(),
                        etAlamat.getText().toString(),
                        etPos.getText().toString(),
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
