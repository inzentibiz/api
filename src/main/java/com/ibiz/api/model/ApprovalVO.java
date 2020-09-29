package com.ibiz.api.model;

import java.util.List;
import java.util.Map;

public class ApprovalVO {

    /**
     * 총 갯수
     */
    private Integer totalCnt;

    /**
     * 결재 ID
     */
    private String santId;

    /**
     * 결재 순전
     */
    private String santSeq;

    /**
     * 결재 부서 ID
     */
    private String santDeptId;

    /**
     * 문서제목
     */
    private String docTitl;

    /**
     * 본문내용
     */
    private String bdctCont;

    /**
     * 결재서식코드
     */
    private String santFrmtCd;

    /**
     * 결재서식코드명
     */
    private String santFrmtCdNm;

    /**
     * 결재 알림 구분 코드
     */
    private String santNtcDstCd;

    /**
     * 결재 알림 구분 명
     */
    private String santNtcDstCdNm;

    /**
     * 긴급 결재 구분 코드
     */
    private String emgDstCd;

    /**
     * 긴급 결재 구분 명
     */
    private String emgDstCdNm;

    /**
     * 결재진행상태코드
     */
    private String santPrgsStatCd;

    /**
     * 결재진행상태명
     */
    private String santPrgsStatCdNm;

    /**
     * 승인구분명
     */
    private String santAppvDstCdNm;
    /**
     * 첨부ID
     */
    private String fileAttcId;

    /**
     * 등록사원 ID
     */
    private String regEmpId;
    /**
     * 상신자명
     */
    private String regEmpNm;
    /**
     * 등록일시
     */
    private String RegDt;

    /**
     * 변경사원 ID
     */
    private String chgEmpId;

    /**
     * 변경사원명(최종결재자)
     */
    private String chgEmpNm;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 결재일
     */
    private String santDt;

    /**
     * 결재의견수
     */
    private String santOpinContCnt;
    /**
     * 결재자 상세 리스트
     */
    private List<ApprovalAuthorizerVO> approvalAuthorizerList;

    /**
     * 결재역할별 버튼 리스트
     */
    private List<Map<String, String>> roleButtonList;

    /**
     * 첨부파일 리스트
     */
    private List<AttachVO> attcFileList;

    /**
     * 진행중인결재시퀀스
     */
    private String ongoingSantSeq;

    /**
     * 미상신문서개수
     */
    private int numberToSubmit;
    /**
     * 미결재문서개수
     */
    private int numberToApprove;

    /**
     * 미확인수신문서개수
     */
    private int numberToCheck;

    /**
     * 기결재자가 존재하는지 여부 확인 결과
     */
    private String result;

    /**
     * 최종결재자ID
     */
    private String lastAprnEmpId;

    /**
     * 최종결재자명
     */
    private String lastAprnEmpNm;

    /**
     * 상신일자
     */
    private String rtosSantDt;

    /**
     * 최종결재일
     */
    private String lastSantDt;

    /**
     * 상신자ID
     */
    private String rtosEmpId;

    /**
     * 상신자명
     */
    private String rtosEmpNm;

    /**
     * 상신자명
     */
    private String rtosAprnEmpNm;

    private String santOpinCount;

    /**
     * 수신일자
     */
    private String rcvSantDt;

    /**
     * 결재완료일
     */
    private String cmplSantDt;

    private String nextAprnEmpNm;

    private String nextAprnRoleCd;

    private Integer nextSantSeq;

    /**
     * 결재자 역할 코드
     */
    private String aprnRoleCd;

    /**
     * 다음 결재자 아이디
     */
    private String nextAprnEmpId;

    /**
     * 다음결재자 구분
     */
    private String nextAprnRoleNm;

    /**
     *
     * inquireApprovalLine 관련..
     *
     */
    private String aprnEmpId;

    private String aprnEmpNm;

    private String aprnResoCd;

    private String aprnOfpsCd;

    private String santOpinCont;

    private String santAppvDstCd;

    private String mdtrAprnYn;


