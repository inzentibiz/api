package com.ibiz.api.model;
/**
 *
 * BEST100T : 견적서발행내역
 *
 */

public class EstimateProductPSVO {

    /**
     * 견적ID
     */
    private String estiId;

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * 상품구분코드
     */
    private String prodDstCd;

    /**
     * 상품유형코드
     */
    private String prodTypeCd;

    /**
     * 상품구분코드명
     */
    private String prodDstCdNm;

    /**
     * 상품유형코드명
     */
    private String prodTypeCdNm;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 서비스업무명
     */
    private String svcJobNm;

    /**
     * 기술등급코드명
     */
    private String swTcenGrdCdNm;

    /**
     * 제조업체명
     */
    private String makeCmpyNm;

    /**
     * 상품명
     */
    private String prodNm;

    /**
     * 상세제품명
     */
    private String dtlGodsNm;

    /**
     * 상세제품명
     */
    private String godsNm;

    /**
     * 제품명
     */
    private String prodpNm;

    /**
     * 단가단위명
     */
    private String upcUnitNm;

    /**
     * 단위수량
     */
    private Long unitQnt;

    /**
     * copy수량(서비스 인원)
     */
    private Double qnt;

    /**
     * 기본단가금액
     */
    private Long bscUpcAmt;

    /**
     * ListPrice금액
     */
    private Long lpcAmt;

    /**
     * 공급단가금액
     */
    private Long splyUpcAmt;

    /**
     * 공급금액
     */
    private Long splyAmt;

    /**
     * 비고내용
     */
    private String rmrkCont;

    /**
     * 할인정책
     */
    private String prcDcOptnCd;

    /**
     * 투입시간단위코드
     */
    private String putTimeUnitCd;

    /**
     * 제조사명(공급업체명)
     */
    private String splyCmpyNm;

    public String getEstiId() {
        return estiId;
    }

    public void setEstiId(String estiId) {
        this.estiId = estiId;
    }

    public String getProdDstCd() {
        return prodDstCd;
    }

    public void setProdDstCd(String prodDstCd) {
        this.prodDstCd = prodDstCd;
    }

    public String getProdDstCdNm() {
        return prodDstCdNm;
    }

    public void setProdDstCdNm(String prodDstCdNm) {
        this.prodDstCdNm = prodDstCdNm;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getSvcJobNm() {
        return svcJobNm;
    }

    public void setSvcJobNm(String svcJobNm) {
        this.svcJobNm = svcJobNm;
    }

    public String getMakeCmpyNm() {
        return makeCmpyNm;
    }

    public void setMakeCmpyNm(String makeCmpyNm) {
        this.makeCmpyNm = makeCmpyNm;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public String getUpcUnitNm() {
        return upcUnitNm;
    }

    public void setUpcUnitNm(String upcUnitNm) {
        this.upcUnitNm = upcUnitNm;
    }

    public Long getBscUpcAmt() {
        return bscUpcAmt;
    }

    public void setBscUpcAmt(Long bscUpcAmt) {
        this.bscUpcAmt = bscUpcAmt;
    }

    public Long getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public Long getSplyUpcAmt() {
        return splyUpcAmt;
    }

    public void setSplyUpcAmt(Long splyUpcAmt) {
        this.splyUpcAmt = splyUpcAmt;
    }

    public Long getSplyAmt() {
        return splyAmt;
    }

    public void setSplyAmt(Long splyAmt) {
        this.splyAmt = splyAmt;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
    }

    public String getGodsNm() {
        return godsNm;
    }

    public void setGodsNm(String godsNm) {
        this.godsNm = godsNm;
    }

    public Long getUnitQnt() {
        return unitQnt;
    }

    public void setUnitQnt(Long unitQnt) {
        this.unitQnt = unitQnt;
    }

    public Double getQnt() {
        return qnt;
    }

    public void setQnt(Double qnt) {
        this.qnt = qnt;
    }

    public String getSwTcenGrdCdNm() {
        return swTcenGrdCdNm;
    }

    public void setSwTcenGrdCdNm(String swTcenGrdCdNm) {
        this.swTcenGrdCdNm = swTcenGrdCdNm;
    }

    public String getPrcDcOptnCd() {
        return prcDcOptnCd;
    }

    public void setPrcDcOptnCd(String prcDcOptnCd) {
        this.prcDcOptnCd = prcDcOptnCd;
    }

    public String getPutTimeUnitCd() {
        return putTimeUnitCd;
    }

    public void setPutTimeUnitCd(String putTimeUnitCd) {
        this.putTimeUnitCd = putTimeUnitCd;
    }

    public String getSplyCmpyNm() {
        return splyCmpyNm;
    }

    public void setSplyCmpyNm(String splyCmpyNm) {
        this.splyCmpyNm = splyCmpyNm;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getDtlGodsNm() {
        return dtlGodsNm;
    }

    public void setDtlGodsNm(String dtlGodsNm) {
        this.dtlGodsNm = dtlGodsNm;
    }

    public String getProdpNm() {
        return prodpNm;
    }

    public void setProdpNm(String prodpNm) {
        this.prodpNm = prodpNm;
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

    @Override
    public String toString() {
        return "EstimateProductPSVO [estiId=" + estiId + ", prodDstCd=" + prodDstCd + ", prodDstCdNm=" + prodDstCdNm + ", seq=" + seq + ", svcJobNm="
                + svcJobNm + ", makeCmpyNm=" + makeCmpyNm + ", prodNm=" + prodNm + ", godsNm=" + godsNm
                + ", upcUnitNm=" + upcUnitNm + ", unitQnt=" + unitQnt + ", qnt=" + qnt + ", bscUpcAmt=" + bscUpcAmt
                + ", lpcAmt=" + lpcAmt + ", godsNm=" + godsNm + ", swTcenGrdCdNm=" + swTcenGrdCdNm + ", prcDcOptnCd=" + prcDcOptnCd
                + ", putTimeUnitCd=" + putTimeUnitCd + ", splyCmpyNm=" + splyCmpyNm + ", fcstPalId=" + fcstPalId + ", dtlGodsNm=" + dtlGodsNm
                + ", splyUpcAmt=" + splyUpcAmt + ", splyAmt=" + splyAmt + ", rmrkCont=" + rmrkCont
                + ", prodpNm=" + prodpNm + ", prodTypeCd=" + prodTypeCd + ", prodTypeCdNm=" + prodTypeCdNm + "]";
    }

}
