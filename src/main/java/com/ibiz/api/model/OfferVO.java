package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 *
 * BEST000T : 사업예상손익기본
 *
 */
public class OfferVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    // 201911상품변경
    /**
     * 서식코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 서식코드는 4자리 이하여야합니다." )
    private String frmtCd;

    /**
     * 서식코드명
     */
    private String frmtCdNm;

    /**
     * 최종고객ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 최종고객ID는 10자리 이하여야합니다." )
    private String lastCustId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 프로젝트ID는 10자리 이하여야합니다." )
    private String prjtId;

    /**
     * 프로젝트명
     */
    private String prjtNm;

    /**
     * 프로젝트유형코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 프로젝트유형코드는 4자리 이하여야합니다." )
    private String prjtTypeCd;

    /**
     * 프로젝트유형코드명
     */
    private String prjtTypeCdNm;

    /**
     * 사업기회ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업기회ID는 10자리 이하여야합니다." )
    private String boptId;

    /**
     * 사업기회명
     */
    private String boptNm;

    /**
     * 사업기회상태명
     */
    private String boptStatCdNm;

    /**
     * 발주고객ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 발주고객ID는 10자리 이하여야합니다." )
    private String ordeCustId;

    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 계약이행시작연월
     */
    @Size(max=6, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 계약이행시작연월은 6자리 이하여야합니다." )
    private String cntrTrsfStartYam;

    /**
     * 계약이행종료연월
     */
    @Size(max=6, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 계약이행종료연월은 6자리 이하여야합니다." )
    private String cntrTrsfEndYam;

    /**
     * 기술서비스검토사원ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 기술서비스검토사원ID는 10자리 이하여야합니다." )
    private String techSvcRvwEmpId;

    /**
     * 기술서비스검토사원명
     */
    private String techSvcRvwEmpNm;

    /**
     * 기술서비스검토부서ID
     */
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 기술서비스검토부서ID는 8자리 이하여야합니다." )
    private String techSvcRvwDeptId;

    /**
     * 기술서비스검토부서명
     */
    private String techSvcRvwDeptNm;

    /**
     * 이슈존재여부
     */
    private String issueExstYn;

    /**
     * VRB선정결과코드
     */
    private String vrbSlctRstCd;

    /**
     * VRB선정결과코드명
     */
    private String vrbSlctRstCdNm;

    /**
     * 매출금액
     */
    @Digits(integer=15,fraction=0)
    private Long sellAmt;

    /**
     * 계약특별내용
     */
    private String cntrSpclCont;

    /**
     * 사업기회내용
     */
    private String spclCont;
    /**
     * 기타사항
     */
    private String etcMtr;

    /**
     * 예상손익진행상태코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 예상손익진행상태코드는 4자리 이하여야합니다." )
    private String fcstPalPrgsStatCd;

    /**
     * 예상손익진행상태코드명
     */
    private String fcstPalPrgsStatCdNm;

    /**
     * 결재ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 결재ID는 10자리 이하여야합니다." )
    private String santId;

    /**
     * 영업부서ID
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업부서ID는 8자리 이하여야합니다." )
    private String slsDeptId;

    private String slsDeptNm;

    /**
     * 영업사원ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업사원ID는 10자리 이하여야합니다." )
    private String slsEmpId;

    private String slsEmpNm;

    private String slsOfpsCdNm;


    /**
     * 등록사원ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 등록사원ID는 10자리 이하여야합니다." )
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
     * VRB선정기준
     */
    private List<VRBSelectCriteriaVO> vrbCriteriaList;

    /**
     * VRB분석리스트
     */
    private List<VRBAnalysisVO> vrbProfitAnalysisList;

    /**
     * 사업예상상품상세
     */
    private List<OfferProductVO> bsnsProdDetailList;

    /**
     * 견적제품할인정책리스트
     */
    private List<OfferProductDCVO> prodDcPolicyList;

    /**
     * 예상투입인원상세리스트
     */
    private List<OfferProductVO> inputPersonList;

    /**
     * 프로젝트경비리스트
     */
    private List<OfferExpenseVO> bsnsExpenseList;

    /**
     * 프로젝트경비리스트(ACOM120T)
     */
    private List<DirectCostCriteriaVO> prjtDrcstExpenseList;

    /**
     * 사업예상간접비리스트
     */
    /*private List<IncstExpenseVO> incstExpenseList;*/

    /**
     * 유지보수대상사업상세리스트
     */
    private List<OfferProductVO> maBsnsDetailList;

    /**
     * 유지보수제공조건상세리스트
     */
    private List<OfferMACondVO> maConditionList;

    /**
     * 결재역할별 버튼 리스트
     */
    private List<Map<String, String>> roleButtonList;

    /**
     * 결재순번에 따른 버튼 리스트
     */
    private List<Map<String, String>> approvalButtonList;
    /**
     * 직위명
     */
    private String techSvcRvwOfpsNm;

    private ApprovalVO approval;

    /**
     * 문서번호
     */
    private String docNo;

    /**
     * 문서제목
     */
    private String docTitl;

    /**
     * 문서타입코드
     */
    private String docTypeCd;

    /**
     * 결재서식코드(결재 문서제목을 위한..)
     */
    private String santFrmtCd;

    /**
     * 결재 버튼 활성화 여부 ( 결재공통모듈 체크시 넘겨야할 프로퍼티 )
     */
    private Boolean isInProgress;

    /**
     *  계약옵션
     */
    private List<OfferContractCondVO> contractOptionList;

    /**
     * 에상손익 실적(취합)
     */
    private List<OfferResultVO> bsnsRslSmryList;

    /**
     * 에상손익 쿼리 조회시 사용될 분기값
     */
    private String svcSearchType;

    /**
     * 변경전 예상손익ID
     */
    private String befFcstPalId;

    /**
     * 승인일자
     */
    private String santAppvDt;

    /**
     * 전체 row수
     */
    private Integer totalCnt;

    private String santPrgsStatCd;

    /**
     * 매출금액 총합
     */
    private long sumSellAmt;

    /**
     * 사업기회 별 총매출액
     */
    private long sumBuyAmt;

    /**
     * 공헌이익
     */
    private long ctmgAmt;

    /**
     * 사업기회 별 총투입MM
     */
    private float sumPutNopCount;

    /**
     * 투입 단위
     */
    private String putTimeUnitCd;

    // 수익보고 매칭 리스트
    private List<ProfitReportVO> profitReportList;

    // 결재서식 진행상태 업데이트 url (수익변경보고)
    private String prgsStatUrl;

    // 수익보고 내자
    private long exptTurnKeyAmt;

    // 수익보고 외주비(Turn-key)
    private long turnKeyAmt;

    // 파일첨부ID
    private String fileAttcId;

    // 파일첨부리스트
    private List<AttachVO> fileAttcList;

    public String getFrmtCdNm() {
        return frmtCdNm;
    }

    public void setFrmtCdNm(String frmtCdNm) {
        this.frmtCdNm = frmtCdNm;
    }

    public Boolean getIsInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(Boolean isInProgress) {
        this.isInProgress = isInProgress;
    }

    public String getFrmtCd() {
        return frmtCd;
    }

    public void setFrmtCd(String frmtCd) {
        this.frmtCd = frmtCd;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

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

    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }

    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
    }

    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }

    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
    }

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public String getBoptNm() {
        return boptNm;
    }

    public void setBoptNm(String boptNm) {
        this.boptNm = boptNm;
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

    public String getVrbSlctRstCdNm() {
        return vrbSlctRstCdNm;
    }

    public void setVrbSlctRstCdNm(String vrbSlctRstCdNm) {
        this.vrbSlctRstCdNm = vrbSlctRstCdNm;
    }

    public Long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
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

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
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

    public List<VRBSelectCriteriaVO> getVrbCriteriaList() {
        return vrbCriteriaList;
    }

    public void setVrbCriteriaList(List<VRBSelectCriteriaVO> vrbCriteriaList) {
        this.vrbCriteriaList = vrbCriteriaList;
    }

    public List<VRBAnalysisVO> getVrbProfitAnalysisList() {
        return vrbProfitAnalysisList;
    }

    public void setVrbProfitAnalysisList(List<VRBAnalysisVO> vrbProfitAnalysisList) {
        this.vrbProfitAnalysisList = vrbProfitAnalysisList;
    }

    public List<OfferProductVO> getBsnsProdDetailList() {
        return bsnsProdDetailList;
    }

    public void setBsnsProdDetailList(List<OfferProductVO> bsnsProdDetailList) {
        this.bsnsProdDetailList = bsnsProdDetailList;
    }

    public List<OfferProductDCVO> getProdDcPolicyList() {
        return prodDcPolicyList;
    }

    public void setProdDcPolicyList(List<OfferProductDCVO> prodDcPolicyList) {
        this.prodDcPolicyList = prodDcPolicyList;
    }

    public List<OfferProductVO> getInputPersonList() {
        return inputPersonList;
    }

    public void setInputPersonList(List<OfferProductVO> inputPersonList) {
        this.inputPersonList = inputPersonList;
    }

    public List<OfferExpenseVO> getBsnsExpenseList() {
        return bsnsExpenseList;
    }

    public void setBsnsExpenseList(List<OfferExpenseVO> bsnsExpenseList) {
        this.bsnsExpenseList = bsnsExpenseList;
    }

    /*public List<IncstExpenseVO> getIncstExpenseList() {
        return incstExpenseList;
    }

    public void setIncstExpenseList(List<IncstExpenseVO> incstExpenseList) {
        this.incstExpenseList = incstExpenseList;
    }

    public List<MaBsnsDetailVO> getMaBsnsDetailList() {
        return maBsnsDetailList;
    }

    public void setMaBsnsDetailList(List<MaBsnsDetailVO> maBsnsDetailList) {
        this.maBsnsDetailList = maBsnsDetailList;
    }
*/
    public List<OfferMACondVO> getMaConditionList() {
        return maConditionList;
    }

    public void setMaConditionList(List<OfferMACondVO> maConditionList) {
        this.maConditionList = maConditionList;
    }

    public List<Map<String, String>> getRoleButtonList() {
        return roleButtonList;
    }

    public void setRoleButtonList(List<Map<String, String>> roleButtonList) {
        this.roleButtonList = roleButtonList;
    }

    public String getTechSvcRvwEmpId() {
        return techSvcRvwEmpId;
    }

    public void setTechSvcRvwEmpId(String techSvcRvwEmpId) {
        this.techSvcRvwEmpId = techSvcRvwEmpId;
    }

    public String getTechSvcRvwEmpNm() {
        return techSvcRvwEmpNm;
    }

    public void setTechSvcRvwEmpNm(String techSvcRvwEmpNm) {
        this.techSvcRvwEmpNm = techSvcRvwEmpNm;
    }

    public String getTechSvcRvwDeptNm() {
        return techSvcRvwDeptNm;
    }

    public void setTechSvcRvwDeptNm(String techSvcRvwDeptNm) {
        this.techSvcRvwDeptNm = techSvcRvwDeptNm;
    }

    public String getSlsOfpsCdNm() {
        return slsOfpsCdNm;
    }

    public void setSlsOfpsCdNm(String slsOfpsCdNm) {
        this.slsOfpsCdNm = slsOfpsCdNm;
    }

    public String getTechSvcRvwOfpsNm() {
        return techSvcRvwOfpsNm;
    }

    public void setTechSvcRvwOfpsNm(String techSvcRvwOfpsNm) {
        this.techSvcRvwOfpsNm = techSvcRvwOfpsNm;
    }

    public ApprovalVO getApproval() {
        return approval;
    }

    public void setApproval(ApprovalVO approval) {
        this.approval = approval;
    }

    public List<Map<String, String>> getApprovalButtonList() {
        return approvalButtonList;
    }

    public void setApprovalButtonList(List<Map<String, String>> approvalButtonList) {
        this.approvalButtonList = approvalButtonList;
    }

    public String getRegEmpNm() {
        return regEmpNm;
    }

    public void setRegEmpNm(String regEmpNm) {
        this.regEmpNm = regEmpNm;
    }

    public String getChgEmpNm() {
        return chgEmpNm;
    }

    public void setChgEmpNm(String chgEmpNm) {
        this.chgEmpNm = chgEmpNm;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocTypeCd() {
        return docTypeCd;
    }

    public void setDocTypeCd(String docTypeCd) {
        this.docTypeCd = docTypeCd;
    }

    public String getBoptStatCdNm() {
        return boptStatCdNm;
    }

    public void setBoptStatCdNm(String boptStatCdNm) {
        this.boptStatCdNm = boptStatCdNm;
    }

    public List<OfferContractCondVO> getContractOptionList() {
        return contractOptionList;
    }

    public void setContractOptionList(List<OfferContractCondVO> contractOptionList) {
        this.contractOptionList = contractOptionList;
    }

    public List<OfferProductVO> getMaBsnsDetailList() {
        return maBsnsDetailList;
    }

    public void setMaBsnsDetailList(List<OfferProductVO> maBsnsDetailList) {
        this.maBsnsDetailList = maBsnsDetailList;
    }

    public List<OfferResultVO> getBsnsRslSmryList() {
        return bsnsRslSmryList;
    }

    public void setBsnsRslSmryList(List<OfferResultVO> bsnsRslSmryList) {
        this.bsnsRslSmryList = bsnsRslSmryList;
    }

    public String getTechSvcRvwDeptId() {
        return techSvcRvwDeptId;
    }

    public void setTechSvcRvwDeptId(String techSvcRvwDeptId) {
        this.techSvcRvwDeptId = techSvcRvwDeptId;
    }

    public String getSvcSearchType() {
        return svcSearchType;
    }

    public void setSvcSearchType(String svcSearchType) {
        this.svcSearchType = svcSearchType;
    }

    public List<DirectCostCriteriaVO> getPrjtDrcstExpenseList() {
        return prjtDrcstExpenseList;
    }

    public void setPrjtDrcstExpenseList(List<DirectCostCriteriaVO> prjtDrcstExpenseList) {
        this.prjtDrcstExpenseList = prjtDrcstExpenseList;
    }

    public String getSpclCont() {
        return spclCont;
    }

    public void setSpclCont(String spclCont) {
        this.spclCont = spclCont;
    }

    public String getBefFcstPalId() {
        return befFcstPalId;
    }

    public void setBefFcstPalId(String befFcstPalId) {
        this.befFcstPalId = befFcstPalId;
    }

    public String getSantAppvDt() {
        return santAppvDt;
    }

    public void setSantAppvDt(String santAppvDt) {
        this.santAppvDt = santAppvDt;
    }

    public String getFcstPalPrgsStatCd() {
        return fcstPalPrgsStatCd;
    }

    public void setFcstPalPrgsStatCd(String fcstPalPrgsStatCd) {
        this.fcstPalPrgsStatCd = fcstPalPrgsStatCd;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getFcstPalPrgsStatCdNm() {
        return fcstPalPrgsStatCdNm;
    }

    public void setFcstPalPrgsStatCdNm(String fcstPalPrgsStatCdNm) {
        this.fcstPalPrgsStatCdNm = fcstPalPrgsStatCdNm;
    }

    public Boolean getInProgress() {
        return isInProgress;
    }

    public void setInProgress(Boolean inProgress) {
        isInProgress = inProgress;
    }

    public String getDocTitl() {
        return docTitl;
    }

    public void setDocTitl(String docTitl) {
        this.docTitl = docTitl;
    }

    public String getSantPrgsStatCd() {
        return santPrgsStatCd;
    }

    public void setSantPrgsStatCd(String santPrgsStatCd) {
        this.santPrgsStatCd = santPrgsStatCd;
    }

    public long getSumSellAmt() {
        return sumSellAmt;
    }

    public void setSumSellAmt(long sumSellAmt) {
        this.sumSellAmt = sumSellAmt;
    }

    public long getSumBuyAmt() {
        return sumBuyAmt;
    }

    public void setSumBuyAmt(long sumBuyAmt) {
        this.sumBuyAmt = sumBuyAmt;
    }

    public long getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }

    public float getSumPutNopCount() {
        return sumPutNopCount;
    }

    public void setSumPutNopCount(float sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public List<ProfitReportVO> getProfitReportList() {
        return profitReportList;
    }

    public void setProfitReportList(List<ProfitReportVO> profitReportList) {
        this.profitReportList = profitReportList;
    }

    public String getPrgsStatUrl() {
        return prgsStatUrl;
    }

    public void setPrgsStatUrl(String prgsStatUrl) {
        this.prgsStatUrl = prgsStatUrl;
    }

    public long getExptTurnKeyAmt() {
        return exptTurnKeyAmt;
    }

    public void setExptTurnKeyAmt(long exptTurnKeyAmt) {
        this.exptTurnKeyAmt = exptTurnKeyAmt;
    }

    public long getTurnKeyAmt() {
        return turnKeyAmt;
    }

    public void setTurnKeyAmt(long turnKeyAmt) {
        this.turnKeyAmt = turnKeyAmt;
    }

    public String getFileAttcId() {
        return fileAttcId;
    }

    public void setFileAttcId(String fileAttcId) {
        this.fileAttcId = fileAttcId;
    }

    public List<AttachVO> getFileAttcList() {
        return fileAttcList;
    }

    public void setFileAttcList(List<AttachVO> fileAttcList) {
        this.fileAttcList = fileAttcList;
    }
}
