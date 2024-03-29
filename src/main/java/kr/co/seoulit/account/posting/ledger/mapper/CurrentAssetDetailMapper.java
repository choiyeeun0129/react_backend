package kr.co.seoulit.account.posting.ledger.mapper;

import kr.co.seoulit.account.posting.ledger.to.CurrentAssetDetailBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CurrentAssetDetailMapper {

    public CurrentAssetDetailBean selectAssetDetail(String assetCode);
}
