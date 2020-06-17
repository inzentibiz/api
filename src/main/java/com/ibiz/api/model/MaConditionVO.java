package com.ibiz.api.model;
/**
 *
 * BEST080T : 유지보수제공조건상세
 *
 */
public class MaConditionVO {

    /**
     * 예상손익ID
     */
    private String fcstPalId;

    /**
     * 순번
     */
    private Integer seq;

    /**
     * 기술서비스코드
     */
    private String techSvcCd;

    /**
     * 기술서비스코드명
     */
    private String techSvcNm;

    /**
     * 서비스제공조건내용
     */
    private String svcPrvdCdntCont;

    /**
     * 서비스단가기준코드
     */
    private String svcUpcCritCd;

    /**
     * 서비스단가기준코드명
     */
    private String svcUpcCritNm;

    /**
     * 연간예상투입원가금액
     */
    private Long yrlyFcstPutCostAmt;

    /**
     * 비고내용
     */
    private String rmrkCont;


    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getTechSvcCd() {
        return techSvcCd;
    }

    public void setTechSvcCd(String techSvcCd) {
        this.techSvcCd = techSvcCd;
    }

    public String getTechSvcNm() {
        return techSvcNm;
    }

    public void setTechSvcNm(String techSvcNm) {
        this.techSvcNm = techSvcNm;
    }

    public String getSvcPrvdCdntCont() {
        return svcPrvdCdntCont;
    }

    public void setSvcPrvdCdntCont(String svcPrvdCdntCont) {
        this.svcPrvdCdntCont = svcPrvdCdntCont;
    }

    public String getSvcUpcCritCd() {
        return svcUpcCritCd;
    }

    public void setSvcUpcCritCd(String svcUpcCritCd) {
        this.svcUpcCritCd = svcUpcCritCd;
    }

    public String getSvcUpcCritNm() {
        return svcUpcCritNm;
    }

    public void setSvcUpcCritNm(String svcUpcCritNm) {
        this.svcUpcCritNm = svcUpcCritNm;
    }

    public Long getYrlyFcstPutCostAmt() {
        return yrlyFcstPutCostAmt;
    }

    public void setYrlyFcstPutCostAmt(Long yrlyFcstPutCostAmt) {
        this.yrlyFcstPutCostAmt = yrlyFcstPutCostAmt;
    }

    public String getRmrkCont() {
        return rmrkCont;
    }

    public void setRmrkCont(String rmrkCont) {
        this.rmrkCont = rmrkCont;
    }


}
