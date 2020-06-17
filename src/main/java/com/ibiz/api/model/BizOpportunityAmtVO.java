package com.ibiz.api.model;

public class BizOpportunityAmtVO {


    /**
     * 사업기회 ID
     */
    private String boptId;

    /**
     * 예상연월
     */
    private String fcstYam;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 상품구분코드
     */
    private String prodDstCd;

    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 제품분류코드
     */
    private String godsClsfCd;

    /**
     * 매출금액
     */
    private Long sellAmt;

    /**
     * 매입금액
     */
    private Long buyAmt;

    /**
     * 오리지널 예상연월
     */
    private String orinFcstYam;

    /**
     * 그리드 상태값 (C/U/D)
     */
    private String gridStatus;

    /**
     * 변경일시 (for History Insert)
     */
    private String chgDt;

    /**
     * 상품구분명
     */
    private String prodDstNm;

    /**
     * 상품유형명
     */
    private String prodTypeNm;

    /**
     * 제품분류명
     */
    private String godsClsfNm;

    /**
     * 총 매출금액
     */
    private Long sumSellAmt;

    /**
     * 총 매입금액
     */
    private Long sumBuyAmt;

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public String getFcstYam() {
        return fcstYam;
    }

    public void setFcstYam(String fcstYam) {
        this.fcstYam = fcstYam;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getProdDstCd() {
        return prodDstCd;
    }

    public void setProdDstCd(String prodDstCd) {
        this.prodDstCd = prodDstCd;
    }

    public String getGodsClsfCd() {
        return godsClsfCd;
    }

    public void setGodsClsfCd(String godsClsfCd) {
        this.godsClsfCd = godsClsfCd;
    }

    public Long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public Long getBuyAmt() {
        return buyAmt;
    }

    public void setBuyAmt(Long buyAmt) {
        this.buyAmt = buyAmt;
    }

    public String getOrinFcstYam() {
        return orinFcstYam;
    }

    public void setOrinFcstYam(String orinFcstYam) {
        this.orinFcstYam = orinFcstYam;
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public void setGridStatus(String gridStatus) {
        this.gridStatus = gridStatus;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getProdDstNm() {
        return prodDstNm;
    }

    public void setProdDstNm(String prodDstNm) {
        this.prodDstNm = prodDstNm;
    }

    public String getGodsClsfNm() {
        return godsClsfNm;
    }

    public void setGodsClsfNm(String godsClsfNm) {
        this.godsClsfNm = godsClsfNm;
    }

    public Long getSumSellAmt() {
        return sumSellAmt;
    }

    public void setSumSellAmt(Long sumSellAmt) {
        this.sumSellAmt = sumSellAmt;
    }

    public Long getSumBuyAmt() {
        return sumBuyAmt;
    }

    public void setSumBuyAmt(Long sumBuyAmt) {
        this.sumBuyAmt = sumBuyAmt;
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
        return "BizOpportunityAmtVO [boptId=" + boptId + ", fcstYam=" + fcstYam + ", seq=" + seq + ", prodDstCd="
                + prodDstCd + ", godsClsfCd=" + godsClsfCd + ", sellAmt=" + sellAmt + ", buyAmt=" + buyAmt
                + ", orinFcstYam=" + orinFcstYam + ", gridStatus=" + gridStatus + ", chgDt=" + chgDt + ", prodDstNm="
                + prodDstNm + ", godsClsfNm=" + godsClsfNm + ", sumSellAmt=" + sumSellAmt + ", sumBuyAmt=" + sumBuyAmt
                + "]";
    }
}
