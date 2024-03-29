package kr.co.seoulit.account.settlement.trialbalance.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class EarlyAssetBean extends BaseBean {
    private String gropuCode;
    private String accountInnerCode;
    private String accountName;
    private String price;
    private String statementsDivision;
    private String balanceDivision;
    private String leftDebtorPrice;
    private String rightCreditsPrice;


    public String getGropuCode() {
        return gropuCode;
    }

    public void setGropuCode(String gropuCode) {
        this.gropuCode = gropuCode;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatementsDivision() {
        return statementsDivision;
    }

    public void setStatementsDivision(String statementsDivision) {
        this.statementsDivision = statementsDivision;
    }

    public String getBalanceDivision() {
        return balanceDivision;
    }

    public void setBalanceDivision(String balanceDivision) {
        this.balanceDivision = balanceDivision;
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
