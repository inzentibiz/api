package com.ibiz.api.model;

public class OfferProfitSearchVO {

    /**
     * 최종고객 ID
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
     * 발주고객 ID
     */
    private String ordeCustId;
    /**
     * 발주고객명
     */
    private String ordeCustNm;
    /**
     * 등록기간 시작일
     */
    private String regStartDate;

    /**
     * 등록기간 종료일
     */
    private String regEndDate;

    /**
     * 영업부서ID
     */
    private String slsDeptId;

    /**
     * 영업대표 ID
     */
    private String slsEmpId;

    /**
     * 영업대표명
     */
    private String slsEmpNm;
    /**
     * 프로젝트 타입 코드
     */
    private String prjtTypeCd;

    /**
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 영업사원 정보
     */
    private String slsEmpInfo;

    /**
     * 견적 상태 코드
     */
    private String fcstPalPrgsStatCd;

    private String fromRegDt;

    private String toRegDt;

    private String sessEmpId;

    private String santId;

    // 복제여부
    private String isCopy;

    ////////// 결재목록에서 진입할 경우..필요한 프로퍼티 //////////

    /**
     * 상신일자 검색 시작일
     */
    private String submitStartDate;

    /**
     * 상신일자 검색 종료일
     */
    private String submitEndDate;

    /**
     * 문서 제목 검색
     */
    private String docTitl;

    /**
     * 결재 상태 코드 검색
     */
    private String submitStatusCd;

    /**
     * 문서 종류 코드
     */
    private String santFrmtCd;

    /**
     * 문서 종류 코드 검색 코드
     */
    private String santFrmtSearchCd;

    /**
     * 문서 승인 상태 검색
     */
    private String santPrgsStatCd;

    /**
     * 수신구분여부
     */
    private String santRcvStatCd;
    /**
     * 결재자명 검색
     */
    private String reporterName;

    /**
     * 결재변경할 사원의 아이디
     */
    private String searchChgEmpId;

    /**
     *사원 아이디
     */
    private String empId;

    /**
     * 상신자
     */
    private String regEmpId;

    /**
     * 상신자 명
     */
    private String regEmpNm;

    /**
     * 결재 승인 상태
     */
    private String santAppvDstCd;

    /**
     * 결재구분 코드
     */
    private String aprnRoleCd;

    /**
     * 상신일자-From
     */
    private String rtosSantFromDt;

    /**
     * 상신일자-To
     */
    private String rtosSantToDt;

    /**
     * 상신자ID
     */
    private String rtosEmpId;

    /**
     * 상신자명
     */
    private String rtosEmpAprnNm;

    private String regPos;

    /**
     * 윈도우팝업여부
     */
    private String winPopupCd;

    /**
     * 프린트팝업여부
     */
    private String winPrintCd;

    /**
     * 문서번호
     */
    private String docNo;

    private String pageSearchType;

    /**
     * 변경전 손익ID
     */
    private String befFcstPalId;

    // 사업분류코드
    private String bsnsClsfCd;

    // 제품분류코드
    private String godsClsfCd;

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
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

    public String getRegStartDate() {
        return regStartDate;
    }

    public void setRegStartDate(String regStartDate) {
        this.regStartDate = regStartDate;
    }

    public String getRegEndDate() {
        return regEndDate;
    }

