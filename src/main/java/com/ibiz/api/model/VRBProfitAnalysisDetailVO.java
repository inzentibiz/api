package com.ibiz.api.model;

import java.util.List;

/**
 *
 * BPIP141T : VRB수익분석상세
 *
 */

public class VRBProfitAnalysisDetailVO {

    /**
     * 예상손익 ID
     */
    private String fcstPalId;
    /**
     * VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 견적ID
     */
    private String estiId;

    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 상품유형명
     */
    private String prodTypeNm;

    /**
     * LISTPRICE금액
     */
    private Long lpcAmt;

    /**
     * 매출금액
     */
    private Long sellAmt;

    /**
     * 매입원가금액
     */
    private Long buyCostAmt;

    /**
     * 직접원가금액(매입외)
     */
    private Long drcstAmt;

    /**
     * 직접경비금액
     */
    private Long drexpAmt;

    /**
     * 간접원가금액
     */
    private Long incstAmt;

    /**
     * 공헌이익금액
     */
    private Long ctmgAmt;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 투입시간단위명
     */
    private String putTimeUnitNm;

    /**
     * 투입인원수
     */
    private float putNopCount;

    public String getFcstPalId() {
        return fcstPalId;
    }


    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }


    public String getVrbAnlyId() {
        return vrbAnlyId;
    }


    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }


    public String getEstiId() {
        return estiId;
    }


    public void setEstiId(String estiId) {
        this.estiId = estiId;
    }


    public String getProdTypeCd() {
        return prodTypeCd;
    }


    public void setProdTypeCd(String prodTypeCd) {
        this.prodTypeCd = prodTypeCd;
    }


    public String getProdTypeNm() {
        return prodTypeNm;
    }


    public void setProdTypeNm(String prodTypeNm) {
        this.prodTypeNm = prodTypeNm;
    }


    public Long getLpcAmt() {
        return lpcAmt;
    }


    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }


    public Long getSellAmt() {
        return sellAmt;
    }


    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }


    public Long getBuyCostAmt() {
        return buyCostAmt;
    }


    public void setBuyCostAmt(Long buyCostAmt) {
        this.buyCostAmt = buyCostAmt;
    }


    public Long getDrcstAmt() {
        return drcstAmt;
    }


    public void setDrcstAmt(Long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }


    public Long getDrexpAmt() {
        return drexpAmt;
    }


    public void setDrexpAmt(Long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }


    public Long getIncstAmt() {
        return incstAmt;
    }


    public void setIncstAmt(Long incstAmt) {
        this.incstAmt = incstAmt;
    }


    public Long getCtmgAmt() {
        return ctmgAmt;
    }


    public void setCtmgAmt(Long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }


    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }


    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }


    public String getPutTimeUnitNm() {
        return putTimeUnitNm;
    }


    public void setPutTimeUnitNm(String putTimeUnitNm) {
        this.putTimeUnitNm = putTimeUnitNm;
    }


    public float getPutNopCount() {
        return putNopCount;
    }


    public void setPutNopCount(float putNopCount) {
        this.putNopCount = putNopCount;
    }


    @Override
    public String toString() {
        return "VRBProfitAnalysisDetailVO [fcstPalId=" + fcstPalId + ", vrbAnlyId=" + vrbAnlyId + ", estiId=" + estiId
                + ", prodTypeCd=" + prodTypeCd + ", prodTypeNm=" + prodTypeNm + ", lpcAmt=" + lpcAmt + ", sellAmt="
                + sellAmt + ", buyCostAmt=" + buyCostAmt + ", drcstAmt=" + drcstAmt + ", drexpAmt=" + drexpAmt
                + ", incstAmt=" + incstAmt + ", ctmgAmt=" + ctmgAmt + ", putTimeUnitCd=" + putTimeUnitCd
                + ", putTimeUnitNm=" + putTimeUnitNm + ", putNopCount=" + putNopCount +"]";
    }

}
