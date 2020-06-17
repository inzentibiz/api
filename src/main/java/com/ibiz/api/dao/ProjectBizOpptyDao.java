package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "projectBizOpptyDao")
public class ProjectBizOpptyDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    public List<BizOpportunityVO> selectBizOpportunityDetailList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityDetailList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityAmtVO> selectBizOpportunityAmtList(BizOpportunityAmtVO bizOpportunityAmtVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityAmtList", bizOpportunityAmtVO);
    }

    public List<BizOpportunityNopVO> selectBizOpportunityNopList(BizOpportunityNopVO bizOpportunityNopVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityNopList", bizOpportunityNopVO);
    }

    public BizOpportunityVO selectBizOpportunityDetail(BizOpportunityVO bizOpportunityVO) throws Exception {
        return mybatis.selectOne("BizOpptyMapper.Select_bizOpportunityDetail", bizOpportunityVO);
    }
    public BizOpportunityVO selectMaxBoptId() throws Exception {
        return mybatis.selectOne("BizOpptyMapper.Select_maxBoptId");
    }

    public List<BizOpportunityVO> selectBusinessOpportunitySearchList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_businessOpportunitySearchList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityHistoryVO> selectBizOpportunityHistoryWctList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityHistoryWctList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityHistoryVO> selectBizOpportunityHistorySellList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityHistorySellList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityHistoryVO> selectBizOpportunityHistoryBuyList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityHistoryBuyList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityHistoryVO> selectBizOpportunityHistoryPncList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityHistoryPncList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityVO> selectBizOpportunityForSlsEmpTransferList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityForSlsEmpTransferList", bizOpportunitySearchVO);
    }

    public List<BizOpportunityVO> selectAssociatedBizOpportunity(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_AssociatedBizOpportunity", bizOpportunitySearchVO);
    }

    public List<BizOpportunityVO> selectApplicablePnsProfitAnalysis(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_ApplicablePnsProfitAnalysis", bizOpportunitySearchVO);
    }

    public List<BizOpportunityVO> selectApplicableMAProfitAnalysis(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_ApplicableMAProfitAnalysis", bizOpportunitySearchVO);
    }
    public String selectPrjtTypeCd(String string) throws Exception {
        return mybatis.selectOne("BizOpptyMapper.Select_PrjtTypeCd", string);
    }

    /*
     * INSERT
     */

    public void insertBizOpportunity(BizOpportunityVO bizOpportunityVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunity", bizOpportunityVO);
    }
    public void insertBizOpportunityHistory(BizOpportunityVO bizOpportunityVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityHistory",bizOpportunityVO);
    }

    public void insertBizOpportunityAmt(BizOpportunityAmtVO bizOpportunityAmtVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityAmt", bizOpportunityAmtVO);
    }

    public void insertBizOpportunityAmtHistory(BizOpportunityAmtVO bizOpportunityAmtVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityAmtHistory", bizOpportunityAmtVO);
    }

    public void insertBizOpportunityNop(BizOpportunityNopVO bizOpportunityNopVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityNop", bizOpportunityNopVO);
    }

    public void insertBizOpportunityNopHistory(BizOpportunityNopVO bizOpportunityNopVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityNopHistory", bizOpportunityNopVO);
    }

    public List<BizOpportunityVO> selectBizOpportunityList(BizOpportunitySearchVO bizOpportunitySearchVO) throws Exception {
        return mybatis.selectList("BizOpptyMapper.Select_businessOpportunityList", bizOpportunitySearchVO);
    }

    public List<ExcelBizOpportunityDetailVO> selectBizOpportunityDetailListForExcel(BizOpportunitySearchVO bizOpportunitySearchVO) {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityDetailListForExcel", bizOpportunitySearchVO);
    }

    public List<ExcelBizOpportunityVO> selectBizOpportunityListForExcel(BizOpportunitySearchVO bizOpportunitySearchVO) {
        return mybatis.selectList("BizOpptyMapper.Select_bizOpportunityListForExcel", bizOpportunitySearchVO);
    }

    public void insertBizOpportunityAmtTransferHistory(BizOpportunityVO bizOpportunityVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityAmtTransferHistory", bizOpportunityVO);
    }

    public void insertBizOpportunityNopTransferHistory(BizOpportunityVO bizOpportunityVO) throws Exception {
        mybatis.insert("BizOpptyMapper.Insert_bizOpportunityNopTransferHistory", bizOpportunityVO);
    }

    public BizOpportunityVO selectBizOpportunityInfo(BizOpportunityVO bizOpportunityVO) {
        return mybatis.selectOne("BizOpptyMapper.Select_BizOpportunityInfo", bizOpportunityVO);
    }

    /*
     * UPDATE
     */

    public void updateBizOpportunity(BizOpportunityVO bizOpportunityVO) {
        mybatis.update("BizOpptyMapper.Update_bizOpportunity", bizOpportunityVO);
    }

    public void updateBizOpportunitySlsInfo(BizOpportunityVO bizOpportunityVO) {
        mybatis.update("BizOpptyMapper.Update_BizOpportunitySlsInfo", bizOpportunityVO);
    }
    public void updateBizOpportunityStat(BizOpportunityVO bizOpportunityVO) {
        mybatis.update("BizOpptyMapper.Update_bizOpportunityStat", bizOpportunityVO);
    }

    /*
     * DELETE
     */

    public void deleteAllBizOpportunityAmt(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allBizOpportunityAmt", bizOpportunityVO);
    }

    public void deleteAllBizOpportunityNop(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allBizOpportunityNop", bizOpportunityVO);
    }

    public void deleteBizOpportunity(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_bizOpportunity", bizOpportunityVO);
    }

    public void deleteAllBizOpportunityHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allBizOpportunityHistory", bizOpportunityVO);
    }

    public void deleteAllSalesActivity(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allSalesActivity", bizOpportunityVO);
    }

    public void deleteAllBizOpportunityAmtHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allBizOpportunityAmtHistory", bizOpportunityVO);
    }

    public void deleteAllBizOpportunityNopHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_allBizOpportunityNopHistory", bizOpportunityVO);
    }

    public Integer selectBusinessOpportunityHistoryCount(BizOpportunityVO bizOpportunityVO) throws Exception {
        return mybatis.selectOne("BizOpptyMapper.Select_BusinessOpportunityHistoryCount", bizOpportunityVO);
    }

    public void deleteBizOpportunityHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_BizOpportunityHistory", bizOpportunityVO);
    }
    public void deleteBizOpportunityAmtHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_BizOpportunityAmtHistory", bizOpportunityVO);
    }
    public void deleteBizOpportunityNopHistory(BizOpportunityVO bizOpportunityVO) {
        mybatis.delete("BizOpptyMapper.Delete_BizOpportunityNopHistory", bizOpportunityVO);
    }

}
