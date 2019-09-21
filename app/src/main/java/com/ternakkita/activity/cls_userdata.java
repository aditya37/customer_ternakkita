package com.ternakkita.activity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ternakkita.R;
import com.ternakkita.presenter.presenterLogin;
import com.ternakkita.presenter.presenterRegdata;
import com.ternakkita.sharedPreferences.spRegister;
import com.ternakkita.view.interfaceRegdata;

import java.io.File;
import java.io.IOException;

public class cls_userdata extends AppCompatActivity implements interfaceRegdata {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    // Variable yang menampung alamat file
    String imagePath;

    // Deklarasi classPresenter
    presenterRegdata presenter;
    spRegister spRegister;

    // Deklarasi widget
    ImageView imageView;
    EditText etfirstName,etlastName,etBirth,etPhone;
    Button btnNext;

    //spinner declaration
    Spinner spnGender;
    String[] gender ={"Male","Female"};

    //progress dialog
    ProgressDialog loading;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_userdata);

        // Verifikasi permission
        verifyStoragePermissions(cls_userdata.this);

        mContext = this;

        // initialisasi shared Preferences
        spRegister = new spRegister(this);

        // initialisasi presenter
        presenter = new presenterRegdata(this);

        // Editext
        etfirstName = (EditText)findViewById(R.id.etfirstName);
        etlastName = (EditText)findViewById(R.id.etlastName);
        etBirth = (EditText) findViewById(R.id.etBirth);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnNext   = (Button) findViewById(R.id.btnReg);
        imageView = (ImageView) findViewById(R.id.imgProfile);
        //spinner
        spnGender = (Spinner) findViewById(R.id.gender);

        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext,
                android.R.layout.simple_spinner_item, gender);
        spnGender.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePopup(v);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagePath == null){
                    Toast.makeText(getBaseContext(),"Please Select Image",Toast.LENGTH_LONG).show();
                }else {
                    presenter.regData(etfirstName.getText().toString(),
                            etlastName.getText().toString(),
                            etBirth.getText().toString(),
                            spnGender.getSelectedItem().toString(),
                            imagePath,
                            etPhone.getText().toString(),
                            spRegister.getIdCustomer()); // id didapatkan dari sharedPrefernces
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100) {
            if (data == null) {
                Toast.makeText(getApplicationContext(),"Unable to pick image",Toast.LENGTH_LONG).show();
                return;
            }

            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);
         /*
            Uri selectedImageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);*/
            imagePath = getRealPathFromURI(imageUri);

            //    Picasso.with(getApplicationContext()).load(new File(imagePath))
            //            .into(imageView);

            //   Toast.makeText(getApplicationContext(),"Please reselect your image",Toast.LENGTH_LONG).show();
           /*     cursor.close();

            } else {

                Toast.makeText(getApplicationContext(),"Unable to load image",Toast.LENGTH_LONG).show();
            }*/
        }
    }

    @Override
    public void berhasil() {
        Intent region = new Intent(cls_userdata.this,cls_userregion.class);
        startActivity(region);
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
    public void errorAdd(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(getApplicationContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
    public void showImagePopup(View view) {
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);

        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Choose image");
        startActivityForResult(chooserIntent, 100);

    }
}
