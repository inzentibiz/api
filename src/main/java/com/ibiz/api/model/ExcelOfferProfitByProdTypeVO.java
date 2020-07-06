package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;
import com.ibiz.api.utils.Enum.CellType;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelOfferProfitByProdTypeVO {
    @ColumnAttribute(Index = 0, Title = "예상손익분석서ID", ColumnWidth = 120, CellStyleMethodName = "Content")
    private String fcstPalId;

    @ColumnAttribute(Index = 1, Title = "문서번호", ColumnWidth = 180, CellStyleMethodName = "Content")
    private String docNo;

    @ColumnAttribute(Index = 2, Title = "영업부서", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsDeptNm;

    @ColumnAttribute(Index = 3, Title = "영업대표", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String slsEmpNm;

    @ColumnAttribute(Index = 4, Title = "프로젝트유형", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtTypeCdNm;

    @ColumnAttribute(Index = 5, Title = "최종고객ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String lastCustId;

    @ColumnAttribute(Index = 6, Title = "최종고객명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String lastCustNm;

    @ColumnAttribute(Index = 7, Title = "프로젝트ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prjtId;

    @ColumnAttribute(Index = 8, Title = "프로젝트명", ColumnWidth = 350, CellStyleMethodName = "ContentLeft")
    private String prjtNm;

    @ColumnAttribute(Index = 9, Title = "사업기회ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String boptId;

    @ColumnAttribute(Index = 10, Title = "사업기회명", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String boptNm;

    @ColumnAttribute(Index = 11, Title = "발주업체ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String ordeCustId;

    @ColumnAttribute(Index = 12, Title = "발주업체명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String ordeCustNm;

    @ColumnAttribute(Index = 13, Title = "계약이행시작월", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String cntrTrsfStartYam;

    @ColumnAttribute(Index = 14, Title = "계약이행종료월", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String cntrTrsfEndYam;

    @ColumnAttribute(Index = 15, Title = "예상손익진행상태", ColumnWidth = 130, CellStyleMethodName = "Content")
    private String fcstPalPrgsStatCdNm;

    @ColumnAttribute(Index = 16, Title = "상품유형", ColumnWidth = 140, CellStyleMethodName = "ContentLeft")
    private String prodTypeCdNm;

    @ColumnAttribute(Index = 17, Title = "제품분류", ColumnWidth = 100, CellStyleMethodName = "ContentLeft")
    private String godsClsfCdNm;

    @ColumnAttribute(Index = 18, Title = "매출액", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String sellAmt;

    @ColumnAttribute(Index = 19, Title = "매입원가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String buyCostAmt;

    @ColumnAttribute(Index = 20, Title = "매입외 직접원가", ColumnWidth = 120, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String drcstAmt;

    @ColumnAttribute(Index = 21, Title = "직접경비", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String drexpAmt;

    @ColumnAttribute(Index = 22, Title = "간접원가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String incstAmt;

    @ColumnAttribute(Index = 23, Title = "공헌이익", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String ctmgAmt;

    @ColumnAttribute(Index = 24, Title = "예상투입인원", ColumnWidth = 100, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String putNopCount;

    @ColumnAttribute(Index = 25, Title = "투입시간단위", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String putTimeUnitCdNm;

    @ColumnAttribute(Index = 26, Title = "등록일시", ColumnWidth = 160, CellStyleMethodName = "Content")
    private String regDt;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getSlsDeptNm() {
        return slsDeptNm;
    }

    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }

    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
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

    public String getFcstPalPrgsStatCdNm() {
        return fcstPalPrgsStatCdNm;
    }

    public void setFcstPalPrgsStatCdNm(String fcstPalPrgsStatCdNm) {
        this.fcstPalPrgsStatCdNm = fcstPalPrgsStatCdNm;
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

    public String getBuyCostAmt() {
        return buyCostAmt;
    }

    public void setBuyCostAmt(String buyCostAmt) {
        this.buyCostAmt = buyCostAmt;
    }

    public String getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(String drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public String getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(String drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

    public String getIncstAmt() {
        return incstAmt;
    }

    public void setIncstAmt(String incstAmt) {
        this.incstAmt = incstAmt;
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

    public String getPutTimeUnitCdNm() {
        return putTimeUnitCdNm;
    }

    public void setPutTimeUnitCdNm(String putTimeUnitCdNm) {
        this.putTimeUnitCdNm = putTimeUnitCdNm;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }


}
