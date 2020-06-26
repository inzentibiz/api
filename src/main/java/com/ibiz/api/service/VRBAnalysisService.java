package com.ibiz.api.service;

import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.dao.VRBAnalysisDAO;
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
public class VRBAnalysisService extends AbstractDraftService {

    @Resource(name = "vrbAnalysisDAO")
    private VRBAnalysisDAO vrbAnalysisDAO;

    @Resource(name="draftDao")
    private DraftDao draftDao;

    @Transactional
    public List<VRBAnalysisVO> selectVRBAnalysisList(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisList");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        vrbAnalysisVO.setSessEmpId(accountVO.getEmpId());
        List<VRBAnalysisVO> vrbList = vrbAnalysisDAO.selectVRBAnalysisList(vrbAnalysisVO);

        return vrbList;
    }

    @Transactional
    public VRBAnalysisVO selectVRBAnalysis(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();
        VRBAnalysisVO vrb;

        if (vrbAnalysisVO.getVrbAnlyId() != null)
            vrbAnalysisVO = vrbAnalysisDAO.selectVRBAnlyId(vrbAnalysisVO);

        vrb = vrbAnalysisDAO.selectVRBAnalysis(vrbAnalysisVO);
        vrb.setProject(vrbAnalysisDAO.selectVRBAnalysisProject(vrbAnalysisVO));
        vrb.setVrbBizOpportunityList(vrbAnalysisDAO.selectVRBAnalysisBizChanceListForView(vrbAnalysisVO));
        vrb.setVrbCustomerAnalysisList(vrbAnalysisDAO.selectVRBCustomerList(vrbAnalysisVO));
        vrb.setVrbBusinessAnalysisList(vrbAnalysisDAO.selectVRBStrategyList(vrbAnalysisVO));
        vrb.setVrbCompetitorAnalysisList(vrbAnalysisDAO.selectVRBCompetitorList(vrbAnalysisVO));
        vrb.setVrbParticipantList(vrbAnalysisDAO.selectVRBOpinionList(vrbAnalysisVO));

        vrb.setVrbProfitAnalysisDetailList(vrbAnalysisDAO.selectVRBAnalysisErnnAnlyList(vrbAnalysisVO)); //수익가치 분석
        vrb.setProfitValueAnalysis(vrbAnalysisDAO.selectVRBAnalysisErnnAnly(vrbAnalysisVO)); //수익가치분석

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

        vrb.setApproval(super.selectApprovalInfo(vrbAnalysisVO.getSantId()));

        //폐기일때 false
        if(vrb.getVrbPrgsStatCd().equals('W')) {
            vrb.setIsInProgress(false);
        }else {
            vrb.setIsInProgress(true);
        }

        return vrb;
    }

    @Transactional
    public VRBAnalysisVO updateVRBAnalysisStat(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateVRBAnalysisStat");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();
        VRBAnalysisVO vrb = new VRBAnalysisVO();

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        switch (vrbAnalysisVO.getSantPrgsStatCd()) {
            case "A":	// 미상신
                vrbAnalysisVO.setVrbPrgsStatCd("A"); // 등록
                break;
            case "B":	// 결재중
                vrbAnalysisVO.setVrbPrgsStatCd("B"); // 결재진행
                break;
            case "C":	// 완결
                vrbAnalysisVO.setVrbPrgsStatCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                vrbAnalysisVO.setVrbPrgsStatCd("R"); // 반려
                break;
            case "W":	// 폐기
                vrbAnalysisVO.setVrbPrgsStatCd("W"); // 폐기
                break;
        }

        vrbAnalysisDAO.updateVrbPrgsStatCd(vrbAnalysisVO);

        //화면 바인딩을 위함
        vrb = vrbAnalysisDAO.selectVRBPrgsStatCd(vrbAnalysisVO);

        if(vrbAnalysisVO.getSantPrgsStatCd().equals("W")){
            vrb.setIsInProgress(false);
        }else {
            vrb.setIsInProgress(true);
        }

        return vrb;
    }

