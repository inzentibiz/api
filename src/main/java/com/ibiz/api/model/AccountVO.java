package com.ibiz.api.model;

import java.util.List;

public class AccountVO {

    /**
     * 사용자 ID
     */
    private String userId;

    /**
     * 고객ID
     */
    private String custId;

    /**
     * 사용자 암호
     */
    private String pswd;

    /**
     * 소속부서 ID
     */
    private String deptId;

    /**
     * EMP ID
     */
    private String empId;

    /**
     * 이름
     */
    private String userNm;

    /**
     * 직위 코드
     */
    private String ofpsCd;

    /**
     * 직책 코드
     */
    private String resoCd;

    /**
     * 직위명
     */
    private String ofpsCdNm;

    /**
     * 직책명
     */
    private String resoCdNm;

    /**
     * 소속부서명
     */
    private String deptNm;

    /**
     * 사용자권한정보
     */
    private List<String> roleList;

    /**
     * 사용자역할정보
     * */
    private Boolean isInRoles;

    /**
     * 사용자 로그인 정보
     */
    private LoginVO loginVO;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getOfpsCd() {
        return ofpsCd;
    }

    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
    }

    public String getResoCd() {
        return resoCd;
    }

    public void setResoCd(String resoCd) {
        this.resoCd = resoCd;
    }

    public String getOfpsCdNm() {
        return ofpsCdNm;
    }

    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }

    public String getResoCdNm() {
        return resoCdNm;
    }

    public void setResoCdNm(String resoCdNm) {
        this.resoCdNm = resoCdNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public List<String> getRoleList() { return roleList; }

    public void setRoleList(List<String> roleList) { this.roleList = roleList; }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }


    public LoginVO getLoginVO() {
        return loginVO;
    }

    public void setLoginVO(LoginVO loginVO) {
        this.loginVO = loginVO;
    }

    public Boolean getIsInRoles() {
        return isInRoles;
    }

    public void setIsInRoles(Boolean isInRoles) {
        this.isInRoles = isInRoles;
    }
}