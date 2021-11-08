package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * BPIP141T : VRB수익분석상세
 *
 */

public class VRBProfitVO {

    /**
     * 손익 ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 손익ID는 10자리 이하여야합니다." )
    private String fcstPalId;
    /**
     * VRB분석ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" VRB분석ID는 10자리 이하여야합니다." )
    private String vrbAnlyId;

    /**
     * 견적ID
     */
    private String estiId;

    /**
     * 상품유형코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 상품유형코드는 4자리 이하여야합니다." )
    private String prodTypeCd;

    /**
     * 상품유형명
     */
    private String prodTypeCdNm;

    /**
     * LISTPRICE금액
     */
    @Digits(integer=15,fraction=0)
    private Long lpcAmt;

    /**
     * 매출금액
     */
    @Digits(integer=15,fraction=0)
    private Long sellAmt;

    /**
     * 매입원가금액
     */
    @Digits(integer=15,fraction=0)
    private Long buyCostAmt;

    /**
     * 직접원가금액(매입외)
     */
    @Digits(integer=15,fraction=0)
    private Long drcstAmt;

    /**
     * 직접경비금액
     */
    @Digits(integer=15,fraction=0)
    private Long drexpAmt;

    /**
     * 간접원가금액
     */
    @Digits(integer=15,fraction=0)
    private Long incstAmt;

    /**
     * 사업이익금액
     */
    @Digits(integer=15,fraction=0)
    private Long ctmgAmt;

    /**
     * 투입시간단위코드
     */
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 투입시간단위코드는 4자리 이하여야합니다." )
    private String putTimeUnitCd;

    /**
     * 투입시간단위명
     */
    private String putTimeUnitCdNm;

    /**
     * 투입인원수
     */
    @Digits(integer=5,fraction=2)
    private float putNopCount;

    /**
     * vrb 투입 리스트
     */
    private List<VRBBizChanceVO> vrbBizChanceList;

    public String getFcstPalId() {
        return fcstPalId;
    }


    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }


    public String getVrbAnlyId() {
        return vrbAnlyId;
    }


    public void setVrbAnlyId(String vrbAnlyId) {
        this.vrbAnlyId = vrbAnlyId;
    }


    public String getEstiId() {
        return estiId;
    }


    public void setEstiId(String estiId) {
        this.estiId = estiId;
    }


    public String getProdTypeCd() {
        return prodTypeCd;
    }


    public void setProdTypeCd(String prodTypeCd) {
        this.prodTypeCd = prodTypeCd;
    }


    public String getProdTypeCdNm() {
        return prodTypeCdNm;
    }


    public void setProdTypeCdNm(String prodTypeCdNm) {
        this.prodTypeCdNm = prodTypeCdNm;
    }


    public Long getLpcAmt() {
        return lpcAmt;
    }


    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }


    public Long getSellAmt() {
        return sellAmt;
    }


    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }


    public Long getBuyCostAmt() {
        return buyCostAmt;
    }


    public void setBuyCostAmt(Long buyCostAmt) {
        this.buyCostAmt = buyCostAmt;
    }


    public Long getDrcstAmt() {
        return drcstAmt;
    }


    public void setDrcstAmt(Long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }


    public Long getDrexpAmt() {
        return drexpAmt;
    }


    public void setDrexpAmt(Long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }


    public Long getIncstAmt() {
        return incstAmt;
    }


    public void setIncstAmt(Long incstAmt) {
        this.incstAmt = incstAmt;
    }


    public Long getCtmgAmt() {
        return ctmgAmt;
    }


    public void setCtmgAmt(Long ctmgAmt) {
        this.ctmgAmt = ctmgAmt;
    }


    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }


    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }


    public String getPutTimeUnitCdNm() {
        return putTimeUnitCdNm;
    }


    public void setPutTimeUnitCdNm(String putTimeUnitCdNm) {
        this.putTimeUnitCdNm = putTimeUnitCdNm;
    }


    public float getPutNopCount() {
        return putNopCount;
    }


    public void setPutNopCount(float putNopCount) {
        this.putNopCount = putNopCount;
    }

    public List<VRBBizChanceVO> getVrbBizChanceList() {
        return vrbBizChanceList;
    }

    public void setVrbBizChanceList(List<VRBBizChanceVO> vrbBizChanceList) {
        this.vrbBizChanceList = vrbBizChanceList;
    }

    @Override
    public String toString() {
        return "VRBProfitVO [fcstPalId=" + fcstPalId + ", vrbAnlyId=" + vrbAnlyId + ", estiId=" + estiId
                + ", prodTypeCd=" + prodTypeCd + ", prodTypeCdNm=" + prodTypeCdNm + ", lpcAmt=" + lpcAmt + ", sellAmt="
                + sellAmt + ", buyCostAmt=" + buyCostAmt + ", drcstAmt=" + drcstAmt + ", drexpAmt=" + drexpAmt
                + ", incstAmt=" + incstAmt + ", ctmgAmt=" + ctmgAmt + ", putTimeUnitCd=" + putTimeUnitCd
                + ", putTimeUnitCdNm=" + putTimeUnitCdNm + ", putNopCount=" + putNopCount + ", vrbBizChanceList=" + vrbBizChanceList +"]";
    }

}
