package kr.co.seoulit.account.budget.formulation.to;

public class ComparisonBudgetBean {
    private String budgetDate;
    private String appBudget;
    private String orgBudget;
    private String execPerform;
    private String budgetAccountComparison;

    public String getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(String budgetDate) {
        this.budgetDate = budgetDate;
    }

    public String getAppBudget() {
        return appBudget;
    }

    public void setAppBudget(String appBudget) {
        this.appBudget = appBudget;
    }

    public String getOrgBudget() {
        return orgBudget;
    }

    public void setOrgBudget(String orgBudget) {
        this.orgBudget = orgBudget;
    }

    public String getExecPerform() {
        return execPerform;
    }

    public void setExecPerform(String execPerform) {
        this.execPerform = execPerform;
    }

    public String getBudgetAccountComparison() {
        return budgetAccountComparison;
    }

    public void setBudgetAccountComparison(String budgetAccountComparison) {
        this.budgetAccountComparison = budgetAccountComparison;
    }
}
