package kr.co.seoulit.account.posting.business.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="RECEIPT")
public class ReceiptBean extends BaseBean{
    @Id
    private String slipNo;
    private String accountPeriodNo;
    private String reportingDate;
    private String expenseReport;
    private String receiptType;
    private String proofStatus;
}
