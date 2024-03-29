package kr.co.seoulit.account.posting.ledger.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = false)
@Data
public class CurrentAssetBean {

        private String accountCode;
        private String accountName;
        private String assetCode;
        private String assetName;
        private String progress;
        private String finalizeStatus;
        private String checkStatus;
        private ArrayList<CurrentAssetDetailBean> currentAssetDetailBean;


}
