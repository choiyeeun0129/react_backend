package kr.co.seoulit.account.settlement.trialbalance.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.account.settlement.trialbalance.to.EarlyAssetBean;
import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;

@Mapper
public interface TotalTrialBalanceMapper {
	
    public HashMap<String, Object> selectcallTotalTrialBalance(HashMap<String,Object> map);
    
    public HashMap<String, Object> selectcallEarlyStatements(HashMap<String,Object> params);
    
    public ArrayList<DetailTrialBalanceBean> selectDetailTrialBalance(HashMap<String, Object> params);

	public HashMap<String, Object> selectAccountingSettlement(HashMap<String, String> map);
	
//	public HashMap<String, Object> selectTotalTrialBalance(HashMap<String,Object> map);
	
	public ArrayList<TotalTrialBalanceBean> selectTotalTrialBalance(HashMap<String, Object> map);
}
