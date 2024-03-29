package kr.co.seoulit.account.operate.humanresource.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;

@Mapper
public interface UserAuthorityGroupMapper {
	
	public ArrayList<DepartmentBean> selectDept();
	
	public ArrayList<DepartmentBean> selectDeptList2();
	
	public ArrayList<DepartmentBean> selectDetailDeptList(String workplaceCode);

	
}
