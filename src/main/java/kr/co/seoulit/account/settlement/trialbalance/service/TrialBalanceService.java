package kr.co.seoulit.account.settlement.trialbalance.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.account.settlement.trialbalance.to.EarlyAssetBean;
import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;

public interface TrialBalanceService {

	 public HashMap<String, Object> findTotalTrialBalance(String accountPeriodNo, String callResult);
	 //String accountPeriodNo, String callResult
	 public HashMap<String, Object> findEarlyStatements(HashMap<String, Object> params);
	 
	 public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult);
	 
	 public ArrayList<DetailTrialBalanceBean> findDetailTrialBalance(String fromDate, String toDate);
	 
	 public ArrayList<TotalTrialBalanceBean> searchTotalTrialBalance(HashMap<String, Object> map);
}
