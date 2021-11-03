package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * BEST100T : 견적서발행내역
 *
 */

public class EstimateVO {

    /**
     * 견적ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 견적ID는 10자리 이하여야합니다." )
    private String estiId;

    /**
     * 손익ID
     */
    @NotNull
    @Size(max=10, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 손익ID는 10자리 이하여야합니다." )
    private String fcstPalId;

    /**
     * 결재ID
     */
    private String santId;

    /**
     * 견적작성일자
     */
    @NotNull
    @Size(max=8, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 견적작성일자는 8자리 이하여야합니다." )
    private String estiWrtDate;

    /**
     * 견적서문서번호
     */
    private String docNo;

    /**
     * 문서제목
     */
    private String docTitl;

    /**
     * 서식코드
     */
    private String frmtCd;
    
    /**
     * 서식코드명
     */
    private String frmtCdNm;

    /**
     * 수신업체명
     */
    private String rcvCmpyNm;

    /**
     * 수신담당자명
     */
    private String rcvChrrNm;

    /**
     * 발신담당자명
     */
    private String trsmtChrrNm;

    /**
     * 발신전화번호
     */
    private String trsmtTelNo;

    /**
     * 발신이메일주소
     */
    private String trsmtEmlAdrs;

    /**
     * 사업명
     */
    private String bsnsNm;

    /**
     * 공급업체ID
     */
    private String splyCmpyId;

    /**
     * 공급업체명
     */
    private String splyCmpyNm;

    /**
     * 공급업체사업자번호
     */
    private String splyCmpyBsnnNo;

    /**
     * 공급업체주소
     */
    private String splyCmpyAdrs;

    /**
     * 공급업체전화번호
     */
    private String splyCmpyTelNo;

    /**
     * 공급업체팩스번호
     */
    private String splyCmpyFaxNo;

    /**
     * 부가세포함구분코드
     */
    @NotNull
    @Size(max=4, message=ExceptionCode.OUTOFSIZE_EXCEPTION+" 부가세코드는 4자리 이하여야합니다." )
    private String vatCvrdDstCd;

    /**
     * 부가세포함구분명
     */
    private String vatCvrdDstCdNm;

    /**
     * 품질보증서비스내용
     */
    private String qltyGarntSvcCont;

    /**
     * 기타사항
     */
    private String etcMtr;

    /**
     * 견적서상태코드
     */
    @NotNull
    @Size(max=4, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 견적서상태코드는 4자리 이하여야합니다." )
    private String estisStatCd;

    /**
     * 발행일시
     */
    private String isuDt;

    /**
     * 등록사원ID
     */
    private String regEmpId;

    /**
     * 등록일시
     */
    private String regDt;

    /**
     * 변경사원ID
     */
    private String chgEmpId;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 대표고객ID
     */
    private String rprnCustId;

    /**
     * 자사 제품 리스트
     */
    private List<EstimateProductPSVO> productList;

    /**
     * 서비스 리스트
     */
    private List<EstimateProductPSVO> serviceList;

    /**
     * 타사제품 리스트
     */
    private List<EstimateProductPSVO> otherProductList;

    /**
     * total 소비자금액
     */
    private Long totalLpcAmt;

    /**
     * total 공급금액
     */
    private Long totalSplyAmt;

    /**
     * VAT ( total 공급금액 * 0.1 )
     */
    private Long vat;

    /**
     * 총합계 ( total 공급금액 + VAT )
     */
    private Long totalAmt;

    /**
     * total 제품 소비자금액
     */
    private Long totalProdLpcAmt;

    /**
     * total 제품 공급금액
     */
    private Long totalProdSplyAmt;

    /**
     * total 서비스 소비자금액
     */
    private Long totalSVLpcAmt;

    /**
     * total 서비스 공급금액
     */
    private Long totalSVSplyAmt;

    /**
     * total 타사제품 소비자금액
     */
    private Long totalOPLpcAmt;

    /**
     * total 타사제품 공급금액
     */
    private Long totalOPSplyAmt;

    /**
     * 제품 VAT 소비자금액
     */
    private Long prodVATLpcAmt;

    /**
     * 제품 VAT 공급금액
     */
    private Long prodVATSplyAmt;

    /**
     * total MA 월보수료(소계)
     */
    private Long sumMAMnthMndnAmt;

    /**
     * total MA 공급금액(소계)
     */
    private Long sumMASplyAmt;

    /**
     * MA 월보수료 VAT
     */
    private Long maVATMnthMndnAmt;

    /**
     * MA 공급금액 VAT
     */
    private Long maVATSplyAmt;

    /**
     * total MA 월보수료
     */
    private Long totalMAMnthMndnAmt;

    /**
     * total MA 공급금액
     */
    private Long totalMASplyAmt;

    /**
     * 서비스 총 인원명
     */
    private Long totalSVPerson;

    /**
     * 최종고객 ID
     */
    private String lastCustId;

    /**
     * 최종고객명
     */
    private String lastCustNm;

    /**
     * 프로젝트 ID
     */
    private String prjtId;

    /**
     * 프로젝트명
     */
    private String prjtNm;

    /**
     * 사업기회 ID
     */
    private String boptId;

    /**
     * 사업기회명
     */
    private String boptNm;

    /**
     * 발주고객 ID
     */
    private String ordeCustId;

    /**
     * 발주고객명
     */
    private String ordeCustNm;

    /**
     * 프로젝트 유형코드
     */
    private String prjtTypeCd;

    /**
     * 프로젝트유형명
     */
    private String prjtTypeCdNm;

    /**
     * 매출금액
     */
    private Long sellAmt;

    /**
     * 영업부서명
     */
    private String slsDeptNm;

    /**
     * 영업부서 ID
     */
    private String slsDeptId;

    /**
     * 영업사원명
     */
    private String slsEmpNm;

    /**
     * 영업사원 ID
     */
    private String slsEmpId;

    /**
     * 영업사원정보
     */
    private String slsEmpInfo;

    /**
     * 견적서 상태명
     */
    private String estisStatCdNm;

    /**
     * 공급업체대표자명
     */
    private String splyCmpyRprnNm;

    /**
     * 발행 시작일
     */
    private String fromRegDt;

    /**
     * 발행 종료일
     */
    private String toRegDt;

    /**
     * 페이징 크기
     */
    private String pageSize;

    /**
     * 페이지번호
     */
    private String pageNumber;

    /**
     * 서식코드
     */
    private String santFrmtCd;

    /**
     * MA 유지보수 견적 상세
     */
    private List<EstimateProductMAVO> estiIssueMAList;
    /**
     * 유지보수 서비스 제공조건 리스트
     */
    private List<EstimateMAServiceVO> estiIssueMAServiceList;

    /**
     * 타사제품 리스트
     */
    private List<EstimateProductPSVO> estiIssuePnsList;

    /**
     * 총 갯수
     */
    private Integer totalCnt;

    /**
     * rowNumber
     */
    private Integer rowNumber;

    /**
     * 등록자명
     */
    private String regEmpNm;
    /**
     * 최종수정자명
     */
    private String chgEmpNm;

    /**
     * 손익상태
     */
    private String fcstPalPrgsStatCd;

    /**
     * 윈도우팝업여부
     */
    private String winPopupCd;

    /**
     * 프린트팝업여부
     */
    private String winPrintCd;

    /**
     * 제품명
     */
    private String prodpNm;

    /**
     * 발신고객명
     */
    private String custNm;

    /**
     * 발신고객직위명
     */
    private String ofpsNm;

    /**
     * 공급업체 고객ID
     */
    private String splyCmpyCustId;

    private String docKindCd;

    public String getEstiId() {
        return estiId;
    }

    public void setEstiId(String estiId) {
        this.estiId = estiId;
    }

    public String getFcstPalId() {
        return fcstPalId;
    }

    public void setFcstPalId(String fcstPalId) {
        this.fcstPalId = fcstPalId;
    }

    public String getEstiWrtDate() {
        return estiWrtDate;
    }

    public void setEstiWrtDate(String estiWrtDate) {
        this.estiWrtDate = estiWrtDate;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getRcvCmpyNm() {
        return rcvCmpyNm;
    }

    public void setRcvCmpyNm(String rcvCmpyNm) {
        this.rcvCmpyNm = rcvCmpyNm;
    }

    public String getRcvChrrNm() {
        return rcvChrrNm;
    }

    public void setRcvChrrNm(String rcvChrrNm) {
        this.rcvChrrNm = rcvChrrNm;
    }

    public String getTrsmtChrrNm() {
        return trsmtChrrNm;
    }

    public void setTrsmtChrrNm(String trsmtChrrNm) {
        this.trsmtChrrNm = trsmtChrrNm;
    }

    public String getTrsmtTelNo() {
        return trsmtTelNo;
    }

    public void setTrsmtTelNo(String trsmtTelNo) {
        this.trsmtTelNo = trsmtTelNo;
    }

    public String getTrsmtEmlAdrs() {
        return trsmtEmlAdrs;
    }

    public void setTrsmtEmlAdrs(String trsmtEmlAdrs) {
        this.trsmtEmlAdrs = trsmtEmlAdrs;
    }

    public String getBsnsNm() {
        return bsnsNm;
    }

    public void setBsnsNm(String bsnsNm) {
        this.bsnsNm = bsnsNm;
    }

    public String getSplyCmpyId() {
        return splyCmpyId;
    }

    public void setSplyCmpyId(String splyCmpyId) {
        this.splyCmpyId = splyCmpyId;
    }

    public String getSplyCmpyNm() {
        return splyCmpyNm;
    }

    public void setSplyCmpyNm(String splyCmpyNm) {
        this.splyCmpyNm = splyCmpyNm;
    }

    public String getSplyCmpyBsnnNo() {
        return splyCmpyBsnnNo;
    }

    public void setSplyCmpyBsnnNo(String splyCmpyBsnnNo) {
        this.splyCmpyBsnnNo = splyCmpyBsnnNo;
    }

    public String getSplyCmpyAdrs() {
        return splyCmpyAdrs;
    }

    public void setSplyCmpyAdrs(String splyCmpyAdrs) {
        this.splyCmpyAdrs = splyCmpyAdrs;
    }

    public String getSplyCmpyTelNo() {
        return splyCmpyTelNo;
    }

    public void setSplyCmpyTelNo(String splyCmpyTelNo) {
        this.splyCmpyTelNo = splyCmpyTelNo;
    }

    public String getSplyCmpyFaxNo() {
        return splyCmpyFaxNo;
    }

    public void setSplyCmpyFaxNo(String splyCmpyFaxNo) {
        this.splyCmpyFaxNo = splyCmpyFaxNo;
    }

    public String getVatCvrdDstCd() {
        return vatCvrdDstCd;
    }

    public void setVatCvrdDstCd(String vatCvrdDstCd) {
        this.vatCvrdDstCd = vatCvrdDstCd;
    }

    public String getQltyGarntSvcCont() {
        return qltyGarntSvcCont;
    }

    public void setQltyGarntSvcCont(String qltyGarntSvcCont) {
        this.qltyGarntSvcCont = qltyGarntSvcCont;
    }

    public String getEtcMtr() {
        return etcMtr;
    }

    public void setEtcMtr(String etcMtr) {
        this.etcMtr = etcMtr;
    }

    public String getEstisStatCd() {
        return estisStatCd;
    }

    public void setEstisStatCd(String estisStatCd) {
        this.estisStatCd = estisStatCd;
    }

    public String getIsuDt() {
        return isuDt;
    }

    public void setIsuDt(String isuDt) {
        this.isuDt = isuDt;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getRprnCustId() {
        return rprnCustId;
    }

    public void setRprnCustId(String rprnCustId) {
        this.rprnCustId = rprnCustId;
    }


    public List<EstimateProductPSVO> getProductList() {
        return productList;
    }

    public void setProductList(List<EstimateProductPSVO> productList) {
        this.productList = productList;
    }

    public List<EstimateProductPSVO> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<EstimateProductPSVO> serviceList) {
        this.serviceList = serviceList;
    }

    public List<EstimateProductPSVO> getOtherProductList() {
        return otherProductList;
    }

    public void setOtherProductList(List<EstimateProductPSVO> otherProductList) {
        this.otherProductList = otherProductList;
    }

    public Long getTotalLpcAmt() {
        return totalLpcAmt;
    }

    public void setTotalLpcAmt(Long totalLpcAmt) {
        this.totalLpcAmt = totalLpcAmt;
    }

    public Long getTotalSplyAmt() {
        return totalSplyAmt;
    }

    public void setTotalSplyAmt(Long totalSplyAmt) {
        this.totalSplyAmt = totalSplyAmt;
    }

    public Long getVat() {
        return vat;
    }

    public void setVat(Long vat) {
        this.vat = vat;
    }

    public Long getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Long totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Long getTotalProdLpcAmt() {
        return totalProdLpcAmt;
    }

    public void setTotalProdLpcAmt(Long totalProdLpcAmt) {
        this.totalProdLpcAmt = totalProdLpcAmt;
    }

    public Long getTotalProdSplyAmt() {
        return totalProdSplyAmt;
    }

    public void setTotalProdSplyAmt(Long totalProdSplyAmt) {
        this.totalProdSplyAmt = totalProdSplyAmt;
    }

    public Long getTotalSVLpcAmt() {
        return totalSVLpcAmt;
    }

    public void setTotalSVLpcAmt(Long totalSVLpcAmt) {
        this.totalSVLpcAmt = totalSVLpcAmt;
    }

    public Long getTotalSVSplyAmt() {
        return totalSVSplyAmt;
    }

    public void setTotalSVSplyAmt(Long totalSVSplyAmt) {
        this.totalSVSplyAmt = totalSVSplyAmt;
    }

    public Long getTotalOPLpcAmt() {
        return totalOPLpcAmt;
    }

    public void setTotalOPLpcAmt(Long totalOPLpcAmt) {
        this.totalOPLpcAmt = totalOPLpcAmt;
    }

    public Long getTotalOPSplyAmt() {
        return totalOPSplyAmt;
    }

    public void setTotalOPSplyAmt(Long totalOPSplyAmt) {
        this.totalOPSplyAmt = totalOPSplyAmt;
    }

    public Long getProdVATLpcAmt() {
        return prodVATLpcAmt;
    }

    public void setProdVATLpcAmt(Long prodVATLpcAmt) {
        this.prodVATLpcAmt = prodVATLpcAmt;
    }

    public Long getProdVATSplyAmt() {
        return prodVATSplyAmt;
    }

    public void setProdVATSplyAmt(Long prodVATSplyAmt) {
        this.prodVATSplyAmt = prodVATSplyAmt;
    }

    public List<EstimateProductMAVO> getEstiIssueMAList() {
        return estiIssueMAList;
    }

    public void setEstiIssueMAList(List<EstimateProductMAVO> estiIssueMAList) {
        this.estiIssueMAList = estiIssueMAList;
    }

    public List<EstimateMAServiceVO> getEstiIssueMAServiceList() {
        return estiIssueMAServiceList;
    }

    public void setEstiIssueMAServiceList(List<EstimateMAServiceVO> estiIssueMAServiceList) {
        this.estiIssueMAServiceList = estiIssueMAServiceList;
    }

    public Long getSumMAMnthMndnAmt() {
        return sumMAMnthMndnAmt;
    }

    public void setSumMAMnthMndnAmt(Long sumMAMnthMndnAmt) {
        this.sumMAMnthMndnAmt = sumMAMnthMndnAmt;
    }

    public Long getSumMASplyAmt() {
        return sumMASplyAmt;
    }

    public void setSumMASplyAmt(Long sumMASplyAmt) {
        this.sumMASplyAmt = sumMASplyAmt;
    }

    public Long getMaVATMnthMndnAmt() {
        return maVATMnthMndnAmt;
    }

    public void setMaVATMnthMndnAmt(Long maVATMnthMndnAmt) {
        this.maVATMnthMndnAmt = maVATMnthMndnAmt;
    }

    public Long getMaVATSplyAmt() {
        return maVATSplyAmt;
    }

    public void setMaVATSplyAmt(Long maVATSplyAmt) {
        this.maVATSplyAmt = maVATSplyAmt;
    }

    public Long getTotalMAMnthMndnAmt() {
        return totalMAMnthMndnAmt;
    }

    public void setTotalMAMnthMndnAmt(Long totalMAMnthMndnAmt) {
        this.totalMAMnthMndnAmt = totalMAMnthMndnAmt;
    }

    public Long getTotalMASplyAmt() {
        return totalMASplyAmt;
    }

    public void setTotalMASplyAmt(Long totalMASplyAmt) {
        this.totalMASplyAmt = totalMASplyAmt;
    }

    public Long getTotalSVPerson() {
        return totalSVPerson;
    }

    public void setTotalSVPerson(Long totalSVPerson) {
        this.totalSVPerson = totalSVPerson;
    }

    public String getLastCustId() {
        return lastCustId;
    }

    public void setLastCustId(String lastCustId) {
        this.lastCustId = lastCustId;
    }

    public String getLastCustNm() {
        return lastCustNm;
    }

    public void setLastCustNm(String lastCustNm) {
        this.lastCustNm = lastCustNm;
    }

    public String getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(String prjtId) {
        this.prjtId = prjtId;
    }

    public String getPrjtNm() {
        return prjtNm;
    }

    public void setPrjtNm(String prjtNm) {
        this.prjtNm = prjtNm;
    }

    public String getBoptId() {
        return boptId;
    }

    public void setBoptId(String boptId) {
        this.boptId = boptId;
    }

    public String getBoptNm() {
        return boptNm;
    }

    public void setBoptNm(String boptNm) {
        this.boptNm = boptNm;
    }
    /**/
    public String getOrdeCustId() {
        return ordeCustId;
    }

    public void setOrdeCustId(String ordeCustId) {
        this.ordeCustId = ordeCustId;
    }

    public String getOrdeCustNm() {
        return ordeCustNm;
    }

    public void setOrdeCustNm(String ordeCustNm) {
        this.ordeCustNm = ordeCustNm;
    }

    public String getPrjtTypeCd() {
        return prjtTypeCd;
    }

    public void setPrjtTypeCd(String prjtTypeCd) {
        this.prjtTypeCd = prjtTypeCd;
    }

    public String getPrjtTypeCdNm() {
        return prjtTypeCdNm;
    }

    public void setPrjtTypeCdNm(String prjtTypeCdNm) {
        this.prjtTypeCdNm = prjtTypeCdNm;
    }

    public Long getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Long sellAmt) {
        this.sellAmt = sellAmt;
    }

    public String getSlsDeptNm() {
        return slsDeptNm;
    }

    public void setSlsDeptNm(String slsDeptNm) {
        this.slsDeptNm = slsDeptNm;
    }

    public String getSlsDeptId() {
        return slsDeptId;
    }

    public void setSlsDeptId(String slsDeptId) {
        this.slsDeptId = slsDeptId;
    }

    public String getSlsEmpNm() {
        return slsEmpNm;
    }

    public void setSlsEmpNm(String slsEmpNm) {
        this.slsEmpNm = slsEmpNm;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public String getEstisStatCdNm() {
        return estisStatCdNm;
    }

    public void setEstisStatCdNm(String estisStatCdNm) {
        this.estisStatCdNm = estisStatCdNm;
    }

    public String getSplyCmpyRprnNm() {
        return splyCmpyRprnNm;
    }

    public void setSplyCmpyRprnNm(String splyCmpyRprnNm) {
        this.splyCmpyRprnNm = splyCmpyRprnNm;
    }

    public String getFromRegDt() {
        return fromRegDt;
    }

    public void setFromRegDt(String fromRegDt) {
        this.fromRegDt = fromRegDt;
    }

    public String getToRegDt() {
        return toRegDt;
    }

    public void setToRegDt(String toRegDt) {
        this.toRegDt = toRegDt;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSantFrmtCd() {
        return santFrmtCd;
    }

    public void setSantFrmtCd(String santFrmtCd) {
        this.santFrmtCd = santFrmtCd;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<EstimateProductPSVO> getEstiIssuePnsList() {
        return estiIssuePnsList;
    }

    public void setEstiIssuePnsList(List<EstimateProductPSVO> estiIssuePnsList) {
        this.estiIssuePnsList = estiIssuePnsList;
    }

    public String getRegEmpNm() {
        return regEmpNm;
    }

    public void setRegEmpNm(String regEmpNm) {
        this.regEmpNm = regEmpNm;
    }

    public String getChgEmpNm() {
        return chgEmpNm;
    }

    public void setChgEmpNm(String chgEmpNm) {
        this.chgEmpNm = chgEmpNm;
    }

    public String getFcstPalPrgsStatCdNm() {
        return fcstPalPrgsStatCd;
    }

    public void setFcstPalPrgsStatCdNm(String fcstPalPrgsStatCd) {
        this.fcstPalPrgsStatCd = fcstPalPrgsStatCd;
    }

    public String getWinPopupCd() {
        return winPopupCd;
    }

    public void setWinPopupCd(String winPopupCd) {
        this.winPopupCd = winPopupCd;
    }

    public String getWinPrintCd() {
        return winPrintCd;
    }

    public void setWinPrintCd(String winPrintCd) {
        this.winPrintCd = winPrintCd;
    }

    public String getSlsEmpInfo() {
        return slsEmpInfo;
    }

    public void setSlsEmpInfo(String slsEmpInfo) {
        this.slsEmpInfo = slsEmpInfo;
    }


    public String getProdpNm() {
        return prodpNm;
    }

    public void setProdpNm(String prodpNm) {
        this.prodpNm = prodpNm;
    }

    public String getVatCvrdDstCdNm() {
        return vatCvrdDstCdNm;
    }

    public void setVatCvrdDstCdNm(String vatCvrdDstCdNm) {
        this.vatCvrdDstCdNm = vatCvrdDstCdNm;
    }


    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getOfpsNm() {
        return ofpsNm;
    }

    public void setOfpsNm(String ofpsNm) {
        this.ofpsNm = ofpsNm;
    }

    public String getSplyCmpyCustId() {
        return splyCmpyCustId;
    }

    public void setSplyCmpyCustId(String splyCmpyCustId) {
        this.splyCmpyCustId = splyCmpyCustId;
    }

    public String getDocTitl() {
        return docTitl;
    }

    public void setDocTitl(String docTitl) {
        this.docTitl = docTitl;
    }

    public String getFrmtCd() {
        return frmtCd;
    }

    public void setFrmtCd(String frmtCd) {
        this.frmtCd = frmtCd;
    }

    public String getFrmtCdNm() {
        return frmtCdNm;
    }

    public void setFrmtCdNm(String frmtCdNm) {
        this.frmtCdNm = frmtCdNm;
    }

    public String getFcstPalPrgsStatCd() {
        return fcstPalPrgsStatCd;
    }

    public void setFcstPalPrgsStatCd(String fcstPalPrgsStatCd) {
        this.fcstPalPrgsStatCd = fcstPalPrgsStatCd;
    }

    public String getDocKindCd() {
        return docKindCd;
    }

    public void setDocKindCd(String docKindCd) {
        this.docKindCd = docKindCd;
    }
}
