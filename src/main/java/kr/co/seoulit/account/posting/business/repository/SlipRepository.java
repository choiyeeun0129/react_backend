package kr.co.seoulit.account.posting.business.repository;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface SlipRepository extends CrudRepository<SlipEntity, Long> {
    ArrayList<SlipEntity> findByReportingDateBetweenOrderByReportingDateAscSlipNoAsc(String fromDate, String toDate);
    ArrayList<SlipEntity> findByReportingDateBetweenAndSlipStatusEqualsOrderByReportingDateAscSlipNoAsc(String fromDate, String toDate, String slipStatuses);


}
