package com.ibiz.api.model;

public class FcstPalVO {

    /**
     * 예상손익 ID
     */
    private String fcstPalId;

    /**
     * 최종고객 ID
     */
    private String lastCustId;

    /**
     * 프로젝트 ID
     */
    private String prjtId;

    /**
     * 프로젝트 유형코드
     */
    private String prjtTypeCd;

    /**
     * 사업기회 ID
     */
    private String boptId;

    /**
     * 발주고객 ID
     */
    private String ordeCustId;

    /**
     * 계약이행 시작연월
     */
    private String cntrTrsfStartYam;

    /**
     * 계약이행 종료연월
     */
    private String cntrTrsfEndYam;

    /**
     * 기술서비스 검토사원 ID
     */
    private String techSvcRvwEmpId;

    /**
     * 이슈존재여부
     */
    private String issueExstYn;

    /**
     * VRB 선정결과코드
     */
    private String vrbSlctRstCd;

    /**
     * 부가세 금액
     */
    private Long vatAmt;

    /**
     * 계약특별내용
     */
    private String cntrSpclCont;

    /**
     * 기타사항
     */
    private String etcMtr;

    /**
     * 예상손익 진행상태코드
     */
    private String fcstPalPrgsStatCd;

    /**
     * 결재ID
     */
    private String santId;

    /**
     * 영업부서ID
     */
    private String slsDeptId;

    /**
     * 영업사원ID
     */
    private String slsEmpId;

    /**
     * 등록사원ID
     */
    private String regEmpId;

    /**
     * 변경사원ID
     */
    private String chgEmpId;

    /**
     * 변경일자
     */
    private String chgDt;

    /**
     * 등록일자
     */
    private String regDt;

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
     * 프로젝트유형명
     */
    private String prjtTypeCdNm;

    /**
     * 매출금액
     */
    private Long sellAmt;

    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 영업사원명
     */
    private String slsEmpNm;

    /**
     * 예상손익 진행상태명
     */
    private String fcstPalPrgsStatCdNm;

    private String santFrmtCd;

    private String custId;

    /**
     * 문서번호
     */
    private String docNo;

    /**
     * 전체 row 수
     */
    private Integer totalCnt;

    private String pageSearchType;

    /**
     * 승인날짜
     */
    private String santAppvDt;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getLastCustId() {
        return lastCustId;
    }

    public void setLastCustId(String lastCustId) {
        this.lastCustId = lastCustId;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
    }

    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }

    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
    }

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public String getOrdeCustId() {
        return ordeCustId;
    }

    public void setOrdeCustId(String ordeCustId) {
        this.ordeCustId = ordeCustId;
    }

    public String getCntrTrsfStartYam() {
        return cntrTrsfStartYam;
    }

    public void setCntrTrsfStartYam(String cntrTrsfStartYam) {
        this.cntrTrsfStartYam = cntrTrsfStartYam;
    }

    public String getCntrTrsfEndYam() {
        return cntrTrsfEndYam;
    }

    public void setCntrTrsfEndYam(String cntrTrsfEndYam) {
        this.cntrTrsfEndYam = cntrTrsfEndYam;
    }

    public String getIssueExstYn() {
        return issueExstYn;
    }

    public void setIssueExstYn(String issueExstYn) {
        this.issueExstYn = issueExstYn;
    }

    public String getVrbSlctRstCd() {
        return vrbSlctRstCd;
    }

    public void setVrbSlctRstCd(String vrbSlctRstCd) {
        this.vrbSlctRstCd = vrbSlctRstCd;
    }

    public Long getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(Long vatAmt) {
        this.vatAmt = vatAmt;
    }

    public String getCntrSpclCont() {
        return cntrSpclCont;
    }

    public void setCntrSpclCont(String cntrSpclCont) {
        this.cntrSpclCont = cntrSpclCont;
    }

    public String getEtcMtr() {
        return etcMtr;
    }

    public void setEtcMtr(String etcMtr) {
        this.etcMtr = etcMtr;
    }

    public String getFcstPalPrgsStatCdNmCd() {
        return fcstPalPrgsStatCd;
    }

    public void setFcstPalPrgsStatCdNmCd(String fcstPalPrgsStatCd) {
        this.fcstPalPrgsStatCd = fcstPalPrgsStatCd;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public String getSlsDeptId() {
        return slsDeptId;
    }

    public void setSlsDeptId(String slsDeptId) {
        this.slsDeptId = slsDeptId;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
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

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
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

    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }

    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
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

    public String getFcstPalPrgsStatCdNmNm() {
        return fcstPalPrgsStatCdNm;
    }

    public void setFcstPalPrgsStatCdNmNm(String fcstPalPrgsStatCdNm) {
        this.fcstPalPrgsStatCdNm = fcstPalPrgsStatCdNm;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getTechSvcRvwEmpId() {
        return techSvcRvwEmpId;
    }

    public void setTechSvcRvwEmpId(String techSvcRvwEmpId) {
        this.techSvcRvwEmpId = techSvcRvwEmpId;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getPageSearchType() {
        return pageSearchType;
    }

    public void setPageSearchType(String pageSearchType) {
        this.pageSearchType = pageSearchType;
    }

    public String getSantAppvDt() {
        return santAppvDt;
    }

    public void setSantAppvDt(String santAppvDt) {
        this.santAppvDt = santAppvDt;
    }
}
