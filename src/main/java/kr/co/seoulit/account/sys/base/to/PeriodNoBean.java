package kr.co.seoulit.account.sys.base.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class PeriodNoBean extends BaseBean{

    private String accountPeriodNo;
    private String fiscalYear;
    private String workplaceCode;
    private String periodStartDate;
    private String periodEndDate;

}
