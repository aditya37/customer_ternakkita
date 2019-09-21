package com.ternakkita.presenter;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.UserRespone;
import com.ternakkita.view.interfaceLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterLogin {


    // Import interface class register
    private interfaceLogin loginView;


    public presenterLogin(interfaceLogin View) {
        this.loginView = View;
    }

    public void actionLogin(final String username,final String password){
        // Menampikan progressbar
        loginView.showProgress();
        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);
        Call<UserRespone> call = baseApi.loginRequest(username,password);

        call.enqueue(new Callback<UserRespone>() {
            @Override
            public void onResponse(Call<UserRespone> call, Response<UserRespone> response) {
                if(response.isSuccessful()){

                    if (response.body().getSuccess().equals("1")){
                        loginView.loginBerhasil(response.body().getMessage());
                        loginView.hideProgress();
                    }else{
                        loginView.onLoginError("gagal");
                        loginView.hideProgress();
                    }
                }else {
                    loginView.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<UserRespone> call, Throwable t) {
                loginView.hideProgress();
            }
        });
    }
}
