package com.ternakkita.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaksi {
    @SerializedName("nomorTransaction")
    @Expose
    private String nomorTransaction;
    @SerializedName("namaVendor")
    @Expose
    private String namaVendor;
    @SerializedName("judulProduk")
    @Expose
    private String judulProduk;
    @SerializedName("hargaProduk")
    @Expose
    private String hargaProduk;
    @SerializedName("thumbnailProduct")
    @Expose
    private String thumbnailProduct;
    @SerializedName("statusTransaction")
    @Expose
    private String statusTransaction;
    @SerializedName("tglCash")
    @Expose
    private String tglCash;

    public String getNomorTransaction() {
        return nomorTransaction;
    }

    public void setNomorTransaction(String nomorTransaction) {
        this.nomorTransaction = nomorTransaction;
    }

    public String getNamaVendor() {
        return namaVendor;
    }

    public void setNamaVendor(String namaVendor) {
        this.namaVendor = namaVendor;
    }

    public String getJudulProduk() {
        return judulProduk;
    }

    public void setJudulProduk(String judulProduk) {
        this.judulProduk = judulProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getThumbnailProduct() {
        return thumbnailProduct;
    }

    public void setThumbnailProduct(String thumbnailProduct) {
        this.thumbnailProduct = thumbnailProduct;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public String getTglCash() {
        return tglCash;
    }

    public void setTglCash(String tglCash) {
        this.tglCash = tglCash;
    }
}
