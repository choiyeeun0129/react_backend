package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class PeriodBean extends BaseBean{

	private String accountPeriodNo;
	private String fiscalYear;
	private String workplaceCode;
	private String periodStartDate;
	private String periodEndDate;
	
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getAccountPeriodNo() {
		return accountPeriodNo;
	}
	public void setAccountPeriodNo(String accountPeriodNo) {
		this.accountPeriodNo = accountPeriodNo;
	}
	public String getWorkplaceCode() {
		return workplaceCode;
	}
	public void setWorkplaceCode(String workplaceCode) {
		this.workplaceCode = workplaceCode;
	}
	public String getPeriodStartDate() {
		return periodStartDate;
	}
	public void setPeriodStartDate(String periodStartDate) {
		this.periodStartDate = periodStartDate;
	}
	public String getPeriodEndDate() {
		return periodEndDate;
	}
	public void setPeriodEndDate(String periodEndDate) {
		this.periodEndDate = periodEndDate;
	}
	
}
