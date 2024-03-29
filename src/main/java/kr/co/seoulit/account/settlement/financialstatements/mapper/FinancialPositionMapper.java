package kr.co.seoulit.account.settlement.financialstatements.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinancialPositionMapper {
	
	public HashMap<String, Object> selectcallFinancialPosition(HashMap<String,Object> params);
}
