package com.ibiz.api.model;
/**
 *
 * ACOM120T : 프로젝트직접경비코드
 *
 */
public class PrjtDrcstExpenseVO {

    /**
     * 프로젝트직접경비코드
     */
    private String prjtDrexpCd;

    /**
     * 유효시작일자
     */
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    private String avlEndDate;

    /**
     * 프로젝트직접경비명
     */
    private String prjtDrexpNm;

    /**
     * GL계정코드
     */
    private String glAcntCd;

    /**
     * 예산산출근거내용
     */
    private String bdgtCmptBssCont;

    /**
     * 예산산출기준내용
     */
    private String bdgtCmptCritCont;

    /**
     * 예산산출기준금액
     */
    private long bdgtCmptCritAmt;

    /**
     * 예산산출기준코드
     */
    private String bdgtCmptCritCd;

    /**
     * 예산산출적용수량
     */
    private double bdgtCmptAplcnQnt;

    /**
     * 실적배부기준코드
     */
    private String dstrCritRslItmCd;

    /**
     * 실적배부기준명
     */
    private String dstrCritRslItmNm;

    /**
     * 등록사원ID
     */
    private String regEmpId;

    /**
     * 등록일자
     */
    private String regDt;

    /**
     * 변경사원ID
     */
    private String chgEmpId;

    /**
     * 변경일자
     */
    private String chgDt;

    /**
     * 직접경비금액
     */
    private long drexpAmt;

    public String getPrjtDrexpCd() {
        return prjtDrexpCd;
    }

    public void setPrjtDrexpCd(String prjtDrexpCd) {
        this.prjtDrexpCd = prjtDrexpCd;
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

    public String getPrjtDrexpNm() {
        return prjtDrexpNm;
    }

    public void setPrjtDrexpNm(String prjtDrexpNm) {
        this.prjtDrexpNm = prjtDrexpNm;
    }

    public String getGlAcntCd() {
        return glAcntCd;
    }

    public void setGlAcntCd(String glAcntCd) {
        this.glAcntCd = glAcntCd;
    }

    public String getBdgtCmptCritCont() {
        return bdgtCmptCritCont;
    }

    public void setBdgtCmptCritCont(String bdgtCmptCritCont) {
        this.bdgtCmptCritCont = bdgtCmptCritCont;
    }

    public String getBdgtCmptCritCd() {
        return bdgtCmptCritCd;
    }

    public void setBdgtCmptCritCd(String bdgtCmptCritCd) {
        this.bdgtCmptCritCd = bdgtCmptCritCd;
    }

    public double getBdgtCmptAplcnQnt() {
        return bdgtCmptAplcnQnt;
    }

    public void setBdgtCmptAplcnQnt(double bdgtCmptAplcnQnt) {
        this.bdgtCmptAplcnQnt = bdgtCmptAplcnQnt;
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

    public String getDstrCritRslItmCd() {
        return dstrCritRslItmCd;
    }

    public void setDstrCritRslItmCd(String dstrCritRslItmCd) {
        this.dstrCritRslItmCd = dstrCritRslItmCd;
    }

    public String getDstrCritRslItmNm() {
        return dstrCritRslItmNm;
    }

    public void setDstrCritRslItmNm(String dstrCritRslItmNm) {
        this.dstrCritRslItmNm = dstrCritRslItmNm;
    }

    public long getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

    public String getBdgtCmptBssCont() {
        return bdgtCmptBssCont;
    }

    public void setBdgtCmptBssCont(String bdgtCmptBssCont) {
        this.bdgtCmptBssCont = bdgtCmptBssCont;
    }

    public long getBdgtCmptCritAmt() {
        return bdgtCmptCritAmt;
    }

    public void setBdgtCmptCritAmt(long bdgtCmptCritAmt) {
        this.bdgtCmptCritAmt = bdgtCmptCritAmt;
    }
}
