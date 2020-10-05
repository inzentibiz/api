package com.ibiz.api.service;

import com.ibiz.api.dao.BizChanceDAO;
import com.ibiz.api.dao.SanctionDAO;
import com.ibiz.api.dao.OfferProfitDAO;
import com.ibiz.api.dao.VRBAnalysisDAO;
import com.ibiz.api.exception.DeleteDeniedException;
import com.ibiz.api.exception.ExceptionCode;
import com.ibiz.api.exception.UpdateDeniedException;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class OfferProfitService extends AbstractDraftService {

    @Resource(name = "bizChanceDAO")
    private BizChanceDAO bizChanceDAO;

    @Resource(name = "offerProfitDAO")
    private OfferProfitDAO offerProfitDAO;

    @Resource(name="vrbAnalysisDAO")
    private VRBAnalysisDAO vrbAnalysisDAO;

    @Resource(name = "sanctionDAO")
    private SanctionDAO sanctionDAO;

    /*
     * 예상손익분석서(P&S) ver 1
     */

    @Transactional
    public OfferVO insertOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{
            String fcstPalId = offerProfitDAO.selectNewFcstPalId(offerVO).getFcstPalId();
            offerVO.setFcstPalId(fcstPalId);
            offerVO.setRegEmpId(accountVO.getEmpId());

            // 결재 등록 (미상신)
            offerVO.setFcstPalPrgsStatCd("A");
            offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));
            offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.setSantId(super.insertApprovalInfo(offerVO.getApproval()));

            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());

            // 문서서식채번 포함하여 기본테이블 INSERT
            offerProfitDAO.insertOfferProfit(offerVO);

            // LC, SV, OP
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            // 할인정책
            if (offerVO.getProdDcPolicyList() != null) {
                for (OfferProductDCVO offerProductDCVO : offerVO.getProdDcPolicyList()) {
                    offerProductDCVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS1ProductDC(offerProductDCVO);
                }
            }
            // 투입인력
            if (offerVO.getInputPersonList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getInputPersonList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            // 프로젝트 직접비
            if (offerVO.getBsnsExpenseList() != null) {
                for (OfferExpenseVO offerExpenseVO : offerVO.getBsnsExpenseList()) {
                    offerExpenseVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitExpense(offerExpenseVO);
                }
            }
            // 예상손익 실적취합
            if(offerVO.getBsnsRslSmryList() != null) {
                for(OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitResult(offerResultVO);
                }
            }

        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 등록 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }
        return offerVO;
    }

    @Transactional
    public OfferVO selectOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalAuthorizerVO approvalDetail = new ApprovalAuthorizerVO();

        OfferVO bsnsProfitLoss;
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<OfferResultVO> bsnsRslSmryList =  new ArrayList();

        if (offerVO.getFcstPalId() == null)
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfit(offerVO);

        if(bsnsProfitLoss !=null) {

            offerVO.setRegDt(bsnsProfitLoss.getRegDt());
            bsnsProfitLoss.setVrbCriteriaList(offerProfitDAO.selectVrbCriteriaList(offerVO));
            List<VRBProfitVO> profitValueAnalysisDetailList = new ArrayList();

            profitValueAnalysisDetailList = offerProfitDAO.selectOfferProfitPS1VrbList(offerVO); // BPIP141T
            List<VRBAnalysisVO> mergeVRBList = new ArrayList();

            if (profitValueAnalysisDetailList.size() > 0) {
                for (int i = 0; i < profitValueAnalysisDetailList.size(); i++) {
                    VRBAnalysisVO searchVRBAnalysisVO = new VRBAnalysisVO();
                    VRBAnalysisVO vrbAnalysisVO = new VRBAnalysisVO();
                    searchVRBAnalysisVO.setVrbAnlyId(profitValueAnalysisDetailList.get(i).getVrbAnlyId());
                    vrbAnalysisVO = vrbAnalysisDAO.selectRlvnVRBAnalysis(searchVRBAnalysisVO);
                    List<VRBProfitVO> subProfitValueAnalysisDetailList = new ArrayList();
                    subProfitValueAnalysisDetailList.add(profitValueAnalysisDetailList.get(i));

                    vrbAnalysisVO.setVrbProfitAnalysisDetailList(subProfitValueAnalysisDetailList);
                    mergeVRBList.add(vrbAnalysisVO);

                }
            }
            bsnsProfitLoss.setVrbProfitAnalysisList(mergeVRBList); // BPIP141T


            List<OfferProductVO> bsnsProdDetailList = new ArrayList();
            List<OfferProductDCVO> bsnsProdDetailPolicyList = new ArrayList();
            bsnsProdDetailList = offerProfitDAO.selectOfferProfitProductList(offerVO);
            bsnsProdDetailPolicyList = offerProfitDAO.selectOfferProfitProductDCList(offerVO);
            List<OfferProductVO> inputPersonList = new ArrayList();

            for (int i = 0; i < bsnsProdDetailList.size(); i++) {
                if (bsnsProdDetailList.get(i).getProdDstCd().equals("LC")) {
                    if (bsnsProdDetailPolicyList.size() > 0) {
                        for (int k = 0; k < bsnsProdDetailPolicyList.size(); k++) {
                            if (bsnsProdDetailList.get(i).getFcstPalId().equals(bsnsProdDetailPolicyList.get(k).getFcstPalId())
                                    && bsnsProdDetailList.get(i).getProdTypeCd().equals(bsnsProdDetailPolicyList.get(k).getProdTypeCd())
                                    && bsnsProdDetailList.get(i).getProdSeq().equals(bsnsProdDetailPolicyList.get(k).getProdSeq())) {
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("U")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdU(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdNmU(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCdNm());
                                    bsnsProdDetailList.get(i).setDcRtU(bsnsProdDetailPolicyList.get(k).getDcRt());
                                }
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("H")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdH(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdNmH(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCdNm());
                                    bsnsProdDetailList.get(i).setDcRtH(bsnsProdDetailPolicyList.get(k).getDcRt());
                                }
                                if (bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd().substring(0, 1).equals("M")) {
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdM(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCd());
                                    bsnsProdDetailList.get(i).setPrcDcOptnCdNmM(bsnsProdDetailPolicyList.get(k).getPrcDcOptnCdNm());
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


            bsnsProfitLoss.setProdDcPolicyList(offerProfitDAO.selectOfferProfitProductDCList(offerVO));
            bsnsProfitLoss.setInputPersonList(inputPersonList);
            bsnsProfitLoss.setBsnsExpenseList(offerProfitDAO.selectPrjojectDirectCostList(offerVO));
            bsnsProfitLoss.setBsnsRslSmryList(offerProfitDAO.selectOfferProfitResultList(offerVO));

            sysUserGroupVO.setTargetUserId(bsnsProfitLoss.getSlsEmpId());
            sysUserGroupVO.setSourceUserId(accountVO.getEmpId());

            bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));

/*

            // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W")) {
                bsnsProfitLoss.setIsInProgress(false);
            } else {
                bsnsProfitLoss.setIsInProgress(true);
            }
*/

            return bsnsProfitLoss;
        }else{
            return bsnsProfitLoss;
        }
    }

    @Transactional
    public ApprovalVO selectOfferProfitDrfBtnList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitDrfBtnList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = new ApprovalVO();
        ApprovalAuthorizerVO approvalDetail = new ApprovalAuthorizerVO();
        OfferVO offerVO = new OfferVO();
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<Map<String, String>> buttonList = new ArrayList<>();

        sysUserGroupVO.setTargetUserId(bsnsProfitLoss.getSlsEmpId());
        sysUserGroupVO.setSourceUserId(accountVO.getEmpId());

        offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(bsnsProfitLoss));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfit(offerVO);

        if (bsnsProfitLoss.getSantId() != null &&
                (super.isBelongToAuthDept(sysUserGroupVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(bsnsProfitLoss.getSantId());
            approvalDetail.setSysUserGroupVO(sysUserGroupVO);
            
            buttonList.add(new HashMap<String, String>() {{put("button", "복제"); }});
            
            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A") &&  super.isBelongToAuthDept(sysUserGroupVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(sysUserGroupVO) ){
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
                    && sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }


        }

        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public OfferVO updateOfferProfitDisposal(Payload<OfferVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitDisposal");
        OfferVO offerVO= requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        CommonCodeMappingVO commonCodeMappingVO = new CommonCodeMappingVO();
        commonCodeMappingVO.setComCd("W");
        commonCodeMappingVO.setMappClmnNm("FCST_PAL_PRGS_STAT_CD");

        ApprovalVO approvalVO = new ApprovalVO();

        // 폐기코드 <> 결재매핑 정보 조회
        approvalVO = super.selectSyncronizedPrgsStatCd(commonCodeMappingVO);

        try{
            // 결재 진행상태 업데이트
            approvalVO.setSantId(offerVO.getSantId());
            approvalVO.setChgEmpId(accountVO.getEmpId());
            super.updatePrgsStatCd(approvalVO);

            // 결재서식(예상손익) 진행상태 업데이트
            offerVO.setFcstPalPrgsStatCd(commonCodeMappingVO.getComCd());
            offerProfitDAO.updateOfferProfitStat(offerVO);

        }catch (Exception e){
            //throw new UpdateDeniedException("진행상태 변경 중 오류가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 진행상태 변경 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_STATE_EXCEPTION_MESSAGE, offerVO);
            }
        }

        /*
        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        sanctionDAO.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(approvalVO.getSantId());
        offerVO.setFcstPalPrgsStatCd("W");
        offerProfitDAO.updateOfferProfitStat(offerVO);

        return approvalVO;
*/

        return offerVO;
    }

    @Transactional
    public OfferVO updateOfferProfitPS1(Payload<OfferVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{
            offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
            offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
            offerProfitDAO.deleteOfferProfitPSExpense(offerVO); // BEST050T
            offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T


            // LC , SV, OP
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            // 할인정책
            if (offerVO.getProdDcPolicyList() != null) {
                for (OfferProductDCVO offerProductDCVO : offerVO.getProdDcPolicyList()) {
                    offerProductDCVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS1ProductDC(offerProductDCVO);
                }
            }
            // 투입인력
            if (offerVO.getInputPersonList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getInputPersonList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            // 프로젝트직접비
            if (offerVO.getBsnsExpenseList() != null) {
                for (OfferExpenseVO offerExpenseVO : offerVO.getBsnsExpenseList()) {
                    offerExpenseVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitExpense(offerExpenseVO);
                }
            }
            // 실적취합 (BEST020T)
            if (offerVO.getBsnsRslSmryList() != null) {
                for (OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitResult(offerResultVO);
                }
            }

            offerVO.getApproval().setSantId(offerVO.getSantId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));
            offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());

            offerVO.setChgEmpId(accountVO.getEmpId());
            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());
            offerProfitDAO.updateOfferProfit(offerVO);

            if (offerVO.getApproval().getApprovalAuthorizerList() != null){
                super.updateApproverList(offerVO.getApproval());
            }

            super.updateApprovalInfo(offerVO.getApproval());

        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 변경 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }

        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitPS1(Payload<OfferVO> requestPayload) throws DeleteDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();

        try{

            if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("") ) {
                offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
            }
            if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
                throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }
            if (offerProfitDAO.selectIsRelatedWithEstimate(offerVO) > 0) {
                throw new DeleteDeniedException("견적서가 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }


            ApprovalVO approvalVO = new ApprovalVO();

            offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
            offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
            offerProfitDAO.deleteOfferProfitPSExpense(offerVO); // BEST050T
            offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T


            // 유지보수대상사업상세, 유지보수제공조건상세, 견족쪽, 계약쪽 추후 추가

            if (offerVO.getSantId() != null) {
                approvalVO.setSantId(offerVO.getSantId());
                super.deleteApprovalInfo(approvalVO);
            }

            offerProfitDAO.deleteOfferProfitPS(offerVO);
        }catch (Exception e){
            if(e.getMessage() != null){
                throw new DeleteDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 삭제 중 오류가 발생했습니다.
                throw new DeleteDeniedException(ExceptionCode.DELETE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }

        return offerVO;
    }

    @Transactional
    public List<DirectCostCriteriaVO> selectDirectCostCriteriaList() throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectCostCriteriaList");

        List<DirectCostCriteriaVO> data = offerProfitDAO.selectDirectCostCriteriaList();

        return data;
    }

    @Transactional
    public List<OfferExpenseVO> selectDirectCostBindList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectCostBindList");
        OfferVO offerVO = requestPayload.getDto();

        List<OfferExpenseVO> data = offerProfitDAO.selectDirectCostBindList(offerVO);

        return data;
    }

    @Transactional
    public List<VRBSelectCriteriaVO> selectVrbCriteriaList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVrbCriteriaList");
        OfferVO offerVO = requestPayload.getDto();

        List<VRBSelectCriteriaVO> data = offerProfitDAO.selectVrbCriteriaList(offerVO);

        return data;
    }

    @Transactional
    public List<OfferVO> selectOfferProfitList(Payload<OfferProfitSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitList");
        OfferProfitSearchVO offerProfitSearchVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        offerProfitSearchVO.setSessEmpId(accountVO.getEmpId());

        List<OfferVO> list = offerProfitDAO.selectOfferProfitList(offerProfitSearchVO);

        return list;
    }

    @Transactional
    public OfferVO updateOfferProfitStat(Payload<OfferVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitStat");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        OfferVO result = new OfferVO();

        try {
            bsnsProfitLoss.setFcstPalPrgsStatCd(bsnsProfitLoss.getSantPrgsStatCd());
            // 결재진행상태 업데이트
            offerProfitDAO.updateOfferProfitStat(bsnsProfitLoss);

            //화면 바인딩을 위해 진행상태코드명 조회
            result = offerProfitDAO.selectFcstPalPrgsStatCd(bsnsProfitLoss);

        }catch (Exception e){
            //throw new UpdateDeniedException("진행상태 변경 중 문제가 발생했습니다.",bsnsProfitLoss);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), bsnsProfitLoss);
            }else{
                //예상손익분석서 진행상태 변경 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_STATE_EXCEPTION_MESSAGE, bsnsProfitLoss);
            }
        }

        return result;
    }

    @Transactional
    public List<OfferProductVO> selectOfferRstProdTypeList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferRstProdTypeList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<OfferProductVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(offerProfitDAO.selectFcstPalId(bsnsProfitLoss));

        result = offerProfitDAO.selectOfferRstProdTypeList(bsnsProfitLoss);

        return result;
    }

    @Transactional
    public List<OfferProductVO> selectOfferRstProdTypeView(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferRstProdTypeView");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<OfferProductVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(offerProfitDAO.selectFcstPalId(bsnsProfitLoss));

        result = offerProfitDAO.selectOfferRstProdTypeView(bsnsProfitLoss);

        return result;
    }


    /*
     * 예상손익분석서(ma) ver 1
     */

    @Transactional
    public OfferVO insertOfferProfitMA1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{

            String fcstPalId = offerProfitDAO.selectNewFcstPalId(offerVO).getFcstPalId();

            offerVO.setFcstPalId(fcstPalId);
            offerVO.setRegEmpId(accountVO.getEmpId());
            offerVO.setFcstPalPrgsStatCd("A");

            offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));
            offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.setSantId(super.insertApprovalInfo(offerVO.getApproval()));

            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());
            // 문서서식채번 포함하여 기본테이블 INSERT
            offerProfitDAO.insertOfferProfit(offerVO);

            // 타사구매내역
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    // 201911상품변경 추가
                    offerProductVO.setProdTypeCd("MA");
                    offerProductVO.setProdDstCd("MA");
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            // 유지보수구매내역
            if(offerVO.getMaBsnsDetailList() != null) {
                for (OfferProductVO maBsnsDetailVO : offerVO.getMaBsnsDetailList()) {
                    maBsnsDetailVO.setProdTypeCd("MA");
                    maBsnsDetailVO.setProdDstCd("MA");
                    maBsnsDetailVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitProduct(maBsnsDetailVO);
                }
            }
            // 서비스제공조건
            if (offerVO.getMaConditionList() != null) {
                for (OfferMACondVO offerMACondVO : offerVO.getMaConditionList()) {
                    offerMACondVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferMACond(offerMACondVO);
                }
            }
            // 계약옵션
            if(offerVO.getContractOptionList() != null) {
                for(OfferContractCondVO offerContractCondVO : offerVO.getContractOptionList()) {
                    offerContractCondVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertContractCond(offerContractCondVO);
                }
            }
            // 예상손익 실적취합
            if(offerVO.getBsnsRslSmryList() != null) {
                for(OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(offerVO.getFcstPalId());
                    offerResultVO.setProdTypeCd("MA");
                    offerProfitDAO.insertOfferProfitResult(offerResultVO);
                }
            }

        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 등록 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }
        return offerVO;
    }

    @Transactional
    public OfferVO selectOfferProfitMA1View(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitMA1View");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        OfferVO bsnsProfitLoss = new OfferVO();
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();

        if (offerVO.getFcstPalId() == null)
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfit(offerVO);
        bsnsProfitLoss.setMaConditionList(offerProfitDAO.selectOfferMACondList(offerVO));
        bsnsProfitLoss.setBsnsProdDetailList(offerProfitDAO.selectOfferProfitProductList(offerVO));
        bsnsProfitLoss.setContractOptionList(offerProfitDAO.selectContractCondList(offerVO));
        bsnsProfitLoss.setBsnsRslSmryList(offerProfitDAO.selectOfferProfitResultList(offerVO));

        bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));
