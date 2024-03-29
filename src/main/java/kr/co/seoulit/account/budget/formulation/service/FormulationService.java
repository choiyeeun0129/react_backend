package kr.co.seoulit.account.budget.formulation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import kr.co.seoulit.account.budget.formulation.to.BudgetBean;
import kr.co.seoulit.account.budget.formulation.to.BudgetStatusBean;
import kr.co.seoulit.account.budget.formulation.to.ComparisonBudgetBean;
import org.springframework.ui.ModelMap;

public interface FormulationService {

	public ArrayList<BudgetBean> findBudget(String deptCode, String workplaceCode , String accountPeriodNo , String accountInnerCode);

	public BudgetBean findBudgetorganization(BudgetBean bean);

	public void findBudgetList(BudgetBean bean);

	public BudgetBean findBudgetAppl(BudgetBean bean);

	public HashMap<String, Object> findBudgetStatus(HashMap<String, Object> bean);

	//public ModelMap registerBudget(BudgetBean bean);

	public ModelMap modifyBudget(BudgetBean bean);

	public HashMap<String, Object> findComparisonBudget(HashMap<String, Object> bean);

	public ArrayList<BudgetBean> findCurrentBudget(String deptCode , String workplaceCode, String accountPeriodNo, String accountInnerCode);

	public void registerBudget(BudgetBean budgetBean);


//	public ArrayList<BudgetBean> registerBudget(String deptCode, String workplaceCode, String accountPeriodNo, String accountInnerCode, String m1Budget, String m2Budget, String m3Budget, String m4Budget, String m5Budget, String m6Budget, String m7Budget, String m8Budget, String m9Budget, String m10Budget, String m11Budget, String m12Budget);
}