package com.ibiz.api.service;

import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.dao.ProjectVRBDao;
import com.ibiz.api.exception.DeleteDeniedException;
import com.ibiz.api.exception.UpdateDeniedException;
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
public class EstimatePSService extends AbstractDraftService {

    @Resource(name = "estimateDao")
    private EstimateDao estimateDao;

    @Resource(name="projectVRBDao")
    private ProjectVRBDao projectVRBDao;

    @Resource(name = "draftDao")
    private DraftDao draftDao;

    /*
     * 예상손익분석서(P&S)
     */

    @Transactional
    public BsnsProfitLossVO insertEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = estimateDao.selectMaxFcstPalId().getFcstPalId();
        bsnsProfitLossVO.setFcstPalId(IndexUtils.generateId(10, prevId));
        bsnsProfitLossVO.setRegEmpId(accountVO.getEmpId());

        // 결재 등록 (미상신)
        bsnsProfitLossVO.setFcstPalPrgsStatCd("A");
        bsnsProfitLossVO.getApproval().setRegEmpId(accountVO.getEmpId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(estimateDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));
        bsnsProfitLossVO.getApproval().setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.setSantId(super.insertDraft(bsnsProfitLossVO.getApproval()));

        // 문서서식채번
        String prevDocNo = estimateDao.selectMaxDocNo(bsnsProfitLossVO.getApproval()).getDocNo();
        bsnsProfitLossVO.setDocNo(super.generateDocId(3, prevDocNo));

        estimateDao.insertEstimatedProfitAndLoss(bsnsProfitLossVO);

        // LC, SV, OP
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 할인정책
        if (bsnsProfitLossVO.getProdDcPolicyList() != null) {
            for (ProdDcPolicyVO prodDcPolicyVO : bsnsProfitLossVO.getProdDcPolicyList()) {
                prodDcPolicyVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDiscountPolocy(prodDcPolicyVO);
            }
        }
        // 투입인력
        if (bsnsProfitLossVO.getInputPersonList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getInputPersonList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 프로젝트 직접비
        if (bsnsProfitLossVO.getBsnsExpenseList() != null) {
            for (BsnsExpenseVO bsnsExpenseVO : bsnsProfitLossVO.getBsnsExpenseList()) {
                bsnsExpenseVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedExpense(bsnsExpenseVO);
            }
        }
        // 예상손익 실적취합
        if(bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for(BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimateRslSmry(bsnsRslSmryVO);
            }
        }

        return bsnsProfitLossVO;
    }

    @Transactional
    public BsnsProfitLossVO selectEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();

        BsnsProfitLossVO bsnsProfitLoss;
        UserGrpVO userGrpVO = new UserGrpVO();
        List<BsnsRslSmryVO> bsnsRslSmryList =  new ArrayList();