/*
        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(bsnsProfitLoss.getFcstPalPrgsStatCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W")) {
            bsnsProfitLoss.setIsInProgress(false);
        }else {
            bsnsProfitLoss.setIsInProgress(true);
        }*/

        return bsnsProfitLoss;
    }

    @Transactional
    public OfferVO updateOfferProfitMA1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{

            offerProfitDAO.deleteOfferProfitPSProduct(offerVO);
            // 유지보수, 타사구매내역 동일한 VO
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    // 201911상품변경 추가
                    offerProductVO.setProdTypeCd("MA");
                    offerProductVO.setProdDstCd("MA");
                    offerProfitDAO.insertOfferProfitProduct(offerProductVO);
                }
            }
            if (offerVO.getMaBsnsDetailList() != null) {
                for (OfferProductVO maBsnsDetailVO : offerVO.getMaBsnsDetailList()) {
                    maBsnsDetailVO.setFcstPalId(offerVO.getFcstPalId());
                    // 201911상품변경 추가
                    maBsnsDetailVO.setProdTypeCd("MA");
                    maBsnsDetailVO.setProdDstCd("MA");
                    offerProfitDAO.insertOfferProfitProduct(maBsnsDetailVO);
                }
            }

            offerProfitDAO.deleteOfferMACond(offerVO);
            if (offerVO.getMaConditionList() != null) {
                for (OfferMACondVO offerMACondVO : offerVO.getMaConditionList()) {
                    offerMACondVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferMACond(offerMACondVO);
                }
            }

            offerProfitDAO.deleteContractCond(offerVO);
            if(offerVO.getContractOptionList() != null) {
                for(OfferContractCondVO offerContractCondVO : offerVO.getContractOptionList()) {
                    offerContractCondVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertContractCond(offerContractCondVO);
                }
            }

            // 예상손익 실적취합
            offerProfitDAO.deleteOfferProfitPSResult(offerVO);
            if(offerVO.getBsnsRslSmryList() != null) {
                for(OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(offerVO.getFcstPalId());
                    offerResultVO.setProdTypeCd("MA");
                    offerProfitDAO.insertOfferProfitResult(offerResultVO);
                }
            }

            offerVO.getApproval().setSantId(offerVO.getSantId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));

            offerVO.setChgEmpId(accountVO.getEmpId());
            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());
            offerProfitDAO.updateOfferProfit(offerVO);

            if (offerVO.getApproval().getApprovalAuthorizerList() != null)
            {
                super.updateApproverList(offerVO.getApproval());
            }

            super.updateApprovalInfo(offerVO.getApproval());

        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 변경 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }
        
        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitMA1(Payload<OfferVO> requestPayload) throws DeleteDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        ApprovalVO approvalVO = new ApprovalVO();

        try{

            if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("")) {
                offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
            }
            if (offerProfitDAO.selectIsRelatedWithEstimate(offerVO) > 0) {
                throw new DeleteDeniedException("견적서가 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }
            offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
            offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
            offerProfitDAO.deleteOfferMACond(offerVO); // BEST080T
            offerProfitDAO.deleteContractCond(offerVO); // BEST090T
            offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T

            if (offerVO.getSantId() != null) {
                approvalVO.setSantId(offerVO.getSantId());
                super.deleteApprovalInfo(approvalVO);
            }

            offerProfitDAO.deleteOfferProfitPS(offerVO); // BEST000T

        }catch (Exception e){
            if(e.getMessage() != null){
                throw new DeleteDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 삭제 중 오류가 발생했습니다.
                throw new DeleteDeniedException(ExceptionCode.DELETE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }
        
        return offerVO;
    }



    /*
     * 예상손익분석서(P&S) ver 2
     */

    @Transactional
    public OfferVO insertOfferProfitPS2(Payload<OfferVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{
            // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
            OfferVO befOfferVO = new OfferVO();
            if(offerVO.getBefFcstPalId() != null){
                befOfferVO.setFcstPalId(offerVO.getBefFcstPalId());
                befOfferVO.setSantId(offerProfitDAO.selectOfferProfitPS2(befOfferVO).getSantId());

                if( !offerProfitDAO.selectFcstPalPrgsStatCd(befOfferVO).getFcstPalPrgsStatCd().equals("C")){
                    throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.", befOfferVO);
                }
            }

            // 결재 등록 (미상신)
            offerVO.setFcstPalPrgsStatCd("A");
            offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));
            offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.setSantId(super.insertApprovalInfo(offerVO.getApproval()));

            offerVO.setRegEmpId(accountVO.getEmpId());
            String fcstPalId = offerProfitDAO.selectNewFcstPalId(offerVO).getFcstPalId();
            // 문서서식채번 포함하여 기본테이블 INSERT
            offerVO.setFcstPalId(fcstPalId);
            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());
            offerProfitDAO.insertOfferProfitPS2(offerVO);

            // LC, SD, SS, TS, OP
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(fcstPalId);
                    offerProfitDAO.insertOfferProfitPS2Product(offerProductVO);
                }
            }
            // 할인정책
            if (offerVO.getProdDcPolicyList() != null) {
                for (OfferProductDCVO offerProductDCVO : offerVO.getProdDcPolicyList()) {
                    offerProductDCVO.setFcstPalId(fcstPalId);
                    offerProfitDAO.insertOfferProfitPS2ProductDC(offerProductDCVO);
                }
            }
            // 프로젝트 직접비
            if (offerVO.getBsnsExpenseList() != null) {
                for (OfferExpenseVO offerExpenseVO : offerVO.getBsnsExpenseList()) {
                    offerExpenseVO.setFcstPalId(fcstPalId);
                    offerProfitDAO.insertOfferProfitPS2Expense(offerExpenseVO);
                }
            }
            // 예상손익 실적취합
            if(offerVO.getBsnsRslSmryList() != null) {
                for(OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(fcstPalId);
                    offerProfitDAO.insertOfferProfitPS2Result(offerResultVO);
                }
            }
        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 등록 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }

        return offerVO;
    }

    @Transactional
    public OfferVO selectOfferProfitPS2(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalAuthorizerVO approvalDetail = new ApprovalAuthorizerVO();

        OfferVO bsnsProfitLoss;
        List<OfferResultVO> bsnsRslSmryList =  new ArrayList();

        if (offerVO.getFcstPalId() == null)
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfitPS2(offerVO);

        if(bsnsProfitLoss !=null) {

            offerVO.setRegDt(bsnsProfitLoss.getRegDt());
            bsnsProfitLoss.setVrbCriteriaList(offerProfitDAO.selectOfferProfitPS2VRBSelectCriteriaList(offerVO));
            List<VRBProfitVO> profitValueAnalysisDetailList = new ArrayList();

            profitValueAnalysisDetailList = offerProfitDAO.selectOfferProfitPS2VrbList(offerVO); // BPIP100T + BPIP141T
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

            List<OfferProductVO> bsnsProdDetailList = new ArrayList();
            List<OfferProductDCVO> resultBsnsProdDetailPolicyList = new ArrayList();
            bsnsProdDetailList = offerProfitDAO.selectOfferProfitPS2ProductList(offerVO);

            for (int i = 0; i < bsnsProdDetailList.size(); i++) {
                // LC or SS 할인정책이 존재하는 상품유형
                if (bsnsProdDetailList.get(i).getProdTypeCd().equals("LD") || bsnsProdDetailList.get(i).getProdTypeCd().equals("SS") ) {
                    List<OfferProductDCVO> bsnsProdDetailPolicyList = new ArrayList();
                    bsnsProdDetailPolicyList = offerProfitDAO.selectOfferProfitPS2ProductDCList(bsnsProdDetailList.get(i));
                    resultBsnsProdDetailPolicyList.addAll(bsnsProdDetailPolicyList);
                }
            }

            bsnsProfitLoss.setBsnsProdDetailList(bsnsProdDetailList); // BEST010T
            bsnsProfitLoss.setProdDcPolicyList(resultBsnsProdDetailPolicyList); // BEST011T
            // svcSearchType 이 상세용인가 수정용인가에 따라 직접경비 쿼리분기
            // default 는 R
            if(offerVO.getSvcSearchType() == null){
                offerVO.setSvcSearchType("R");
            }

            if(offerVO.getSvcSearchType().equals("R")){
                bsnsProfitLoss.setBsnsExpenseList(offerProfitDAO.selectOfferExpenseList(offerVO));  // BEST050T
            }else if(offerVO.getSvcSearchType().equals("U")){
                bsnsProfitLoss.setPrjtDrcstExpenseList(offerProfitDAO.selectDirectCostList(offerVO)); // BEST050T
            }

            bsnsProfitLoss.setBsnsRslSmryList(offerProfitDAO.selectOfferProfitPS2ResultList(offerVO));

            bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));
