package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BEST090T : 계약체결조건상세
 *
 */
public class OfferContractCondVO {

    /**
     * 예상손익ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 예상손익ID는 10자리 이하여야합니다." )
    private String fcstPalId;

    /**
     * 시퀀스
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer seq;

    /**
     * 계약체결조건코드
     */
    @NotNull
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 계약체결조건코드는 4자리 이하여야합니다." )
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
