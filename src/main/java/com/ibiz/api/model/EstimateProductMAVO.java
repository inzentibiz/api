package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BEST170T : MA견적상세
 *
 */

public class EstimateProductMAVO {

    /**
     * 견적ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 견적ID는 10자리 이하여야합니다." )
    private String estiId;

    /**
     * 손익ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 손익ID는 10자리 이하여야합니다." )
    private String fcstPalId;

    /**
     * 순번
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer seq;

    /**
     * 프로젝트명
     */
    @NotNull
    private String prjtNm;

    /**
     * 제품명
     */
    @NotNull
    private String godsNm;

    /**
     * 제품공급금액
     */
    @NotNull
    @Digits(integer=15,fraction=0)
    private Long godsSplyAmt;

    /**
     * 유지보수요율
     */
    @Digits(integer=5,fraction=4)
    private Double maTrf;

    /**
     * 유지보수 시작일자
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 유지보수 시작일자는 8자리 이하여야합니다." )
    private String maStartDate;

    /**
     * 유지보수 종료일자
     */
    @Size(max=8, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 유지보수 종료일자는 8자리 이하여야합니다." )
    private String maEndDate;

    /**
     * 월간보수금액
     */
    @NotNull
    @Digits(integer=15,fraction=0)
    private Long mnthMndnAmt;

    /**
     * 공급금액
     */
    @NotNull
    @Digits(integer=15,fraction=0)
    private Integer splyAmt;

    /**
     * 개월 수 차이
     */
    private Double mthCount;

    /**
     * 제품명
     */
    private String prodpNm;

    public String getEstiId() {
        return estiId;
    }

    public void setEstiId(String estiId) {
        this.estiId = estiId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getPrjtNm() {
        return prjtNm;
    }

    public void setPrjtNm(String prjtNm) {
        this.prjtNm = prjtNm;
    }

    public String getGodsNm() {
        return godsNm;
    }

    public void setGodsNm(String godsNm) {
        this.godsNm = godsNm;
    }

    public Long getGodsSplyAmt() {
        return godsSplyAmt;
    }

    public void setGodsSplyAmt(Long godsSplyAmt) {
        this.godsSplyAmt = godsSplyAmt;
    }

    public Double getMaTrf() {
        return maTrf;
    }

    public void setMaTrf(Double maTrf) {
        this.maTrf = maTrf;
    }

    public String getMaStartDate() {
        return maStartDate;
    }

    public void setMaStartDate(String maStartDate) {
        this.maStartDate = maStartDate;
    }

    public String getMaEndDate() {
        return maEndDate;
    }

    public void setMaEndDate(String maEndDate) {
        this.maEndDate = maEndDate;
    }

    public Long getMnthMndnAmt() {
        return mnthMndnAmt;
    }

    public void setMnthMndnAmt(Long mnthMndnAmt) {
        this.mnthMndnAmt = mnthMndnAmt;
    }

    public Integer getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(Integer splyAmt) {
        this.splyAmt = splyAmt;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public Double getMthCount() {
        return mthCount;
    }

    public void setMthCount(Double mthCount) {
        this.mthCount = mthCount;
    }

    public String getProdpNm() {
        return prodpNm;
    }

    public void setProdpNm(String prodpNm) {
        this.prodpNm = prodpNm;
    }

    @Override
    public String toString() {
        return "EstimateProductMAVO [estiId=" + estiId + ", seq=" + seq + ", prjtNm=" + prjtNm + ", godsNm=" + godsNm
                + ", godsSplyAmt=" + godsSplyAmt + ", maTrf=" + maTrf + ", maStartDate=" + maStartDate + ", maEndDate="
                + maEndDate + ", mnthMndnAmt=" + mnthMndnAmt + ", splyAmt=" + splyAmt + ", fcstPalId=" + fcstPalId
                + ", mthCount=" + mthCount + ", prodpNm=" + prodpNm + "]";
    }

}
