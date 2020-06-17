package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.dao.ProjectBizOpptyDao;
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

    @Resource(name = "projectBizOpptyDao")
    private ProjectBizOpptyDao projectBizOpptyDao;

    @Resource(name = "estimateDao")
    private EstimateDao estimateDao;

    @Transactional
    public List<ExcelBizOpportunityVO> selectExceldownloadBizOpportunity(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".getBizOpportunityDetailList");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<ExcelBizOpportunityVO> list = projectBizOpptyDao.selectBizOpportunityListForExcel(bizOpportunitySearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getCntrDate() != null && list.get(i).getCntrDate() != "") {
                String cntrDate = list.get(i).getCntrDate();
                cntrDate = afterFormat.format(beforeFormat.parse(cntrDate));
                list.get(i).setCntrDate(cntrDate);
            }
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
            if(list.get(i).getPrpsFnshDate() != null && list.get(i).getPrpsFnshDate() != "") {
                String prpsFnshDate = list.get(i).getPrpsFnshDate();
                prpsFnshDate = afterFormat.format(beforeFormat.parse(prpsFnshDate));
                list.get(i).setPrpsFnshDate(prpsFnshDate);
            }
            if(list.get(i).getBidFnshDate() != null && list.get(i).getBidFnshDate() != "") {
                String bidFnshDate = list.get(i).getBidFnshDate();
                bidFnshDate = afterFormat.format(beforeFormat.parse(bidFnshDate));
                list.get(i).setBidFnshDate(bidFnshDate);
            }
            if(list.get(i).getCmpySlctDate() != null && list.get(i).getCmpySlctDate() != "") {
                String cmpySlctDate = list.get(i).getCmpySlctDate();
                cmpySlctDate = afterFormat.format(beforeFormat.parse(cmpySlctDate));
                list.get(i).setCmpySlctDate(cmpySlctDate);
            }
            if(list.get(i).getWctDcdDate() != null && list.get(i).getWctDcdDate() != "") {
                String wctDcdDate = list.get(i).getWctDcdDate();
                wctDcdDate = afterFormat.format(beforeFormat.parse(wctDcdDate));
                list.get(i).setWctDcdDate(wctDcdDate);
            }
        }

        return list;
    }

    @Transactional
    public List<ExcelBizOpportunityDetailVO> selectExceldownloadBizOpportunityDetail(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExceldownloadBizOpportunityDetail");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<ExcelBizOpportunityDetailVO> list = projectBizOpptyDao.selectBizOpportunityDetailListForExcel(bizOpportunitySearchVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat beforeMMFormat = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat afterMMFormat = new SimpleDateFormat("yyyy-MM");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getCntrDate() != null && list.get(i).getCntrDate() != "") {
                String cntrDate = list.get(i).getCntrDate();
                cntrDate = afterFormat.format(beforeFormat.parse(cntrDate));
                list.get(i).setCntrDate(cntrDate);
            }
            if(list.get(i).getFcstYam() != null && list.get(i).getFcstYam() != "") {
                String fcstYam = list.get(i).getFcstYam();
                fcstYam = afterMMFormat.format(beforeMMFormat.parse(fcstYam));
                list.get(i).setFcstYam(fcstYam);
            }
        }

        return list;
    }


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
