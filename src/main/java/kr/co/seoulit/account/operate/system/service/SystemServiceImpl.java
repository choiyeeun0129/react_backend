package kr.co.seoulit.account.operate.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.account.operate.system.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.operate.system.mapper.AccountSubjectMapper;
import kr.co.seoulit.account.operate.system.mapper.AuthorityGroupMapper;
import kr.co.seoulit.account.operate.system.mapper.CustomerMapper;

@Service
@Transactional
public class SystemServiceImpl implements SystemService{
	
	@Autowired
    private AccountSubjectMapper accountDAO;
	@Autowired
    private AuthorityGroupMapper authorityGroupDAO;
	@Autowired
    private CustomerMapper customerDAO;


	@Override
	public void registerDetailaccountList(AccountBean accountBean) {
		accountDAO.insertDetailaccountList(accountBean);
	}

	@Override
	public ArrayList<AccountBean> findAccount(HashMap<String, Object> map) {


        	ArrayList<AccountBean> accountBean = accountDAO.selectAccount(map);


        return accountBean;
    }

    @Override
    public ArrayList<AccountBean> findParentAccountList() {
		return accountDAO.selectParentAccountList();
    }

    @Override
    public ArrayList<AccountBean> findDetailAccountList(String code) {

        	ArrayList<AccountBean> accountList = null;
        	accountList = accountDAO.selectDetailAccountList(code);

        return accountList;
    }
    
    @Override
	public ArrayList<AccountBean> findJournalAccountList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
    	ArrayList<AccountBean> accountBean = accountDAO.JournalAccountList(map);
		return accountBean;
	}

    @Override
    public void modifyAccount(AccountBean accountBean) {

        	accountDAO.updateAccount(accountBean);

    }

    @Override
    public ArrayList<AccountBean> findAccountListByName(String accountName) {

        	ArrayList<AccountBean> accountList = null;
        	accountList = accountDAO.selectAccountListByName(accountName);

        return accountList;
    }

    @Override
    public ArrayList<AccountControlBean> findAccountControlList(String accountCode) {

        	ArrayList<AccountControlBean> accountControlList = null;
        	accountControlList = accountDAO.selectAccountControlList(accountCode);

        return accountControlList;
    }

	@Override
	public ArrayList<AccountBean> findDetailBudgetList(String code) {
		// TODO Auto-generated method stub

        	ArrayList<AccountBean> budgetList = null;
        	budgetList = accountDAO.selectDetailBudgetList(code);

        return budgetList;
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList() {
		// TODO Auto-generated method stub

        	ArrayList<AccountBean> parentBudgetList = null;
        	parentBudgetList = accountDAO.selectParentBudgetList();

        return parentBudgetList;
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList2(String workplaceCode,String deptCode, String accountPeriodNo) {
		// TODO Auto-generated method stub

		ArrayList<AccountBean> parentBudgetList = null;
		parentBudgetList = accountDAO.selectParentBudgetList2(workplaceCode,deptCode,accountPeriodNo);

		return parentBudgetList;
	}

	@Override
	public ArrayList<PeriodBean> findAccountPeriodList() {
		// TODO Auto-generated method stub

			ArrayList<PeriodBean> accountPeriodList = null;
        	accountPeriodList = accountDAO.selectAccountPeriodList();

        return accountPeriodList;
	}
	
	@Override
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode) {


        	ArrayList<AuthorityEmpBean> authorityEmp = null;
        	authorityEmp = authorityGroupDAO.selectAuthorityEmp(deptCode);

        return authorityEmp;
    }

	@Override
	public void modifyAuthorityGroup(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept) {

	        	for(AuthorityEmpBean bean : authorityEmpBean) {
	        		authorityGroupDAO.updateAuthorityGroup(bean, dept);
	        }
	}

	@Override
	public ArrayList<AuthorityMenuBean> findAuthorityGroup(){


        	ArrayList<AuthorityMenuBean> authorityGroup= null;
        	authorityGroup = authorityGroupDAO.selectAuthorityGroup();

        return authorityGroup;
    }

	@Override
	public void addAuthorityGroup(String addAuthority,String nextGroupCode) {

	        	authorityGroupDAO.insertAuthorityGroup(addAuthority,nextGroupCode); 

	}
	@Override
	public ArrayList<AuthorityEmpBean> findAuthorityGroupCode() {
		

        	ArrayList<AuthorityEmpBean> findAuthorityGroupCode= null;
        	findAuthorityGroupCode = authorityGroupDAO.selectAuthorityGroupCode();

        return findAuthorityGroupCode;
    }
	@Override
	public void removeAuthorityGroup(String groupCode) {
	
	        	authorityGroupDAO.deleteAuthorityGroup(groupCode);   
	        	authorityGroupDAO.deleteAuthorityMenu(groupCode); 

	}
	@Override
	public ArrayList<AuthorityMenuBean> findAuthorityMenu(String menuName){
		
			HashMap<String, String> map = new HashMap<>();
			map.put("menuName", menuName);
        	ArrayList<AuthorityMenuBean> authorityMenu= null;
        	authorityMenu = authorityGroupDAO.selectAuthorityMenu(map);

        return authorityMenu;
    }
	@Override
	public void modifyAuthorityMenu(ArrayList<AuthorityMenuBean> authorityMenuBean, String dept) {

	        	for(AuthorityMenuBean bean : authorityMenuBean) {
	        		authorityGroupDAO.updateAuthorityMenu(bean, dept);
	            }

	}
	
	@Override
	public void registerWorkplace(WorkplaceBean workplaceBean) {

			WorkplaceBean workplaceCodeCheck = customerDAO.selectWorkplace(workplaceBean.getWorkplaceCode());
			if(workplaceCodeCheck==null) {
			System.out.println("workplaceBean : "+workplaceBean);
			customerDAO.insertWorkplace(workplaceBean);
			}
	}
	
	@Override
	public void removeWorkplace(ArrayList<String> getCodes) {

			for(String code : getCodes) {
				customerDAO.deleteWorkplace(code);
        		System.out.println("사업장삭제완료:"+code);
			}
	}
	
	@Override
	public void modifyApprovalStatus(ArrayList<String> getCodes,String status) {
		
				for(String code : getCodes) {
					customerDAO.updateWorkplaceAccount(code, status);
        		
		}
	}
	
	@Override
	public WorkplaceBean findWorkplace(String workplaceCode) {
		
			WorkplaceBean workplaceBean =null;
			workplaceBean = customerDAO.selectWorkplace(workplaceCode);
		
		return workplaceBean;
	}
	
	
	@Override
	public ArrayList<WorkplaceBean> findAllWorkplaceList () {
	
			ArrayList<WorkplaceBean> allworkplaceList = null;
			allworkplaceList = customerDAO.selectAllWorkplaceList();
		
		return allworkplaceList;
	}
	
	@Override
	public ArrayList<BusinessBean> findBusinessList() {
		
			ArrayList<BusinessBean> businessList = null;
			businessList = customerDAO.selectBusinessList();
		
		return businessList;
	}
	
	@Override
	public ArrayList<DetailBusinessBean> findDetailBusiness(String businessCode) {
		
			ArrayList<DetailBusinessBean> detailBusinessList = null;
			detailBusinessList = customerDAO.selectDetailBusinessList(businessCode);
		
		return detailBusinessList;
	}

	public List<CustomerBean> getCustomerList(){
		return customerDAO.selectCustomerList();
	}

	public List<CustomerBean> getCreditCard(){
		return customerDAO.selectCreditCardList();
	}

}
