package kr.co.seoulit.account.settlement.trialbalance.to;

public class TotalTrialBalanceBean {

    private long lev;
    private String accountName;
    private String accountInnerCode;
    private long debitsSumBalance;
    private long debitsSum;
    private long creditsSum;
    private long creditsSumBalance;

    public long getLev() {
        return lev;
    }

    public void setLev(long lev) {
        this.lev = lev;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountInnerCode() {
        return accountInnerCode;
    }

    public void setAccountInnerCode(String accountInnerCode) {
        this.accountInnerCode = accountInnerCode;
    }

    public long getDebitsSumBalance() {
        return debitsSumBalance;
    }

    public void setDebitsSumBalance(long debitsSumBalance) {
        this.debitsSumBalance = debitsSumBalance;
    }

    public long getDebitsSum() {
        return debitsSum;
    }

    public void setDebitsSum(long debitsSum) {
        this.debitsSum = debitsSum;
    }

    public long getCreditsSum() {
        return creditsSum;
    }

    public void setCreditsSum(long creditsSum) {
        this.creditsSum = creditsSum;
    }

    public long getCreditsSumBalance() {
        return creditsSumBalance;
    }

    public void setCreditsSumBalance(long creditsSumBalance) {
        this.creditsSumBalance = creditsSumBalance;
    }
}
