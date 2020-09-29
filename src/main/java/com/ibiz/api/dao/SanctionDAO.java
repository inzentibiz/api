package com.ibiz.api.dao;

import com.ibiz.api.model.ApprovalAuthorizerVO;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.CommonCodeMappingVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "sanctionDAO")
public class SanctionDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    private static final String MAPPER_PATH = "com.inzent.ibiz.svc.sanction.";

    public ApprovalVO selectSantNtcDstInfo(ApprovalVO approvalVO) {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectSantNtcDstInfo", approvalVO);
    }

    public ApprovalVO selectNewSantId()  {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectNewSantId");
    }

    public ApprovalVO selectSyncronizedPrgsStatCd(CommonCodeMappingVO commonCodeMappingVO)  {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectSyncronizedPrgsStatCd", commonCodeMappingVO);
    }
/*

    // 전체 결재자수와 결재를 수행한 결재자수 조회
    public ApprovalVO selectTotalAprnCntWithAppvCnt(ApprovalVO approvalVO) {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectTotalAprnCntWithAppvCnt", approvalVO);
    }
*/



    /*
     * INSERT
     */

    public void insertApprovalInfo(ApprovalVO approvalVO) {
        mybatis.insert(MAPPER_PATH + "SanctionMapper.insertApprovalInfo", approvalVO);
    }

    public void insertApprovalAuthorizer(ApprovalAuthorizerVO approvalAuthorizerVO) {
        mybatis.insert(MAPPER_PATH + "SanctionMapper.insertApprovalAuthorizer", approvalAuthorizerVO);
    }

    /*
     * UPDATE
     */

    public void updateApprovalInfo(ApprovalVO approvalVO) {
        mybatis.update(MAPPER_PATH + "SanctionMapper.updateApprovalInfo", approvalVO);
    }

    public void updateApprovalState(ApprovalVO approvalVO) {
        mybatis.update(MAPPER_PATH + "SanctionMapper.updateApprovalState", approvalVO);
    }

    /*
     * DELTE
     */

    public void deleteApprovalInfo(ApprovalVO approvalVO) {
        mybatis.delete(MAPPER_PATH + "SanctionMapper.deleteApprovalInfo", approvalVO);
    }

    public void deleteApprovalAuthorizer(ApprovalVO approvalVO) {
        mybatis.delete(MAPPER_PATH + "SanctionMapper.deleteApprovalAuthorizer", approvalVO);
    }


}
