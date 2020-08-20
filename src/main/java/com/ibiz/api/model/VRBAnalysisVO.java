package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 *
 * BPIP100T : VRB기본
 *
 */

public class VRBAnalysisVO {

    /**
     * 예상손익 ID
     */
    private String fcstPalId;
    /**
     * VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 프로젝트ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 프로젝트ID는 10자리 이하여야합니다." )
    private String prjtId;

    /**
     * 프로젝트 검색 ID
     */
    private String prjtSearchId;

    /**
     * 프로젝트 명
     */
    private String prjtNm;

    /**
     * 최종고객 ID
     */
    private String lastCustId;

    /**
     * 최종고객 검색 ID
     */
    private String lastCustSearchId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트 유형코드명
     */
    private String prjtTypeCdNm;

    /**
     * 프로젝트상태명
     */
    private String prjtStatCdNm;

    /**
     * 사업수행시작일자
     */
    private String bexcStartDate;

    /**
     * 사업수행종료일자
     */
    private String bexcEndDate;

    /**
     * 시행일자
     */
    private String efcmDate;

    /**
     * 고객요구사항
     */
    private String custDmdMtr;

    /**
     * 사업특성내용
     */
    private String bsnsChrcCont;

    /**
     * 대응방안내용
     */
    private String copeSchmCont;

    /**
     * 업체선정방식내용
     */
    private String cmpySlctWayCont;

    /**
     * 업체평가방식내용
     */
    private String cmpyEvalWayCont;

    /**
     * 참여업체현황내용
     */
    private String prtcCmpyPrscdCont;

    /**
     * 영업부서ID
     */
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업부서ID는 8자리 이하여야합니다." )
    private String slsDeptId;

    /**
     * 영업사원명
     */
    private String slsEmpNm;

    /**
     * 영업사원부서명
     */
    private String slsDeptNm;

    /**
     * 영업사원ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업사원ID는 10자리 이하여야합니다." )
    private String slsEmpId;

    /**
     * 영업사원ID
     */
    private String slsEmpSearchId;

    /**
     * 영업사원ID
     */
    private String slsEmpInfo;


    /**
     * VRB심사결과코드
     */
    private String vrbUdwgRstCd;

    /**
     * VRB심사결과명
     */
    private String vrbUdwgRstCdNm;

    /**
     * VRB진행상태코드
     */
    private String vrbPrgsStatCd;

    /**
     * VRB진행상태명
     */
    private String vrbPrgsStatCdNm;

    /**
     * 결재ID
     */
    private String santId;

    /**
     * 등록사원ID
     */
    @Size(max=10, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 등록사원ID는 10자리 이하여야합니다." )
    private String regEmpId;

    /**
     * 등록사원명
     */
    private String regEmpNm;

    /**
     * 등록일시
     */
    private String regDt;

    /**
     * 변경사원ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 변경사원ID는 10자리 이하여야합니다." )
    private String chgEmpId;

    /**
     * 변경사원명
     */
    private String chgEmpNm;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 제조원가금액
     */
    private String makeCostAmt;

    /**
     * 페이지 구분
     */
    private String classification;

    /**
     * 프로젝트
     */
    private ProjectVO project;

    /**
     * VRB수익분석상세리스트
     */
    private List<VRBProfitVO> vrbProfitAnalysisDetailList;

    /**
     * VRB참여자상세리스트
     */
    private List<VRBOpinionVO> vrbParticipantList;

    /**
     * VRB고객분석내역리스트
     */
    private List<VRBCustomerVO> vrbCustomerAnalysisList;

    /**
     * VRB경쟁사분석내역리스트
     */
    private List<VRBCompetitorVO> vrbCompetitorAnalysisList;

    /**
     * VRB사업분석내역리스트
     */
    private List<VRBStrategyVO> vrbBusinessAnalysisList;

    /**
     * 사업기회리스트
     */
    private List<BizChanceVO> bizChanceList;

    /**
     * 영업활동리스트
     */
    private List<BizChanceActivityVO> salesActivityList;

    private List<ProfitValueAnalysisDetailVO> profitValueAnalysisDetailList;

    private ProfitValueAnalysisVO profitValueAnalysis;

    /**
     * 결재역할별 버튼 리스트
     */
    private List<Map<String, String>> roleButtonList;

    private ApprovalAuthorizerVO approvalDetail;

    private List<VRBBizChanceVO> vrbBizChanceList;

    private ApprovalVO approval;

    /**
     * 매출액(총)
     */
    private String splyAmt;

    /**
     * 순매출액
     */
    private String nsleAmt;

    /**
     * 공헌이익
     */
    private String ctmgAmt;

    /**
     * 투입인원
     */
    private String putNopCount;

    /**
     * 투입인원코드
     */
    private String putTimeUnitCd;

    /**
     * 투입인원코드명
     */
    private String putTimeUnitCdNm;

    private String sessEmpId;

    private String fromRegDt;

    private String toRegDt;

    /**
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 결재서식코드
     */
    private String santFrmtCd;

    /**
     * 서식코드
     */
    private String frmtCd;

    /**
     * 서식코드명
     */
    private String frmtCdNm;


    /**
     * 문서번호
     */
    private String docNo;

    /**
     * 문서제목
     */
    private String docTitl;

    /**
     * 윈도우팝업여부
     */
    private String winPopupCd;

    /**
     * 프린트팝업여부
     */
    private String winPrintCd;

    private Boolean isInProgress;

    private String santPrgsStatCd;

    /**
     * 전체사이즈
     */
    private Integer totalCnt;

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

    public String getVrbAnlyId() {
        return vrbAnlyId;
    }

    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
    }

