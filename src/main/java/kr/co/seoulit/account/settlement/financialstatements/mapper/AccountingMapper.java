package kr.co.seoulit.account.settlement.financialstatements.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface AccountingMapper {
	public HashMap<String, Object> selectcallAccountingStatement(HashMap<String, Object> param);


}
