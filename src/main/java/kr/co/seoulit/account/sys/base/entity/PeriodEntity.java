package kr.co.seoulit.account.sys.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERIOD")
@NoArgsConstructor
@Data
public class PeriodEntity {
    @Id
    private String accountPeriodNo;
    private String periodStartDate;
    private String periodEndDate;
    private String workplaceCode;
}
