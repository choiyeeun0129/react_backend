package kr.co.seoulit.account.posting.business.to;

public class AccountingSettlementStatusBean {
	private long accountPeriodNo;
	private String totalTrialBalance;
	private String incomeStatement;
	private String financialPosition;
	private String capitalStatement;

	public long getAccountPeriodNo() {
		return accountPeriodNo;
	}
	public void setAccountPeriodNo(long accountPeriodNo) {
		this.accountPeriodNo = accountPeriodNo;
	}
	public String getTotalTrialBalance() {
		return totalTrialBalance;
	}
	public void setTotalTrialBalance(String totalTrialBalance) {
		this.totalTrialBalance = totalTrialBalance;
	}
	public String getIncomeStatement() {
		return incomeStatement;
	}
	public void setIncomeStatement(String incomeStatement) {
		this.incomeStatement = incomeStatement;
	}
	public String getFinancialPosition() {
		return financialPosition;
	}
	public void setFinancialPosition(String financialPosition) {
		this.financialPosition = financialPosition;
	}
	public String getCapitalStatement() {
		return capitalStatement;
	}
	public void setCapitalStatement(String capitalStatement) {
		this.capitalStatement = capitalStatement;
	}


}