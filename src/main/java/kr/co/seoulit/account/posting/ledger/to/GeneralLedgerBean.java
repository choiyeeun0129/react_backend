package kr.co.seoulit.account.posting.ledger.to;

import lombok.Data;

@Data
public class GeneralLedgerBean {
    private String reportingDate;
    private String accountName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String customerName;
    private String expenseReport;
}
