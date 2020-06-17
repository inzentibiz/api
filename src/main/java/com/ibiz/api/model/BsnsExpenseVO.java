package com.ibiz.api.model;

/**
 *
 * BEST050T : 사업예상직접경비상세
 *
 */

public class BsnsExpenseVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * GL계정코드
     */
    private String glAcntCd;

    /**
     * GL계정명
     */
    private String glAcntNm;


    /**
     * 직접비금액
     */
    private Long drcstAmt;


    /**
     * 예상손익직접비명
     */
    private String fcstPalDrcstNm;

    /**
     * 비용구분
     */
    private String expDst;

    /**
     * 전사 공통기준
     */
    private String entpzCmnCrit;

    // 201911상품변경
    /**
     * 직접경비금액
     */
    private long drexpAmt;

    /**
     * 프로젝트직접경비코드
     */
    private String prjtDrexpCd;

    /**
     * 프로젝트직접경비명
     */
    private String prjtDrexpNm;

    /**
     * 예산산출기준내용
     */
    private String bdgtCmptCritCont;

    /**
     * 예산산출기준금액
     */
    private long bdgtCmptCritAmt;

    /**
     * 예산산출근거내용
     */
    private String bdgtCmptBssCont;

    /**
     * 예산산출적용수량
     */
    private double bdgtCmptAplcnQnt;

    /**
     * 예산산출기준코드
     */
    private String bdgtCmptCritCd;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getGlAcntCd() {
        return glAcntCd;
    }

    public void setGlAcntCd(String glAcntCd) {
        this.glAcntCd = glAcntCd;
    }

    public String getGlAcntNm() {
        return glAcntNm;
    }

    public void setGlAcntNm(String glAcntNm) {
        this.glAcntNm = glAcntNm;
    }

    public Long getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(Long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public String getFcstPalDrcstNm() {
        return fcstPalDrcstNm;
    }

    public void setFcstPalDrcstNm(String fcstPalDrcstNm) {
        this.fcstPalDrcstNm = fcstPalDrcstNm;
    }

    public String getExpDst() {
        return expDst;
    }

    public void setExpDst(String expDst) {
        this.expDst = expDst;
    }

    public String getEntpzCmnCrit() {
        return entpzCmnCrit;
    }

    public void setEntpzCmnCrit(String entpzCmnCrit) {
        this.entpzCmnCrit = entpzCmnCrit;
    }

    public long getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

    public String getPrjtDrexpCd() {
        return prjtDrexpCd;
    }

    public void setPrjtDrexpCd(String prjtDrexpCd) {
        this.prjtDrexpCd = prjtDrexpCd;
    }

    public String getPrjtDrexpNm() {
        return prjtDrexpNm;
    }

    public void setPrjtDrexpNm(String prjtDrexpNm) {
        this.prjtDrexpNm = prjtDrexpNm;
    }

    public String getBdgtCmptCritCont() {
        return bdgtCmptCritCont;
    }

    public void setBdgtCmptCritCont(String bdgtCmptCritCont) {
        this.bdgtCmptCritCont = bdgtCmptCritCont;
    }

    public long getBdgtCmptCritAmt() {
        return bdgtCmptCritAmt;
    }

    public void setBdgtCmptCritAmt(long bdgtCmptCritAmt) {
        this.bdgtCmptCritAmt = bdgtCmptCritAmt;
    }

    public String getBdgtCmptBssCont() {
        return bdgtCmptBssCont;
    }

    public void setBdgtCmptBssCont(String bdgtCmptBssCont) {
        this.bdgtCmptBssCont = bdgtCmptBssCont;
    }

    public double getBdgtCmptAplcnQnt() {
        return bdgtCmptAplcnQnt;
    }

    public void setBdgtCmptAplcnQnt(double bdgtCmptAplcnQnt) {
        this.bdgtCmptAplcnQnt = bdgtCmptAplcnQnt;
    }

    public String getBdgtCmptCritCd() {
        return bdgtCmptCritCd;
    }

    public void setBdgtCmptCritCd(String bdgtCmptCritCd) {
        this.bdgtCmptCritCd = bdgtCmptCritCd;
    }
}
