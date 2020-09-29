package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "vrbAnalysisDAO")
public class VRBAnalysisDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    public VRBAnalysisVO selectVRBAnlyId(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBAnlyId", vrbAnalysisVO);
    }

    public VRBAnalysisVO selectRlvnVRBAnalysis(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectRlvnVRBAnalysis", vrbAnalysisVO);
    }

    public List<VRBProfitVO> selectVRBAnalysisErnnAnlyList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBAnalysisErnnAnlyList", vrbAnalysisVO);
    }

    public ProfitValueAnalysisVO selectVRBAnalysisErnnAnly(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBAnalysisErnnAnly", vrbAnalysisVO);
    }

    /*public String selectDraftVRBAnalysisTitle(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectDraftVRBAnalysisTitle", vrbAnalysisVO);
    }*/

    public List<VRBAnalysisVO> selectVRBAnalysisList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBAnalysisList", vrbAnalysisVO);
    }

    public List<CommonGroupCodeVO> selectVRBAnlyItmCdList(CommonGroupCodeVO commonGroupCodeVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBAnlyItmCdList", commonGroupCodeVO);
    }

    public VRBAnalysisVO selectNewVrbAnlyId() {
        return mybatis.selectOne("VRBAnalysisMapper.selectNewVrbAnlyId");
    }

    /*
    public VRBAnalysisVO selectMaxVRBAnlyId() {
        return mybatis.selectOne("VRBAnalysisMapper.selectMaxVRBAnlyId");
    }
*/
    public VRBAnalysisVO selectVRBAnalysisMaxDocNo(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBAnalysisMaxDocNo", vrbAnalysisVO);
    }

    public VRBAnalysisVO selectVRBAnalysis(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBAnalysis", vrbAnalysisVO);
    }

    public VRBAnalysisVO selectPrjtIdAndVrbAnlyId(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectPrjtIdAndVrbAnlyId", vrbAnalysisVO);
    }

    public ProjectVO selectVRBAnalysisProject(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBAnalysisProject", vrbAnalysisVO);
    }

    public List<VRBBizChanceVO> selectVRBAnalysisBizChanceListForView(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBAnalysisBizChanceListForView", vrbAnalysisVO);
    }

    public List<VRBBizChanceVO> selectVRBAnalysisBizChanceList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBAnalysisBizChanceList", vrbAnalysisVO);
    }

    public List<VRBCustomerVO> selectVRBCustomerList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBCustomerList", vrbAnalysisVO);
    }

    public List<VRBStrategyVO> selectVRBStrategyList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBStrategyList", vrbAnalysisVO);
    }

    public List<VRBCompetitorVO> selectVRBCompetitorList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBCompetitorList", vrbAnalysisVO);
    }

    public List<VRBOpinionVO> selectVRBOpinionList(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectList("VRBAnalysisMapper.selectVRBOpinionList", vrbAnalysisVO);
    }

    public VRBAnalysisVO selectVRBPrgsStatCd(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectVRBPrgsStatCd", vrbAnalysisVO);
    }
    /*
     * INSERT
     */

    public void insertOfferProfitIntoVrbAnalysis(VRBProfitVO vrbProfitVO) {
        mybatis.insert("VRBAnalysisMapper.insertOfferProfitIntoVrbAnalysis", vrbProfitVO);
    }

    public void insertVRBAnalysis(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.insert("VRBAnalysisMapper.insertVRBAnalysis", vrbAnalysisVO);
    }

    public void insertVRBCustomer(VRBCustomerVO vrbCustomerVO) {
        mybatis.insert("VRBAnalysisMapper.insertVRBCustomer", vrbCustomerVO);
    }

    public void insertVRBCompetitor(VRBCompetitorVO vrbCompetitorVO) {
        mybatis.insert("VRBAnalysisMapper.insertVRBCompetitor", vrbCompetitorVO);
    }

    public void insertVRBOpinion(VRBOpinionVO vrbOpinionVO) {
        mybatis.insert("VRBAnalysisMapper.insertVRBOpinion", vrbOpinionVO);
    }

    public void insertVRBStrategy(VRBStrategyVO vrbStrategyVO) {
        mybatis.insert("VRBAnalysisMapper.insertVRBStrategy", vrbStrategyVO);
    }

    /*
     * UPDATE
     */

    public void updateVRBAnalysis(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.update("VRBAnalysisMapper.updateVRBAnalysis", vrbAnalysisVO);
    }

    public void updateVRBStrategy(VRBStrategyVO vrbStrategyVO) {
        mybatis.update("VRBAnalysisMapper.updateVRBStrategy", vrbStrategyVO);
    }

    public void updateVrbPrgsStatCd(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.update("VRBAnalysisMapper.updateVrbPrgsStatCd", vrbAnalysisVO);
    }

    /*
     * DELETE
     */

    public void deleteVRBAnalysis(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBAnalysis", vrbAnalysisVO);
    }

    public void deleteVRBProfit(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBProfit", vrbAnalysisVO);
    }

    public void deleteVRBCustomer(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBCustomer", vrbAnalysisVO);
    }

    public void deleteVRBStrategy(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBStrategy", vrbAnalysisVO);
    }

    public void deleteVRBCompetitor(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBCompetitor", vrbAnalysisVO);
    }

    public void deleteVRBOpinion(VRBAnalysisVO vrbAnalysisVO) {
        mybatis.delete("VRBAnalysisMapper.deleteVRBOpinion", vrbAnalysisVO);
    }

    public String selectApprovalTitle(VRBAnalysisVO vrbAnalysisVO) {
        return mybatis.selectOne("VRBAnalysisMapper.selectApprovalTitle", vrbAnalysisVO);
    }
}
