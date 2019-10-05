package com.ternakkita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ternakkita.R;
import com.ternakkita.model.detailProduk.DetailProduk;
import com.ternakkita.model.detailProduk.Vendor;
import com.ternakkita.presenter.presenterDetailProduct;
import com.ternakkita.view.interfaceDetailProduk;

import java.util.List;

public class cls_detailProduk extends AppCompatActivity implements interfaceDetailProduk {
    presenterDetailProduct presenterDetailProduct;
    Context mContext;
    // Progressbar
    ProgressDialog loading;
    // Widget
    TextView txtNameProduct,txtPrice,txtDetBobot,txtDetUsia,txtDetJenisKelamin,txtDetDeskripsi,detNamaVendor,detAlamatVendor;
    ImageView imgProduk,imgProfile;
    //intent dump
    private String id;
    private String key_id_barang ="key_id_barang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_detailproduk);

        // declare context
        mContext = this;

        // declare view/widget into activity
        txtPrice       = (TextView)  findViewById(R.id.txtPrice);
        txtNameProduct = (TextView)  findViewById(R.id.txtNameProduct);
        txtDetBobot    = (TextView)  findViewById(R.id.txtDetBobot);
        txtDetUsia     = (TextView)  findViewById(R.id.txtDetUsia);
        txtDetJenisKelamin = (TextView) findViewById(R.id.txtDetJenisKelamin);
        txtDetDeskripsi = (TextView) findViewById(R.id.txtDetDeskripsi);
        detAlamatVendor = (TextView)findViewById(R.id.detAlamatVendor);
        detNamaVendor   = (TextView) findViewById(R.id.detNamaVendor);
        imgProduk       = (ImageView) findViewById(R.id.imgProduk);
        imgProfile      = (ImageView) findViewById(R.id.imgProfile);

        Bundle id_barang = getIntent().getExtras();
        id = id_barang.getString(key_id_barang);

        // Declare Presnter
        presenterDetailProduct = new presenterDetailProduct(this);
        presenterDetailProduct.getProdukDetail(id);
    }

    @Override
    public void errorGetData(String message) {

    }

    @Override
    public void getDataProduk(List<DetailProduk> detailProduks) {
        for (int i = 0; i <detailProduks.size() ; i++) {
            txtNameProduct.setText(detailProduks.get(i).getJudulProduk());
            txtPrice.setText("Rp "+detailProduks.get(i).getHarga());
            txtDetBobot.setText(detailProduks.get(i).getBobot());
            txtDetUsia.setText(detailProduks.get(i).getUmur());
            txtDetJenisKelamin.setText(detailProduks.get(i).getJenisKelamin());
            txtDetDeskripsi.setText(detailProduks.get(i).getDeskripsi());

            Glide.with(mContext)
                    .load(detailProduks.get(i).getThumbnail())
                    .into(imgProduk);
        }
    }

    @Override
    public void getDataVendor(List<Vendor> detailvendor) {
        for (int i = 0; i <detailvendor.size() ; i++) {
            detNamaVendor.setText(detailvendor.get(i).getFirstName());
            detAlamatVendor.setText(detailvendor.get(i).getAlamat());
            Glide.with(mContext)
                    .load(detailvendor.get(i).getImgProfile())
                    .into(imgProfile);
        }
    }

    @Override
    public void getDetailhideProgress() {
        loading.dismiss();
    }

    @Override
    public void getDetailShowProgress() {
        loading = ProgressDialog.show(mContext, null, "Please Wait...", true, false);
    }

}
