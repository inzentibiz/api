package com.ibiz.api.model;

public class EstiProductVO {

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
    private String prodDstNm;

    /**
     * 상품유형코드명
     */
    private String prodTypeNm;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 서비스업무명
     */
    private String svcJobNm;

    /**
     * 기술등급코드
     */
    private String swTcenGrdNm;

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

    public String getProdDstNm() {
        return prodDstNm;
    }

    public void setProdDstNm(String prodDstNm) {
        this.prodDstNm = prodDstNm;
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

    public String getSwTcenGrdNm() {
        return swTcenGrdNm;
    }

    public void setSwTcenGrdNm(String swTcenGrdNm) {
        this.swTcenGrdNm = swTcenGrdNm;
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

    public String getProdTypeNm() {
        return prodTypeNm;
    }

    public void setProdTypeNm(String prodTypeNm) {
        this.prodTypeNm = prodTypeNm;
    }

    @Override
    public String toString() {
        return "EstiProductVO [estiId=" + estiId + ", prodDstCd=" + prodDstCd + ", prodDstNm=" + prodDstNm + ", seq=" + seq + ", svcJobNm="
                + svcJobNm + ", makeCmpyNm=" + makeCmpyNm + ", prodNm=" + prodNm + ", godsNm=" + godsNm
                + ", upcUnitNm=" + upcUnitNm + ", unitQnt=" + unitQnt + ", qnt=" + qnt + ", bscUpcAmt=" + bscUpcAmt
                + ", lpcAmt=" + lpcAmt + ", godsNm=" + godsNm + ", swTcenGrdNm=" + swTcenGrdNm + ", prcDcOptnCd=" + prcDcOptnCd
                + ", putTimeUnitCd=" + putTimeUnitCd + ", splyCmpyNm=" + splyCmpyNm + ", fcstPalId=" + fcstPalId + ", dtlGodsNm=" + dtlGodsNm
                + ", splyUpcAmt=" + splyUpcAmt + ", splyAmt=" + splyAmt + ", rmrkCont=" + rmrkCont
                + ", prodpNm=" + prodpNm + ", prodTypeCd=" + prodTypeCd + ", prodTypeNm=" + prodTypeNm + "]";
    }

}
