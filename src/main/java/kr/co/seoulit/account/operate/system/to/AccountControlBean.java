package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class AccountControlBean extends BaseBean {
    private String accountControlCode;
    private String accountControlName;
    private String accountControlType;
    private String accountControlDescription;

	public String getAccountControlDescription() {
		return accountControlDescription;
	}

	public void setAccountControlDescription(String accountControlDescription) {
		this.accountControlDescription = accountControlDescription;
	}

	public String getAccountControlCode() {
        return accountControlCode;
    }

    public void setAccountControlCode(String accountControlCode) {
        this.accountControlCode = accountControlCode;
    }

    public String getAccountControlName() {
        return accountControlName;
    }

    public void setAccountControlName(String accountControlName) {
        this.accountControlName = accountControlName;
    }

    public String getAccountControlType() {
        return accountControlType;
    }

    public void setAccountControlType(String accountControlType) {
        this.accountControlType = accountControlType;
    }
}
