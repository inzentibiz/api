package com.ibiz.api.model;

/**
 *
 * BEST020T : 예상손익실적집계
 *
 */

public class OfferResultVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 상품유형명
     */
    private String prodTypeCdNm;

    /**
     * 제품분류코드
     */
    private String godsClsfCd;

    /**
     * 제품분류명
     */
    private String godsClsfCdNm;

    /**
     * ListPirce금액
     */
    private long lpcAmt;

    /**
     * 매출금액
     */
    private long sellAmt;

    /**
     * 매입원가금액
     */
    private long buyCostAmt;

    /**
     * 직접원가금액
     */
    private long drcstAmt;

    /**
     * 직접경비금액
     */
    private long drexpAmt;

    /**
     * 간접원가금액
     */
    private long incstAmt;

    /**
     * 공헌이익금액
     */
    private long ctmgAmt;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 투입시간단위명
     */
    private String putTimeUnitCdNm;

    /**
     * 투입인원수
     */
    private double putNopCount;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getProdTypeCd() {
        return prodTypeCd;
    }

    public void setProdTypeCd(String prodTypeCd) {
        this.prodTypeCd = prodTypeCd;
    }

    public String getProdTypeCdNm() {
        return prodTypeCdNm;
    }

    public void setProdTypeCdNm(String prodTypeCdNm) {
        this.prodTypeCdNm = prodTypeCdNm;
    }

    public long getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public long getBuyCostAmt() {
        return buyCostAmt;
    }

    public void setBuyCostAmt(long buyCostAmt) {
        this.buyCostAmt = buyCostAmt;
    }

    public long getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public long getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

    public long getIncstAmt() {
        return incstAmt;
    }

    public void setIncstAmt(long incstAmt) {
        this.incstAmt = incstAmt;
    }

    public String getGodsClsfCd() {
        return godsClsfCd;
    }

    public void setGodsClsfCd(String godsClsfCd) {
        this.godsClsfCd = godsClsfCd;
    }

    public String getGodsClsfCdNm() {
        return godsClsfCdNm;
    }

    public void setGodsClsfCdNm(String godsClsfCdNm) {
        this.godsClsfCdNm = godsClsfCdNm;
    }

    public long getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public String getPutTimeUnitCdNm() {
        return putTimeUnitCdNm;
    }

    public void setPutTimeUnitCdNm(String putTimeUnitCdNm) {
        this.putTimeUnitCdNm = putTimeUnitCdNm;
    }

    public double getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(double putNopCount) {
        this.putNopCount = putNopCount;
    }


}
