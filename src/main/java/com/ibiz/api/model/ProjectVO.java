package com.ibiz.api.model;

import java.util.List;

public class ProjectVO {

    /**
     * 프로젝트 아이디
     */
    private String prjtId;

    /**
     * 프로젝트 명
     */
    private String prjtNm;

    /**
     * 최종고객 ID
     */
    private String lastCustId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 주사업자고객 ID
     */
    private String mbsnCustId;

    /**
     * 주사업자고객명
     */
    private String mbsnCustNm;

    /**
     * 프로젝트 유형코드
     */
    private String prjtTypeCd;

    /**
     * 프로젝트 유형코드명
     */
    private String prjtTypeNm;
    /**
     * 사업중요도코드
     */
    private String bsnsDoiCd;
    /**
     * 사업중요도코드명
     */
    private String bsnsDoiNm;

    /**
     * 추진배경목적내용
     */
    private String puahBckgPposeCont;

    /**
     * 주요사업내용
     */
    private String prmryBsnsCont;

    /**
     * 당사사업영역내용
     */
    private String thofBsnsFldCont;

    /**
     * 고객요구사항
     */
    private String custDmdMtr;

    /**
     * 사업튻성내용
     */
    private String bsnsChrcCont;

    /**
     * 대응방안내용
     */
    private String copeSchmCont;

    /**
     * 사업예산금액
     */
    private String bsnsBdgtAmt;

    /**
     * 사업수행시작일자
     */
    private String bexcStartDate;

    /**
     * 사업수행종료일자
     */
    private String bexcEndDate;

    /**
     * 국가코드
     */
    private String ctryCd;

    /**
     * 국가명
     */
    private String ctryNm;
    /**
     * 화폐단위코드
     */
    private String crncUnitCd;
    /**
     * 화폐단위명
     */
    private String crncUnitNm;

    /**
     * 영업부서ID
     */
    private String slsDeptId;
    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 부서분류코드
     */
    private String orgDstCd;

    /**
     * 영업사원ID
     */
    private String slsEmpId;

    /**
     * 영업사원명
     */
    private String slsEmpNm;

    /**
     * 기타사항
     */
    private String etcMtr;

    /**
     * 프로젝트상태코드
     */
    private String prjtStatCd;
    /**
     * 프로젝트상태명
     */
    private String prjtStatNm;

    /**
     * warranty 기간 코드
     */
    private String wartPerdCd;

    /**
     * warranty 기간명
     */
    private String wartPerdNm;

    /**
     * 등록사원ID
     */
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
     * 변경사원 ID
     */
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
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 영업사원 직위명
     */
    private String ofpsCdNm;
    /**
     * 이슈제목
     */
    private String issueTitl;

    /**
     * 사업기회리스트
     */
    private List<BizOpportunityVO> bizOpportunityList;

    /**
     * 영업대표 이관을 위한 리스트
     */
    private List<ProjectVO> projectSlsTransferList;

    /**
     * 이슈발생기간 From
     */
    private String fromIssueOcrDate;

    /**
     * 이슈발생기간 To
     */
    private String toIssueOcrDate;

    /**
     * 영업부서명
     */
    private String deptNm;

    /**
     * 사업분류코드
     */
    private String bsnsClsfCd;

    /**
     * 이슈처리상태코드
     */
    private String issueDlngStatCd;

    private String fromRegDt;

    private String toRegDt;

    private String vrbPrgsStatCd;

    private String sessEmpId;

    private String totalCnt;

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

    public String getMbsnCustId() {
        return mbsnCustId;
    }

    public void setMbsnCustId(String mbsnCustId) {
        this.mbsnCustId = mbsnCustId;
    }

    public String getMbsnCustNm() {
        return mbsnCustNm;
    }

