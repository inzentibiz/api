package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.dao.BizChanceDAO;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class ExcelService {

    @Resource(name = "bizChanceDAO")
    private BizChanceDAO bizChanceDAO;

    @Resource(name = "estimateDao")
    private EstimateDao estimateDao;


    @Transactional
    public List<ExcelBasicEstimateAnalysisVO> selectExceldownloadBasicEstimateAnalysisList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExceldownloadBasicEstimateAnalysisList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelBasicEstimateAnalysisVO> list = estimateDao.selectBasicEstimateAnalysisListForExcel(fcstPalSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelProductTypeEstimateVO> selectExceldownloadEstimateByProdTypeList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExceldownloadEstimateByProdTypeList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelProductTypeEstimateVO> list = estimateDao.selectEstimateByProdTypeListForExcel(fcstPalSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelProductEstimateVO> selectExceldownloadEstimateByProductList(Payload<FcstPalSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExceldownloadEstimateByProductList");
        FcstPalSearchVO fcstPalSearchVO = requestPayload.getDto();

        List<ExcelProductEstimateVO> list = estimateDao.selectEstimateByProductListForExcel(fcstPalSearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if(list.get(i).getCntrTrsfStartYam() != null && list.get(i).getCntrTrsfStartYam() != "") {
                String cntrTrsfStartYam = list.get(i).getCntrTrsfStartYam();
                cntrTrsfStartYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfStartYam));
                list.get(i).setCntrTrsfStartYam(cntrTrsfStartYam);
            }
            if(list.get(i).getCntrTrsfEndYam() != null && list.get(i).getCntrTrsfEndYam() != "") {
                String cntrTrsfEndYam = list.get(i).getCntrTrsfEndYam();
                cntrTrsfEndYam = afterMMFormat.format(beforeMMFormat.parse(cntrTrsfEndYam));
                list.get(i).setCntrTrsfEndYam(cntrTrsfEndYam);
            }
        }

        return list;
    }

}
