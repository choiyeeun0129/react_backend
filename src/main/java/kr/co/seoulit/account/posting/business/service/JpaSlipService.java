package kr.co.seoulit.account.posting.business.service;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;

import java.util.ArrayList;
import java.util.List;

public interface JpaSlipService {

    public ArrayList<SlipEntity> findRangedSlipList(String startDate, String endDate, String slipStatus);




    List<SlipEntity> selectSlipList();
    void removeSlip(Long slipNo);
    void removeJournal(String journalNo);
}
