package com.ibiz.api.service;

import com.ibiz.api.dao.EstimateDao;
import com.ibiz.api.dao.ProjectBizOpptyDao;
import com.ibiz.api.dao.ProjectSalesDao;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
public class ProjectBizOpptyService {

    @Resource(name = "projectBizOpptyDao")
    private ProjectBizOpptyDao projectBizOpptyDao;

    @Resource(name="projectSalesDao")
    private ProjectSalesDao projectSalesDao;

    @Resource(name = "estimateDao")
    private EstimateDao estimateDao;

    @Transactional
    public List<BizOpportunityVO> selectBizOpportunityList(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunityList");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<BizOpportunityVO> BizOpportList = projectBizOpptyDao.selectBizOpportunityList(bizOpportunitySearchVO);

        return BizOpportList;
    }

    @Transactional
    public List<BizOpportunityVO> selectBizOpportunityDetailList(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunityDetailList");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        BizOpportunityAmtVO bizOpportunityAmtVO = new BizOpportunityAmtVO();
        BizOpportunityNopVO bizOpportunityNopVO = new BizOpportunityNopVO();

        List<BizOpportunityVO> bizOpportList = projectBizOpptyDao.selectBizOpportunityDetailList(bizOpportunitySearchVO);

        for(int i=0; i<bizOpportList.size(); i++) {
            bizOpportunityAmtVO.setBoptId(bizOpportList.get(i).getBoptId());
            bizOpportunityNopVO.setBoptId(bizOpportList.get(i).getBoptId());

            List<BizOpportunityAmtVO> amtList = projectBizOpptyDao.selectBizOpportunityAmtList(bizOpportunityAmtVO);
            List<BizOpportunityNopVO> nopList = projectBizOpptyDao.selectBizOpportunityNopList(bizOpportunityNopVO);

            bizOpportList.get(i).setBizOpportunityAmtList(amtList);
            bizOpportList.get(i).setBizOpportunityNopList(nopList);

            bizOpportList.get(i).setSumPutNopCount(0);
            for(int j=0; j<nopList.size(); j++) {
                bizOpportList.get(i).setSumPutNopCount(bizOpportList.get(i).getSumPutNopCount() + nopList.get(j).getPutNopCount());
            }
            bizOpportList.get(i).setSumSellAmt(0);
            bizOpportList.get(i).setSumBuyAmt(0);
            for(int j=0; j<amtList.size(); j++) {

                bizOpportList.get(i).setSumSellAmt(bizOpportList.get(i).getSumSellAmt() + (amtList.get(j).getSellAmt()== null? 0: amtList.get(j).getSellAmt()));
                bizOpportList.get(i).setSumBuyAmt(bizOpportList.get(i).getSumBuyAmt() + (amtList.get(j).getBuyAmt()== null? 0: amtList.get(j).getBuyAmt()) );
            }
        }

        bizOpportList.get(0).setChgDtView(bizOpportList.get(0).getChgDt());

        return bizOpportList;
    }

    @Transactional
    public List<BizOpportunityHistoryVO> selectBizOpportunityHistoryList(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunityHistoryList");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<BizOpportunityHistoryVO> data = null;
        // historyGrpCd 분기
        if(bizOpportunitySearchVO.getHistoryGroupCd().equals("WCT")){
            data = projectBizOpptyDao.selectBizOpportunityHistoryWctList(bizOpportunitySearchVO);
        } else if(bizOpportunitySearchVO.getHistoryGroupCd().equals("SELL")){
            data = projectBizOpptyDao.selectBizOpportunityHistorySellList(bizOpportunitySearchVO);
        } else if(bizOpportunitySearchVO.getHistoryGroupCd().equals("BUY")){
            data = projectBizOpptyDao.selectBizOpportunityHistoryBuyList(bizOpportunitySearchVO);
        } else if(bizOpportunitySearchVO.getHistoryGroupCd().equals("PN")){
            data = projectBizOpptyDao.selectBizOpportunityHistoryPncList(bizOpportunitySearchVO);
        }

        return data;
    }

    @Transactional
    public List<BizOpportunityVO> selectBizOpportunitySearchList(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunitySearchList");
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<BizOpportunityVO> BizOpportList = projectBizOpptyDao.selectBusinessOpportunitySearchList(bizOpportunitySearchVO);

        return BizOpportList;
    }

    // INSERT

    @Transactional
    public BizOpportunityVO insertBizOpportunity(Payload<BizOpportunityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".insertBizOpportunity");

        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        String prevId = projectBizOpptyDao.selectMaxBoptId().getBoptId();

