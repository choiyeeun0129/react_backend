package kr.co.seoulit.account.settlement.financialstatements.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CapitalStatementMapper {
    public HashMap<String, Object> selectcallCapitalStatement(HashMap<String, Object> params);

}
