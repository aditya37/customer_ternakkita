package com.ternakkita.sharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ternakkita.activity.cls_landingPage;
import com.ternakkita.activity.cls_login;

public class spLogin {
    public static final String PREFERENCES_NAME = "login"; // session name jika di pemrograman web
    public static final String ID_CUSTOMER      = "id_customer"; // menanpung id customer setelah registrasi
    public static final String is_login = "islogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    Context context;

    public spLogin(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(PREFERENCES_NAME,context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void creteSession(String KeySession, String idCustomer){
        spEditor.putBoolean(is_login,true);
        spEditor.putString(KeySession,idCustomer);
        spEditor.commit();
    }

    public String getIdCustomer() {
        return sp.getString(ID_CUSTOMER,"");
    }

    public void checkLogin(){
        if (!this.is_login()){
            Intent i = new Intent(context, cls_login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }else {
            Intent i = new Intent(context, cls_landingPage.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }

    private boolean is_login() {
        return sp.getBoolean(is_login, false);
    }
}
