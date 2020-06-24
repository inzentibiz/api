package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.EstimateVO;
import com.ibiz.api.model.JsonObject;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.OfferEstimateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class OfferEstimateController extends BaseController {

    @Autowired
    private OfferEstimateService offerEstimateService;

    @GetMapping("/offerEstimateController")
    public String checkState() {
        return "offerEstimate-8200";
    }

    //견적서 리스트
    @PostMapping("/selectOfferEstimateList")
    public ResponseEntity<String> selectOfferEstimateList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferEstimateList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<List>(offerEstimateService.selectOfferEstimateList(requestPayload)));
    }

    //견적서발신인 조회
    @PostMapping("/selectEstimateTrnrInfo")
    public ResponseEntity<String> selectEstimateTrnrInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateTrnrInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.selectEstimateTrnrInfo(requestPayload)));
    }

    //견적서 대표 조회
    @PostMapping("/selectEstimateRprsInfo")
    public ResponseEntity<String> selectEstimateRprsInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateRprsInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(offerEstimateService.selectEstimateRprsInfo(requestPayload)));
    }

    //견적서 견적내역 조회
    @PostMapping("/selectEstimateBkdnList")
    public ResponseEntity<String> selectEstimateBkdnList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateBkdnList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.selectEstimateBkdnList(requestPayload)));
    }

    //견적서 조회
    @PostMapping("/selectOfferEstimate")
    public ResponseEntity<String> selectOfferEstimate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferEstimate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.selectOfferEstimate(requestPayload)));
    }

    //견적서 견적내역 상세
    @PostMapping("/selectOfferEstimateView")
    public ResponseEntity<String> selectOfferEstimateView(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferEstimateView");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.selectOfferEstimateView(requestPayload)));
    }

    //견적서 상태 별 버튼
    @PostMapping("/selectOfferEstimateBtnList")
    public ResponseEntity<String> selectOfferEstimateBtnList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferEstimateBtnList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(offerEstimateService.selectOfferEstimateBtnList(requestPayload)));
    }

    //견적서 등록
    @PostMapping("/insertOfferEstimate")
    public ResponseEntity<String> insertOfferEstimate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertOfferEstimate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.insertOfferEstimate(requestPayload)));
    }

    //견적서 수정
    @PostMapping("/updateOfferEstimate")
    public ResponseEntity<String> updateOfferEstimate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferEstimate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.updateOfferEstimate(requestPayload)));
    }

    //견적서 상태
    @PostMapping("/updateOfferEstimateIssue")
    public ResponseEntity<String> updateOfferEstimateIssue(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferEstimateIssue");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<EstimateVO>(offerEstimateService.updateOfferEstimateIssue(requestPayload)));
    }

    //견적서 삭제
    @PostMapping("/deleteOfferEstimate")
    public ResponseEntity<String> deleteOfferEstimate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteOfferEstimate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EstimateVO>>(){});

        return super.composePayload(new Payload<Integer>(offerEstimateService.deleteOfferEstimate(requestPayload)));
    }

}