/*

            // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W")) {
                bsnsProfitLoss.setIsInProgress(false);
            } else {
                bsnsProfitLoss.setIsInProgress(true);
            }
*/

            return bsnsProfitLoss;
        }else{
            return bsnsProfitLoss;
        }
    }

    @Transactional
    public ApprovalVO selectOfferProfitPS2DrfBtnList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS2DrfBtnList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = new ApprovalVO();
        ApprovalAuthorizerVO approvalDetail = new ApprovalAuthorizerVO();
        OfferVO offerVO = new OfferVO();
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<Map<String, String>> buttonList = new ArrayList<>();

        sysUserGroupVO.setTargetUserId(bsnsProfitLoss.getSlsEmpId());
        sysUserGroupVO.setSourceUserId(accountVO.getEmpId());

        offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(bsnsProfitLoss));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfitPS2(offerVO);

        if (bsnsProfitLoss.getSantId() != null &&
                (super.isBelongToAuthDept(sysUserGroupVO)) || accountVO.getRoleList().contains("AD")) {
            approvalDetail.setSantId(bsnsProfitLoss.getSantId());
            approvalDetail.setSysUserGroupVO(sysUserGroupVO);
            buttonList.add(new HashMap<String, String>() {{put("button", "복제"); }});

            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A") &&  super.isBelongToAuthDept(sysUserGroupVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(sysUserGroupVO)){
                // 예상손익진행상태가 반려, 폐기가 아닌 경우에만 견적작성버튼 내려줌(요구사항 수정)
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
                    && sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }


        }

        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }
