package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * BEST180T : MA서비스상세
 *
 */

public class EstimateMAServiceVO {

    /**
     * 견적ID
     */
    @NotNull
    @Size(max=10, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 견적ID는 10자리 이하여야합니다." )
    private String estiId;

    /**
     * 순번
     */
    @NotNull
    @Digits(integer=3,fraction=0)
    private Integer seq;

    /**
     * 서비스 업무명
     */
    @NotNull
    private String svcJobNm;

    /**
     * 서비스제공 조건내용
     */
    private String svcPrvdCdntCont;

    /**
     * 제공서비스 비고내용
     */
    private String prvdSvcRmrkCont;

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

    public String getSvcJobNm() {
        return svcJobNm;
    }

    public void setSvcJobNm(String svcJobNm) {
        this.svcJobNm = svcJobNm;
    }

    public String getSvcPrvdCdntCont() {
        return svcPrvdCdntCont;
    }

    public void setSvcPrvdCdntCont(String svcPrvdCdntCont) {
        this.svcPrvdCdntCont = svcPrvdCdntCont;
    }

    public String getPrvdSvcRmrkCont() {
        return prvdSvcRmrkCont;
    }

    public void setPrvdSvcRmrkCont(String prvdSvcRmrkCont) {
        this.prvdSvcRmrkCont = prvdSvcRmrkCont;
    }

    @Override
    public String toString() {
        return "EstimateMAServiceVO [estiId=" + estiId + ", seq=" + seq + ", svcJobNm=" + svcJobNm
                + ", svcPrvdCdntCont=" + svcPrvdCdntCont + ", prvdSvcRmrkCont=" + prvdSvcRmrkCont + "]";
    }

}