    public void setMbsnCustNm(String mbsnCustNm) {
        this.mbsnCustNm = mbsnCustNm;
    }

    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }

    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
    }

    public String getPrjtTypeNm() {
        return prjtTypeNm;
    }

    public void setPrjtTypeNm(String prjtTypeNm) {
        this.prjtTypeNm = prjtTypeNm;
    }

    public String getBsnsDoiCd() {
        return bsnsDoiCd;
    }

    public void setBsnsDoiCd(String bsnsDoiCd) {
        this.bsnsDoiCd = bsnsDoiCd;
    }

    public String getBsnsDoiNm() {
        return bsnsDoiNm;
    }

    public void setBsnsDoiNm(String bsnsDoiNm) {
        this.bsnsDoiNm = bsnsDoiNm;
    }

    public String getPuahBckgPposeCont() {
        return puahBckgPposeCont;
    }

    public void setPuahBckgPposeCont(String puahBckgPposeCont) {
        this.puahBckgPposeCont = puahBckgPposeCont;
    }

    public String getPrmryBsnsCont() {
        return prmryBsnsCont;
    }

    public void setPrmryBsnsCont(String prmryBsnsCont) {
        this.prmryBsnsCont = prmryBsnsCont;
    }

    public String getThofBsnsFldCont() {
        return thofBsnsFldCont;
    }

    public void setThofBsnsFldCont(String thofBsnsFldCont) {
        this.thofBsnsFldCont = thofBsnsFldCont;
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

    public String getBsnsBdgtAmt() {
        return bsnsBdgtAmt;
    }

    public void setBsnsBdgtAmt(String bsnsBdgtAmt) {
        this.bsnsBdgtAmt = bsnsBdgtAmt;
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

    public String getCtryCd() {
        return ctryCd;
    }

    public void setCtryCd(String ctryCd) {
        this.ctryCd = ctryCd;
    }

    public String getCtryNm() {
        return ctryNm;
    }

    public void setCtryNm(String ctryNm) {
        this.ctryNm = ctryNm;
    }

    public String getCrncUnitCd() {
        return crncUnitCd;
    }

    public void setCrncUnitCd(String crncUnitCd) {
        this.crncUnitCd = crncUnitCd;
    }

    public String getCrncUnitNm() {
        return crncUnitNm;
    }

    public void setCrncUnitNm(String crncUnitNm) {
        this.crncUnitNm = crncUnitNm;
    }

    public String getSlsDeptId() {
        return slsDeptId;
    }

    public void setSlsDeptId(String slsDeptId) {
        this.slsDeptId = slsDeptId;
    }

    public String getSlsDeptNm() {
        return slsDeptNm;
    }

    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
    }

    public String getOrgDstCd() {
        return orgDstCd;
    }

    public void setOrgDstCd(String orgDstCd) {
        this.orgDstCd = orgDstCd;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getEtcMtr() {
        return etcMtr;
    }

    public void setEtcMtr(String etcMtr) {
        this.etcMtr = etcMtr;
    }

    public String getPrjtStatCd() {
        return prjtStatCd;
    }

    public void setPrjtStatCd(String prjtStatCd) {
        this.prjtStatCd = prjtStatCd;
    }

    public String getPrjtStatNm() {
        return prjtStatNm;
    }

    public void setPrjtStatNm(String prjtStatNm) {
        this.prjtStatNm = prjtStatNm;
    }

    public String getWartPerdCd() {
        return wartPerdCd;
    }

    public void setWartPerdCd(String wartPerdCd) {
        this.wartPerdCd = wartPerdCd;
    }

    public String getWartPerdNm() {
        return wartPerdNm;
    }

    public void setWartPerdNm(String wartPerdNm) {
        this.wartPerdNm = wartPerdNm;
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

    public String getOfpsCdNm() {
        return ofpsCdNm;
    }

    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }

    public String getIssueTitl() {
        return issueTitl;
    }

    public void setIssueTitl(String issueTitl) {
        this.issueTitl = issueTitl;
    }

    public List<BizOpportunityVO> getBizOpportunityList() {
        return bizOpportunityList;
    }

    public void setBizOpportunityList(List<BizOpportunityVO> bizOpportunityList) {
        this.bizOpportunityList = bizOpportunityList;
    }

    public List<ProjectVO> getProjectSlsTransferList() {
        return projectSlsTransferList;
    }

    public void setProjectSlsTransferList(List<ProjectVO> projectSlsTransferList) {
        this.projectSlsTransferList = projectSlsTransferList;
    }

    public String getFromIssueOcrDate() {
        return fromIssueOcrDate;
    }

    public void setFromIssueOcrDate(String fromIssueOcrDate) {
        this.fromIssueOcrDate = fromIssueOcrDate;
    }

    public String getToIssueOcrDate() {
        return toIssueOcrDate;
    }

    public void setToIssueOcrDate(String toIssueOcrDate) {
        this.toIssueOcrDate = toIssueOcrDate;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getBsnsClsfCd() {
        return bsnsClsfCd;
    }

    public void setBsnsClsfCd(String bsnsClsfCd) {
        this.bsnsClsfCd = bsnsClsfCd;
    }

    public String getIssueDlngStatCd() {
        return issueDlngStatCd;
    }

    public void setIssueDlngStatCd(String issueDlngStatCd) {
        this.issueDlngStatCd = issueDlngStatCd;
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

    public String getVrbPrgsStatCd() {
        return vrbPrgsStatCd;
    }

    public void setVrbPrgsStatCd(String vrbPrgsStatCd) {
        this.vrbPrgsStatCd = vrbPrgsStatCd;
    }

    public String getSessEmpId() {
        return sessEmpId;
    }

    public void setSessEmpId(String sessEmpId) {
        this.sessEmpId = sessEmpId;
    }

    public String getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(String totalCnt) {
        this.totalCnt = totalCnt;
    }
}
