package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;
import com.ibiz.api.utils.Enum.CellType;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelOfferProfitByProductVO {

    @ColumnAttribute(Index = 0, Title = "손익분석서ID", ColumnWidth = 120, CellStyleMethodName = "Content")
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

    @ColumnAttribute(Index = 15, Title = "손익진행상태", ColumnWidth = 130, CellStyleMethodName = "Content")
    private String fcstPalPrgsStatCdNm;

    @ColumnAttribute(Index = 16, Title = "상품유형", ColumnWidth = 140, CellStyleMethodName = "ContentLeft")
    private String prodTypeCdNm;

    @ColumnAttribute(Index = 17, Title = "상품순번", ColumnWidth = 80, CellStyleMethodName = "ContentRight")
    private String prodSeq;

    @ColumnAttribute(Index = 18, Title = "제품분류", ColumnWidth = 100, CellStyleMethodName = "ContentLeft")
    private String godsClsfCdNm;

    @ColumnAttribute(Index = 19, Title = "MA대상프로젝트ID", ColumnWidth = 130, CellStyleMethodName = "Content")
    private String maTgtPrjtId;

    @ColumnAttribute(Index = 20, Title = "MA대상프로젝트명", ColumnWidth = 350, CellStyleMethodName = "ContentLeft")
    private String maTgtPrjtNm;

    @ColumnAttribute(Index = 21, Title = "공급업체ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String splyCmpyCustId;

    @ColumnAttribute(Index = 22, Title = "공급업체명", ColumnWidth = 250, CellStyleMethodName = "ContentLeft")
    private String splyCmpyCustNm;

    @ColumnAttribute(Index = 23, Title = "상품팩ID", ColumnWidth = 100, CellStyleMethodName = "Content")
    private String prodpId;

    @ColumnAttribute(Index = 24, Title = "상품팩명", ColumnWidth = 140, CellStyleMethodName = "ContentLeft")
    private String prodpNm;

    @ColumnAttribute(Index = 25, Title = "서비스업무명", ColumnWidth = 350, CellStyleMethodName = "ContentLeft")
    private String svcJobNm;

    @ColumnAttribute(Index = 26, Title = "단가단위", ColumnWidth = 100, CellStyleMethodName = "ContentLeft")
    private String upcUnitNm;

    @ColumnAttribute(Index = 27, Title = "단위수량", ColumnWidth = 90, CellStyleMethodName ="ContentRight", CellType=CellType.Numeric)
    private String unitQnt;

    @ColumnAttribute(Index = 28, Title = "COPY수량", ColumnWidth = 90, CellStyleMethodName ="ContentRight", CellType=CellType.Numeric)
    private String copyQnt;

    @ColumnAttribute(Index = 29, Title = "표준단가", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String stdUpcAmt;

    @ColumnAttribute(Index = 30, Title = "가격할인정책율", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.Percent2)
    private String prcPlcyDcRt;

    @ColumnAttribute(Index = 31, Title = "기본단가(할인단가)", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String bscUpcAmt;

    @ColumnAttribute(Index = 32, Title = "ListPrice", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String lpcAmt;

    @ColumnAttribute(Index = 33, Title = "구매단가", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String pchsUpcAmt;

    @ColumnAttribute(Index = 34, Title = "구매금액", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String pchsAmt;

    @ColumnAttribute(Index = 35, Title = "MA제품공급가", ColumnWidth = 130, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String maGodsSplyAmt;

    @ColumnAttribute(Index = 36, Title = "MA요율", ColumnWidth = 90, CellStyleMethodName = "ContentRight", CellType=CellType.Percent2)
    private String maTrf;

    @ColumnAttribute(Index = 37, Title = "MA시작일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String maStartDate;

    @ColumnAttribute(Index = 38, Title = "MA종료일", ColumnWidth = 110, CellStyleMethodName = "Content")
    private String maEndDate;

    @ColumnAttribute(Index = 39, Title = "공급단가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String splyUpcAmt;

    @ColumnAttribute(Index = 40, Title = "공급가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String splyAmt;

    @ColumnAttribute(Index = 41, Title = "기본원가율", ColumnWidth = 90, CellStyleMethodName = "ContentRight", CellType=CellType.Percent2)
    private String bscCostRt;

    @ColumnAttribute(Index = 42, Title = "적용원가율", ColumnWidth = 90, CellStyleMethodName = "ContentRight", CellType=CellType.Percent2)
    private String aplcnCostRt;

    @ColumnAttribute(Index = 43, Title = "투입인력등급", ColumnWidth = 130, CellStyleMethodName = "ContentLeft")
    private String putHmfrGrdCdNm;

    @ColumnAttribute(Index = 44, Title = "표준원가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String stdCostAmt;

    @ColumnAttribute(Index = 45, Title = "투입인원수", ColumnWidth = 100, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String putNopCount;

    @ColumnAttribute(Index = 46, Title = "직접원가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String drcstAmt;

    @ColumnAttribute(Index = 47, Title = "간접원가", ColumnWidth = 110, CellStyleMethodName = "ContentRight", CellType=CellType.NumericComma)
    private String incstAmt;

    @ColumnAttribute(Index = 48, Title = "내장형여부", ColumnWidth = 80, CellStyleMethodName = "Content")
    private String embGodsYn;

    @ColumnAttribute(Index = 49, Title = "추가구매여부", ColumnWidth = 80, CellStyleMethodName = "Content")
    private String splmPchsYn;

    @ColumnAttribute(Index = 50, Title = "견적비고", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String estiRmrkCont;

    @ColumnAttribute(Index = 51, Title = "원가비고", ColumnWidth = 400, CellStyleMethodName = "ContentLeft")
    private String costRmrkCont;

    @ColumnAttribute(Index = 52, Title = "등록일시", ColumnWidth = 160, CellStyleMethodName = "Content")
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

    public String getProdSeq() {
        return prodSeq;
    }

    public void setProdSeq(String prodSeq) {
        this.prodSeq = prodSeq;
    }

    public String getGodsClsfCdNm() {
        return godsClsfCdNm;
    }

    public void setGodsClsfCdNm(String godsClsfCdNm) {
        this.godsClsfCdNm = godsClsfCdNm;
    }

    public String getMaTgtPrjtId() {
        return maTgtPrjtId;
    }

    public void setMaTgtPrjtId(String maTgtPrjtId) {
        this.maTgtPrjtId = maTgtPrjtId;
    }

    public String getMaTgtPrjtNm() {
        return maTgtPrjtNm;
    }

    public void setMaTgtPrjtNm(String maTgtPrjtNm) {
        this.maTgtPrjtNm = maTgtPrjtNm;
    }

    public String getProdpId() {
        return prodpId;
    }

    public void setProdpId(String prodpId) {
        this.prodpId = prodpId;
    }

    public String getProdpNm() {
        return prodpNm;
    }

    public void setProdpNm(String prodpNm) {
        this.prodpNm = prodpNm;
    }

    public String getSvcJobNm() {
        return svcJobNm;
    }

    public void setSvcJobNm(String svcJobNm) {
        this.svcJobNm = svcJobNm;
    }

    public String getUpcUnitNm() {
        return upcUnitNm;
    }

    public void setUpcUnitNm(String upcUnitNm) {
        this.upcUnitNm = upcUnitNm;
    }

    public String getUnitQnt() {
        return unitQnt;
    }

    public void setUnitQnt(String unitQnt) {
        this.unitQnt = unitQnt;
    }

    public String getCopyQnt() {
        return copyQnt;
    }

    public void setCopyQnt(String copyQnt) {
        this.copyQnt = copyQnt;
    }

    public String getStdUpcAmt() {
        return stdUpcAmt;
    }

    public void setStdUpcAmt(String stdUpcAmt) {
        this.stdUpcAmt = stdUpcAmt;
    }

    public String getPrcPlcyDcRt() {
        return prcPlcyDcRt;
    }

    public void setPrcPlcyDcRt(String prcPlcyDcRt) {
        this.prcPlcyDcRt = prcPlcyDcRt;
    }

    public String getBscUpcAmt() {
        return bscUpcAmt;
    }

    public void setBscUpcAmt(String bscUpcAmt) {
        this.bscUpcAmt = bscUpcAmt;
    }

    public String getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(String lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public String getPchsUpcAmt() {
        return pchsUpcAmt;
    }

    public void setPchsUpcAmt(String pchsUpcAmt) {
        this.pchsUpcAmt = pchsUpcAmt;
    }

    public String getPchsAmt() {
        return pchsAmt;
    }

    public void setPchsAmt(String pchsAmt) {
        this.pchsAmt = pchsAmt;
    }

    public String getMaGodsSplyAmt() {
        return maGodsSplyAmt;
    }

    public void setMaGodsSplyAmt(String maGodsSplyAmt) {
        this.maGodsSplyAmt = maGodsSplyAmt;
    }

    public String getMaTrf() {
        return maTrf;
    }

    public void setMaTrf(String maTrf) {
        this.maTrf = maTrf;
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

    public String getSplyUpcAmt() {
        return splyUpcAmt;
    }

    public void setSplyUpcAmt(String splyUpcAmt) {
        this.splyUpcAmt = splyUpcAmt;
    }

    public String getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(String splyAmt) {
        this.splyAmt = splyAmt;
    }

    public String getBscCostRt() {
        return bscCostRt;
    }

    public void setBscCostRt(String bscCostRt) {
        this.bscCostRt = bscCostRt;
    }

    public String getAplcnCostRt() {
        return aplcnCostRt;
    }

    public void setAplcnCostRt(String aplcnCostRt) {
        this.aplcnCostRt = aplcnCostRt;
    }

    public String getPutHmfrGrdCdNm() {
        return putHmfrGrdCdNm;
    }

    public void setPutHmfrGrdCdNm(String putHmfrGrdCdNm) {
        this.putHmfrGrdCdNm = putHmfrGrdCdNm;
    }

    public String getStdCostAmt() {
        return stdCostAmt;
    }

    public void setStdCostAmt(String stdCostAmt) {
        this.stdCostAmt = stdCostAmt;
    }

    public String getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(String putNopCount) {
        this.putNopCount = putNopCount;
    }

    public String getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(String drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public String getIncstAmt() {
        return incstAmt;
    }

    public void setIncstAmt(String incstAmt) {
        this.incstAmt = incstAmt;
    }

    public String getEmbGodsYn() {
        return embGodsYn;
    }

    public void setEmbGodsYn(String embGodsYn) {
        this.embGodsYn = embGodsYn;
    }

    public String getSplmPchsYn() {
        return splmPchsYn;
    }

    public void setSplmPchsYn(String splmPchsYn) {
        this.splmPchsYn = splmPchsYn;
    }

    public String getEstiRmrkCont() {
        return estiRmrkCont;
    }

    public void setEstiRmrkCont(String estiRmrkCont) {
        this.estiRmrkCont = estiRmrkCont;
    }

    public String getCostRmrkCont() {
        return costRmrkCont;
    }

    public void setCostRmrkCont(String costRmrkCont) {
        this.costRmrkCont = costRmrkCont;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }



}
