package com.ibiz.api.service;

import com.ibiz.api.dao.BizChanceDAO;
import com.ibiz.api.dao.OfferProfitDAO;
import com.ibiz.api.exception.DeleteDeniedException;
import com.ibiz.api.exception.UpdateDeniedException;
import com.ibiz.api.model.*;
import com.ibiz.api.utils.IndexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class BizChanceService {

    @Resource(name = "bizChanceDAO")
    private BizChanceDAO bizChanceDAO;

    @Resource(name = "offerProfitDAO")
    private OfferProfitDAO offerProfitDAO;

    @Transactional
    public List<BizChanceVO> selectBizChanceList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> bizChanceList = bizChanceDAO.selectBizChanceList(bizChanceSearchVO);

        return bizChanceList;
    }
/*

    @Transactional
    public List<BizChanceVO> selectBizChanceView(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceView");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        BizChanceAmountVO bizChanceAmountVO = new BizChanceAmountVO();
        BizChancePersonVO bizChancePersonVO = new BizChancePersonVO();

        List<BizChanceVO> bizChanceList = bizChanceDAO.selectBizChanceView(bizChanceSearchVO);

        for(int i=0; i<bizChanceList.size(); i++) {
            bizChanceAmountVO.setBoptId(bizChanceList.get(i).getBoptId());
            bizChancePersonVO.setBoptId(bizChanceList.get(i).getBoptId());

            List<BizChanceAmountVO> amtList = bizChanceDAO.selectBizChanceAmtList(bizChanceAmountVO);
            List<BizChancePersonVO> nopList = bizChanceDAO.selectBizChanceNopList(bizChancePersonVO);

            bizChanceList.get(i).setBizChanceAmtList(amtList);
            bizChanceList.get(i).setBizChanceNopList(nopList);

            bizChanceList.get(i).setSumPutNopCount(0);
            for(int j=0; j<nopList.size(); j++) {
                bizChanceList.get(i).setSumPutNopCount(bizChanceList.get(i).getSumPutNopCount() + nopList.get(j).getPutNopCount());
            }
            bizChanceList.get(i).setSumSellAmt(0);
            bizChanceList.get(i).setSumBuyAmt(0);
            for(int j=0; j<amtList.size(); j++) {

                bizChanceList.get(i).setSumSellAmt(bizChanceList.get(i).getSumSellAmt() + (amtList.get(j).getSellAmt()== null? 0: amtList.get(j).getSellAmt()));
                bizChanceList.get(i).setSumBuyAmt(bizChanceList.get(i).getSumBuyAmt() + (amtList.get(j).getBuyAmt()== null? 0: amtList.get(j).getBuyAmt()) );
            }
        }

        bizChanceList.get(0).setChgDtView(bizChanceList.get(0).getChgDt());

        return bizChanceList;
    }
*/


    @Transactional
    public BizChanceVO selectBizChance(Payload<BizChanceVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChance");
        BizChanceVO bizChanceVO = requestPayload.getDto();

        BizChanceAmountVO bizChanceAmountVO = new BizChanceAmountVO();
        BizChancePersonVO bizChancePersonVO = new BizChancePersonVO();

        bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
        bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());

        BizChanceVO bizChance = bizChanceDAO.selectBizChance(bizChanceVO);
        List<BizChanceAmountVO> amtList = bizChanceDAO.selectBizChanceAmtList(bizChanceAmountVO);
        List<BizChancePersonVO> nopList = bizChanceDAO.selectBizChanceNopList(bizChancePersonVO);

        bizChance.setBizChanceAmtList(amtList);
        bizChance.setBizChanceNopList(nopList);
        bizChance.setChgDtView(bizChance.getChgDt());

        bizChance.setSumPutNopCount(0);
        for(int j=0; j<nopList.size(); j++) {
            bizChance.setSumPutNopCount(bizChance.getSumPutNopCount() + nopList.get(j).getPutNopCount());
        }
        bizChance.setSumSellAmt(0);
        bizChance.setSumBuyAmt(0);
        for(int j=0; j<amtList.size(); j++) {
            bizChance.setSumSellAmt(bizChance.getSumSellAmt() + (amtList.get(j).getSellAmt()== null? 0: amtList.get(j).getSellAmt()));
            bizChance.setSumBuyAmt(bizChance.getSumBuyAmt() + (amtList.get(j).getBuyAmt()== null? 0: amtList.get(j).getBuyAmt()) );
        }

        bizChance.setSalesActivityList(bizChanceDAO.selectBizChanceActivityList(bizChanceVO));

        return bizChance;
    }

    @Transactional
    public List<BizChanceHistoryVO> selectBizChanceHistoryList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceHistoryList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceHistoryVO> data = null;
        // historyGrpCd 분기
        if(bizChanceSearchVO.getHistoryGroupCd().equals("WCT")){
            data = bizChanceDAO.selectBizChanceHistoryWctList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("SELL")){
            data = bizChanceDAO.selectBizChanceHistorySellList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("BUY")){
            data = bizChanceDAO.selectBizChanceHistoryBuyList(bizChanceSearchVO);
        } else if(bizChanceSearchVO.getHistoryGroupCd().equals("PN")){
            data = bizChanceDAO.selectBizChanceHistoryPncList(bizChanceSearchVO);
        }

        return data;
    }

    @Transactional
    public List<BizChanceVO> selectBizChancePopupList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChancePopupList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> bizChanceList = bizChanceDAO.selectBizChancePopupList(bizChanceSearchVO);

        return bizChanceList;
    }

    // INSERT
    @Transactional(rollbackFor = Exception.class)
    public BizChanceVO insertBizChance(Payload<BizChanceVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".insertBizChance");

        BizChanceVO bizChanceVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        try{

            String boptId = bizChanceDAO.selectNewBoptId("").getBoptId();

            bizChanceVO.setBoptId(boptId);
            bizChanceVO.setRegEmpId(accountVO.getEmpId());
            bizChanceVO.setChgEmpId(accountVO.getEmpId());

            long currDateTime = new Date().getTime();
            Timestamp currDateTimestamp = new Timestamp(currDateTime);

            //날짜
            String date = currDateTimestamp.toString();
            int idx = date.indexOf(".");
            String chgDt = date.substring(0, idx);

            bizChanceVO.setChgDt(chgDt);
            bizChanceVO.setExtndYn("N");
            bizChanceDAO.insertBizChance(bizChanceVO);
            bizChanceDAO.insertBizChanceHistory(bizChanceVO);

            if(bizChanceVO.getBizChanceAmtList() != null) {
                int amtSeq = 1;
                for(BizChanceAmountVO bizChanceAmountVO : bizChanceVO.getBizChanceAmtList()) {
                    bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
                    bizChanceAmountVO.setChgDt(chgDt);
                    bizChanceAmountVO.setSeq(amtSeq);
                    bizChanceAmountVO.setSellAmt( (bizChanceAmountVO.getSellAmt() == null? 0: bizChanceAmountVO.getSellAmt() ) );
                    bizChanceAmountVO.setBuyAmt( (bizChanceAmountVO.getBuyAmt() == null? 0: bizChanceAmountVO.getBuyAmt() ) );
                    bizChanceDAO.insertBizChanceAmt(bizChanceAmountVO);
                    bizChanceDAO.insertBizChanceHistoryAmt(bizChanceAmountVO);
                    amtSeq++;
                }
            }
            if(bizChanceVO.getBizChanceNopList() != null) {
                for(BizChancePersonVO bizChancePersonVO : bizChanceVO.getBizChanceNopList()) {
                    bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());
                    bizChancePersonVO.setPutTimeUnitCd("A");
                    bizChancePersonVO.setChgDt(chgDt);

                    bizChanceDAO.insertBizChanceNop(bizChancePersonVO);
                    bizChanceDAO.insertBizChanceHistoryNop(bizChancePersonVO);
                }
            }
        }catch (Exception e){
            throw new UpdateDeniedException("사업기회 등록 중 문제가 발생했습니다.", bizChanceVO);
        }

        return bizChanceVO;
    }

    // UPDATE

    @Transactional(rollbackFor = Exception.class)
    public BizChanceVO updateBizChance(Payload<BizChanceVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChance");
        BizChanceVO bizChanceVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();
        bizChanceVO.setChgEmpId(accountVO.getEmpId());

        try{

            long currDateTime = new Date().getTime();
            Timestamp currDateTimestamp = new Timestamp(currDateTime);
            //날짜
            String date = currDateTimestamp.toString();
            int idx = date.indexOf(".");
            String chgDt = date.substring(0, idx);

            bizChanceVO.setChgDt(chgDt);
            bizChanceVO.setExtndYn("N");
            bizChanceDAO.updateBizChance(bizChanceVO);
            // 변경이력(히스토리) 테이블에 적재..
            // 동일한 날짜로 이력된게 있으면 지우고 적재..
            if( bizChanceDAO.selectBizChanceHistoryCount(bizChanceVO) > 0) {
                bizChanceDAO.deleteBizChanceHistoryAmt(bizChanceVO);
                bizChanceDAO.deleteBizChanceHistoryNop(bizChanceVO);
                bizChanceDAO.deleteBizChanceHistory(bizChanceVO);
            }
            bizChanceDAO.insertBizChanceHistory(bizChanceVO);

            if(bizChanceVO.getBizChanceAmtList() != null) {
                bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO);

                int amtSeq = 1;
                for(BizChanceAmountVO bizChanceAmountVO : bizChanceVO.getBizChanceAmtList()) {
                    bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
                    bizChanceAmountVO.setChgDt(chgDt);
                    bizChanceAmountVO.setSeq(amtSeq);

                    bizChanceAmountVO.setSellAmt( (bizChanceAmountVO.getSellAmt() == null? 0: bizChanceAmountVO.getSellAmt() ) );
                    bizChanceAmountVO.setBuyAmt( (bizChanceAmountVO.getBuyAmt() == null? 0: bizChanceAmountVO.getBuyAmt() ) );
                    bizChanceDAO.insertBizChanceAmt(bizChanceAmountVO);
                    bizChanceDAO.insertBizChanceHistoryAmt(bizChanceAmountVO);
                    amtSeq++;
                }
            }

            if(bizChanceVO.getBizChanceNopList() != null) {
                bizChanceDAO.deleteBizChanceNopAll(bizChanceVO);

                for(BizChancePersonVO bizChancePersonVO : bizChanceVO.getBizChanceNopList()) {
                    bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());
                    bizChancePersonVO.setPutTimeUnitCd("A");
                    bizChancePersonVO.setChgDt(chgDt);

                    bizChanceDAO.insertBizChanceNop(bizChancePersonVO);
                    bizChanceDAO.insertBizChanceHistoryNop(bizChancePersonVO);

                }
            }

        }catch (Exception e){
            throw new UpdateDeniedException(bizChanceVO);
        }

        return bizChanceVO;
    }

    // DELETE

    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteBizChance(Payload<BizChanceVO> requestPayload) throws DeleteDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".deleteBizChance");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();
        BizChanceVO bizChanceVO2 = new BizChanceVO();
        Boolean YN = true;

        try {

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

            bizChanceVO.setChgDt(chgDt);

            // 예상손익분석/견적서가 존재하는지 여부를 확인 후 삭제시도.. 존재할 경우 "예상손익분석/견적서가 존재하여 삭제 불가능합니다."
            OfferVO offerVO = new OfferVO();
            offerVO.setBoptId(bizChanceVO.getBoptId());

            if( !(offerProfitDAO.selectisExistsOffer(offerVO) > 0)) {	//예상손익&견적서 있는 지 비교
                if(!bizChanceVO.getRegDt().equals(today)) {

                    bizChanceVO = bizChanceDAO.selectBizChaneInfo(bizChanceVO);

                    bizChanceVO.setBoptStatCd("D1");
                    bizChanceVO.setChgDt(chgDt);

                    bizChanceDAO.updateBizChanceStatus(bizChanceVO);//상태 변경

                    //삭제 변경하면서 매출 매입, 투입인원 삭제 + 영업활동내역도 삭제
                    bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO); //월별 매출매입삭제
                    bizChanceDAO.deleteBizChanceNopAll(bizChanceVO); //투입인원 삭제
                    bizChanceDAO.deleteBizChanceActivityAll(bizChanceVO); //영업활동내역 삭제


                    //이력 등록 당일 이력 중복이 체크하고 등록
                    if( bizChanceDAO.selectBizChanceHistoryCount(bizChanceVO) > 0) {
                        bizChanceDAO.deleteBizChanceHistoryAmt(bizChanceVO);
                        bizChanceDAO.deleteBizChanceHistoryNop(bizChanceVO);
                        bizChanceDAO.deleteBizChanceHistory(bizChanceVO);
                    }

                    bizChanceDAO.insertBizChanceHistory(bizChanceVO);


                }else {
                    bizChanceDAO.deleteBizChanceAmtAll(bizChanceVO); //월별 매출매입삭제
                    bizChanceDAO.deleteBizChanceNopAll(bizChanceVO); //투입인원 삭제
                    bizChanceDAO.deleteBizChanceHistoryAmtAll(bizChanceVO); //월별 매출매입 이력삭제
                    bizChanceDAO.deleteBizChanceHistoryNopAll(bizChanceVO);	//투입인원 이력삭제
                    bizChanceDAO.deleteBizChanceHistoryAll(bizChanceVO); //사업기회 이력삭제
                    bizChanceDAO.deleteBizChanceActivityAll(bizChanceVO); //영업활동내역 삭제
                    bizChanceDAO.deleteBizChance(bizChanceVO); //사업기회 삭제
                }

                YN = true;
            }else {
                YN = false;
            }

        }catch (Exception e){
            throw new DeleteDeniedException(bizChanceVO);
        }

        return YN;
    }

    @Transactional
    public List<BizChanceVO> selectBizChanceRelList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceRelList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> bizChanceList = bizChanceDAO.selectBizChanceRelList(bizChanceSearchVO);

        return bizChanceList;
    }

    @Transactional
    public List<BizChanceVO> selectRlvnOfferProfitList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectRlvnOfferProfitList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<BizChanceVO> bizChanceList = null;

        String prjtTypeCd = bizChanceDAO.selectPrjtTypeCd(bizChanceSearchVO.getBoptId());
        bizChanceSearchVO.setPrjtTypeCd(prjtTypeCd);

        //해당 예상손익분석서
        if(bizChanceSearchVO.getPrjtTypeCd().equals("B2")) {
            bizChanceList = bizChanceDAO.selectRlvnOfferProfitMAList(bizChanceSearchVO);
        }else {
            bizChanceList = bizChanceDAO.selectRlvnOfferProfitPSList(bizChanceSearchVO);
        }

        return bizChanceList;
    }


    @Transactional
    public List<BizChanceVO> selectBizChanceSalesEmpList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceSalesEmpList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        bizChanceSearchVO.setUserId(accountVO.getEmpId());

        // 데이터 받을 준비
        List<BizChanceVO> data = bizChanceDAO.selectBizChanceSalesEmpList(bizChanceSearchVO);

        return data;
    }

    @Transactional(rollbackFor = Exception.class)
    public BizChanceVO updateBizChanceSalesEmp(Payload<BizChanceVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChanceSalesEmp");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();

        List<BizChanceHistoryVO> data = null;
        BizChanceVO transferBizChanceVO = new BizChanceVO();

        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);

        //날짜
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        bizChanceVO.setChgDt(chgDt);
        transferBizChanceVO.setChgDt(chgDt);

        //boptId, slsEmpId, slsDeptId
        bizChanceVO.getSlsDeptId();
        bizChanceVO.getSlsEmpId();

        try{
            for(BizChanceVO model : bizChanceVO.getBizChanceChangeList()) {
                bizChanceVO.setBoptId(model.getBoptId());
                transferBizChanceVO.setBoptId(model.getBoptId());

                //주테이블 업뎃
                bizChanceDAO.updateBizChanceSalesEmp(bizChanceVO);

                //주테이블 검색
                transferBizChanceVO = bizChanceDAO.selectBizChaneInfo(bizChanceVO);


                transferBizChanceVO.setChgDt(chgDt);
                //ChgDt
                if( bizChanceDAO.selectBizChanceHistoryCount(transferBizChanceVO) > 0) {
                    bizChanceDAO.deleteBizChanceHistoryAmt(transferBizChanceVO);
                    bizChanceDAO.deleteBizChanceHistoryNop(transferBizChanceVO);
                    bizChanceDAO.deleteBizChanceHistory(transferBizChanceVO);
                }

                //이력(주)인서트
                bizChanceDAO.insertBizChanceHistory(transferBizChanceVO);

                //이력(서브)인서트(따로생성)
                bizChanceDAO.insertBizChanceHistoryAmtSalesEmp(transferBizChanceVO);
                bizChanceDAO.insertBizChanceHistoryNopSalesEmp(transferBizChanceVO);
            }
        } catch (Exception e) {
            throw new UpdateDeniedException(bizChanceVO);
        }

        return bizChanceVO;
    }



    // EXCEL


    @Transactional
    public List<ExcelBizChanceVO> selectExcelDwnlBizChanceList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".getBizChanceDetailList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<ExcelBizChanceVO> list = bizChanceDAO.selectExcelDwnlBizChanceList(bizChanceSearchVO);

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
    public List<ExcelBizChanceAmountVO> selectExcelDwnlBizChanceSellBuyList(Payload<BizChanceSearchVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlBizChanceSellBuyList");
        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();

        List<ExcelBizChanceAmountVO> list = bizChanceDAO.selectExcelDwnlBizChanceSellBuyList(bizChanceSearchVO);

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

    // 영업 활동 내역


    @Transactional
    public List<BizChanceActivityVO> selectBizChanceActivityList(Payload<BizChanceVO> requestPayload) {
        log.info("Call Service : " + this.getClass().getName() + ".selectBizChanceActivityList");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceVO bizChanceVO = requestPayload.getDto();

        List<BizChanceActivityVO> salesActivityList = bizChanceDAO.selectBizChanceActivityList(bizChanceVO);

        return salesActivityList;
    }

    @Transactional
    public BizChanceActivityVO insertBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".insertBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        bizChanceActivityVO.setRegEmpId(accountVO.getEmpId());

        try {
            bizChanceDAO.insertBizChanceActivity(bizChanceActivityVO);
        }catch (Exception e){
            throw new UpdateDeniedException("영업활동 등록 중 문제가 발생했습니다.", bizChanceActivityVO);
        }


        return bizChanceActivityVO;
    }

    @Transactional
    public BizChanceActivityVO updateBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".updateBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        try {
            bizChanceActivityVO.setChgEmpId(accountVO.getEmpId());
            bizChanceDAO.updateBizChanceActivity(bizChanceActivityVO);
        }catch (Exception e){
            throw new UpdateDeniedException(bizChanceActivityVO);
        }

        return bizChanceActivityVO;
    }

    @Transactional
    public BizChanceActivityVO deleteBizChanceActivity(Payload<BizChanceActivityVO> requestPayload) throws DeleteDeniedException{
        log.info("Call Service : " + this.getClass().getName() + ".deleteBizChanceActivity");
        AccountVO accountVO = requestPayload.getAccountVO();
        BizChanceActivityVO bizChanceActivityVO = requestPayload.getDto();

        try {
            bizChanceDAO.deleteBizChanceActivity(bizChanceActivityVO);
        }catch (Exception e){
            throw new DeleteDeniedException(bizChanceActivityVO);
        }

        return bizChanceActivityVO;
    }

    // 사업기회 연장
    @Transactional(rollbackFor = Exception.class)
    public BizChanceSearchVO extendBizChanceInfo(Payload<BizChanceSearchVO> requestPayload) throws UpdateDeniedException {
        log.info("Call Service : " + this.getClass().getName() + ".extendBizChanceInfo");

        BizChanceSearchVO bizChanceSearchVO = requestPayload.getDto();
        AccountVO accountVO = requestPayload.getAccountVO();

        //날짜
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int nextYear = cal.get(Calendar.YEAR)+1; // 연장할 연도
        long currDateTime = new Date().getTime();
        Timestamp currDateTimestamp = new Timestamp(currDateTime);
        String date = currDateTimestamp.toString();
        int idx = date.indexOf(".");
        String chgDt = date.substring(0, idx);

        try{
            // 연장할 사업기회 조회
            for(BizChanceVO bizChanceVO : bizChanceSearchVO.getBizChanceChangeList()){
                BizChanceAmountVO bizChanceAmountVO = new BizChanceAmountVO();
                BizChancePersonVO bizChancePersonVO = new BizChancePersonVO();

                bizChanceAmountVO.setBoptId(bizChanceVO.getBoptId());
                bizChancePersonVO.setBoptId(bizChanceVO.getBoptId());

                BizChanceVO bizChance = bizChanceDAO.selectBizChance(bizChanceVO);
                List<BizChanceAmountVO> amtList = bizChanceDAO.selectBizChanceAmtList(bizChanceAmountVO);
                List<BizChancePersonVO> nopList = bizChanceDAO.selectBizChanceNopList(bizChancePersonVO);

                bizChance.setBizChanceAmtList(amtList);
                bizChance.setBizChanceNopList(nopList);

                //연장한 사업기회 연장여부 Y
                bizChance.setExtndYn("Y");
                bizChance.setChgDt(bizChance.getChgDt().substring(0, idx));
                bizChanceDAO.updateBizChance(bizChance);

                //새사업기회ID 생성
                String boptId = bizChanceDAO.selectNewBoptId(String.valueOf(nextYear)).getBoptId();

                //프로젝트명 재생성(년도 prefix)
                String boptNm = bizChance.getBoptNm();
                boptNm = boptNm.replace(year+"년","");
                boptNm = boptNm.replace(Integer.toString(year).substring(2)+"년",""); //(현재연도)
                boptNm = "["+ nextYear + "년] " + boptNm;

                //사업기회 연장
                bizChance.setBoptId(boptId);
                bizChance.setBoptNm(boptNm);
                bizChance.setPrjtId(bizChanceVO.getPrjtId());
                bizChance.setRegEmpId(accountVO.getEmpId());
                bizChance.setChgEmpId(accountVO.getEmpId());
                bizChance.setExtndYn("N");
                bizChance.setChgDt(chgDt);
                bizChance.setCntrDate(String.valueOf(Integer.parseInt(bizChance.getCntrDate())+10000));
                if(bizChance.getCntrTrsfStartYam() != null ){
                    bizChance.setCntrTrsfStartYam(String.valueOf(Integer.parseInt(bizChance.getCntrTrsfStartYam())+100));
                }
                if(bizChance.getCntrTrsfEndYam() != null ){
                    bizChance.setCntrTrsfEndYam(String.valueOf(Integer.parseInt(bizChance.getCntrTrsfEndYam())+100));
                }
                bizChance.setPrpsFnshDate(null);
                bizChance.setBidFnshDate(null);
                bizChance.setCmpySlctDate(null);
                bizChance.setWctDcdDate(null);

                bizChanceDAO.insertBizChance(bizChance);
                bizChanceDAO.insertBizChanceHistory(bizChance);

                if(amtList != null) { //사업기회 월별 매출매입
                    int amtSeq = 1;
                    for(BizChanceAmountVO bizChanceAmount : amtList){
                        bizChanceAmount.setBoptId(boptId);
                        bizChanceAmount.setChgDt(chgDt);
                        bizChanceAmount.setSeq(amtSeq);
                        bizChanceAmount.setFcstYam(String.valueOf(Integer.parseInt(bizChanceAmount.getFcstYam())+100));

                        bizChanceDAO.insertBizChanceAmt(bizChanceAmount);
                        bizChanceDAO.insertBizChanceHistoryAmt(bizChanceAmount);
                        amtSeq++;
                    }
                }
                if(nopList != null) { //사업기회 투입인원
                    for(BizChancePersonVO bizChancePerson : nopList) {
                        bizChancePerson.setBoptId(boptId);
                        bizChancePerson.setChgDt(chgDt);

                        bizChanceDAO.insertBizChanceNop(bizChancePerson);
                        bizChanceDAO.insertBizChanceHistoryNop(bizChancePerson);
                    }
                }
            }

            return bizChanceSearchVO;

        }catch (Exception e){
            throw new UpdateDeniedException("사업기회 연장 중 문제가 발생했습니다.", bizChanceSearchVO);
        }
    }


}
