package kr.co.seoulit.account.sys.base.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.sys.base.to.MenuBean;

@Mapper
public interface MenuMapper {
    ArrayList<MenuBean> selectMenuList(String empCode);

    ArrayList<MenuBean> selectAllMenuList();
    
    ArrayList<MenuBean> selectMenuNameList(String deptCode);

}
