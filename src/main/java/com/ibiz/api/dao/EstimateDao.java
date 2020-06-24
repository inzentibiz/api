package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "estimateDao")
public class EstimateDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    /**
     * 이전 문서정보 조회
     */
    public BsnsProfitLossVO selectMaxDocNo(ApprovalVO approvalVO) {
        return mybatis.selectOne("EstimateMapper.Select_maxDocNo",approvalVO);
    }

    /**
     * 프로젝트 및 최종고객 정보조회
     */
    public String selectFcstPalId(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("EstimateMapper.Select_fcstPalId", bsnsProfitLossVO);
    }

    public String selectIsRelatedWithVrb(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("EstimateMapper.Select_isRelatedWithVrb", bsnsProfitLossVO);
    }

    /**
     * 프로젝트 경비 기준정보 조회
     */
    public List<PrjtDrcstExpenseVO> selectDirectExpenseStandardList() {
        return mybatis.selectList("EstimateMapper.Select_directExpenseStandardList");
    }

    /**
     * 프로젝트 경비 정보 조회 바인딩
     */
    public List<BsnsExpenseVO> selectDirectExpenseList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_directExpenseList", bsnsProfitLossVO);
    }

    /**
     * 프로젝트 및 최종고객 정보조회
     */
    public String selectDraftEstimateDocTitl(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("EstimateMapper.Select_draftEstimateDocTitl", bsnsProfitLossVO);
    }

    /**
     * MAX(FCST_PAL_ID) 조회
     */
    public BsnsProfitLossVO selectMaxFcstPalId() {
        return mybatis.selectOne("EstimateMapper.Select_maxFcstPalId");
    }

    /**
     * 1. 사업정보 조회
     */
    public BsnsProfitLossVO selectBusinessInformation(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("EstimateMapper.Select_businessInformation", bsnsProfitLossVO);
    }

    /**
     * 3. VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
     */
    public List<VRBSelectCriteriaVO> selectVrbCriteriaList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_vrbCriteriaList", bsnsProfitLossVO);
    }

    /**
     * 3. VRB 대상선정 및 평가결과 : VRB 분석리스트 조회
     */
    public List<VRBProfitVO> selectVrbList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_vrbList", bsnsProfitLossVO);
    }

    /**
     * 4. 견적사항 : 견적 리스트 조회
     */
    public List<BsnsProdDetailVO> selectEstimationContentsList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_estimationContentsList", bsnsProfitLossVO);
    }

    /**
     * 4. 견적사항 : 할인정책리스트
     */
    public List<ProdDcPolicyVO> selectDiscountPolicyList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_discountPolicyList", bsnsProfitLossVO);
    }

    /**
     * 5. 예상매출원가 : 프로젝트 경비(직접비)
     */
    public List<BsnsExpenseVO> selectProjectDirectExpenseList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_projectDirectExpenseList", bsnsProfitLossVO);
    }

    /**
     * 예상손익 : 실적(취합)
     */
    public List<BsnsRslSmryVO> selectEstimateRslSmryList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_estimateRslSmryList", bsnsProfitLossVO);
    }


    /**
     * 2. 예상손익 : 상품구분별 간접비
     */
    // 삭제테이블
