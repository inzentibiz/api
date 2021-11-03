package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "offerProfitDAO")
public class OfferProfitDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    /**
     * 이전 문서정보 조회
     */
    public OfferVO selectMaxDocNo(ApprovalVO approvalVO) {
        return mybatis.selectOne("OfferProfitMapper.selectMaxDocNo",approvalVO);
    }

    /**
     * 프로젝트 경비 기준정보 조회
     */
    public List<DirectCostCriteriaVO> selectDirectCostCriteriaList() {
        return mybatis.selectList("OfferProfitMapper.selectDirectCostCriteriaList");
    }

    /**
     * 프로젝트 경비 정보 조회 바인딩
     */
    public List<OfferExpenseVO> selectDirectCostBindList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectDirectCostBindList", offerVO);
    }

    /**
     * 프로젝트 및 최종고객 정보조회
     */
//    public String selectDraftOfferProfitTitle(OfferVO offerVO) {
//        return mybatis.selectOne("OfferProfitMapper.selectDraftOfferProfitTitle", offerVO);
//    }

    /**
     * MAX(FCST_PAL_ID) 조회
     */
    public OfferVO selectMaxFcstPalId() {
        return mybatis.selectOne("OfferProfitMapper.selectMaxFcstPalId");
    }

    /**
     * 1. 사업정보 조회
     */
    public OfferVO selectOfferProfit(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectOfferProfit", offerVO);
    }

    /**
     * 3. VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
     */
    public List<VRBSelectCriteriaVO> selectVrbCriteriaList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectVrbCriteriaList", offerVO);
    }

    /**
     * 3. VRB 대상선정 및 평가결과 : VRB 분석리스트 조회
     */
    public List<VRBProfitVO> selectOfferProfitPS1VrbList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS1VrbList", offerVO);
    }

    /**
     * 4. 견적사항 : 견적 리스트 조회
     */
    public List<OfferProductVO> selectOfferProfitProductList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitProductList", offerVO);
    }

    /**
     * 4. 견적사항 : 할인정책리스트
     */
    public List<OfferProductDCVO> selectOfferProfitProductDCList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitProductDCList", offerVO);
    }

    /**
     * 5. 예상매출원가 : 프로젝트 경비(직접비)
     */
    public List<OfferExpenseVO> selectPrjojectDirectCostList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectPrjojectDirectCostList", offerVO);
    }

    /**
     * 손익 : 실적(취합)
     */
    public List<OfferResultVO> selectOfferProfitResultList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitResultList", offerVO);
    }


    /**
     * 2. 손익 : 상품구분별 간접비
     */


    /**
     * 상품유형 가져오기
     */
    public List<OfferProductVO> selectOfferRstProdTypeList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferRstProdTypeList", offerVO);
    }
    /**
     * 상품유형 가져오기(020T에 존재하는 값만 조회)
     */
    public List<OfferProductVO> selectOfferRstProdTypeView(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferRstProdTypeView", offerVO);
    }

    public List<OfferMACondVO> selectOfferMACondList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferMACondList", offerVO);
    }


    /**
     * EXCEL
     */
    public List<ExcelOfferProfitVO> seleceExcelDwnlOfferProfitList(OfferProfitSearchVO offerProfitSearchVO) {
        return mybatis.selectList("OfferProfitMapper.seleceExcelDwnlOfferProfitList", offerProfitSearchVO);
    }

    public List<ExcelOfferProfitByProdTypeVO> seleceExcelDwnlOfferProfitByProdTypeList(OfferProfitSearchVO offerProfitSearchVO) {
        return mybatis.selectList("OfferProfitMapper.seleceExcelDwnlOfferProfitByProdTypeList", offerProfitSearchVO);
    }
    public List<ExcelOfferProfitByProductVO> seleceExcelDwnlOfferProfitByProductList(OfferProfitSearchVO offerProfitSearchVO) {
        return mybatis.selectList("OfferProfitMapper.seleceExcelDwnlOfferProfitByProductList", offerProfitSearchVO);
    }

    /*
     * INSERT
     */

    /**
     * 1. 사업정보 저장
     */
    public void insertOfferProfit(OfferVO offerVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfit", offerVO);
    }

    /**
     * 4. 견적사항, 5. 예상매출원가 : 제조사포함
     */
    public void insertOfferProfitProduct(OfferProductVO offerProductVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitProduct", offerProductVO);
    }

    /**
     * 4. 견적사항 : 할인정책상세
     */
    public void insertOfferProfitPS1ProductDC(OfferProductDCVO offerProductDCVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS1ProductDC", offerProductDCVO);
    }


    /**
     * 5. 예상매출가 : 프로젝트 경비 (직접비)
     */
    public void insertOfferProfitExpense(OfferExpenseVO offerExpenseVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitExpense", offerExpenseVO);
    }

    /**
     * 손익 : 실적(취합)
     */
    public void insertOfferProfitResult(OfferResultVO offerResultVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitResult", offerResultVO);
    }

    /*
     * Maintenance
     */

    public void insertOfferMACond(OfferMACondVO offerMACondVO) {
        mybatis.insert("OfferProfitMapper.insertOfferMACond", offerMACondVO);
    }

    public void insertContractCond(OfferContractCondVO offerContractCondVO) {
        mybatis.insert("OfferProfitMapper.insertContractCond", offerContractCondVO);
    }
    /*
     * UPDATE
     */

    public void updateOfferProfit(OfferVO offerVO) {
        mybatis.update("OfferProfitMapper.updateOfferProfit", offerVO);
    }

    /*
     * Maintenance
     */

    public void deleteOfferMACond(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferMACond", offerVO);
    }

    public void deleteContractCond(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteContractCond", offerVO);
    }
    public List<OfferContractCondVO> selectContractCondList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectContractCondList", offerVO);
    }


    /*
     * Legacy
     */
    public List<OfferVO> selectOfferProfitList(OfferProfitSearchVO offerProfitSearchVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitList", offerProfitSearchVO);
    }

    public Integer selectisExistsOffer(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectisExistsOffer", offerVO);
    }


    // P&S ver 2


    /*
     * SELECT
     */


    // fcstPalId 정보조회
    public String selectFcstPalId(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.SelectFcstPalId", offerVO);
    }

    //VRB 등록여부 조회
    public Integer selectIsRelatedWithVrb(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectIsRelatedWithVrb", offerVO);
    }
    //견적서 등록여부 조회
    public Integer selectIsRelatedWithEstimate(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectIsRelatedWithEstimate", offerVO);
    }

    //수익변경보고 등록여부 조회
    public Integer selectIsRelatedWithBefProfitAnalysis(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectIsRelatedWithBefProfitAnalysis", offerVO);
    }

    //손익기본 상세 조회
    public OfferVO selectOfferProfitPS2(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectOfferProfitPS2", offerVO);
    }

    //상품상세 리스트 조회
    public List<OfferProductVO> selectOfferProfitPS2ProductList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS2ProductList", offerVO);
    }

    //할인정책 리스트 조회
    public List<OfferProductDCVO> selectOfferProfitPS2ProductDCList(OfferProductVO offerProductVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS2ProductDCList", offerProductVO);
    }

    //실적집계 조회
    public List<OfferResultVO> selectOfferProfitPS2ResultList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS2ResultList", offerVO);
    }

    //프로젝트 경비(직접비) 조회(상세화면)
    public List<OfferExpenseVO> selectOfferExpenseList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferExpenseList", offerVO);
    }

    //프로젝트 경비 기준정보 조회(등록수정화면)
    public List<DirectCostCriteriaVO> selectDirectCostList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectDirectCostList", offerVO);
    }

    //결재문서 title 구성
