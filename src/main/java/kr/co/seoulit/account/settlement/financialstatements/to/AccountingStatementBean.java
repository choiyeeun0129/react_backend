package kr.co.seoulit.account.settlement.financialstatements.to;

import kr.co.seoulit.account.posting.business.to.SlipBean;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class AccountingStatementBean extends BaseBean {
    private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String income;
    private String incomeSummary;
    private String earlyIncome;
    private String earlyIncomeSummary;
    private String isThisYear;
    private List <SlipBean> SlipBean;

}
