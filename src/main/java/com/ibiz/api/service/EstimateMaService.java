package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class EstimateMaService extends AbstractDraftService {

    @Resource(name = "estimateDao")
    private EstimateDao estimateDao;

    @Transactional
    public BsnsProfitLossVO insertEstimatedMaAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertEstimatedMaAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = estimateDao.selectMaxFcstPalId().getFcstPalId();

        bsnsProfitLossVO.setFcstPalId(IndexUtils.generateId(10, prevId));
        bsnsProfitLossVO.setRegEmpId(accountVO.getEmpId());
        bsnsProfitLossVO.setFcstPalPrgsStatCd("A");

        bsnsProfitLossVO.getApproval().setRegEmpId(accountVO.getEmpId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(estimateDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));
        bsnsProfitLossVO.getApproval().setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.setSantId(super.insertDraft(bsnsProfitLossVO.getApproval()));
  /* 구소스
        // 문서서식채번
        String prevDocNo = estimateDao.selectMaxDocNo(bsnsProfitLossVO.getApproval()).getDocNo();
        bsnsProfitLossVO.setDocNo(super.generateDocId(3, prevDocNo));

        estimateDao.insertEstimatedProfitAndLoss(bsnsProfitLossVO);
*/

        // 문서서식채번 포함하여 기본테이블 INSERT
        estimateDao.insertEstimatedProfitAndLoss(bsnsProfitLossVO);

        // 타사구매내역
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                // 201911상품변경 추가
                bsnsProdDetailVO.setProdTypeCd("MA");
                bsnsProdDetailVO.setProdDstCd("MA");
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        // 유지보수구매내역
        if(bsnsProfitLossVO.getMaBsnsDetailList() != null) {
            for (BsnsProdDetailVO maBsnsDetailVO : bsnsProfitLossVO.getMaBsnsDetailList()) {
                maBsnsDetailVO.setProdTypeCd("MA");
                maBsnsDetailVO.setProdDstCd("MA");
                maBsnsDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertEstimatedProductDetail(maBsnsDetailVO);
            }
        }
        // 서비스제공조건
        if (bsnsProfitLossVO.getMaConditionList() != null) {
            for (MaConditionVO maConditionVO : bsnsProfitLossVO.getMaConditionList()) {
                maConditionVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertMaintenanceConditionDetail(maConditionVO);
            }
        }
        // 계약옵션
        if(bsnsProfitLossVO.getContractOptionList() != null) {
            for(ContractOptionVO contractOptionVO : bsnsProfitLossVO.getContractOptionList()) {
                contractOptionVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertContractOptionDetail(contractOptionVO);
            }
        }
        // 예상손익 실적취합
        if(bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for(BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                bsnsRslSmryVO.setProdTypeCd("MA");
                estimateDao.insertEstimateRslSmry(bsnsRslSmryVO);
            }
        }

        return bsnsProfitLossVO;
    }

    @Transactional
        public BsnsProfitLossVO selectEstimatedMaAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimatedMaAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        BsnsProfitLossVO bsnsProfitLoss = new BsnsProfitLossVO();
        UserGrpVO userGrpVO = new UserGrpVO();

        if (bsnsProfitLossVO.getFcstPalId() == null)
            bsnsProfitLossVO.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLossVO));

        bsnsProfitLoss = estimateDao.selectBusinessInformation(bsnsProfitLossVO);
        //bsnsProfitLoss.setMaBsnsDetailList(estimateDAO.selectEstimatedMaintenanceDetail(bsnsProfitLossVO));
        bsnsProfitLoss.setMaConditionList(estimateDao.selectMaintenanceConditionDetail(bsnsProfitLossVO));
        bsnsProfitLoss.setBsnsProdDetailList(estimateDao.selectEstimationContentsList(bsnsProfitLossVO));