        bizOpportunityVO.setBoptId(IndexUtils.generateId(10, prevId));
        bizOpportunityVO.setRegEmpId(accountVO.getEmpId());
        bizOpportunityVO.setChgEmpId(accountVO.getEmpId());

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);

        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizOpportunityVO.setChgDt(chgDt);
        projectBizOpptyDao.insertBizOpportunity(bizOpportunityVO);
        projectBizOpptyDao.insertBizOpportunityHistory(bizOpportunityVO);

        if(bizOpportunityVO.getBizOpportunityAmtList() != null) {
            int amtSeq = 1;
            for(BizOpportunityAmtVO bizOpportunityAmtVO : bizOpportunityVO.getBizOpportunityAmtList()) {
                bizOpportunityAmtVO.setBoptId(bizOpportunityVO.getBoptId());
                bizOpportunityAmtVO.setChgDt(chgDt);
                bizOpportunityAmtVO.setSeq(amtSeq);
                bizOpportunityAmtVO.setSellAmt( (bizOpportunityAmtVO.getSellAmt() == null? 0: bizOpportunityAmtVO.getSellAmt() * 1000) );
                bizOpportunityAmtVO.setBuyAmt( (bizOpportunityAmtVO.getBuyAmt() == null? 0: bizOpportunityAmtVO.getBuyAmt() * 1000) );
                projectBizOpptyDao.insertBizOpportunityAmt(bizOpportunityAmtVO);
                projectBizOpptyDao.insertBizOpportunityAmtHistory(bizOpportunityAmtVO);
                amtSeq++;
            }
        }
        if(bizOpportunityVO.getBizOpportunityNopList() != null) {
            for(BizOpportunityNopVO bizOpportunityNopVO : bizOpportunityVO.getBizOpportunityNopList()) {
                bizOpportunityNopVO.setBoptId(bizOpportunityVO.getBoptId());
                bizOpportunityNopVO.setPutTimeUnitCd("A");
                bizOpportunityNopVO.setChgDt(chgDt);

                projectBizOpptyDao.insertBizOpportunityNop(bizOpportunityNopVO);
                projectBizOpptyDao.insertBizOpportunityNopHistory(bizOpportunityNopVO);
            }
        }

        return bizOpportunityVO;
    }

    // UPDATE

    @Transactional
    public BizOpportunityVO updateBizOpportunity(Payload<BizOpportunityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizOpportunity");
        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        bizOpportunityVO.setChgEmpId(accountVO.getEmpId());

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);
        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizOpportunityVO.setChgDt(chgDt);
        projectBizOpptyDao.updateBizOpportunity(bizOpportunityVO);
        // 변경이력(히스토리) 테이블에 적재..
        // 동일한 날짜로 이력된게 있으면 지우고 적재..
        if( projectBizOpptyDao.selectBusinessOpportunityHistoryCount(bizOpportunityVO) > 0) {
            projectBizOpptyDao.deleteBizOpportunityAmtHistory(bizOpportunityVO);
            projectBizOpptyDao.deleteBizOpportunityNopHistory(bizOpportunityVO);
            projectBizOpptyDao.deleteBizOpportunityHistory(bizOpportunityVO);
        }
        projectBizOpptyDao.insertBizOpportunityHistory(bizOpportunityVO);

        if(bizOpportunityVO.getBizOpportunityAmtList() != null) {
            projectBizOpptyDao.deleteAllBizOpportunityAmt(bizOpportunityVO);

            int amtSeq = 1;
            for(BizOpportunityAmtVO bizOpportunityAmtVO : bizOpportunityVO.getBizOpportunityAmtList()) {
                bizOpportunityAmtVO.setBoptId(bizOpportunityVO.getBoptId());
                bizOpportunityAmtVO.setChgDt(chgDt);
                bizOpportunityAmtVO.setSeq(amtSeq);

                bizOpportunityAmtVO.setSellAmt( (bizOpportunityAmtVO.getSellAmt() == null? 0: bizOpportunityAmtVO.getSellAmt() * 1000) );
                bizOpportunityAmtVO.setBuyAmt( (bizOpportunityAmtVO.getBuyAmt() == null? 0: bizOpportunityAmtVO.getBuyAmt() * 1000) );
                projectBizOpptyDao.insertBizOpportunityAmt(bizOpportunityAmtVO);
                projectBizOpptyDao.insertBizOpportunityAmtHistory(bizOpportunityAmtVO);
                amtSeq++;
            }
        }

        if(bizOpportunityVO.getBizOpportunityNopList() != null) {
            projectBizOpptyDao.deleteAllBizOpportunityNop(bizOpportunityVO);

            for(BizOpportunityNopVO bizOpportunityNopVO : bizOpportunityVO.getBizOpportunityNopList()) {
                bizOpportunityNopVO.setBoptId(bizOpportunityVO.getBoptId());
                bizOpportunityNopVO.setPutTimeUnitCd("A");
                bizOpportunityNopVO.setChgDt(chgDt);

                projectBizOpptyDao.insertBizOpportunityNop(bizOpportunityNopVO);
                projectBizOpptyDao.insertBizOpportunityNopHistory(bizOpportunityNopVO);

            }
        }

        return bizOpportunityVO;
    }

    // DELETE

    @Transactional
    public Boolean deleteBizOpportunity(Payload<BizOpportunityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".deleteBizOpportunity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();
        BizOpportunityVO bizOpportunityVO2 = new BizOpportunityVO();
        Boolean YN = true;

        //현재 날짜 구하기
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd", Locale.KOREA );
        Date currentTime = new Date ();
        String today = mSimpleDateFormat.format (currentTime);

        //ChgDt
        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);
        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizOpportunityVO.setChgDt(chgDt);

        // 예상손익분석/견적서가 존재하는지 여부를 확인 후 삭제시도.. 존재할 경우 "예상손익분석/견적서가 존재하여 삭제 불가능합니다."
        FcstPalVO fcstPalVO = new FcstPalVO();
        fcstPalVO.setBoptId(bizOpportunityVO.getBoptId());

        if( !(estimateDao.selectIsExistForcastPAL(fcstPalVO) > 0)) {	//예상손익&견적서 있는 지 비교
            if(!bizOpportunityVO.getRegDt().equals(today)) {

                bizOpportunityVO = projectBizOpptyDao.selectBizOpportunityInfo(bizOpportunityVO);

                bizOpportunityVO.setBoptStatCd("D1");
                bizOpportunityVO.setChgDt(chgDt);

                projectBizOpptyDao.updateBizOpportunityStat(bizOpportunityVO);//상태 변경

                //삭제 변경하면서 매출 매입, 투입인원 삭제 + 영업활동내역도 삭제
                projectBizOpptyDao.deleteAllBizOpportunityAmt(bizOpportunityVO); //월별 매출매입삭제
                projectBizOpptyDao.deleteAllBizOpportunityNop(bizOpportunityVO); //투입인원 삭제
                projectBizOpptyDao.deleteAllSalesActivity(bizOpportunityVO); //영업활동내역 삭제


                //이력 등록 당일 이력 중복이 체크하고 등록
                if( projectBizOpptyDao.selectBusinessOpportunityHistoryCount(bizOpportunityVO) > 0) {
                    projectBizOpptyDao.deleteBizOpportunityAmtHistory(bizOpportunityVO);
                    projectBizOpptyDao.deleteBizOpportunityNopHistory(bizOpportunityVO);
                    projectBizOpptyDao.deleteBizOpportunityHistory(bizOpportunityVO);
                }

                projectBizOpptyDao.insertBizOpportunityHistory(bizOpportunityVO);


            }else {
                projectBizOpptyDao.deleteAllBizOpportunityAmt(bizOpportunityVO); //월별 매출매입삭제
                projectBizOpptyDao.deleteAllBizOpportunityNop(bizOpportunityVO); //투입인원 삭제
                projectBizOpptyDao.deleteAllBizOpportunityAmtHistory(bizOpportunityVO); //월별 매출매입 이력삭제
                projectBizOpptyDao.deleteAllBizOpportunityNopHistory(bizOpportunityVO);	//투입인원 이력삭제
                projectBizOpptyDao.deleteAllBizOpportunityHistory(bizOpportunityVO); //사업기회 이력삭제
                projectBizOpptyDao.deleteAllSalesActivity(bizOpportunityVO); //영업활동내역 삭제
                projectBizOpptyDao.deleteBizOpportunity(bizOpportunityVO); //사업기회 삭제
            }

            YN = true;
        }else {
            YN = false;
        }

        return YN;
    }

    @Transactional
    public List<BizOpportunityVO> AssociatedBizOpportunity(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".AssociatedBizOpportunity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<BizOpportunityVO> BizOpportList = projectBizOpptyDao.selectAssociatedBizOpportunity(bizOpportunitySearchVO);

        return BizOpportList;
    }

    @Transactional
    public List<BizOpportunityVO> ApplicableProfitAnalysis(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".ApplicableProfitAnalysis");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        List<BizOpportunityVO> BizOpportList = null;

        String prjtTypeCd = projectBizOpptyDao.selectPrjtTypeCd(bizOpportunitySearchVO.getBoptId());
        bizOpportunitySearchVO.setPrjtTypeCd(prjtTypeCd);

        //해당 예상손익분석서
        if(bizOpportunitySearchVO.getPrjtTypeCd().equals("B2")) {
            BizOpportList = projectBizOpptyDao.selectApplicableMAProfitAnalysis(bizOpportunitySearchVO);
        }else {
            BizOpportList = projectBizOpptyDao.selectApplicablePnsProfitAnalysis(bizOpportunitySearchVO);
        }

        return BizOpportList;
    }

    @Transactional
    public BizOpportunityVO selectBizOpportunityDetail(Payload<BizOpportunityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunityDetail");
        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();

        BizOpportunityAmtVO bizOpportunityAmtVO = new BizOpportunityAmtVO();
        BizOpportunityNopVO bizOpportunityNopVO = new BizOpportunityNopVO();

        bizOpportunityAmtVO.setBoptId(bizOpportunityVO.getBoptId());
        bizOpportunityNopVO.setBoptId(bizOpportunityVO.getBoptId());

        BizOpportunityVO bizOpportunity = projectBizOpptyDao.selectBizOpportunityDetail(bizOpportunityVO);
        List<BizOpportunityAmtVO> amtList = projectBizOpptyDao.selectBizOpportunityAmtList(bizOpportunityAmtVO);
        List<BizOpportunityNopVO> nopList = projectBizOpptyDao.selectBizOpportunityNopList(bizOpportunityNopVO);

        bizOpportunity.setBizOpportunityAmtList(amtList);
        bizOpportunity.setBizOpportunityNopList(nopList);
        bizOpportunity.setChgDtView(bizOpportunity.getChgDt());

        bizOpportunity.setSalesActivityList(projectSalesDao.selectSalesActivityList(bizOpportunityVO));

        return bizOpportunity;
    }


    @Transactional
    public List<BizOpportunityVO> selectBizOpportunityForSlsEmpTransferList(Payload<BizOpportunitySearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizOpportunityForSlsEmpTransferList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunitySearchVO bizOpportunitySearchVO = requestPayload.getDto();

        if(bizOpportunitySearchVO.getSlsEmpId() != "" && bizOpportunitySearchVO.getSlsEmpId() != null) {
            bizOpportunitySearchVO.setSlsDeptId(null);
        }

        bizOpportunitySearchVO.setUserId(accountVO.getEmpId());

        // 데이터 받을 준비
        List<BizOpportunityVO> data = projectBizOpptyDao.selectBizOpportunityForSlsEmpTransferList(bizOpportunitySearchVO);

        return data;
    }

    @Transactional
    public BizOpportunityVO updateBizOpportunityForSlsEmpTransfer(Payload<BizOpportunityVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizOpportunityForSlsEmpTransfer");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizOpportunityVO bizOpportunityVO = requestPayload.getDto();

        List<BizOpportunityHistoryVO> data = null;
        BizOpportunityVO transferBizOpportunityVO = new BizOpportunityVO();

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);

        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizOpportunityVO.setChgDt(chgDt);
        transferBizOpportunityVO.setChgDt(chgDt);

        //boptId, slsEmpId, slsDeptId
        bizOpportunityVO.getSlsDeptId();
        bizOpportunityVO.getSlsEmpId();

        try{
            for(BizOpportunityVO model : bizOpportunityVO.getBizOpportunityTransferList()) {
                bizOpportunityVO.setBoptId(model.getBoptId());
                transferBizOpportunityVO.setBoptId(model.getBoptId());

                //주테이블 업뎃
                projectBizOpptyDao.updateBizOpportunitySlsInfo(bizOpportunityVO);

                //주테이블 검색
                transferBizOpportunityVO = projectBizOpptyDao.selectBizOpportunityInfo(bizOpportunityVO);


                transferBizOpportunityVO.setChgDt(chgDt);
                //ChgDt
                if( projectBizOpptyDao.selectBusinessOpportunityHistoryCount(transferBizOpportunityVO) > 0) {
                    projectBizOpptyDao.deleteBizOpportunityAmtHistory(transferBizOpportunityVO);
                    projectBizOpptyDao.deleteBizOpportunityNopHistory(transferBizOpportunityVO);
                    projectBizOpptyDao.deleteBizOpportunityHistory(transferBizOpportunityVO);
                }

                //이력(주)인서트
                projectBizOpptyDao.insertBizOpportunityHistory(transferBizOpportunityVO);

                //이력(서브)인서트(따로생성)
                projectBizOpptyDao.insertBizOpportunityAmtTransferHistory(transferBizOpportunityVO);
                projectBizOpptyDao.insertBizOpportunityNopTransferHistory(transferBizOpportunityVO);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return bizOpportunityVO;
        }

        return bizOpportunityVO;
    }

}