        if (bsnsProfitLossVO.getFcstPalId() == null)
            bsnsProfitLossVO.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLossVO));

        bsnsProfitLoss = estimateDao.selectBusinessInformation(bsnsProfitLossVO);

        if(bsnsProfitLoss !=null) {

            bsnsProfitLossVO.setRegDt(bsnsProfitLoss.getRegDt());
            bsnsProfitLoss.setVrbCriteriaList(estimateDao.selectVrbCriteriaList(bsnsProfitLossVO));
            List<VRBProfitAnalysisDetailVO> profitValueAnalysisDetailList = new ArrayList();

            profitValueAnalysisDetailList = estimateDao.selectVrbList(bsnsProfitLossVO); // BPIP141T
            List<VRBVO> mergeVRBList = new ArrayList();

            if (profitValueAnalysisDetailList.size() > 0) {
                for (int i = 0; i < profitValueAnalysisDetailList.size(); i++) {
                    VRBVO searchVRBVO = new VRBVO();
                    VRBVO vrbVO = new VRBVO();
                    searchVRBVO.setVrbAnlyId(profitValueAnalysisDetailList.get(i).getVrbAnlyId());
                    vrbVO = projectVRBDao.selectVrbInfoByAnlyId(searchVRBVO);
                    List<VRBProfitAnalysisDetailVO> subProfitValueAnalysisDetailList = new ArrayList();
                    subProfitValueAnalysisDetailList.add(profitValueAnalysisDetailList.get(i));

                    vrbVO.setVrbProfitAnalysisDetailList(subProfitValueAnalysisDetailList);
                    mergeVRBList.add(vrbVO);

                }
            }
            bsnsProfitLoss.setVrbProfitAnalysisList(mergeVRBList); // BPIP141T


            List<BsnsProdDetailVO> bsnsProdDetailList = new ArrayList();
            List<ProdDcPolicyVO> bsnsProdDetailPolicyList = new ArrayList();
            bsnsProdDetailList = estimateDao.selectEstimationContentsList(bsnsProfitLossVO);
            bsnsProdDetailPolicyList = estimateDao.selectDiscountPolicyList(bsnsProfitLossVO);
            List<BsnsProdDetailVO> inputPersonList = new ArrayList();

            for (int i = 0; i < bsnsProdDetailList.size(); i++) {
                if (bsnsProdDetailList.get(i).getProdDstCd().equals("LC")) {
                    if (bsnsProdDetailPolicyList.size() > 0) {
                        for (int k = 0; k < bsnsProdDetailPolicyList.size(); k++) {
                            if (bsnsProdDetailList.get(i).getFcstPalId().equals(bsnsProdDetailPolicyList.get(k).getFcstPalId())
                                    && bsnsProdDetailList.get(i).getProdTypeCd().equals(bsnsProdDetailPolicyList.get(k).getProdTypeCd())
                                    && bsnsProdDetailList.get(i).getProdSeq().equals(bsnsProdDetailPolicyList.get(k).getProdSeq())) {
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("U")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdU(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnNmU(bsnsProdDetailPolicyList.get(k).getPrcDcOptnNm());
                                    bsnsProdDetailList.get(i).setDcRtU(bsnsProdDetailPolicyList.get(k).getDcRt());
                                }
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("H")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdH(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnNmH(bsnsProdDetailPolicyList.get(k).getPrcDcOptnNm());
                                    bsnsProdDetailList.get(i).setDcRtH(bsnsProdDetailPolicyList.get(k).getDcRt());
                                }
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("M")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdM(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnNmM(bsnsProdDetailPolicyList.get(k).getPrcDcOptnNm());
                                    bsnsProdDetailList.get(i).setDcRtM(bsnsProdDetailPolicyList.get(k).getDcRt());
                                }
                            }
                        }
                    }
                } else if (bsnsProdDetailList.get(i).getProdDstCd().equals("SV")) {
                    if (bsnsProdDetailList.get(i).getPutHmfrGrdCd() != null) {
                        // 투입인력
                        inputPersonList.add(bsnsProdDetailList.get(i));
                    }
                }

            }


            bsnsProfitLoss.setBsnsProdDetailList(bsnsProdDetailList);


            bsnsProfitLoss.setProdDcPolicyList(estimateDao.selectDiscountPolicyList(bsnsProfitLossVO));
            bsnsProfitLoss.setInputPersonList(inputPersonList);
            bsnsProfitLoss.setBsnsExpenseList(estimateDao.selectProjectDirectExpenseList(bsnsProfitLossVO));
            bsnsProfitLoss.setBsnsRslSmryList(estimateDao.selectEstimateRslSmryList(bsnsProfitLossVO));

            userGrpVO.setTargetUserId(bsnsProfitLoss.getSlsEmpId());
            userGrpVO.setSourceUserId(accountVO.getEmpId());

            bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));


            // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W")) {
                bsnsProfitLoss.setIsInProgress(false);
            } else {
                bsnsProfitLoss.setIsInProgress(true);
            }

            return bsnsProfitLoss;
        }else{
            return bsnsProfitLoss;
        }
    }

    @Transactional
    public ApprovalVO selectDraftButtonList(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDraftButtonList");
        BsnsProfitLossVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = new ApprovalVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
        BsnsProfitLossVO bsnsProfitLossVO = new BsnsProfitLossVO();
        UserGrpVO userGrpVO = new UserGrpVO();
        List<Map<String, String>> buttonList = new ArrayList<>();

        userGrpVO.setTargetUserId(bsnsProfitLoss.getSlsEmpId());
        userGrpVO.setSourceUserId(accountVO.getEmpId());

        bsnsProfitLossVO.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLoss));

        bsnsProfitLoss = estimateDao.selectBusinessInformation(bsnsProfitLossVO);

        if (bsnsProfitLoss.getSantId() != null &&
                (super.isBelongToAuthDept(userGrpVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(bsnsProfitLoss.getSantId());
            approvalDetail.setUserGrpVO(userGrpVO);

            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A") &&  super.isBelongToAuthDept(userGrpVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(userGrpVO) ){
                // 예상손익진행상태가 반려, 폐기가 아닌 경우에만 견적장성버튼 내려줌(요구사항 수정)
                if(!bsnsProfitLoss.getFcstPalPrgsStatCd().equals("R") && !bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W") ){
                    buttonList.add(new HashMap<String, String>() {{put("button", "견적작성"); }});
                }
                if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("C")) {
                    // 예상손익진행상태가 승인인 경우 예상손익변경버튼 내려줌
                    buttonList.add(new HashMap<String, String>() {{put("button", "예상손익변경"); }});
                    buttonList.add(new HashMap<String, String>() {{put("button", "수주보고"); }});
                }
            }

            if ((bsnsProfitLoss.getFcstPalPrgsStatCd().equals("C") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("R"))
                    && userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }


        }

        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public ApprovalVO discardDraft(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".discardDraft");
        ApprovalVO approvalVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        draftDao.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        BsnsProfitLossVO bsnsProfitLossVO = new BsnsProfitLossVO();
        bsnsProfitLossVO.setSantId(approvalVO.getSantId());
        bsnsProfitLossVO.setFcstPalPrgsStatCd("W");
        estimateDao.updateEstimateApprovalState(bsnsProfitLossVO);

        return approvalVO;
    }

    @Transactional
    public BsnsProfitLossVO updateEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        if (Boolean.valueOf(estimateDao.selectIsRelatedWithVrb(bsnsProfitLossVO))) {
            throw new UpdateDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.",bsnsProfitLossVO);
        }

        bsnsProfitLossVO.setChgEmpId(accountVO.getEmpId());

        estimateDao.updateEstimatedProfitAndLoss(bsnsProfitLossVO);


        estimateDao.deleteEstimatedProductDiscountPolocy(bsnsProfitLossVO); // BEST011T
        estimateDao.deleteEstimatedProductDetail(bsnsProfitLossVO); // BEST010T
        estimateDao.deleteEstimatedExpense(bsnsProfitLossVO); // BEST050T
        estimateDao.deleteEstimateRslSmry(bsnsProfitLossVO); // BEST020T


        // LC , SV, OP
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 할인정책
        if (bsnsProfitLossVO.getProdDcPolicyList() != null) {
            for (ProdDcPolicyVO prodDcPolicyVO : bsnsProfitLossVO.getProdDcPolicyList()) {
                prodDcPolicyVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDiscountPolocy(prodDcPolicyVO);
            }
        }
        // 투입인력
        if (bsnsProfitLossVO.getInputPersonList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getInputPersonList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 프로젝트직접비
        if (bsnsProfitLossVO.getBsnsExpenseList() != null) {
            for (BsnsExpenseVO bsnsExpenseVO : bsnsProfitLossVO.getBsnsExpenseList()) {
                bsnsExpenseVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedExpense(bsnsExpenseVO);
            }
        }
        // 실적취합 (BEST020T)
        if (bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for (BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimateRslSmry(bsnsRslSmryVO);
            }
        }

        bsnsProfitLossVO.getApproval().setSantId(bsnsProfitLossVO.getSantId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(estimateDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));
        bsnsProfitLossVO.getApproval().setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());

        if (bsnsProfitLossVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(bsnsProfitLossVO.getApproval());

        super.updateDraft(bsnsProfitLossVO.getApproval());

        return bsnsProfitLossVO;
    }

    @Transactional
    public BsnsProfitLossVO deleteEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        if (bsnsProfitLossVO.getFcstPalId() == null || bsnsProfitLossVO.getFcstPalId().equals("") ) {
            bsnsProfitLossVO.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLossVO));
        }
        if (Boolean.valueOf(estimateDao.selectIsRelatedWithVrb(bsnsProfitLossVO))) {
            throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.",bsnsProfitLossVO);
        }

        ApprovalVO approvalVO = new ApprovalVO();

        estimateDao.deleteEstimatedProductDiscountPolocy(bsnsProfitLossVO); // BEST011T
        estimateDao.deleteEstimatedProductDetail(bsnsProfitLossVO); // BEST010T
        estimateDao.deleteEstimatedExpense(bsnsProfitLossVO); // BEST050T
        estimateDao.deleteEstimateRslSmry(bsnsProfitLossVO); // BEST020T


        // 유지보수대상사업상세, 유지보수제공조건상세, 견족쪽, 계약쪽 추후 추가

        if (bsnsProfitLossVO.getSantId() != null) {
            approvalVO.setSantId(bsnsProfitLossVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        estimateDao.deleteEstimatedProfitAndLoss(bsnsProfitLossVO);

        return bsnsProfitLossVO;
    }

    @Transactional
    public List<PrjtDrcstExpenseVO> selectDirectExpenseStandardList() throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectExpenseStandardList");

        List<PrjtDrcstExpenseVO> data = estimateDao.selectDirectExpenseStandardList();

        return data;
    }

    @Transactional
    public List<BsnsExpenseVO> selectDirectExpenseList(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectExpenseList");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        List<BsnsExpenseVO> data = estimateDao.selectDirectExpenseList(bsnsProfitLossVO);

        return data;
    }

    @Transactional
    public List<VrbCriteriaVO> selectVrbCriteriaList(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVrbCriteriaList");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        List<VrbCriteriaVO> data = estimateDao.selectVrbCriteriaList(bsnsProfitLossVO);

        return data;
    }

    @Transactional
    public List<FcstPalVO> selectQuoteAnalysisList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectQuoteAnalysisList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        fcstPalSearchVO.setSessEmpId(accountVO.getEmpId());

        List<FcstPalVO> list = estimateDao.selectQuoteAnalysisList(fcstPalSearchVO);

        return list;
    }

    @Transactional
    public BsnsProfitLossVO updateDraftPrgsStatCd(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateDraftPrgsStatCd");
        BsnsProfitLossVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        BsnsProfitLossVO result = new BsnsProfitLossVO();

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        BsnsProfitLossVO bsnsProfitLossVO = new BsnsProfitLossVO();
        bsnsProfitLossVO.setSantId(bsnsProfitLoss.getSantId());

        switch (bsnsProfitLoss.getApproval().getSantPrgsStatCd()) {
            case "A":	// 미상신
                bsnsProfitLossVO.setFcstPalPrgsStatCd("A"); // 등록
                break;
            case "B":	// 결재중
                bsnsProfitLossVO.setFcstPalPrgsStatCd("B"); // 결재진행
                break;
            case "C":	// 완결
                bsnsProfitLossVO.setFcstPalPrgsStatCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                bsnsProfitLossVO.setFcstPalPrgsStatCd("R"); // 반려
                break;
            case "W":	// 폐기
                bsnsProfitLossVO.setFcstPalPrgsStatCd("W"); // 폐기
                break;
        }


        // 결재진행상태 업데이트
        estimateDao.updateEstimateApprovalState(bsnsProfitLossVO);

        // 예상손익 결재진행 상태 조회
        result = estimateDao.selectFcstPalPrgsStatCd(bsnsProfitLoss);

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(result.getFcstPalPrgsStatCd().equals("D") || result.getFcstPalPrgsStatCd().equals("W")) {
            result.setIsInProgress(false);
        }else {
            result.setIsInProgress(true);
        }

        return result;
    }

    @Transactional
    public List<BsnsProdDetailVO> selectProdTypeCd(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectProdTypeCd");
        BsnsProfitLossVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<BsnsProdDetailVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLoss));

        result = estimateDao.selectProdTypeCd(bsnsProfitLoss);

        return result;
    }

    @Transactional
    public List<BsnsProdDetailVO> selectProdTypeCdByFcstPalId(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectProdTypeCdByFcstPalId");
        BsnsProfitLossVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<BsnsProdDetailVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLoss));

        result = estimateDao.selectProdTypeCdByFcstPalId(bsnsProfitLoss);

        return result;
    }
}
