
package kr.co.seoulit.account.budget.formulation.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.budget.formulation.to.BudgetBean;

@Mapper
public interface FormulationMapper {

	ArrayList<BudgetBean> selectBudget(String deptCode, String workplaceCode, String accountPeriodNo, String accountInnerCode);
	
	public BudgetBean selectBudgetorganization(BudgetBean bean);
	
	public void selectBudgetList(BudgetBean bean);
	
	public BudgetBean selectBudgetAppl(BudgetBean bean);
	
	public HashMap<String, Object> selectBudgetStatus(HashMap<String, Object> bean);

	//public ArrayList<BudgetBean> insertBudget(HashMap<String, Object> bean);

	public void updateBudget(BudgetBean bean);

	public HashMap<String, Object> selectComparisonBudget(HashMap<String, Object> params);

	public ArrayList<BudgetBean> selectCurrentBudget(String deptCode, String workplaceCode, String accountInnerCode, String accountPeriodNo);


	//public ArrayList<BudgetBean> insertBudget(String deptCode, String workplaceCode, String accountInnerCode, String accountPeriodNo, String m1Budget, String m2Budget, String m3Budget, String m4Budget, String m5Budget, String m6Budget, String m7Budget, String m8Budget, String m9Budget, String m10Budget, String m11Budget, String m12Budget);
	

	public void insertBudget(BudgetBean budgetBean);
}