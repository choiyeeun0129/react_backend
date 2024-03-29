package kr.co.seoulit.account.settlement.trialbalance.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.settlement.trialbalance.mapper.TotalTrialBalanceMapper;
import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;

@Service
@Transactional
public class TrialBalanceServiceImpl implements TrialBalanceService{
    
	@Autowired
    private TotalTrialBalanceMapper totalTrialBalanceDAO;

    @Override
    public HashMap<String, Object> findTotalTrialBalance(String accountPeriodNo, String callResult) {

        	HashMap<String, Object> map = new HashMap<>();
			map.put("accountPeriodNo", accountPeriodNo);
			map.put("callResult" , callResult);
        	totalTrialBalanceDAO.selectcallTotalTrialBalance(map);
        	
        return map;
    }
    
    @Override
	public HashMap<String, Object> findEarlyStatements(HashMap<String,Object> params) {
    		System.out.println(params);
    		 HashMap<String, Object> earlyledgersList = null;
	    	 earlyledgersList = totalTrialBalanceDAO.selectcallEarlyStatements(params);

	     return earlyledgersList;

	 }
    
    @Override
	public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult) {

        	HashMap<String, String> map = new HashMap<>();
        	map.put("accountPeriodNo", accountPeriodNo);
        	map.put("callResult", callResult);
        	return totalTrialBalanceDAO.selectAccountingSettlement(map);
    }
    
    @Override
	public ArrayList<DetailTrialBalanceBean> findDetailTrialBalance(String fromDate, String toDate) {
    		
				HashMap<String, Object> params = new HashMap<>();
				params.put("fromDate",fromDate);
				params.put("toDate",toDate);
		
				ArrayList<DetailTrialBalanceBean> detailTrialBalanceList = totalTrialBalanceDAO.selectDetailTrialBalance(params);

	        return detailTrialBalanceList;
    }

	@Override
	public ArrayList<TotalTrialBalanceBean> searchTotalTrialBalance(HashMap<String, Object> map) {
		System.out.println(map);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		// TODO Auto-generated method stub
		return totalTrialBalanceDAO.selectTotalTrialBalance(map);
	}
}
