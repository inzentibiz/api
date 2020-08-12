package com.ibiz.api.service;

import com.ibiz.api.dao.DraftDao;
import com.ibiz.api.model.ApprovalAuthorizerVO;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.AttachVO;
import com.ibiz.api.utils.IndexUtils;
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

    private static final Map<String, String> SUBMIT_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "2"); put("button", "상신"); put("value", "A");}};

    private static final Map<String, String> APPROVE_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "3"); put("button", "승인"); put("value", "B");}};

    private static final Map<String, String> REJECT_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "4"); put("button", "반려"); put("value", "C");}};

    private static final Map<String, String> AGREE_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "5"); put("button", "합의"); put("value", "D");}};

    private static final Map<String, String> REJECT_AGREEMENT_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "6"); put("button", "합의거부"); put("value", "E");}};

    private static final Map<String, String> WITHDRAW_APPROVAL_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "8"); put("button", "결재회수"); put("value", "G");}};

    private static final Map<String, String> CHANGE_APPROVAL_OPINION_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "7"); put("button", "결재의견변경"); put("value", "H");}};

    private static final Map<String, String> CHANGE_APPROVAL_LINE_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "1"); put("button", "결재라인변경"); put("value", "I");}};

    private static final Map<String, String> RECEIVE_BUTTON = new HashMap<String, String>() {{put("sortSeqc", "9"); put("button", "수신"); put("value", "F");}};


    @Resource(name = "draftDao")
    private DraftDao draftDao;

    @Transactional
    protected ApprovalVO selectApprovalInfo(String santId) {
        ApprovalVO approvalVO = new ApprovalVO();
        approvalVO.setSantId(santId);

        return draftDao.selectSantNtcDstInfo(approvalVO);
    }

    @Transactional
    protected void deleteCascadingDraft(ApprovalVO approvalVO) throws Exception {
        AttachVO attachVO = new AttachVO();

        if (approvalVO.getFileAttcId() != null && !approvalVO.getFileAttcId().equals("")) {
            attachVO.setFileAttcId(approvalVO.getFileAttcId());
        }

        draftDao.deleteApprovalAuthorizer(approvalVO);
        draftDao.deleteApprovalDraft(approvalVO);
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
    protected String insertDraft(ApprovalVO approvalVO) throws Exception {
        String prevId = draftDao.selectMaxSantId().getSantId();

        approvalVO.setSantId(IndexUtils.generateId(10, prevId));
        approvalVO.setSantPrgsStatCd("A");
        //approvalVO.setSantId(IndexUtils.generateId(10, prevId));

        draftDao.insertApprovalDraft(approvalVO);
        insertApproverList(approvalVO);

        return approvalVO.getSantId();
    }

    @Transactional
    protected void insertApproverList(ApprovalVO approvalVO) {
        for (ApprovalAuthorizerVO approvalAuthorizerVO : approvalVO.getApprovalDetailList()) {
            approvalAuthorizerVO.setSantId(approvalVO.getSantId());
            draftDao.insertApprovalAuthorizer(approvalAuthorizerVO);
        }
    }

    @Transactional
    protected void updateApproverList(ApprovalVO approvalVO) {
        draftDao.deleteApprovalAuthorizer(approvalVO);
        insertApproverList(approvalVO);
    }

    @Transactional
    protected void updateDraft(ApprovalVO approvalVO) throws Exception {

        draftDao.updateApprovalDraft(approvalVO);
    }
}
