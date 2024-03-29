package kr.co.seoulit.account.sys.base.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeBean extends BaseBean {
    private String divisionCodeNo;
    private String codeType;
    private String divisionCodeName;


    public String getDivisionCodeNo() {
        return divisionCodeNo;
    }

    public void setDivisionCodeNo(String divisionCodeNo) {
        this.divisionCodeNo = divisionCodeNo;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getDivisionCodeName() {
        return divisionCodeName;
    }

    public void setDivisionCodeName(String divisionCodeName) {
        this.divisionCodeName = divisionCodeName;
    }

}
