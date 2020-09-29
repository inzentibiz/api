package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.ApprovalVO;
import com.ibiz.api.model.OfferProfitSearchVO;
import com.ibiz.api.model.OfferVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.OfferProfitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class OfferProfitController extends BaseController {

    @Autowired
    private OfferProfitService offerProfitService;

    @GetMapping("/offerProfitController")
    public String checkState() {
        return "estimate-7300";
    }

    /*
     *  P&S ver1 , MA
     */


    // 예상손익분석서 리스트 조회
    @PostMapping("/selectOfferProfitList")
    public ResponseEntity<String> selectOfferProfitList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferProfitSearchVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectOfferProfitList(requestPayload)));
    }

    // 예상손익분석서(P&S) 상세조회
    @PostMapping("/selectOfferProfitPS1")
    public ResponseEntity<String> selectOfferProfitPS1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitPS1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.selectOfferProfitPS1(requestPayload)));
    }

    // 예상손익분석서(P&S) 저장
    @PostMapping("/insertOfferProfitPS1")
    public ResponseEntity<String> insertOfferProfitPS1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertOfferProfitPS1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.insertOfferProfitPS1(requestPayload)));
    }

    // 예상손익분석서(P&S) 수정
    @PostMapping("/updateOfferProfitPS1")
    public ResponseEntity<String> updateOfferProfitPS1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitPS1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitPS1(requestPayload)));
    }

    // 예상손익분석서(P&S) 삭제
    @PostMapping("/deleteOfferProfitPS1")
    public ResponseEntity<String> deleteOfferProfitPS1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteOfferProfitPS1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.deleteOfferProfitPS1(requestPayload)));
    }

    // 예상손익분석서(P&S)  프로젝트 경비 직접비 기준 리스트 조회
    @PostMapping("/selectDirectCostCriteriaList")
    public ResponseEntity<String> selectDirectCostCriteriaList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDirectCostCriteriaList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectDirectCostCriteriaList()));
    }

    // 예상손익분석서(P&S)  프로젝트 경비 직접비 리스트 조회 (바인딩)
    @PostMapping("/selectDirectCostBindList")
    public ResponseEntity<String> selectDirectCostBindList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDirectCostBindList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectDirectCostBindList(requestPayload)));
    }

    // 3. VRB 대상선정 및 평가결과 : VRB 대상선정 기준항목 조회
    @PostMapping("/selectVrbCriteriaList")
    public ResponseEntity<String> selectVrbCriteriaList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectVrbCriteriaList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectVrbCriteriaList(requestPayload)));
    }

    // 예상손익분석서(솔루션.MA) 기안버튼리스트
    @PostMapping("/selectOfferProfitDrfBtnList")
    public ResponseEntity<String> selectOfferProfitDrfBtnList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitDrfBtnList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(offerProfitService.selectOfferProfitDrfBtnList(requestPayload)));
    }

    // 예상손익분석서 폐기
    @PostMapping("/updateOfferProfitDisposal")
    public ResponseEntity<String> updateOfferProfitDisposal(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitDisposal");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitDisposal(requestPayload)));
    }

    /*
     * Maintenace
     */

    // 예상손익분석서(MA) 상세조회
    @PostMapping("/selectOfferProfitMA1View")
    public ResponseEntity<String> selectOfferProfitMA1View(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitMA1View");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.selectOfferProfitMA1View(requestPayload)));
    }

    // 예상손익분석서(MA) 저장
    @PostMapping("/insertOfferProfitMA1")
    public ResponseEntity<String> insertOfferProfitMA1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertOfferProfitMA1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.insertOfferProfitMA1(requestPayload)));
    }

    // 예상손익분석서(MA) 수정
    @PostMapping("/updateOfferProfitMA1")
    public ResponseEntity<String> updateOfferProfitMA1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitMA1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitMA1(requestPayload)));
    }

    // 예상손익분석서(MA) 삭제
    @PostMapping("/deleteOfferProfitMA1")
    public ResponseEntity<String> deleteOfferProfitMA1(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteOfferProfitMA1");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.deleteOfferProfitMA1(requestPayload)));
    }


    // updateOfferProfitStat 결재진행상태 동기화
    @PostMapping("/updateOfferProfitStat")
    public ResponseEntity<String> updateOfferProfitStat(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitStat");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitStat(requestPayload)));
    }

    // selectOfferRstProdTypeList 조회
    @PostMapping("/selectOfferRstProdTypeList")
    public ResponseEntity<String> selectOfferRstProdTypeList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferRstProdTypeList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectOfferRstProdTypeList(requestPayload)));
    }

    // selectOfferRstProdTypeList 조회( 존재하는 값만 조회)
    @PostMapping("/selectOfferRstProdTypeView")
    public ResponseEntity<String> selectOfferRstProdTypeView(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferRstProdTypeView");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectOfferRstProdTypeView(requestPayload)));
    }

    // excel 엑셀

    // 예상손익 기본리스트 엑셀 다운로드
    @PostMapping("/seleceExcelDwnlOfferProfitList")
    public ResponseEntity<String> seleceExcelDwnlOfferProfitList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferProfitSearchVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.seleceExcelDwnlOfferProfitList(requestPayload)));
    }


    // 예상손익 상품타입별 리스트 엑셀 다운로드
    @PostMapping("/seleceExcelDwnlOfferProfitByProdTypeList")
    public ResponseEntity<String> seleceExcelDwnlOfferProfitByProdTypeList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProdTypeList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferProfitSearchVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.seleceExcelDwnlOfferProfitByProdTypeList(requestPayload)));
    }


    // 예상손익 상품별 리스트 엑셀 다운로드
    @PostMapping("/seleceExcelDwnlOfferProfitByProductList")
    public ResponseEntity<String> seleceExcelDwnlOfferProfitByProductList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".seleceExcelDwnlOfferProfitByProductList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferProfitSearchVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.seleceExcelDwnlOfferProfitByProductList(requestPayload)));
    }
    
    
    /*
     *  P&S ver2
     */

    // 예상손익분석서(P&S)2 상세조회
    @PostMapping("/selectOfferProfitPS2")
    public ResponseEntity<String> selectOfferProfitPS2(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitPS2");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.selectOfferProfitPS2(requestPayload)));
    }

    // 예상손익분석서(P&S)2 저장
    @PostMapping("/insertOfferProfitPS2")
    public ResponseEntity<String> insertOfferProfitPS2(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertOfferProfitPS2");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.insertOfferProfitPS2(requestPayload)));
    }

    // 예상손익분석서(P&S) 2수정
    @PostMapping("/updateOfferProfitPS2")
    public ResponseEntity<String> updateOfferProfitPS2(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitPS2");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitPS2(requestPayload)));
    }

    // 예상손익분석서(P&S)2 삭제
    @PostMapping("/deleteOfferProfitPS2")
    public ResponseEntity<String> deleteOfferProfitPS2(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteOfferProfitPS2");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.deleteOfferProfitPS2(requestPayload)));
    }

    // 예상손익분석서(P&S)  프로젝트 경비 등록 수정용 조회
    @PostMapping("/selectDirectCostList")
    public ResponseEntity<String> selectDirectCostList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDirectCostList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectDirectCostList(requestPayload)));
    }

    // 예상손익분석서(솔루션.MA) 기안버튼리스트
    @PostMapping("/selectOfferProfitPS2DrfBtnList")
    public ResponseEntity<String> selectOfferProfitPS2DrfBtnList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectOfferProfitPS2DrfBtnList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(offerProfitService.selectOfferProfitPS2DrfBtnList(requestPayload)));
    }

