package com.anand.expandableView.model.pathologDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTestDetail {

    @SerializedName("SubTestName")
    @Expose
    private String subTestName;
    @SerializedName("SubTestValue")
    @Expose
    private String subTestValue;
    @SerializedName("Unit")
    @Expose
    private String unit;
    @SerializedName("NormalRange")
    @Expose
    private String normalRange;
    @SerializedName("Remark")
    @Expose
    private String remark;

    public String getSubTestName() {
        return subTestName;
    }

    public void setSubTestName(String subTestName) {
        this.subTestName = subTestName;
    }

    public String getSubTestValue() {
        return subTestValue;
    }

    public void setSubTestValue(String subTestValue) {
        this.subTestValue = subTestValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}