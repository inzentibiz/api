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

   /* public ApprovalVO selectMaxSantId() {
        return mybatis.selectOne("SanctionMapper.selectMaxSantId");
    }*/

    public ApprovalVO selectNewSantId()  {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectNewSantId");
    }

    public ApprovalVO selectSyncronizedPrgsStatCd(CommonCodeMappingVO commonCodeMappingVO)  {
        return mybatis.selectOne(MAPPER_PATH + "SanctionMapper.selectSyncronizedPrgsStatCd", commonCodeMappingVO);
    }





    /*
     * INSERT
     */

    public void insertApprovalDraft(ApprovalVO approvalVO) {
        mybatis.insert(MAPPER_PATH + "SanctionMapper.insertApprovalDraft", approvalVO);
    }

    public void insertApprovalAuthorizer(ApprovalAuthorizerVO approvalAuthorizerVO) {
        mybatis.insert(MAPPER_PATH + "SanctionMapper.insertApprovalAuthorizer", approvalAuthorizerVO);
    }

    /*
     * UPDATE
     */

    public void updateApprovalDraft(ApprovalVO approvalVO) {
        mybatis.update(MAPPER_PATH + "SanctionMapper.updateApprovalDraft", approvalVO);
    }

    public void updateApprovalState(ApprovalVO approvalVO) {
        mybatis.update(MAPPER_PATH + "SanctionMapper.updateApprovalState", approvalVO);
    }

    /*
     * DELTE
     */

    public void deleteApprovalDraft(ApprovalVO approvalVO) {
        mybatis.delete(MAPPER_PATH + "SanctionMapper.deleteApprovalDraft", approvalVO);
    }

    public void deleteApprovalAuthorizer(ApprovalVO approvalVO) {
        mybatis.delete(MAPPER_PATH + "SanctionMapper.deleteApprovalAuthorizer", approvalVO);
    }


}
