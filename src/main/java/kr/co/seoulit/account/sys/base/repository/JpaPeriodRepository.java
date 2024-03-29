package kr.co.seoulit.account.sys.base.repository;

import kr.co.seoulit.account.sys.base.entity.PeriodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface JpaPeriodRepository extends CrudRepository<PeriodEntity, String> {
    ArrayList<PeriodEntity> findAllBy();


    PeriodEntity findAccountPeriodNoByPeriodStartDateAndPeriodEndDate(String periodStartDate, String periodEndDate);

}
