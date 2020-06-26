package com.ibiz.api.service;

import com.ibiz.api.dao.OfferEstimateDAO;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OfferEstimateService extends AbstractDraftService {

    @Resource(name = "offerEstimateDAO")
    private OfferEstimateDAO offerEstimateDAO;

    @Transactional
    public List<EstimateVO> selectOfferEstimateList(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferEstimateList");
        EstimateVO estimateVO = requestPayload.getDto();

        List<EstimateVO> data = offerEstimateDAO.selectOfferEstimateList(estimateVO);

        return data;
    }

    @Transactional
    public EstimateVO selectEstimateTrnrInfo(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateTrnrInfo");
        EstimateVO estimateVO = requestPayload.getDto();

        estimateVO =  offerEstimateDAO.selectEstimateTrnrInfo(estimateVO.getSlsEmpId());

        return estimateVO;
    }

    @Transactional
    public JsonObject selectEstimateRprsInfo(Payload<EstimateVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateRprsInfo");
        EstimateVO estimateVO = requestPayload.getDto();
        JsonObject<Object, Object> jsonObject = new JsonObject();
        EstimateVO customerDetail;

        customerDetail = offerEstimateDAO.selectEstimateRprsInfo(estimateVO.getSlsEmpId());

        jsonObject.Data = customerDetail;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public EstimateVO selectEstimateBkdnList(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateBkdnList");
        EstimateVO estimateVO = requestPayload.getDto();

        List<EstimateProductPSVO> estiIssuePnsList = new ArrayList();
        List<EstimateProductMAVO> estiIssueMAList = new ArrayList();
        List<EstimateMAServiceVO> estiIssueMAServiceList = new ArrayList();

        //프로젝트 유형 갖고오기
        estimateVO.setPrjtTypeCd(offerEstimateDAO.selectEstimatePrjtTypeCd(estimateVO).getPrjtTypeCd());

        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            //견적내역(견적사항의  (서비스(외주포함)SV), (자사제품LC), (타사상품(H/W, S/W)OP)
            estiIssuePnsList = offerEstimateDAO.selectEstimateBkdnList(estimateVO.getFcstPalId());

            estimateVO.setEstiIssuePnsList(estiIssuePnsList);
        }else{
            //MA면
            //견적내역(유지보수 견적내역, 서비스 제공조건(유지보수 서비스), 기타사항)
            estiIssueMAList = offerEstimateDAO.selectEstimateMABkdnList(estimateVO.getFcstPalId());
            estiIssueMAServiceList = offerEstimateDAO.selectEstimateMAServiceBkdnList(estimateVO.getFcstPalId());

            estimateVO.setEstiIssueMAList(estiIssueMAList);
            estimateVO.setEstiIssueMAServiceList(estiIssueMAServiceList);
        }

        return estimateVO;
    }

    @Transactional
    public EstimateVO selectOfferEstimate(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferEstimate");
        EstimateVO estimateVO = requestPayload.getDto();

        EstimateVO estiModel = offerEstimateDAO.selectOfferEstimate(estimateVO.getEstiId());

        return estiModel;
    }

    @Transactional
    public EstimateVO selectOfferEstimateView(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferEstimateView");
        EstimateVO estimateVO = requestPayload.getDto();

        List<EstimateProductPSVO> estiIssuePnsList = new ArrayList();
        List<EstimateProductMAVO> estiIssueMAList = new ArrayList();
        List<EstimateMAServiceVO> estiIssueMAServiceList = new ArrayList();

        //프로젝트 유형 구하기
        estimateVO.setPrjtTypeCd(offerEstimateDAO.selectEstimatePrjtTypeCd(estimateVO).getPrjtTypeCd());

        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estiIssuePnsList = offerEstimateDAO.selectOfferEstimatePSList(estimateVO.getEstiId());

            estimateVO.setEstiIssuePnsList(estiIssuePnsList);
        }else{
            //MA면
            estiIssueMAList = offerEstimateDAO.selectOfferEstimateMAList(estimateVO.getEstiId());
            estiIssueMAServiceList = offerEstimateDAO.selectOfferEstimateMAServiceList(estimateVO.getEstiId());

            estimateVO.setEstiIssueMAList(estiIssueMAList);
            estimateVO.setEstiIssueMAServiceList(estiIssueMAServiceList);
        }

        return estimateVO;
    }

    @Transactional
    public ApprovalVO selectOfferEstimateBtnList(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectOfferEstimateBtnList");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstimateVO estimateVO = requestPayload.getDto();

        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        List<Map<String, String>> buttonList = new ArrayList<>();
        ApprovalVO approvalVO = new ApprovalVO();
        estimateVO = offerEstimateDAO.selectOfferEstimate(estimateVO.getEstiId());

        sysUserGroupVO.setTargetUserId(estimateVO.getSlsEmpId());
        sysUserGroupVO.setSourceUserId(accountVO.getEmpId());

        if (estimateVO.getEstiId() != null && (super.isBelongToAuthDept(sysUserGroupVO)) || accountVO.getRoleList().contains("AD")) {

            // 버튼 리스트
            if (estimateVO.getEstisStatCd().equals("A1") || estimateVO.getEstisStatCd().equals("A2") &&  super.isBelongToAuthDept(sysUserGroupVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
                buttonList.add(new HashMap<String, String>() {{put("button", "발행"); }});
            }/*else if (estiIssueVO.getEstisStatCd().equals("B2") &&  super.isBelongToAuthDept(userGrpVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "발행"); }});
            }*/

            if (accountVO.getRoleList().contains("AD")
                    || (sysUserGroupVO.getTargetUserId().equals(sysUserGroupVO.getSourceUserId()) && estimateVO.getEstisStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }

        }
        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public EstimateVO insertOfferEstimate(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertOfferEstimate");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstimateVO estimateVO = requestPayload.getDto();

        estimateVO.setChgEmpId(accountVO.getEmpId());

        String fcstPalPrgsStatCd = offerEstimateDAO.selectEstimateFcstPalPrgsStatCd(estimateVO).getFcstPalPrgsStatCdNmCd();

        //견적서 상태(등록:A1,임시등록:A2,발행:B1,임시발행:B2,폐기:C)
        if(fcstPalPrgsStatCd.equals("C")) {
            estimateVO.setEstisStatCd("A1");//등록
        }else {
            estimateVO.setEstisStatCd("A2");
        }

        //프로젝트 유형 갖고오기
        estimateVO.setPrjtTypeCd(offerEstimateDAO.selectEstimatePrjtTypeCd(estimateVO).getPrjtTypeCd());

        String kind = null;
        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estimateVO.setSantFrmtCd("B04");
            kind = "BES";
        }else{
            //MA면
            estimateVO.setSantFrmtCd("B05");
            kind = "BEM";
        }

        //문서번호 갖고오기
        String prevDocNo = offerEstimateDAO.selectEstiMaxDocNo(estimateVO).getDocNo();
        String estiWrtDate = estimateVO.getEstiWrtDate();
        String docNum = prevDocNo.split("-")[3];
        String docNo = null;
        int nextSequence;
        if(docNum.equals("00")) {
            nextSequence = 1;
        }else {
            nextSequence = Integer.parseInt(docNum) + 1;
        }

        //docNo= prevDocNo.split("-")[0]+"-"+ prevDocNo.split("-")[1]+"-"+ estiWrtDate +"-"+ String.format("%03d", nextSequence);
        docNo= prevDocNo.split("-")[0]+"-"+ kind+"-"+ estiWrtDate +"-"+ String.format("%03d", nextSequence);
        estimateVO.setDocNo(docNo);

        //견적 id 생성
        String prevId = offerEstimateDAO.selectMaxEstiId().getEstiId();
        estimateVO.setEstiId(IndexUtils.generateId(10, prevId));
        estimateVO.setRegEmpId(accountVO.getEmpId());

        //견적서 내역 저장
        offerEstimateDAO.insertOfferEstimate(estimateVO);

        //견적서 종류는 총 두가지(솔루션과 MA)이므로 프로젝트 유형 거르기
        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            //견적내역(견적사항의  (서비스(외주포함)SV), (자사제품LC), (타사상품(H/W, S/W)OP)
            if (estimateVO.getEstiIssuePnsList() != null) {
                for(EstimateProductPSVO estimateProductPSVO :  estimateVO.getEstiIssuePnsList()) {
                    estimateProductPSVO.setEstiId(estimateVO.getEstiId());
                    offerEstimateDAO.insertOfferEstimatePS(estimateProductPSVO);
                }
            }
        }else{
            //견적내역(유지보수 견적내역, 서비스 제공조건(유지보수 서비스), 기타사항)
            if (estimateVO.getEstiIssueMAList() != null) {
                offerEstimateDAO.insertOfferEstimateMA(estimateVO);
                for(EstimateMAServiceVO estimateMAServiceVO : estimateVO.getEstiIssueMAServiceList()) {
                    estimateMAServiceVO.setEstiId(estimateVO.getEstiId());
                    offerEstimateDAO.insertOfferEstimateMAService(estimateMAServiceVO);
                }
            }
        }

        return estimateVO;
    }

    @Transactional
    public EstimateVO updateOfferEstimate(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferEstimate");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstimateVO estimateVO = requestPayload.getDto();
        estimateVO.setChgEmpId(accountVO.getEmpId());

        //프로젝트 유형 갖고오기
        estimateVO.setPrjtTypeCd(offerEstimateDAO.selectEstimatePrjtTypeCd(estimateVO).getPrjtTypeCd());

        String kind = null;
        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estimateVO.setSantFrmtCd("B04");
            kind = "BES";
        }else{
            //MA면
            estimateVO.setSantFrmtCd("B05");
            kind = "BEM";
        }

        String prevDocDate = estimateVO.getDocNo().split("-")[2];
        if(!(prevDocDate.equals(estimateVO.getEstiWrtDate()))) {
            //문서번호 갖고오기
            String prevDocNo = offerEstimateDAO.selectEstiMaxDocNo(estimateVO).getDocNo();
            String estiWrtDate = estimateVO.getEstiWrtDate();
            String docNum = prevDocNo.split("-")[3];
            String docNo = null;
            int nextSequence;
            if(docNum.equals("00")) {
                nextSequence = 1;
            }else {
                nextSequence = Integer.parseInt(docNum) + 1;
            }

            docNo= prevDocNo.split("-")[0]+"-"+ kind+"-"+ estiWrtDate +"-"+ String.format("%03d", nextSequence);
            estimateVO.setDocNo(docNo);
        }

        // 견적서 상태값이 등록일 경우에만 업데이트
        EstimateVO model = offerEstimateDAO.selectOfferEstimateStat(estimateVO);

        offerEstimateDAO.updateOfferEstimate(estimateVO);

        if(estimateVO.getPrjtTypeCd().equals("B1")) {
            offerEstimateDAO.deleteOfferEstimatePS(estimateVO);
            if (estimateVO.getEstiIssuePnsList() != null) {
                for(EstimateProductPSVO estimateProductPSVO :  estimateVO.getEstiIssuePnsList()) {
                    estimateProductPSVO.setEstiId(estimateVO.getEstiId());
                    offerEstimateDAO.insertOfferEstimatePS(estimateProductPSVO);
                }
            }
        }else {
            offerEstimateDAO.deleteOfferEstimateMAService(estimateVO);
            for(EstimateMAServiceVO estimateMAServiceVO : estimateVO.getEstiIssueMAServiceList()) {
                estimateMAServiceVO.setEstiId(estimateVO.getEstiId());
                offerEstimateDAO.insertOfferEstimateMAService(estimateMAServiceVO);
            }
        }

        return estimateVO;
    }

    @Transactional
    public EstimateVO updateOfferEstimateIssue(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateOfferEstimateIssue");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstimateVO estimateVO = requestPayload.getDto();
        // 견적서 상태 체크해야함
        String estistatCd = estimateVO.getEstisStatCd();

        if(estistatCd.equals("A1")) {
            estimateVO.setEstisStatCd("B1");
        }else {
            estimateVO.setEstisStatCd("B2");
        }
        // 견적서 진행상태 업데이트
        offerEstimateDAO.updateOfferEstimateIssue(estimateVO);

        estimateVO = offerEstimateDAO.selectOfferEstimate(estimateVO.getEstiId());

        return estimateVO;
    }

    @Transactional
    public Integer deleteOfferEstimate(Payload<EstimateVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteOfferEstimate");
        EstimateVO estimateVO = requestPayload.getDto();
        int cnt = 0;
        cnt = offerEstimateDAO.selectIsExistsOfferEstimate(estimateVO);

        if( cnt > 0 ) {
            //프로젝트 유형 갖고오기
            estimateVO.setPrjtTypeCd(offerEstimateDAO.selectEstimatePrjtTypeCd(estimateVO).getPrjtTypeCd());

            if(estimateVO.getPrjtTypeCd().equals("B1")) {
                offerEstimateDAO.deleteOfferEstimatePS(estimateVO);
            }else {
                offerEstimateDAO.deleteOfferEstimateMA(estimateVO);
                offerEstimateDAO.deleteOfferEstimateMAService(estimateVO);
            }
            offerEstimateDAO.deleteOfferEstimate(estimateVO);

        }

        return cnt;
    }

}
