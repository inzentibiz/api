package com.ibiz.api.model;

import java.sql.Timestamp;

public class BizOpportunityNopVO {

    /**
     * 사업기회ID
     */
    private String boptId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 사업수행역할코드
     */
    private String bexcRoleCd;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 투입인원수
     */
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
    private String bexcRoleNm;

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

    public String getBexcRoleNm() {
        return bexcRoleNm;
    }

    public void setBexcRoleNm(String bexcRoleNm) {
        this.bexcRoleNm = bexcRoleNm;
    }

    public Integer getSumPutNopCount() {
        return sumPutNopCount;
    }

    public void setSumPutNopCount(Integer sumPutNopCount) {
        this.sumPutNopCount = sumPutNopCount;
    }

    @Override
    public String toString() {
        return "BizOpportunityNopVO [boptId=" + boptId + ", seq=" + seq + ", bexcRoleCd=" + bexcRoleCd
                + ", putTimeUnitCd=" + putTimeUnitCd + ", putNopCount=" + putNopCount + ", rmrkCont=" + rmrkCont
                + ", orinFcstYam=" + orinFcstYam + ", gridStatus=" + gridStatus + ", chgDt=" + chgDt + ", bexcRoleNm="
                + bexcRoleNm + ", sumPutNopCount=" + sumPutNopCount + "]";
    }

}
