package com.ternakkita.view;

// interface login handle
public interface interfaceLogin {

    void showProgress();
    void hideProgress();
    void onLoginError(String message);
    void loginBerhasil(String pesan);

}
