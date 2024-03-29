package kr.co.seoulit.account.sys.base.mapper;

import kr.co.seoulit.account.sys.base.to.MonthBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthMapper {
    public List<MonthBean> findMonth();
}
