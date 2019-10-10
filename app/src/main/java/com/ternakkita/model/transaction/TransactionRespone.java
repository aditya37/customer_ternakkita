package com.ternakkita.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionRespone {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("transaksi")
    @Expose
    private List<Transaksi> transaksi = null;
    @SerializedName("data")
    @Expose
    private List<data_user> data = null;

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

    public List<Transaksi> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(List<Transaksi> transaksi) {
        this.transaksi = transaksi;
    }

    public List<data_user> getData() {
        return data;
    }

    public void setData(List<data_user> data) {
        this.data = data;
    }
}
