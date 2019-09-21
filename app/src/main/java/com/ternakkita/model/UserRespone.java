package com.ternakkita.model;

// class ini berisi respone atau callback dari restapi
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRespone {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("userLevel")
    @Expose
    private String userLevel;
    @SerializedName("result")
    @Expose
    private result result = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public result getResult() {
        return result;
    }

    public void setResult(result result) {
        this.result = result;
    }
}
