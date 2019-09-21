package com.ternakkita.presenter;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.UserRespone;
import com.ternakkita.view.interfaceRegregion;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterRegregion {

    private interfaceRegregion regregionView;

    public presenterRegregion(interfaceRegregion View){
        this.regregionView = View;
    }

    public void regRegion(final String provinsi,
                          final String kabupaten,
                          final String kecamatan,
                          final String desa,
                          final String address,
                          final String kodepos, final String id_user) {

        regregionView.showProgress();

        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);

        Call<UserRespone> call = baseApi.registerRegion(provinsi,
                                                        kabupaten,
                                                        kecamatan,
                                                        desa,
                                                        address,
                                                        kodepos,id_user);

        call.enqueue(new Callback<UserRespone>() {
            @Override
            public void onResponse(Call<UserRespone> call, Response<UserRespone> response) {
                regregionView.hideProgress();
               if (response.isSuccessful()){

                   if(response.body().getSuccess().equals("1")){
                       regregionView.onAddSuccess(response.body().getMessage());
                   }else{
                       regregionView.onAddError(response.body().getMessage());
                   }

               }else{
                   regregionView.hideProgress();
               }

            }

            @Override
            public void onFailure(Call<UserRespone> call, Throwable t) {
                regregionView.hideProgress();
            }
        });

    }
}
