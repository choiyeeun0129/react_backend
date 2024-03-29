package kr.co.seoulit.account.settlement.trialbalance.to;

public class DetailTrialBalanceBean {
	private long lev;
	private String accountInnerCode;
	private long debitsSum;
	private long exceptCashDebits;
	private long cashDebits;
	private String accountName;
	private long creditsSumBalance;
	private long debitsSumBalance;
	private long cashCredits;
	private long exceptCashCredits;
	private long creditsSum;
	
	public long getCreditsSumBalance() {
		return creditsSumBalance;
	}
	public void setCreditsSumBalance(long creditsSumBalance) {
		this.creditsSumBalance = creditsSumBalance;
	}
	public long getDebitsSumBalance() {
		return debitsSumBalance;
	}
	public void setDebitsSumBalance(long debitsSumBalance) {
		this.debitsSumBalance = debitsSumBalance;
	}
	public long getLev() {
		return lev;
	}
	public void setLev(long lev) {
		this.lev = lev;
	}
	public String getAccountInnerCode() {
		return accountInnerCode;
	}
	public void setAccountInnerCode(String accountInnerCode) {
		this.accountInnerCode = accountInnerCode;
	}
	public long getDebitsSum() {
		return debitsSum;
	}
	public void setDebitsSum(long debitsSum) {
		this.debitsSum = debitsSum;
	}
	public long getExceptCashDebits() {
		return exceptCashDebits;
	}
	public void setExceptCashDebits(long exceptCashDebits) {
		this.exceptCashDebits = exceptCashDebits;
	}
	public long getCashDebits() {
		return cashDebits;
	}
	public void setCashDebits(long cashDebits) {
		this.cashDebits = cashDebits;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public long getCashCredits() {
		return cashCredits;
	}
	public void setCashCredits(long cashCredits) {
		this.cashCredits = cashCredits;
	}
	public long getExceptCashCredits() {
		return exceptCashCredits;
	}
	public void setExceptCashCredits(long exceptCashCredits) {
		this.exceptCashCredits = exceptCashCredits;
	}
	public long getCreditsSum() {
		return creditsSum;
	}
	public void setCreditsSum(long creditsSum) {
		this.creditsSum = creditsSum;
	}

}
