package com.ibiz.api.model;

import java.util.List;

public class CommonGroupCodeVO {

    private String comGrpCd;

    private String comGrpCdNm;

    private String comGrpCdDesc;

    private String dataSbarCd;

    private String hgrkComGrpCd;

    private String avlStartDate;

    private String avlEndDate;

    private String regEmpId;

    private String regDt;

    private String chgEmpId;

    private String chgDt;

    private List<CmnCodeVO> commonCodeList;

    public String getComGrpCd() {
        return comGrpCd;
    }

    public void setComGrpCd(String comGrpCd) {
        this.comGrpCd = comGrpCd;
    }

    public String getComGrpCdNm() {
        return comGrpCdNm;
    }

    public void setComGrpCdNm(String comGrpCdNm) {
        this.comGrpCdNm = comGrpCdNm;
    }

    public String getComGrpCdDesc() {
        return comGrpCdDesc;
    }

    public void setComGrpCdDesc(String comGrpCdDesc) {
        this.comGrpCdDesc = comGrpCdDesc;
    }

    public String getDataSbarCd() {
        return dataSbarCd;
    }

    public void setDataSbarCd(String dataSbarCd) {
        this.dataSbarCd = dataSbarCd;
    }

    public String getHgrkComGrpCd() {
        return hgrkComGrpCd;
    }

    public void setHgrkComGrpCd(String hgrkComGrpCd) {
        this.hgrkComGrpCd = hgrkComGrpCd;
    }

    public String getAvlStartDate() {
        return avlStartDate;
    }

    public void setAvlStartDate(String avlStartDate) {
        this.avlStartDate = avlStartDate;
    }

    public String getAvlEndDate() {
        return avlEndDate;
    }

    public void setAvlEndDate(String avlEndDate) {
        this.avlEndDate = avlEndDate;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public List<CmnCodeVO> getCommonCodeList() {
        return commonCodeList;
    }

    public void setCommonCodeList(List<CmnCodeVO> commonCodeList) {
        this.commonCodeList = commonCodeList;
    }

}
