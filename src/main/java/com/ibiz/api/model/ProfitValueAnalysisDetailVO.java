package com.ibiz.api.model;

public class ProfitValueAnalysisDetailVO {

    /**
     *	VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * List Price
     */
    private Long lpcAmt;

    /**
     * 영업할인율
     */
    private float slsDcRt;

    /**
     * 매출액
     */
    private Long sellAmt;

    /**
     * 매입원가
     */
    private Long pchsAmt;

    /**
     * 매입외 직접비
     */
    private Long drcstAmt;

    /**
     * 매출이익
     */
    private Long sellPrf;

    /**
     * 상품구분코드
     */
    private String prodDstCd;

    /**
     * 상품구분명
     */
    private String prodDstNm;

    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 상품유형명
     */
    private String prodTypeNm;

    /**
     * 제조원가금액
     */
    private String makeCostAmt;

    /**
     * 순매출
     */
    private String nsleAmt;

    public String getVrbAnlyId() {
        return vrbAnlyId;
    }

    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public Long getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public float getSlsDcRt() {
        return slsDcRt;
    }

    public void setSlsDcRt(float slsDcRt) {
        this.slsDcRt = slsDcRt;
    }

    public Long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public Long getPchsAmt() {
        return pchsAmt;
    }

    public void setPchsAmt(Long pchsAmt) {
        this.pchsAmt = pchsAmt;
    }

    public Long getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(Long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public Long getSellPrf() {
        return sellPrf;
    }

    public void setSellPrf(Long sellPrf) {
        this.sellPrf = sellPrf;
    }

    public String getProdDstCd() {
        return prodDstCd;
    }

    public void setProdDstCd(String prodDstCd) {
        this.prodDstCd = prodDstCd;
    }

    public String getProdDstNm() {
        return prodDstNm;
    }

    public void setProdDstNm(String prodDstNm) {
        this.prodDstNm = prodDstNm;
    }

    public String getMakeCostAmt() {
        return makeCostAmt;
    }

    public void setMakeCostAmt(String makeCostAmt) {
        this.makeCostAmt = makeCostAmt;
    }

    public String getNsleAmt() {
        return nsleAmt;
    }

    public void setNsleAmt(String nsleAmt) {
        this.nsleAmt = nsleAmt;
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

    @Override
    public String toString() {
        return "ProfitValueAnalysisDetailVO [vrbAnlyId=" + vrbAnlyId + ", fcstPalId=" + fcstPalId + ", lpcAmt=" + lpcAmt
                + ", slsDcRt=" + slsDcRt + ", sellAmt=" + sellAmt + ", pchsAmt=" + pchsAmt + ", drcstAmt=" + drcstAmt
                + ", sellPrf=" + sellPrf + ", prodDstCd=" + prodDstCd + ", prodDstNm=" + prodDstNm + ", makeCostAmt=" + makeCostAmt
                + ", nsleAmt=" + nsleAmt + ", prodTypeCd=" + prodTypeCd + ", prodTypeNm=" + prodTypeNm + "]";
    }

}
