package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BizChancePersonVO {

    /**
     * 사업기회ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업기회ID는 10자리 이하여야합니다." )
    private String boptId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 사업수행역할코드
     */
    @NotNull
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 사업수행역할코드는 4자리 이하여야합니다." )
    private String bexcRoleCd;

    /**
     * 투입시간단위코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 투입시간단위코드는 4자리 이하여야합니다." )
    private String putTimeUnitCd;

    /**
     * 투입인원수
     */
    @NotNull
    @Digits(integer=5,fraction=2)
    private float putNopCount;

    /**
     * 비고내용
     */
    private String rmrkCont;

    /**
     * 오리지널 예상연월
     */
    private String orinFcstYam;

    /**
     * 그리드 상태값 (C/U/D)
     */
    private String gridStatus;

    /**
     * 변경일시 ( for History Insert)
     */
    private String chgDt;

    /**
     * 사업수행역할명
     */
    private String bexcRoleCdNm;

    /**
     * 총 투입인원
     */
    private Integer sumPutNopCount;

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getBexcRoleCd() {
        return bexcRoleCd;
    }

    public void setBexcRoleCd(String bexcRoleCd) {
        this.bexcRoleCd = bexcRoleCd;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }


    public float getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(float putNopCount) {
        this.putNopCount = putNopCount;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
    }

    public String getOrinFcstYam() {
        return orinFcstYam;
    }

    public void setOrinFcstYam(String orinFcstYam) {
        this.orinFcstYam = orinFcstYam;
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public void setGridStatus(String gridStatus) {
        this.gridStatus = gridStatus;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getBexcRoleCdNm() {
        return bexcRoleCdNm;
    }

    public void setBexcRoleCdNm(String bexcRoleCdNm) {
        this.bexcRoleCdNm = bexcRoleCdNm;
    }

    public Integer getSumPutNopCount() {
        return sumPutNopCount;
    }

    public void setSumPutNopCount(Integer sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }

    @Override
    public String toString() {
        return "BizChancePersonVO [boptId=" + boptId + ", seq=" + seq + ", bexcRoleCd=" + bexcRoleCd
                + ", putTimeUnitCd=" + putTimeUnitCd + ", putNopCount=" + putNopCount + ", rmrkCont=" + rmrkCont
                + ", orinFcstYam=" + orinFcstYam + ", gridStatus=" + gridStatus + ", chgDt=" + chgDt + ", bexcRoleCdNm="
                + bexcRoleCdNm + ", sumPutNopCount=" + sumPutNopCount + "]";
    }

}
