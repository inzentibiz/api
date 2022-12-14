package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;
import com.ibiz.api.utils.Enum.CellType;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelBizChanceAmountVO {

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
    @ColumnAttribute(Index = 5, Title = "프로젝트상세유형", ColumnWidth = 130, CellStyleMethodName = "Content")
    private String prjtDtlTypeCdNm;
    @ColumnAttribute(Index = 6, Title = "사업중요도", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String bsnsDoiNm;
    @ColumnAttribute(Index = 7, Title = "총사업예산", ColumnWidth = 120, CellStyleMethodName = "Content" , CellType=CellType.NumericComma)
    private String bsnsBdgtAmt;
    @ColumnAttribute(Index = 8, Title = "프로젝트상태", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtStatCdNm;
    @ColumnAttribute(Index = 9, Title = "프로젝트인입경로", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtInputCdNm;
    @ColumnAttribute(Index = 10, Title = "사업기회ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptId;
    @ColumnAttribute(Index = 11, Title = "사업기회명", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String boptNm;
    @ColumnAttribute(Index = 12, Title = "사업분류", ColumnWidth = 80, CellStyleMethodName = "Content")
    private String bsnsClsfCdNm;
    @ColumnAttribute(Index = 13, Title = "발주업체ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String ordeCustId;
    @ColumnAttribute(Index = 14, Title = "발주업체명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String ordeCustNm;
    @ColumnAttribute(Index = 15, Title = "계약일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String cntrDate;
    @ColumnAttribute(Index = 16, Title = "수주가능성", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String wctPrbbCdNm;
    @ColumnAttribute(Index = 17, Title = "확률적용가중치", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String wctPrbbWgvl;
    @ColumnAttribute(Index = 18, Title = "예상반영어부", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String fcstRflcYn;
    @ColumnAttribute(Index = 19, Title = "사업기회상태", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptStatCdNm;
    @ColumnAttribute(Index = 20, Title = "기회종료유형", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptEndTypeCdNm;
    @ColumnAttribute(Index = 21, Title = "영업부서ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsDeptId;
    @ColumnAttribute(Index = 22, Title = "영업부서명", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsDeptNm;
    @ColumnAttribute(Index = 23, Title = "영업대표ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsEmpId;
    @ColumnAttribute(Index = 24, Title = "영업대표명", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsEmpNm;
    @ColumnAttribute(Index = 25, Title = "매출매입연월", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String fcstYam;
    @ColumnAttribute(Index = 26, Title = "상품유형", ColumnWidth = 170, CellStyleMethodName = "Content")
    private String prodTypeCdNm;
    @ColumnAttribute(Index = 27, Title = "제품분류", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String godsClsfCdNm;
    @ColumnAttribute(Index = 28, Title = "매출액", ColumnWidth = 100, CellStyleMethodName = "Content", CellType=CellType.NumericComma)
    private String sellAmt;
    @ColumnAttribute(Index = 29, Title = "매입액", ColumnWidth = 100, CellStyleMethodName = "Content", CellType=CellType.NumericComma)
    private String buyAmt;
    @ColumnAttribute(Index = 30, Title = "매출액(확률적용)", ColumnWidth = 120, CellStyleMethodName = "Content", CellType=CellType.NumericComma)
    private String fcstSellAmt;
    @ColumnAttribute(Index = 31, Title = "매입액(확률적용)", ColumnWidth = 120, CellStyleMethodName = "Content", CellType=CellType.NumericComma)
    private String fcstBuyAmt;

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
    public String getPrjtDtlTypeCdNm() {
        return prjtDtlTypeCdNm;
    }
    public void setPrjtDtlTypeCdNm(String prjtDtlTypeCdNm) {
        this.prjtDtlTypeCdNm = prjtDtlTypeCdNm;
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
    public String getPrjtInputCdNm() {
        return prjtInputCdNm;
    }
    public void setPrjtInputCdNm(String prjtInputCdNm) {
        this.prjtInputCdNm = prjtInputCdNm;
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
    public String getBsnsClsfCdNm() {
        return bsnsClsfCdNm;
    }
    public void setBsnsClsfCdNm(String bsnsClsfCdNm) {
        this.bsnsClsfCdNm = bsnsClsfCdNm;
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
    public String getFcstYam() {
        return fcstYam;
    }
    public void setFcstYam(String fcstYam) {
        this.fcstYam = fcstYam;
    }
    public String getProdTypeCdNm() {
        return prodTypeCdNm;
    }
    public void setProdTypeCdNm(String prodTypeCdNm) {
        this.prodTypeCdNm = prodTypeCdNm;
    }
    public String getGodsClsfCdNm() {
        return godsClsfCdNm;
    }
    public void setGodsClsfCdNm(String godsClsfCdNm) {
        this.godsClsfCdNm = godsClsfCdNm;
    }
    public String getSellAmt() {
        return sellAmt;
    }
    public void setSellAmt(String sellAmt) {
        this.sellAmt = sellAmt;
    }
    public String getBuyAmt() {
        return buyAmt;
    }
    public void setBuyAmt(String buyAmt) {
        this.buyAmt = buyAmt;
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
}
