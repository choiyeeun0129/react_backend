package kr.co.seoulit.account.sys.base.to;

public class IreportBean {
	protected String slipNo;
	protected String reportingDate;
	protected String deptName;
	protected String empName;
	protected String accountName;
	protected String expenseReport;
	protected String leftDebtorPrice;
	protected String rightCreditsPrice;
	public String getSlipNo() {
		return slipNo;
	}
	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}
	public String getReportingDate() {
		return reportingDate;
	}
	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getExpenseReport() {
		return expenseReport;
	}
	public void setExpenseReport(String expenseReport) {
		this.expenseReport = expenseReport;
	}
	public String getLeftDebtorPrice() {
		return leftDebtorPrice;
	}
	public void setLeftDebtorPrice(String leftDebtorPrice) {
		this.leftDebtorPrice = leftDebtorPrice;
	}
	public String getRightCreditsPrice() {
		return rightCreditsPrice;
	}
	public void setRightCreditsPrice(String rightCreditsPrice) {
		this.rightCreditsPrice = rightCreditsPrice;
	}
	
}