    @Transactional
    public VRBAnalysisVO selectPrjtIdAndVrbAnlyId(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectPrjtIdAndVrbAnlyId");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        VRBAnalysisVO vrb = vrbAnalysisDAO.selectPrjtIdAndVrbAnlyId(vrbAnalysisVO);

        return vrb;
    }

    @Transactional
    public ApprovalVO selectVRBAnalysisDrfBtnList(Payload<VRBAnalysisVO> requestPayload) throws Exception { //수정
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisDrfBtnList");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrb = requestPayload.getDto();

        ApprovalDetailVO approvalDetail = new ApprovalDetailVO();
        ApprovalVO approvalVO = new ApprovalVO();

        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<Map<String, String>> buttonList = new ArrayList<>();

        sysUserGroupVO.setTargetUserId(vrb.getSlsEmpId());
        sysUserGroupVO.setSourceUserId(accountVO.getEmpId());

        VRBAnalysisVO vrbAnalysisVO = vrbAnalysisDAO.selectVRBAnlyId(vrb);

        vrb.setProject(vrbAnalysisDAO.selectVRBAnalysisProject(vrbAnalysisVO));

        if (vrbAnalysisVO.getSantId() != null &&
                (super.isBelongToAuthDept(sysUserGroupVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(vrb.getSantId());
            approvalDetail.setSysUserGroupVO(sysUserGroupVO);

            // 버튼 리스트
            if (vrbAnalysisVO.getVrbPrgsStatCd().equals("A") ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && vrbAnalysisVO.getVrbPrgsStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }

            if (vrbAnalysisVO.getVrbPrgsStatCd().equals("C")) {
                buttonList.add(new HashMap<String, String>() {{put("button", "견적작성"); }});
                buttonList.add(new HashMap<String, String>() {{put("button", "수주작성"); }});
            }

            if (  (vrbAnalysisVO.getVrbPrgsStatCd().equals("C") || vrbAnalysisVO.getVrbPrgsStatCd().equals("R")) && (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) || accountVO.getRoleList().contains("AD")) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }
        }
        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public VRBAnalysisVO deleteVRBAnalysis(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        // '수익가치 분석' 의 경우 '예상손익분석' 기획이 나온뒤에 추가해야함
        vrbAnalysisDAO.deleteVRBProfit(vrbAnalysisVO);
        vrbAnalysisDAO.deleteVRBStrategy(vrbAnalysisVO);
        vrbAnalysisDAO.deleteVRBOpinion(vrbAnalysisVO);
        vrbAnalysisDAO.deleteVRBCompetitor(vrbAnalysisVO);
        vrbAnalysisDAO.deleteVRBCustomer(vrbAnalysisVO);

        ApprovalVO approvalVO = new ApprovalVO();
        if (vrbAnalysisVO.getSantId() != null) {
            approvalVO.setSantId(vrbAnalysisVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        vrbAnalysisDAO.deleteVRBAnalysis(vrbAnalysisVO);

        return vrbAnalysisVO;
    }

    @Transactional
    public VRBAnalysisVO updateVRBAnalysisDss(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateVRBAnalysisDss");
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = requestPayload.getDto();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        draftDao.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        VRBAnalysisVO vrbAnalysisVO = new VRBAnalysisVO();
        vrbAnalysisVO.setSantId(approvalVO.getSantId());
        vrbAnalysisVO.setVrbPrgsStatCd("W");
        vrbAnalysisDAO.updateVrbPrgsStatCd(vrbAnalysisVO);

        return vrbAnalysisVO;
    }

    @Transactional
    public VRBAnalysisVO selectVRBAnalysisForInsert(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisForInsert");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
        VRBAnalysisVO vrb = new VRBAnalysisVO();

        vrb.setProject(vrbAnalysisDAO.selectVRBAnalysisProject(vrbAnalysisVO));
        vrb.setVrbBizOpportunityList(vrbAnalysisDAO.selectVRBAnalysisBizChanceList(vrbAnalysisVO));

        return vrb;
    }

    @Transactional
    public VRBAnalysisVO selectVRBAnalysisForUpdate(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnalysisForUpdate");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();
        VRBAnalysisVO vrb =  vrbAnalysisDAO.selectVRBAnalysis(vrbAnalysisVO);

        vrb.setProject(vrbAnalysisDAO.selectVRBAnalysisProject(vrbAnalysisVO));
        vrb.setVrbBizOpportunityList(vrbAnalysisDAO.selectVRBAnalysisBizChanceList(vrbAnalysisVO));

        vrb.setVrbCustomerAnalysisList(vrbAnalysisDAO.selectVRBCustomerList(vrbAnalysisVO));
        vrb.setVrbBusinessAnalysisList(vrbAnalysisDAO.selectVRBStrategyList(vrbAnalysisVO));
        vrb.setVrbCompetitorAnalysisList(vrbAnalysisDAO.selectVRBCompetitorList(vrbAnalysisVO));
        vrb.setVrbParticipantList(vrbAnalysisDAO.selectVRBOpinionList(vrbAnalysisVO));

        return vrb;
    }

    @Transactional
    public List<CommonGroupVO> selectVRBAnlyItmCdList(Payload<CommonGroupVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBAnlyItmCdList");
        AccountVO accountVO = requestPayload.getAccountVO();
        CommonGroupVO commonGroupVO = requestPayload.getDto();
        List<CommonGroupVO> list =  vrbAnalysisDAO.selectVRBAnlyItmCdList(commonGroupVO);

        return list;
    }

    @Transactional
    public VRBAnalysisVO insertVRBAnalysis(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        String prevId = vrbAnalysisDAO.selectMaxVRBAnlyId().getVrbAnlyId();
        vrbAnalysisVO.setVrbAnlyId(IndexUtils.generateId(10, prevId));
        vrbAnalysisVO.setRegEmpId(accountVO.getEmpId());

        // 결재 등록 (미상신)
        vrbAnalysisVO.setVrbPrgsStatCd("A");
        vrbAnalysisVO.getApproval().setRegEmpId(accountVO.getEmpId());
        vrbAnalysisVO.getApproval().setSantFrmtCd("B03");
        vrbAnalysisVO.setSantFrmtCd("B03");
        vrbAnalysisVO.getApproval().setDocTitl(vrbAnalysisDAO.selectDraftVRBAnalysisTitle(vrbAnalysisVO));
        vrbAnalysisVO.setSantId(super.insertDraft(vrbAnalysisVO.getApproval()));

        //문서번호 갖고오기
        String prevDocNo = vrbAnalysisDAO.selectVRBAnalysisMaxDocNo(vrbAnalysisVO).getDocNo();
        vrbAnalysisVO.setDocNo(super.generateDocId(3, prevDocNo));

        vrbAnalysisDAO.insertVRBAnalysis(vrbAnalysisVO);

        // 고객분석내역
        if (vrbAnalysisVO.getVrbCustomerAnalysisList() != null) {
            for (VRBCustomerVO vrbCustomerVO : vrbAnalysisVO.getVrbCustomerAnalysisList()) {
                vrbCustomerVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBCustomer(vrbCustomerVO);
            }
        }

        if (vrbAnalysisVO.getVrbProfitAnalysisDetailList() != null) {
            for (VRBProfitVO vrbProfitVO : vrbAnalysisVO.getVrbProfitAnalysisDetailList()) {
                vrbProfitVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertOfferProfitIntoVrbAnalysis(vrbProfitVO);
            }
        }

        // 사업분석내역 : 전략적사업가치, 사업수행리스크, 수주&수행전략
        if (vrbAnalysisVO.getVrbBusinessAnalysisList() != null) {
            for (VRBStrategyVO vrbStrategyVO : vrbAnalysisVO.getVrbBusinessAnalysisList()) {
                vrbStrategyVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBStrategy(vrbStrategyVO);
            }
        }

        // 경쟁사 분석 리스트
        if (vrbAnalysisVO.getVrbCompetitorAnalysisList() != null) {
            for (VRBCompetitorVO vrbCompetitorVO : vrbAnalysisVO.getVrbCompetitorAnalysisList()) {
                vrbCompetitorVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBCompetitor(vrbCompetitorVO);
            }
        }

        if (vrbAnalysisVO.getVrbParticipantList() != null) {
            for (VRBOpinionVO vrbOpinionVO : vrbAnalysisVO.getVrbParticipantList()) {
                vrbOpinionVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBOpinion(vrbOpinionVO);
            }
        }

        return vrbAnalysisVO;
    }

    @Transactional
    public VRBAnalysisVO updateVRBAnalysis(Payload<VRBAnalysisVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateVRBAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        VRBAnalysisVO vrbAnalysisVO = requestPayload.getDto();

        vrbAnalysisVO.setChgEmpId(accountVO.getEmpId());
        vrbAnalysisDAO.updateVRBAnalysis(vrbAnalysisVO);

        // 고객분석내역
        if (vrbAnalysisVO.getVrbCustomerAnalysisList() != null) {
            vrbAnalysisDAO.deleteVRBCustomer(vrbAnalysisVO);
            for (VRBCustomerVO vrbCustomerVO : vrbAnalysisVO.getVrbCustomerAnalysisList()) {
                vrbCustomerVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBCustomer(vrbCustomerVO);
            }
        }

        if (vrbAnalysisVO.getVrbProfitAnalysisDetailList() != null) {
            vrbAnalysisDAO.deleteVRBProfit(vrbAnalysisVO);
            for (VRBProfitVO vrbProfitVO : vrbAnalysisVO.getVrbProfitAnalysisDetailList()) {
                vrbProfitVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertOfferProfitIntoVrbAnalysis(vrbProfitVO);
            }
        }

        // 사업분석내역 : 전략적사업가치, 사업수행리스크, 수주&수행전략
        if (vrbAnalysisVO.getVrbBusinessAnalysisList() != null) {
            for (VRBStrategyVO vrbStrategyVO : vrbAnalysisVO.getVrbBusinessAnalysisList()) {
                vrbStrategyVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.updateVRBStrategy(vrbStrategyVO);
            }
        }

        if (vrbAnalysisVO.getVrbCompetitorAnalysisList() != null) {
            vrbAnalysisDAO.deleteVRBCompetitor(vrbAnalysisVO);
            for (VRBCompetitorVO vrbCompetitorVO : vrbAnalysisVO.getVrbCompetitorAnalysisList()) {
                vrbCompetitorVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBCompetitor(vrbCompetitorVO);
            }
        }

        if (vrbAnalysisVO.getVrbParticipantList() != null) {
            vrbAnalysisDAO.deleteVRBOpinion(vrbAnalysisVO);
            for (VRBOpinionVO vrbOpinionVO : vrbAnalysisVO.getVrbParticipantList()) {
                vrbOpinionVO.setVrbAnlyId(vrbAnalysisVO.getVrbAnlyId());
                vrbAnalysisDAO.insertVRBOpinion(vrbOpinionVO);
            }
        }

        vrbAnalysisVO.setApproval(vrbAnalysisVO.getApproval());
        vrbAnalysisVO.getApproval().setSantFrmtCd("B03");
        vrbAnalysisVO.setSantFrmtCd("B03");
        vrbAnalysisVO.getApproval().setDocTitl(vrbAnalysisDAO.selectDraftVRBAnalysisTitle(vrbAnalysisVO));

        if (vrbAnalysisVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(vrbAnalysisVO.getApproval());

        super.updateDraft(vrbAnalysisVO.getApproval());

        return vrbAnalysisVO;
    }
}
