package kr.co.seoulit.account.posting.ledger.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;

@Mapper
public interface JournalEntryMapper {
	
    public ArrayList<JournalBean> selectRangedJournalList(String fromDate, String toDate);
    
    ArrayList<JournalDetailBean> selectJournalDetailList(String journalNo);
}
