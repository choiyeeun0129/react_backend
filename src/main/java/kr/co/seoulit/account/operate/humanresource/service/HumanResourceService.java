package kr.co.seoulit.account.operate.humanresource.service;

import java.util.ArrayList;

import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;

public interface HumanResourceService {

    public ArrayList<EmployeeBean> findEmployeeList(String deptCode);
    
    public ArrayList<EmployeeBean> findEmployeeList();

    public EmployeeBean findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeBean employeeBean);

    public void batchEmployee(ArrayList<EmployeeBean> empList);

    public void registerEmployee(EmployeeBean employeeBean);
    
    public void removeEmployee(EmployeeBean employeeBean);
	
	public ArrayList<DepartmentBean> findDeptList();
	
	public ArrayList<DepartmentBean> findDeptList2();

	public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode);
	
	public void modifyImage(String newFileName);

	public EmployeeBean findImage(String EMP_CODE);
}
