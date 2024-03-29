package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;

@Mapper
public interface JournalMapper {

    public ArrayList<JournalBean> selectJournalList(String slipNo);

    public void deleteJournal(String journalNo);

    public void deleteJournalAll(String slipNo);

    public void updateJournal(JournalBean journalBean);

    public ArrayList<JournalDetailBean> selectJournalDetailList(String journalNo);
    
    public ArrayList<JournalDetailBean> addJournalDetailList(String accountCode);

    public String selectJournalDetailDescriptionName(String journalDetailNo);

    public void deleteJournalDetail(String journalNo);

    public void deleteJournalDetailByJournalNo(String journalNo);

    public void updateJournalDetailList(JournalDetailBean journalDetailBean);

    public void insertJournalDetailList(JournalDetailBean journalDetailBean);

    public ArrayList<JournalBean> selectRangedJournalList(HashMap<String, Object> map);

    public void insertJournal(JournalBean journalBean);

    public String selectJournalName(String slipNo);
    
    public void insertJournalDetailTemp(JournalDetailBean journalDetailBean);
}
