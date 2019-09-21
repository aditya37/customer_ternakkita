package com.ternakkita.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class spRegister {

    // key atau variable yang akan menampung data dari activity register

    public static final String PREFERENCES_NAME = "register"; // session name jika di pemrograman web
    public static final String ID_CUSTOMER      = "id_customer"; // menanpung id customer setelah registrasi

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public spRegister(Context mContext){
        sp = mContext.getSharedPreferences(PREFERENCES_NAME,mContext.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    // save sharedPrefernces dalam bentuk STRING
    // keySP => session name, jika di project ini keySP adalah ID_CUSTOMER
    public void saveStringSP(String keySP,String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    // get id Customer
    public String getIdCustomer() {
        return sp.getString(ID_CUSTOMER,"");
    }

}
