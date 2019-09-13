package com.ternakkita.apiservice;

public class UtilsApi {
    /*
    * - Jika  menggunakan server atau vps BASE_URL_API di isi dengan url atau ip public dari vps tersebut
    *
    * */
    public static final String BASE_URL_API = "http://192.168.0.133/api.ternakkita/";


    // Deklarasi Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
