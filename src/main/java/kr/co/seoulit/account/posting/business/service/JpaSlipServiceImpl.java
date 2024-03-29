package kr.co.seoulit.account.posting.business.service;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.account.posting.business.repository.JournalRepository;
import kr.co.seoulit.account.posting.business.repository.SlipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JpaSlipServiceImpl implements JpaSlipService{
    @Autowired
    SlipRepository slipRepository;
    @Autowired
    JournalRepository journalRepository;

    // JPA로 수정했는데 값을 가져오지 않음. 쿼리문에 문제가 있는듯.
    @Override
    public ArrayList<SlipEntity> findRangedSlipList(String startDate, String endDate, String slipStatus) {


        System.out.println(startDate+"플러스"+endDate+"플러스"+slipStatus);
        ArrayList<SlipEntity> slipEntity = null;

        if(slipStatus != "전체") {
             slipEntity = slipRepository.findByReportingDateBetweenAndSlipStatusEqualsOrderByReportingDateAscSlipNoAsc(startDate,endDate,slipStatus);
        }else {
             slipEntity = slipRepository.findByReportingDateBetweenOrderByReportingDateAscSlipNoAsc(startDate, endDate);
        }
        System.out.println(slipEntity.toString() + "널로나오니??");
        return slipEntity;
    }

    @Override
    public List<SlipEntity> selectSlipList() {
        return null;
    }

    @Override
    public void removeSlip(Long slipNo) {
        slipRepository.deleteById(slipNo);
    }

    @Override
    public void removeJournal(String journalNo) {
        journalRepository.deleteById(journalNo);
    }

}
