package com.ternakkita.model;
// berisi array dari json Result[
// ]
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class result {

    @SerializedName("idCustomer")
    @Expose
    private String idCustomer;
    @SerializedName("username")
    @Expose
    private String username;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
