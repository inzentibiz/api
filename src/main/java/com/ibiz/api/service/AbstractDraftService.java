package com.ibiz.api.service;

import com.ibiz.api.dao.SanctionDAO;
import com.ibiz.api.exception.ApprovalSaveException;
import com.ibiz.api.exception.ApprovalStateException;
import com.ibiz.api.exception.DeleteDeniedException;
import com.ibiz.api.exception.UpdateDeniedException;
import com.ibiz.api.model.ApprovalAuthorizerVO;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.AttachVO;
import com.ibiz.api.model.CommonCodeMappingVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
public class AbstractDraftService extends AbstractWebService {

    @Resource(name = "sanctionDAO")
    private SanctionDAO sanctionDAO;

    @Transactional
    protected ApprovalVO selectApprovalInfo(String santId) {
        ApprovalVO approvalVO = new ApprovalVO();
        approvalVO.setSantId(santId);

        return sanctionDAO.selectSantNtcDstInfo(approvalVO);
    }

    @Transactional
    public static String generateDocId(int sequenceSize, String prevId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        Date currentTime = new Date();
        String currDate = simpleDateFormat.format(currentTime);
        int nextSequence;

        String prevDocDate = prevId.split("-")[2];
        String prevSequence = prevId.split("-")[3];
        if (currDate.equals(prevDocDate.substring(0, 8))) {
            nextSequence = Integer.parseInt(prevSequence) + 1;
        } else {
            nextSequence = 1;
        }

        String Sequenceformat = "%0"+ Integer.toString(sequenceSize)+ "d";
        String prevIbizDoc = prevId.split("-")[0]+"-"+ prevId.split("-")[1];

        return prevIbizDoc +"-"+ currDate +"-"+ String.format(Sequenceformat, nextSequence);
    }

    @Transactional
    protected String insertApprovalDraft(ApprovalVO approvalVO) throws ApprovalSaveException {

        try{
            approvalVO.setSantPrgsStatCd("A");
            approvalVO.setSantId(sanctionDAO.selectNewSantId().getSantId());

            sanctionDAO.insertApprovalDraft(approvalVO);
            insertApproverList(approvalVO);
        }catch (Exception e){
            throw new ApprovalSaveException(approvalVO);
        }

        return approvalVO.getSantId();
    }

    @Transactional
    protected void insertApproverList(ApprovalVO approvalVO) throws ApprovalSaveException {
        try {
            for (ApprovalAuthorizerVO approvalAuthorizerVO : approvalVO.getApprovalDetailList()) {
                approvalAuthorizerVO.setSantId(approvalVO.getSantId());
                sanctionDAO.insertApprovalAuthorizer(approvalAuthorizerVO);
            }
        }catch (Exception e){
            throw new ApprovalSaveException(approvalVO);
        }
    }

    @Transactional
    protected void updateApproverList(ApprovalVO approvalVO) throws UpdateDeniedException{
        try {
            sanctionDAO.deleteApprovalAuthorizer(approvalVO);
            this.insertApproverList(approvalVO);
        }catch (Exception e){
            throw new UpdateDeniedException(approvalVO);
        }
    }

    @Transactional
    protected void updateApprovalDraft(ApprovalVO approvalVO) throws UpdateDeniedException {
        try {
            sanctionDAO.updateApprovalDraft(approvalVO);
        }catch (Exception e){
            throw new UpdateDeniedException(approvalVO);
        }
    }
/*

    // 폐기시 유효성 확인 함수
    // 테스트
    @Transactional
    protected void updateApprovalDraftDisposal(ApprovalVO approvalVO) throws Exception {
        try {
            // 폐기는 결재완료(반려/승인) 이후에 가능


            // 폐기 전 유효성 체크 ???
            // 전체 결재자수와 결재 수행한 결재자수 조회(유효성체크1)
            ApprovalVO avlChkApprovalVO = sanctionDAO.selectTotalAprnCntWithAppvCnt(approvalVO);
            avlChkApprovalVO.setSantId(approvalVO.getSantId());

            if(avlChkApprovalVO.getAppvCnt() > 0){
                // 결재 진행상태 업데이트
                sanctionDAO.updateApprovalState(approvalVO);

            }


        }catch (Exception e){
            throw new UpdateDeniedException(approvalVO);
        }
    }
*/


    // 비즈니스 진행상태에 따른 결재 진행상태 조회
    // 폐기시 호출
    @Transactional
    protected ApprovalVO selectSyncronizedPrgsStatCd(CommonCodeMappingVO commonCodeMappingVO)  {
        // 비즈니스 진행상태에 따른 결재 진행상태 조회
        return sanctionDAO.selectSyncronizedPrgsStatCd(commonCodeMappingVO);
    }

    // 결재 진행상태 업데이트
    // 폐기시 호출
    @Transactional
    protected void updatePrgsStatCd(ApprovalVO approvalVO) throws ApprovalStateException {
        try {
            sanctionDAO.updateApprovalState(approvalVO);
        }catch (Exception e){
            throw new ApprovalStateException(approvalVO);
        }
    }

    // 비즈니스 문서 삭제에 따른 결재 삭제
    @Transactional(rollbackFor = Exception.class)
    protected void deleteApprovalDraft(ApprovalVO approvalVO) throws DeleteDeniedException {
        AttachVO attachVO = new AttachVO();

        if (approvalVO.getFileAttcId() != null && !approvalVO.getFileAttcId().equals("")) {
            attachVO.setFileAttcId(approvalVO.getFileAttcId());
        }
        try{
            sanctionDAO.deleteApprovalAuthorizer(approvalVO);
            sanctionDAO.deleteApprovalDraft(approvalVO);
        }catch (Exception e){   
            throw new DeleteDeniedException("결재문서 삭제 중 오류가 발생했습니다.", approvalVO);
        }
    }

}
