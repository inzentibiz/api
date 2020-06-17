package com.ibiz.api.model;

/**
 *
 * BPIP170T : VRB참여자상세
 *
 */

public class VRBParticipantVO {

    /**
     * VRB분석ID
     */
    private String vrbAnlyId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 조직구분코드
     */
    private String orgDstCd;

    /**
     * 조직구분코드명
     */
    private String orgDstNm;

    /**
     * 검토자부서ID
     */
    private String rvwrDeptId;

    /**
     * 검토자부서명
     */
    private String rvwrDeptNm;

    /**
     * 검토자사원ID
     */
    private String rvwrEmpId;

    /**
     * 검토자사원ID
     */
    private String rvwrEmpNm;

    /**
     * 검토자직책코드
     */
    private String rvwrResoCd;

    /**
     * 검토자직책명
     */
    private String rvwrResoNm;

    /**
     * 검토자직위코드
     */
    private String rvwrOfpsCd;

    /**
     * 검토자직위코드명
     */
    private String rvwrOfpsNm;

    /**
     * 검토의견내용
     */
    private String rvwOpinCont;

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

    public String getOrgDstCd() {
        return orgDstCd;
    }

    public void setOrgDstCd(String orgDstCd) {
        this.orgDstCd = orgDstCd;
    }

    public String getOrgDstNm() {
        return orgDstNm;
    }

    public void setOrgDstNm(String orgDstNm) {
        this.orgDstNm = orgDstNm;
    }

    public String getRvwrDeptId() {
        return rvwrDeptId;
    }

    public void setRvwrDeptId(String rvwrDeptId) {
        this.rvwrDeptId = rvwrDeptId;
    }

    public String getRvwrDeptNm() {
        return rvwrDeptNm;
    }

    public void setRvwrDeptNm(String rvwrDeptNm) {
        this.rvwrDeptNm = rvwrDeptNm;
    }

    public String getRvwrEmpId() {
        return rvwrEmpId;
    }

    public void setRvwrEmpId(String rvwrEmpId) {
        this.rvwrEmpId = rvwrEmpId;
    }

    public String getRvwrEmpNm() {
        return rvwrEmpNm;
    }

    public void setRvwrEmpNm(String rvwrEmpNm) {
        this.rvwrEmpNm = rvwrEmpNm;
    }

    public String getRvwrResoCd() {
        return rvwrResoCd;
    }

    public void setRvwrResoCd(String rvwrResoCd) {
        this.rvwrResoCd = rvwrResoCd;
    }

    public String getRvwrResoNm() {
        return rvwrResoNm;
    }

    public void setRvwrResoNm(String rvwrResoNm) {
        this.rvwrResoNm = rvwrResoNm;
    }

    public String getRvwrOfpsCd() {
        return rvwrOfpsCd;
    }

    public void setRvwrOfpsCd(String rvwrOfpsCd) {
        this.rvwrOfpsCd = rvwrOfpsCd;
    }

    public String getRvwrOfpsNm() {
        return rvwrOfpsNm;
    }

    public void setRvwrOfpsNm(String rvwrOfpsNm) {
        this.rvwrOfpsNm = rvwrOfpsNm;
    }

    public String getRvwOpinCont() {
        return rvwOpinCont;
    }

    public void setRvwOpinCont(String rvwOpinCont) {
        this.rvwOpinCont = rvwOpinCont;
    }

    @Override
    public String toString() {
        return "VRBParticipantVO [vrbAnlyId=" + vrbAnlyId + ", seq=" + seq + ", orgDstCd=" + orgDstCd + ", orgDstNm="
                + orgDstNm + ", rvwrDeptId=" + rvwrDeptId + ", rvwrDeptNm=" + rvwrDeptNm + ", rvwrEmpId=" + rvwrEmpId
                + ", rvwrEmpNm=" + rvwrEmpNm + ", rvwrResoCd=" + rvwrResoCd + ", rvwrResoNm=" + rvwrResoNm
                + ", rvwrOfpsCd=" + rvwrOfpsCd + ", rvwrOfpsNm=" + rvwrOfpsNm + ", rvwOpinCont=" + rvwOpinCont + "]";
    }

}
