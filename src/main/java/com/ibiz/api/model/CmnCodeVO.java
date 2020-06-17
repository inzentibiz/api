package com.ibiz.api.model;

public class CmnCodeVO {

    /**
     * 컬럼명
     */
    private String clmnNm;

    /**
     * 공통그룹코드
     */
    private String comGrpCd;

    /**
     * 공통코드
     */
    private String comCd;

    /**
     * 공통코드명
     */
    private String comCdNm;

    /**
     * 상위코드
     */
    private String hgrkComCd;

    /**
     * 문자값
     */
    private String comCdCharVal;

    /**
     * 상위그룹코드
     */
    private String hgrkComGrpCd;

    /**
     * 숫자값
     */
    private String comCdNumVal;
    /**
     * 하위 공통코드 아이디
     */

    /**
     * 사용여부
     */
    private String useYN;

    public String getClmnNm() {
        return clmnNm;
    }

    public void setClmnNm(String clmnNm) {
        this.clmnNm = clmnNm;
    }

    public String getComGrpCd() {
        return comGrpCd;
    }

    public void setComGrpCd(String comGrpCd) {
        this.comGrpCd = comGrpCd;
    }

    public String getComCd() {
        return comCd;
    }

    public void setComCd(String comCd) {
        this.comCd = comCd;
    }

    public String getComCdNm() {
        return comCdNm;
    }

    public void setComCdNm(String comCdNm) {
        this.comCdNm = comCdNm;
    }

    public String getHgrkComCd() {
        return hgrkComCd;
    }

    public void setHgrkComCd(String hgrkComCd) {
        this.hgrkComCd = hgrkComCd;
    }

    public String getComCdCharVal() {
        return comCdCharVal;
    }

    public void setComCdCharVal(String comCdCharVal) {
        this.comCdCharVal = comCdCharVal;
    }

    public String getHgrkComGrpCd() {
        return hgrkComGrpCd;
    }

    public void setHgrkComGrpCd(String hgrkComGrpCd) {
        this.hgrkComGrpCd = hgrkComGrpCd;
    }

    public String getComCdNumVal() {
        return comCdNumVal;
    }

    public void setComCdNumVal(String comCdNumVal) {
        this.comCdNumVal = comCdNumVal;
    }

    public String getUseYN() {
        return useYN;
    }

    public void setUseYN(String useYN) {
        this.useYN = useYN;
    }
}
