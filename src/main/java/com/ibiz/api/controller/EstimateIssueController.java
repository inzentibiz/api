package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.EstiIssueVO;
import com.ibiz.api.model.JsonObject;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.EstimateIssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EstimateIssueController extends BaseController {

    @Autowired
    private EstimateIssueService estimateIssueService;

    @GetMapping("/estimateIssueController")
    public String checkState() {
        return "estimateIssue-8200";
    }

    //견적서 리스트
    @PostMapping("/selectEstimateHistoryList")
    public ResponseEntity<String> selectEstimateHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<List>(estimateIssueService.selectEstimateHistoryList(requestPayload)));
    }

    //견적서 조회
    @PostMapping("/selectEstimateIssueDetail")
    public ResponseEntity<String> selectEstimateIssueDetail(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateIssueDetail");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.selectEstimateIssueDetail(requestPayload)));
    }

    //견적서발신인 조회
    @PostMapping("/selectEstimateIssueTrsmtInfo")
    public ResponseEntity<String> selectEstimateIssueTrsmtInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateIssueTrsmtInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.selectEstimateIssueTrsmtInfo(requestPayload)));
    }

    //견적서 대표 조회
    @PostMapping("/selectEstimateIssueCustomerDetail")
    public ResponseEntity<String> selectEstimateIssueCustomerDetail(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateIssueCustomerDetail");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(estimateIssueService.selectEstimateIssueCustomerDetail(requestPayload)));
    }

    //견적서 견적내역 조회
    @PostMapping("/selectProfitAnalysis")
    public ResponseEntity<String> selectProfitAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectProfitAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.selectProfitAnalysis(requestPayload)));
    }

    //견적서 견적내역 상세
    @PostMapping("/selectEstimateDetail")
    public ResponseEntity<String> selectEstimateDetail(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateDetail");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.selectEstimateDetail(requestPayload)));
    }

    //견적서 상태 별 버튼
    @PostMapping("/selectEstimateButtonList")
    public ResponseEntity<String> selectEstimateButtonList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateButtonList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(estimateIssueService.selectEstimateButtonList(requestPayload)));
    }

    //견적서 등록
    @PostMapping("/insertEstimateIssue")
    public ResponseEntity<String> insertEstimateIssue(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertEstimateIssue");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.insertEstimateIssue(requestPayload)));
    }

    //견적서 수정
    @PostMapping("/updateEstimateIssue")
    public ResponseEntity<String> updateEstimateIssue(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateEstimateIssue");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.updateEstimateIssue(requestPayload)));
    }

    //견적서 상태
    @PostMapping("/updateEstisStatCd")
    public ResponseEntity<String> updateEstisStatCd(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateEstisStatCd");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<EstiIssueVO>(estimateIssueService.updateEstisStatCd(requestPayload)));
    }

    //견적서 삭제
    @PostMapping("/deleteEstimateIssue")
    public ResponseEntity<String> deleteEstimateIssue(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteEstimateIssue");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstiIssueVO>>(){});

        return super.composePayload(new Payload<Integer>(estimateIssueService.deleteEstimateIssue(requestPayload)));
    }

}
