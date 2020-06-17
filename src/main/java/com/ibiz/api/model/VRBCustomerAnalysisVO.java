package com.ibiz.api.model;

/**
 *
 * BPIP120T : VRB고객분석내역
 *
 */

public class VRBCustomerAnalysisVO {

    /**
     * VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 소속기관명
     */
    private String bltoIsttNm;

    /**
     * 부서명
     */
    private String deptNm;

    /**
     * 고객명
     */
    private String custNm;

    /**
     * 직급명
     */
    private String copsNm;

    /**
     * 직책명
     */
    private String resoNm;

    /**
     * 담당업무명
     */
    private String  crgJobNm;

    /**
     * 고객영향도코드
     */
    private String custIndgCd;

    /**
     * 고객영향도명
     */
    private String custIndgNm;

    /**
     * 고객우호성향코드
     */
    private String custFdlInclnCd;

    /**
     * 고객우호성향명
     */
    private String custFdlInclnNm;

    /**
     * 비고내용
     */
    private String rmrkCont;

    public String getVrbAnlyId() {
        return vrbAnlyId;
    }

    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getBltoIsttNm() {
        return bltoIsttNm;
    }

    public void setBltoIsttNm(String bltoIsttNm) {
        this.bltoIsttNm = bltoIsttNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCopsNm() {
        return copsNm;
    }

    public void setCopsNm(String copsNm) {
        this.copsNm = copsNm;
    }

    public String getResoNm() {
        return resoNm;
    }

    public void setResoNm(String resoNm) {
        this.resoNm = resoNm;
    }

    public String getCrgJobNm() {
        return crgJobNm;
    }

    public void setCrgJobNm(String crgJobNm) {
        this.crgJobNm = crgJobNm;
    }

    public String getCustIndgCd() {
        return custIndgCd;
    }

    public void setCustIndgCd(String custIndgCd) {
        this.custIndgCd = custIndgCd;
    }

    public String getCustIndgNm() {
        return custIndgNm;
    }

    public void setCustIndgNm(String custIndgNm) {
        this.custIndgNm = custIndgNm;
    }

    public String getCustFdlInclnCd() {
        return custFdlInclnCd;
    }

    public void setCustFdlInclnCd(String custFdlInclnCd) {
        this.custFdlInclnCd = custFdlInclnCd;
    }

    public String getCustFdlInclnNm() {
        return custFdlInclnNm;
    }

    public void setCustFdlInclnNm(String custFdlInclnNm) {
        this.custFdlInclnNm = custFdlInclnNm;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
    }

    @Override
    public String toString() {
        return "VRBCustomerAnalysisVO [vrbAnlyId=" + vrbAnlyId + ", seq=" + seq + ", bltoIsttNm=" + bltoIsttNm
                + ", deptNm=" + deptNm + ", custNm=" + custNm + ", copsNm=" + copsNm + ", resoNm=" + resoNm
                + ", crgJobNm=" + crgJobNm + ", custIndgCd=" + custIndgCd + ", custIndgNm=" + custIndgNm
                + ", custFdlInclnCd=" + custFdlInclnCd + ", custFdlInclnNm=" + custFdlInclnNm + ", rmrkCont=" + rmrkCont
                + "]";
    }

}
