package com.ibiz.api.model;

import javax.validation.constraints.NotNull;

public class BizChanceHistoryVO {

    /**
     * 사업기회 ID
     */
    @NotNull
    private String boptId;

    /**
     * 사업기회명
     */
    @NotNull
    private String boptNm;

    /**
     * 프로젝트 ID
     */
    @NotNull
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
     * 사업분류코드
     */
    @NotNull
    private String bsnsClsfCd;

    /**
     * 사업분류코드명
     */
    private String bsnsClsfCdNm;


    /**
     * 계약일자
     */
    @NotNull
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
     * 수주확률코드
     */
    @NotNull
    private String wctPrbbCd;

    /**
     * 예상 반영 여부
     */
    @NotNull
    private String fcstRflcYn;

    /**
     * 사업기회상태코드
     */
    @NotNull
    private String boptStatCd;

    /**
     * 사업기회상태명
     */
    private String boptStatCdNm;

    /**
     * 사업기회종료유형코드
     */
    @NotNull
    private String boptEndTypeCd;

    /**
     * 영업부서ID
     */
    @NotNull
    private String slsDeptId;

    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 영업사원ID
     */
    @NotNull
    private String slsEmpId;

    /**
     * 영업사원명
     */
    private String slsEmpNm;

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
    @NotNull
    private String chgDt;

    /* 월별 매출 매입 */

    /**
     * 예상연월
     */
    private String fcstYam;

    /**
     * 상품구분코드
     */
    private String prodDstCd;

    /**
     * 제품분류코드
     */
    private String godsClsfCd;

    /**
     * 매출금액
     */
    private long sellAmt;

    /**
     * 매입금액
     */
    private long buyAmt;

    /**
     * 사업수행역할코드
     */
    private String bexcRoleCd;

    /**
     * 사업수행역할명
     */
    private String bexcRoleCdNm;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 투입인원수
     */
    private float putNopCount;

    /**
     * 비고내용
     */
    private String rmrkCont;


    /**
     * 최종고객ID
     */
    private String lastCustId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트유형코드
     */
    private String prjtTypeCd;

    /**
     * 프로젝트유형코드명
     */
    private String prjtTypeCdNm;

    /**
     * 매출금액 총합
     */
    private long sumSellAmt;

    /**
     * 수주확률명
     */
    private String wctPrbbCdNm;

    /**
     * 페이지사이즈
     */
    private String pageSize;

    /**
     * 페이지넘버
     */
    private String pageNumber;

    /**
     * 변경전 사업기회명
     */
    private String befBoptStatCdNm;

    /**
     * 변경전 변경일시
     */
    private String befChgDt;

    /**
     * 변경전 매입기회금액
     */
    private String befCntrBuyAmt;

    /**
     * 매입기회금액
     */
    private String cntrBuyAmt;

    /**
     * 변경전 계약연월
     */
    private String befCntrYam;

    /**
     * 변경후 계약연월
     */
    private String cntrYam;

    /**
     * 변경전 수주가능성
     */
    private String befWctPrbbNumVal;

    /**
     * 변경후 수주가능성
     */
    private String wctPrbbNumVal;

    /**
     * 변경전 수주확률명
     */
    private String befWctPrbbCdNm;

    /**
     * 변경전 예상 반영 유무
     */
    private String befFcstRflcYn;

    /**
     * 변경전 매출확률금액
     */
    private String befCntrSellPrbbAmt;

    /**
     * 매출확률금액
     */
    private String cntrSellPrbbAmt;

    /**
     * 변경전 매출기회금액
     */
    private String befCntrSellAmt;

    /**
     * 매출기회금액
     */
    private long cntrSellAmt;

    /**
     * 변경전 매입확률금액
     */
    private String befCntrBuyPrbbAmt;

    /**
     * 매입확률금액
     */
    private String cntrBuyPrbbAmt;

    /**
     * 변경전 예상연월
     */
    private String befFcstYam;

    /**
     * 변경전 매출금액
     */
    private Long befSellAmt;

    /**
     * 변경전 매입금액
     */
    private Long befBuyAmt;

    /**
     * 변경전 매출확률금액
     */
    private String befSellPrbbAmt;

    /**
     * 매출확률금액
     */
    private String sellPrbbAmt;

    /**
     * 변경전 매입확률금액
     */
    private String befBuyPrbbAmt;

    /**
     * 매입확률금액
     */
    private String buyPrbbAmt;

    /**
     * 변경전 사업수행역할코드
     */
    private String befBexcRoleCd;

