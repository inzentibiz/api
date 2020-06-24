package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "bizChanceDAO")
public class BizChanceDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    public List<BizChanceVO> selectBizChanceView(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceView", bizChanceSearchVO);
    }

    public List<BizChanceAmountVO> selectBizChanceAmtList(BizChanceAmountVO bizChanceAmountVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceAmtList", bizChanceAmountVO);
    }

    public List<BizChancePersonVO> selectBizChanceNopList(BizChancePersonVO bizChancePersonVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceNopList", bizChancePersonVO);
    }

    public BizChanceVO selectBizChance(BizChanceVO bizChanceVO) throws Exception {
        return mybatis.selectOne("BizChanceMapper.selectBizChance", bizChanceVO);
    }
    public BizChanceVO selectMaxBoptId() throws Exception {
        return mybatis.selectOne("BizChanceMapper.selectMaxBoptId");
    }

    public List<BizChanceVO> selectBizChancePopupList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChancePopupList", bizChanceSearchVO);
    }

    public List<BizChanceHistoryVO> selectBizChanceHistoryWctList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceHistoryWctList", bizChanceSearchVO);
    }

    public List<BizChanceHistoryVO> selectBizChanceHistorySellList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceHistorySellList", bizChanceSearchVO);
    }

    public List<BizChanceHistoryVO> selectBizChanceHistoryBuyList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceHistoryBuyList", bizChanceSearchVO);
    }

    public List<BizChanceHistoryVO> selectBizChanceHistoryPncList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceHistoryPncList", bizChanceSearchVO);
    }

    public List<BizChanceVO> selectBizChanceSalesEmpList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceSalesEmpList", bizChanceSearchVO);
    }

    public List<BizChanceVO> selectBizChanceRelList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceRelList", bizChanceSearchVO);
    }

    public List<BizChanceVO> selectRlvnOfferProfitPSList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectRlvnOfferProfitPSList", bizChanceSearchVO);
    }

    public List<BizChanceVO> selectRlvnOfferProfitMAList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectRlvnOfferProfitMAList", bizChanceSearchVO);
    }
    public String selectPrjtTypeCd(String string) throws Exception {
        return mybatis.selectOne("BizChanceMapper.selectPrjtTypeCd", string);
    }

    /*
     * INSERT
     */

    public void insertBizChance(BizChanceVO bizChanceVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChance", bizChanceVO);
    }
    public void insertBizChanceHistory(BizChanceVO bizChanceVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceHistory", bizChanceVO);
    }

    public void insertBizChanceAmt(BizChanceAmountVO bizChanceAmountVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceAmt", bizChanceAmountVO);
    }

    public void insertBizChanceHistoryAmt(BizChanceAmountVO bizChanceAmountVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceHistoryAmt", bizChanceAmountVO);
    }

    public void insertBizChanceNop(BizChancePersonVO bizChancePersonVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceNop", bizChancePersonVO);
    }

    public void insertBizChanceHistoryNop(BizChancePersonVO bizChancePersonVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceHistoryNop", bizChancePersonVO);
    }

    public List<BizChanceVO> selectBizChanceList(BizChanceSearchVO bizChanceSearchVO) throws Exception {
        return mybatis.selectList("BizChanceMapper.selectBizChanceList", bizChanceSearchVO);
    }

    public List<ExcelBizChanceAmountVO> selectExcelDwnlBizChanceSellBuyList(BizChanceSearchVO bizChanceSearchVO) {
        return mybatis.selectList("BizChanceMapper.selectExcelDwnlBizChanceSellBuyList", bizChanceSearchVO);
    }

    public List<ExcelBizChanceVO> selectExcelDwnlBizChanceList(BizChanceSearchVO bizChanceSearchVO) {
        return mybatis.selectList("BizChanceMapper.selectExcelDwnlBizChanceList", bizChanceSearchVO);
    }

    public void insertBizChanceHistoryAmtSalesEmp(BizChanceVO bizChanceVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceHistoryAmtSalesEmp", bizChanceVO);
    }

    public void insertBizChanceHistoryNopSalesEmp(BizChanceVO bizChanceVO) throws Exception {
        mybatis.insert("BizChanceMapper.insertBizChanceHistoryNopSalesEmp", bizChanceVO);
    }

    public BizChanceVO selectBizChaneInfo(BizChanceVO bizChanceVO) {
        return mybatis.selectOne("BizChanceMapper.selectBizChaneInfo", bizChanceVO);
    }

    /*
     * UPDATE
     */

    public void updateBizChance(BizChanceVO bizChanceVO) {
        mybatis.update("BizChanceMapper.updateBizChance", bizChanceVO);
    }

    public void updateBizChanceSalesEmp(BizChanceVO bizChanceVO) {
        mybatis.update("BizChanceMapper.updateBizChanceSalesEmp", bizChanceVO);
    }
    public void updateBizChanceStatus(BizChanceVO bizChanceVO) {
        mybatis.update("BizChanceMapper.updateBizChanceStatus", bizChanceVO);
    }

    /*
     * DELETE
     */

    public void deleteBizChanceAmtAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceAmtAll", bizChanceVO);
    }

    public void deleteBizChanceNopAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceNopAll", bizChanceVO);
    }

    public void deleteBizChance(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChance", bizChanceVO);
    }

    public void deleteBizChanceHistoryAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistoryAll", bizChanceVO);
    }

    public void deleteBizChanceActivityAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceActivityAll", bizChanceVO);
    }

    public void deleteBizChanceHistoryAmtAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistoryAmtAll", bizChanceVO);
    }

    public void deleteBizChanceHistoryNopAll(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistoryNopAll", bizChanceVO);
    }

    public void deleteBizChanceHistory(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistory", bizChanceVO);
    }
    public void deleteBizChanceHistoryAmt(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistoryAmt", bizChanceVO);
    }
    public void deleteBizChanceHistoryNop(BizChanceVO bizChanceVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceHistoryNop", bizChanceVO);
    }

    public Integer selectBizChanceHistoryCount(BizChanceVO bizChanceVO) throws Exception {
        return mybatis.selectOne("BizChanceMapper.selectBizChanceHistoryCount", bizChanceVO);
    }

    // 영업활동내역

    public List<BizChanceActivityVO> selectBizChanceActivityList(BizChanceVO bizChanceVO) {
        return mybatis.selectList("BizChanceMapper.selectBizChanceActivityList", bizChanceVO);
    }

    public BizChanceActivityVO selectMaxSlsActId() {
        return mybatis.selectOne("BizChanceMapper.selectMaxSlsActId");
    }

    public void insertBizChanceActivity(BizChanceActivityVO bizChanceActivityVO) {
        mybatis.insert("BizChanceMapper.insertBizChanceActivity", bizChanceActivityVO);
    }

    public void updateBizChanceActivity(BizChanceActivityVO bizChanceActivityVO) {
        mybatis.update("BizChanceMapper.updateBizChanceActivity", bizChanceActivityVO);
    }

    public void deleteBizChanceActivity(BizChanceActivityVO bizChanceActivityVO) {
        mybatis.delete("BizChanceMapper.deleteBizChanceActivity", bizChanceActivityVO);
    }

}
