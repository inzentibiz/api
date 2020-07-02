package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BPIP130T : VRB경쟁사분석내역
 *
 */

public class VRBCompetitorVO {

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
     * 업체명
     */
    @NotNull
    private String cmpyNm;

    /**
     * 강점내용
     */
    private String strhCont;

    /**
     * 약점내용
     */
    private String wknsCont;

    /**
     * 경쟁제품명
     */
    private String cpttGodsNm;

    /**
     * 제품경쟁우위코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 제품경쟁우위코드는 4자리 이하여야합니다." )
    private String godsCpttSupCd;

    /**
     * 제품경쟁우위명
     */
    private String godsCpttSupCdNm;

    /**
     * 가격경쟁우위코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 가격경쟁우위코드는 4자리 이하여야합니다." )
    private String prcCpttSupCd;

    /**
     * 가격경쟁우위명
     */
    private String prcCpttSupCdNm;

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

    public String getCmpyNm() {
        return cmpyNm;
    }

    public void setCmpyNm(String cmpyNm) {
        this.cmpyNm = cmpyNm;
    }

    public String getStrhCont() {
        return strhCont;
    }

    public void setStrhCont(String strhCont) {
        this.strhCont = strhCont;
    }

    public String getWknsCont() {
        return wknsCont;
    }

    public void setWknsCont(String wknsCont) {
        this.wknsCont = wknsCont;
    }

    public String getCpttGodsNm() {
        return cpttGodsNm;
    }

    public void setCpttGodsNm(String cpttGodsNm) {
        this.cpttGodsNm = cpttGodsNm;
    }

    public String getGodsCpttSupCd() {
        return godsCpttSupCd;
    }

    public void setGodsCpttSupCd(String godsCpttSupCd) {
        this.godsCpttSupCd = godsCpttSupCd;
    }

    public String getGodsCpttSupCdNm() {
        return godsCpttSupCdNm;
    }

    public void setGodsCpttSupCdNm(String godsCpttSupCdNm) {
        this.godsCpttSupCdNm = godsCpttSupCdNm;
    }

    public String getPrcCpttSupCd() {
        return prcCpttSupCd;
    }

    public void setPrcCpttSupCd(String prcCpttSupCd) {
        this.prcCpttSupCd = prcCpttSupCd;
    }

    public String getPrcCpttSupCdNm() {
        return prcCpttSupCdNm;
    }

    public void setPrcCpttSupCdNm(String prcCpttSupCdNm) {
        this.prcCpttSupCdNm = prcCpttSupCdNm;
    }

    @Override
    public String toString() {
        return "VRBCompetitorVO [vrbAnlyId=" + vrbAnlyId + ", seq=" + seq + ", cmpyNm=" + cmpyNm + ", strhCont="
                + strhCont + ", wknsCont=" + wknsCont + ", cpttGodsNm=" + cpttGodsNm + ", godsCpttSupCd="
                + godsCpttSupCd + ", godsCpttSupCdNm=" + godsCpttSupCdNm + ", prcCpttSupCd=" + prcCpttSupCd
                + ", prcCpttSupCdNm=" + prcCpttSupCdNm + "]";
    }

}
