package kr.co.seoulit.account.operate.system.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class CustomerBean {
    private String customerCode;
    private String workplaceCode;
    private String customerName;
    private String customerType;
    private String customerCeo;
    private String businessLicenseNumber;
    private String socialSecurityNumber;
    private String customerBusinessConditions;
    private String customerBusinessItems;
    private String customerZipCode;
    private String customerBasicAddress;
    private String customerDetailAddress;
    private String customerTelNumber;
    private String customerFaxNumber;
    private String accountNumber;
    private String cardNumber;
    private String customerNote;
    private String cardType;
    private String cardMemberName;
    private String cardOpenPlace;
    private String financialInstituteName;
    private String financialInstituteCode;
    private String status;

}
