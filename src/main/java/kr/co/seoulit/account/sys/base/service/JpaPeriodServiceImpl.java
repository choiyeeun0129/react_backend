package kr.co.seoulit.account.sys.base.service;



import kr.co.seoulit.account.sys.base.entity.PeriodEntity;
import kr.co.seoulit.account.sys.base.repository.JpaPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaPeriodServiceImpl implements JpaPeriodService{
    @Autowired
    JpaPeriodRepository jpaPeriodRepository;

    @Override
    public List<PeriodEntity> findPeriodNo() {
        List<PeriodEntity> period = jpaPeriodRepository.findAllBy();
        return period;
    }

    @Override

    public PeriodEntity findTPeriodNo(String periodStartDate,String periodEndDate) {
        PeriodEntity map = jpaPeriodRepository.findAccountPeriodNoByPeriodStartDateAndPeriodEndDate(periodStartDate, periodEndDate);

        return map;
    }

    ;




}
