package kr.co.seoulit.account.sys.base.to;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class MonthBean extends BaseBean{

    private String month;
    private String monthStartDate;
    private String monthEndDate;
}
