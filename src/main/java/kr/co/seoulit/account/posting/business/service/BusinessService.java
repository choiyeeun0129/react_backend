package kr.co.seoulit.account.posting.business.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.posting.business.to.ReceiptBean;
import kr.co.seoulit.account.posting.business.to.SlipBean;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessService {

    public ArrayList<JournalDetailBean> findJournalDetailList(String journalNo);
    
    public ArrayList<JournalDetailBean> addJournalDetailList(String accountCode);

    public String modifyJournalDetail(JournalDetailBean journalDetailBean);

    public ArrayList<JournalBean> findSingleJournalList(String slipNo);

    public void removeJournal(String journalNo);

    public void modifyJournal(String slipNo, ArrayList<JournalBean> journalBeanList);
    
    public void updateJournal(String slipNo, ArrayList<JournalBean> journalBeanList);

    public ArrayList<SlipBean> findRangedSlipList(HashMap<String, Object> map);

    public ArrayList<SlipBean> findDisApprovalSlipList();

    public void registerSlip(SlipBean slipBean);

    public void removeSlip(String slipNo);

    public String modifySlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans);

    public void modifyapproveSlip(SlipBean slipBean);

    public ArrayList<SlipBean> findSlipDataList(String slipDate);

    public HashMap<String, Object> findAccountingSettlementStatus(HashMap<String, Object> params);

    public ArrayList<SlipBean> findSlip(String slipNo);

    //public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);
    public ArrayList<JournalBean> findRangedJournalList(HashMap<String, Object> map);

    public ArrayList<SlipBean> findApprovalSlipList(HashMap<String, Object> map);

	public void updateSlip(SlipBean slipBean);
	
	public void approvalSlipRequest(SlipBean slipBean);
	
	public ArrayList<JournalBean> findApprovalJournalList(String slipNo);
	
	public void tempModifyJournalDetail(ArrayList<JournalDetailBean> journalDetailBean);

    //지출증빙
    //지출증빙 전체조회
    ArrayList<ReceiptBean> findReceiptList();
    //지출증빙 한개조회
    ReceiptBean findReceiptBySlipNo(String slipNo);
    //지출증빙 증빙등록
    void registerReceipt(String slipNo, String type, MultipartFile file);
    //지출증빙 증빙삭제
    void deleteReceiptFile(String slipNo);
    //지출증빙 증빙완료
    void proofReceipt(ArrayList<ReceiptBean> receiptList);
	
}

