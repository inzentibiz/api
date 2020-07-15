package com.ibiz.api.dao;

import com.ibiz.api.model.ApprovalAuthorizerVO;
import com.ibiz.api.model.ApprovalVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "draftDao")
public class DraftDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    public ApprovalVO selectSantNtcDstInfo(ApprovalVO approvalVO) {
        return mybatis.selectOne("DraftMapper.selectSantNtcDstInfo", approvalVO);
    }

    public void updateApprovalState(ApprovalVO approvalVO) {
        mybatis.update("DraftMapper.updateApprovalState", approvalVO);
    }

    public ApprovalVO selectMaxSantId() {
        return mybatis.selectOne("DraftMapper.selectMaxSantId");
    }

    /*
     * INSERT
     */

    public void insertApprovalDraft(ApprovalVO approvalVO) {
        mybatis.insert("DraftMapper.insertApprovalDraft", approvalVO);
    }

    public void insertApprovalAuthorizer(ApprovalAuthorizerVO approvalAuthorizerVO) {
        mybatis.insert("DraftMapper.insertApprovalAuthorizer", approvalAuthorizerVO);
    }

    /*
     * UPDATE
     */

    public void updateApprovalDraft(ApprovalVO approvalVO) {
        mybatis.update("DraftMapper.updateApprovalDraft", approvalVO);
    }

    /*
     * DELTE
     */

    public void deleteApprovalDraft(ApprovalVO approvalVO) {
        mybatis.delete("DraftMapper.deleteApprovalDraft", approvalVO);
    }

    public void deleteApprovalAuthorizer(ApprovalVO approvalVO) {
        mybatis.delete("DraftMapper.deleteApprovalAuthorizer", approvalVO);
    }


}
