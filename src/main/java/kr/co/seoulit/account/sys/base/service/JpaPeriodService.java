package kr.co.seoulit.account.sys.base.service;

import kr.co.seoulit.account.sys.base.entity.PeriodEntity;

import java.time.LocalDate;
import java.util.List;

public interface JpaPeriodService {
    List<PeriodEntity> findPeriodNo();


    PeriodEntity findTPeriodNo(String periodStartDate, String periodEndDate);

}
