package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BPIP150T : VRB사업분석내역
 *
 */


public class VRBStrategyVO {

    /**
     * VRB분석ID
     */
    @NotNull
    @Size(max=10, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" VRB분석ID는 10자리 이하여야합니다." )
    private String vrbAnlyId;

    /**
     * VRB분석유형코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" VRB분석유형코드는 4자리 이하여야합니다." )
    private String vrbAnlyTypeCd;

    /**
     * VRB분석유형명
     */
    private String vrbAnlyTypeCdNm;

    /**
     * VRB분석항목코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" VRB분석항목코드는 4자리 이하여야합니다." )
    private String vrbAnlyItmCd;

    /**
     * VRB분석항목명
     */
    private String vrbAnlyItmCdNm;

    /**
     * 현황분석내용
     */
    private String prscdAnlyCont;

    /**
     * 실행방안내용
     */
    private String runSchmCont;

    /**
     * 지원요청내용
     */
    private String sprtReqCont;

    public String getVrbAnlyId() {
        return vrbAnlyId;
    }

    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }

    public String getVrbAnlyTypeCd() {
        return vrbAnlyTypeCd;
    }

    public void setVrbAnlyTypeCd(String vrbAnlyTypeCd) {
        this.vrbAnlyTypeCd = vrbAnlyTypeCd;
    }

    public String getVrbAnlyTypeCdNm() {
        return vrbAnlyTypeCdNm;
    }

    public void setVrbAnlyTypeCdNm(String vrbAnlyTypeCdNm) {
        this.vrbAnlyTypeCdNm = vrbAnlyTypeCdNm;
    }

    public String getVrbAnlyItmCd() {
        return vrbAnlyItmCd;
    }

    public void setVrbAnlyItmCd(String vrbAnlyItmCd) {
        this.vrbAnlyItmCd = vrbAnlyItmCd;
    }

    public String getVrbAnlyItmCdNm() {
        return vrbAnlyItmCdNm;
    }

    public void setVrbAnlyItmCdNm(String vrbAnlyItmCdNm) {
        this.vrbAnlyItmCdNm = vrbAnlyItmCdNm;
    }

    public String getPrscdAnlyCont() {
        return prscdAnlyCont;
    }

    public void setPrscdAnlyCont(String prscdAnlyCont) {
        this.prscdAnlyCont = prscdAnlyCont;
    }

    public String getRunSchmCont() {
        return runSchmCont;
    }

    public void setRunSchmCont(String runSchmCont) {
        this.runSchmCont = runSchmCont;
    }

    public String getSprtReqCont() {
        return sprtReqCont;
    }

    public void setSprtReqCont(String sprtReqCont) {
        this.sprtReqCont = sprtReqCont;
    }

    @Override
    public String toString() {
        return "VRBStrategyVO [vrbAnlyId=" + vrbAnlyId + ", vrbAnlyTypeCd=" + vrbAnlyTypeCd + ", vrbAnlyTypeCdNm="
                + vrbAnlyTypeCdNm + ", vrbAnlyItmCd=" + vrbAnlyItmCd + ", vrbAnlyItmCdNm=" + vrbAnlyItmCdNm
                + ", prscdAnlyCont=" + prscdAnlyCont + ", runSchmCont=" + runSchmCont + ", sprtReqCont=" + sprtReqCont
                + "]";
    }

}