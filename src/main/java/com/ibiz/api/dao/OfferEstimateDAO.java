package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "offerEstimateDAO")
public class OfferEstimateDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /* 견적서 리스트 조회*/
    public List<EstimateVO> selectOfferEstimateList(EstimateVO estimateVO) throws Exception {
        return mybatis.selectList("OfferEstimateMapper.selectOfferEstimateList", estimateVO);
    }

    /* 견적서 상세 조회*/
    public EstimateVO selectOfferEstimate(String string) {
        return mybatis.selectOne("OfferEstimateMapper.selectOfferEstimate", string);
    }

    /* 견적서 발신인 상세 조회*/
    public EstimateVO selectEstimateTrnrInfo(String string) {
        return mybatis.selectOne("OfferEstimateMapper.selectEstimateTrnrInfo", string);
    }

    /* 견적서 대표 조회*/
    public EstimateVO selectEstimateRprsInfo(String string) {
        return mybatis.selectOne("OfferEstimateMapper.selectEstimateRprsInfo", string);
    }

    /* 예상손익 견적내역 조회*/
    public List<EstimateProductPSVO> selectEstimateBkdnList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectEstimateBkdnList", string);
    }

    /* 예상손익 견적내역 유지보수 조회*/
    public List<EstimateProductMAVO> selectEstimateMABkdnList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectEstimateMABkdnList", string);
    }

    /* 예상손익 견적내역 유지보수 서비스 조회*/
    public List<EstimateMAServiceVO> selectEstimateMAServiceBkdnList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectEstimateMAServiceBkdnList", string);
    }

    /* 견적서 상품 상세 조회*/
    public List<EstimateProductPSVO> selectOfferEstimatePSList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectOfferEstimatePSList", string);
    }

    /* 견적서 유지보수 상세 조회*/
    public List<EstimateProductMAVO> selectOfferEstimateMAList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectOfferEstimateMAList", string);
    }

    /* 견적서 유지보수 서비스 상세 조회*/
    public List<EstimateMAServiceVO> selectOfferEstimateMAServiceList(String string) {
        return mybatis.selectList("OfferEstimateMapper.selectOfferEstimateMAServiceList", string);
    }


    /* 예상손익 상태*/
    public EstimateVO selectEstimateFcstPalPrgsStatCd(EstimateVO estimateVO) {
        return mybatis.selectOne("OfferEstimateMapper.selectEstimateFcstPalPrgsStatCd", estimateVO);
    }

    public EstimateVO selectMaxEstiId() {
        return mybatis.selectOne("OfferEstimateMapper.selectMaxEstiId");
    }

    public EstimateVO selectEstiMaxDocNo(EstimateVO estimateVO) {
        return mybatis.selectOne("OfferEstimateMapper.selectEstiMaxDocNo", estimateVO);
    }

    /* 견적서 프로젝트 유형 조회*/
    public EstimateVO selectEstimatePrjtTypeCd(EstimateVO estimateVO) {
        return mybatis.selectOne("OfferEstimateMapper.selectEstimatePrjtTypeCd", estimateVO);
    }

    /* 견적서 상태 조회*/
    public EstimateVO selectOfferEstimateStat(EstimateVO estimateVO) {
        return mybatis.selectOne("OfferEstimateMapper.selectOfferEstimateStat", estimateVO);
    }

    public Integer selectIsExistsOfferEstimate(EstimateVO estimateVO) {
        return mybatis.selectOne("OfferEstimateMapper.selectIsExistsOfferEstimate", estimateVO);
    }

    /* 견적서 등록*/
    public void insertOfferEstimate(EstimateVO estimateVO) {
        mybatis.insert("OfferEstimateMapper.insertOfferEstimate", estimateVO);
    }

    /* 견적서 상품등록(pns)*/
    public void insertOfferEstimatePS(EstimateProductPSVO estimateProductPSVO) {
        mybatis.insert("OfferEstimateMapper.insertOfferEstimatePS", estimateProductPSVO);
    }

    /* 견적서 유지보수 등록(ma)*/
    public void insertOfferEstimateMA(EstimateVO estimateVO) {
        mybatis.insert("OfferEstimateMapper.insertOfferEstimateMA", estimateVO);
    }

    /* 견적서 유지보수 서비스 등록(ma)*/
    public void insertOfferEstimateMAService(EstimateMAServiceVO estimateMAServiceVO) {
        mybatis.insert("OfferEstimateMapper.insertOfferEstimateMAService", estimateMAServiceVO);
    }

    /* 견적서 수정*/
    public void updateOfferEstimate(EstimateVO estimateVO) {
        mybatis.update("OfferEstimateMapper.updateOfferEstimate", estimateVO);
    }

    /* 견적서 상태 업데이트*/
    public void updateOfferEstimateIssue(EstimateVO estimateVO) {
        mybatis.update("OfferEstimateMapper.updateOfferEstimateIssue", estimateVO);
    }

    /* 견적서 삭제*/
    public void deleteOfferEstimate(EstimateVO estimateVO) {
        mybatis.delete("OfferEstimateMapper.deleteOfferEstimate", estimateVO);
    }

    /* 견적서 상품 삭제*/
    public void deleteOfferEstimatePS(EstimateVO estimateVO) {
        mybatis.delete("OfferEstimateMapper.deleteOfferEstimatePS", estimateVO);
    }

    /* 견적서 유지보수 삭제*/
    public void deleteOfferEstimateMA(EstimateVO estimateVO) {
        mybatis.delete("OfferEstimateMapper.deleteOfferEstimateMA", estimateVO);
    }

    /* 견적서 유지보수 서비스 삭제*/
    public void deleteOfferEstimateMAService(EstimateVO estimateVO) {
        mybatis.delete("OfferEstimateMapper.deleteOfferEstimateMAService", estimateVO);
    }

}
