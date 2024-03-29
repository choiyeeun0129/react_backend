package kr.co.seoulit.account.settlement.financialstatements.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class IncomeStatementBean extends BaseBean {
    private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String income;
    private String incomeSummary;
    private String earlyIncome;
    private String earlyIncomeSummary;
    private String isThisYear;

    public String getAccountInnerCode() {
        return accountInnerCode;
    }

    public void setAccountInnerCode(String accountInnerCode) {
        this.accountInnerCode = accountInnerCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getParentAccountCode() {
        return parentAccountCode;
    }

    public void setParentAccountCode(String parentAccountCode) {
        this.parentAccountCode = parentAccountCode;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getIncomeSummary() {
        return incomeSummary;
    }

    public void setIncomeSummary(String incomeSummary) {
        this.incomeSummary = incomeSummary;
    }

    public String getEarlyIncome() {
        return earlyIncome;
    }

    public void setEarlyIncome(String earlyIncome) {
        this.earlyIncome = earlyIncome;
    }

    public String getEarlyIncomeSummary() {
        return earlyIncomeSummary;
    }

    public void setEarlyIncomeSummary(String earlyIncomeSummary) {
        this.earlyIncomeSummary = earlyIncomeSummary;
    }

    public String getIsThisYear() {
        return isThisYear;
    }

    public void setIsThisYear(String isThisYear) {
        this.isThisYear = isThisYear;
    }
}
