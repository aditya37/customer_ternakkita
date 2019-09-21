package com.ternakkita.presenter;

import android.content.Intent;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.UserRespone;
import com.ternakkita.view.interfaceRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterRegister {


    // Import interface class register
    private interfaceRegister registerview;

    public presenterRegister(interfaceRegister View) {
        this.registerview = View;
    }

   public void register(final String username,final String password){
       registerview.showProgress();
        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);
        Call<UserRespone> call = baseApi.registerRequest(username,password);
        call.enqueue(new Callback<UserRespone>() {
            @Override
            public void onResponse(Call<UserRespone> call, Response<UserRespone> response) {
                if(response.isSuccessful()){
                    registerview.hideProgress();
                    if(response.body().getSuccess().equals("1")){
                        registerview.onAddSuccess(response.body().getResult().getIdCustomer());
                    }else if(response.body().getSuccess().equals("0")){
                        registerview.onAddError("User Sudah Terdaftar");
                    }
                }else{
                    registerview.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<UserRespone> call, Throwable t) {
                registerview.hideProgress();
            }
        });
    }
}
