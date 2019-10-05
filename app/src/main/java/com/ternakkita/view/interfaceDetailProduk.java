package com.ternakkita.view;

import com.ternakkita.model.detailProduk.DetailProduk;
import com.ternakkita.model.detailProduk.Produk;
import com.ternakkita.model.detailProduk.Vendor;

import java.util.List;

public interface interfaceDetailProduk {
    void  errorGetData(String message);
    void  getDataProduk(List<DetailProduk> detailProduks);
    void  getDataVendor(List<Vendor> detailVendor);
    void  getDetailhideProgress();
    void  getDetailShowProgress();
}
