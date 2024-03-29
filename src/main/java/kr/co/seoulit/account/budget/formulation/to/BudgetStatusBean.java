package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

import java.util.List;


public class BudgetStatusBean extends BaseBean {
    private String accountInnerCode;
    private String accountName;
    private long ABR;//연간 예산 실적
    private long annualBudget;
    private long remainingBudget;
    private double budgetExecRate;//집행률
    private long AMBR;
    private long Budget;
    private long remainingMonthBudget;
    private double monthBudgetExecRate;//집행률

    public long getABR() {return ABR;}

    public double getBudgetExecRate() {
        return budgetExecRate;
    }

    public void setBudgetExecRate(double budgetExecRate) {
        this.budgetExecRate = budgetExecRate;
    }

    public double getMonthBudgetExecRate() {
        return monthBudgetExecRate;
    }

    public void setMonthBudgetExecRate(double monthBudgetExecRate) {
        this.monthBudgetExecRate = monthBudgetExecRate;
    }

    public void setABR(long ABR) {this.ABR = ABR;}
    public long getAMBR() {return AMBR;}
    public void setAMBR(long AMBR) {this.AMBR = AMBR;}
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

    public long getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(long annualBudget) {
        this.annualBudget = annualBudget;
    }

    public long getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(long remainingBudget) {
        this.remainingBudget = remainingBudget;
    }


    public long getBudget() {
        return Budget;
    }

    public void setBudget(long Budget) {
        this.Budget = Budget;
    }

    public long getRemainingMonthBudget() {
        return remainingMonthBudget;
    }

    public void setRemainingMonthBudget(long remainingMonthBudget) {
        this.remainingMonthBudget = remainingMonthBudget;
    }




}