/*
    @Transactional
    public ApprovalVO updateOfferProfitPS2Dss(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS2Dss");
        ApprovalVO approvalVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        sanctionDAO.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(approvalVO.getSantId());
        offerVO.setFcstPalPrgsStatCd("W");
        offerProfitDAO.updateOfferProfitStat(offerVO);

        return approvalVO;
    }
*/

    @Transactional
    public OfferVO updateOfferProfitPS2(Payload<OfferVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{

        /*if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
            throw new UpdateDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
        }*/
            // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
            OfferVO befOfferVO = new OfferVO();
            if(offerVO.getBefFcstPalId() != null) {
                befOfferVO.setFcstPalId(offerVO.getBefFcstPalId());
                befOfferVO.setSantId(offerProfitDAO.selectOfferProfitPS2(befOfferVO).getSantId());

                if (!offerProfitDAO.selectFcstPalPrgsStatCd(befOfferVO).getFcstPalPrgsStatCd().equals("C")) {
                    throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.", befOfferVO);
                }
            }

            offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
            offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
            offerProfitDAO.deleteOfferProfitPSExpense(offerVO); // BEST050T
            offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T


            // LC , SD, SS. TS, OP
            if (offerVO.getBsnsProdDetailList() != null) {
                for (OfferProductVO offerProductVO : offerVO.getBsnsProdDetailList()) {
                    offerProductVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS2Product(offerProductVO);
                }
            }
            // 할인정책
            if (offerVO.getProdDcPolicyList() != null) {
                for (OfferProductDCVO offerProductDCVO : offerVO.getProdDcPolicyList()) {
                    offerProductDCVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS2ProductDC(offerProductDCVO);
                }
            }
            // 프로젝트직접비
            if (offerVO.getBsnsExpenseList() != null) {
                for (OfferExpenseVO offerExpenseVO : offerVO.getBsnsExpenseList()) {
                    offerExpenseVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS2Expense(offerExpenseVO);
                }
            }
            // 실적취합 (BEST020T)
            if (offerVO.getBsnsRslSmryList() != null) {
                for (OfferResultVO offerResultVO : offerVO.getBsnsRslSmryList()) {
                    offerResultVO.setFcstPalId(offerVO.getFcstPalId());
                    offerProfitDAO.insertOfferProfitPS2Result(offerResultVO);
                }
            }

            offerVO.getApproval().setSantId(offerVO.getSantId());
            offerVO.setSantFrmtCd(offerVO.getFrmtCd());
            offerVO.getApproval().setDocTitl(offerProfitDAO.selectApprovalTitle(offerVO));
            offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());

            offerVO.setChgEmpId(accountVO.getEmpId());
            offerVO.setDocTitl(offerVO.getApproval().getDocTitl());
            offerProfitDAO.updateOfferProfitPS2(offerVO); // BEST000T

            if (offerVO.getApproval().getApprovalAuthorizerList() != null){
                super.updateApproverList(offerVO.getApproval());
            }

            super.updateApprovalInfo(offerVO.getApproval());

        }catch (Exception e){
            //throw new UpdateDeniedException("예상손익분석서 변경 중 문제가 발생했습니다.", offerVO);

            if(e.getMessage() != null){
                throw new UpdateDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 저장 중 오류가 발생했습니다.
                throw new UpdateDeniedException(ExceptionCode.UPDATE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }

        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitPS2(Payload<OfferVO> requestPayload) throws DeleteDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();

        try{

            if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("")) {
                offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
            }
            if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
                throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }
            if (offerProfitDAO.selectIsRelatedWithEstimate(offerVO) > 0) {
                throw new DeleteDeniedException("견적서가 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }
            if (offerProfitDAO.selectIsRelatedWithBefProfitAnalysis(offerVO) > 0) {
                throw new DeleteDeniedException("손익변경보고로 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
            }

            ApprovalVO approvalVO = new ApprovalVO();

            offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
            offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
            offerProfitDAO.deleteOfferProfitPSExpense(offerVO); // BEST050T
            offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T

            if (offerVO.getSantId() != null) {
                approvalVO.setSantId(offerVO.getSantId());
                super.deleteApprovalInfo(approvalVO);
            }

            offerProfitDAO.deleteOfferProfitPS(offerVO);

        }catch (Exception e){
            if(e.getMessage() != null){
                throw new DeleteDeniedException(e.getMessage(), offerVO);
            }else{
                //예상손익분석서 삭제 중 오류가 발생했습니다.
                throw new DeleteDeniedException(ExceptionCode.DELETE_PROFIT_DATA_EXCEPTION_MESSAGE, offerVO);
            }
        }
        return offerVO;
    }

    @Transactional
    public List<DirectCostCriteriaVO> selectDirectCostList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectCostList");
        OfferVO offerVO = requestPayload.getDto();

        List<DirectCostCriteriaVO> data = offerProfitDAO.selectDirectCostList(offerVO);

        return data;
    }
/*

    @Transactional
    public OfferVO updateOfferProfitPS2Stat(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS2Stat");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        OfferVO result = new OfferVO();

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(bsnsProfitLoss.getSantId());

        switch (bsnsProfitLoss.getApproval().getSantPrgsStatCd()) {
            case "A":	// 미상신
                offerVO.setFcstPalPrgsStatCd("A"); // 등록
                break;
            case "B":	// 결재중
                offerVO.setFcstPalPrgsStatCd("B"); // 결재진행
                break;
            case "C":	// 완결
                offerVO.setFcstPalPrgsStatCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                offerVO.setFcstPalPrgsStatCd("R"); // 반려
                break;
            case "W":	// 폐기
                offerVO.setFcstPalPrgsStatCd("W"); // 폐기
                break;
        }


        // 결재진행상태 업데이트
        offerProfitDAO.updateOfferProfitStat(offerVO);

        // 예상손익 결재진행 상태 조회
        result = offerProfitDAO.selectFcstPalPrgsStatCd(bsnsProfitLoss);

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(result.getFcstPalPrgsStatCd().equals("D") || result.getFcstPalPrgsStatCd().equals("W")) {
            result.setIsInProgress(false);
        }else {
            result.setIsInProgress(true);
        }

        return result;
    }
*/

    @Transactional
    public List<OfferResultVO> selectEstimateRslSmryList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateRslSmryList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        List<OfferResultVO> result =  new ArrayList();

        if (bsnsProfitLoss.getSantId() != null)
            bsnsProfitLoss.setFcstPalId(offerProfitDAO.selectFcstPalId(bsnsProfitLoss));

        result = offerProfitDAO.selectOfferProfitPS2ResultList(bsnsProfitLoss);

        return result;
    }

    @Transactional
    public OfferVO selectBeforeEstimatedPSAnalysis(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBeforeEstimatedPSAnalysis");
        OfferVO offerVO = requestPayload.getDto();

        OfferVO bsnsProfitLoss;
        bsnsProfitLoss = offerProfitDAO.selectOfferProfitPS2(offerVO);

        return bsnsProfitLoss;
    }


    // excel



    @Transactional
    public List<ExcelOfferProfitVO> seleceExcelDwnlOfferProfitList(Payload<OfferProfitSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitList");
        OfferProfitSearchVO offerProfitSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitList(offerProfitSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelOfferProfitByProdTypeVO> seleceExcelDwnlOfferProfitByProdTypeList(Payload<OfferProfitSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProdTypeList");
        OfferProfitSearchVO offerProfitSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitByProdTypeVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitByProdTypeList(offerProfitSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelOfferProfitByProductVO> seleceExcelDwnlOfferProfitByProductList(Payload<OfferProfitSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProductList");
        OfferProfitSearchVO offerProfitSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitByProductVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitByProductList(offerProfitSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }
}