//    public String selectDraftOfferProfitPS2Title(OfferVO offerVO) {
//        return mybatis.selectOne("OfferProfitMapper.selectDraftOfferProfitPS2Title", offerVO);
//    }

    //VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
    public List<VRBSelectCriteriaVO> selectOfferProfitPS2VRBSelectCriteriaList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS2VRBSelectCriteriaList", offerVO);
    }

    //VRB 분석리스트 조회
    public List<VRBProfitVO> selectOfferProfitPS2VrbList(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectOfferProfitPS2VrbList", offerVO);
    }


    // 진행상태 조회
    public OfferVO selectFcstPalPrgsStatCd(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectFcstPalPrgsStatCd", offerVO);
    }

    // 손익 key select
    public OfferVO selectNewFcstPalId(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectNewFcstPalId", offerVO);
    }

    // 프로젝트에 연관된 손익 조회
    public List<OfferVO> selectProfitAnalysisListByPrjtId(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectProfitAnalysisListByPrjtId", offerVO);
    }


    /*
     * INSERT
     */

    // 손익 기본 등록
    public void insertOfferProfitPS2(OfferVO offerVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS2", offerVO);
    }

    // 손익 상품 등록
    public void insertOfferProfitPS2Product(OfferProductVO offerProductVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS2Product", offerProductVO);
    }

    // 할인정책 등록
    public void insertOfferProfitPS2ProductDC(OfferProductDCVO offerProductDCVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS2ProductDC", offerProductDCVO);
    }

    // 프로젝트 직접경비 등록
    public void insertOfferProfitPS2Expense(OfferExpenseVO offerExpenseVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS2Expense", offerExpenseVO);
    }

    // 실적집계 등록
    public void insertOfferProfitPS2Result(OfferResultVO offerResultVO) {
        mybatis.insert("OfferProfitMapper.insertOfferProfitPS2Result", offerResultVO);
    }

    /*
     * UPDATE
     */

    // 손익 기본 수정
    public void updateOfferProfitPS2(OfferVO offerVO) {
        mybatis.update("OfferProfitMapper.updateOfferProfitPS2", offerVO);
    }

    /*
     * DELETE
     */
    // 손익 기본 삭제
    public void deleteOfferProfitPS(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferProfitPS", offerVO);
    }

    // 손익 상품 삭제
    public void deleteOfferProfitPSProduct(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferProfitPSProduct", offerVO);
    }

    // 손익 할인정책 삭제
    public void deleteOfferProfitPSProductDC(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferProfitPSProductDC", offerVO);
    }

    // 프로젝트 경비 삭제
    public void deleteOfferProfitPSExpense(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferProfitPSExpense", offerVO);
    }

    // 손익 실적집계 삭제
    public void deleteOfferProfitPSResult(OfferVO offerVO) {
        mybatis.delete("OfferProfitMapper.deleteOfferProfitPSResult", offerVO);
    }

    public void updateOfferProfitStat(OfferVO offerVO) {
        mybatis.update("OfferProfitMapper.updateOfferProfitStat", offerVO);
    }

    //문서 title 구성
    public String selectApprovalTitle(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectApprovalTitle", offerVO);
    }


    // 수익보고 상세조회
    public List<ProfitReportVO> selectProfitReportInfo(OfferVO offerVO) {
        return mybatis.selectList("OfferProfitMapper.selectProfitReportInfo", offerVO);
    }

    //  수익보고 등록
    public void insertProfitReportInfo(ProfitReportVO profitReportVO) {
        mybatis.insert("OfferProfitMapper.insertProfitReportInfo", profitReportVO);
    }

    //  수익보고 전체삭제
    public void deleteProfitReportInfo(ProfitReportVO profitReportVO) {
        mybatis.delete("OfferProfitMapper.deleteProfitReportInfo", profitReportVO);
    }
    // 수익보고 key 생성
    public ProfitReportVO selectNewErnnRprtId() {
        return mybatis.selectOne("OfferProfitMapper.selectNewErnnRprtId");
    }

    // 수익보고 횟수 카운트 조회
    public Integer selectProfitReportCnt(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectProfitReportCnt",offerVO);
    }

    // 수익보고 횟수 카운트 조회
    public OfferVO selectProfitReportCntOption(OfferVO offerVO) {
        return mybatis.selectOne("OfferProfitMapper.selectProfitReportCntOption",offerVO);
    }


}
