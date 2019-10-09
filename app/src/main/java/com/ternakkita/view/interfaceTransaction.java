package com.ternakkita.view;

import com.ternakkita.model.transaction.Transaksi;

import java.util.List;

public interface interfaceTransaction {
    void getTransaction(List <Transaksi> transaksis);
    void emptyData(String message); // fungsi ini dipanggil jika data transaksi masih kosong
}
