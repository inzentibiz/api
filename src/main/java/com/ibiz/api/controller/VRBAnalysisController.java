package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.CommonGroupCodeVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.model.VRBAnalysisVO;
import com.ibiz.api.service.VRBAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class VRBAnalysisController extends BaseController {

    @Autowired
    private VRBAnalysisService vrbAnalysisService;

    @GetMapping("/vrbAnalysisController")
    public String checkState() {
        return "vrb-8200";
    }

    /**
     * PRJT_VRB분석 목록
     */
    @PostMapping("/selectVRBAnalysisList")
    public ResponseEntity<String> selectVRBAnalysisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<List>(vrbAnalysisService.selectVRBAnalysisList(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회
     */
    @PostMapping("/selectVRBAnalysis")
    public ResponseEntity<String> selectVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.selectVRBAnalysis(requestPayload)));
    }

    /**
     * 결재진행상태 동기화 > 결재버튼 활성화 여부체크 > 진행상태값 바인딩
     */
    @PostMapping("/updateVRBAnalysisStat")
    public ResponseEntity<String> updateVRBAnalysisStat(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateVRBAnalysisStat");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.updateVRBAnalysisStat(requestPayload)));
    }

    /**
     * prjtId, santId 조회
     */
    @PostMapping("/selectPrjtIdAndVrbAnlyId")
    public ResponseEntity<String> selectPrjtIdAndVrbAnlyId(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectPrjtIdAndVrbAnlyId");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.selectPrjtIdAndVrbAnlyId(requestPayload)));
    }

    /**
     * VRB분석서(솔루션.MA) 기안버튼리스트
     */
    @PostMapping("/selectVRBAnalysisDrfBtnList")
    public ResponseEntity<String> selectVRBAnalysisDrfBtnList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisDrfBtnList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(vrbAnalysisService.selectVRBAnalysisDrfBtnList(requestPayload)));
    }


    /**
     * PRJT_VRB분석 삭제
     */
    @PostMapping("/deleteVRBAnalysis")
    public ResponseEntity<String> deleteVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.deleteVRBAnalysis(requestPayload)));
    }

    /**
     * VRB분석서 폐기
     */
    @PostMapping("/updateVRBAnalysisDss")
    public ResponseEntity<String> updateVRBAnalysisDss(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateVRBAnalysisDss");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.updateVRBAnalysisDss(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회 (for 등록)
     */
    @PostMapping("/selectVRBAnalysisForInsert")
    public ResponseEntity<String> selectVRBAnalysisForInsert(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisForInsert");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.selectVRBAnalysisForInsert(requestPayload)));
    }

    /**
     * PRJT_VRB분석 상세조회 (for 수정)
     */
    @PostMapping("/selectVRBAnalysisForUpdate")
    public ResponseEntity<String> selectVRBAnalysisForUpdate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnalysisForUpdate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.selectVRBAnalysisForUpdate(requestPayload)));
    }

    /**
     * VRB분석항목코드 조회
     */
    @PostMapping("/selectVRBAnlyItmCdList")
    public ResponseEntity<String> selectVRBAnlyItmCdList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVRBAnlyItmCdList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CommonGroupCodeVO>>(){});

        return super.composePayload(new Payload<List>(vrbAnalysisService.selectVRBAnlyItmCdList(requestPayload)));
    }

    /**
     * PRJT_VRB분석 등록
     */
    @PostMapping("/insertVRBAnalysis")
    public ResponseEntity<String> insertVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.insertVRBAnalysis(requestPayload)));
    }

    /**
     * PRJT_VRB분석 수정
     */
    @PostMapping("/updateVRBAnalysis")
    public ResponseEntity<String> updateVRBAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateVRBAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<VRBAnalysisVO>>(){});

        return super.composePayload(new Payload<VRBAnalysisVO>(vrbAnalysisService.updateVRBAnalysis(requestPayload)));
    }

}
