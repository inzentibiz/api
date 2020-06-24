package com.ibiz.api.service;

import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.dao.ProfitAnalysisDao;
import com.ibiz.api.dao.VRBAnalysisDAO;
import com.ibiz.api.exception.DeleteDeniedException;
import com.ibiz.api.exception.UpdateDeniedException;
import com.ibiz.api.model.*;
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
public class ProfitAnalysisPnSService  extends AbstractDraftService {

    @Resource(name = "profitAnalysisDao")
    private ProfitAnalysisDao profitAnalysisDao;

    @Resource(name="vrbAnalysisDAO")
    private VRBAnalysisDAO vrbAnalysisDAO;

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


        // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
        BsnsProfitLossVO befBsnsProfitLossVO = new BsnsProfitLossVO();
        if(bsnsProfitLossVO.getBefFcstPalId() != null){
            befBsnsProfitLossVO.setFcstPalId(bsnsProfitLossVO.getBefFcstPalId());
            befBsnsProfitLossVO.setSantId(profitAnalysisDao.selectBusinessInformation(befBsnsProfitLossVO).getSantId());

           if( !profitAnalysisDao.selectFcstPalPrgsStatCdNmCd(befBsnsProfitLossVO).getFcstPalPrgsStatCdNmCd().equals("C")){
               throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.",befBsnsProfitLossVO);
           }
        }

        // 결재 등록 (미상신)
        bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("A");
        bsnsProfitLossVO.getApproval().setRegEmpId(accountVO.getEmpId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(profitAnalysisDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));
        bsnsProfitLossVO.getApproval().setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.setSantId(super.insertDraft(bsnsProfitLossVO.getApproval()));

        bsnsProfitLossVO.setRegEmpId(accountVO.getEmpId());
        String fcstPalId = profitAnalysisDao.selectNewFcstPalId(bsnsProfitLossVO).getFcstPalId();
        // 문서서식채번 포함하여 기본테이블 INSERT
        bsnsProfitLossVO.setFcstPalId(fcstPalId);
        profitAnalysisDao.insertEstimatedProfitAndLoss(bsnsProfitLossVO);