    public void setRegEndDate(String regEndDate) {
        this.regEndDate = regEndDate;
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

    public String getFcstPalPrgsStatCdNm() {
        return fcstPalPrgsStatCd;
    }

    public void setFcstPalPrgsStatCdNm(String fcstPalPrgsStatCd) {
        this.fcstPalPrgsStatCd = fcstPalPrgsStatCd;
    }

    public String getFromRegDt() {
        return fromRegDt;
    }

    public void setFromRegDt(String fromRegDt) {
        this.fromRegDt = fromRegDt;
    }

    public String getToRegDt() {
        return toRegDt;
    }

    public void setToRegDt(String toRegDt) {
        this.toRegDt = toRegDt;
    }

    public String getSessEmpId() {
        return sessEmpId;
    }

    public void setSessEmpId(String sessEmpId) {
        this.sessEmpId = sessEmpId;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getSlsEmpInfo() {
        return slsEmpInfo;
    }

    public void setSlsEmpInfo(String slsEmpInfo) {
        this.slsEmpInfo = slsEmpInfo;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public String getIsCopy() {
        return isCopy;
    }

    public void setIsCopy(String isCopy) {
        this.isCopy = isCopy;
    }

    public String getSubmitStartDate() {
        return submitStartDate;
    }

    public void setSubmitStartDate(String submitStartDate) {
        this.submitStartDate = submitStartDate;
    }

    public String getSubmitEndDate() {
        return submitEndDate;
    }

    public void setSubmitEndDate(String submitEndDate) {
        this.submitEndDate = submitEndDate;
    }

    public String getDocTitl() {
        return docTitl;
    }

    public void setDocTitl(String docTitl) {
        this.docTitl = docTitl;
    }

    public String getSubmitStatusCd() {
        return submitStatusCd;
    }

    public void setSubmitStatusCd(String submitStatusCd) {
        this.submitStatusCd = submitStatusCd;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getSantFrmtSearchCd() {
        return santFrmtSearchCd;
    }

    public void setSantFrmtSearchCd(String santFrmtSearchCd) {
        this.santFrmtSearchCd = santFrmtSearchCd;
    }

    public String getSantPrgsStatCd() {
        return santPrgsStatCd;
    }

    public void setSantPrgsStatCd(String santPrgsStatCd) {
        this.santPrgsStatCd = santPrgsStatCd;
    }

    public String getSantRcvStatCd() {
        return santRcvStatCd;
    }

    public void setSantRcvStatCd(String santRcvStatCd) {
        this.santRcvStatCd = santRcvStatCd;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getSearchChgEmpId() {
        return searchChgEmpId;
    }

    public void setSearchChgEmpId(String searchChgEmpId) {
        this.searchChgEmpId = searchChgEmpId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public String getRegEmpNm() {
        return regEmpNm;
    }

    public void setRegEmpNm(String regEmpNm) {
        this.regEmpNm = regEmpNm;
    }

    public String getSantAppvDstCd() {
        return santAppvDstCd;
    }

    public void setSantAppvDstCd(String santAppvDstCd) {
        this.santAppvDstCd = santAppvDstCd;
    }

    public String getAprnRoleCd() {
        return aprnRoleCd;
    }

    public void setAprnRoleCd(String aprnRoleCd) {
        this.aprnRoleCd = aprnRoleCd;
    }

    public String getRtosSantFromDt() {
        return rtosSantFromDt;
    }

    public void setRtosSantFromDt(String rtosSantFromDt) {
        this.rtosSantFromDt = rtosSantFromDt;
    }

    public String getRtosSantToDt() {
        return rtosSantToDt;
    }

    public void setRtosSantToDt(String rtosSantToDt) {
        this.rtosSantToDt = rtosSantToDt;
    }

    public String getRtosEmpId() {
        return rtosEmpId;
    }

    public void setRtosEmpId(String rtosEmpId) {
        this.rtosEmpId = rtosEmpId;
    }

    public String getRtosEmpAprnNm() {
        return rtosEmpAprnNm;
    }

    public void setRtosEmpAprnNm(String rtosEmpAprnNm) {
        this.rtosEmpAprnNm = rtosEmpAprnNm;
    }

    public String getRegPos() {
        return regPos;
    }

    public void setRegPos(String regPos) {
        this.regPos = regPos;
    }

    public String getWinPopupCd() {
        return winPopupCd;
    }

    public void setWinPopupCd(String winPopupCd) {
        this.winPopupCd = winPopupCd;
    }

    public String getWinPrintCd() {
        return winPrintCd;
    }

    public void setWinPrintCd(String winPrintCd) {
        this.winPrintCd = winPrintCd;
    }

    public String getPageSearchType() {
        return pageSearchType;
    }

    public void setPageSearchType(String pageSearchType) {
        this.pageSearchType = pageSearchType;
    }

    public String getBefFcstPalId() {
        return befFcstPalId;
    }

    public void setBefFcstPalId(String befFcstPalId) {
        this.befFcstPalId = befFcstPalId;
    }

    public String getBsnsClsfCd() {
        return bsnsClsfCd;
    }

    public void setBsnsClsfCd(String bsnsClsfCd) {
        this.bsnsClsfCd = bsnsClsfCd;
    }

    public String getGodsClsfCd() {
        return godsClsfCd;
    }

    public void setGodsClsfCd(String godsClsfCd) {
        this.godsClsfCd = godsClsfCd;
    }
}
