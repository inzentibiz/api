package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "projectVRBDao")
public class ProjectVRBDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT
     */

    public VRBVO selectVrbAnlyId(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_vrbAnlyId", vrbVO);
    }

    public VRBVO selectVrbInfoByAnlyId(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_vrbInfoByAnlyId", vrbVO);
    }

    public List<VRBProfitAnalysisDetailVO> selectProfitAnalysisDetailForVRBList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_profitAnalysisDetailForVRBList", vrbVO);
    }

    public ProfitValueAnalysisVO selectProfitAnalysisForVRB(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_profitAnalysisForVRB", vrbVO);
    }

    public String selectDraftVRBDocTitl(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_draftVRBDocTitl", vrbVO);
    }

    public List<VRBVO> selectVRBAnalysisHistoryList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBAnalysisHistoryList", vrbVO);
    }

    public List<CommonGroupVO> selectVRBAnlyItmCdList(CommonGroupVO commonGroupVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBAnlyItmCdList", commonGroupVO);
    }

    public VRBVO selectMaxVRBAnlyId() {
        return mybatis.selectOne("ProjectVRBMapper.Select_maxVRBAnlyId");
    }

    public VRBVO selectMaxDocNo(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_maxDocNo", vrbVO);
    }

    public VRBVO selectVRB(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_VRB", vrbVO);
    }

    public VRBVO selectPrjtIdAndVrbAnlyId(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_PrjtIdAndVrbAnlyId", vrbVO);
    }

    public ProjectVO selectVRBProject(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_VRBProject", vrbVO);
    }

    public List<VRBBizOpportunityVO> selectVRBBusinessOpportunityListForView(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBBusinessOpportunityListForView", vrbVO);
    }

    public List<VRBBizOpportunityVO> selectVRBBusinessOpportunityList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBBusinessOpportunityList", vrbVO);
    }

    public List<VRBCustomerAnalysisVO> selectVRBCustomerAnlaysisList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBCustomerAnlaysisList", vrbVO);
    }

    public List<VRBBusinessAnalysisVO> selectVRBBusinessAnalysisList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBBusinessAnalysisList", vrbVO);
    }

    public List<VRBCompetitorAnalysisVO> selectVRBCompetitorAnalysisList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBCompetitorAnalysisList", vrbVO);
    }

    public List<VRBParticipantVO> selectVRBInvestigationResultList(VRBVO vrbVO) {
        return mybatis.selectList("ProjectVRBMapper.Select_VRBInvestigationResultList", vrbVO);
    }

    public VRBVO selectVrbPrgsStatCd(VRBVO vrbVO) {
        return mybatis.selectOne("ProjectVRBMapper.Select_VrbPrgsStatCd", vrbVO);
    }
    /*
     * INSERT
     */

    public void insertEstimateIntoVrbProfitAnalysisDetail(VRBProfitAnalysisDetailVO vrbProfitAnalysisDetailVO) {
        mybatis.insert("ProjectVRBMapper.Insert_EstimateIntoVrbProfitAnalysisDetail", vrbProfitAnalysisDetailVO);
    }

    public void insertVRB(VRBVO vrbVO) {
        mybatis.insert("ProjectVRBMapper.Insert_VRB", vrbVO);
    }

    public void insertVRBCustomerAnalysis(VRBCustomerAnalysisVO vrbCustomerAnalysisVO) {
        mybatis.insert("ProjectVRBMapper.Insert_VRBCustomerAnalysis", vrbCustomerAnalysisVO);
    }

    public void insertVRBCompetitorAnalysis(VRBCompetitorAnalysisVO vrbCompetitorAnalysisVO) {
        mybatis.insert("ProjectVRBMapper.Insert_VRBCompetitorAnalysis", vrbCompetitorAnalysisVO);
    }

    public void insertVRBInvestigationResult(VRBParticipantVO vrbParticipantVO) {
        mybatis.insert("ProjectVRBMapper.Insert_VRBInvestigationResult", vrbParticipantVO);
    }

    public void insertVRBBusinessAnalysis(VRBBusinessAnalysisVO vrbBusinessAnalysisVO) {
        mybatis.insert("ProjectVRBMapper.Insert_VRBBusinessAnalysis", vrbBusinessAnalysisVO);
    }

    /*
     * UPDATE
     */

    public void updateVRB(VRBVO vrbVO) {
        mybatis.update("ProjectVRBMapper.Update_VRB", vrbVO);
    }

    public void updateVRBBusinessAnalysis(VRBBusinessAnalysisVO vrbBusinessAnalysisVO) {
        mybatis.update("ProjectVRBMapper.Update_VRBBusinessAnalysis", vrbBusinessAnalysisVO);
    }

    public void updateVrbPrgsStatCd(VRBVO vrbVO) {
        mybatis.update("ProjectVRBMapper.Update_VrbPrgsStatCd", vrbVO);
    }

    /*
     * DELETE
     */

    public void deleteVRB(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VRB", vrbVO);
    }

    public void deleteVrbProfitAnalysisDetail(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VrbProfitAnalysisDetail", vrbVO);
    }

    public void deleteVRBCustomerAnalysis(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VRBCustomerAnalysis", vrbVO);
    }

    public void deleteVRBBusinessAnalysis(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VRBBusinessAnalysis", vrbVO);
    }

    public void deleteVRBCompetitorAnalysis(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VRBCompetitorAnalysis", vrbVO);
    }

    public void deleteVRBInvestigationResult(VRBVO vrbVO) {
        mybatis.delete("ProjectVRBMapper.Delete_VRBInvestigationResult", vrbVO);
    }

}
