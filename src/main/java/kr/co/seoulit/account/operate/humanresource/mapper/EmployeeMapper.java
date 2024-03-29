package kr.co.seoulit.account.operate.humanresource.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;
@Mapper
public interface EmployeeMapper {

    public ArrayList<EmployeeBean> selectEmployeeList(String deptCode);

    public void updateEmployeeInfo(EmployeeBean employeeBean);

    public void updateEmployee(EmployeeBean employBean);

    public void deleteEmployee(String empCode);

    public void insertEmployee(EmployeeBean employeeBean);

    public EmployeeBean selectEmployee(String EmpCode);
    
    public void updateImage(String newFileName);

	public EmployeeBean selectImage(String EMP_CODE);

	public ArrayList<EmployeeBean> selectEmployeeListAll();
}
