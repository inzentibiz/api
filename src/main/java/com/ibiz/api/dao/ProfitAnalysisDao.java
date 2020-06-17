package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "profitAnalysisDao")
public class ProfitAnalysisDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */


    // fcstPalId 정보조회
    public String selectFcstPalId(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_fcstPalId", bsnsProfitLossVO);
    }

    //VRB 등록여부 조회
    public Integer selectIsRelatedWithVrb(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_isRelatedWithVrb", bsnsProfitLossVO);
    }

    //수익변경보고 등록여부 조회
    public Integer selectIsRelatedWithBefProfitAnalysis(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_IsRelatedWithBefProfitAnalysis", bsnsProfitLossVO);
    }


    //예상손익기본 상세 조회
    public BsnsProfitLossVO selectBusinessInformation(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_businessInformation", bsnsProfitLossVO);
    }

    //상품상세 리스트 조회
    public List<BsnsProdDetailVO> selectEstimationContentsList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_estimationContentsList", bsnsProfitLossVO);
    }

    //할인정책 리스트 조회
    public List<ProdDcPolicyVO> selectDiscountPolicyList(BsnsProdDetailVO bsnsProdDetailVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_discountPolicyList", bsnsProdDetailVO);
    }

    //실적집계 조회
    public List<BsnsRslSmryVO> selectEstimateRslSmryList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_estimateRslSmryList", bsnsProfitLossVO);
    }

    //프로젝트 경비(직접비) 조회(상세화면)
    public List<BsnsExpenseVO> selectPrjtDirectExpenseListForDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_prjtDirectExpenseListForDetail", bsnsProfitLossVO);
    }

    //프로젝트 경비 기준정보 조회(등록수정화면)
    public List<PrjtDrcstExpenseVO> selectPrjtDirectExpenseListForCreateModify(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_prjtDirectExpenseListForCreateModify", bsnsProfitLossVO);
    }


    //결재문서 title 구성
    public String selectDraftEstimateDocTitl(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_draftEstimateDocTitl", bsnsProfitLossVO);
    }

    //VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
    public List<VrbCriteriaVO> selectVrbCriteriaList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_vrbCriteriaList", bsnsProfitLossVO);
    }

    //VRB 분석리스트 조회
    public List<VRBProfitAnalysisDetailVO> selectVrbList(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_vrbList", bsnsProfitLossVO);
    }



    /*
     * Maintenance
     */

    //서비스 제공조건 조회
    public List<MaConditionVO> selectMaintenanceConditionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_maintenanceConditionDetail", bsnsProfitLossVO);
    }
    // 계약옵션 조회
    public List<ContractOptionVO> selectContractOptionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_ContractOptionDetail", bsnsProfitLossVO);
    }

    // 진행상태 조회
    public BsnsProfitLossVO selectFcstPalPrgsStatCd(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_fcstPalPrgsStatCd", bsnsProfitLossVO);
    }

    //EXCEL 예상손익 기본리스트 조회
    public List<ExcelBasicEstimateAnalysisVO> selectBasicEstimateAnalysisListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_basicEstimateAnalysisListForExcel", fcstPalSearchVO);
    }

    //EXCEL 예상손익 상품유형별 리스트 조회
    public List<ExcelProductTypeEstimateVO> selectEstimateByProdTypeListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_estimateByProdTypeListForExcel", fcstPalSearchVO);
    }

    //EXCEL 예상손익 상품별 리스트 조회
    public List<ExcelProductEstimateVO> selectEstimateByProductListForExcel(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("ProfitAnalysisMapper.Select_estimateByProductListForExcel", fcstPalSearchVO);
    }
    // 예상손익 key select
    public BsnsProfitLossVO selectNewFcstPalId(BsnsProfitLossVO bsnsProfitLossVO) {
        return mybatis.selectOne("ProfitAnalysisMapper.Select_newFcstPalId", bsnsProfitLossVO);
    }



    /*
     * INSERT
     */

    // 예상손익 기본 등록
    public void insertEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_estimatedProfitAndLoss", bsnsProfitLossVO);
    }

    // 예상손익 상품 등록
    public void insertEstimatedProductDetail(BsnsProdDetailVO bsnsProdDetailVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_estimatedProductDetail", bsnsProdDetailVO);
    }

    // 할인정책 등록
    public void insertEstimatedProductDiscountPolicy(ProdDcPolicyVO prodDcPolicyVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_estimatedProductDiscountPolicy", prodDcPolicyVO);
    }


    // 프로젝트 직접경비 등록
    public void insertEstimatedExpense(BsnsExpenseVO bsnsExpenseVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_estimatedExpense", bsnsExpenseVO);
    }

    // 실적집계 등록
    public void insertEstimateRslSmry(BsnsRslSmryVO bsnsRslSmryVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_estimateRslSmry", bsnsRslSmryVO);
    }

    /*
     * Maintenance
     */
    // 서비스 조건 등록
    public void insertMaintenanceConditionDetail(MaConditionVO maConditionVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_maintenanceConditionDetail", maConditionVO);
    }

    // 계약옵션 등록
    public void insertContractOptionDetail(ContractOptionVO contractOptionVO) {
        mybatis.insert("ProfitAnalysisMapper.Insert_contractOptionDetail", contractOptionVO);
    }

    /*
     * UPDATE
     */

    // 예상손익 기본 수정
    public void updateEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.update("ProfitAnalysisMapper.Update_estimatedProfitAndLoss", bsnsProfitLossVO);
    }

    /*
     * DELETE
     */
    // 예상손익 기본 삭제
    public void deleteEstimatedProfitAndLoss(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_estimatedProfitAndLoss", bsnsProfitLossVO);
    }

    // 예상손익 상품 삭제
    public void deleteEstimatedProductDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_estimatedProductDetail", bsnsProfitLossVO);
    }

    // 예상손익 할인정책 삭제
    public void deleteEstimatedProductDiscountPolicy(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_estimatedProductDiscountPolicy", bsnsProfitLossVO);
    }

    // 프로젝트 경비 삭제
    public void deleteEstimatedExpense(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_estimatedExpense", bsnsProfitLossVO);
    }

    // 예상손익 실적집계 삭제
    public void deleteEstimateRslSmry(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_estimateRslSmry", bsnsProfitLossVO);
    }

    /*
     * Maintenance
     */


    // 서비스제공조건 삭제
    public void deleteMaintenanceConditionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_maintenanceConditionDetail", bsnsProfitLossVO);
    }

    // 계약옵션 삭제
    public void deleteContractOptionDetail(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.delete("ProfitAnalysisMapper.Delete_contractOptionDetail", bsnsProfitLossVO);
    }



    /*
     *
     */
    public List<FcstPalVO> selectQuoteAnalysisList(FcstPalSearchVO fcstPalSearchVO) {
        return mybatis.selectList("ForcastPALMapper.Select_quoteAnalysisList", fcstPalSearchVO);
    }

    public List<EstiHisVO> selectEstimateHistoryList(EstiHisSearchVO estiHisSearchVO){
        return mybatis.selectList("EstimateIssueMapper.Select_estimateHistoryList", estiHisSearchVO);
    }

    public Integer selectEstimateHistoryListCount(EstiHisSearchVO estiHisSearchVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateHistoryListCount", estiHisSearchVO);
    }

    public Integer selectIsExistForcastPAL(FcstPalVO fcstPalVO) {
        return mybatis.selectOne("ForcastPALMapper.Select_isExistForcastPAL", fcstPalVO);
    }

    public void updateEstimateApprovalState(BsnsProfitLossVO bsnsProfitLossVO) {
        mybatis.update("ProfitAnalysisMapper.Update_estimateApprovalState", bsnsProfitLossVO);
    }

}
