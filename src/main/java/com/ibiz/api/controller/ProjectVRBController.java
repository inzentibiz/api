package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.CommonGroupVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.model.VRBVO;
import com.ibiz.api.service.ProjectVRBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProjectVRBController extends BaseController {

    @Autowired
    private ProjectVRBService projectVRBService;

    @GetMapping("/projectVRBController")
    public String checkState() {
        return "vrb-8200";
    }

    /**
     * PRJT_VRB분석 목록
     */
    @PostMapping("/selectVRBAnalysisHistoryList")
    public ResponseEntity<String> selectVRBAnalysisHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<List>(projectVRBService.selectVRBAnalysisHistoryList(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회
     */
    @PostMapping("/selectVRBAnalysis")
    public ResponseEntity<String> selectVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.selectVRBAnalysis(requestPayload)));
    }

    /**
     * 결재진행상태 동기화 > 결재버튼 활성화 여부체크 > 진행상태값 바인딩
     */
    @PostMapping("/updateVrbDraftPrgsStatCd")
    public ResponseEntity<String> updateDraftPrgsStatCd(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDraftPrgsStatCd");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.updateDraftPrgsStatCd(requestPayload)));
    }

    /**
     * prjtId, santId 조회
     */
    @PostMapping("/selectPrjtIdAndVrbAnlyId")
    public ResponseEntity<String> selectPrjtIdAndVrbAnlyId(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectPrjtIdAndVrbAnlyId");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.selectPrjtIdAndVrbAnlyId(requestPayload)));
    }

    /**
     * VRB분석서(솔루션.MA) 기안버튼리스트
     */
    @PostMapping("/selectVrbDraftButtonList")
    public ResponseEntity<String> selectDraftButtonList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDraftButtonList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(projectVRBService.selectDraftButtonList(requestPayload)));
    }


    /**
     * PRJT_VRB분석 삭제
     */
    @PostMapping("/deleteVRBAnalysis")
    public ResponseEntity<String> deleteVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.deleteVRBAnalysis(requestPayload)));
    }

    /**
     * VRB분석서 폐기
     */
    @PostMapping("/vrbDiscardDraft")
    public ResponseEntity<String> discardDraft(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".discardDraft");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<ApprovalVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.discardDraft(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회 (for 등록)
     */
    @PostMapping("/selectVRBAnalysisForInsert")
    public ResponseEntity<String> selectVRBAnalysisForInsert(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisForInsert");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.selectVRBAnalysisForInsert(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회 (for 수정)
     */
    @PostMapping("/selectVRBAnalysisForUpdate")
    public ResponseEntity<String> selectVRBAnalysisForUpdate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisForUpdate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.selectVRBAnalysisForUpdate(requestPayload)));
    }

    /**
     * VRB분석항목코드 조회
     */
    @PostMapping("/selectVRBAnlyItmCdList")
    public ResponseEntity<String> selectVRBAnlyItmCdList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnlyItmCdList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CommonGroupVO>>(){});

        return super.composePayload(new Payload<List>(projectVRBService.selectVRBAnlyItmCdList(requestPayload)));
    }

    /**
     * PRJT_VRB분석 등록
     */
    @PostMapping("/insertVRBAnalysis")
    public ResponseEntity<String> insertVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnlyItmCdList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.insertVRBAnalysis(requestPayload)));
    }

    /**
     * PRJT_VRB분석 수정
     */
    @PostMapping("/updateVRBAnalysis")
    public ResponseEntity<String> updateVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<VRBVO>(projectVRBService.updateVRBAnalysis(requestPayload)));
    }

    /**
     * 사업기회리스트 조회 : 등록, 수정
     */
    @PostMapping("/selectVRBBusinessOpportunityList")
    public ResponseEntity<String> selectVRBBusinessOpportunityList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBBusinessOpportunityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBVO>>(){});

        return super.composePayload(new Payload<List>(projectVRBService.selectVRBBusinessOpportunityList(requestPayload)));
    }
}