    /**
     * 변경전 사업수행역할명
     */
    private String befBexcRoleCdNm;

    /**
     * 변경전 투입인원수
     */
    private float befPutNopCount;

    /**
     * 변경전 투입확률인원수
     */
    private float befPutPrbbNopCount;

    /**
     * 투입확률인원수
     */
    private float putPrbbNopCount;

    /**
     * 이력구분
     */
    private String historyGroupCd;

    /**
     * 전체 수
     */
    private Integer totalCnt;

    /**
     * 변경전후 계약시작일
     */
    private String allCntrStartDate;

    /**
     * 변경전후 계약종료일
     */
    private String allCntrEndDate;

    /**
     * 변경전 계약시작일
     */
    private String befCntrStartDate;

    /**
     * 변경전 계약종료일
     */
    private String befCntrEndDate;

    /**
     * 변경전후 매출시작일
     */
    private String allSellStartDate;

    /**
     * 변경전후 매출종료일
     */
    private String allSellEndDate;

    /**
     * 변경전 매출시작일
     */
    private String befSellStartDate;

    /**
     * 변경전 매출종료일
     */
    private String befSellEndDate;

    /**
     * 변경전후 매입시작일
     */
    private String allBuyStartDate;

    /**
     * 변경전후 매입종료일
     */
    private String allBuyEndDate;

    /**
     * 변경전 매입시작일
     */
    private String befBuyStartDate;

    /**
     * 변경전 매입종료일
     */
    private String befBuyEndDate;

    /**
     * 변경시기 시작일
     */
    private String chgStartDate;

    /**
     * 변경시기 종료일
     */
    private String chgEndDate;

    /**
     * 계약금액
     */
    private long cntrAmt;

    /**
     * 변경전 계약금액
     */
    private String befCntrAmt;

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

    public String getWctPrbbCd() {
        return wctPrbbCd;
    }

    public void setWctPrbbCd(String wctPrbbCd) {
        this.wctPrbbCd = wctPrbbCd;
    }

    public String getFcstRflcYn() {
        return fcstRflcYn;
    }

