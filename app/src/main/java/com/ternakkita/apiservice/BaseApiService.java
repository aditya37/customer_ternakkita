package com.ternakkita.apiservice;

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

    // Vendor REST API Client
    @FormUrlEncoded
    @POST("vendor/vendor-register.php")
    Call<ResponseBody> registerRequest(@Field("username") String username,
                                       @Field("password") String password);

}
