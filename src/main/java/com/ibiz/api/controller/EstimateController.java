package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.*;
import com.ibiz.api.service.EstimateMaService;
import com.ibiz.api.service.EstimatePSService;
import com.ibiz.api.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EstimateController extends BaseController {

    @Autowired
    private EstimatePSService estimatePSService;

    @Autowired
    private EstimateMaService estimateMaService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/estimateController")
    public String checkState() {
        return "estimate-8200";
    }

    /*
     *  P&S
     */

    // 예상손익분석서 리스트 조회
    @PostMapping("/selectQuoteAnalysisList")
    public ResponseEntity<String> selectQuoteAnalysisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectQuoteAnalysisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<FcstPalSearchVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectQuoteAnalysisList(requestPayload)));
    }

    // 예상손익분석서(P&S) 상세조회
    @PostMapping("/selectEstimatedPSAnalysis")
    public ResponseEntity<String> selectEstimatedPSAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimatedPSAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimatePSService.selectEstimatedPSAnalysis(requestPayload)));
    }

    // 예상손익분석서(P&S) 저장
    @PostMapping("/insertEstimatedPSAnalysis")
    public ResponseEntity<String> insertEstimatedPSAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertEstimatedPSAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimatePSService.insertEstimatedPSAnalysis(requestPayload)));
    }

    // 예상손익분석서(P&S) 수정
    @PostMapping("/updateEstimatedPSAnalysis")
    public ResponseEntity<String> updateEstimatedPSAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateEstimatedPSAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimatePSService.updateEstimatedPSAnalysis(requestPayload)));
    }

    // 예상손익분석서(P&S) 삭제
    @PostMapping("/deleteEstimatedPSAnalysis")
    public ResponseEntity<String> deleteEstimatedPSAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteEstimatedPSAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimatePSService.deleteEstimatedPSAnalysis(requestPayload)));
    }

    // 예상손익분석서(P&S)  프로젝트 경비 직접비 기준 리스트 조회
    @PostMapping("/selectDirectExpenseStandardList")
    public ResponseEntity<String> selectDirectExpenseStandardList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDirectExpenseStandardList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectDirectExpenseStandardList()));
    }

    // 예상손익분석서(P&S)  프로젝트 경비 직접비 리스트 조회 (바인딩)
    @PostMapping("/selectDirectExpenseList")
    public ResponseEntity<String> selectDirectExpenseList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDirectExpenseList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectDirectExpenseList(requestPayload)));
    }

    // 3. VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
    @PostMapping("/selectVrbCriteriaList")
    public ResponseEntity<String> selectVrbCriteriaList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVrbCriteriaList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectVrbCriteriaList(requestPayload)));
    }

    // 예상손익분석서(솔루션.MA) 기안버튼리스트
    @PostMapping("/selectDraftButtonList")
    public ResponseEntity<String> selectDraftButtonList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDraftButtonList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(estimatePSService.selectDraftButtonList(requestPayload)));
    }

    // 예상손익분석서 폐기
    @PostMapping("/discardDraft")
    public ResponseEntity<String> discardDraft(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".discardDraft");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<ApprovalVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(estimatePSService.discardDraft(requestPayload)));
    }

    /*
     * Maintenace
     */

    // 예상손익분석서(MA) 상세조회
    @PostMapping("/selectEstimatedMaAnalysis")
    public ResponseEntity<String> selectEstimatedMaAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimatedMaAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimateMaService.selectEstimatedMaAnalysis(requestPayload)));
    }

    // 예상손익분석서(MA) 저장
    @PostMapping("/insertEstimatedMaAnalysis")
    public ResponseEntity<String> insertEstimatedMaAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertEstimatedMaAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimateMaService.insertEstimatedMaAnalysis(requestPayload)));
    }

    // 예상손익분석서(MA) 수정
    @PostMapping("/updateEstimatedMaAnalysis")
    public ResponseEntity<String> updateEstimatedMaAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateEstimatedMaAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimateMaService.updateEstimatedMaAnalysis(requestPayload)));
    }

    // 예상손익분석서(MA) 삭제
    @PostMapping("/deleteEstimatedMaAnalysis")
    public ResponseEntity<String> deleteEstimatedMaAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteEstimatedMaAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimateMaService.deleteEstimatedMaAnalysis(requestPayload)));
    }


    // updateDraftPrgsStatCd 결재진행상태 동기화 > 결재버튼 활성화 여부체크 > 진행상태값 바인딩
    @PostMapping("/updateDraftPrgsStatCd")
    public ResponseEntity<String> updateDraftPrgsStatCd(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDraftPrgsStatCd");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<BsnsProfitLossVO>(estimatePSService.updateDraftPrgsStatCd(requestPayload)));
    }

    // selectProdTypeCd 조회
    @PostMapping("/selectProdTypeCd")
    public ResponseEntity<String> selectProdTypeCd(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectProdTypeCd");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectProdTypeCd(requestPayload)));
    }

    // selectProdTypeCd 조회( 존재하는 값만 조회)
    @PostMapping("/selectProdTypeCdByFcstPalId")
    public ResponseEntity<String> selectProdTypeCdByFcstPalId(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectProdTypeCd");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BsnsProfitLossVO>>(){});

        return super.composePayload(new Payload<List>(estimatePSService.selectProdTypeCdByFcstPalId(requestPayload)));
    }

    // excel 엑셀

    // 예상손익 기본리스트 엑셀 다운로드
    @PostMapping("/selectExceldownloadBasicEstimateAnalysisList")
    public ResponseEntity<String> selectExceldownloadBasicEstimateAnalysisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExceldownloadBasicEstimateAnalysisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<FcstPalSearchVO>>(){});

        return super.composePayload(new Payload<List>(excelService.selectExceldownloadBasicEstimateAnalysisList(requestPayload)));
    }


    // 예상손익 상품타입별 리스트 엑셀 다운로드
    @PostMapping("/selectExceldownloadEstimateByProdTypeList")
    public ResponseEntity<String> selectExceldownloadEstimateByProdTypeList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExceldownloadEstimateByProdTypeList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<FcstPalSearchVO>>(){});

        return super.composePayload(new Payload<List>(excelService.selectExceldownloadEstimateByProdTypeList(requestPayload)));
    }


    // 예상손익 상품별 리스트 엑셀 다운로드
    @PostMapping("/selectExceldownloadEstimateByProductList")
    public ResponseEntity<String> selectExceldownloadEstimateByProductList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExceldownloadEstimateByProductList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<FcstPalSearchVO>>(){});

        return super.composePayload(new Payload<List>(excelService.selectExceldownloadEstimateByProductList(requestPayload)));
    }

}
