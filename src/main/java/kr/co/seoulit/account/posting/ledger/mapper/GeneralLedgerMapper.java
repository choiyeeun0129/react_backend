package kr.co.seoulit.account.posting.ledger.mapper;

import kr.co.seoulit.account.posting.ledger.to.GeneralLedgerBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface GeneralLedgerMapper {

   public ArrayList<GeneralLedgerBean> selectGeneralAccountLedgerList(HashMap<String, Object> map);

   public ArrayList<GeneralLedgerBean> selectAccountLedger(HashMap<String, Object> map);
}
