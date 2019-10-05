package com.ternakkita.apiservice;

import com.ternakkita.model.detailProduk.DetailProductRespone;
import com.ternakkita.model.getAllproduct.ProductRespone;
import com.ternakkita.model.UserRespone;


import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

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

    /*
    * Jika ingin mengupload file gunakan @Multipart dan setiap form field menggunakan @PartMap
    * untuk meringkas penulisann code bisa gunakan Map<String,RequestBody> value
    * Map<field di RestAPI,RequestBody> param/nilai yang di kirim user
     */
    @Multipart
    @POST("customer/customer-userdata.php")
    Call<UserRespone> registerUserData(@Part MultipartBody.Part file,@PartMap Map<String,RequestBody> Value);

    // user region
    @FormUrlEncoded
    @POST("customer/customer-region.php")
    Call<UserRespone> registerRegion(@Field("provinsi") String provinsi,
                                     @Field("kabupaten") String kabupaten,
                                     @Field("kecamatan") String kecamatan,
                                     @Field("desa") String desa,
                                     @Field("alamat") String address,
                                     @Field("postalcode") String kodepos,
                                     @Field("id_login") String id_user);

    @GET("product/product-getall.php")
    Call<ProductRespone> getallproduct();

    @GET("product/product-getaByid.php")
    Call <DetailProductRespone> getDetailProduk(@Query("idProduct") String idProduct);
}

