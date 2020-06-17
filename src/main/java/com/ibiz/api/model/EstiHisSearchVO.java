package com.ibiz.api.model;

public class EstiHisSearchVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;
    /**
     * 최종고객ID
     */
    private String lastCustId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트 ID
     */
    private String prjtId;
    /**
     * 프로젝트명
     */
    private String prjtNm;

    /**
     * 발주고객ID
     */
    private String ordeCustId;

    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 등록기간 시작일자
     */
    private String estiWrtStartDate;

    /**
     * 등록기간 종료일자
     */
    private String estiWrtEndDate;

    /**
     * 영업부서 ID
     */
    private String slsDeptId;

    /**
     * 영업대표 사원 ID
     */
    private String slsEmpId;

    /**
     * 프로젝트 유형 코드
     */
    private String prjtTypeCd;

    /**
     * 견적상태코드
     */
    private String estisStatCd;
    /**
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 결재ID
     */
    private String santId;

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

    public String getLastCustNm() {
        return lastCustNm;
    }

    public void setLastCustNm(String lastCustNm) {
        this.lastCustNm = lastCustNm;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
    }

    public String getPrjtNm() {
        return prjtNm;
    }

    public void setPrjtNm(String prjtNm) {
        this.prjtNm = prjtNm;
    }

    public String getOrdeCustId() {
        return ordeCustId;
    }

    public void setOrdeCustId(String ordeCustId) {
        this.ordeCustId = ordeCustId;
    }

    public String getOrdeCustNm() {
        return ordeCustNm;
    }

    public void setOrdeCustNm(String ordeCustNm) {
        this.ordeCustNm = ordeCustNm;
    }

    public String getEstiWrtStartDate() {
        return estiWrtStartDate;
    }

    public void setEstiWrtStartDate(String estiWrtStartDate) {
        this.estiWrtStartDate = estiWrtStartDate;
    }

    public String getEstiWrtEndDate() {
        return estiWrtEndDate;
    }

    public void setEstiWrtEndDate(String estiWrtEndDate) {
        this.estiWrtEndDate = estiWrtEndDate;
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

    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }

    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
    }

    public String getEstisStatCd() {
        return estisStatCd;
    }

    public void setEstisStatCd(String estisStatCd) {
        this.estisStatCd = estisStatCd;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    @Override
    public String toString() {
        return "EstiHisSearchVO [fcstPalId=" + fcstPalId + ", lastCustId=" + lastCustId + ", lastCustNm=" + lastCustNm
                + ", prjtId=" + prjtId + ", prjtNm=" + prjtNm + ", ordeCustId=" + ordeCustId + ", ordeCustNm="
                + ordeCustNm + ", estiWrtStartDate=" + estiWrtStartDate + ", estiWrtEndDate=" + estiWrtEndDate
                + ", slsDeptId=" + slsDeptId + ", slsEmpId=" + slsEmpId + ", prjtTypeCd=" + prjtTypeCd
                + ", estisStatCd=" + estisStatCd + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", santId="
                + santId + "]";
    }

}