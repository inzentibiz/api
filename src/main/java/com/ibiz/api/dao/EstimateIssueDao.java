package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "estimateIssueDao")
public class EstimateIssueDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /* 견적서 리스트 조회*/
    public List<EstiIssueVO> selectEstimateHistoryList(EstiIssueVO estiIssueVO) throws Exception {
        return mybatis.selectList("EstimateIssueMapper.Select_estimateHistoryList", estiIssueVO);
    }

    /* 견적서 상세 조회*/
    public EstiIssueVO selectEstimateIssueDetail(String string) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateIssueDetail", string);
    }

    /* 견적서 발신인 상세 조회*/
    public EstiIssueVO selectEstimateIssueTrsmtInfo(String string) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateIssueTrsmtInfo", string);
    }

    /* 견적서 대표 조회*/
    public EstiIssueVO selectEstimateIssueCustomerDetail(String string) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateIssueCustomerDetail", string);
    }

    /* 예상손익 견적내역 조회*/
    public List<EstiProductVO> selectProfitAnalysis(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_ProfitAnalysis", string);
    }

    /* 예상손익 견적내역 유지보수 조회*/
    public List<EstiIssueMAVO> selectProfitAnalysisMA(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_ProfitAnalysisMA", string);
    }

    /* 예상손익 견적내역 유지보수 서비스 조회*/
    public List<EstiIssueMAServiceVO> selectProfitAnalysisMAService(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_ProfitAnalysisMAService", string);
    }

    /* 견적서 상품 상세 조회*/
    public List<EstiProductVO> selectEstimateDetail(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_estimateDetail", string);
    }

    /* 견적서 유지보수 상세 조회*/
    public List<EstiIssueMAVO> selectEstimateIssueMAList(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_estimateIssueMAList", string);
    }

    /* 견적서 유지보수 서비스 상세 조회*/
    public List<EstiIssueMAServiceVO> selectEstimateIssueMAServiceList(String string) {
        return mybatis.selectList("EstimateIssueMapper.Select_estimateIssueMAServiceList", string);
    }


    /* 예상손익 상태*/
    public EstiIssueVO selectEstimateIssueFcstPalPrgsStatCd(EstiIssueVO estiIssueVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateIssueFcstPalPrgsStatCd", estiIssueVO);
    }

    public EstiIssueVO selectMaxEstiIssueId() {
        return mybatis.selectOne("EstimateIssueMapper.Select_maxEstiId");
    }

    public EstiIssueVO selectMaxDocNo(EstiIssueVO estiIssueVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_maxDocNo", estiIssueVO);
    }

    /* 견적서 프로젝트 유형 조회*/
    public EstiIssueVO selectEstimateIssuePrjtTypeCd(EstiIssueVO estiIssueVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_estimateIssuePrjtTypeCd", estiIssueVO);
    }

    /* 견적서 상태 조회*/
    public EstiIssueVO selectEstimateIssueStatCd(EstiIssueVO estiIssueVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_EstimateIssueStatCd", estiIssueVO);
    }

    public Integer selectIsExistEstimateIssue(EstiIssueVO estiIssueVO) {
        return mybatis.selectOne("EstimateIssueMapper.Select_IsExistEstimateIssue", estiIssueVO);
    }

    /* 견적서 등록*/
    public void insertEstimateIssue(EstiIssueVO estiIssueVO) {
        mybatis.insert("EstimateIssueMapper.Insert_estimateIssue", estiIssueVO);
    }

    /* 견적서 상품등록(pns)*/
    public void insertEstimateIssueProductAll(EstiProductVO estiProductVO) {
        mybatis.insert("EstimateIssueMapper.Insert_estimateIssueProductAll", estiProductVO);
    }

    /* 견적서 유지보수 등록(ma)*/
    public void insertEstimateIssueMaDetail(EstiIssueVO estiIssueVO) {
        mybatis.insert("EstimateIssueMapper.Insert_estimateIssueMaDetail", estiIssueVO);
    }

    /* 견적서 유지보수 서비스 등록(ma)*/
    public void insertEstimateIssueMaServiceDetail(EstiIssueMAServiceVO estiIssueMAServiceVO) {
        mybatis.insert("EstimateIssueMapper.Insert_estimateIssueMaServiceDetail", estiIssueMAServiceVO);
    }

    /* 견적서 수정*/
    public void updateEstimateIssue(EstiIssueVO estiIssueVO) {
        mybatis.update("EstimateIssueMapper.Update_estimateIssue", estiIssueVO);
    }

    /* 견적서 상태 업데이트*/
    public void updateEstimateIssueStatCd(EstiIssueVO estiIssueVO) {
        mybatis.update("EstimateIssueMapper.Update_estimateIssueStatCd", estiIssueVO);
    }

    /* 견적서 삭제*/
    public void deleteEstimateIssue(EstiIssueVO estiIssueVO) {
        mybatis.delete("EstimateIssueMapper.Delete_estimateIssue", estiIssueVO);
    }

    /* 견적서 상품 삭제*/
    public void deleteEstimateIssueProduct(EstiIssueVO estiIssueVO) {
        mybatis.delete("EstimateIssueMapper.Delete_estimateIssueProduct", estiIssueVO);
    }

    /* 견적서 유지보수 삭제*/
    public void deleteEstimateIssueMA(EstiIssueVO estiIssueVO) {
        mybatis.delete("EstimateIssueMapper.Delete_estimateIssueMA", estiIssueVO);
    }

    /* 견적서 유지보수 서비스 삭제*/
    public void deleteEstimateIssueMAService(EstiIssueVO estiIssueVO) {
        mybatis.delete("EstimateIssueMapper.Delete_estimateIssueMAService", estiIssueVO);
    }

}
