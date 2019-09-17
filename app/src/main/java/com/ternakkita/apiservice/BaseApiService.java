package com.ternakkita.apiservice;

import com.ternakkita.model.UserRespone;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    /*
    * Catatan :
    *   - Class ini berfungsi untuk mengisi atau mengHandle perintah GET,POST,UPDATE,DELETE
    *   - Anotasi @GET mendefinisikan request GET yang akan di run setelah metode dipanggil
    * */

    // Customer REST API Client
    @FormUrlEncoded
    @POST("customer/customer-login.php")
    Call<UserRespone> loginRequest(@Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("customer/customer-register.php")
    Call<UserRespone> registerRequest(@Field("username") String username,
                                      @Field("password") String password);




}