    public void setFcstRflcYn(String fcstRflcYn) {
        this.fcstRflcYn = fcstRflcYn;
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

    public String getBoptEndTypeCd() {
        return boptEndTypeCd;
    }

    public void setBoptEndTypeCd(String boptEndTypeCd) {
        this.boptEndTypeCd = boptEndTypeCd;
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

    public String getFcstYam() {
        return fcstYam;
    }

    public void setFcstYam(String fcstYam) {
        this.fcstYam = fcstYam;
    }

    public String getProdDstCd() {
        return prodDstCd;
    }

    public void setProdDstCd(String prodDstCd) {
        this.prodDstCd = prodDstCd;
    }

    public String getGodsClsfCd() {
        return godsClsfCd;
    }

    public void setGodsClsfCd(String godsClsfCd) {
        this.godsClsfCd = godsClsfCd;
    }

    public long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public long getBuyAmt() {
        return buyAmt;
    }

    public void setBuyAmt(long buyAmt) {
        this.buyAmt = buyAmt;
    }

    public String getBexcRoleCd() {
        return bexcRoleCd;
    }

    public void setBexcRoleCd(String bexcRoleCd) {
        this.bexcRoleCd = bexcRoleCd;
    }

    public String getBexcRoleCdNm() {
        return bexcRoleCdNm;
    }

    public void setBexcRoleCdNm(String bexcRoleCdNm) {
        this.bexcRoleCdNm = bexcRoleCdNm;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public float getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(float putNopCount) {
        this.putNopCount = putNopCount;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
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

    public long getSumSellAmt() {
        return sumSellAmt;
    }

    public void setSumSellAmt(long sumSellAmt) {
        this.sumSellAmt = sumSellAmt;
    }

    public String getWctPrbbCdNm() {
        return wctPrbbCdNm;
    }

    public void setWctPrbbCdNm(String wctPrbbCdNm) {
        this.wctPrbbCdNm = wctPrbbCdNm;
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

    public String getBefBoptStatCdNm() {
        return befBoptStatCdNm;
    }

    public void setBefBoptStatCdNm(String befBoptStatCdNm) {
        this.befBoptStatCdNm = befBoptStatCdNm;
    }

    public String getBefChgDt() {
        return befChgDt;
    }

    public void setBefChgDt(String befChgDt) {
        this.befChgDt = befChgDt;
    }

    public String getBefCntrBuyAmt() {
        return befCntrBuyAmt;
    }

    public void setBefCntrBuyAmt(String befCntrBuyAmt) {
        this.befCntrBuyAmt = befCntrBuyAmt;
    }

    public String getCntrBuyAmt() {
        return cntrBuyAmt;
    }

    public void setCntrBuyAmt(String cntrBuyAmt) {
        this.cntrBuyAmt = cntrBuyAmt;
    }

    public String getBefCntrYam() {
        return befCntrYam;
    }

    public void setBefCntrYam(String befCntrYam) {
        this.befCntrYam = befCntrYam;
    }

    public String getCntrYam() {
        return cntrYam;
    }

    public void setCntrYam(String cntrYam) {
        this.cntrYam = cntrYam;
    }

    public String getBefWctPrbbNumVal() {
        return befWctPrbbNumVal;
    }

    public void setBefWctPrbbNumVal(String befWctPrbbNumVal) {
        this.befWctPrbbNumVal = befWctPrbbNumVal;
    }

    public String getWctPrbbNumVal() {
        return wctPrbbNumVal;
    }

    public void setWctPrbbNumVal(String wctPrbbNumVal) {
        this.wctPrbbNumVal = wctPrbbNumVal;
    }

    public String getBefWctPrbbCdNm() {
        return befWctPrbbCdNm;
    }

    public void setBefWctPrbbCdNm(String befWctPrbbCdNm) {
        this.befWctPrbbCdNm = befWctPrbbCdNm;
    }

    public String getBefFcstRflcYn() {
        return befFcstRflcYn;
    }

    public void setBefFcstRflcYn(String befFcstRflcYn) {
        this.befFcstRflcYn = befFcstRflcYn;
    }

    public String getBefCntrSellPrbbAmt() {
        return befCntrSellPrbbAmt;
    }

    public void setBefCntrSellPrbbAmt(String befCntrSellPrbbAmt) {
        this.befCntrSellPrbbAmt = befCntrSellPrbbAmt;
    }

    public String getCntrSellPrbbAmt() {
        return cntrSellPrbbAmt;
    }

    public void setCntrSellPrbbAmt(String cntrSellPrbbAmt) {
        this.cntrSellPrbbAmt = cntrSellPrbbAmt;
    }

    public String getBefCntrSellAmt() {
        return befCntrSellAmt;
    }

    public void setBefCntrSellAmt(String befCntrSellAmt) {
        this.befCntrSellAmt = befCntrSellAmt;
    }

    public long getCntrSellAmt() {
        return cntrSellAmt;
    }

    public void setCntrSellAmt(long cntrSellAmt) {
        this.cntrSellAmt = cntrSellAmt;
    }

    public String getBefCntrBuyPrbbAmt() {
        return befCntrBuyPrbbAmt;
    }

    public void setBefCntrBuyPrbbAmt(String befCntrBuyPrbbAmt) {
        this.befCntrBuyPrbbAmt = befCntrBuyPrbbAmt;
    }

    public String getCntrBuyPrbbAmt() {
        return cntrBuyPrbbAmt;
    }

    public void setCntrBuyPrbbAmt(String cntrBuyPrbbAmt) {
        this.cntrBuyPrbbAmt = cntrBuyPrbbAmt;
    }

    public String getBefFcstYam() {
        return befFcstYam;
    }

    public void setBefFcstYam(String befFcstYam) {
        this.befFcstYam = befFcstYam;
    }

    public Long getBefSellAmt() {
        return befSellAmt;
    }

    public void setBefSellAmt(Long befSellAmt) {
        this.befSellAmt = befSellAmt;
    }

    public Long getBefBuyAmt() {
        return befBuyAmt;
    }

    public void setBefBuyAmt(Long befBuyAmt) {
        this.befBuyAmt = befBuyAmt;
    }

    public String getBefSellPrbbAmt() {
        return befSellPrbbAmt;
    }

    public void setBefSellPrbbAmt(String befSellPrbbAmt) {
        this.befSellPrbbAmt = befSellPrbbAmt;
    }

    public String getSellPrbbAmt() {
        return sellPrbbAmt;
    }

    public void setSellPrbbAmt(String sellPrbbAmt) {
        this.sellPrbbAmt = sellPrbbAmt;
    }

    public String getBefBuyPrbbAmt() {
        return befBuyPrbbAmt;
    }

    public void setBefBuyPrbbAmt(String befBuyPrbbAmt) {
        this.befBuyPrbbAmt = befBuyPrbbAmt;
    }

    public String getBuyPrbbAmt() {
        return buyPrbbAmt;
    }

    public void setBuyPrbbAmt(String buyPrbbAmt) {
        this.buyPrbbAmt = buyPrbbAmt;
    }

    public String getBefBexcRoleCd() {
        return befBexcRoleCd;
    }

    public void setBefBexcRoleCd(String befBexcRoleCd) {
        this.befBexcRoleCd = befBexcRoleCd;
    }

    public String getBefBexcRoleCdNm() {
        return befBexcRoleCdNm;
    }

    public void setBefBexcRoleCdNm(String befBexcRoleCdNm) {
        this.befBexcRoleCdNm = befBexcRoleCdNm;
    }

    public float getBefPutNopCount() {
        return befPutNopCount;
    }

    public void setBefPutNopCount(float befPutNopCount) {
        this.befPutNopCount = befPutNopCount;
    }

    public float getBefPutPrbbNopCount() {
        return befPutPrbbNopCount;
    }

    public void setBefPutPrbbNopCount(float befPutPrbbNopCount) {
        this.befPutPrbbNopCount = befPutPrbbNopCount;
    }

    public float getPutPrbbNopCount() {
        return putPrbbNopCount;
    }

    public void setPutPrbbNopCount(float putPrbbNopCount) {
        this.putPrbbNopCount = putPrbbNopCount;
    }

    public String getHistoryGroupCd() {
        return historyGroupCd;
    }

    public void setHistoryGroupCd(String historyGroupCd) {
        this.historyGroupCd = historyGroupCd;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getAllCntrStartDate() {
        return allCntrStartDate;
    }

    public void setAllCntrStartDate(String allCntrStartDate) {
        this.allCntrStartDate = allCntrStartDate;
    }

    public String getAllCntrEndDate() {
        return allCntrEndDate;
    }

    public void setAllCntrEndDate(String allCntrEndDate) {
        this.allCntrEndDate = allCntrEndDate;
    }

    public String getBefCntrStartDate() {
        return befCntrStartDate;
    }

    public void setBefCntrStartDate(String befCntrStartDate) {
        this.befCntrStartDate = befCntrStartDate;
    }

    public String getBefCntrEndDate() {
        return befCntrEndDate;
    }

    public void setBefCntrEndDate(String befCntrEndDate) {
        this.befCntrEndDate = befCntrEndDate;
    }

    public String getAllSellStartDate() {
        return allSellStartDate;
    }

    public void setAllSellStartDate(String allSellStartDate) {
        this.allSellStartDate = allSellStartDate;
    }

    public String getAllSellEndDate() {
        return allSellEndDate;
    }

    public void setAllSellEndDate(String allSellEndDate) {
        this.allSellEndDate = allSellEndDate;
    }

    public String getBefSellStartDate() {
        return befSellStartDate;
    }

    public void setBefSellStartDate(String befSellStartDate) {
        this.befSellStartDate = befSellStartDate;
    }

    public String getBefSellEndDate() {
        return befSellEndDate;
    }

    public void setBefSellEndDate(String befSellEndDate) {
        this.befSellEndDate = befSellEndDate;
    }

    public String getAllBuyStartDate() {
        return allBuyStartDate;
    }

    public void setAllBuyStartDate(String allBuyStartDate) {
        this.allBuyStartDate = allBuyStartDate;
    }

    public String getAllBuyEndDate() {
        return allBuyEndDate;
    }

    public void setAllBuyEndDate(String allBuyEndDate) {
        this.allBuyEndDate = allBuyEndDate;
    }

    public String getBefBuyStartDate() {
        return befBuyStartDate;
    }

    public void setBefBuyStartDate(String befBuyStartDate) {
        this.befBuyStartDate = befBuyStartDate;
    }

    public String getBefBuyEndDate() {
        return befBuyEndDate;
    }

    public void setBefBuyEndDate(String befBuyEndDate) {
        this.befBuyEndDate = befBuyEndDate;
    }

    public String getChgStartDate() {
        return chgStartDate;
    }

    public void setChgStartDate(String chgStartDate) {
        this.chgStartDate = chgStartDate;
    }

    public String getChgEndDate() {
        return chgEndDate;
    }

    public void setChgEndDate(String chgEndDate) {
        this.chgEndDate = chgEndDate;
    }

    public long getCntrAmt() {
        return cntrAmt;
    }

    public void setCntrAmt(long cntrAmt) {
        this.cntrAmt = cntrAmt;
    }

    public String getBefCntrAmt() {
        return befCntrAmt;
    }

    public void setBefCntrAmt(String befCntrAmt) {
        this.befCntrAmt = befCntrAmt;
    }

}