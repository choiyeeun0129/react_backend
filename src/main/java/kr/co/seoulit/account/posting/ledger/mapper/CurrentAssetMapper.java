package kr.co.seoulit.account.posting.ledger.mapper;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.to.CurrentAssetBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface CurrentAssetMapper {
    public ArrayList<CurrentAssetBean> selectCurrentAssetList(String accountCode, String accountName);

    public ArrayList<AccountBean> selectCurrentAssetList1();
}
