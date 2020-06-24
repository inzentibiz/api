package com.ibiz.api.model;

/**
 *
 * BEST011T : 예상손익할인정책상세
 *
 */
public class ProdDcPolicyVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    // 201911상품변경
    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 상품유형명
     */
    private String prodTypeCdNm;


    /**
     * 상품순번
     */
    private Integer prodSeq;

    /**
     * 가격할인옵션코드
     */
    private String prcDcOptnCd;

    /**
     * 가격할인옵션코드명
     */
    private String prcDcOptnNm;

    /**
     * 할인율
     */
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

    public String getPrcDcOptnNm() {
        return prcDcOptnNm;
    }

    public void setPrcDcOptnNm(String prcDcOptnNm) {
        this.prcDcOptnNm = prcDcOptnNm;
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
