package kr.co.seoulit.account.sys.base.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeriodMapper {
	public String getPeriodNo(String today);
    
    public void insertPeriodNo(String sdate,String edate);
    
    public void updateEarlyStatements(String periodNo);

}