    public String getPrjtSearchId() {
        return prjtSearchId;
    }

    public void setPrjtSearchId(String prjtSearchId) {
        this.prjtSearchId = prjtSearchId;
    }

    public String getPrjtNm() {
        return prjtNm;
    }

    public void setPrjtNm(String prjtNm) {
        this.prjtNm = prjtNm;
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

    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }

    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
    }

    public String getPrjtStatCdNm() {
        return prjtStatCdNm;
    }

    public void setPrjtStatCdNm(String prjtStatCdNm) {
        this.prjtStatCdNm = prjtStatCdNm;
    }

    public String getBexcStartDate() {
        return bexcStartDate;
    }

    public void setBexcStartDate(String bexcStartDate) {
        this.bexcStartDate = bexcStartDate;
    }

    public String getBexcEndDate() {
        return bexcEndDate;
    }

    public void setBexcEndDate(String bexcEndDate) {
        this.bexcEndDate = bexcEndDate;
    }

    public String getEfcmDate() {
        return efcmDate;
    }

    public void setEfcmDate(String efcmDate) {
        this.efcmDate = efcmDate;
    }

    public String getCustDmdMtr() {
        return custDmdMtr;
    }

    public void setCustDmdMtr(String custDmdMtr) {
        this.custDmdMtr = custDmdMtr;
    }

    public String getBsnsChrcCont() {
        return bsnsChrcCont;
    }

    public void setBsnsChrcCont(String bsnsChrcCont) {
        this.bsnsChrcCont = bsnsChrcCont;
    }

    public String getCopeSchmCont() {
        return copeSchmCont;
    }

    public void setCopeSchmCont(String copeSchmCont) {
        this.copeSchmCont = copeSchmCont;
    }

    public String getCmpySlctWayCont() {
        return cmpySlctWayCont;
    }

    public void setCmpySlctWayCont(String cmpySlctWayCont) {
        this.cmpySlctWayCont = cmpySlctWayCont;
    }

    public String getCmpyEvalWayCont() {
        return cmpyEvalWayCont;
    }

    public void setCmpyEvalWayCont(String cmpyEvalWayCont) {
        this.cmpyEvalWayCont = cmpyEvalWayCont;
    }

    public String getPrtcCmpyPrscdCont() {
        return prtcCmpyPrscdCont;
    }

    public void setPrtcCmpyPrscdCont(String prtcCmpyPrscdCont) {
        this.prtcCmpyPrscdCont = prtcCmpyPrscdCont;
    }

    public String getSlsDeptId() {
        return slsDeptId;
    }

    public void setSlsDeptId(String slsDeptId) {
        this.slsDeptId = slsDeptId;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getSlsDeptNm() {
        return slsDeptNm;
    }

    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public String getSlsEmpSearchId() {
        return slsEmpSearchId;
    }

    public void setSlsEmpSearchId(String slsEmpSearchId) {
        this.slsEmpSearchId = slsEmpSearchId;
    }

    public String getSlsEmpInfo() {
        return slsEmpInfo;
    }

    public void setSlsEmpInfo(String slsEmpInfo) {
        this.slsEmpInfo = slsEmpInfo;
    }

    public String getVrbUdwgRstCd() {
        return vrbUdwgRstCd;
    }

    public void setVrbUdwgRstCd(String vrbUdwgRstCd) {
        this.vrbUdwgRstCd = vrbUdwgRstCd;
    }

    public String getVrbUdwgRstCdNm() {
        return vrbUdwgRstCdNm;
    }

    public void setVrbUdwgRstCdNm(String vrbUdwgRstCdNm) {
        this.vrbUdwgRstCdNm = vrbUdwgRstCdNm;
    }

    public String getVrbPrgsStatCd() {
        return vrbPrgsStatCd;
    }

    public void setVrbPrgsStatCd(String vrbPrgsStatCd) {
        this.vrbPrgsStatCd = vrbPrgsStatCd;
    }

    public String getVrbPrgsStatCdNm() {
        return vrbPrgsStatCdNm;
    }

    public void setVrbPrgsStatCdNm(String vrbPrgsStatCdNm) {
        this.vrbPrgsStatCdNm = vrbPrgsStatCdNm;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
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

    public String getChgEmpNm() {
        return chgEmpNm;
    }

    public void setChgEmpNm(String chgEmpNm) {
        this.chgEmpNm = chgEmpNm;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

	/*public String getSumSplyUpcAmt() {
		return sumSplyUpcAmt;
	}

	public void setSumSplyUpcAmt(String sumSplyUpcAmt) {
		this.sumSplyUpcAmt = sumSplyUpcAmt;
	}

	public String getNetSplyUpcAmt() {
		return netSplyUpcAmt;
	}

	public void setNetSplyUpcAmt(String netSplyUpcAmt) {
		this.netSplyUpcAmt = netSplyUpcAmt;
	}

	public String getSumCtmgAmt() {
		return sumCtmgAmt;
	}

	public void setSumCtmgAmt(String sumCtmgAmt) {
		this.sumCtmgAmt = sumCtmgAmt;
	}

	public String getSumPutNopCount() {
		return sumPutNopCount;
	}

	public void setSumPutNopCount(String sumPutNopCount) {
		this.sumPutNopCount = sumPutNopCount;
	}*/

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public ProjectVO getProject() {
        return project;
    }

    public void setProject(ProjectVO project) {
        this.project = project;
    }

    public List<VRBProfitVO> getVrbProfitAnalysisDetailList() {
        return vrbProfitAnalysisDetailList;
    }

    public void setVrbProfitAnalysisDetailList(List<VRBProfitVO> vrbProfitAnalysisDetailList) {
        this.vrbProfitAnalysisDetailList = vrbProfitAnalysisDetailList;
    }

    public List<VRBOpinionVO> getVrbParticipantList() {
        return vrbParticipantList;
    }

    public void setVrbParticipantList(List<VRBOpinionVO> vrbParticipantList) {
        this.vrbParticipantList = vrbParticipantList;
    }

    public List<VRBCustomerVO> getVrbCustomerAnalysisList() {
        return vrbCustomerAnalysisList;
    }

    public void setVrbCustomerAnalysisList(List<VRBCustomerVO> vrbCustomerAnalysisList) {
        this.vrbCustomerAnalysisList = vrbCustomerAnalysisList;
    }

    public List<VRBCompetitorVO> getVrbCompetitorAnalysisList() {
        return vrbCompetitorAnalysisList;
    }

    public void setVrbCompetitorAnalysisList(List<VRBCompetitorVO> vrbCompetitorAnalysisList) {
        this.vrbCompetitorAnalysisList = vrbCompetitorAnalysisList;
    }

    public List<VRBStrategyVO> getVrbBusinessAnalysisList() {
        return vrbBusinessAnalysisList;
    }

    public void setVrbBusinessAnalysisList(List<VRBStrategyVO> vrbBusinessAnalysisList) {
        this.vrbBusinessAnalysisList = vrbBusinessAnalysisList;
    }

    public List<BizChanceVO> getBizChanceList() {
        return bizChanceList;
    }

    public void setBizChanceList(List<BizChanceVO> bizChanceList) {
        this.bizChanceList = bizChanceList;
    }

    public List<BizChanceActivityVO> getSalesActivityList() {
        return salesActivityList;
    }

    public void setSalesActivityList(List<BizChanceActivityVO> salesActivityList) {
        this.salesActivityList = salesActivityList;
    }

    public List<ProfitValueAnalysisDetailVO> getProfitValueAnalysisDetailList() {
        return profitValueAnalysisDetailList;
    }

    public void setProfitValueAnalysisDetailList(List<ProfitValueAnalysisDetailVO> profitValueAnalysisDetailList) {
        this.profitValueAnalysisDetailList = profitValueAnalysisDetailList;
    }

    public ProfitValueAnalysisVO getProfitValueAnalysis() {
        return profitValueAnalysis;
    }

    public void setProfitValueAnalysis(ProfitValueAnalysisVO profitValueAnalysis) {
        this.profitValueAnalysis = profitValueAnalysis;
    }

    public List<Map<String, String>> getRoleButtonList() {
        return roleButtonList;
    }

    public void setRoleButtonList(List<Map<String, String>> roleButtonList) {
        this.roleButtonList = roleButtonList;
    }

    public ApprovalAuthorizerVO getApprovalDetail() {
        return approvalDetail;
    }

    public void setApprovalDetail(ApprovalAuthorizerVO approvalDetail) {
        this.approvalDetail = approvalDetail;
    }

    public List<VRBBizChanceVO> getVrbBizChanceList() {
        return vrbBizChanceList;
    }

    public void setVrbBizChanceList(List<VRBBizChanceVO> vrbBizChanceList) {
        this.vrbBizChanceList = vrbBizChanceList;
    }

    public ApprovalVO getApproval() {
        return approval;
    }

    public void setApproval(ApprovalVO approval) {
        this.approval = approval;
    }

    public String getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(String splyAmt) {
        this.splyAmt = splyAmt;
    }

    public String getNsleAmt() {
        return nsleAmt;
    }

    public void setNsleAmt(String nsleAmt) {
        this.nsleAmt = nsleAmt;
    }

    public String getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(String ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }

    public String getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(String putNopCount) {
        this.putNopCount = putNopCount;
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

    public String getLastCustSearchId() {
        return lastCustSearchId;
    }

    public void setLastCustSearchId(String lastCustSearchId) {
        this.lastCustSearchId = lastCustSearchId;
    }

    public String getSessEmpId() {
        return sessEmpId;
    }

    public void setSessEmpId(String sessEmpId) {
        this.sessEmpId = sessEmpId;
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

    public String getRegEmpNm() {
        return regEmpNm;
    }

    public void setRegEmpNm(String regEmpNm) {
        this.regEmpNm = regEmpNm;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getMakeCostAmt() {
        return makeCostAmt;
    }

    public void setMakeCostAmt(String makeCostAmt) {
        this.makeCostAmt = makeCostAmt;
    }

    public Boolean getIsInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(Boolean isInProgress) {
        this.isInProgress = isInProgress;
    }

    public String getSantPrgsStatCd() {
        return santPrgsStatCd;
    }

    public void setSantPrgsStatCd(String santPrgsStatCd) {
        this.santPrgsStatCd = santPrgsStatCd;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getDocTitl() {
        return docTitl;
    }

    public void setDocTitl(String docTitl) {
        this.docTitl = docTitl;
    }

    public String getFrmtCd() {
        return frmtCd;
    }

    public void setFrmtCd(String frmtCd) {
        this.frmtCd = frmtCd;
    }

    public String getFrmtCdNm() {
        return frmtCdNm;
    }

    public void setFrmtCdNm(String frmtCdNm) {
        this.frmtCdNm = frmtCdNm;
    }
}
