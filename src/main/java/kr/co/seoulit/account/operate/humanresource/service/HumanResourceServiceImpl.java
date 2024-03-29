package kr.co.seoulit.account.operate.humanresource.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.sys.base.mapper.DetailCodeMapper;
import kr.co.seoulit.account.sys.base.to.DetailCodeBean;

import kr.co.seoulit.account.operate.humanresource.mapper.EmployeeMapper;
import kr.co.seoulit.account.operate.humanresource.mapper.UserAuthorityGroupMapper;
import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;

@Service
@Transactional
public class HumanResourceServiceImpl implements HumanResourceService {
    
	@Autowired
    private EmployeeMapper employeeDAO;
	@Autowired
	private DetailCodeMapper codeDetailDAO;
	@Autowired
    private UserAuthorityGroupMapper usrePermissionGroupDAO;


    @Override
    public EmployeeBean findEmployee(String empCode) {


        EmployeeBean employeeBean = null;
        employeeBean = employeeDAO.selectEmployee(empCode);

        return employeeBean;
    }

    @Override
    public ArrayList<EmployeeBean> findEmployeeList(String deptCode) {


        ArrayList<EmployeeBean> empList = null;
        empList = employeeDAO.selectEmployeeList(deptCode);

        return empList;
    }
    
    @Override
    public ArrayList<EmployeeBean> findEmployeeList() {


        ArrayList<EmployeeBean> empList = null;
        empList = employeeDAO.selectEmployeeListAll();

        return empList;
    }

    @Override
    public void batchEmployeeInfo(EmployeeBean employeeBean) {

        	employeeDAO.updateEmployeeInfo(employeeBean);
    }

    @Override
    public void batchEmployee(ArrayList<EmployeeBean> empList) {

        	for (EmployeeBean employBean : empList) {
                String empStatus = employBean.getStatus();
                switch (empStatus) {
                    case "update":
                        modifyEmployee(employBean);
                        break;
                    case "delete":
                        removeEmployee(employBean);
                        break;
                }
            }
            for (int a = 0; a < empList.size(); a++) {
                System.out.println(empList.get(a).getEmpName());
            }
            
    }
    
    private void modifyEmployee(EmployeeBean employeeBean) {

        
            employeeDAO.updateEmployee(employeeBean);
            String empCode = employeeBean.getEmpCode();
            String empName = employeeBean.getEmpName();
            DetailCodeBean detailCodeBean = new DetailCodeBean();
            detailCodeBean.setDivisionCodeNo("HR-02");
            detailCodeBean.setDetailCode(empCode);
            detailCodeBean.setDetailCodeName(empName);
            codeDetailDAO.updateDetailCode(detailCodeBean);

    }

    @Override
    public void registerEmployee(EmployeeBean employeeBean) {


        	employeeDAO.insertEmployee(employeeBean);
            String empCode = employeeBean.getEmpCode();
            String empName = employeeBean.getEmpName();
            DetailCodeBean detailCodeBean = new DetailCodeBean();
            detailCodeBean.setDivisionCodeNo("HR-02");
            detailCodeBean.setDetailCode(empCode);
            detailCodeBean.setDetailCodeName(empName);
            codeDetailDAO.insertDetailCode(detailCodeBean);
           
    }

	@Override
	public void removeEmployee(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
	
	        	employeeDAO.deleteEmployee(employeeBean.getEmpCode());
	            codeDetailDAO.deleteDetailCode(employeeBean.getEmpCode());
	            
	}

	@Override
	public ArrayList<DepartmentBean> findDeptList() {
		// TODO Auto-generated method stub
		
        ArrayList<DepartmentBean> deptList=usrePermissionGroupDAO.selectDept();
        
        return deptList;
	}

	@Override
	public ArrayList<DepartmentBean> findDetailDeptList(String workplaceCode) {
		// TODO Auto-generated method stub
		
        ArrayList<DepartmentBean> detailDeptList=null;
        detailDeptList=usrePermissionGroupDAO.selectDetailDeptList(workplaceCode);
        
        return detailDeptList;
	}

	@Override
	public ArrayList<DepartmentBean> findDeptList2() {
		// TODO Auto-generated method stub
				
		        ArrayList<DepartmentBean> deptList=null;
		        deptList=usrePermissionGroupDAO.selectDeptList2();
		        
		        return deptList;
	}

	@Override
	public void modifyImage(String newFileName) {

			employeeDAO.updateImage(newFileName);
            
    }

	@Override
	public EmployeeBean findImage(String EMP_CODE) {
		// TODO Auto-generated method stub

		  EmployeeBean admin = null;
		  admin = employeeDAO.selectImage(EMP_CODE);
	           	
		return admin;
	}
		
	}


