package kr.co.seoulit.account.operate.system.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.operate.system.to.AccountControlBean;
import kr.co.seoulit.account.operate.system.to.PeriodBean;

@Mapper
public interface AccountSubjectMapper {

    void insertDetailaccountList(AccountBean accountBean);

    public ArrayList<AccountBean> selectAccount(HashMap<String, Object> map);

    public ArrayList<AccountBean> selectDetailAccountList(String code);

    public ArrayList<AccountBean> selectParentAccountList();

    public void updateAccount(AccountBean accountBean);

    public ArrayList<AccountBean> selectAccountListByName(String accountName);

    public ArrayList<AccountControlBean> selectAccountControlList(String accountCode);
    
    public ArrayList<AccountBean> selectDetailBudgetList(String code);
    
    public ArrayList<AccountBean> selectParentBudgetList();
    
    public ArrayList<PeriodBean> selectAccountPeriodList();

    ArrayList<AccountBean> selectParentBudgetList2(String workplaceCode, String deptCode, String accountPeriodNo);

    public ArrayList<AccountBean> selectCurrentAssetList();
    
    public ArrayList<AccountBean> JournalAccountList(HashMap<String, Object> map);

}
