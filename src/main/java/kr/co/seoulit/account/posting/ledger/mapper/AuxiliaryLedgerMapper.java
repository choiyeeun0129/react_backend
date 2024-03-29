package kr.co.seoulit.account.posting.ledger.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.ledger.to.CashJournalBean;

@Mapper
public interface AuxiliaryLedgerMapper {
	
	public ArrayList<CashJournalBean> selectCashJournalList(HashMap<String, String> map);
	
	public ArrayList<CashJournalBean> selectTotalCashJournalList(HashMap<String, String> map);
}
