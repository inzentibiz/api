package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.BizOpportunitySearchVO;
import com.ibiz.api.model.BizOpportunityVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.ExcelService;
import com.ibiz.api.service.ProjectBizOpptyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProjectBizOpptyController extends BaseController {

    @Autowired
    private ProjectBizOpptyService projectBizOpptyService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/projectBizOpptyController")
    public String checkState() {
        return "bizOppty-8200";
    }

    @PostMapping("/selectBizOpportunityList")
    public ResponseEntity<String> selectBizOpportunityList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.selectBizOpportunityList(requestPayload)));
    }

    @PostMapping("/selectBizOpportunityDetailList")
    public ResponseEntity<String> selectBizOpportunityDetailList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityDetailList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.selectBizOpportunityDetailList(requestPayload)));
    }

   @PostMapping("/deleteBizOpportunity")
    public ResponseEntity<String> deleteBizOpportunity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteBizOpportunity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<Boolean>(projectBizOpptyService.deleteBizOpportunity(requestPayload)));
    }

    @PostMapping("/AssociatedBizOpportunity")
    public ResponseEntity<String> AssociatedBizOpportunity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".AssociatedBizOpportunity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.AssociatedBizOpportunity(requestPayload)));
    }

    @PostMapping("/ApplicableProfitAnalysis")
    public ResponseEntity<String> ApplicableProfitAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".ApplicableProfitAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.ApplicableProfitAnalysis(requestPayload)));
    }

    @PostMapping("/selectBizOpportunityHistoryList")
    public ResponseEntity<String> selectBizOpportunityHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.selectBizOpportunityHistoryList(requestPayload)));
    }

    //사업기회 팝업 리스트 조회
    @PostMapping("/selectBizOpportunitySearchList")
    public ResponseEntity<String> selectBizOpportunitySearchList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunitySearchList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.selectBizOpportunitySearchList(requestPayload)));
    }

    // BOPT_사업기회 : 사업기회 등록
    @PostMapping("/insertBizOpportunity")
    public ResponseEntity<String> insertBizOpportunity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertBizOpportunity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<BizOpportunityVO>(projectBizOpptyService.insertBizOpportunity(requestPayload)));
    }

    // BOPT_사업기회 : 사업기회 수정
    @PostMapping("/updateBizOpportunity")
    public ResponseEntity<String> updateBizOpportunity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateBizOpportunity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<BizOpportunityVO>(projectBizOpptyService.updateBizOpportunity(requestPayload)));
    }

    // BOPT_사업기회 : 사업기회 세부 내용 조회
    @PostMapping("/selectBizOpportunityDetail")
    public ResponseEntity<String> selectBizOpportunityDetail(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityDetail");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<BizOpportunityVO>(projectBizOpptyService.selectBizOpportunityDetail(requestPayload)));
    }

    // 사업기회 이관 리스트 조회
    @PostMapping("/selectBizOpportunityForSlsEmpTransferList")
    public ResponseEntity<String> selectBizOpportunityForSlsEmpTransferList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBizOpportunityForSlsEmpTransferList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(projectBizOpptyService.selectBizOpportunityForSlsEmpTransferList(requestPayload)));
    }

    // 사업기회 이관
    @PostMapping("/updateBizOpportunityForSlsEmpTransfer")
    public ResponseEntity<String> updateBizOpportunityForSlsEmpTransfer(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateBizOpportunityForSlsEmpTransfer");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<BizOpportunityVO>(projectBizOpptyService.updateBizOpportunityForSlsEmpTransfer(requestPayload)));
    }


    // excel 엑셀

    // 사업기회 엑셀 다운로드
    @PostMapping("/selectExceldownloadBizOpportunity")
    public ResponseEntity<String> selectExceldownloadBizOpportunity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExceldownloadBizOpportunity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(excelService.selectExceldownloadBizOpportunity(requestPayload)));
    }

    // 사업기회 예상매출매입 엑셀 다운로드
    @PostMapping("/selectExceldownloadBizOpportunityDetail")
    public ResponseEntity<String> selectExceldownloadBizOpportunityDetail(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExceldownloadBizOpportunityDetail");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunitySearchVO>>(){});

        return super.composePayload(new Payload<List>(excelService.selectExceldownloadBizOpportunityDetail(requestPayload)));
    }
}
