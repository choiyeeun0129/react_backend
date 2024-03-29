package kr.co.seoulit.account.operate.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.account.operate.system.to.*;

public interface SystemService {
	void registerDetailaccountList(AccountBean accountBean);
	
    public ArrayList<AccountBean> findAccount(HashMap<String , Object> map);
    
    public ArrayList<AccountBean> findParentAccountList();
    
    public ArrayList<AccountBean> findDetailAccountList(String code);
    
    public ArrayList<AccountBean> findJournalAccountList(HashMap<String , Object> map);
    
    public void modifyAccount(AccountBean accountBean);

    ArrayList<AccountBean> findAccountListByName(String accountName);

    ArrayList<AccountControlBean> findAccountControlList(String accountCode);
    
    public ArrayList<AccountBean> findDetailBudgetList(String code);
    
    public ArrayList<AccountBean> findParentBudgetList();
    
    public ArrayList<PeriodBean> findAccountPeriodList();
    
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode);
    
	public void modifyAuthorityGroup(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept);
	
	public ArrayList<AuthorityMenuBean> findAuthorityGroup();
	
	public ArrayList<AuthorityMenuBean> findAuthorityMenu(String menuName);
	
	public void addAuthorityGroup(String addAuthority,String nextGroupCode);
	
	public ArrayList<AuthorityEmpBean> findAuthorityGroupCode();
	
	public void modifyAuthorityMenu(ArrayList<AuthorityMenuBean> authorityMenuBean, String dept);
	
	public void removeAuthorityGroup(String groupCode);
	
	public ArrayList<BusinessBean> findBusinessList(); //�뾽�깭醫낅ぉ �쟾遺�議고쉶
	
	public ArrayList<DetailBusinessBean> findDetailBusiness(String businessName); // �뾽�깭醫낅ぉ �냼遺꾨쪟 �쟾遺�議고쉶
	
	public WorkplaceBean findWorkplace(String workplaceCode); // 1媛쒖궗�뾽�옣 議고쉶
	
	public void registerWorkplace(WorkplaceBean workplaceBean); //�궗�뾽�옣異붽�
	
	public void removeWorkplace(ArrayList<String> getCodes); //�궗�뾽�옣�궘�젣 //arraylist濡� 諛붽�爰쇱엫

	public void modifyApprovalStatus(ArrayList<String> getCodes,String status); //�궗�뾽�옣 �듅�씤�긽�깭 �뾽�뜲�씠�듃
		
	public ArrayList<WorkplaceBean> findAllWorkplaceList(); //紐⑤뱺�궗�뾽�옣議고쉶

    ArrayList<AccountBean> findParentBudgetList2(String workplaceCode, String deptCode,String accountPeriodNo);

	public List<CustomerBean> getCustomerList();

	public List<CustomerBean> getCreditCard();

	;
}
