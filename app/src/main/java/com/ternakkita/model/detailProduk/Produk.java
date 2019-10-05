package com.ternakkita.model.detailProduk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Produk {
    @SerializedName("detail_produk")
    @Expose
    private List<DetailProduk> detailProduk = null;
    @SerializedName("vendor")
    @Expose
    private List<Vendor> vendor = null;

    public List<DetailProduk> getDetailProduk() {
        return detailProduk;
    }

    public void setDetailProduk(List<DetailProduk> detailProduk) {
        this.detailProduk = detailProduk;
    }

    public List<Vendor> getVendor() {
        return vendor;
    }

    public void setVendor(List<Vendor> vendor) {
        this.vendor = vendor;
    }
}
