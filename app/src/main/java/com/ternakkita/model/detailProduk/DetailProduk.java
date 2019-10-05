package com.ternakkita.model.detailProduk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailProduk {
    @SerializedName("idProduct")
    @Expose
    private String idProduct;
    @SerializedName("judulProduk")
    @Expose
    private String judulProduk;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("bobot")
    @Expose
    private String bobot;
    @SerializedName("umur")
    @Expose
    private String umur;
    @SerializedName("jenisKelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("catatan")
    @Expose
    private String catatan;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getJudulProduk() {
        return judulProduk;
    }

    public void setJudulProduk(String judulProduk) {
        this.judulProduk = judulProduk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBobot() {
        return bobot;
    }

    public void setBobot(String bobot) {
        this.bobot = bobot;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
