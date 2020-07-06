package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.BizChanceSearchVO;
import com.ibiz.api.model.BizChanceVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.model.BizChanceActivityVO;
import com.ibiz.api.service.BizChanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class BizChanceController extends BaseController {

    @Autowired
    private BizChanceService bizChanceService;

    @GetMapping("/bizChanceController")
    public String checkState() {
        return "bizChance-8200";
    }

    @PostMapping("/selectBizChanceList")
    public ResponseEntity<String> selectBizChanceList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceList(requestPayload)));
    }
/*
    @PostMapping("/selectBizChanceView")
    public ResponseEntity<String> selectBizChanceView(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceView");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceView(requestPayload)));
    }*/

    // BOPT_사업기회 : 사업기회 세부 내용 조회
    @PostMapping("/selectBizChance")
    public ResponseEntity<String> selectBizChance(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChance");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<BizChanceVO>(bizChanceService.selectBizChance(requestPayload)));
    }

    @PostMapping("/selectBizChanceRelList")
    public ResponseEntity<String> selectBizChanceRelList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceRelList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceRelList(requestPayload)));
    }

    @PostMapping("/selectRlvnOfferProfitList")
    public ResponseEntity<String> selectRlvnOfferProfitList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectRlvnOfferProfitList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectRlvnOfferProfitList(requestPayload)));
    }

    // 사업기회 이력 리스트 조회
    @PostMapping("/selectBizChanceHistoryList")
    public ResponseEntity<String> selectBizChanceHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceHistoryList(requestPayload)));
    }

    //사업기회 팝업 리스트 조회
    @PostMapping("/selectBizChancePopupList")
    public ResponseEntity<String> selectBizChancePopupList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChancePopupList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChancePopupList(requestPayload)));
    }

    // BOPT_사업기회 : 사업기회 등록
    @PostMapping("/insertBizChance")
    public ResponseEntity<String> insertBizChance(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertBizChance");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<BizChanceVO>(bizChanceService.insertBizChance(requestPayload)));
    }

    // BOPT_사업기회 : 사업기회 수정
    @PostMapping("/updateBizChance")
    public ResponseEntity<String> updateBizChance(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateBizChance");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<BizChanceVO>(bizChanceService.updateBizChance(requestPayload)));
    }

    // 사업기회 삭제
    @PostMapping("/deleteBizChance")
    public ResponseEntity<String> deleteBizChance(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteBizChance");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<Boolean>(bizChanceService.deleteBizChance(requestPayload)));
    }


    // 사업기회 이관 리스트 조회
    @PostMapping("/selectBizChanceSalesEmpList")
    public ResponseEntity<String> selectBizChanceSalesEmpList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceSalesEmpList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceSalesEmpList(requestPayload)));
    }

    // 사업기회 이관
    @PostMapping("/updateBizChanceSalesEmp")
    public ResponseEntity<String> updateBizChanceSalesEmp(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateBizChanceSalesEmp");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<BizChanceVO>(bizChanceService.updateBizChanceSalesEmp(requestPayload)));
    }


    // excel 엑셀

    // 사업기회 엑셀 다운로드
    @PostMapping("/selectExcelDwnlBizChanceList")
    public ResponseEntity<String> selectExcelDwnlBizChanceList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlBizChanceList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectExcelDwnlBizChanceList(requestPayload)));
    }

    // 사업기회 예상매출매입 엑셀 다운로드
    @PostMapping("/selectExcelDwnlBizChanceSellBuyList")
    public ResponseEntity<String> selectExcelDwnlBizChanceSellBuyList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlBizChanceSellBuyList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceSearchVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectExcelDwnlBizChanceSellBuyList(requestPayload)));
    }


    // 영업활동내역

    @PostMapping("/selectBizChanceActivityList")
    public ResponseEntity<String> selectBizChanceActivityList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizChanceActivityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceVO>>(){});

        return super.composePayload(new Payload<List>(bizChanceService.selectBizChanceActivityList(requestPayload)));
    }

    @PostMapping("/insertBizChanceActivity")
    public ResponseEntity<String> insertBizChanceActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertBizChanceActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceActivityVO>>(){});

        return super.composePayload(new Payload<BizChanceActivityVO>(bizChanceService.insertBizChanceActivity(requestPayload)));
    }

    @PostMapping("/updateBizChanceActivity")
    public ResponseEntity<String> updateBizChanceActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateBizChanceActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceActivityVO>>(){});

        return super.composePayload(new Payload<BizChanceActivityVO>(bizChanceService.updateBizChanceActivity(requestPayload)));
    }

    @PostMapping("/deleteBizChanceActivity")
    public ResponseEntity<String> deleteBizChanceActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteBizChanceActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizChanceActivityVO>>(){});

        return super.composePayload(new Payload<BizChanceActivityVO>(bizChanceService.deleteBizChanceActivity(requestPayload)));
    }


}
