package com.ibiz.api.model;

public class ApprovalDetailVO {

    /**
     * 결재 ID
     */
    private String santId;

    /**
     * 결재 진행상태
     */
    private Boolean isInProgress;

    /**
     * 결재 순번
     */
    private String santSeq;

    /**
     * 결재자 역할 코드
     */
    private String aprnRoleCd;

    /**
     * 결재자 역할 이름
     */
    private String aprnRoleNm;

    /**
     * 결재부서 ID
     */
    private String santDeptId;


    /**
     * 결재부서명
     */
    private String santDeptNm;

    /**
     * 결재자 사원 ID
     */
    private String aprnEmpId;

    /**
     * 결재자사원명
     */
    private String aprnEmpNm;

    /**
     * 결재자 직책 코드
     */
    private String aprnResoCd;

    /**
     * 결재자 직책 이름
     */
    private String aprnResoNm;

    /**
     * 결재자 직위 코드
     */
    private String aprnOfpsCd;

    /**
     * 결재자 직위 이름
     */
    private String aprnOfpsNm;

    /**
     * 결재의견내용
     */
    private String santOpinCont;

    /**
     * 결재 승인 구분 코드
     */
    private String santAppvDstCd;

    /**
     * 결재 승인 구분 이름
     */
    private String santAppvDstNm;

    /**
     * 결재 일시
     */
    private String santDt;

    /**
     * 결재알림 구분코드
     */
    private String santNtcDstCd;

    /**
     * 결재서식코드
     */
    private String santFrmtCd;

    private String sessEmpId;

    private UserGrpVO userGrpVO;

    private String mdtrAprnYn;

    private String url;

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public Boolean getIsInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(Boolean isInProgress) {
        this.isInProgress = isInProgress;
    }

    public String getSantSeq() {
        return santSeq;
    }

    public void setSantSeq(String santSeq) {
        this.santSeq = santSeq;
    }

    public String getAprnRoleCd() {
        return aprnRoleCd;
    }

    public void setAprnRoleCd(String aprnRoleCd) {
        this.aprnRoleCd = aprnRoleCd;
    }

    public String getAprnRoleNm() {
        return aprnRoleNm;
    }

    public void setAprnRoleNm(String aprnRoleNm) {
        this.aprnRoleNm = aprnRoleNm;
    }

    public String getSantDeptId() {
        return santDeptId;
    }

    public void setSantDeptId(String santDeptId) {
        this.santDeptId = santDeptId;
    }

    public String getSantDeptNm() {
        return santDeptNm;
    }

    public void setSantDeptNm(String santDeptNm) {
        this.santDeptNm = santDeptNm;
    }

    public String getAprnEmpId() {
        return aprnEmpId;
    }

    public void setAprnEmpId(String aprnEmpId) {
        this.aprnEmpId = aprnEmpId;
    }

    public String getAprnEmpNm() {
        return aprnEmpNm;
    }

    public void setAprnEmpNm(String aprnEmpNm) {
        this.aprnEmpNm = aprnEmpNm;
    }

    public String getAprnResoCd() {
        return aprnResoCd;
    }

    public void setAprnResoCd(String aprnResoCd) {
        this.aprnResoCd = aprnResoCd;
    }

    public String getAprnResoNm() {
        return aprnResoNm;
    }

    public void setAprnResoNm(String aprnResoNm) {
        this.aprnResoNm = aprnResoNm;
    }

    public String getAprnOfpsCd() {
        return aprnOfpsCd;
    }

    public void setAprnOfpsCd(String aprnOfpsCd) {
        this.aprnOfpsCd = aprnOfpsCd;
    }

    public String getAprnOfpsNm() {
        return aprnOfpsNm;
    }

    public void setAprnOfpsNm(String aprnOfpsNm) {
        this.aprnOfpsNm = aprnOfpsNm;
    }

    public String getSantOpinCont() {
        return santOpinCont;
    }

    public void setSantOpinCont(String santOpinCont) {
        this.santOpinCont = santOpinCont;
    }

    public String getSantAppvDstCd() {
        return santAppvDstCd;
    }

    public void setSantAppvDstCd(String santAppvDstCd) {
        this.santAppvDstCd = santAppvDstCd;
    }

    public String getSantAppvDstNm() {
        return santAppvDstNm;
    }

    public void setSantAppvDstNm(String santAppvDstNm) {
        this.santAppvDstNm = santAppvDstNm;
    }

    public String getSantDt() {
        return santDt;
    }

    public void setSantDt(String santDt) {
        this.santDt = santDt;
    }

    public String getSantNtcDstCd() {
        return santNtcDstCd;
    }

    public void setSantNtcDstCd(String santNtcDstCd) {
        this.santNtcDstCd = santNtcDstCd;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getSessEmpId() {
        return sessEmpId;
    }

    public void setSessEmpId(String sessEmpId) {
        this.sessEmpId = sessEmpId;
    }

    public UserGrpVO getUserGrpVO() {
        return userGrpVO;
    }

    public void setUserGrpVO(UserGrpVO userGrpVO) {
        this.userGrpVO = userGrpVO;
    }

    public String getMdtrAprnYn() {
        return mdtrAprnYn;
    }

    public void setMdtrAprnYn(String mdtrAprnYn) {
        this.mdtrAprnYn = mdtrAprnYn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
