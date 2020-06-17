package com.ibiz.api.model;

public class EstiHisVO {

    /**
     * 등록일
     */
    private String estiWrtDate;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트명
     */
    private String prjtNm;

    /**
     * 사업기회명
     */
    private String boptNm;

    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 프로젝트유형
     */
    private String prjtTypeNm;

    /**
     * 총매출액
     */
    private Long sellAmt;

    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 영업대표명
     */
    private String slsEmpNm;

    /**
     * 견적상태명
     */
    private String estisStatNm;

    public String getEstiWrtDate() {
        return estiWrtDate;
    }

    public void setEstiWrtDate(String estiWrtDate) {
        this.estiWrtDate = estiWrtDate;
    }

    public String getLastCustNm() {
        return lastCustNm;
    }

    public void setLastCustNm(String lastCustNm) {
        this.lastCustNm = lastCustNm;
    }

    public String getPrjtNm() {
        return prjtNm;
    }

    public void setPrjtNm(String prjtNm) {
        this.prjtNm = prjtNm;
    }

    public String getBoptNm() {
        return boptNm;
    }

    public void setBoptNm(String boptNm) {
        this.boptNm = boptNm;
    }

    public String getOrdeCustNm() {
        return ordeCustNm;
    }

    public void setOrdeCustNm(String ordeCustNm) {
        this.ordeCustNm = ordeCustNm;
    }

    public String getPrjtTypeNm() {
        return prjtTypeNm;
    }

    public void setPrjtTypeNm(String prjtTypeNm) {
        this.prjtTypeNm = prjtTypeNm;
    }

    public Long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public String getSlsDeptNm() {
        return slsDeptNm;
    }

    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getEstisStatNm() {
        return estisStatNm;
    }

    public void setEstisStatNm(String estisStatNm) {
        this.estisStatNm = estisStatNm;
    }

    @Override
    public String toString() {
        return "EstiHisVO [estiWrtDate=" + estiWrtDate + ", lastCustNm=" + lastCustNm + ", prjtNm=" + prjtNm
                + ", boptNm=" + boptNm + ", ordeCustNm=" + ordeCustNm + ", prjtTypeNm=" + prjtTypeNm + ", sellAmt="
                + sellAmt + ", slsDeptNm=" + slsDeptNm + ", slsEmpNm=" + slsEmpNm + ", estisStatNm=" + estisStatNm
                + "]";
    }

}
