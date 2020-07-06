package com.ibiz.api.model;

public class VRBBizChanceVO {

    /**
     * 분석일
     */
    private String anlyDt;

    /**
     * 결재ID
     */
    private String santId;

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * 사업기회ID
     */
    private String boptId;

    /**
     * 사업기회명
     */
    private String boptNm;

    /**
     * 순매출
     */
    private Long nsleAmt;

    /**
     * 공헌이익
     */
    private Long ctmgAmt;

    /**
     * 계약업체ID
     */
    private String ordeCustId;

    /**
     * 계약업체명
     */
    private String ordeCustNm;

    /**
     * 총매출액
     */
    private Long splyAmt;

    /**
     * 투입인원수
     */
    private String putNopCount;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 투입시간단위명
     */
    private String putTimeUnitCdNm;

    /**
     * 수주확률코드
     */
    private String wctPrbbCd;

    /**
     * 수주확률
     */
    private String wctPrbbCdNm;

    /**
     * 제안마감일자
     */
    private String prpsFnshDate;

    /**
     * 입찰마감일자
     */
    private String bidFnshDate;

    /**
     * 계약일자
     */
    private String cntrDate;

    /**
     * 체크박스선택여부
     */
    private String checkBox;

    /**
     * 프로젝트ID
     */
    private String prjtId;

    /**
     * 문서번호
     */
    private String docNo;

    /**
     * 예상손익상태
     */
    private String fcstPalPrgsStatCdNm;

    public String getAnlyDt() {
        return anlyDt;
    }

    public void setAnlyDt(String anlyDt) {
        this.anlyDt = anlyDt;
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

    public String getBoptNm() {
        return boptNm;
    }

    public void setBoptNm(String boptNm) {
        this.boptNm = boptNm;
    }

    public Long getNsleAmt() {
        return nsleAmt;
    }

    public void setNsleAmt(Long nsleAmt) {
        this.nsleAmt = nsleAmt;
    }

    public Long getCtmgAmt() {
        return ctmgAmt;
    }

    public void setCtmgAmt(Long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
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

    public Long getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(Long splyAmt) {
        this.splyAmt = splyAmt;
    }

    public String getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(String putNopCount) {
        this.putNopCount = putNopCount;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public String getPutTimeUnitCdNm() {
        return putTimeUnitCdNm;
    }

    public void setPutTimeUnitCdNm(String putTimeUnitCdNm) {
        this.putTimeUnitCdNm = putTimeUnitCdNm;
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

    public String getCntrDate() {
        return cntrDate;
    }

    public void setCntrDate(String cntrDate) {
        this.cntrDate = cntrDate;
    }

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
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

    @Override
    public String toString() {
        return "VRBBizChanceVO [anlyDt=" + anlyDt + ", fcstPalId=" + fcstPalId + ", boptId=" + boptId + ", boptNm="
                + boptNm + ", nsleAmt=" + nsleAmt + ", ctmgAmt=" + ctmgAmt + ", ordeCustId=" + ordeCustId
                + ", ordeCustNm=" + ordeCustNm + ", splyAmt=" + splyAmt + ", putNopCount=" + putNopCount
                + ", putTimeUnitCd=" + putTimeUnitCd + ", putTimeUnitCdNm=" + putTimeUnitCdNm + ", wctPrbbCd=" + wctPrbbCd
                + ", wctPrbbCdNm=" + wctPrbbCdNm + ", prpsFnshDate=" + prpsFnshDate + ", bidFnshDate=" + bidFnshDate
                + ", cntrDate=" + cntrDate + ", checkBox=" + checkBox + ", docNo=" + docNo + ", santId=" + santId
                + ", fcstPalPrgsStatCdNm=" + fcstPalPrgsStatCdNm +"]";
    }


}
