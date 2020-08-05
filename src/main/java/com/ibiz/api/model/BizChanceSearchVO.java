package com.ibiz.api.model;

import java.util.List;

public class BizChanceSearchVO {
    /**
     * 프로젝트 ID
     */
    private String prjtId;

    /**
     * 프로젝트 검색 ID
     */
    private String prjtSearchId;

    /**
     * 프로젝트명
     */
    private String prjtNm;
    /**
     * 최종 고객 ID
     */
    private String lastCustId;

    /**
     * 최종 고객 검색 ID
     */
    private String lastCustSearchId;

    /**
     * 최종 고객명
     */
    private String lastCustNm;
    /**
     * 사업기회 ID
     */
    private String boptId;

    /**
     * 사업기회검색 ID
     */
    private String boptSearchId;

    /**
     * 사업기회명
     */
    private String boptNm;
    /**
     * 영업부서 ID
     */
    private String slsDeptId;
    /**
     * 영업부서 검색 ID
     */
    private String slsDeptSearchId;
    /**
     * 영업사원 ID
     */
    private String slsEmpId;

    /**
     * 영업대표정보
     */
    private String slsEmpInfo;

    /**
     * 영업사원 아이디
     */
    private String slsEmpSearchId;

    /**
     * 프로젝트 상태 코드
     */
    private String prjtStatCd;
    /**
     * 사업기회 상태 코드
     */
    private String boptStatCd;
    /**
     * 프로젝트 유형 코드
     */
    private String prjtTypeCd;
    /**
     * 프로젝트유형코드명
     */
    private String prjtTypeCdNm;
    /**
     * 수주확률 코드
     */
    private String wctPrbbCd;
    /**
     * 정렬기준
     */
    private String orderByCd;
    /**
     * 예상 반영 유무
     */
    private String fcstRflcYn;
    /**
     * 계약시기 시작일
     */
    private String cntrStartDate;
    /**
     * 계약시기 종료일
     */
    private String cntrEndDate;

    /**
     * 페이징 크기
     */
    private String pageSize;

    /**
     * 페이지번호
     */
    private String pageNumber;

    /**
     * 영업대표명
     */
    private String slsEmpNm;

    /**
     * 사업기회종료유형코드
     */
    private String boptEndTypeCd;

    /**
     * 사업분류코드
     */
    private String bsnsClsfCd;

    /**
     * 사업분류코드명
     */
    private String bsnsClsfCdNm;

    /**
     * 매출 시작일
     */
    private String sellStartDate;
    /**
     * 매출 종료일
     */
    private String sellEndDate;
    /**
     * 매입 시작일
     */
    private String buyStartDate;
    /**
     * 매입 종료일
     */
    private String buyEndDate;

    /**
     * 시기
     */
    private String period;

    /**
     * 계약일자
     */
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
     * 사업기회상태명
     */
    private String boptStatCdNm;

    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 발주고객 ID
     */
    private String ordeCustId;

    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 변경사원 ID
     */
    private String chgEmpId;

    /**
     * 변경사원명
     */
    private String chgEmpNm;

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
     * 변경일시
     */
    private String chgDt;

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
     * 매출금액 총합
     */
    private long sumSellAmt;

    /**
     * 수주확률명
     */
    private String wctPrbbCdNm;

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
    private Integer befSellAmt;

    /**
     * 변경전 매입금액
     */
    private Integer befBuyAmt;

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
     * 변경전 계약시작일
     */
    private String befCntrStartDate;

    /**
     * 변경전 계약종료일
     */
    private String befCntrEndDate;

    /**
     * 변경전 매출시작일
     */
    private String befSellStartDate;

    /**
     * 변경전 매출종료일
     */
    private String befSellEndDate;

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
     * 사업기회 이관 리스트
     */
    private List<BizChanceVO> bizChanceChangeList;

    /**
     * 윈도우팝업여부
     */
    private String winPopupCd;

    /**
     * 프린트팝업여부
     */
    private String winPrintCd;

    /**
     * 사용자ID
     */
    private String userId;

    /**
     * 전체 수
     */
    private Integer totalCnt;

