package com.ibiz.api.service;

import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.dao.ProjectVRBDao;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProjectVRBService extends AbstractDraftService {

    @Resource(name = "projectVRBDao")
    private ProjectVRBDao projectVRBDao;

    @Resource(name="draftDao")
    private DraftDao draftDao;

    @Transactional
    public List<VRBVO> selectVRBAnalysisHistoryList(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisHistoryList");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        vrbVO.setSessEmpId(accountVO.getEmpId());
        List<VRBVO> vrbList = projectVRBDao.selectVRBAnalysisHistoryList(vrbVO);

        return vrbList;
    }

    @Transactional
    public VRBVO selectVRBAnalysis(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();
        VRBVO vrb;

        if (vrbVO.getVrbAnlyId() != null)
            vrbVO = projectVRBDao.selectVrbAnlyId(vrbVO);

        vrb = projectVRBDao.selectVRB(vrbVO);
        vrb.setProject(projectVRBDao.selectVRBProject(vrbVO));
        vrb.setVrbBizOpportunityList(projectVRBDao.selectVRBBusinessOpportunityListForView(vrbVO));
        vrb.setVrbCustomerAnalysisList(projectVRBDao.selectVRBCustomerAnlaysisList(vrbVO));
        vrb.setVrbBusinessAnalysisList(projectVRBDao.selectVRBBusinessAnalysisList(vrbVO));
        vrb.setVrbCompetitorAnalysisList(projectVRBDao.selectVRBCompetitorAnalysisList(vrbVO));
        vrb.setVrbParticipantList(projectVRBDao.selectVRBInvestigationResultList(vrbVO));

        vrb.setVrbProfitAnalysisDetailList(projectVRBDao.selectProfitAnalysisDetailForVRBList(vrbVO)); //수익가치 분석
        vrb.setProfitValueAnalysis(projectVRBDao.selectProfitAnalysisForVRB(vrbVO)); //수익가치분석

        if (vrb.getProfitValueAnalysis() != null) {
            // 순매출, 매출성과, 직간접비, 매출이익, 매출성과대비매출이익률, 공헌이익, 매출성과대비 공헌이익률
            vrb.getProfitValueAnalysis().setNsleAmt(vrb.getProfitValueAnalysis().getSplyAmt() - vrb.getProfitValueAnalysis().getBuyCostAmt());
            vrb.getProfitValueAnalysis().setSellRslt(vrb.getProfitValueAnalysis().getNsleAmt() + vrb.getProfitValueAnalysis().getSvcBuyCostAmt());
            vrb.getProfitValueAnalysis().setDrcstIncstAmt(vrb.getProfitValueAnalysis().getIncstAmt() + vrb.getProfitValueAnalysis().getDrcstAmt());
            vrb.getProfitValueAnalysis().setSellPrf(vrb.getProfitValueAnalysis().getNsleAmt() - vrb.getProfitValueAnalysis().getDrcstAmt() - vrb.getProfitValueAnalysis().getDrexpAmt());

            if (vrb.getProfitValueAnalysis().getSellRslt() != 0)
                vrb.getProfitValueAnalysis().setSellPrfRt(vrb.getProfitValueAnalysis().getSellPrf() / (float)vrb.getProfitValueAnalysis().getSellRslt());
            vrb.getProfitValueAnalysis().setCtmgAmt(vrb.getProfitValueAnalysis().getSellPrf()-vrb.getProfitValueAnalysis().getIncstAmt());
            vrb.getProfitValueAnalysis().setCtmgAmtRt(vrb.getProfitValueAnalysis().getCtmgAmt() / (float)vrb.getProfitValueAnalysis().getSellRslt());
        }

        vrb.setApproval(super.selectApprovalInfo(vrbVO.getSantId()));

        //폐기일때 false
        if(vrb.getVrbPrgsStatCd().equals('W')) {
            vrb.setIsInProgress(false);
        }else {
            vrb.setIsInProgress(true);
        }

        return vrb;
    }

    @Transactional
    public VRBVO updateDraftPrgsStatCd(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateDraftPrgsStatCd");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();
        VRBVO vrb = new VRBVO();

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        switch (vrbVO.getSantPrgsStatCd()) {
            case "A":	// 미상신
                vrbVO.setVrbPrgsStatCd("A"); // 등록
                break;
            case "B":	// 결재중
                vrbVO.setVrbPrgsStatCd("B"); // 결재진행
                break;
            case "C":	// 완결
                vrbVO.setVrbPrgsStatCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                vrbVO.setVrbPrgsStatCd("R"); // 반려
                break;
            case "W":	// 폐기
                vrbVO.setVrbPrgsStatCd("W"); // 폐기
                break;
        }

        projectVRBDao.updateVrbPrgsStatCd(vrbVO);

        //화면 바인딩을 위함
        vrb = projectVRBDao.selectVrbPrgsStatCd(vrbVO);

        if(vrbVO.getSantPrgsStatCd().equals("W")){
            vrb.setIsInProgress(false);
        }else {
            vrb.setIsInProgress(true);
        }

        return vrb;
    }

    @Transactional
    public VRBVO selectPrjtIdAndVrbAnlyId(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectPrjtIdAndVrbAnlyId");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        VRBVO vrb = projectVRBDao.selectPrjtIdAndVrbAnlyId(vrbVO);

        return vrb;
    }

    @Transactional
    public ApprovalVO selectDraftButtonList(Payload<VRBVO> requestPayload) throws Exception { //수정
        log.info("Call Service : " + this.getClass().getName() + ".selectDraftButtonList");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrb = requestPayload.getDto();

        ApprovalDetailVO approvalDetail = new ApprovalDetailVO();
        ApprovalVO approvalVO = new ApprovalVO();

        UserGrpVO userGrpVO = new UserGrpVO();
        List<Map<String, String>> buttonList = new ArrayList<>();

        userGrpVO.setTargetUserId(vrb.getSlsEmpId());
        userGrpVO.setSourceUserId(accountVO.getEmpId());

        VRBVO vrbVO = projectVRBDao.selectVrbAnlyId(vrb);

        vrb.setProject(projectVRBDao.selectVRBProject(vrbVO));

        if (vrbVO.getSantId() != null &&
                (super.isBelongToAuthDept(userGrpVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(vrb.getSantId());
            approvalDetail.setUserGrpVO(userGrpVO);

            // 버튼 리스트
            if (vrbVO.getVrbPrgsStatCd().equals("A") ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) && vrbVO.getVrbPrgsStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }

            if (vrbVO.getVrbPrgsStatCd().equals("C")) {
                buttonList.add(new HashMap<String, String>() {{put("button", "견적작성"); }});
                buttonList.add(new HashMap<String, String>() {{put("button", "수주작성"); }});
            }

            if (  (vrbVO.getVrbPrgsStatCd().equals("C") || vrbVO.getVrbPrgsStatCd().equals("R")) && (userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) || accountVO.getRoleList().contains("AD")) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }
        }
        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public VRBVO deleteVRBAnalysis(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        // '수익가치 분석' 의 경우 '예상손익분석' 기획이 나온뒤에 추가해야함
        projectVRBDao.deleteVrbProfitAnalysisDetail(vrbVO);
        projectVRBDao.deleteVRBBusinessAnalysis(vrbVO);
        projectVRBDao.deleteVRBInvestigationResult(vrbVO);
        projectVRBDao.deleteVRBCompetitorAnalysis(vrbVO);
        projectVRBDao.deleteVRBCustomerAnalysis(vrbVO);

        ApprovalVO approvalVO = new ApprovalVO();
        if (vrbVO.getSantId() != null) {
            approvalVO.setSantId(vrbVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        projectVRBDao.deleteVRB(vrbVO);

        return vrbVO;
    }

    @Transactional
    public VRBVO discardDraft(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".discardDraft");
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = requestPayload.getDto();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        draftDao.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        VRBVO vrbVO = new VRBVO();
        vrbVO.setSantId(approvalVO.getSantId());
        vrbVO.setVrbPrgsStatCd("W");
        projectVRBDao.updateVrbPrgsStatCd(vrbVO);

        return vrbVO;
    }

    @Transactional
    public VRBVO selectVRBAnalysisForInsert(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisForInsert");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
        VRBVO vrb = new VRBVO();

        vrb.setProject(projectVRBDao.selectVRBProject(vrbVO));
        vrb.setVrbBizOpportunityList(projectVRBDao.selectVRBBusinessOpportunityList(vrbVO));

        return vrb;
    }

    @Transactional
    public VRBVO selectVRBAnalysisForUpdate(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisForUpdate");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();
        VRBVO vrb =  projectVRBDao.selectVRB(vrbVO);

        vrb.setProject(projectVRBDao.selectVRBProject(vrbVO));
        vrb.setVrbBizOpportunityList(projectVRBDao.selectVRBBusinessOpportunityList(vrbVO));
        vrb.setVrbCustomerAnalysisList(projectVRBDao.selectVRBCustomerAnlaysisList(vrbVO));
        vrb.setVrbBusinessAnalysisList(projectVRBDao.selectVRBBusinessAnalysisList(vrbVO));
        vrb.setVrbCompetitorAnalysisList(projectVRBDao.selectVRBCompetitorAnalysisList(vrbVO));
        vrb.setVrbParticipantList(projectVRBDao.selectVRBInvestigationResultList(vrbVO));

        return vrb;
    }

    @Transactional
    public List<CommonGroupVO> selectVRBAnlyItmCdList(Payload<CommonGroupVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnlyItmCdList");
        AccountVO accountVO = requestPayload.getAccountVO();
        CommonGroupVO commonGroupVO = requestPayload.getDto();
        List<CommonGroupVO> list =  projectVRBDao.selectVRBAnlyItmCdList(commonGroupVO);

        return list;
    }

    @Transactional
    public VRBVO insertVRBAnalysis(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        String prevId = projectVRBDao.selectMaxVRBAnlyId().getVrbAnlyId();
        vrbVO.setVrbAnlyId(IndexUtils.generateId(10, prevId));
        vrbVO.setRegEmpId(accountVO.getEmpId());

        // 결재 등록 (미상신)
        vrbVO.setVrbPrgsStatCd("A");
        vrbVO.getApproval().setRegEmpId(accountVO.getEmpId());
        vrbVO.getApproval().setSantFrmtCd("B03");
        vrbVO.setSantFrmtCd("B03");
        vrbVO.getApproval().setDocTitl(projectVRBDao.selectDraftVRBDocTitl(vrbVO));
        vrbVO.setSantId(super.insertDraft(vrbVO.getApproval()));

        //문서번호 갖고오기
        String prevDocNo = projectVRBDao.selectMaxDocNo(vrbVO).getDocNo();
        vrbVO.setDocNo(super.generateDocId(3, prevDocNo));

        projectVRBDao.insertVRB(vrbVO);

        // 고객분석내역
        if (vrbVO.getVrbCustomerAnalysisList() != null) {
            for (VRBCustomerAnalysisVO vrbCustomerAnalysisVO : vrbVO.getVrbCustomerAnalysisList()) {
                vrbCustomerAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBCustomerAnalysis(vrbCustomerAnalysisVO);
            }
        }

        if (vrbVO.getVrbProfitAnalysisDetailList() != null) {
            for (VRBProfitAnalysisDetailVO vrbProfitAnalysisDetailVO : vrbVO.getVrbProfitAnalysisDetailList()) {
                vrbProfitAnalysisDetailVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertEstimateIntoVrbProfitAnalysisDetail(vrbProfitAnalysisDetailVO);
            }
        }

        // 사업분석내역 : 전략적사업가치, 사업수행리스크, 수주&수행전략
        if (vrbVO.getVrbBusinessAnalysisList() != null) {
            for (VRBBusinessAnalysisVO vrbBusinessAnalysisVO : vrbVO.getVrbBusinessAnalysisList()) {
                vrbBusinessAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBBusinessAnalysis(vrbBusinessAnalysisVO);
            }
        }

        // 경쟁사 분석 리스트
        if (vrbVO.getVrbCompetitorAnalysisList() != null) {
            for (VRBCompetitorAnalysisVO vrbCompetitorAnalysisVO : vrbVO.getVrbCompetitorAnalysisList()) {
                vrbCompetitorAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBCompetitorAnalysis(vrbCompetitorAnalysisVO);
            }
        }

        if (vrbVO.getVrbParticipantList() != null) {
            for (VRBParticipantVO vrbParticipantVO  : vrbVO.getVrbParticipantList()) {
                vrbParticipantVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBInvestigationResult(vrbParticipantVO);
            }
        }

        return vrbVO;
    }

    @Transactional
    public VRBVO updateVRBAnalysis(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        vrbVO.setChgEmpId(accountVO.getEmpId());
        projectVRBDao.updateVRB(vrbVO);

        // 고객분석내역
        if (vrbVO.getVrbCustomerAnalysisList() != null) {
            projectVRBDao.deleteVRBCustomerAnalysis(vrbVO);
            for (VRBCustomerAnalysisVO vrbCustomerAnalysisVO : vrbVO.getVrbCustomerAnalysisList()) {
                vrbCustomerAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBCustomerAnalysis(vrbCustomerAnalysisVO);
            }
        }

        if (vrbVO.getVrbProfitAnalysisDetailList() != null) {
            projectVRBDao.deleteVrbProfitAnalysisDetail(vrbVO);
            for (VRBProfitAnalysisDetailVO vrbProfitAnalysisDetailVO : vrbVO.getVrbProfitAnalysisDetailList()) {
                vrbProfitAnalysisDetailVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertEstimateIntoVrbProfitAnalysisDetail(vrbProfitAnalysisDetailVO);
            }
        }

        // 사업분석내역 : 전략적사업가치, 사업수행리스크, 수주&수행전략
        if (vrbVO.getVrbBusinessAnalysisList() != null) {
            for (VRBBusinessAnalysisVO vrbBusinessAnalysisVO : vrbVO.getVrbBusinessAnalysisList()) {
                vrbBusinessAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.updateVRBBusinessAnalysis(vrbBusinessAnalysisVO);
            }
        }

        if (vrbVO.getVrbCompetitorAnalysisList() != null) {
            projectVRBDao.deleteVRBCompetitorAnalysis(vrbVO);
            for (VRBCompetitorAnalysisVO vrbCompetitorAnalysisVO : vrbVO.getVrbCompetitorAnalysisList()) {
                vrbCompetitorAnalysisVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBCompetitorAnalysis(vrbCompetitorAnalysisVO);
            }
        }

        if (vrbVO.getVrbParticipantList() != null) {
            projectVRBDao.deleteVRBInvestigationResult(vrbVO);
            for (VRBParticipantVO vrbParticipantVO  : vrbVO.getVrbParticipantList()) {
                vrbParticipantVO.setVrbAnlyId(vrbVO.getVrbAnlyId());
                projectVRBDao.insertVRBInvestigationResult(vrbParticipantVO);
            }
        }

        vrbVO.setApproval(vrbVO.getApproval());
        vrbVO.getApproval().setSantFrmtCd("B03");
        vrbVO.setSantFrmtCd("B03");
        vrbVO.getApproval().setDocTitl(projectVRBDao.selectDraftVRBDocTitl(vrbVO));

        if (vrbVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(vrbVO.getApproval());

        super.updateDraft(vrbVO.getApproval());

        return vrbVO;
    }

    @Transactional
    public List<VRBBizOpportunityVO> selectVRBBusinessOpportunityList(Payload<VRBVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBVO vrbVO = requestPayload.getDto();

        List<VRBBizOpportunityVO> list = projectVRBDao.selectVRBBusinessOpportunityList(vrbVO);

        return list;
    }
}
