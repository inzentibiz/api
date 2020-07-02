package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BEST011T : 예상손익할인정책상세
 *
 */
public class OfferProductDCVO {

    /**
     * 예상손익ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 예상손익ID는 10자리 이하여야합니다." )
    private String fcstPalId;

    // 201911상품변경
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
     * 상품순번
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer prodSeq;

    /**
     * 가격할인옵션코드
     */
    @NotNull
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 가격할인옵션코드는 4자리 이하여야합니다." )
    private String prcDcOptnCd;

    /**
     * 가격할인옵션코드명
     */
    private String prcDcOptnCdNm;

    /**
     * 할인율
     */
    @NotNull
    @Digits(integer=5,fraction=4)
    private Double dcRt;

    /**
     * 할인정책순번
     */
    private Integer dcPlcySeq;

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public Integer getProdSeq() {
        return prodSeq;
    }

    public void setProdSeq(Integer prodSeq) {
        this.prodSeq = prodSeq;
    }

    public String getPrcDcOptnCd() {
        return prcDcOptnCd;
    }

    public void setPrcDcOptnCd(String prcDcOptnCd) {
        this.prcDcOptnCd = prcDcOptnCd;
    }

    public String getPrcDcOptnCdNm() {
        return prcDcOptnCdNm;
    }

    public void setPrcDcOptnCdNm(String prcDcOptnCdNm) {
        this.prcDcOptnCdNm = prcDcOptnCdNm;
    }

    public Double getDcRt() {
        return dcRt;
    }

    public void setDcRt(Double dcRt) {
        this.dcRt = dcRt;
    }

    public Integer getDcPlcySeq() {
        return dcPlcySeq;
    }

    public void setDcPlcySeq(Integer dcPlcySeq) {
        this.dcPlcySeq = dcPlcySeq;
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

}
