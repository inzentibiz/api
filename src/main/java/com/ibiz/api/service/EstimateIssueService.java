package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateIssueDao;
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
public class EstimateIssueService extends AbstractDraftService {

    @Resource(name = "estimateIssueDao")
    private EstimateIssueDao estimateIssueDao;

    @Transactional
    public List<EstiIssueVO> selectEstimateHistoryList(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateHistoryList");
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        List<EstiIssueVO> data = estimateIssueDao.selectEstimateHistoryList(estiIssueVO);

        return data;
    }

    @Transactional
    public EstiIssueVO selectEstimateIssueTrsmtInfo(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateIssueTrsmtInfo");
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        estiIssueVO =  estimateIssueDao.selectEstimateIssueTrsmtInfo(estiIssueVO.getSlsEmpId());

        return estiIssueVO;
    }

    @Transactional
    public JsonObject selectEstimateIssueCustomerDetail(Payload<EstiIssueVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateIssueCustomerDetail");
        EstiIssueVO estiIssueVO = requestPayload.getDto();
        JsonObject<Object, Object> jsonObject = new JsonObject();
        EstiIssueVO customerDetail;

        customerDetail = estimateIssueDao.selectEstimateIssueCustomerDetail(estiIssueVO.getSlsEmpId());

        jsonObject.Data = customerDetail;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public EstiIssueVO selectProfitAnalysis(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectProfitAnalysis");
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        List<EstiProductVO> estiIssuePnsList = new ArrayList();
        List<EstiIssueMAVO> estiIssueMAList = new ArrayList();
        List<EstiIssueMAServiceVO> estiIssueMAServiceList = new ArrayList();

        //프로젝트 유형 갖고오기
        estiIssueVO.setPrjtTypeCd(estimateIssueDao.selectEstimateIssuePrjtTypeCd(estiIssueVO).getPrjtTypeCd());

        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            //견적내역(견적사항의  (서비스(외주포함)SV), (자사제품LC), (타사상품(H/W, S/W)OP)
            estiIssuePnsList = estimateIssueDao.selectProfitAnalysis(estiIssueVO.getFcstPalId());

            estiIssueVO.setEstiIssuePnsList(estiIssuePnsList);
        }else{
            //MA면
            //견적내역(유지보수 견적내역, 서비스 제공조건(유지보수 서비스), 기타사항)
            estiIssueMAList = estimateIssueDao.selectProfitAnalysisMA(estiIssueVO.getFcstPalId());
            estiIssueMAServiceList = estimateIssueDao.selectProfitAnalysisMAService(estiIssueVO.getFcstPalId());

            estiIssueVO.setEstiIssueMAList(estiIssueMAList);
            estiIssueVO.setEstiIssueMAServiceList(estiIssueMAServiceList);
        }

        return estiIssueVO;
    }

    @Transactional
    public EstiIssueVO selectEstimateIssueDetail(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateIssueDetail");
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        EstiIssueVO estiModel = estimateIssueDao.selectEstimateIssueDetail(estiIssueVO.getEstiId());

        return estiModel;
    }

    @Transactional
    public EstiIssueVO selectEstimateDetail(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateDetail");
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        List<EstiProductVO> estiIssuePnsList = new ArrayList();
        List<EstiIssueMAVO> estiIssueMAList = new ArrayList();
        List<EstiIssueMAServiceVO> estiIssueMAServiceList = new ArrayList();

        //프로젝트 유형 구하기
        estiIssueVO.setPrjtTypeCd(estimateIssueDao.selectEstimateIssuePrjtTypeCd(estiIssueVO).getPrjtTypeCd());

        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estiIssuePnsList = estimateIssueDao.selectEstimateDetail(estiIssueVO.getEstiId());

            estiIssueVO.setEstiIssuePnsList(estiIssuePnsList);
        }else{
            //MA면
            estiIssueMAList = estimateIssueDao.selectEstimateIssueMAList(estiIssueVO.getEstiId());
            estiIssueMAServiceList = estimateIssueDao.selectEstimateIssueMAServiceList(estiIssueVO.getEstiId());

            estiIssueVO.setEstiIssueMAList(estiIssueMAList);
            estiIssueVO.setEstiIssueMAServiceList(estiIssueMAServiceList);
        }

