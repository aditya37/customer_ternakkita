package com.ternakkita.model.getAllproduct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class product {

    @SerializedName("idProduct")
    @Expose
    private String idProduct;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("provinsi")
    @Expose
    private String provinsi;
    @SerializedName("peternak")
    @Expose
    private String peternak;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public product(String idProduct, String judul, String harga, String provinsi, String peternak, String thumbnail) {
        this.idProduct = idProduct;
        this.judul = judul;
        this.harga = harga;
        this.provinsi = provinsi;
        this.peternak = peternak;
        this.thumbnail = thumbnail;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getPeternak() {
        return peternak;
    }

    public void setPeternak(String peternak) {
        this.peternak = peternak;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}