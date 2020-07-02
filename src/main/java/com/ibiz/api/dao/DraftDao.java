package com.ibiz.api.dao;

import com.ibiz.api.model.ApprovalAuthorizerVO;
import com.ibiz.api.model.ApprovalVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "draftDao")
public class DraftDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    public ApprovalVO selectSantNtcDstInfo(ApprovalVO approvalVO) {
        return mybatis.selectOne("DraftMapper.Select_santNtcDstInfo", approvalVO);
    }

    public void updateApprovalState(ApprovalVO approvalVO) {
        mybatis.update("DraftMapper.Update_approvalState", approvalVO);
    }

    public ApprovalVO selectMaxSantId() {
        return mybatis.selectOne("DraftMapper.Select_maxSantId");
    }

    /*
     * INSERT
     */

    public void insertDraft(ApprovalVO approvalVO) {
        mybatis.insert("DraftMapper.Insert_draft", approvalVO);
    }

    public void insertApprover(ApprovalAuthorizerVO approvalAuthorizerVO) {
        mybatis.insert("DraftMapper.Insert_approver", approvalAuthorizerVO);
    }

    /*
     * UPDATE
     */

    public void updateDraft(ApprovalVO approvalVO) {
        mybatis.update("DraftMapper.Update_draft", approvalVO);
    }

    /*
     * DELTE
     */

    public void deleteDraft(ApprovalVO approvalVO) {
        mybatis.delete("DraftMapper.Delete_draft", approvalVO);
    }

    public void deleteDraftDetail(ApprovalVO approvalVO) {
        mybatis.delete("DraftMapper.Delete_draftDetail", approvalVO);
    }

    public void deleteApproverList(ApprovalVO approvalVO) {
        mybatis.delete("DraftMapper.Delete_approverList", approvalVO);
    }

}
