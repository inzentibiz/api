package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.BizOpportunityVO;
import com.ibiz.api.model.Payload;
import com.ibiz.api.model.SalesActivityVO;
import com.ibiz.api.service.ProjectSalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProjectSalesController extends BaseController {

    @Autowired
    private ProjectSalesService projectSalesService;

    @GetMapping("/projectSalesController")
    public String checkState() {
        return "projectSalesController-8200";
    }

    @PostMapping("/selectSalesActivityList")
    public ResponseEntity<String> selectSalesActivityList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectSalesActivityList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<BizOpportunityVO>>(){});

        return super.composePayload(new Payload<List>(projectSalesService.selectSalesActivityList(requestPayload)));
    }

    @PostMapping("/insertSalesActivity")
    public ResponseEntity<String> insertSalesActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".insertSalesActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<SalesActivityVO>>(){});

        return super.composePayload(new Payload<SalesActivityVO>(projectSalesService.insertSalesActivity(requestPayload)));
    }

    @PostMapping("/updateSalesActivity")
    public ResponseEntity<String> updateSalesActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateSalesActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<SalesActivityVO>>(){});

        return super.composePayload(new Payload<SalesActivityVO>(projectSalesService.updateSalesActivity(requestPayload)));
    }

    @PostMapping("/deleteSalesActivity")
    public ResponseEntity<String> deleteSalesActivity(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteSalesActivity");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<SalesActivityVO>>(){});

        return super.composePayload(new Payload<SalesActivityVO>(projectSalesService.deleteSalesActivity(requestPayload)));
    }

}
