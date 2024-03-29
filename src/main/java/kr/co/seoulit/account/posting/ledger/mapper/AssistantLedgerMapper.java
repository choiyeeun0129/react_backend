package kr.co.seoulit.account.posting.ledger.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.ledger.to.AssetBean;
import kr.co.seoulit.account.posting.ledger.to.AssetItemBean;
import kr.co.seoulit.account.posting.ledger.to.DeptBean;

@Mapper
public interface AssistantLedgerMapper {

	ArrayList<AssetBean> selectAssetList();
	
	ArrayList<AssetItemBean> selectAssetItemList(String parentsCode);
	
	ArrayList<DeptBean> selectDeptList();
	
	void createAssetItem(HashMap<String, Object> map);
	
	void updateAssetItem(HashMap<String, Object> map);
	
	void removeAssetItem(String assetItemCode);

	public ArrayList<AssetItemBean> selectAssetDta(String parentsCode);
}
