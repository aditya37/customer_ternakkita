package com.ternakkita.presenter;

import android.util.Log;

import com.ternakkita.apiservice.BaseApiService;
import com.ternakkita.apiservice.RetrofitClient;
import com.ternakkita.model.UserRespone;
import com.ternakkita.view.interfaceRegdata;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class presenterRegdata{

    // Import interface class register
    private interfaceRegdata regdata;

    public presenterRegdata(interfaceRegdata View) {
        this.regdata = View;
    }

    private RequestBody createPartFromString(String valueString) {
        return RequestBody.create( okhttp3.MultipartBody.FORM, valueString);
    }


    // Merubah inputan dari string ke Map
    public void regData(final String firstName,final String lastName,final String birth,final String gender,final String path,final String phone,final String
                        id_user){
        //show progress
        regdata.showProgress();

        // Start Retrofit Service
        BaseApiService baseApi = RetrofitClient.getClient().create(BaseApiService.class);

        // Menampung Data dari inputan user
        HashMap<String,RequestBody> map = new HashMap<>();
        map.put("firstName",createPartFromString(firstName));
        map.put("lastName",createPartFromString(lastName));
        map.put("birth",createPartFromString(birth));
        map.put("gender",createPartFromString(gender));
        map.put("phone",createPartFromString(phone));
        map.put("locationImg",createPartFromString(path));
        map.put("id_login",createPartFromString(id_user));

        // Convert Gambar Menjadi File
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("Multipart/form-data"),file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file",file.getName(),requestFile);

        Call<UserRespone> call = baseApi.registerUserData(body,map);

        call.enqueue(new Callback<UserRespone>() {
            @Override
            public void onResponse(Call<UserRespone> call, Response<UserRespone> response) {
                regdata.hideProgress();
                if(response.isSuccessful()){
                    if(response.body().getSuccess().equals("1")){
                        regdata.berhasil();
                    }else{
                        regdata.errorAdd(response.body().getMessage());
                    }
                }else{
                    regdata.errorAdd(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserRespone> call, Throwable t) {
                regdata.hideProgress();
            }
        });
    }


}