    /*
     * 결재조건 결재자 / 상신자
     * */

    private String iptChgEmpNm;
    private String iptRegEmpNm;

    /**
     * 에러 사유
     */
    private String errorText;

    /**
     * 변경리스트
     */
    private List<ApprovalVO> approvalChangeList;

    /**
     *  상신일자
     */

    private String rtosDate;

    /**
     * 마지막 결재일
     */
    private String lastSantDate;

    /**
     * 다음 결재자 역할
     */
    private String aprnRoleNm;

    /**
     * 화면 첨부ID
     */
    private String scrnAttcId;

    // 전체 결재자수
    private Integer aprnCnt;
    // 결재를 수행한 결재자수
    private Integer appvCnt;

    private List<Map<String, String>> buttonList;

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public String getSantSeq() {
        return santSeq;
    }

    public void setSantSeq(String santSeq) {
        this.santSeq = santSeq;
    }

    public String getSantDeptId() {
        return santDeptId;
    }

    public void setSantDeptId(String santDeptId) {
        this.santDeptId = santDeptId;
    }

    public String getDocTitl() {
        return docTitl;
    }

    public void setDocTitl(String docTitl) {
        this.docTitl = docTitl;
    }

    public String getBdctCont() {
        return bdctCont;
    }

    public void setBdctCont(String bdctCont) {
        this.bdctCont = bdctCont;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getSantFrmtCdNm() {
        return santFrmtCdNm;
    }

    public void setSantFrmtCdNm(String santFrmtCdNm) {
        this.santFrmtCdNm = santFrmtCdNm;
    }

    public String getSantNtcDstCd() {
        return santNtcDstCd;
    }

    public void setSantNtcDstCd(String santNtcDstCd) {
        this.santNtcDstCd = santNtcDstCd;
    }

    public String getSantNtcDstCdNm() {
        return santNtcDstCdNm;
    }

    public void setSantNtcDstCdNm(String santNtcDstCdNm) {
        this.santNtcDstCdNm = santNtcDstCdNm;
    }

    public String getEmgDstCd() {
        return emgDstCd;
    }

    public void setEmgDstCd(String emgDstCd) {
        this.emgDstCd = emgDstCd;
    }

    public String getEmgDstCdNm() {
        return emgDstCdNm;
    }

    public void setEmgDstCdNm(String emgDstCdNm) {
        this.emgDstCdNm = emgDstCdNm;
    }

    public String getSantPrgsStatCd() {
        return santPrgsStatCd;
    }

    public void setSantPrgsStatCd(String santPrgsStatCd) {
        this.santPrgsStatCd = santPrgsStatCd;
    }

    public String getSantPrgsStatCdNm() {
        return santPrgsStatCdNm;
    }

    public void setSantPrgsStatCdNm(String santPrgsStatCdNm) {
        this.santPrgsStatCdNm = santPrgsStatCdNm;
    }

    public String getSantAppvDstCdNm() {
        return santAppvDstCdNm;
    }

    public void setSantAppvDstCdNm(String santAppvDstCdNm) {
        this.santAppvDstCdNm = santAppvDstCdNm;
    }

    public String getFileAttcId() {
        return fileAttcId;
    }

    public void setFileAttcId(String fileAttcId) {
        this.fileAttcId = fileAttcId;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public String getRegEmpNm() {
        return regEmpNm;
    }

    public void setRegEmpNm(String regEmpNm) {
        this.regEmpNm = regEmpNm;
    }

    public String getRegDt() {
        return RegDt;
    }

    public void setRegDt(String regDt) {
        RegDt = regDt;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public String getChgEmpNm() {
        return chgEmpNm;
    }

    public void setChgEmpNm(String chgEmpNm) {
        this.chgEmpNm = chgEmpNm;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getSantDt() {
        return santDt;
    }

    public void setSantDt(String santDt) {
        this.santDt = santDt;
    }

    public String getSantOpinContCnt() {
        return santOpinContCnt;
    }

    public void setSantOpinContCnt(String santOpinContCnt) {
        this.santOpinContCnt = santOpinContCnt;
    }

    public List<ApprovalAuthorizerVO> getApprovalAuthorizerList() {
        return approvalAuthorizerList;
    }

    public void setApprovalAuthorizerList(List<ApprovalAuthorizerVO> approvalAuthorizerList) {
        this.approvalAuthorizerList = approvalAuthorizerList;
    }

    public List<Map<String, String>> getRoleButtonList() {
        return roleButtonList;
    }

    public void setRoleButtonList(List<Map<String, String>> roleButtonList) {
        this.roleButtonList = roleButtonList;
    }

    public List<AttachVO> getAttcFileList() {
        return attcFileList;
    }

    public void setAttcFileList(List<AttachVO> attcFileList) {
        this.attcFileList = attcFileList;
    }

    public String getOngoingSantSeq() {
        return ongoingSantSeq;
    }

    public void setOngoingSantSeq(String ongoingSantSeq) {
        this.ongoingSantSeq = ongoingSantSeq;
    }

    public int getNumberToSubmit() {
        return numberToSubmit;
    }

    public void setNumberToSubmit(int numberToSubmit) {
        this.numberToSubmit = numberToSubmit;
    }

    public int getNumberToApprove() {
        return numberToApprove;
    }

    public void setNumberToApprove(int numberToApprove) {
        this.numberToApprove = numberToApprove;
    }

    public int getNumberToCheck() {
        return numberToCheck;
    }

    public void setNumberToCheck(int numberToCheck) {
        this.numberToCheck = numberToCheck;
    }

    public String getResult() {
        return result;
    }

    public List<Map<String, String>> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Map<String, String>> buttonList) {
        this.buttonList = buttonList;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLastAprnEmpId() {
        return lastAprnEmpId;
    }

    public void setLastAprnEmpId(String lastAprnEmpId) {
        this.lastAprnEmpId = lastAprnEmpId;
    }

    public String getLastAprnEmpNm() {
        return lastAprnEmpNm;
    }

    public void setLastAprnEmpNm(String lastAprnEmpNm) {
        this.lastAprnEmpNm = lastAprnEmpNm;
    }

    public String getRtosSantDt() {
        return rtosSantDt;
    }

    public void setRtosSantDt(String rtosSantDt) {
        this.rtosSantDt = rtosSantDt;
    }

    public String getLastSantDt() {
        return lastSantDt;
    }

    public void setLastSantDt(String lastSantDt) {
        this.lastSantDt = lastSantDt;
    }

    public String getRtosEmpId() {
        return rtosEmpId;
    }

    public void setRtosEmpId(String rtosEmpId) {
        this.rtosEmpId = rtosEmpId;
    }

    public String getRtosEmpNm() {
        return rtosEmpNm;
    }

    public void setRtosEmpNm(String rtosEmpNm) {
        this.rtosEmpNm = rtosEmpNm;
    }

    public String getRtosAprnEmpNm() {
        return rtosAprnEmpNm;
    }

    public void setRtosAprnEmpNm(String rtosAprnEmpNm) {
        this.rtosAprnEmpNm = rtosAprnEmpNm;
    }

    public String getSantOpinCount() {
        return santOpinCount;
    }

    public void setSantOpinCount(String santOpinCount) {
        this.santOpinCount = santOpinCount;
    }

    public String getRcvSantDt() {
        return rcvSantDt;
    }

    public void setRcvSantDt(String rcvSantDt) {
        this.rcvSantDt = rcvSantDt;
    }

    public String getCmplSantDt() {
        return cmplSantDt;
    }

    public void setCmplSantDt(String cmplSantDt) {
        this.cmplSantDt = cmplSantDt;
    }

    public String getNextAprnEmpNm() {
        return nextAprnEmpNm;
    }

    public void setNextAprnEmpNm(String nextAprnEmpNm) {
        this.nextAprnEmpNm = nextAprnEmpNm;
    }

    public String getNextAprnRoleNm() {
        return nextAprnRoleNm;
    }

    public void setNextAprnRoleNm(String nextAprnRoleNm) {
        this.nextAprnRoleNm = nextAprnRoleNm;
    }

    public String getAprnRoleCd() {
        return aprnRoleCd;
    }

    public void setAprnRoleCd(String aprnRoleCd) {
        this.aprnRoleCd = aprnRoleCd;
    }

    public String getNextAprnEmpId() {
        return nextAprnEmpId;
    }

    public void setNextAprnEmpId(String nextAprnEmpId) {
        this.nextAprnEmpId = nextAprnEmpId;
    }

    public String getNextAprnRoleCd() {
        return nextAprnRoleCd;
    }

    public void setNextAprnRoleCd(String nextAprnRoleCd) {
        this.nextAprnRoleCd = nextAprnRoleCd;
    }

    public Integer getNextSantSeq() {
        return nextSantSeq;
    }

    public void setNextSantSeq(Integer nextSantSeq) {
        this.nextSantSeq = nextSantSeq;
    }

    public List<ApprovalVO> getApprovalChangeList() {
        return approvalChangeList;
    }

    public void setApprovalChangeList(List<ApprovalVO> approvalChangeList) {
        this.approvalChangeList = approvalChangeList;
    }

    public String getAprnEmpId() {
        return aprnEmpId;
    }

    public void setAprnEmpId(String aprnEmpId) {
        this.aprnEmpId = aprnEmpId;
    }

    public String getAprnEmpNm() {
        return aprnEmpNm;
    }

    public void setAprnEmpNm(String aprnEmpNm) {
        this.aprnEmpNm = aprnEmpNm;
    }

    public String getAprnResoCd() {
        return aprnResoCd;
    }

    public void setAprnResoCd(String aprnResoCd) {
        this.aprnResoCd = aprnResoCd;
    }

    public String getAprnOfpsCd() {
        return aprnOfpsCd;
    }

    public void setAprnOfpsCd(String aprnOfpsCd) {
        this.aprnOfpsCd = aprnOfpsCd;
    }

    public String getSantOpinCont() {
        return santOpinCont;
    }

    public void setSantOpinCont(String santOpinCont) {
        this.santOpinCont = santOpinCont;
    }

    public String getSantAppvDstCd() {
        return santAppvDstCd;
    }

    public void setSantAppvDstCd(String santAppvDstCd) {
        this.santAppvDstCd = santAppvDstCd;
    }

    public String getMdtrAprnYn() {
        return mdtrAprnYn;
    }

    public void setMdtrAprnYn(String mdtrAprnYn) {
        this.mdtrAprnYn = mdtrAprnYn;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getIptChgEmpNm() {
        return iptChgEmpNm;
    }

    public void setIptChgEmpNm(String iptChgEmpNm) {
        this.iptChgEmpNm = iptChgEmpNm;
    }

    public String getIptRegEmpNm() {
        return iptRegEmpNm;
    }

    public void setIptRegEmpNm(String iptRegEmpNm) {
        this.iptRegEmpNm = iptRegEmpNm;
    }

    public String getRtosDate() {
        return rtosDate;
    }

    public void setRtosDate(String rtosDate) {
        this.rtosDate = rtosDate;
    }

    public String getLastSantDate() {
        return lastSantDate;
    }

    public void setLastSantDate(String lastSantDate) {
        this.lastSantDate = lastSantDate;
    }

    public String getAprnRoleNm() {
        return aprnRoleNm;
    }

    public void setAprnRoleNm(String aprnRoleNm) {
        this.aprnRoleNm = aprnRoleNm;
    }

    public String getScrnAttcId() {
        return scrnAttcId;
    }

    public void setScrnAttcId(String scrnAttcId) {
        this.scrnAttcId = scrnAttcId;
    }

    public Integer getAprnCnt() {
        return aprnCnt;
    }

    public void setAprnCnt(Integer aprnCnt) {
        this.aprnCnt = aprnCnt;
    }

    public Integer getAppvCnt() {
        return appvCnt;
    }

    public void setAppvCnt(Integer appvCnt) {
        this.appvCnt = appvCnt;
    }
}