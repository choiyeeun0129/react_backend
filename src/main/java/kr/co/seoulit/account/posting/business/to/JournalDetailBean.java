package kr.co.seoulit.account.posting.business.to;

//import java.util.List;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;
// 분개상세
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class JournalDetailBean extends BaseBean {
    private String journalDetailNo;
    private String accountControlName;
    private String accountControlType;
    private String description;
    private String accountControlDescription;
    private String journalNo;
    private String accountControlCode;
    private String accountCode;

    public String getAccountControlCode() {
		return accountControlCode;
	}

	public void setAccountControlCode(String accountControlCode) {
		this.accountControlCode = accountControlCode;
	}

	public String getJournalDetailNo() {
        return journalDetailNo;
    }

    public void setJournalDetailNo(String journalDetailNo) {
        this.journalDetailNo = journalDetailNo;
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

    public String getJournalDescription() {
        return description;
    }

    public void setJournalDescription(String journalDescription) {
        this.description = journalDescription;
    }

    public String getAccountControlDescription() {
        return accountControlDescription;
    }

    public void setAccountControlDescription(String accountControlDescription) {
        this.accountControlDescription = accountControlDescription;
    }

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}
	
	public String getJournalNo() {
        return journalNo;
    }
	
}
