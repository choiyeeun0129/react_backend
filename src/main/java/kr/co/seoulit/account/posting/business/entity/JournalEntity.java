package kr.co.seoulit.account.posting.business.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Journal")
@NoArgsConstructor
@Data
public class JournalEntity {
    @Id
    private String journalNo;
    private String slipNo;
    private String balanceDivision;
    private String accountInnerCode;
    private String customerCode;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
}
