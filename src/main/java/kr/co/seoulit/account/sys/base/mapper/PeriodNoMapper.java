package kr.co.seoulit.account.sys.base.mapper;

import kr.co.seoulit.account.sys.base.to.PeriodNoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface PeriodNoMapper {
    public List<PeriodNoBean> findPeriodNo();
    
    public PeriodNoBean selectPeriodNo(HashMap<String, Object> map);
}
