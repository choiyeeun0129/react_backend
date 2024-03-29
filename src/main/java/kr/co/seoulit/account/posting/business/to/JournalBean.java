package kr.co.seoulit.account.posting.business.to;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;

// 분개
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class JournalBean extends BaseBean {
    private String id;
    private String slipNo;
    private String journalNo;
    private String balanceDivision;
    private String accountCode;
    private String accountName;
    private String customerCode;
    private String customerName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String price;
    private String deptCode;
    private String accountPeriodNo;
    private String reportingDate;
    private String expenseReport;
    private List<JournalDetailBean> journalDetailList;
//    public String getReportingDate() {
//		return reportingDate;
//	}
//	public void setReportingDate(String reportingDate) {
//		this.reportingDate = reportingDate;
//	}
//	public String getExpenseReport() {
//		return expenseReport;
//	}
//	public void setExpenseReport(String expenseReport) {
//		this.expenseReport = expenseReport;
//	}
//    
//	public List<JournalDetailBean> getJournalDetailList() {
//		return journalDetailList;
//	}
//	public void setJournalDetailList(List<JournalDetailBean> journalDetailList) {
//		this.journalDetailList = journalDetailList;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getSlipNo() {
//		return slipNo;
//	}
//	public void setSlipNo(String slipNo) {
//		this.slipNo = slipNo;
//	}
//	public String getJournalNo() {
//		return journalNo;
//	}
//	public void setJournalNo(String journalNo) {
//		this.journalNo = journalNo;
//	}
//	public String getBalanceDivision() {
//		return balanceDivision;
//	}
//	public void setBalanceDivision(String balanceDivision) {
//		this.balanceDivision = balanceDivision;
//	}
//	public String getAccountCode() {
//		return accountCode;
//	}
//	public void setAccountCode(String accountCode) {
//		this.accountCode = accountCode;
//	}
//	public String getAccountName() {
//		return accountName;
//	}
//	public void setAccountName(String accountName) {
//		this.accountName = accountName;
//	}
//	public String getCustomerCode() {
//		return customerCode;
//	}
//	public void setCustomerCode(String customerCode) {
//		this.customerCode = customerCode;
//	}
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public String getLeftDebtorPrice() {
//		return leftDebtorPrice;
//	}
//	public void setLeftDebtorPrice(String leftDebtorPrice) {
//		this.leftDebtorPrice = leftDebtorPrice;
//	}
//	public String getRightCreditsPrice() {
//		return rightCreditsPrice;
//	}
//	public void setRightCreditsPrice(String rightCreditsPrice) {
//		this.rightCreditsPrice = rightCreditsPrice;
//	}
//	public String getPrice() {
//		return price;
//	}
//	public void setPrice(String price) {
//		this.price = price;
//	}
//	public String getDeptCode() {
//		return deptCode;
//	}
//	public void setDeptCode(String deptCode) {
//		this.deptCode = deptCode;
//	}
//	public String getAccountPeriodNo() {
//		return accountPeriodNo;
//	}
//	public void setAccountPeriodNo(String accountPeriodNo) {
//		this.accountPeriodNo = accountPeriodNo;
//	}

    


}
