package kr.co.seoulit.account.posting.ledger.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.mapper.AccountSubjectMapper;
import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.mapper.*;
import kr.co.seoulit.account.posting.ledger.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;

@Service
@Transactional
public class LedgerServiceImpl implements LedgerService {
    
	@Autowired
    private JournalEntryMapper journalEntryDAO;
	@Autowired
    private AuxiliaryLedgerMapper auxiliaryLedgerDAO;
	@Autowired
    private AssistantLedgerMapper assistantLedgerDAO;
	@Autowired
	private CurrentAssetMapper currentAssetMapper;
	@Autowired
	private AccountSubjectMapper accountSubjectMapper;
	@Autowired
	private GeneralLedgerMapper generalLedgerMapper;


	@Override
	public ArrayList<GeneralLedgerBean> findGeneralAccountLedgerList(HashMap<String , Object> map){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");System.out.println(map);System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		return generalLedgerMapper.selectGeneralAccountLedgerList(map);
	}

	public ArrayList<CurrentAssetBean> findCurrentAssetList(String accountCode , String accountName){
		HashMap<String, Object> param =new HashMap<>();

		ArrayList<CurrentAssetBean> findCurrentAssetList = currentAssetMapper.selectCurrentAssetList(accountCode , accountName);
		return findCurrentAssetList;
	}

	public ArrayList<AccountBean> currentAssetCode(){
		return accountSubjectMapper.selectCurrentAssetList();
	}


    @Override
	public ArrayList<CashJournalBean> findTotalCashJournal(String year, String account) {

        	ArrayList<CashJournalBean> cashJournalList = null;
        	HashMap<String, String> map = new HashMap<String, String>();
        	map.put("year", year);
        	map.put("account", account);
        	cashJournalList = auxiliaryLedgerDAO.selectTotalCashJournalList(map);

        return cashJournalList;
	}
	
	@Override
	public ArrayList<CashJournalBean> findCashJournal(String fromDate, String toDate) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
        	ArrayList<CashJournalBean> cashJournalList = null;
        	cashJournalList = auxiliaryLedgerDAO.selectCashJournalList(map);

        return cashJournalList;
	}

	@Override
	public ArrayList<GeneralLedgerBean> findAccountLedger(String fromDate, String toDate, String accountCode){

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		map.put("accountCode", accountCode);
		ArrayList<GeneralLedgerBean> generalLedgerList = null;
		generalLedgerList = generalLedgerMapper.selectAccountLedger(map);

		return generalLedgerList;
	}
	
	@Override
    public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {

        	ArrayList<JournalBean> journalList = null;
        	journalList = journalEntryDAO.selectRangedJournalList(fromDate, toDate);
        	
        return journalList;
    }
	
	@Override
    public ArrayList<JournalDetailBean> findJournalDetailList(String journalNo) {

        	ArrayList<JournalDetailBean> journalDetailBeans = null;
        	journalDetailBeans = journalEntryDAO.selectJournalDetailList(journalNo);

        return journalDetailBeans;
    }
	
	@Override
	public ArrayList<AssetBean> findAssetList() {
		

        	ArrayList<AssetBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetList();

        return assetBean;
	}
	
	@Override
	public ArrayList<AssetItemBean> findAssetItemList(String parentsCode) {
		
        	ArrayList<AssetItemBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetItemList(parentsCode);

        return assetBean;
	}

	public ArrayList<AssetItemBean> findAssetDta(String parentsCode){
		ArrayList<AssetItemBean> assetBean = null;
		assetBean = assistantLedgerDAO.selectAssetDta(parentsCode);
		return assetBean;
	}
	
	@Override
	public ArrayList<DeptBean> findDeptList(){

        	ArrayList<DeptBean> DeptBean = null;
        	DeptBean = assistantLedgerDAO.selectDeptList();

        return DeptBean;
	}
	
	@Override
	public void assetStorage(HashMap<String, Object> map) {
			
			if(map.get("previousAssetItemCode").equals("CREATE")) {
				assistantLedgerDAO.createAssetItem(map);
			}
			else {
				assistantLedgerDAO.updateAssetItem(map);
			}
          
	}
	
	@Override
	public void removeAssetItem(String assetItemCode) {

			assistantLedgerDAO.removeAssetItem(assetItemCode);
           
	}


}
