package com.ibiz.api.model;

public class SysUserGroupVO {

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 사용자ID
     */
    private String userId;

    /**
     * 사용자명
     */
    private String userNm;

    /**
     * 사용자그룹코드
     */
    private String userGrpCd;

    /**
     * 사용자그룹명
     */
    private String userGrpNm;

    /**
     * 권한부서코드
     */
    private String athrDeptCd;

    /**
     * 권한부서명
     */
    private String athrDeptNm;

    /**
     * 유효시작일자
     */
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    private String avlEndDate;

    private String targetUserId;

    private String sourceUserId;

    private String deptId;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserGrpCd() {
        return userGrpCd;
    }

    public void setUserGrpCd(String userGrpCd) {
        this.userGrpCd = userGrpCd;
    }

    public String getUserGrpNm() {
        return userGrpNm;
    }

    public void setUserGrpNm(String userGrpNm) {
        this.userGrpNm = userGrpNm;
    }

    public String getAthrDeptCd() {
        return athrDeptCd;
    }

    public void setAthrDeptCd(String athrDeptCd) {
        this.athrDeptCd = athrDeptCd;
    }

    public String getAthrDeptNm() {
        return athrDeptNm;
    }

    public void setAthrDeptNm(String athrDeptNm) {
        this.athrDeptNm = athrDeptNm;
    }

    public String getAvlStartDate() {
        return avlStartDate;
    }

    public void setAvlStartDate(String avlStartDate) {
        this.avlStartDate = avlStartDate;
    }

    public String getAvlEndDate() {
        return avlEndDate;
    }

    public void setAvlEndDate(String avlEndDate) {
        this.avlEndDate = avlEndDate;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(String sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "SysUserGroupVO [seq=" + seq + ", userId=" + userId + ", userNm=" + userNm + ", userGrpCd=" + userGrpCd
                + ", userGrpNm=" + userGrpNm + ", athrDeptCd=" + athrDeptCd + ", athrDeptNm=" + athrDeptNm
                + ", avlStartDate=" + avlStartDate + ", avlEndDate=" + avlEndDate + ", targetUserId=" + targetUserId
                + ", sourceUserId=" + sourceUserId + ", deptId=" + deptId + "]";
    }

}