        return estiIssueVO;
    }

    @Transactional
    public ApprovalVO selectEstimateButtonList(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectEstimateButtonList");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        ApprovalDetailVO  approvalDetail = new ApprovalDetailVO();
        UserGrpVO userGrpVO = new UserGrpVO();
        List<Map<String, String>> buttonList = new ArrayList<>();
        ApprovalVO approvalVO = new ApprovalVO();
        estiIssueVO = estimateIssueDao.selectEstimateIssueDetail(estiIssueVO.getEstiId());

        userGrpVO.setTargetUserId(estiIssueVO.getSlsEmpId());
        userGrpVO.setSourceUserId(accountVO.getEmpId());

        if (estiIssueVO.getEstiId() != null && (super.isBelongToAuthDept(userGrpVO)) || accountVO.getRoleList().contains("AD")) {

            // 버튼 리스트
            if (estiIssueVO.getEstisStatCd().equals("A1") || estiIssueVO.getEstisStatCd().equals("A2") &&  super.isBelongToAuthDept(userGrpVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "수정"); }});
                buttonList.add(new HashMap<String, String>() {{put("button", "발행"); }});
            }/*else if (estiIssueVO.getEstisStatCd().equals("B2") &&  super.isBelongToAuthDept(userGrpVO) ) {
                buttonList.add(new HashMap<String, String>() {{put("button", "발행"); }});
            }*/

            if (accountVO.getRoleList().contains("AD")
                    || (userGrpVO.getTargetUserId().equals(userGrpVO.getSourceUserId()) && estiIssueVO.getEstisStatCd().equals("A"))) {
                buttonList.add(new HashMap<String, String>() {{put("button", "삭제"); }});
            }

        }
        approvalVO.setButtonList(buttonList);

        return approvalVO;
    }

    @Transactional
    public EstiIssueVO insertEstimateIssue(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertEstimateIssue");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstiIssueVO estiIssueVO = requestPayload.getDto();

        estiIssueVO.setChgEmpId(accountVO.getEmpId());

        String fcstPalPrgsStatCd = estimateIssueDao.selectEstimateIssueFcstPalPrgsStatCd(estiIssueVO).getFcstPalPrgsStatCd();

        //견적서 상태(등록:A1,임시등록:A2,발행:B1,임시발행:B2,폐기:C)
        if(fcstPalPrgsStatCd.equals("C")) {
            estiIssueVO.setEstisStatCd("A1");//등록
        }else {
            estiIssueVO.setEstisStatCd("A2");
        }

        //프로젝트 유형 갖고오기
        estiIssueVO.setPrjtTypeCd(estimateIssueDao.selectEstimateIssuePrjtTypeCd(estiIssueVO).getPrjtTypeCd());

        String kind = null;
        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estiIssueVO.setSantFrmtCd("B04");
            kind = "BES";
        }else{
            //MA면
            estiIssueVO.setSantFrmtCd("B05");
            kind = "BEM";
        }

        //문서번호 갖고오기
        String prevDocNo = estimateIssueDao.selectMaxDocNo(estiIssueVO).getDocNo();
        String estiWrtDate = estiIssueVO.getEstiWrtDate();
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
        estiIssueVO.setDocNo(docNo);

        //견적 id 생성
        String prevId = estimateIssueDao.selectMaxEstiIssueId().getEstiId();
        estiIssueVO.setEstiId(IndexUtils.generateId(10, prevId));
        estiIssueVO.setRegEmpId(accountVO.getEmpId());

        //견적서 내역 저장
        estimateIssueDao.insertEstimateIssue(estiIssueVO);

        //견적서 종류는 총 두가지(솔루션과 MA)이므로 프로젝트 유형 거르기
        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            //견적내역(견적사항의  (서비스(외주포함)SV), (자사제품LC), (타사상품(H/W, S/W)OP)
            if (estiIssueVO.getEstiIssuePnsList() != null) {
                for(EstiProductVO estiProductVO :  estiIssueVO.getEstiIssuePnsList()) {
                    estiProductVO.setEstiId(estiIssueVO.getEstiId());
                    estimateIssueDao.insertEstimateIssueProductAll(estiProductVO);
                }
            }
        }else{
            //견적내역(유지보수 견적내역, 서비스 제공조건(유지보수 서비스), 기타사항)
            if (estiIssueVO.getEstiIssueMAList() != null) {
                estimateIssueDao.insertEstimateIssueMaDetail(estiIssueVO);
                for(EstiIssueMAServiceVO estiIssueMAServiceVO : estiIssueVO.getEstiIssueMAServiceList()) {
                    estiIssueMAServiceVO.setEstiId(estiIssueVO.getEstiId());
                    estimateIssueDao.insertEstimateIssueMaServiceDetail(estiIssueMAServiceVO);
                }
            }
        }

        return estiIssueVO;
    }

    @Transactional
    public EstiIssueVO updateEstimateIssue(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateEstimateIssue");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstiIssueVO estiIssueVO = requestPayload.getDto();
        estiIssueVO.setChgEmpId(accountVO.getEmpId());

        //프로젝트 유형 갖고오기
        estiIssueVO.setPrjtTypeCd(estimateIssueDao.selectEstimateIssuePrjtTypeCd(estiIssueVO).getPrjtTypeCd());

        String kind = null;
        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            //PNS면
            estiIssueVO.setSantFrmtCd("B04");
            kind = "BES";
        }else{
            //MA면
            estiIssueVO.setSantFrmtCd("B05");
            kind = "BEM";
        }

        String prevDocDate = estiIssueVO.getDocNo().split("-")[2];
        if(!(prevDocDate.equals(estiIssueVO.getEstiWrtDate()))) {
            //문서번호 갖고오기
            String prevDocNo = estimateIssueDao.selectMaxDocNo(estiIssueVO).getDocNo();
            String estiWrtDate = estiIssueVO.getEstiWrtDate();
            String docNum = prevDocNo.split("-")[3];
            String docNo = null;
            int nextSequence;
            if(docNum.equals("00")) {
                nextSequence = 1;
            }else {
                nextSequence = Integer.parseInt(docNum) + 1;
            }

            docNo= prevDocNo.split("-")[0]+"-"+ kind+"-"+ estiWrtDate +"-"+ String.format("%03d", nextSequence);
            estiIssueVO.setDocNo(docNo);
        }

        // 견적서 상태값이 등록일 경우에만 업데이트
        EstiIssueVO model = estimateIssueDao.selectEstimateIssueStatCd(estiIssueVO);

        estimateIssueDao.updateEstimateIssue(estiIssueVO);

        if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
            estimateIssueDao.deleteEstimateIssueProduct(estiIssueVO);
            if (estiIssueVO.getEstiIssuePnsList() != null) {
                for(EstiProductVO estiProductVO :  estiIssueVO.getEstiIssuePnsList()) {
                    estiProductVO.setEstiId(estiIssueVO.getEstiId());
                    estimateIssueDao.insertEstimateIssueProductAll(estiProductVO);
                }
            }
        }else {
            estimateIssueDao.deleteEstimateIssueMAService(estiIssueVO);
            for(EstiIssueMAServiceVO estiIssueMAServiceVO : estiIssueVO.getEstiIssueMAServiceList()) {
                estiIssueMAServiceVO.setEstiId(estiIssueVO.getEstiId());
                estimateIssueDao.insertEstimateIssueMaServiceDetail(estiIssueMAServiceVO);
            }
        }

        return estiIssueVO;
    }

    @Transactional
    public EstiIssueVO updateEstisStatCd(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateEstisStatCd");
        AccountVO accountVO = requestPayload.getAccountVO();
        EstiIssueVO estiIssueVO = requestPayload.getDto();
        // 견적서 상태 체크해야함
        String estistatCd = estiIssueVO.getEstisStatCd();

        if(estistatCd.equals("A1")) {
            estiIssueVO.setEstisStatCd("B1");
        }else {
            estiIssueVO.setEstisStatCd("B2");
        }
        // 견적서 진행상태 업데이트
        estimateIssueDao.updateEstimateIssueStatCd(estiIssueVO);

        estiIssueVO = estimateIssueDao.selectEstimateIssueDetail(estiIssueVO.getEstiId());

        return estiIssueVO;
    }

    @Transactional
    public Integer deleteEstimateIssue(Payload<EstiIssueVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteEstimateIssue");
        EstiIssueVO estiIssueVO = requestPayload.getDto();
        int cnt = 0;
        cnt = estimateIssueDao.selectIsExistEstimateIssue(estiIssueVO);

        if( cnt > 0 ) {
            //프로젝트 유형 갖고오기
            estiIssueVO.setPrjtTypeCd(estimateIssueDao.selectEstimateIssuePrjtTypeCd(estiIssueVO).getPrjtTypeCd());

            if(estiIssueVO.getPrjtTypeCd().equals("B1")) {
                estimateIssueDao.deleteEstimateIssueProduct(estiIssueVO);
            }else {
                estimateIssueDao.deleteEstimateIssueMA(estiIssueVO);
                estimateIssueDao.deleteEstimateIssueMAService(estiIssueVO);
            }
            estimateIssueDao.deleteEstimateIssue(estiIssueVO);

        }

        return cnt;
    }

}
