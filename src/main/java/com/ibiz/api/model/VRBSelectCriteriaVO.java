package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BPIP110T : 선정기준관리
 *
 */
public class VRBSelectCriteriaVO {

    /**
     * VRB선정항목코드
     */
    @NotNull
    @Size(max = 4, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " VRB선정항목코드는 4자리 이하여야합니다.")
    private String vrbSlctItmCd;

    /**
     * VRB선정항목코드명
     */
    private String vrbSlctItmCdNm;

    /**
     * VRB선정항목구분코드
     */
    private String vrbSlctItmDstCd;

    /**
     * VRB선정항목구분코드명
     */
    private String vrbSlctItmDstCdNm;

    /**
     * 유효시작일자
     */
    @NotNull
    @Size(max = 8, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " 유효시작일자는 8자리 이하여야합니다.")
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    @NotNull
    @Size(max = 8, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " 유효종료일자는 8자리 이하여야합니다.")
    private String avlEndDate;

    /**
     * VRB선정기준수량
     */
    @NotNull
    @Digits(integer = 17, fraction = 5)
    private Integer vrbSlctCritQnt;

    /**
     * VRB선정기준단위코드
     */
    @Size(max = 4, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " VRB선정기준단위코드는 4자리 이하여야합니다.")
    private String vrbSlctCritUnitCd;

    /**
     * VRB선정기준단위코드명
     */
    private String vrbSlctCritUnitCdNm;

    /**
     * 기준수량적용조건코드
     */
    @Size(max = 4, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " 기준수량적용조건코드는 4자리 이하여야합니다.")
    private String critQntAplcnCdntCd;

    /**
     * 기준수량적용조건코드명
     */
    private String critQntAplcnCdntCdNm;

    /**
     * 변경사원ID
     */
    @Size(max = 10, message = ExceptionCode.OUTOFSIZE_EXCEPTION + " 변경사원ID는 10자리 이하여야합니다.")
    private String chgEmpId;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 수량적용조건코드
     */
    private String qntAplcnCdntCd;

    /**
     * 수량적용조건코드명
     */
    private String qntAplcnCdntCdNm;

    public String getVrbSlctItmCd() {
        return vrbSlctItmCd;
    }

    public void setVrbSlctItmCd(String vrbSlctItmCd) {
        this.vrbSlctItmCd = vrbSlctItmCd;
    }

    public String getVrbSlctItmCdNm() {
        return vrbSlctItmCdNm;
    }

    public void setVrbSlctItmCdNm(String vrbSlctItmCdNm) {
        this.vrbSlctItmCdNm = vrbSlctItmCdNm;
    }

    public String getVrbSlctItmDstCd() {
        return vrbSlctItmDstCd;
    }

    public void setVrbSlctItmDstCd(String vrbSlctItmDstCd) {
        this.vrbSlctItmDstCd = vrbSlctItmDstCd;
    }

    public String getVrbSlctItmDstCdNm() {
        return vrbSlctItmDstCdNm;
    }

    public void setVrbSlctItmDstCdNm(String vrbSlctItmDstCdNm) {
        this.vrbSlctItmDstCdNm = vrbSlctItmDstCdNm;
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

    public Integer getVrbSlctCritQnt() {
        return vrbSlctCritQnt;
    }

    public void setVrbSlctCritQnt(Integer vrbSlctCritQnt) {
        this.vrbSlctCritQnt = vrbSlctCritQnt;
    }

    public String getVrbSlctCritUnitCd() {
        return vrbSlctCritUnitCd;
    }

    public void setVrbSlctCritUnitCd(String vrbSlctCritUnitCd) {
        this.vrbSlctCritUnitCd = vrbSlctCritUnitCd;
    }

    public String getVrbSlctCritUnitCdNm() {
        return vrbSlctCritUnitCdNm;
    }

    public void setVrbSlctCritUnitCdNm(String vrbSlctCritUnitCdNm) {
        this.vrbSlctCritUnitCdNm = vrbSlctCritUnitCdNm;
    }

    public String getCritQntAplcnCdntCd() {
        return critQntAplcnCdntCd;
    }

    public void setCritQntAplcnCdntCd(String critQntAplcnCdntCd) {
        this.critQntAplcnCdntCd = critQntAplcnCdntCd;
    }

    public String getCritQntAplcnCdntCdNm() {
        return critQntAplcnCdntCdNm;
    }

    public void setCritQntAplcnCdntCdNm(String critQntAplcnCdntCdNm) {
        this.critQntAplcnCdntCdNm = critQntAplcnCdntCdNm;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getQntAplcnCdntCd() {
        return qntAplcnCdntCd;
    }

    public void setQntAplcnCdntCd(String qntAplcnCdntCd) {
        this.qntAplcnCdntCd = qntAplcnCdntCd;
    }

    public String getQntAplcnCdntCdNm() {
        return qntAplcnCdntCdNm;
    }

    public void setQntAplcnCdntCdNm(String qntAplcnCdntCdNm) {
        this.qntAplcnCdntCdNm = qntAplcnCdntCdNm;
    }
}