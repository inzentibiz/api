package com.ibiz.api.model;

// ACOM030T 코드매핑테이블
public class CommonCodeMappingVO {

    // 공통그룹코드
    private String comGrpCd;

    // 공통그룹코드명
    private String comGrpCdNm;

    // 공통코드
    private String comCd;

    // 공통코드명
    private String comCdNm;

    // 매핑시스템구분코드
    private String mappSysDstCd;

    // 매핑시스템구분코드명
    private String mappSysDstCdNm;

    // 매핑컬럼명
    private String mappClmnNm;

    // 매핑공통코드
    private String mappComCd;

    // 매핑속성명
    private String mappAtrbNm;

    // 매핑공통코드명
    private String mappComCdNm;

    // 유효시작일자
    private String avlStartDate;

    // 유효종료일자
    private String avlEndDate;

    public String getComGrpCd() {
        return comGrpCd;
    }

    public void setComGrpCd(String comGrpCd) {
        this.comGrpCd = comGrpCd;
    }

    public String getComGrpCdNm() {
        return comGrpCdNm;
    }

    public void setComGrpCdNm(String comGrpCdNm) {
        this.comGrpCdNm = comGrpCdNm;
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

    public String getMappSysDstCd() {
        return mappSysDstCd;
    }

    public void setMappSysDstCd(String mappSysDstCd) {
        this.mappSysDstCd = mappSysDstCd;
    }

    public String getMappSysDstCdNm() {
        return mappSysDstCdNm;
    }

    public void setMappSysDstCdNm(String mappSysDstCdNm) {
        this.mappSysDstCdNm = mappSysDstCdNm;
    }

    public String getMappClmnNm() {
        return mappClmnNm;
    }

    public void setMappClmnNm(String mappClmnNm) {
        this.mappClmnNm = mappClmnNm;
    }

    public String getMappComCd() {
        return mappComCd;
    }

    public void setMappComCd(String mappComCd) {
        this.mappComCd = mappComCd;
    }

    public String getMappAtrbNm() {
        return mappAtrbNm;
    }

    public void setMappAtrbNm(String mappAtrbNm) {
        this.mappAtrbNm = mappAtrbNm;
    }

    public String getMappComCdNm() {
        return mappComCdNm;
    }

    public void setMappComCdNm(String mappComCdNm) {
        this.mappComCdNm = mappComCdNm;
    }

    public String getAvlStartDate() {
        return avlStartDate;
    }

    public void setAvlStartDate(String avlStartDate) {
        this.avlStartDate = avlStartDate;
    }

    public String getAvlEndDate() {
        return avlEndDate;
    }

    public void setAvlEndDate(String avlEndDate) {
        this.avlEndDate = avlEndDate;
    }
}
