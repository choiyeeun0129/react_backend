package kr.co.seoulit.account.settlement.trialbalance.to;

public class ImTotalTrialBalanceBean {
private String accountName;
private long leftBalance;
private long  sumLeftDebtorPrice;
private long rightBalance;
private long sumRightCreditsPrice;

public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public long getLeftBalance() {
	return leftBalance;
}
public void setLeftBalance(long leftBalance) {
	this.leftBalance = leftBalance;
}
public long getSumLeftDebtorPrice() {
	return sumLeftDebtorPrice;
}
public void setSumLeftDebtorPrice(long sumLeftDebtorPrice) {
	this.sumLeftDebtorPrice = sumLeftDebtorPrice;
}
public long getRightBalance() {
	return rightBalance;
}
public void setRightBalance(long rightBalance) {
	this.rightBalance = rightBalance;
}
public long getSumRightCreditsPrice() {
	return sumRightCreditsPrice;
}
public void setSumRightCreditsPrice(long sumRightCreditsPrice) {
	this.sumRightCreditsPrice = sumRightCreditsPrice;
}
}
