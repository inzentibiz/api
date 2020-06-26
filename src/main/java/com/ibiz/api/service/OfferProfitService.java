package com.ibiz.api.service;

import com.ibiz.api.dao.BizChanceDAO;
import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.dao.OfferProfitDAO;
import com.ibiz.api.dao.VRBAnalysisDAO;
import com.ibiz.api.exception.DeleteDeniedException;
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

    @Resource(name = "draftDao")
    private DraftDao draftDao;

    /*
     * 예상손익분석서(P&S) ver 1
     */

    @Transactional
    public OfferVO insertOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = offerProfitDAO.selectMaxFcstPalId().getFcstPalId();
        offerVO.setFcstPalId(IndexUtils.generateId(10, prevId));
        offerVO.setRegEmpId(accountVO.getEmpId());

        // 결재 등록 (미상신)
        offerVO.setFcstPalPrgsStatCdNmCd("A");
        offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
        offerVO.setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitTitle(offerVO));
        offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.setSantId(super.insertDraft(offerVO.getApproval()));
/* 구소스

        // 문서서식채번
        String prevDocNo = offerProfitDAO.selectMaxDocNo(offerVO.getApproval()).getDocNo();
        offerVO.setDocNo(super.generateDocId(3, prevDocNo));

        offerProfitDAO.insertOfferProfit(offerVO);
*/

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

        return offerVO;
    }

    @Transactional
    public OfferVO selectOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();

        OfferVO bsnsProfitLoss;
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<OfferResultVO> bsnsRslSmryList =  new ArrayList();

        if (offerVO.getFcstPalId() == null)
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));

        bsnsProfitLoss = offerProfitDAO.selectOfferProfit(offerVO);

        if(bsnsProfitLoss !=null) {

            offerVO.setRegDt(bsnsProfitLoss.getRegDt());
            bsnsProfitLoss.setVrbCriteriaList(offerProfitDAO.selectVRBSelectCriteriaList(offerVO));
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
    public ApprovalVO selectOfferProfitDrfBtnList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitDrfBtnList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = new ApprovalVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
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

            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A") &&  super.isBelongToAuthDept(sysUserGroupVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(sysUserGroupVO) ){
                // 예상손익진행상태가 반려, 폐기가 아닌 경우에만 견적장성버튼 내려줌(요구사항 수정)
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
                    && sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }


        }

        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public ApprovalVO updateOfferProfitDss(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitDss");
        ApprovalVO approvalVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        draftDao.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(approvalVO.getSantId());
        offerVO.setFcstPalPrgsStatCdNmCd("W");
        offerProfitDAO.updateOfferProfitStat(offerVO);

        return approvalVO;
    }

    @Transactional
    public OfferVO updateOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0 ) {
            throw new UpdateDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
        }

        offerVO.setChgEmpId(accountVO.getEmpId());

        offerProfitDAO.updateOfferProfit(offerVO);


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
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitTitle(offerVO));
        offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());

        if (offerVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(offerVO.getApproval());

        super.updateDraft(offerVO.getApproval());

        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitPS1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitPS1");
        OfferVO offerVO = requestPayload.getDto();

        if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("") ) {
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
        }
        if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
            throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
        }

        ApprovalVO approvalVO = new ApprovalVO();

        offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
        offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
        offerProfitDAO.deleteOfferProfitPSExpense(offerVO); // BEST050T
        offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T


        // 유지보수대상사업상세, 유지보수제공조건상세, 견족쪽, 계약쪽 추후 추가

        if (offerVO.getSantId() != null) {
            approvalVO.setSantId(offerVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        offerProfitDAO.deleteOfferProfitPS(offerVO);

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
    public List<VRBSelectCriteriaVO> selectVRBSelectCriteriaList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectVRBSelectCriteriaList");
        OfferVO offerVO = requestPayload.getDto();

        List<VRBSelectCriteriaVO> data = offerProfitDAO.selectVRBSelectCriteriaList(offerVO);

        return data;
    }

    @Transactional
    public List<FcstPalVO> selectOfferProfitList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        fcstPalSearchVO.setSessEmpId(accountVO.getEmpId());

        List<FcstPalVO> list = offerProfitDAO.selectOfferProfitList(fcstPalSearchVO);

        return list;
    }

    @Transactional
    public OfferVO updateOfferProfitStat(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitStat");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        OfferVO result = new OfferVO();

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(bsnsProfitLoss.getSantId());

        switch (bsnsProfitLoss.getApproval().getSantPrgsStatCd()) {
            case "A":	// 미상신
                offerVO.setFcstPalPrgsStatCdNmCd("A"); // 등록
                break;
            case "B":	// 결재중
                offerVO.setFcstPalPrgsStatCdNmCd("B"); // 결재진행
                break;
            case "C":	// 완결
                offerVO.setFcstPalPrgsStatCdNmCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                offerVO.setFcstPalPrgsStatCdNmCd("R"); // 반려
                break;
            case "W":	// 폐기
                offerVO.setFcstPalPrgsStatCdNmCd("W"); // 폐기
                break;
        }


        // 결재진행상태 업데이트
        offerProfitDAO.updateOfferProfitStat(offerVO);

        // 예상손익 결재진행 상태 조회
        result = offerProfitDAO.selectFcstPalPrgsStatCd(bsnsProfitLoss);

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(result.getFcstPalPrgsStatCdNmCd().equals("D") || result.getFcstPalPrgsStatCdNmCd().equals("W")) {
            result.setIsInProgress(false);
        }else {
            result.setIsInProgress(true);
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


    @Transactional
    public List<BizChanceVO> selectBizChanceList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> BizOpportList = bizChanceDAO.selectBizChanceList(bizChanceSearchVO);

        return BizOpportList;
    }

    @Transactional
    public List<BizChanceVO> selectBizChanceView(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceView");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        BizChanceAmountVO bizChanceAmountVO = new BizChanceAmountVO();
        BizChancePersonVO bizChancePersonVO = new BizChancePersonVO();

        List<BizChanceVO> bizOpportList = bizChanceDAO.selectBizChanceView(bizChanceSearchVO);

        for(int i=0; i<bizOpportList.size(); i++) {
            bizChanceAmountVO.setBoptId(bizOpportList.get(i).getBoptId());
            bizChancePersonVO.setBoptId(bizOpportList.get(i).getBoptId());

            List<BizChanceAmountVO> amtList = bizChanceDAO.selectBizChanceAmtList(bizChanceAmountVO);
            List<BizChancePersonVO> nopList = bizChanceDAO.selectBizChanceNopList(bizChancePersonVO);

            bizOpportList.get(i).setBizOpportunityAmtList(amtList);
            bizOpportList.get(i).setBizOpportunityNopList(nopList);

            bizOpportList.get(i).setSumPutNopCount(0);
            for(int j=0; j<nopList.size(); j++) {
                bizOpportList.get(i).setSumPutNopCount(bizOpportList.get(i).getSumPutNopCount() + nopList.get(j).getPutNopCount());
            }
            bizOpportList.get(i).setSumSellAmt(0);
            bizOpportList.get(i).setSumBuyAmt(0);
            for(int j=0; j<amtList.size(); j++) {

                bizOpportList.get(i).setSumSellAmt(bizOpportList.get(i).getSumSellAmt() + (amtList.get(j).getSellAmt()== null? 0: amtList.get(j).getSellAmt()));
                bizOpportList.get(i).setSumBuyAmt(bizOpportList.get(i).getSumBuyAmt() + (amtList.get(j).getBuyAmt()== null? 0: amtList.get(j).getBuyAmt()) );
            }
        }

        bizOpportList.get(0).setChgDtView(bizOpportList.get(0).getChgDt());

        return bizOpportList;
    }


    @Transactional
    public BizChanceVO selectBizChance(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChance");
        BizChanceVO bizChanceVO = requestPayload.getDto();

        BizChanceAmountVO bizChanceAmountVO = new BizChanceAmountVO();
        BizChancePersonVO bizChancePersonVO = new BizChancePersonVO();

        bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
        bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());

        BizChanceVO bizOpportunity = bizChanceDAO.selectBizChance(bizChanceVO);
        List<BizChanceAmountVO> amtList = bizChanceDAO.selectBizChanceAmtList(bizChanceAmountVO);
        List<BizChancePersonVO> nopList = bizChanceDAO.selectBizChanceNopList(bizChancePersonVO);

        bizOpportunity.setBizOpportunityAmtList(amtList);
        bizOpportunity.setBizOpportunityNopList(nopList);
        bizOpportunity.setChgDtView(bizOpportunity.getChgDt());

        bizOpportunity.setSalesActivityList(bizChanceDAO.selectBizChanceActivityList(bizChanceVO));

        return bizOpportunity;
    }

    @Transactional
    public List<BizChanceHistoryVO> selectBizChanceHistoryList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceHistoryList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceHistoryVO> data = null;
        // historyGrpCd 분기
        if(bizChanceSearchVO.getHistoryGroupCd().equals("WCT")){
            data = bizChanceDAO.selectBizChanceHistoryWctList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("SELL")){
            data = bizChanceDAO.selectBizChanceHistorySellList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("BUY")){
            data = bizChanceDAO.selectBizChanceHistoryBuyList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("PN")){
            data = bizChanceDAO.selectBizChanceHistoryPncList(bizChanceSearchVO);
        }

        return data;
    }

    @Transactional
    public List<BizChanceVO> selectBizChancePopupList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChancePopupList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> BizOpportList = bizChanceDAO.selectBizChancePopupList(bizChanceSearchVO);

        return BizOpportList;
    }

    // INSERT

    @Transactional
    public BizChanceVO insertBizChance(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertBizChance");

        BizChanceVO bizChanceVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = bizChanceDAO.selectMaxBoptId().getBoptId();

        bizChanceVO.setBoptId(IndexUtils.generateId(10, prevId));
        bizChanceVO.setRegEmpId(accountVO.getEmpId());
        bizChanceVO.setChgEmpId(accountVO.getEmpId());

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);

        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizChanceVO.setChgDt(chgDt);
        bizChanceDAO.insertBizChance(bizChanceVO);
        bizChanceDAO.insertBizChanceHistory(bizChanceVO);

        if(bizChanceVO.getBizOpportunityAmtList() != null) {
            int amtSeq = 1;
            for(BizChanceAmountVO bizChanceAmountVO : bizChanceVO.getBizOpportunityAmtList()) {
                bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
                bizChanceAmountVO.setChgDt(chgDt);
                bizChanceAmountVO.setSeq(amtSeq);
                bizChanceAmountVO.setSellAmt( (bizChanceAmountVO.getSellAmt() == null? 0: bizChanceAmountVO.getSellAmt() * 1000) );
                bizChanceAmountVO.setBuyAmt( (bizChanceAmountVO.getBuyAmt() == null? 0: bizChanceAmountVO.getBuyAmt() * 1000) );
                bizChanceDAO.insertBizChanceAmt(bizChanceAmountVO);
                bizChanceDAO.insertBizChanceHistoryAmt(bizChanceAmountVO);
                amtSeq++;
            }
        }
        if(bizChanceVO.getBizOpportunityNopList() != null) {
            for(BizChancePersonVO bizChancePersonVO : bizChanceVO.getBizOpportunityNopList()) {
                bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());
                bizChancePersonVO.setPutTimeUnitCd("A");
                bizChancePersonVO.setChgDt(chgDt);

                bizChanceDAO.insertBizChanceNop(bizChancePersonVO);
                bizChanceDAO.insertBizChanceHistoryNop(bizChancePersonVO);
            }
        }

        return bizChanceVO;
    }

    // UPDATE

    @Transactional
    public BizChanceVO updateBizChance(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChance");
        BizChanceVO bizChanceVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        bizChanceVO.setChgEmpId(accountVO.getEmpId());

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);
        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizChanceVO.setChgDt(chgDt);
        bizChanceDAO.updateBizChance(bizChanceVO);
        // 변경이력(히스토리) 테이블에 적재..
        // 동일한 날짜로 이력된게 있으면 지우고 적재..
        if( bizChanceDAO.selectBizChanceHistoryCount(bizChanceVO) > 0) {
            bizChanceDAO.deleteBizChanceHistoryAmt(bizChanceVO);
            bizChanceDAO.deleteBizChanceHistoryNop(bizChanceVO);
            bizChanceDAO.deleteBizChanceHistory(bizChanceVO);
        }
        bizChanceDAO.insertBizChanceHistory(bizChanceVO);

        if(bizChanceVO.getBizOpportunityAmtList() != null) {
            bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO);

            int amtSeq = 1;
            for(BizChanceAmountVO bizChanceAmountVO : bizChanceVO.getBizOpportunityAmtList()) {
                bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
                bizChanceAmountVO.setChgDt(chgDt);
                bizChanceAmountVO.setSeq(amtSeq);

                bizChanceAmountVO.setSellAmt( (bizChanceAmountVO.getSellAmt() == null? 0: bizChanceAmountVO.getSellAmt() * 1000) );
                bizChanceAmountVO.setBuyAmt( (bizChanceAmountVO.getBuyAmt() == null? 0: bizChanceAmountVO.getBuyAmt() * 1000) );
                bizChanceDAO.insertBizChanceAmt(bizChanceAmountVO);
                bizChanceDAO.insertBizChanceHistoryAmt(bizChanceAmountVO);
                amtSeq++;
            }
        }

        if(bizChanceVO.getBizOpportunityNopList() != null) {
            bizChanceDAO.deleteBizChanceNopAll(bizChanceVO);

            for(BizChancePersonVO bizChancePersonVO : bizChanceVO.getBizOpportunityNopList()) {
                bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());
                bizChancePersonVO.setPutTimeUnitCd("A");
                bizChancePersonVO.setChgDt(chgDt);

                bizChanceDAO.insertBizChanceNop(bizChancePersonVO);
                bizChanceDAO.insertBizChanceHistoryNop(bizChancePersonVO);

            }
        }

        return bizChanceVO;
    }

    // DELETE

    @Transactional
    public Boolean deleteBizChance(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteBizChance");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();
        BizChanceVO bizChanceVO2 = new BizChanceVO();
        Boolean YN = true;

        //현재 날짜 구하기
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd", Locale.KOREA );
        Date currentTime = new Date ();
        String today = mSimpleDateFormat.format (currentTime);

        //ChgDt
        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);
        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizChanceVO.setChgDt(chgDt);

        // 예상손익분석/견적서가 존재하는지 여부를 확인 후 삭제시도.. 존재할 경우 "예상손익분석/견적서가 존재하여 삭제 불가능합니다."
        FcstPalVO fcstPalVO = new FcstPalVO();
        fcstPalVO.setBoptId(bizChanceVO.getBoptId());

        if( !(offerProfitDAO.selectisExistsOffer(fcstPalVO) > 0)) {	//예상손익&견적서 있는 지 비교
            if(!bizChanceVO.getRegDt().equals(today)) {

                bizChanceVO = bizChanceDAO.selectBizChaneInfo(bizChanceVO);

                bizChanceVO.setBoptStatCd("D1");
                bizChanceVO.setChgDt(chgDt);

                bizChanceDAO.updateBizChanceStatus(bizChanceVO);//상태 변경

                //삭제 변경하면서 매출 매입, 투입인원 삭제 + 영업활동내역도 삭제
                bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO); //월별 매출매입삭제
                bizChanceDAO.deleteBizChanceNopAll(bizChanceVO); //투입인원 삭제
                bizChanceDAO.deleteBizChanceActivityAll(bizChanceVO); //영업활동내역 삭제


                //이력 등록 당일 이력 중복이 체크하고 등록
                if( bizChanceDAO.selectBizChanceHistoryCount(bizChanceVO) > 0) {
                    bizChanceDAO.deleteBizChanceHistoryAmt(bizChanceVO);
                    bizChanceDAO.deleteBizChanceHistoryNop(bizChanceVO);
                    bizChanceDAO.deleteBizChanceHistory(bizChanceVO);
                }

                bizChanceDAO.insertBizChanceHistory(bizChanceVO);


            }else {
                bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO); //월별 매출매입삭제
                bizChanceDAO.deleteBizChanceNopAll(bizChanceVO); //투입인원 삭제
                bizChanceDAO.deleteBizChanceHistoryAmtAll(bizChanceVO); //월별 매출매입 이력삭제
                bizChanceDAO.deleteBizChanceHistoryNopAll(bizChanceVO);	//투입인원 이력삭제
                bizChanceDAO.deleteBizChanceHistoryAll(bizChanceVO); //사업기회 이력삭제
                bizChanceDAO.deleteBizChanceActivityAll(bizChanceVO); //영업활동내역 삭제
                bizChanceDAO.deleteBizChance(bizChanceVO); //사업기회 삭제
            }

            YN = true;
        }else {
            YN = false;
        }

        return YN;
    }

    @Transactional
    public List<BizChanceVO> selectBizChanceRelList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceRelList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> BizOpportList = bizChanceDAO.selectBizChanceRelList(bizChanceSearchVO);

        return BizOpportList;
    }

    @Transactional
    public List<BizChanceVO> selectRlvnOfferProfitList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectRlvnOfferProfitList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> BizOpportList = null;

        String prjtTypeCd = bizChanceDAO.selectPrjtTypeCd(bizChanceSearchVO.getBoptId());
        bizChanceSearchVO.setPrjtTypeCd(prjtTypeCd);

        //해당 예상손익분석서
        if(bizChanceSearchVO.getPrjtTypeCd().equals("B2")) {
            BizOpportList = bizChanceDAO.selectRlvnOfferProfitMAList(bizChanceSearchVO);
        }else {
            BizOpportList = bizChanceDAO.selectRlvnOfferProfitPSList(bizChanceSearchVO);
        }

        return BizOpportList;
    }


    @Transactional
    public List<BizChanceVO> selectBizChanceSalesEmpList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceSalesEmpList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        if(bizChanceSearchVO.getSlsEmpId() != "" && bizChanceSearchVO.getSlsEmpId() != null) {
            bizChanceSearchVO.setSlsDeptId(null);
        }

        bizChanceSearchVO.setUserId(accountVO.getEmpId());

        // 데이터 받을 준비
        List<BizChanceVO> data = bizChanceDAO.selectBizChanceSalesEmpList(bizChanceSearchVO);

        return data;
    }

    @Transactional
    public BizChanceVO updateBizChanceSalesEmp(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChanceSalesEmp");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();

        List<BizChanceHistoryVO> data = null;
        BizChanceVO transferBizChanceVO = new BizChanceVO();

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);

        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizChanceVO.setChgDt(chgDt);
        transferBizChanceVO.setChgDt(chgDt);

        //boptId, slsEmpId, slsDeptId
        bizChanceVO.getSlsDeptId();
        bizChanceVO.getSlsEmpId();

        try{
            for(BizChanceVO model : bizChanceVO.getBizOpportunityTransferList()) {
                bizChanceVO.setBoptId(model.getBoptId());
                transferBizChanceVO.setBoptId(model.getBoptId());

                //주테이블 업뎃
                bizChanceDAO.updateBizChanceSalesEmp(bizChanceVO);

                //주테이블 검색
                transferBizChanceVO = bizChanceDAO.selectBizChaneInfo(bizChanceVO);


                transferBizChanceVO.setChgDt(chgDt);
                //ChgDt
                if( bizChanceDAO.selectBizChanceHistoryCount(transferBizChanceVO) > 0) {
                    bizChanceDAO.deleteBizChanceHistoryAmt(transferBizChanceVO);
                    bizChanceDAO.deleteBizChanceHistoryNop(transferBizChanceVO);
                    bizChanceDAO.deleteBizChanceHistory(transferBizChanceVO);
                }

                //이력(주)인서트
                bizChanceDAO.insertBizChanceHistory(transferBizChanceVO);

                //이력(서브)인서트(따로생성)
                bizChanceDAO.insertBizChanceHistoryAmtSalesEmp(transferBizChanceVO);
                bizChanceDAO.insertBizChanceHistoryNopSalesEmp(transferBizChanceVO);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return bizChanceVO;
        }

        return bizChanceVO;
    }



    // EXCEL


    @Transactional
    public List<ExcelBizChanceVO> selectExcelDwnlBizChanceList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".getBizOpportunityDetailList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<ExcelBizChanceVO> list = bizChanceDAO.selectExcelDwnlBizChanceList(bizChanceSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getCntrDate() != null && list.get(i).getCntrDate() != "") {
                String cntrDate = list.get(i).getCntrDate();
                cntrDate = afterFormat.format(beforeFormat.parse(cntrDate));
                list.get(i).setCntrDate(cntrDate);
            }
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
            if(list.get(i).getPrpsFnshDate() != null && list.get(i).getPrpsFnshDate() != "") {
                String prpsFnshDate = list.get(i).getPrpsFnshDate();
                prpsFnshDate = afterFormat.format(beforeFormat.parse(prpsFnshDate));
                list.get(i).setPrpsFnshDate(prpsFnshDate);
            }
            if(list.get(i).getBidFnshDate() != null && list.get(i).getBidFnshDate() != "") {
                String bidFnshDate = list.get(i).getBidFnshDate();
                bidFnshDate = afterFormat.format(beforeFormat.parse(bidFnshDate));
                list.get(i).setBidFnshDate(bidFnshDate);
            }
            if(list.get(i).getCmpySlctDate() != null && list.get(i).getCmpySlctDate() != "") {
                String cmpySlctDate = list.get(i).getCmpySlctDate();
                cmpySlctDate = afterFormat.format(beforeFormat.parse(cmpySlctDate));
                list.get(i).setCmpySlctDate(cmpySlctDate);
            }
            if(list.get(i).getWctDcdDate() != null && list.get(i).getWctDcdDate() != "") {
                String wctDcdDate = list.get(i).getWctDcdDate();
                wctDcdDate = afterFormat.format(beforeFormat.parse(wctDcdDate));
                list.get(i).setWctDcdDate(wctDcdDate);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelBizChanceAmountVO> selectExcelDwnlBizChanceSellBuyList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlBizChanceSellBuyList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<ExcelBizChanceAmountVO> list = bizChanceDAO.selectExcelDwnlBizChanceSellBuyList(bizChanceSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getCntrDate() != null && list.get(i).getCntrDate() != "") {
                String cntrDate = list.get(i).getCntrDate();
                cntrDate = afterFormat.format(beforeFormat.parse(cntrDate));
                list.get(i).setCntrDate(cntrDate);
            }
            if(list.get(i).getFcstYam() != null && list.get(i).getFcstYam() != "") {
                String fcstYam = list.get(i).getFcstYam();
                fcstYam = afterMMFormat.format(beforeMMFormat.parse(fcstYam));
                list.get(i).setFcstYam(fcstYam);
            }
        }

        return list;
    }

    // 영업 활동 내역


    @Transactional
    public List<BizChanceActivityVO> selectBizChanceActivityList(Payload<BizChanceVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceActivityList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();

        List<BizChanceActivityVO> salesActivityList = bizChanceDAO.selectBizChanceActivityList(bizChanceVO);

        return salesActivityList;
    }

    @Transactional
    public BizChanceActivityVO insertBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        String prevId = bizChanceDAO.selectMaxSlsActId().getSlsActId();

        bizChanceActivityVO.setSlsActId(IndexUtils.generateId(10, prevId));
        bizChanceActivityVO.setRegEmpId(accountVO.getEmpId());

        bizChanceDAO.insertBizChanceActivity(bizChanceActivityVO);

        return bizChanceActivityVO;
    }

    @Transactional
    public BizChanceActivityVO updateBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        bizChanceActivityVO.setChgEmpId(accountVO.getEmpId());
        bizChanceDAO.updateBizChanceActivity(bizChanceActivityVO);

        return bizChanceActivityVO;
    }

    @Transactional
    public BizChanceActivityVO deleteBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".deleteBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        bizChanceDAO.deleteBizChanceActivity(bizChanceActivityVO);

        return bizChanceActivityVO;
    }



    /*
     * 예상손익분석서(ma) ver 1
     */

    @Transactional
    public OfferVO insertOfferProfitMA1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = offerProfitDAO.selectMaxFcstPalId().getFcstPalId();

        offerVO.setFcstPalId(IndexUtils.generateId(10, prevId));
        offerVO.setRegEmpId(accountVO.getEmpId());
        offerVO.setFcstPalPrgsStatCdNmCd("A");

        offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
        offerVO.setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitTitle(offerVO));
        offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.setSantId(super.insertDraft(offerVO.getApproval()));
  /* 구소스
        // 문서서식채번
        String prevDocNo = offerProfitDAO.selectMaxDocNo(offerVO.getApproval()).getDocNo();
        offerVO.setDocNo(super.generateDocId(3, prevDocNo));

        offerProfitDAO.insertOfferProfit(offerVO);
*/

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

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("W")) {
            bsnsProfitLoss.setIsInProgress(false);
        }else {
            bsnsProfitLoss.setIsInProgress(true);
        }

        return bsnsProfitLoss;
    }

    @Transactional
    public OfferVO updateOfferProfitMA1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        offerVO.setChgEmpId(accountVO.getEmpId());

        offerProfitDAO.updateOfferProfit(offerVO);

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

		/*offerProfitDAO.deleteEstimatedIncstExpense(offerVO);
		if (offerVO.getIncstExpenseList() != null) {
			for (IncstExpenseVO incstExpenseVO : offerVO.getIncstExpenseList()) {
				offerProfitDAO.updateEstimatdIncstExpense(incstExpenseVO);
			}
		}
*/
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
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitTitle(offerVO));

        if (offerVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(offerVO.getApproval());

        super.updateDraft(offerVO.getApproval());

        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitMA1(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitMA1");
        OfferVO offerVO = requestPayload.getDto();
        ApprovalVO approvalVO = new ApprovalVO();

        if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("")) {
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
        }
        offerProfitDAO.deleteOfferProfitPSProductDC(offerVO); // BEST011T
        offerProfitDAO.deleteOfferProfitPSProduct(offerVO); // BEST010T
        offerProfitDAO.deleteOfferMACond(offerVO); // BEST080T
        offerProfitDAO.deleteContractCond(offerVO); // BEST090T
        offerProfitDAO.deleteOfferProfitPSResult(offerVO); // BEST020T

        if (offerVO.getSantId() != null) {
            approvalVO.setSantId(offerVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        offerProfitDAO.deleteOfferProfitPS(offerVO); // BEST000T

        return offerVO;
    }



    /*
     * 예상손익분석서(P&S) ver 2
     */

    @Transactional
    public OfferVO insertOfferProfitPS2(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();


        // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
        OfferVO befOfferVO = new OfferVO();
        if(offerVO.getBefFcstPalId() != null){
            befOfferVO.setFcstPalId(offerVO.getBefFcstPalId());
            befOfferVO.setSantId(offerProfitDAO.selectOfferProfitPS2(befOfferVO).getSantId());

           if( !offerProfitDAO.selectFcstPalPrgsStatCd(befOfferVO).getFcstPalPrgsStatCdNmCd().equals("C")){
               throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.", befOfferVO);
           }
        }

        // 결재 등록 (미상신)
        offerVO.setFcstPalPrgsStatCdNmCd("A");
        offerVO.getApproval().setRegEmpId(accountVO.getEmpId());
        offerVO.setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitPS2Title(offerVO));
        offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());
        offerVO.setSantId(super.insertDraft(offerVO.getApproval()));

        offerVO.setRegEmpId(accountVO.getEmpId());
        String fcstPalId = offerProfitDAO.selectNewFcstPalId(offerVO).getFcstPalId();
        // 문서서식채번 포함하여 기본테이블 INSERT
        offerVO.setFcstPalId(fcstPalId);
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

        return offerVO;
    }

    @Transactional
    public OfferVO selectOfferProfitPS2(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();

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
    public ApprovalVO selectOfferProfitPS2DrfBtnList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferProfitPS2DrfBtnList");
        OfferVO bsnsProfitLoss = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        ApprovalVO approvalVO = new ApprovalVO();
        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
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

            // 버튼 리스트
            if (bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A") &&  super.isBelongToAuthDept(sysUserGroupVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
            }

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && bsnsProfitLoss.getFcstPalPrgsStatCdNmCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }


            if(super.isBelongToAuthDept(sysUserGroupVO)){
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
                    && sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "폐기"); }});
            }


        }

        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public ApprovalVO updateOfferProfitPS2Dss(Payload<ApprovalVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS2Dss");
        ApprovalVO approvalVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        approvalVO.setSantPrgsStatCd("W");
        approvalVO.setChgEmpId(accountVO.getEmpId());
        draftDao.updateApprovalState(approvalVO);

        // 결재 모듈에서 처리된 진행상태값에 따라 서식의 진행상태를 업데이트한다.
        OfferVO offerVO = new OfferVO();
        offerVO.setSantId(approvalVO.getSantId());
        offerVO.setFcstPalPrgsStatCdNmCd("W");
        offerProfitDAO.updateOfferProfitStat(offerVO);

        return approvalVO;
    }

    @Transactional
    public OfferVO updateOfferProfitPS2(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
            throw new UpdateDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
        }

        // 변경전예상손익ID가 존재하는 경우 해당 문서의 진행상태가 승인이 아닌 경우 insert를 하지않는다.
        OfferVO befOfferVO = new OfferVO();
        if(offerVO.getBefFcstPalId() != null) {
            befOfferVO.setFcstPalId(offerVO.getBefFcstPalId());
            befOfferVO.setSantId(offerProfitDAO.selectOfferProfitPS2(befOfferVO).getSantId());

            if (!offerProfitDAO.selectFcstPalPrgsStatCd(befOfferVO).getFcstPalPrgsStatCdNmCd().equals("C")) {
                throw new UpdateDeniedException("변경전 예상손익분석서는 승인상태여야 합니다.", befOfferVO);
            }
        }
        offerVO.setChgEmpId(accountVO.getEmpId());

        offerProfitDAO.updateOfferProfitPS2(offerVO); // BEST000T
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
        offerVO.getApproval().setDocTitl(offerProfitDAO.selectDraftOfferProfitPS2Title(offerVO));
        offerVO.getApproval().setSantFrmtCd(offerVO.getFrmtCd());

        if (offerVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(offerVO.getApproval());

        super.updateDraft(offerVO.getApproval());

        return offerVO;
    }

    @Transactional
    public OfferVO deleteOfferProfitPS2(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferProfitPS2");
        OfferVO offerVO = requestPayload.getDto();

        if (offerVO.getFcstPalId() == null || offerVO.getFcstPalId().equals("")) {
            offerVO.setFcstPalId(offerProfitDAO.selectFcstPalId(offerVO));
        }
        if (offerProfitDAO.selectIsRelatedWithVrb(offerVO) > 0) {
            throw new DeleteDeniedException("VRB 분석서에 등록된 예상손익분석서는 삭제할 수 없습니다.", offerVO);
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
            super.deleteCascadingDraft(approvalVO);
        }

        offerProfitDAO.deleteOfferProfitPS(offerVO);

        return offerVO;
    }

    @Transactional
    public List<DirectCostCriteriaVO> selectDirectCostList(Payload<OfferVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectDirectCostList");
        OfferVO offerVO = requestPayload.getDto();

        List<DirectCostCriteriaVO> data = offerProfitDAO.selectDirectCostList(offerVO);

        return data;
    }

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
                offerVO.setFcstPalPrgsStatCdNmCd("A"); // 등록
                break;
            case "B":	// 결재중
                offerVO.setFcstPalPrgsStatCdNmCd("B"); // 결재진행
                break;
            case "C":	// 완결
                offerVO.setFcstPalPrgsStatCdNmCd("C"); // 승인
                break;
            case "R":	// 반려/합의거부
                offerVO.setFcstPalPrgsStatCdNmCd("R"); // 반려
                break;
            case "W":	// 폐기
                offerVO.setFcstPalPrgsStatCdNmCd("W"); // 폐기
                break;
        }


        // 결재진행상태 업데이트
        offerProfitDAO.updateOfferProfitStat(offerVO);

        // 예상손익 결재진행 상태 조회
        result = offerProfitDAO.selectFcstPalPrgsStatCd(bsnsProfitLoss);

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(result.getFcstPalPrgsStatCdNmCd().equals("D") || result.getFcstPalPrgsStatCdNmCd().equals("W")) {
            result.setIsInProgress(false);
        }else {
            result.setIsInProgress(true);
        }

        return result;
    }

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
    public List<ExcelOfferProfitVO> seleceExcelDwnlOfferProfitList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitList(fcstPalSearchVO);

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
    public List<ExcelOfferProfitByProdTypeVO> seleceExcelDwnlOfferProfitByProdTypeList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProdTypeList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitByProdTypeVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitByProdTypeList(fcstPalSearchVO);

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
    public List<ExcelOfferProfitByProductVO> seleceExcelDwnlOfferProfitByProductList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProductList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelOfferProfitByProductVO> list = offerProfitDAO.seleceExcelDwnlOfferProfitByProductList(fcstPalSearchVO);

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
