package com.anand.expandableView.model.pathologyList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResposnseValue {

    @SerializedName("InvestigationMainId")
    @Expose
    private Integer investigationMainId;
    @SerializedName("BillNo")
    @Expose
    private String billNo;
    @SerializedName("PathologyName")
    @Expose
    private String pathologyName;
    @SerializedName("InvestigationDate")
    @Expose
    private String investigationDate;
    @SerializedName("InvestigationType")
    @Expose
    private Integer investigationType;
    @SerializedName("InvestigationImagePath")
    @Expose
    private String investigationImagePath;

    public Integer getInvestigationMainId() {
        return investigationMainId;
    }

    public void setInvestigationMainId(Integer investigationMainId) {
        this.investigationMainId = investigationMainId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getPathologyName() {
        return pathologyName;
    }

    public void setPathologyName(String pathologyName) {
        this.pathologyName = pathologyName;
    }

    public String getInvestigationDate() {
        return investigationDate;
    }

    public void setInvestigationDate(String investigationDate) {
        this.investigationDate = investigationDate;
    }

    public Integer getInvestigationType() {
        return investigationType;
    }

    public void setInvestigationType(Integer investigationType) {
        this.investigationType = investigationType;
    }

    public String getInvestigationImagePath() {
        return investigationImagePath;
    }

    public void setInvestigationImagePath(String investigationImagePath) {
        this.investigationImagePath = investigationImagePath;
    }

}