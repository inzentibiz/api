package com.ibiz.api.model;
/**
 *
 * BEST090T : 계약체결조건상세
 *
 */
public class OfferContractCondVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * 시퀀스
     */
    private Integer seq;

    /**
     * 계약체결조건코드
     */
    private String cntrCnclsCdntCd;

    /**
     * 계약체결조건코드명
     */
    private String cntrCnclsCdntCdNm;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getCntrCnclsCdntCd() {
        return cntrCnclsCdntCd;
    }

    public void setCntrCnclsCdntCd(String cntrCnclsCdntCd) {
        this.cntrCnclsCdntCd = cntrCnclsCdntCd;
    }

    public String getCntrCnclsCdntCdNm() {
        return cntrCnclsCdntCdNm;
    }

    public void setCntrCnclsCdntCdNm(String cntrCnclsCdntCdNm) {
        this.cntrCnclsCdntCdNm = cntrCnclsCdntCdNm;
    }


}
