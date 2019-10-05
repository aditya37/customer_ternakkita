package com.ternakkita.presenter;

import android.util.Log;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.detailProduk.DetailProductRespone;
import com.ternakkita.model.getAllproduct.ProductRespone;
import com.ternakkita.view.interfaceDetailProduk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterDetailProduct {

    private interfaceDetailProduk interfaceDetailProduk;

    public presenterDetailProduct(interfaceDetailProduk view) {
        this.interfaceDetailProduk = view;
    }

    public void getProdukDetail(String idProduct) {
        interfaceDetailProduk.getDetailShowProgress();
        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);
        Call<DetailProductRespone> call = baseApi.getDetailProduk(idProduct);
        call.enqueue(new Callback<DetailProductRespone>() {
            @Override
            public void onResponse(Call<DetailProductRespone> call, Response<DetailProductRespone> response) {
              //validasi respone dari server
                if (response.isSuccessful()){
                  interfaceDetailProduk.getDetailhideProgress();
                  Log.d("Respone Server:","True");
                  if (response.body().getSuccess().equals("1")){
                      // Menampung data vendor ke dalam list List<Vendor> detailVendor
                      interfaceDetailProduk.getDataVendor(response.body().getProduk().getVendor());
                      // Menampung data vendor ke dalam list List<DetailProduk> detailProduk
                      interfaceDetailProduk.getDataProduk(response.body().getProduk().getDetailProduk());
                      Log.d("Respone Server:","True");
                  }else{
                      interfaceDetailProduk.errorGetData(response.body().getMessage());
                  }
              }else{
                  interfaceDetailProduk.getDetailhideProgress();
                  Log.d("Respone Server:","False");
              }
            }

            @Override
            public void onFailure(Call<DetailProductRespone> call, Throwable t) {
                Log.d("Error Detail:",""+t);
            }
        });

    }

}

