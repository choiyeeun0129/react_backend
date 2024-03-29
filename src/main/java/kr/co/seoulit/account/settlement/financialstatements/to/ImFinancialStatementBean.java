package kr.co.seoulit.account.settlement.financialstatements.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class ImFinancialStatementBean extends BaseBean {

	private String accountName1;
	private String amount1;
	private String accountName2;
	private String amount2;
	public String getAccountName1() {
		return accountName1;
	}
	public void setAccountName1(String accountName1) {
		this.accountName1 = accountName1;
	}
	public String getAmount1() {
		return amount1;
	}
	public void setAmount1(String amount1) {
		this.amount1 = amount1;
	}
	public String getAccountName2() {
		return accountName2;
	}
	public void setAccountName2(String accountName2) {
		this.accountName2 = accountName2;
	}
	public String getAmount2() {
		return amount2;
	}
	public void setAmount2(String amount2) {
		this.amount2 = amount2;
	}
	
	
	
	
}
