package kr.co.seoulit.account.posting.ledger.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.posting.ledger.to.*;

public interface LedgerService {

	ArrayList<CashJournalBean> findCashJournal(String fromDate, String toDate);
    
    ArrayList<CashJournalBean> findTotalCashJournal(String year, String account);
    
    ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);
    
    ArrayList<JournalDetailBean> findJournalDetailList(String journalNo);
    
    ArrayList<AssetBean> findAssetList();
    
    ArrayList<AssetItemBean> findAssetItemList(String parentsCode);
    
    ArrayList<DeptBean> findDeptList();
    
    void assetStorage(HashMap<String, Object> map);
    
    void removeAssetItem(String assetItemCode);

    public ArrayList<CurrentAssetBean> findCurrentAssetList(String accountCode, String accountName);

    public ArrayList<AccountBean> currentAssetCode();

    public ArrayList<GeneralLedgerBean> findGeneralAccountLedgerList(HashMap<String , Object> map);

    public ArrayList<AssetItemBean> findAssetDta(String parentsCode);

    public ArrayList<GeneralLedgerBean> findAccountLedger(String fromDate, String toDate, String accountCode);
}

