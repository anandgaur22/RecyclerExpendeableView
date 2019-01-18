package com.anand.expandableView.model.pathologDetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResposnseValue {

    @SerializedName("TestName")
    @Expose
    private String testName;
    @SerializedName("SubTestDetail")
    @Expose
    private List<SubTestDetail> subTestDetail = null;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public List<SubTestDetail> getSubTestDetail() {
        return subTestDetail;
    }

    public void setSubTestDetail(List<SubTestDetail> subTestDetail) {
        this.subTestDetail = subTestDetail;
    }

}