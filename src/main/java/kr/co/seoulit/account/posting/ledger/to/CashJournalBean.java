package kr.co.seoulit.account.posting.ledger.to;

public class CashJournalBean {
	private String monthReportingDate;
	private String reportingDate;
	private String expenseReport;
	private String customerCode;
	private String customerName;
	private long deposit;
	private long withdrawal;
	private String balance;
	
	public String getMonthReportingDate() {
		return monthReportingDate;
	}
	public void setMonthReportingDate(String monthReportingDate) {
		this.monthReportingDate = monthReportingDate;
	}
	public String getReportingDate() {
		return reportingDate;
	}
	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}
	public String getExpenseReport() {
		return expenseReport;
	}
	public void setExpenseReport(String expenseReport) {
		this.expenseReport = expenseReport;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(long withdrawal) {
		this.withdrawal = withdrawal;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
}