        // LC, SD, SS, TS, OP
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(fcstPalId);
                profitAnalysisDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 할인정책
        if (bsnsProfitLossVO.getProdDcPolicyList() != null) {
            for (ProdDcPolicyVO prodDcPolicyVO : bsnsProfitLossVO.getProdDcPolicyList()) {
                prodDcPolicyVO.setFcstPalId(fcstPalId);
                profitAnalysisDao.insertEstimatedProductDiscountPolicy(prodDcPolicyVO);
            }
        }
        // 프로젝트 직접비
        if (bsnsProfitLossVO.getBsnsExpenseList() != null) {
            for (BsnsExpenseVO bsnsExpenseVO : bsnsProfitLossVO.getBsnsExpenseList()) {
                bsnsExpenseVO.setFcstPalId(fcstPalId);
                profitAnalysisDao.insertEstimatedExpense(bsnsExpenseVO);
            }
        }
        // 예상손익 실적취합
        if(bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for(BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(fcstPalId);
                profitAnalysisDao.insertEstimateRslSmry(bsnsRslSmryVO);
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
        List<BsnsRslSmryVO> bsnsRslSmryList =  new ArrayList();

        if (bsnsProfitLossVO.getFcstPalId() == null)
            bsnsProfitLossVO.setFcstPalId(profitAnalysisDao.selectFcstPalId(bsnsProfitLossVO));

        bsnsProfitLoss = profitAnalysisDao.selectBusinessInformation(bsnsProfitLossVO);

        if(bsnsProfitLoss !=null) {

            bsnsProfitLossVO.setRegDt(bsnsProfitLoss.getRegDt());
            bsnsProfitLoss.setVrbCriteriaList(profitAnalysisDao.selectVrbCriteriaList(bsnsProfitLossVO));
            List<VRBProfitVO> profitValueAnalysisDetailList = new ArrayList();

            profitValueAnalysisDetailList = profitAnalysisDao.selectVrbList(bsnsProfitLossVO); // BPIP100T + BPIP141T
            List<VRBAnalysisVO> mergeVRBList = new ArrayList();

            // VRBVO / VRBProfitVO 별도로 관리하기 때문에 내려줄때도 구분해서 내리기
            if (profitValueAnalysisDetailList.size() > 0) {
                for (int i = 0; i < profitValueAnalysisDetailList.size(); i++) {
                    VRBAnalysisVO vrbAnalysisVO = new VRBAnalysisVO();
                    VRBAnalysisVO resultVrbVO = new VRBAnalysisVO();
                    vrbAnalysisVO.setVrbAnlyId(profitValueAnalysisDetailList.get(i).getVrbAnlyId());
                    resultVrbVO = vrbAnalysisDAO.selectRlvnVRBAnalysis(vrbAnalysisVO);
                    List<VRBProfitVO> subProfitValueAnalysisDetailList = new ArrayList();
                    subProfitValueAnalysisDetailList.add(profitValueAnalysisDetailList.get(i));

                    resultVrbVO.setVrbProfitAnalysisDetailList(subProfitValueAnalysisDetailList);
                    mergeVRBList.add(resultVrbVO);
                }
            }
            bsnsProfitLoss.setVrbProfitAnalysisList(mergeVRBList); // BPIP141T

            List<BsnsProdDetailVO> bsnsProdDetailList = new ArrayList();
            List<ProdDcPolicyVO> resultBsnsProdDetailPolicyList = new ArrayList();
            bsnsProdDetailList = profitAnalysisDao.selectEstimationContentsList(bsnsProfitLossVO);

            for (int i = 0; i < bsnsProdDetailList.size(); i++) {
                // LC or SS 할인정책이 존재하는 상품유형
                if (bsnsProdDetailList.get(i).getProdTypeCd().equals("LD") || bsnsProdDetailList.get(i).getProdTypeCd().equals("SS") ) {
                    List<ProdDcPolicyVO> bsnsProdDetailPolicyList = new ArrayList();
                    bsnsProdDetailPolicyList = profitAnalysisDao.selectDiscountPolicyList(bsnsProdDetailList.get(i));
                    resultBsnsProdDetailPolicyList.addAll(bsnsProdDetailPolicyList);
                }
            }

            bsnsProfitLoss.setBsnsProdDetailList(bsnsProdDetailList); // BEST010T
            bsnsProfitLoss.setProdDcPolicyList(resultBsnsProdDetailPolicyList); // BEST011T
            // svcSearchType 이 상세용인가 수정용인가에 따라 직접경비 쿼리분기
            // default 는 R
            if(bsnsProfitLossVO.getSvcSearchType() == null){
                bsnsProfitLossVO.setSvcSearchType("R");
            }

            if(bsnsProfitLossVO.getSvcSearchType().equals("R")){
                bsnsProfitLoss.setBsnsExpenseList(profitAnalysisDao.selectPrjtDirectExpenseListForDetail(bsnsProfitLossVO));  // BEST050T
            }else if(bsnsProfitLossVO.getSvcSearchType().equals("U")){
                bsnsProfitLoss.setPrjtDrcstExpenseList(profitAnalysisDao.selectPrjtDirectExpenseListForCreateModify(bsnsProfitLossVO)); // BEST050T
            }

            bsnsProfitLoss.setBsnsRslSmryList(profitAnalysisDao.selectEstimateRslSmryList(bsnsProfitLossVO));

            bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));

            // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
            if (bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("W")) {
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

        bsnsProfitLossVO.setFcstPalId(profitAnalysisDao.selectFcstPalId(bsnsProfitLoss));

        bsnsProfitLoss = profitAnalysisDao.selectBusinessInformation(bsnsProfitLossVO);

        if (bsnsProfitLoss.getSantId() != null &&
                (super.isBelongToAuthDept(userGrpVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(bsnsProfitLoss.getSantId());
            approvalDetail.setUserGrpVO(userGrpVO);

            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A") &&  super.isBelongToAuthDept(userGrpVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(userGrpVO)){
                // 예상손익진행상태가 반려, 폐기가 아닌 경우에만 견적작성버튼 내려줌(요구사항 수정)
                if(!bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("R") && !bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("W") ){
                    buttonList.add(new HashMap<String, String>() {{put("button", "견적작성"); }});
                }
                if (bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("C")) {
                    // 예상손익진행상태가 승인인 경우 예상손익변경버튼 내려줌
                    buttonList.add(new HashMap<String, String>() {{put("button", "예상손익변경"); }});
                    buttonList.add(new HashMap<String, String>() {{put("button", "수주보고"); }});
                }
            }

            if ((bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("C") || bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("R"))
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
        bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("W");
        profitAnalysisDao.updateEstimateApprovalState(bsnsProfitLossVO);

        return approvalVO;
    }

    @Transactional
    public BsnsProfitLossVO updateEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        if (profitAnalysisDao.selectIsRelatedWithVrb(bsnsProfitLossVO) > 0) {
            throw new UpdateDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.",bsnsProfitLossVO);
        }

        // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
        BsnsProfitLossVO befBsnsProfitLossVO = new BsnsProfitLossVO();
        if(bsnsProfitLossVO.getBefFcstPalId() != null) {
            befBsnsProfitLossVO.setFcstPalId(bsnsProfitLossVO.getBefFcstPalId());
            befBsnsProfitLossVO.setSantId(profitAnalysisDao.selectBusinessInformation(befBsnsProfitLossVO).getSantId());

            if (!profitAnalysisDao.selectFcstPalPrgsStatCdNmCd(befBsnsProfitLossVO).getFcstPalPrgsStatCdNmCd().equals("C")) {
                throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.",befBsnsProfitLossVO);
            }
        }
        bsnsProfitLossVO.setChgEmpId(accountVO.getEmpId());

        profitAnalysisDao.updateEstimatedProfitAndLoss(bsnsProfitLossVO); // BEST000T
        profitAnalysisDao.deleteEstimatedProductDiscountPolicy(bsnsProfitLossVO); // BEST011T
        profitAnalysisDao.deleteEstimatedProductDetail(bsnsProfitLossVO); // BEST010T
        profitAnalysisDao.deleteEstimatedExpense(bsnsProfitLossVO); // BEST050T
        profitAnalysisDao.deleteEstimateRslSmry(bsnsProfitLossVO); // BEST020T


        // LC , SD, SS. TS, OP
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                profitAnalysisDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 할인정책
        if (bsnsProfitLossVO.getProdDcPolicyList() != null) {
            for (ProdDcPolicyVO prodDcPolicyVO : bsnsProfitLossVO.getProdDcPolicyList()) {
                prodDcPolicyVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                profitAnalysisDao.insertEstimatedProductDiscountPolicy(prodDcPolicyVO);
            }
        }
        // 프로젝트직접비
        if (bsnsProfitLossVO.getBsnsExpenseList() != null) {
            for (BsnsExpenseVO bsnsExpenseVO : bsnsProfitLossVO.getBsnsExpenseList()) {
                bsnsExpenseVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                profitAnalysisDao.insertEstimatedExpense(bsnsExpenseVO);
            }
        }
        // 실적취합 (BEST020T)
        if (bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for (BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                profitAnalysisDao.insertEstimateRslSmry(bsnsRslSmryVO);
            }
        }

        bsnsProfitLossVO.getApproval().setSantId(bsnsProfitLossVO.getSantId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(profitAnalysisDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));
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

        if (bsnsProfitLossVO.getFcstPalId() == null || bsnsProfitLossVO.getFcstPalId().equals("")) {
            bsnsProfitLossVO.setFcstPalId(profitAnalysisDao.selectFcstPalId(bsnsProfitLossVO));
        }
        if (profitAnalysisDao.selectIsRelatedWithVrb(bsnsProfitLossVO) > 0) {
            throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", bsnsProfitLossVO);
        }
        if (profitAnalysisDao.selectIsRelatedWithBefProfitAnalysis(bsnsProfitLossVO) > 0) {
            throw new DeleteDeniedException("손익변경보고로 등록된 예상손익분석서는 삭제할 수 없습니다.", bsnsProfitLossVO);
        }

        ApprovalVO approvalVO = new ApprovalVO();

        profitAnalysisDao.deleteEstimatedProductDiscountPolicy(bsnsProfitLossVO); // BEST011T
        profitAnalysisDao.deleteEstimatedProductDetail(bsnsProfitLossVO); // BEST010T
        profitAnalysisDao.deleteEstimatedExpense(bsnsProfitLossVO); // BEST050T
        profitAnalysisDao.deleteEstimateRslSmry(bsnsProfitLossVO); // BEST020T

        if (bsnsProfitLossVO.getSantId() != null) {
            approvalVO.setSantId(bsnsProfitLossVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        profitAnalysisDao.deleteEstimatedProfitAndLoss(bsnsProfitLossVO);

        return bsnsProfitLossVO;
    }

    @Transactional
    public List<PrjtDrcstExpenseVO> selectPrjtDirectExpenseListForCreateModify(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectPrjtDirectExpenseListForCreateModify");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        List<PrjtDrcstExpenseVO> data = profitAnalysisDao.selectPrjtDirectExpenseListForCreateModify(bsnsProfitLossVO);

        return data;
    }

    @Transactional
    public List<VRBSelectCriteriaVO> selectVrbCriteriaList(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVrbCriteriaList");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        List<VRBSelectCriteriaVO> data = profitAnalysisDao.selectVrbCriteriaList(bsnsProfitLossVO);

        return data;
    }

    @Transactional
    public List<FcstPalVO> selectQuoteAnalysisList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectQuoteAnalysisList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        fcstPalSearchVO.setSessEmpId(accountVO.getEmpId());

        List<FcstPalVO> list = profitAnalysisDao.selectQuoteAnalysisList(fcstPalSearchVO);

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
                bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("A"); // 등록
                break;
            case "B":	// 결재중
                bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("B"); // 결재진행
                break;
            case "C":	// 완결
                bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("R"); // 반려
                break;
            case "W":	// 폐기
                bsnsProfitLossVO.setFcstPalPrgsStatCdNmCd("W"); // 폐기
                break;
        }


        // 결재진행상태 업데이트
        profitAnalysisDao.updateEstimateApprovalState(bsnsProfitLossVO);

        // 예상손익 결재진행 상태 조회
        result = profitAnalysisDao.selectFcstPalPrgsStatCdNmCd(bsnsProfitLoss);

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(result.getFcstPalPrgsStatCdNmCd().equals("D") || result.getFcstPalPrgsStatCdNmCd().equals("W")) {
            result.setIsInProgress(false);
        }else {
            result.setIsInProgress(true);
        }

        return result;
    }

    @Transactional
    public List<BsnsRslSmryVO> selectEstimateRslSmryList(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateRslSmryList");
        BsnsProfitLossVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<BsnsRslSmryVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(profitAnalysisDao.selectFcstPalId(bsnsProfitLoss));

        result = profitAnalysisDao.selectEstimateRslSmryList(bsnsProfitLoss);

        return result;
    }

    @Transactional
    public BsnsProfitLossVO selectBeforeEstimatedPSAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBeforeEstimatedPSAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();

        BsnsProfitLossVO bsnsProfitLoss;
        bsnsProfitLoss = profitAnalysisDao.selectBusinessInformation(bsnsProfitLossVO);

        return bsnsProfitLoss;
    }
}
