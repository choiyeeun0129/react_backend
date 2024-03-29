package kr.co.seoulit.account.operate.system.to;

import java.util.ArrayList;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class AccountBean extends BaseBean {
    private ArrayList<AccountControlBean> accountControlList;
    private String accountInnerCode;
    private String parentAccountInnercode;
    private String accountCode;
    private String accountCharacter;
    private String accountName;
    private String accountUseCheck;
    private String accountDescription;
    private String editable;
    private String editform;
	private String lev;
    private String budget;
    
    public String getEditform() {
		return editform;
	}

	public void setEditform(String editform) {
		this.editform = editform;
	}

    public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public ArrayList<AccountControlBean> getAccountControlList() {
        return accountControlList;
    }

    public void setAccountControlList(ArrayList<AccountControlBean> accountControlList) {
        this.accountControlList = accountControlList;
    }

    public String getAccountInnerCode() {
        return accountInnerCode;
    }

    public void setAccountInnerCode(String accountInnerCode) {
        this.accountInnerCode = accountInnerCode;
    }

    public String getParentAccountInnercode() {
        return parentAccountInnercode;
    }

    public void setParentAccountInnercode(String parentAccountInnercode) {
        this.parentAccountInnercode = parentAccountInnercode;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountCharacter() {
        return accountCharacter;
    }

    public void setAccountCharacter(String accountCharacter) {
        this.accountCharacter = accountCharacter;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountUseCheck() {
        return accountUseCheck;
    }

    public void setAccountUseCheck(String accountUseCheck) {
        this.accountUseCheck = accountUseCheck;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }
}
