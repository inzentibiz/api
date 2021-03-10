package com.ibiz.api.model;
// 수익보고테이블
// WMST200T
public class ProfitReportVO {

    // 수익보고ID
    private String ernnRprtId;

    // 프로젝트ID
    private String prjtId;

    // 프로젝트명
    private String prjtNm;

    // 수주ID
    private String wctId;

    // 예상손익ID
    private String fcstPalId;

    // 수익보고진행상태코드
    private String erptPrgsStatCd;

    // 수익보고진행상태코드명
    private String erptPrgsStatCdNm;

    // 수주금액
    private Long wctAmt;

    // 비용유형코드
    private String expTypeCd;

    // 비용유형코드명
    private String expTypeCdNm;

    // 유형금액
    private Long expTypeAmt;

    // 산출내용
    private String cmptCritCont;

    // CBS코드
    private String cbsCd;

    // 기준연도
    private String critYear;

    // 기준월
    private String critMon;

    // 부서
    private String slsDeptId;

    public String getErnnRprtId() {
        return ernnRprtId;
    }

    public void setErnnRprtId(String ernnRprtId) {
        this.ernnRprtId = ernnRprtId;
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

    public String getWctId() {
        return wctId;
    }

    public void setWctId(String wctId) {
        this.wctId = wctId;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getErptPrgsStatCd() {
        return erptPrgsStatCd;
    }

    public void setErptPrgsStatCd(String erptPrgsStatCd) {
        this.erptPrgsStatCd = erptPrgsStatCd;
    }

    public String getErptPrgsStatCdNm() {
        return erptPrgsStatCdNm;
    }

    public void setErptPrgsStatCdNm(String erptPrgsStatCdNm) {
        this.erptPrgsStatCdNm = erptPrgsStatCdNm;
    }

    public Long getWctAmt() {
        return wctAmt;
    }

    public void setWctAmt(Long wctAmt) {
        this.wctAmt = wctAmt;
    }

    public String getExpTypeCd() {
        return expTypeCd;
    }

    public void setExpTypeCd(String expTypeCd) {
        this.expTypeCd = expTypeCd;
    }

    public String getExpTypeCdNm() {
        return expTypeCdNm;
    }

    public void setExpTypeCdNm(String expTypeCdNm) {
        this.expTypeCdNm = expTypeCdNm;
    }

    public Long getExpTypeAmt() {
        return expTypeAmt;
    }

    public void setExpTypeAmt(Long expTypeAmt) {
        this.expTypeAmt = expTypeAmt;
    }

    public String getCmptCritCont() {
        return cmptCritCont;
    }

    public void setCmptCritCont(String cmptCritCont) {
        this.cmptCritCont = cmptCritCont;
    }

    public String getCbsCd() {
        return cbsCd;
    }

    public void setCbsCd(String cbsCd) {
        this.cbsCd = cbsCd;
    }
}
