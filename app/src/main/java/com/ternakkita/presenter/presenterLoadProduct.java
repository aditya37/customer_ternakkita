package com.ternakkita.presenter;

import android.util.Log;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.getAllproduct.ProductRespone;
import com.ternakkita.view.interfaceProduct;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterLoadProduct  {

    private interfaceProduct interfaceProduct;

    public presenterLoadProduct(interfaceProduct view) {
        this.interfaceProduct = view;
    }

   public void getData(){

        interfaceProduct.showLoading();
       BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);
       Call<ProductRespone> call = baseApi.getallproduct();
       call.enqueue(new Callback<ProductRespone>() {
           @Override
           public void onResponse(Call<ProductRespone> call, Response<ProductRespone> response) {
               if(response.isSuccessful()){
                   interfaceProduct.hideLoading();
                   if(response.body().getSuccess().equals("1")){
                       ProductRespone productRespone = response.body();
                       interfaceProduct.getProduct(productRespone.getProduk());

                       Log.d("Pesan Berhasil","Data Sudah Berhasil Di Load!!!");
                   }else{
                       interfaceProduct.onErrorLoading(response.body().getMessage());
                   }
               }else{
                   Log.d("Pesan Respone","Respone Ke Server Error");
               }
           }

           @Override
           public void onFailure(Call<ProductRespone> call, Throwable t) {
               interfaceProduct.hideLoading();
               Log.d("Error",t.getMessage());
           }
       });
   }
}