/*
    // 예상손익분석서2 폐기
    @PostMapping("/updateOfferProfitPS2Dss")
    public ResponseEntity<String> updateOfferProfitPS2Dss(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitPS2Dss");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<ApprovalVO>>(){});

        return super.composePayload(new Payload<ApprovalVO>(offerProfitService.updateOfferProfitPS2Dss(requestPayload)));
    }
*/

/*

    // updateVRBAnalysisStat 결재진행상태 동기화
    @PostMapping("/updateOfferProfitPS2Stat")
    public ResponseEntity<String> updateOfferProfitPS2Stat(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateOfferProfitPS2Stat");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.updateOfferProfitPS2Stat(requestPayload)));
    }
*/

    // 실적집계 조회
    @PostMapping("/selectEstimateRslSmryList")
    public ResponseEntity<String> selectEstimateRslSmryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEstimateRslSmryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<List>(offerProfitService.selectEstimateRslSmryList(requestPayload)));
    }

    // 변경전 예상손익분석서(P&S) 조회
    @PostMapping("/selectBeforeEstimatedPSAnalysis")
    public ResponseEntity<String> selectBeforeEstimatedPSAnalysis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectBeforeEstimatedPSAnalysis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<OfferVO>>(){});

        return super.composePayload(new Payload<OfferVO>(offerProfitService.selectBeforeEstimatedPSAnalysis(requestPayload)));
    }

}

