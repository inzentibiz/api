package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.dao.ProjectBizOpptyDao;
import com.ibiz.api.dao.ProjectSalesDao;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class ProjectSalesService {

    @Resource(name = "projectSalesDao")
    private ProjectSalesDao projectSalesDao;

    @Transactional
    public List<SalesActivityVO> selectSalesActivityList(Payload<BizOpportunityVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".selectSalesActivityList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();

        List<SalesActivityVO> salesActivityList = projectSalesDao.selectSalesActivityList(bizOpportunityVO);

        return salesActivityList;
    }

    @Transactional
    public SalesActivityVO insertSalesActivity(Payload<SalesActivityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertSalesActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        SalesActivityVO salesActivityVO = requestPayload.getDto();

        String prevId = projectSalesDao.selectMaxSlsActId().getSlsActId();

        salesActivityVO.setSlsActId(IndexUtils.generateId(10, prevId));
        salesActivityVO.setRegEmpId(accountVO.getEmpId());

        projectSalesDao.insertSalesActivity(salesActivityVO);

        return salesActivityVO;
    }

    @Transactional
    public SalesActivityVO updateSalesActivity(Payload<SalesActivityVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".updateSalesActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        SalesActivityVO salesActivityVO = requestPayload.getDto();

        salesActivityVO.setChgEmpId(accountVO.getEmpId());
        projectSalesDao.updateSalesActivity(salesActivityVO);

        return salesActivityVO;
    }

    @Transactional
    public SalesActivityVO deleteSalesActivity(Payload<SalesActivityVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".deleteSalesActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        SalesActivityVO salesActivityVO = requestPayload.getDto();

        projectSalesDao.deleteSalesActivity(salesActivityVO);

        return salesActivityVO;
    }



}
