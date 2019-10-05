package com.ternakkita.model.getAllproduct;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRespone {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("jumlah_product")
    @Expose
    private String jumlahProduct;
    @SerializedName("produk")
    @Expose
    private List<product> produk = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJumlahProduct() {
        return jumlahProduct;
    }

    public void setJumlahProduct(String jumlahProduct) {
        this.jumlahProduct = jumlahProduct;
    }

    public List<product> getProduk() {
        return produk;
    }

    public void setProduk(List<product> produk) {
        this.produk = produk;
    }

}