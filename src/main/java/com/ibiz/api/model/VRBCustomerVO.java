package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BPIP120T : VRB고객분석내역
 *
 */

public class VRBCustomerVO {

    /**
     * VRB분석ID
     */
    @NotNull
    @Size(max=10, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" VRB분석ID는 10자리 이하여야합니다." )
    private String vrbAnlyId;

    /**
     * 순번
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer seq;

    /**
     * 소속기관명
     */
    @NotNull
    private String bltoIsttNm;

    /**
     * 부서명
     */
    private String deptNm;

    /**
     * 고객명
     */
    @NotNull
    private String custNm;

    /**
     * 직급명
     */
    private String copsNm;

    /**
     * 직책명
     */
    private String resoNm;

    /**
     * 담당업무명
     */
    private String  crgJobNm;

    /**
     * 고객영향도코드
     */
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 고객영향도코드는 4자리 이하여야합니다." )
    private String custIndgCd;

    /**
     * 고객영향도명
     */
    private String custIndgCdNm;

    /**
     * 고객우호성향코드
     */
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 고객우호성향코드는 4자리 이하여야합니다." )
    private String custFdlInclnCd;

    /**
     * 고객우호성향명
     */
    private String custFdlInclnCdNm;

    /**
     * 비고내용
     */
    private String rmrkCont;

    public String getVrbAnlyId() {
        return vrbAnlyId;
    }

    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getBltoIsttNm() {
        return bltoIsttNm;
    }

    public void setBltoIsttNm(String bltoIsttNm) {
        this.bltoIsttNm = bltoIsttNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCopsNm() {
        return copsNm;
    }

    public void setCopsNm(String copsNm) {
        this.copsNm = copsNm;
    }

    public String getResoNm() {
        return resoNm;
    }

    public void setResoNm(String resoNm) {
        this.resoNm = resoNm;
    }

    public String getCrgJobNm() {
        return crgJobNm;
    }

    public void setCrgJobNm(String crgJobNm) {
        this.crgJobNm = crgJobNm;
    }

    public String getCustIndgCd() {
        return custIndgCd;
    }

    public void setCustIndgCd(String custIndgCd) {
        this.custIndgCd = custIndgCd;
    }

    public String getCustIndgCdNm() {
        return custIndgCdNm;
    }

    public void setCustIndgCdNm(String custIndgCdNm) {
        this.custIndgCdNm = custIndgCdNm;
    }

    public String getCustFdlInclnCd() {
        return custFdlInclnCd;
    }

    public void setCustFdlInclnCd(String custFdlInclnCd) {
        this.custFdlInclnCd = custFdlInclnCd;
    }

    public String getCustFdlInclnCdNm() {
        return custFdlInclnCdNm;
    }

    public void setCustFdlInclnCdNm(String custFdlInclnCdNm) {
        this.custFdlInclnCdNm = custFdlInclnCdNm;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
    }

    @Override
    public String toString() {
        return "VRBCustomerVO [vrbAnlyId=" + vrbAnlyId + ", seq=" + seq + ", bltoIsttNm=" + bltoIsttNm
                + ", deptNm=" + deptNm + ", custNm=" + custNm + ", copsNm=" + copsNm + ", resoNm=" + resoNm
                + ", crgJobNm=" + crgJobNm + ", custIndgCd=" + custIndgCd + ", custIndgCdNm=" + custIndgCdNm
                + ", custFdlInclnCd=" + custFdlInclnCd + ", custFdlInclnCdNm=" + custFdlInclnCdNm + ", rmrkCont=" + rmrkCont
                + "]";
    }

}
