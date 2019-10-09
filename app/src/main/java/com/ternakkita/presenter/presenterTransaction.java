package com.ternakkita.presenter;

import android.util.Log;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.detailProduk.DetailProductRespone;

import com.ternakkita.model.transaction.TransactionRespone;
import com.ternakkita.view.interfaceTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterTransaction {

    private interfaceTransaction interfaceTransaction;

    public presenterTransaction(interfaceTransaction view){
     this.interfaceTransaction = view;
    }

    public void getTransaction(String idCustomer){
        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);
        Call<TransactionRespone> call = baseApi.getTransaction(idCustomer);
        call.enqueue(new Callback<TransactionRespone>() {
            @Override
            public void onResponse(Call<TransactionRespone> call, Response<TransactionRespone> response) {
                if(response.isSuccessful()){
                    Log.d("Respone Server :","True");
                    if (response.body().getSuccess().equals("1")){
                        interfaceTransaction.getTransaction(response.body().getTransaksi());
                    }else{
                        interfaceTransaction.emptyData(response.body().getMessage());
                    }
                }else{
                    Log.d("Respone Server :","False");
                }
            }

            @Override
            public void onFailure(Call<TransactionRespone> call, Throwable t) {
                Log.d("Error Detail:",""+t);
            }
        });
    }
}