//		bsnsProfitLoss.setIncstExpenseList(estimateDAO.selectProjectIncstExpenseList(bsnsProfitLoss)); //삭제테이블
//		bsnsProfitLoss.setProdDcPolicyList(estimateDAO.selectDiscountPolicyList(bsnsProfitLossVO));
        bsnsProfitLoss.setContractOptionList(estimateDao.selectContractOptionDetail(bsnsProfitLossVO));
        bsnsProfitLoss.setBsnsRslSmryList(estimateDao.selectEstimateRslSmryList(bsnsProfitLossVO));

        bsnsProfitLoss.setApproval(super.selectApprovalInfo(bsnsProfitLoss.getSantId()));

        // 예상손익 진행상태가 확정또는 폐기일 경우 결재버튼 내려주면 안된다.
        if(bsnsProfitLoss.getFcstPalPrgsStatCd().equals("D") || bsnsProfitLoss.getFcstPalPrgsStatCd().equals("W")) {
            bsnsProfitLoss.setIsInProgress(false);
        }else {
            bsnsProfitLoss.setIsInProgress(true);
        }

        return bsnsProfitLoss;
    }

    @Transactional
    public BsnsProfitLossVO updateEstimatedMaAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateEstimatedMaAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        bsnsProfitLossVO.setChgEmpId(accountVO.getEmpId());

        estimateDao.updateEstimatedProfitAndLoss(bsnsProfitLossVO);

        estimateDao.deleteEstimatedProductDetail(bsnsProfitLossVO);
        // 유지보수, 타사구매내역 동일한 VO
        if (bsnsProfitLossVO.getBsnsProdDetailList() != null) {
            for (BsnsProdDetailVO bsnsProdDetailVO : bsnsProfitLossVO.getBsnsProdDetailList()) {
                bsnsProdDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                // 201911상품변경 추가
                bsnsProdDetailVO.setProdTypeCd("MA");
                bsnsProdDetailVO.setProdDstCd("MA");
                estimateDao.insertEstimatedProductDetail(bsnsProdDetailVO);
            }
        }
        if (bsnsProfitLossVO.getMaBsnsDetailList() != null) {
            for (BsnsProdDetailVO maBsnsDetailVO : bsnsProfitLossVO.getMaBsnsDetailList()) {
                maBsnsDetailVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                // 201911상품변경 추가
                maBsnsDetailVO.setProdTypeCd("MA");
                maBsnsDetailVO.setProdDstCd("MA");
                estimateDao.insertEstimatedProductDetail(maBsnsDetailVO);
            }
        }

        estimateDao.deleteMaintenanceConditionDetail(bsnsProfitLossVO);
        if (bsnsProfitLossVO.getMaConditionList() != null) {
            for (MaConditionVO maConditionVO : bsnsProfitLossVO.getMaConditionList()) {
                maConditionVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertMaintenanceConditionDetail(maConditionVO);
            }
        }

		/*estimateDAO.deleteEstimatedIncstExpense(bsnsProfitLossVO);
		if (bsnsProfitLossVO.getIncstExpenseList() != null) {
			for (IncstExpenseVO incstExpenseVO : bsnsProfitLossVO.getIncstExpenseList()) {
				estimateDAO.updateEstimatdIncstExpense(incstExpenseVO);
			}
		}
*/
        estimateDao.deleteContractOptionDetail(bsnsProfitLossVO);
        if(bsnsProfitLossVO.getContractOptionList() != null) {
            for(ContractOptionVO contractOptionVO : bsnsProfitLossVO.getContractOptionList()) {
                contractOptionVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                estimateDao.insertContractOptionDetail(contractOptionVO);
            }
        }

        // 예상손익 실적취합
        estimateDao.deleteEstimateRslSmry(bsnsProfitLossVO);
        if(bsnsProfitLossVO.getBsnsRslSmryList() != null) {
            for(BsnsRslSmryVO bsnsRslSmryVO : bsnsProfitLossVO.getBsnsRslSmryList()) {
                bsnsRslSmryVO.setFcstPalId(bsnsProfitLossVO.getFcstPalId());
                bsnsRslSmryVO.setProdTypeCd("MA");
                estimateDao.insertEstimateRslSmry(bsnsRslSmryVO);
            }
        }

        bsnsProfitLossVO.getApproval().setSantId(bsnsProfitLossVO.getSantId());
        bsnsProfitLossVO.setSantFrmtCd(bsnsProfitLossVO.getFrmtCd());
        bsnsProfitLossVO.getApproval().setDocTitl(estimateDao.selectDraftEstimateDocTitl(bsnsProfitLossVO));

        if (bsnsProfitLossVO.getApproval().getApprovalDetailList() != null)
            super.updateApproverList(bsnsProfitLossVO.getApproval());

        super.updateDraft(bsnsProfitLossVO.getApproval());

        return bsnsProfitLossVO;
    }

    @Transactional
    public BsnsProfitLossVO deleteEstimatedMaAnalysis(Payload<BsnsProfitLossVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteEstimatedMaAnalysis");
        BsnsProfitLossVO bsnsProfitLossVO = requestPayload.getDto();
        ApprovalVO approvalVO = new ApprovalVO();

        if (bsnsProfitLossVO.getFcstPalId() == null || bsnsProfitLossVO.getFcstPalId().equals("")) {
            bsnsProfitLossVO.setFcstPalId(estimateDao.selectFcstPalId(bsnsProfitLossVO));
        }
        estimateDao.deleteEstimatedProductDiscountPolocy(bsnsProfitLossVO); // BEST011T
        estimateDao.deleteEstimatedProductDetail(bsnsProfitLossVO); // BEST010T
        //estimateDAO.deleteEstimatedMaintenanceDetail(bsnsProfitLossVO); // BEST070T
        estimateDao.deleteMaintenanceConditionDetail(bsnsProfitLossVO); // BEST080T
        estimateDao.deleteContractOptionDetail(bsnsProfitLossVO); // BEST090T
        estimateDao.deleteEstimateRslSmry(bsnsProfitLossVO); // BEST020T

        if (bsnsProfitLossVO.getSantId() != null) {
            approvalVO.setSantId(bsnsProfitLossVO.getSantId());
            super.deleteCascadingDraft(approvalVO);
        }

        estimateDao.deleteEstimatedProfitAndLoss(bsnsProfitLossVO); // BEST000T

        return bsnsProfitLossVO;
    }
}