    /**
     * 계약완료 제외 유무
     */
    private String exceptContractComplete;

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
    public String getHistoryGroupCd() {
        return historyGroupCd;
    }
    public void setHistoryGroupCd(String historyGroupCd) {
        this.historyGroupCd = historyGroupCd;
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
    public String getSlsDeptId() {
        return slsDeptId;
    }
    public void setSlsDeptId(String slsDeptId) {
        this.slsDeptId = slsDeptId;
    }
    public String getPrjtStatCd() {
        return prjtStatCd;
    }
    public void setPrjtStatCd(String prjtStatCd) {
        this.prjtStatCd = prjtStatCd;
    }
    public String getBoptStatCd() {
        return boptStatCd;
    }
    public void setBoptStatCd(String boptStatCd) {
        this.boptStatCd = boptStatCd;
    }
    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }
    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
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
    public String getCntrStartDate() {
        return cntrStartDate;
    }
    public void setCntrStartDate(String cntrStartDate) {
        this.cntrStartDate = cntrStartDate;
    }
    public String getCntrEndDate() {
        return cntrEndDate;
    }
    public void setCntrEndDate(String cntrEndDate) {
        this.cntrEndDate = cntrEndDate;
    }
    public String getSlsEmpId() {
        return slsEmpId;
    }
    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
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
    public String getSlsEmpNm() {
        return slsEmpNm;
    }
    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }
    public String getBoptEndTypeCd() {
        return boptEndTypeCd;
    }
    public void setBoptEndTypeCd(String boptEndTypeCd) {
        this.boptEndTypeCd = boptEndTypeCd;
    }
    public String getBsnsClsfCd() {
        return bsnsClsfCd;
    }
    public void setBsnsClsfCd(String bsnsClsfCd) {
        this.bsnsClsfCd = bsnsClsfCd;
    }
    public String getPrjtSearchId() {
        return prjtSearchId;
    }
    public void setPrjtSearchId(String prjtSearchId) {
        this.prjtSearchId = prjtSearchId;
    }
    public String getLastCustSearchId() {
        return lastCustSearchId;
    }
    public void setLastCustSearchId(String lastCustSearchId) {
        this.lastCustSearchId = lastCustSearchId;
    }
    public String getBoptSearchId() {
        return boptSearchId;
    }
    public void setBoptSearchId(String boptSearchId) {
        this.boptSearchId = boptSearchId;
    }
    public String getSlsEmpSearchId() {
        return slsEmpSearchId;
    }
    public void setSlsEmpSearchId(String slsEmpSearchId) {
        this.slsEmpSearchId = slsEmpSearchId;
    }
    public String getSlsDeptSearchId() {
        return slsDeptSearchId;
    }
    public void setSlsDeptSearchId(String slsDeptSearchId) {
        this.slsDeptSearchId = slsDeptSearchId;
    }
    public String getSlsEmpInfo() {
        return slsEmpInfo;
    }
    public void setSlsEmpInfo(String slsEmpInfo) {
        this.slsEmpInfo = slsEmpInfo;
    }
    public String getOrderByCd() {
        return orderByCd;
    }
    public void setOrderByCd(String orderByCd) {
        this.orderByCd = orderByCd;
    }
    public String getSellStartDate() {
        return sellStartDate;
    }
    public void setSellStartDate(String sellStartDate) {
        this.sellStartDate = sellStartDate;
    }
    public String getSellEndDate() {
        return sellEndDate;
    }
    public void setSellEndDate(String sellEndDate) {
        this.sellEndDate = sellEndDate;
    }
    public String getBuyStartDate() {
        return buyStartDate;
    }
    public void setBuyStartDate(String buyStartDate) {
        this.buyStartDate = buyStartDate;
    }
    public String getBuyEndDate() {
        return buyEndDate;
    }
    public void setBuyEndDate(String buyEndDate) {
        this.buyEndDate = buyEndDate;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }


    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }
    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
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
    public String getBoptStatCdNm() {
        return boptStatCdNm;
    }
    public void setBoptStatCdNm(String boptStatCdNm) {
        this.boptStatCdNm = boptStatCdNm;
    }
    public String getSlsDeptNm() {
        return slsDeptNm;
    }
    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
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
    public long getBuyAmt() {
        return buyAmt;
    }
    public void setBuyAmt(long buyAmt) {
        this.buyAmt = buyAmt;
    }
    public String getChgDt() {
        return chgDt;
    }
    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
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
    public void setSellAmt(long sellAmt) {
        this.sellAmt = sellAmt;
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
    public Integer getBefSellAmt() {
        return befSellAmt;
    }
    public void setBefSellAmt(Integer befSellAmt) {
        this.befSellAmt = befSellAmt;
    }
    public Integer getBefBuyAmt() {
        return befBuyAmt;
    }
    public void setBefBuyAmt(Integer befBuyAmt) {
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

    public List<BizChanceVO> getBizChanceChangeList() {
        return bizChanceChangeList;
    }
    public void setBizChanceChangeList(List<BizChanceVO> bizChanceChangeList) {
        this.bizChanceChangeList = bizChanceChangeList;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "BizChanceSearchVO [prjtId=" + prjtId + ", prjtSearchId=" + prjtSearchId + ", prjtNm=" + prjtNm
                + ", lastCustId=" + lastCustId + ", lastCustSearchId=" + lastCustSearchId + ", lastCustNm=" + lastCustNm
                + ", boptId=" + boptId + ", boptSearchId=" + boptSearchId + ", boptNm=" + boptNm + ", slsDeptId="
                + slsDeptId + ", slsDeptSearchId=" + slsDeptSearchId + ", slsEmpId=" + slsEmpId + ", slsEmpInfo="
                + slsEmpInfo + ", slsEmpSearchId=" + slsEmpSearchId + ", prjtStatCd=" + prjtStatCd + ", boptStatCd="
                + boptStatCd + ", prjtTypeCd=" + prjtTypeCd + ", wctPrbbCd=" + wctPrbbCd + ", orderByCd=" + orderByCd
                + ", fcstRflcYn=" + fcstRflcYn + ", cntrStartDate=" + cntrStartDate + ", cntrEndDate=" + cntrEndDate
                + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", slsEmpNm=" + slsEmpNm
                + ", boptEndTypeCd=" + boptEndTypeCd + ", bsnsClsfCd=" + bsnsClsfCd + ", sellStartDate=" + sellStartDate
                + ", sellEndDate=" + sellEndDate + ", buyStartDate=" + buyStartDate + ", buyEndDate=" + buyEndDate
                + ", period=" + period + ", prjtTypeCdNm=" + prjtTypeCdNm + ", bsnsClsfCdNm=" + bsnsClsfCdNm + ", cntrDate=" + cntrDate
                + ", cntrTrsfStartYam=" + cntrTrsfStartYam + ", cntrTrsfEndYam=" + cntrTrsfEndYam + ", boptStatCdNm=" + boptStatCdNm
                + ", slsDeptNm=" + slsDeptNm + ", ordeCustId=" + ordeCustId + ", ordeCustNm=" + ordeCustNm + ", chgEmpId="
                + chgEmpId + ", chgEmpNm=" + chgEmpNm + ", fcstYam=" + fcstYam + ", prodDstCd=" + prodDstCd + ", godsClsfCd="
                + godsClsfCd + ", sellAmt=" + sellAmt + ", buyAmt=" + buyAmt + ", chgDt=" + chgDt + ", bexcRoleCd="
                + bexcRoleCd + ", bexcRoleCdNm=" + bexcRoleCdNm + ", putTimeUnitCd=" + putTimeUnitCd + ", putNopCount="
                + putNopCount + ", sumSellAmt=" + sumSellAmt + ", wctPrbbCdNm=" + wctPrbbCdNm + ", befBoptStatCdNm="
                + befBoptStatCdNm + ", befChgDt=" + befChgDt + ", befCntrBuyAmt=" + befCntrBuyAmt + ", cntrBuyAmt="
                + cntrBuyAmt + ", befCntrYam=" + befCntrYam + ", cntrYam=" + cntrYam + ", befWctPrbbNumVal=" + befWctPrbbNumVal
                + ", wctPrbbNumVal=" + wctPrbbNumVal + ", befWctPrbbCdNm=" + befWctPrbbCdNm + ", befFcstRflcYn=" + befFcstRflcYn
                + ", befCntrSellPrbbAmt=" + befCntrSellPrbbAmt + ", cntrSellPrbbAmt=" + cntrSellPrbbAmt + ", befCntrSellAmt="
                + befCntrSellAmt + ", cntrSellAmt=" + cntrSellAmt + ", befCntrBuyPrbbAmt=" + befCntrBuyPrbbAmt
                + ", cntrBuyPrbbAmt=" + cntrBuyPrbbAmt + ", befFcstYam=" + befFcstYam + ", befSellAmt=" + befSellAmt
                + ", befBuyAmt=" + befBuyAmt + ", befSellPrbbAmt=" + befSellPrbbAmt + ", sellPrbbAmt=" + sellPrbbAmt
                + ", befBuyPrbbAmt=" + befBuyPrbbAmt + ", buyPrbbAmt=" + buyPrbbAmt + ", befBexcRoleCd=" + befBexcRoleCd
                + ", befBexcRoleCdNm=" + befBexcRoleCdNm + ", befPutNopCount=" + befPutNopCount + ", befPutPrbbNopCount="
                + befPutPrbbNopCount + ", putPrbbNopCount=" + putPrbbNopCount +	", historyGroupCd=" + historyGroupCd
                + ", befCntrStartDate=" + befCntrStartDate + ", befCntrEndDate=" + befCntrEndDate + ", befSellStartDate="
                + befSellStartDate + ", befSellEndDate=" + befSellEndDate + ", befBuyStartDate=" + befBuyStartDate
                + ", befBuyEndDate=" + befBuyEndDate + ", chgStartDate=" + chgStartDate + ", chgEndDate=" + chgEndDate
                + ", userId=" + userId + ", totalCnt=" + totalCnt + ", exceptContractComplete=" + exceptContractComplete
                + ", boptStatCdList=" + boptStatCdList + ", wctPsbltCd=" + wctPsbltCd+ ", wctPsbltCdList=" + wctPsbltCdList+ "]";
    }
}
