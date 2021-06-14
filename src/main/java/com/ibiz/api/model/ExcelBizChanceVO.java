package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;
import com.ibiz.api.utils.Enum.CellType;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelBizChanceVO {

    @ColumnAttribute(Index = 0, Title = "프로젝트ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtId;
    @ColumnAttribute(Index = 1, Title = "프로젝트명", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String prjtNm;
    @ColumnAttribute(Index = 2, Title = "최종고객ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String lastCustId;
    @ColumnAttribute(Index = 3, Title = "최종고객명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String lastCustNm;
    @ColumnAttribute(Index = 4, Title = "프로젝트유형", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtTypeCdNm;
    @ColumnAttribute(Index = 5, Title = "사업중요도", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String bsnsDoiNm;
    @ColumnAttribute(Index = 6, Title = "총사업예산", ColumnWidth = 120, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String bsnsBdgtAmt;
    @ColumnAttribute(Index = 7, Title = "프로젝트상태", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtStatCdNm;
    @ColumnAttribute(Index = 8, Title = "사업기회ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptId;
    @ColumnAttribute(Index = 9, Title = "사업기회명", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String boptNm;
    /*@ColumnAttribute(Index = 10, Title = "사업분류", ColumnWidth = 80, CellStyleMethodName = "Content")
    private String bsnsClsfCdNm;*/
    @ColumnAttribute(Index = 10, Title = "발주업체ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String ordeCustId;
    @ColumnAttribute(Index = 11, Title = "발주업체명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String ordeCustNm;
    @ColumnAttribute(Index = 12, Title = "계약일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String cntrDate;
    @ColumnAttribute(Index = 13, Title = "계약이행시작일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String cntrTrsfStartYam;
    @ColumnAttribute(Index = 14, Title = "계약이행종료일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String cntrTrsfEndYam;
    @ColumnAttribute(Index = 15, Title = "제안마감일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String prpsFnshDate;
    @ColumnAttribute(Index = 16, Title = "입찰마감일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String bidFnshDate;
    @ColumnAttribute(Index = 17, Title = "업체선정일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String cmpySlctDate;
    @ColumnAttribute(Index = 18, Title = "매출액", ColumnWidth = 100, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String sumSellAmt;
    @ColumnAttribute(Index = 19, Title = "매입액", ColumnWidth = 100, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String sumBuyAmt;
    @ColumnAttribute(Index = 20, Title = "매출액(확률적용)", ColumnWidth = 120, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String fcstSellAmt;
    @ColumnAttribute(Index = 21, Title = "매입액(확률적용)", ColumnWidth = 120, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String fcstBuyAmt;
    @ColumnAttribute(Index = 22, Title = "예상투입인원", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String sumPutNopCount;
    @ColumnAttribute(Index = 23, Title = "수주가능성", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String wctPrbbCdNm;
    @ColumnAttribute(Index = 24, Title = "확률적용가중치", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String wctPrbbWgvl;
    @ColumnAttribute(Index = 25, Title = "예상반영어부", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String fcstRflcYn;
    @ColumnAttribute(Index = 26, Title = "사업기회상태", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptStatCdNm;
    @ColumnAttribute(Index = 27, Title = "기회종료유형", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptEndTypeCdNm;
    @ColumnAttribute(Index = 28, Title = "수주확정일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String wctDcdDate;
    @ColumnAttribute(Index = 29, Title = "영업부서ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsDeptId;
    @ColumnAttribute(Index = 30, Title = "영업부서명", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsDeptNm;
    @ColumnAttribute(Index = 31, Title = "영업대표ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsEmpId;
    @ColumnAttribute(Index = 32, Title = "영업대표명", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsEmpNm;
    @ColumnAttribute(Index = 33, Title = "등록자", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String regEmpNm;
    @ColumnAttribute(Index = 34, Title = "등록일시", ColumnWidth = 160, CellStyleMethodName = "Content")
    private String regDt;
    @ColumnAttribute(Index = 35, Title = "최종수정자", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String chgEmpNm;
    @ColumnAttribute(Index = 36, Title = "최종수정일시", ColumnWidth = 160, CellStyleMethodName = "Content")
    private String chgDt;

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
    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }
    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
    }
    public String getBsnsDoiNm() {
        return bsnsDoiNm;
    }
    public void setBsnsDoiNm(String bsnsDoiNm) {
        this.bsnsDoiNm = bsnsDoiNm;
    }
    public String getBsnsBdgtAmt() {
        return bsnsBdgtAmt;
    }
    public void setBsnsBdgtAmt(String bsnsBdgtAmt) {
        this.bsnsBdgtAmt = bsnsBdgtAmt;
    }
    public String getPrjtStatCdNm() {
        return prjtStatCdNm;
    }
    public void setPrjtStatCdNm(String prjtStatCdNm) {
        this.prjtStatCdNm = prjtStatCdNm;
    }
//    public String getBsnsClsfCdNm() {
//        return bsnsClsfCdNm;
//    }
//    public void setBsnsClsfCdNm(String bsnsClsfCdNm) {
//        this.bsnsClsfCdNm = bsnsClsfCdNm;
//    }
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
    public String getSumSellAmt() {
        return sumSellAmt;
    }
    public void setSumSellAmt(String sumSellAmt) {
        this.sumSellAmt = sumSellAmt;
    }
    public String getSumBuyAmt() {
        return sumBuyAmt;
    }
    public void setSumBuyAmt(String sumBuyAmt) {
        this.sumBuyAmt = sumBuyAmt;
    }
    public String getFcstSellAmt() {
        return fcstSellAmt;
    }
    public void setFcstSellAmt(String fcstSellAmt) {
        this.fcstSellAmt = fcstSellAmt;
    }
    public String getFcstBuyAmt() {
        return fcstBuyAmt;
    }
    public void setFcstBuyAmt(String fcstBuyAmt) {
        this.fcstBuyAmt = fcstBuyAmt;
    }
    public String getSumPutNopCount() {
        return sumPutNopCount;
    }
    public void setSumPutNopCount(String sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }
    public String getWctPrbbCdNm() {
        return wctPrbbCdNm;
    }
    public void setWctPrbbCdNm(String wctPrbbCdNm) {
        this.wctPrbbCdNm = wctPrbbCdNm;
    }
    public String getWctPrbbWgvl() {
        return wctPrbbWgvl;
    }
    public void setWctPrbbWgvl(String wctPrbbWgvl) {
        this.wctPrbbWgvl = wctPrbbWgvl;
    }
    public String getFcstRflcYn() {
        return fcstRflcYn;
    }
    public void setFcstRflcYn(String fcstRflcYn) {
        this.fcstRflcYn = fcstRflcYn;
    }
    public String getBoptStatCdNm() {
        return boptStatCdNm;
    }
    public void setBoptStatCdNm(String boptStatCdNm) {
        this.boptStatCdNm = boptStatCdNm;
    }
    public String getBoptEndTypeCdNm() {
        return boptEndTypeCdNm;
    }
    public void setBoptEndTypeCdNm(String boptEndTypeCdNm) {
        this.boptEndTypeCdNm = boptEndTypeCdNm;
    }
    public String getWctDcdDate() {
        return wctDcdDate;
    }
    public void setWctDcdDate(String wctDcdDate) {
        this.wctDcdDate = wctDcdDate;
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



}
