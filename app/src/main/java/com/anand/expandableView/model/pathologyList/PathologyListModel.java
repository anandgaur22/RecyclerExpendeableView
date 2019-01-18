package com.anand.expandableView.model.pathologyList;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PathologyListModel {

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("resposnseValue")
    @Expose
    private List<ResposnseValue> resposnseValue = null;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<ResposnseValue> getResposnseValue() {
        return resposnseValue;
    }

    public void setResposnseValue(List<ResposnseValue> resposnseValue) {
        this.resposnseValue = resposnseValue;
    }

}