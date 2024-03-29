package kr.co.seoulit.account.sys.base.to;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class DetailCodeBean extends BaseBean {
    private String divisionCodeNo;
    private String detailCode;
    private String detailCodeName;
    private String description;

//    public String getDivisionCodeNo() {
//        return divisionCodeNo;
//    }
//
//    public void setDivisionCodeNo(String divisionCodeNo) {
//        this.divisionCodeNo = divisionCodeNo;
//    }
//
//    public String getDetailCode() {
//        return detailCode;
//    }
//
//    public void setDetailCode(String detailCode) {
//        this.detailCode = detailCode;
//    }
//
//    public String getDetailCodeName() {
//        return detailCodeName;
//    }
//
//    public void setDetailCodeName(String detailCodeName) {
//        this.detailCodeName = detailCodeName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

}
