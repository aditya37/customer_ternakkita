package com.ternakkita.view;

// interface User Register handle
public interface interfaceRegister {

    void showProgress();
    void hideProgress();
    void onAddSuccess(String idUser);
    void onAddError(String message);

}