/*	public List<IncstExpenseVO> selectProjectIncstExpenseList(BsnsProfitLossVO bsnsProfitLossVO) {
		return mybatis.selectList("EstimateMapper.Select_projectIncstExpenseList", bsnsProfitLossVO);
	}*/

    /**
     * 상품유형 가져오기
     */
    public List<BsnsProdDetailVO> selectProdTypeCd(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_prodTypeCd", bsnsProfitLossVO);
    }
    /**
     * 상품유형 가져오기(020T에 존재하는 값만 조회)
     */
    public List<BsnsProdDetailVO> selectProdTypeCdByFcstPalId(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_prodTypeCdByFcstPalId", bsnsProfitLossVO);
    }


    /*
     * Maintenance
     */

    /*public List<MaBsnsDetailVO> selectEstimatedMaintenanceDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_estimatedMaintenanceDetail", bsnsProfitLossVO);
    }
    */
    public List<MaConditionVO> selectMaintenanceConditionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_MaintenanceConditionDetail", bsnsProfitLossVO);
    }


    /**
     * EXCEL
     */
    public List<ExcelBasicEstimateAnalysisVO> selectBasicEstimateAnalysisListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("EstimateMapper.Select_basicEstimateAnalysisListForExcel", fcstPalSearchVO);
    }

    public List<ExcelProductTypeEstimateVO> selectEstimateByProdTypeListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("EstimateMapper.Select_estimateByProdTypeListForExcel", fcstPalSearchVO);
    }
    public List<ExcelProductEstimateVO> selectEstimateByProductListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("EstimateMapper.Select_estimateByProductListForExcel", fcstPalSearchVO);
    }

    /*
     * INSERT
     */

    /**
     * 1. 사업정보 저장
     */
    public void insertEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.insert("EstimateMapper.Insert_estimatedProfitAndLoss", bsnsProfitLossVO);
    }

    /**
     * 4. 견적사항, 5. 예상매출원가 : 제조사포함
     */
    public void insertEstimatedProductDetail(BsnsProdDetailVO bsnsProdDetailVO) {
        mybatis.insert("EstimateMapper.Insert_estimatedProductDetail", bsnsProdDetailVO);
    }

    /**
     * 4. 견적사항 : 할인정책상세
     */
    public void insertEstimatedProductDiscountPolocy(ProdDcPolicyVO prodDcPolicyVO) {
        mybatis.insert("EstimateMapper.Insert_estimatedProductDiscountPolocy", prodDcPolicyVO);
    }


    /**
     * 5. 예상매출가 : 프로젝트 경비 (직접비)
     */
    public void insertEstimatedExpense(BsnsExpenseVO bsnsExpenseVO) {
        mybatis.insert("EstimateMapper.Insert_estimatedExpense", bsnsExpenseVO);
    }

    /**
     * 예상손익 : 실적(취합)
     */
    public void insertEstimateRslSmry(BsnsRslSmryVO bsnsRslSmryVO) {
        mybatis.insert("EstimateMapper.Insert_estimateRslSmry", bsnsRslSmryVO);
    }

    /**
     * 2. 예상손익 : 상품구분별 간접비
     */
	/*public void insertEstimatdIncstExpense(IncstExpenseVO incstExpenseVO) {
		mybatis.insert("EstimateMapper.Insert_estimatdIncstExpense", incstExpenseVO);
	}*/

    /*
     * Maintenance
     */

	/*public void insertEstimatedMaintenanceDetail(MaBsnsDetailVO maBsnsDetailVO) {
		mybatis.insert("EstimateMapper.Insert_estimatedMaintenanceDetail", maBsnsDetailVO);
	}*/

    public void insertMaintenanceConditionDetail(MaConditionVO maConditionVO) {
        mybatis.insert("EstimateMapper.Insert_MaintenanceConditionDetail", maConditionVO);
    }

    public void insertContractOptionDetail(ContractOptionVO contractOptionVO) {
        mybatis.insert("EstimateMapper.Insert_ContractOptionDetail", contractOptionVO);
    }
    /*
     * UPDATE
     */

    public void updateEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.update("EstimateMapper.Update_estimatedProfitAndLoss", bsnsProfitLossVO);
    }
	/*
	public void updateEstimatdIncstExpense(IncstExpenseVO incstExpenseVO) {
		mybatis.update("EstimateMapper.Update_estimatdIncstExpense", incstExpenseVO);
	}*/

    /*
     * DELETE
     */

    public void deleteEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimatedProfitAndLoss", bsnsProfitLossVO);
    }

    public void deleteEstimatedProductDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimatedProductDetail", bsnsProfitLossVO);
    }

    public void deleteEstimatedProductDiscountPolocy(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimatedProductDiscountPolocy", bsnsProfitLossVO);
    }


    public void deleteEstimatedExpense(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimatedExpense", bsnsProfitLossVO);
    }
    /**
     * 예상손익 : 실적(취합)
     */
    public void deleteEstimateRslSmry(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimateRslSmry", bsnsProfitLossVO);
    }

	/*
	public void deleteEstimatedIncstExpense(BsnsProfitLossVO bsnsProfitLossVO) {
		mybatis.delete("EstimateMapper.Delete_estimatedIncstExpense", bsnsProfitLossVO);
	}*/

    /*
     * Maintenance
     */

    public void deleteEstimatedMaintenanceDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_estimatedMaintenanceDetail", bsnsProfitLossVO);
    }

    public void deleteMaintenanceConditionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_MaintenanceConditionDetail", bsnsProfitLossVO);
    }

    public void deleteContractOptionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("EstimateMapper.Delete_ContractOptionDetail", bsnsProfitLossVO);
    }

    public BsnsProfitLossVO selectFcstPalPrgsStatCdNmCd(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("EstimateMapper.Select_FcstPalPrgsStatCdNmCd", bsnsProfitLossVO);
    }

    public List<ContractOptionVO> selectContractOptionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("EstimateMapper.Select_ContractOptionDetail", bsnsProfitLossVO);
    }


    /*
     * Legacy
     */
    public List<FcstPalVO> selectQuoteAnalysisList(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("ForcastPALMapper.Select_quoteAnalysisList", fcstPalSearchVO);
    }

    public Integer selectIsExistForcastPAL(FcstPalVO fcstPalVO) {
        return mybatis.selectOne("ForcastPALMapper.Select_isExistForcastPAL", fcstPalVO);
    }

    public void updateEstimateApprovalState(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.update("EstimateMapper.Update_estimateApprovalState", bsnsProfitLossVO);
    }

}
