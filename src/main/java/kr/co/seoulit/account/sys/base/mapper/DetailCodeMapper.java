package kr.co.seoulit.account.sys.base.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.sys.base.to.DetailCodeBean;

@Mapper
public interface DetailCodeMapper {

    public ArrayList<DetailCodeBean> selectDetailCodeList(HashMap<String, Object> map);

    void insertDetailCode(DetailCodeBean codeDetailBean);

    void updateDetailCode(DetailCodeBean codeDetailBean);

    void deleteDetailCode(String codeNo);

}
