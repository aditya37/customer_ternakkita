package com.ternakkita.view;

import com.ternakkita.model.getAllproduct.product;

import java.util.List;

public interface interfaceProduct {
    void showLoading();
    void hideLoading();
    void getProduct(List<product> dataList);
    void onErrorLoading(String message);
}