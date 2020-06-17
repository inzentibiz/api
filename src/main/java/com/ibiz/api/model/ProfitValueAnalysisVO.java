package com.ibiz.api.model;

public class ProfitValueAnalysisVO {

    /**
     * 매출성과
     */
    private Long sellRslt;

    /**
     * 순매출
     */
    private Long nsleAmt;

    /**
     * 직간접비
     */
    private Long drcstIncstAmt;

    /**
     * 매출이익
     */
    private Long sellPrf;

    /**
     * 매출성과대비 매출이익률
     */
    private Float sellPrfRt;

    /**
     * 공헌이익
     */
    private Long ctmgAmt;

    /**
     * 매출성과대비 공헌이익률
     */
    private Float ctmgAmtRt;

    /**
     * 간접비
     */
    private Long incstAmt;

    private Long lpcAmt;

    /**
     * 공급금액
     */
    private Long splyAmt;

    /**
     * 매입원가
     */
    private Long buyCostAmt;

    /**
     * 직접원가
     */
    private Long drcstAmt;

    /**
     * 직접비
     */
    private Long drexpAmt;

    /**
     * 외주비
     */
    private Long svcBuyCostAmt;

    /**
     * 제조원가금액
     */
    private Long makeCostAmt;

    public Long getSellRslt() {
        return sellRslt;
    }

    public void setSellRslt(Long sellRslt) {
        this.sellRslt = sellRslt;
    }

    public Long getNsleAmt() {
        return nsleAmt;
    }

    public void setNsleAmt(Long nsleAmt) {
        this.nsleAmt = nsleAmt;
    }

    public Long getDrcstIncstAmt() {
        return drcstIncstAmt;
    }

    public void setDrcstIncstAmt(Long drcstIncstAmt) {
        this.drcstIncstAmt = drcstIncstAmt;
    }

    public Long getSellPrf() {
        return sellPrf;
    }

    public void setSellPrf(Long sellPrf) {
        this.sellPrf = sellPrf;
    }

    public Float getSellPrfRt() {
        return sellPrfRt;
    }

    public void setSellPrfRt(Float sellPrfRt) {
        this.sellPrfRt = sellPrfRt;
    }

    public Long getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(Long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }

    public Float getCtmgAmtRt() {
        return ctmgAmtRt;
    }

    public void setCtmgAmtRt(Float ctmgAmtRt) {
        this.ctmgAmtRt = ctmgAmtRt;
    }

    public Long getIncstAmt() {
        return incstAmt;
    }

    public void setIncstAmt(Long incstAmt) {
        this.incstAmt = incstAmt;
    }

    public Long getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public Long getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(Long splyAmt) {
        this.splyAmt = splyAmt;
    }

    public Long getBuyCostAmt() {
        return buyCostAmt;
    }

    public void setBuyCostAmt(Long buyCostAmt) {
        this.buyCostAmt = buyCostAmt;
    }

    public Long getSvcBuyCostAmt() {
        return svcBuyCostAmt;
    }

    public void setSvcBuyCostAmt(Long svcBuyCostAmt) {
        this.svcBuyCostAmt = svcBuyCostAmt;
    }

    public Long getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(Long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public Long getMakeCostAmt() {
        return makeCostAmt;
    }

    public void setMakeCostAmt(Long makeCostAmt) {
        this.makeCostAmt = makeCostAmt;
    }

    public Long getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(Long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

}
