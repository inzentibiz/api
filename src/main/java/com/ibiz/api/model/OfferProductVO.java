package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BEST010T : 사업예상상품상세
 *
 */

public class OfferProductVO {

    /**
     * 손익ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 손익ID는 10자리 이하여야합니다." )
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
     * 상품구분코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 상품구분코드는 4자리 이하여야합니다." )
    private String prodDstCd;

    /**
     * 상품구분코드명
     */
    private String prodDstCdNm;

    /**
     * 상품순번
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer prodSeq;

    /**
     * 제조업체명

     private String makeCmpyNm;
     */

    /**
     * 공급업체고객ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 공급업체고객ID는 10자리 이하여야합니다." )
    private String splyCmpyCustId;

    /**
     * 공급업체고객명
     */
    private String splyCmpyCustNm;

    /**
     * 상품팩ID
     */
    @Size(max=7, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 상품팩ID는 7자리 이하여야합니다." )
    private String prodpId;

    /**
     * 상품팩명
     */
    private String prodpNm;

    /**
     * 상품ID
     */
    @Size(max=7, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 상품ID는 7자리 이하여야합니다." )
    private String prodId;

    /**
     * 상품명
     */
    private String prodNm;

    /**
     * 서비스업무명
     */
    private String svcJobNm;


    /**
     * 서비스단가기준코드
     */
    private String svcUpcCritCd;

    /**
     * 서비스단가기준코드명
     */
    private String svcUpcCritCdNm;

    // 201911상품변경
    /*
     *//**
     * SW기술자등급코드
     *//*
	private String swTcenGrdCd;

	*//**
     * SW기술자등급코드명
     *//*
	private String swTcenGrdCdNm;
	*/
    /**
     * 단가단위코드
     */
    private String upcUnitCd;

    /**
     * 단가단위명
     */
    private String upcUnitNm;

    /**
     * 단위수량
     */
    private Integer unitQnt;

    /**
     * COPY수량
     */
    private Double copyQnt;

    /**
     * 기본단가금액
     */
    private Long bscUpcAmt;

    /**
     * 표준단가금액 (할인전기본단가금액)
     */
    private Long stdUpcAmt;

    /**
     * LISTPRICE금액
     */
    private Long lpcAmt;

    /**
     * 구매단가금액
     */
    private Long pchsUpcAmt;

    /**
     * 구매금액
     */
    private Long pchsAmt;

    /**
     * 공급단가금액
     */
    private Long splyUpcAmt;

    /**
     * 공급금액
     */
    private Long splyAmt;

    /**
     * 내장형제품여부
     */
    private String embGodsYn;

    /**
     * 견적비고내용
     */
    private String estiRmrkCont;

    /**
     * 원가비고내용
     */
    private String costRmrkCont;

    // 201911상품변경
    /*
     *//**
     * 투입시간단위코드
     *//*
	private String putTimeUnitCd;

	*//**
     * 투입시간단위코드명
     *//*
	private String putTimeUnitCdNm;
	*/
    /**
     * 최소단위수량
     */
    @Digits(integer=5,fraction=0)
    private Integer minUnitQnt;

    /**
     * 최대단위수량
     */
    @Digits(integer=5,fraction=0)
    private Integer maxUnitQnt;

    /**
     * 수량할인율
     */
    @Digits(integer=5,fraction=4)
    private Double qntDcRt;

    /**
     * 기본원가율
     */
    @Digits(integer=5,fraction=4)
    private Double bscCostRt;

    // 201911상품변경
    /*
     *//**
     * 제조원가금액
     *//*
	private Long makeCostAmt;
	*/
    /**
     * 가격할인옵션코드
     */
    private String prcDcOptnCd;

    /**
     * 가격할인옵션코드명
     */
    private String prcDcOptnCdNm;

    /**
     * 할인율
     */
    private Double dcRt;

    /**
     * 가격할인옵션코드 (할인정책1)
     */
    private String prcDcOptnCdU;

    /**
     * 격할인옵션명(할인정책1)
     */
    private String prcDcOptnCdNmU;

    /**
     * 할인율(할인정책1)
     */
    private Double dcRtU;

    /**
     * 가격할인옵션코드 (할인정책2)
     */
    private String prcDcOptnCdH;

    /**
     * 격할인옵션명(할인정책2)
     */
    private String prcDcOptnCdNmH;

    /**
     * 할인율(할인정책2)
     */
    private Double dcRtH;

    /**
     * 가격할인옵션코드 (할인정책1)
     */
    private String prcDcOptnCdM;

    /**
     * 격할인옵션명(할인정책2)
     */
    private String prcDcOptnCdNmM;

    /**
     * 할인율(할인정책3)
     */
    private Double dcRtM;

    /**
     * 할인정책순번
     */
    private Integer dcPlcySeq;

    // 201911상품변경
    /**
     * 가격정책할인율
     */
    @Digits(integer=5,fraction=4)
    private Double prcPlcyDcRt;

    /**
     * 적용원가율
     */
    @Digits(integer=5,fraction=4)
    private Double aplcnCostRt;

    /**
     * 직접원가금액
     */
    @Digits(integer=15,fraction=0)
    private long drcstAmt;

    /**
     * 직접경비금액
     */
    private long drexpAmt;

    /**
     * 간접원가금액
     */
    @Digits(integer=15,fraction=0)
    private long incstAmt;

    /**
     * 추가구매여부
     */
    @Size(max=1, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 추가구매여부는 1자리 이하여야합니다." )
    private String splmPchsYn;

    /**
     * 제품분류코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 제품분류코드는 4자리 이하여야합니다." )
    private String godsClsfCd;

    /**
     * 제품분류명
     */
    private String godsClsfCdNm;

    /**
     * MA제품공금금액
     */
    @Digits(integer=15,fraction=0)
    private long maGodsSplyAmt;

    /**
     * MA요율
     */
    @Digits(integer=5,fraction=4)
    private double maTrf;

    /**
     * MA시작일자
     */
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 유지보수 시작일자는 8자리 이하여야합니다." )
    private String maStartDate;

    /**
     * MA종료일자
     */
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 유지보수 종료일자는 8자리 이하여야합니다." )
    private String maEndDate;

    /**
     * MA대상프로젝트ID
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" MA대상프로젝트ID는 10자리 이하여야합니다." )
    private String maTgtPrjtId;

    /**
     * MA대상프로젝트명
     */
    private String maTgtPrjtNm;

    /**
     * 투입인력등급코드
     */
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 투입인력등급코드는 4자리 이하여야합니다." )
    private String putHmfrGrdCd;

    /**
     * 투입인력등급코드명
     */
    private String putHmfrGrdCdNm;

    /**
     * 표준원가금액
     */
    @Digits(integer=15,fraction=0)
    private long stdCostAmt;

    /**
     * 투입인원수
     */
    @Digits(integer=5,fraction=2)
    private double putNopCount;

    /**
     * 최종고객(유지보수 견적내역)
     */
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 최종고객ID는 10자리 이하여야합니다." )
    private String lastCustId;

    /**
     * MA제품공급연월(유지보수 견적내역)
     */
    @Size(max=6, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" MA제품공급연월은 4자리 이하여야합니다." )
    private String maGodsSplyYam;

    /**
     * MA제품단가단위코드(유지보수 견적내역)
     */
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" MA제품단가단위코드는 4자리 이하여야합니다." )
    private String maGodsUpcUnitCd;

    /**
     * MA제품단가단위명(유지보수 견적내역)
     */
    private String maGodsUpcUnitCdNm;

    /**
     * MA제품공급수량(유지보수 견적내역)
     */
    @Digits(integer=10,fraction=5)
    private Double maGodsSplyQnt;


    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
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

    public Integer getProdSeq() {
        return prodSeq;
    }

    public void setProdSeq(Integer prodSeq) {
        this.prodSeq = prodSeq;
    }

    public String getSplyCmpyCustId() {
        return splyCmpyCustId;
    }

    public void setSplyCmpyCustId(String splyCmpyCustId) {
        this.splyCmpyCustId = splyCmpyCustId;
    }

    public String getSplyCmpyCustNm() {
        return splyCmpyCustNm;
    }

    public void setSplyCmpyCustNm(String splyCmpyCustNm) {
        this.splyCmpyCustNm = splyCmpyCustNm;
    }

    public String getProdpId() {
        return prodpId;
    }

    public void setProdpId(String prodpId) {
        this.prodpId = prodpId;
    }

    public String getProdpNm() {
        return prodpNm;
    }

    public void setProdpNm(String prodpNm) {
        this.prodpNm = prodpNm;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public String getSvcJobNm() {
        return svcJobNm;
    }

    public void setSvcJobNm(String svcJobNm) {
        this.svcJobNm = svcJobNm;
    }
    /*
        public String getSwTcenGrdCd() {
            return swTcenGrdCd;
        }

        public void setSwTcenGrdCd(String swTcenGrdCd) {
            this.swTcenGrdCd = swTcenGrdCd;
        }

        public String getSwTcenGrdCdNm() {
            return swTcenGrdCdNm;
        }

        public void setSwTcenGrdCdNm(String swTcenGrdCdNm) {
            this.swTcenGrdCdNm = swTcenGrdCdNm;
        }
    */
    public String getUpcUnitCd() {
        return upcUnitCd;
    }

    public void setUpcUnitCd(String upcUnitCd) {
        this.upcUnitCd = upcUnitCd;
    }

    public String getUpcUnitNm() {
        return upcUnitNm;
    }

    public void setUpcUnitNm(String upcUnitNm) {
        this.upcUnitNm = upcUnitNm;
    }

    public Integer getUnitQnt() {
        return unitQnt;
    }

    public void setUnitQnt(Integer unitQnt) {
        this.unitQnt = unitQnt;
    }

    public Double getCopyQnt() {
        return copyQnt;
    }

    public void setCopyQnt(Double copyQnt) {
        this.copyQnt = copyQnt;
    }

    public Long getBscUpcAmt() {
        return bscUpcAmt;
    }

    public void setBscUpcAmt(Long bscUpcAmt) {
        this.bscUpcAmt = bscUpcAmt;
    }

    public Long getStdUpcAmt() {
        return stdUpcAmt;
    }

    public void setStdUpcAmt(Long stdUpcAmt) {
        this.stdUpcAmt = stdUpcAmt;
    }

    public Long getLpcAmt() {
        return lpcAmt;
    }

    public void setLpcAmt(Long lpcAmt) {
        this.lpcAmt = lpcAmt;
    }

    public Long getPchsUpcAmt() {
        return pchsUpcAmt;
    }

    public void setPchsUpcAmt(Long pchsUpcAmt) {
        this.pchsUpcAmt = pchsUpcAmt;
    }

    public Long getPchsAmt() {
        return pchsAmt;
    }

    public void setPchsAmt(Long pchsAmt) {
        this.pchsAmt = pchsAmt;
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

    public String getEmbGodsYn() {
        return embGodsYn;
    }

    public void setEmbGodsYn(String embGodsYn) {
        this.embGodsYn = embGodsYn;
    }

    public String getEstiRmrkCont() {
        return estiRmrkCont;
    }

    public void setEstiRmrkCont(String estiRmrkCont) {
        this.estiRmrkCont = estiRmrkCont;
    }

    public String getCostRmrkCont() {
        return costRmrkCont;
    }

    public void setCostRmrkCont(String costRmrkCont) {
        this.costRmrkCont = costRmrkCont;
    }
    /*
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
    */
    public Integer getMinUnitQnt() {
        return minUnitQnt;
    }

    public void setMinUnitQnt(Integer minUnitQnt) {
        this.minUnitQnt = minUnitQnt;
    }

    public Integer getMaxUnitQnt() {
        return maxUnitQnt;
    }

    public void setMaxUnitQnt(Integer maxUnitQnt) {
        this.maxUnitQnt = maxUnitQnt;
    }

    public Double getQntDcRt() {
        return qntDcRt;
    }

    public void setQntDcRt(Double qntDcRt) {
        this.qntDcRt = qntDcRt;
    }

    public Double getBscCostRt() {
        return bscCostRt;
    }

    public void setBscCostRt(Double bscCostRt) {
        this.bscCostRt = bscCostRt;
    }
/*
	public Long getMakeCostAmt() {
		return makeCostAmt;
	}

	public void setMakeCostAmt(Long makeCostAmt) {
		this.makeCostAmt = makeCostAmt;
	}*/

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

    public String getPrcDcOptnCdU() {
        return prcDcOptnCdU;
    }

    public void setPrcDcOptnCdU(String prcDcOptnCdU) {
        this.prcDcOptnCdU = prcDcOptnCdU;
    }

    public String getPrcDcOptnCdNmU() {
        return prcDcOptnCdNmU;
    }

    public void setPrcDcOptnCdNmU(String prcDcOptnCdNmU) {
        this.prcDcOptnCdNmU = prcDcOptnCdNmU;
    }

    public Double getDcRtU() {
        return dcRtU;
    }

    public void setDcRtU(Double dcRtU) {
        this.dcRtU = dcRtU;
    }

    public String getPrcDcOptnCdH() {
        return prcDcOptnCdH;
    }

    public void setPrcDcOptnCdH(String prcDcOptnCdH) {
        this.prcDcOptnCdH = prcDcOptnCdH;
    }

    public String getPrcDcOptnCdNmH() {
        return prcDcOptnCdNmH;
    }

    public void setPrcDcOptnCdNmH(String prcDcOptnCdNmH) {
        this.prcDcOptnCdNmH = prcDcOptnCdNmH;
    }

    public Double getDcRtH() {
        return dcRtH;
    }

    public void setDcRtH(Double dcRtH) {
        this.dcRtH = dcRtH;
    }

    public String getPrcDcOptnCdM() {
        return prcDcOptnCdM;
    }

    public void setPrcDcOptnCdM(String prcDcOptnCdM) {
        this.prcDcOptnCdM = prcDcOptnCdM;
    }

    public String getPrcDcOptnCdNmM() {
        return prcDcOptnCdNmM;
    }

    public void setPrcDcOptnCdNmM(String prcDcOptnCdNmM) {
        this.prcDcOptnCdNmM = prcDcOptnCdNmM;
    }

    public Double getDcRtM() {
        return dcRtM;
    }

    public void setDcRtM(Double dcRtM) {
        this.dcRtM = dcRtM;
    }

    public Integer getDcPlcySeq() {
        return dcPlcySeq;
    }

    public void setDcPlcySeq(Integer dcPlcySeq) {
        this.dcPlcySeq = dcPlcySeq;
    }

    public Double getPrcPlcyDcRt() {
        return prcPlcyDcRt;
    }

    public void setPrcPlcyDcRt(Double prcPlcyDcRt) {
        this.prcPlcyDcRt = prcPlcyDcRt;
    }

    public Double getAplcnCostRt() {
        return aplcnCostRt;
    }

    public void setAplcnCostRt(Double aplcnCostRt) {
        this.aplcnCostRt = aplcnCostRt;
    }

    public long getDrcstAmt() {
        return drcstAmt;
    }

    public void setDrcstAmt(long drcstAmt) {
        this.drcstAmt = drcstAmt;
    }

    public long getDrexpAmt() {
        return drexpAmt;
    }

    public void setDrexpAmt(long drexpAmt) {
        this.drexpAmt = drexpAmt;
    }

    public long getIncstAmt() {
        return incstAmt;
    }

    public void setIncstAmt(long incstAmt) {
        this.incstAmt = incstAmt;
    }

    public String getSplmPchsYn() {
        return splmPchsYn;
    }

    public void setSplmPchsYn(String splmPchsYn) {
        this.splmPchsYn = splmPchsYn;
    }

    public String getGodsClsfCd() {
        return godsClsfCd;
    }

    public void setGodsClsfCd(String godsClsfCd) {
        this.godsClsfCd = godsClsfCd;
    }

    public String getGodsClsfCdNm() {
        return godsClsfCdNm;
    }

    public void setGodsClsfCdNm(String godsClsfCdNm) {
        this.godsClsfCdNm = godsClsfCdNm;
    }

    public long getMaGodsSplyAmt() {
        return maGodsSplyAmt;
    }

    public void setMaGodsSplyAmt(long maGodsSplyAmt) {
        this.maGodsSplyAmt = maGodsSplyAmt;
    }

    public double getMaTrf() {
        return maTrf;
    }

    public void setMaTrf(double maTrf) {
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

    public String getMaTgtPrjtId() {
        return maTgtPrjtId;
    }

    public void setMaTgtPrjtId(String maTgtPrjtId) {
        this.maTgtPrjtId = maTgtPrjtId;
    }

    public String getMaTgtPrjtNm() {
        return maTgtPrjtNm;
    }

    public void setMaTgtPrjtNm(String maTgtPrjtNm) {
        this.maTgtPrjtNm = maTgtPrjtNm;
    }

    public String getPutHmfrGrdCd() {
        return putHmfrGrdCd;
    }

    public void setPutHmfrGrdCd(String putHmfrGrdCd) {
        this.putHmfrGrdCd = putHmfrGrdCd;
    }

    public long getStdCostAmt() {
        return stdCostAmt;
    }

    public void setStdCostAmt(long stdCostAmt) {
        this.stdCostAmt = stdCostAmt;
    }

    public double getPutNopCount() {
        return putNopCount;
    }

    public void setPutNopCount(double putNopCount) {
        this.putNopCount = putNopCount;
    }

    public String getLastCustId() {
        return lastCustId;
    }

    public void setLastCustId(String lastCustId) {
        this.lastCustId = lastCustId;
    }

    public String getPutHmfrGrdCdNm() {
        return putHmfrGrdCdNm;
    }

    public void setPutHmfrGrdCdNm(String putHmfrGrdCdNm) {
        this.putHmfrGrdCdNm = putHmfrGrdCdNm;
    }

    public String getSvcUpcCritCd() {
        return svcUpcCritCd;
    }

    public void setSvcUpcCritCd(String svcUpcCritCd) {
        this.svcUpcCritCd = svcUpcCritCd;
    }

    public String getSvcUpcCritCdNm() {
        return svcUpcCritCdNm;
    }

    public void setSvcUpcCritCdNm(String svcUpcCritCdNm) {
        this.svcUpcCritCdNm = svcUpcCritCdNm;
    }

    public String getMaGodsSplyYam() {
        return maGodsSplyYam;
    }

    public void setMaGodsSplyYam(String maGodsSplyYam) {
        this.maGodsSplyYam = maGodsSplyYam;
    }

    public String getMaGodsUpcUnitCd() {
        return maGodsUpcUnitCd;
    }

    public void setMaGodsUpcUnitCd(String maGodsUpcUnitCd) {
        this.maGodsUpcUnitCd = maGodsUpcUnitCd;
    }

    public String getMaGodsUpcUnitCdNm() {
        return maGodsUpcUnitCdNm;
    }

    public void setMaGodsUpcUnitCdNm(String maGodsUpcUnitCdNm) {
        this.maGodsUpcUnitCdNm = maGodsUpcUnitCdNm;
    }

    public Double getMaGodsSplyQnt() {
        return maGodsSplyQnt;
    }

    public void setMaGodsSplyQnt(Double maGodsSplyQnt) {
        this.maGodsSplyQnt = maGodsSplyQnt;
    }

}
