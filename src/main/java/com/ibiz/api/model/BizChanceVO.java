package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BizChanceVO {
    /**
     * 손익 ID
     */
    private String fcstPalId;

    /**
     * 손익 문서번호
     */
    private String docNo;

    /**
     * 손익 결재 ID
     */
    private String santId;

    /**
     * 손익상태
     */
    private String fcstPalPrgsStatCdNm;

    /**
     * 사업기회 ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업기회ID는 10자리 이하여야합니다." )
    private String boptId;

    /**
     * 프로젝트 ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 프로젝트ID는 10자리 이하여야합니다." )
    private String prjtId;

    /**
     * 사업기회명
     */
    @NotNull
    private String boptNm;

    /**
     * 발주고객 ID
     */
    private String ordeCustId;
    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 계약일자
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 계약일자는 8자리 이하여야합니다." )
    private String cntrDate;

    /**
     * 계약이행시작연월
     */
    private String cntrTrsfStartYam;

    /**
     * 계약이행종료연월
     */
    private String cntrTrsfEndYam;

    /**
     * 제안마감일자
     */
    private String prpsFnshDate;

    /**
     * 입찰마감일자
     */
    private String bidFnshDate;

    /**
     * 업체선정일자
     */
    private String cmpySlctDate;

    /**
     * 업체선정방식내용
     */
    private String cmpySlctWayCont;

    /**
     * 수주확률코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 수주확률코드는 4자리 이하여야합니다." )
    private String wctPrbbCd;

    /**
     * 수주확률명
     */
    private String wctPrbbCdNm;
    /**
     * 예상 반영 여부
     */
    @NotNull
    private String fcstRflcYn;

    /**
     * 수주확정일자
     */
    private String wctDcdDate;

    /**
     * 사업기회상태코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업기회상태코드는 4자리 이하여야합니다." )
    private String boptStatCd;

    /**
     * 사업기회상태명
     */
    private String boptStatCdNm;

    /**
     * 프로젝트유형코드
     */
    private String prjtTypeCd;

    /**
     * 프로젝트유형코드명
     */
    private String prjtTypeCdNm;

    /**
     * 프로젝트상태코드
     */
    private String prjtStateCd;

    /**
     * 프로젝트상태코드
     */
    private String prjtStatCdNm;

    /**
     * 사업기회종료유형코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업기회종료코드는 4자리 이하여야합니다." )
    private String boptEndTypeCd;

    /**
     * 사업기회종료유형명
     */
    private String boptEndTypeCdNm;

    /**
     * 영업부서ID
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업부서ID는 8자리 이하여야합니다." )
    private String slsDeptId;
    /**
     * 영업부서명
     */
    private String slsDeptNm;
    /**
     * 영업사원ID
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 영업사원ID는 8자리 이하여야합니다." )
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
     * 변경일시 화면용
     */
    private String chgDtView;

    /**
     * 매출금액 총합
     */
    private long sumSellAmt;

    /**
     * PRJT_VRB분석 상세조회 - 분석일
     */
    private String anlyDt;

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

    /**
     * 월별 매출매입 리스트
     */
    private List<BizChanceAmountVO> bizChanceAmtList;

    /**
     * 월별 투입인원 리스트
     */
    private List<BizChancePersonVO> bizChanceNopList;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트명
     */
    private String prjtNm;

    /**
     * 사업분류코드
     */
    private String bsnsClsfCd;

    /**
     * 사업분류코드명
     */
    private String bsnsClsfCdNm;

    /**
     * 영업대표직위명
     */
    private String slsOfpsCdNm;

    /**
     * 등록사원부서명
     */
    private String regDeptNm;

    /**
     * 수정사원부서명
     */
    private String chgDeptNm;

    /**
     * 특별 내용
     */
    private String spclCont;

    /**
     * 주간보고 사용여부
     */
    private String dtimRprtDispYn;

    /**
     * 최종고객ID
     */
    private String lastCustId;

    /**
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 전체 수
     */
    private Integer totalCnt;

    /**
     * 계약완료 제외 유무
     */
    private String exceptContractComplete;

    private List<BizChanceActivityVO> salesActivityList;

    /**
     * 사업기회 이관 리스트
     */
    private List<BizChanceVO> bizChanceChangeList;

    /**
     * 손익MA 연간투입원가
     */
    private long yrlyFcstPutCostAmt;

    /**
     * 손익MA 유지보수시작일(MIN)
     */
    private String maStartDate;

    /**
     * 손익MA 유지보수종료일(MAX)
     */
    private String maEndDate;

    private BizChanceActivityVO bizChanceActivityVO;

    /**
     * 계약금액
     */
    private long cntrAmt;

    /**
     * 사업기회상태 리스트
     */
    private List<String> boptStatCdList;

    /**
     * 수주가능성 코드
     */
    private String wctPsbltCd;

    /**
     * 수주가능성코드 리스트
     */
    private List<String> wctPsbltCdList;

    /**
     * 프로젝트인입경로 코드
     */
    private String prjtInputCd;

    /**
     * 연장여부
     */
    private String extndYn;

    public List<BizChanceVO> getBizChanceChangeList() {
        return bizChanceChangeList;
    }

    public void setBizChanceChangeList(List<BizChanceVO> bizChanceChangeList) {
        this.bizChanceChangeList = bizChanceChangeList;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
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

    public String getCntrDate() {
        return cntrDate;
    }

    public void setCntrDate(String cntrDate) {
        this.cntrDate = cntrDate;
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

    public String getPrpsFnshDate() {
        return prpsFnshDate;
    }

    public void setPrpsFnshDate(String prpsFnshDate) {
        this.prpsFnshDate = prpsFnshDate;
    }

    public String getBidFnshDate() {
        return bidFnshDate;
    }

    public void setBidFnshDate(String bidFnshDate) {
        this.bidFnshDate = bidFnshDate;
    }

    public String getCmpySlctDate() {
        return cmpySlctDate;
    }

    public void setCmpySlctDate(String cmpySlctDate) {
        this.cmpySlctDate = cmpySlctDate;
    }

    public String getCmpySlctWayCont() {
        return cmpySlctWayCont;
    }

    public void setCmpySlctWayCont(String cmpySlctWayCont) {
        this.cmpySlctWayCont = cmpySlctWayCont;
    }

    public String getWctPrbbCd() {
        return wctPrbbCd;
    }

    public void setWctPrbbCd(String wctPrbbCd) {
        this.wctPrbbCd = wctPrbbCd;
    }

    public String getWctPrbbCdNm() {
        return wctPrbbCdNm;
    }

    public void setWctPrbbCdNm(String wctPrbbCdNm) {
        this.wctPrbbCdNm = wctPrbbCdNm;
    }

    public String getFcstRflcYn() {
        return fcstRflcYn;
    }

    public void setFcstRflcYn(String fcstRflcYn) {
        this.fcstRflcYn = fcstRflcYn;
    }

    public String getWctDcdDate() {
        return wctDcdDate;
    }

    public void setWctDcdDate(String wctDcdDate) {
        this.wctDcdDate = wctDcdDate;
    }

    public String getBoptStatCd() {
        return boptStatCd;
    }

    public void setBoptStatCd(String boptStatCd) {
        this.boptStatCd = boptStatCd;
    }

    public String getBoptStatCdNm() {
        return boptStatCdNm;
    }

    public void setBoptStatCdNm(String boptStatCdNm) {
        this.boptStatCdNm = boptStatCdNm;
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

    public String getPrjtStateCd() {
        return prjtStateCd;
    }

    public void setPrjtStateCd(String prjtStateCd) {
        this.prjtStateCd = prjtStateCd;
    }

    public String getPrjtStatCdNm() {
        return prjtStatCdNm;
    }

    public void setPrjtStatCdNm(String prjtStatCdNm) {
        this.prjtStatCdNm = prjtStatCdNm;
    }

    public String getBoptEndTypeCd() {
        return boptEndTypeCd;
    }

    public void setBoptEndTypeCd(String boptEndTypeCd) {
        this.boptEndTypeCd = boptEndTypeCd;
    }

    public String getBoptEndTypeCdNm() {
        return boptEndTypeCdNm;
    }

    public void setBoptEndTypeCdNm(String boptEndTypeCdNm) {
        this.boptEndTypeCdNm = boptEndTypeCdNm;
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

    public String getEtcMtr() {
        return etcMtr;
    }

    public void setEtcMtr(String etcMtr) {
        this.etcMtr = etcMtr;
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



    public String getChgDtView() {
        return chgDtView;
    }

    public void setChgDtView(String chgDtView) {
        this.chgDtView = chgDtView;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public long getSumSellAmt() {
        return sumSellAmt;
    }

    public void setSumSellAmt(long sumSellAmt) {
        this.sumSellAmt = sumSellAmt;
    }

    public String getAnlyDt() {
        return anlyDt;
    }

    public void setAnlyDt(String anlyDt) {
        this.anlyDt = anlyDt;
    }

    public long getSumBuyAmt() {
        return sumBuyAmt;
    }

    public void setSumBuyAmt(long sumBuyAmt) {
        this.sumBuyAmt = sumBuyAmt;
    }

    public void setSumPutNopCount(Integer sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }

    public List<BizChanceAmountVO> getBizChanceAmtList() {
        return bizChanceAmtList;
    }

    public void setBizChanceAmtList(List<BizChanceAmountVO> bizChanceAmtList) {
        this.bizChanceAmtList = bizChanceAmtList;
    }

    public List<BizChancePersonVO> getBizChanceNopList() {
        return bizChanceNopList;
    }

    public void setBizChanceNopList(List<BizChancePersonVO> bizChanceNopList) {
        this.bizChanceNopList = bizChanceNopList;
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

    public String getBsnsClsfCd() {
        return bsnsClsfCd;
    }

    public void setBsnsClsfCd(String bsnsClsfCd) {
        this.bsnsClsfCd = bsnsClsfCd;
    }

    public String getBsnsClsfCdNm() {
        return bsnsClsfCdNm;
    }

    public void setBsnsClsfCdNm(String bsnsClsfCdNm) {
        this.bsnsClsfCdNm = bsnsClsfCdNm;
    }

    public String getSlsOfpsCdNm() {
        return slsOfpsCdNm;
    }

    public void setSlsOfpsCdNm(String slsOfpsCdNm) {
        this.slsOfpsCdNm = slsOfpsCdNm;
    }

    public String getRegDeptNm() {
        return regDeptNm;
    }

    public void setRegDeptNm(String regDeptNm) {
        this.regDeptNm = regDeptNm;
    }

    public String getChgDeptNm() {
        return chgDeptNm;
    }

    public void setChgDeptNm(String chgDeptNm) {
        this.chgDeptNm = chgDeptNm;
    }

    public String getSpclCont() {
        return spclCont;
    }

    public void setSpclCont(String spclCont) {
        this.spclCont = spclCont;
    }

    public String getDtimRprtDispYn() {
        return dtimRprtDispYn;
    }

    public void setDtimRprtDispYn(String dtimRprtDispYn) {
        this.dtimRprtDispYn = dtimRprtDispYn;
    }

    public String getLastCustId() {
        return lastCustId;
    }

    public void setLastCustId(String lastCustId) {
        this.lastCustId = lastCustId;
    }

    public List<BizChanceActivityVO> getSalesActivityList() {
        return salesActivityList;
    }

    public void setSalesActivityList(List<BizChanceActivityVO> salesActivityList) {
        this.salesActivityList = salesActivityList;
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

    public float getSumPutNopCount() {
        return sumPutNopCount;
    }

    public void setSumPutNopCount(float sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getExceptContractComplete() {
        return exceptContractComplete;
    }

    public void setExceptContractComplete(String exceptContractComplete) {
        this.exceptContractComplete = exceptContractComplete;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public String getFcstPalPrgsStatCdNm() {
        return fcstPalPrgsStatCdNm;
    }

    public void setFcstPalPrgsStatCdNm(String fcstPalPrgsStatCdNm) {
        this.fcstPalPrgsStatCdNm = fcstPalPrgsStatCdNm;
    }

    public long getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public long getYrlyFcstPutCostAmt() {
        return yrlyFcstPutCostAmt;
    }

    public void setYrlyFcstPutCostAmt(long yrlyFcstPutCostAmt) {
        this.yrlyFcstPutCostAmt = yrlyFcstPutCostAmt;
    }

    public String getMaStartDate() {
        return maStartDate;
    }

    public void setMaStartDate(String maStartDate) {
        this.maStartDate = maStartDate;
    }

    public String getMaEndDate() {
        return maEndDate;
    }

    public void setMaEndDate(String maEndDate) {
        this.maEndDate = maEndDate;
    }

    public BizChanceActivityVO getBizChanceActivityVO() {
        return bizChanceActivityVO;
    }

    public void setBizChanceActivityVO(BizChanceActivityVO bizChanceActivityVO) {
        this.bizChanceActivityVO = bizChanceActivityVO;
    }

    public long getCntrAmt() {
        return cntrAmt;
    }

    public void setCntrAmt(long cntrAmt) {
        this.cntrAmt = cntrAmt;
    }

    public List<String> getBoptStatCdList() {
        return boptStatCdList;
    }

    public void setBoptStatCdList(List<String> boptStatCdList) {
        this.boptStatCdList = boptStatCdList;
    }

    public String getWctPsbltCd() {
        return wctPsbltCd;
    }

    public void setWctPsbltCd(String wctPsbltCd) {
        this.wctPsbltCd = wctPsbltCd;
    }

    public List<String> getWctPsbltCdList() {
        return wctPsbltCdList;
    }

    public void setWctPsbltCdList(List<String> wctPsbltCdList) {
        this.wctPsbltCdList = wctPsbltCdList;
    }

    public String getPrjtInputCd() {
        return prjtInputCd;
    }

    public void setPrjtInputCd(String prjtInputCd) {
        this.prjtInputCd = prjtInputCd;
    }

    public String getExtndYn() {
        return extndYn;
    }

    public void setExtndYn(String extndYn) {
        this.extndYn = extndYn;
    }
}
