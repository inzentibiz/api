package com.ibiz.api.model;

/**
 *
 * BPIP130T : VRB경쟁사분석내역
 *
 */

public class VRBCompetitorAnalysisVO {

    /**
     * VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 업체명
     */
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
    private String godsCpttSupCd;

    /**
     * 제품경쟁우위명
     */
    private String godsCpttSupNm;

    /**
     * 가격경쟁우위코드
     */
    private String prcCpttSupCd;

    /**
     * 가격경쟁우위명
     */
    private String prcCpttSupNm;

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

    public String getGodsCpttSupNm() {
        return godsCpttSupNm;
    }

    public void setGodsCpttSupNm(String godsCpttSupNm) {
        this.godsCpttSupNm = godsCpttSupNm;
    }

    public String getPrcCpttSupCd() {
        return prcCpttSupCd;
    }

    public void setPrcCpttSupCd(String prcCpttSupCd) {
        this.prcCpttSupCd = prcCpttSupCd;
    }

    public String getPrcCpttSupNm() {
        return prcCpttSupNm;
    }

    public void setPrcCpttSupNm(String prcCpttSupNm) {
        this.prcCpttSupNm = prcCpttSupNm;
    }

    @Override
    public String toString() {
        return "VRBCompetitorAnalysisVO [vrbAnlyId=" + vrbAnlyId + ", seq=" + seq + ", cmpyNm=" + cmpyNm + ", strhCont="
                + strhCont + ", wknsCont=" + wknsCont + ", cpttGodsNm=" + cpttGodsNm + ", godsCpttSupCd="
                + godsCpttSupCd + ", godsCpttSupNm=" + godsCpttSupNm + ", prcCpttSupCd=" + prcCpttSupCd
                + ", prcCpttSupNm=" + prcCpttSupNm + "]";
    }

}
