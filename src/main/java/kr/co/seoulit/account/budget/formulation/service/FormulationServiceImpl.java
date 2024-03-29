package kr.co.seoulit.account.budget.formulation.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.budget.formulation.mapper.FormulationMapper;
import kr.co.seoulit.account.budget.formulation.to.BudgetBean;
import org.springframework.ui.ModelMap;

@Service
@Transactional
public class FormulationServiceImpl implements FormulationService {

    @Autowired
    private FormulationMapper formulationDAO;


    @Override
    public ArrayList<BudgetBean> findBudget(String deptCode, String workplaceCode , String accountPeriodNo , String accountInnerCode) {
        // TODO Auto-generated method stub

        ArrayList<BudgetBean> budgetBean= null;
        budgetBean = formulationDAO.selectBudget(deptCode,workplaceCode,accountPeriodNo,accountInnerCode);

        return budgetBean;
    }

    public BudgetBean findBudgetorganization(BudgetBean bean) {
        // TODO Auto-generated method stub
        return  formulationDAO.selectBudgetorganization(bean);
    }

    @Override
    public void findBudgetList(BudgetBean bean) {
        // TODO Auto-generated method stub
        formulationDAO.selectBudgetList(bean);
    }

    @Override
    public HashMap<String, Object> findBudgetStatus(HashMap<String, Object> params) {
        // TODO Auto-generated method stub
        HashMap<String, Object> budgetStatus = formulationDAO.selectBudgetStatus(params);
        System.out.println("========== budgetStatus : " + budgetStatus  + "==========");
        return budgetStatus;
    }


    @Override
    public BudgetBean findBudgetAppl(BudgetBean bean) {
        // TODO Auto-generated method stub

        return formulationDAO.selectBudgetAppl(bean);
    }

//   @Override
//   public ArrayList<BudgetBean> registerBudget(String deptCode, String workplaceCode, String accountPeriodNo,
//                                    String accountInnerCode, String m1Budget, String m2Budget, String m3Budget,
//                                    String m4Budget, String m5Budget, String m6Budget, String m7Budget, String m8Budget,
//                                    String m9Budget, String m10Budget, String m11Budget, String m12Budget){
//      ArrayList<BudgetBean> budgetBean= null;
//      budgetBean =formulationDAO.insertBudget(deptCode, workplaceCode, accountInnerCode,accountPeriodNo,m1Budget,m2Budget,m3Budget,m4Budget,m5Budget,m6Budget,m7Budget,m8Budget,m9Budget,m10Budget,m11Budget,m12Budget);
//
//      return budgetBean;
//
//
//   }

    @Override
    public ModelMap modifyBudget(BudgetBean bean) {
        ModelMap map = new ModelMap();
        try{
            formulationDAO.updateBudget(bean);
            map.put("errorCode", 1);
            map.put("errorMsg", "성공!");
        }
        catch (Exception e) {
            map.put("errorCode", -1);
            map.put("exceptionClass", e.getClass());
        }
        return map;
    }


    @Override
    public HashMap<String, Object> findComparisonBudget(HashMap<String, Object> params) {
        formulationDAO.selectComparisonBudget(params);


        return params;
    }

    @Override
    public ArrayList<BudgetBean> findCurrentBudget(String deptCode , String workplaceCode, String accountPeriodNo, String accountInnerCode){
        //budgetBean = formulationDAO.selectCurrentBudget(budgetBean);

        ArrayList<BudgetBean> budgetBean= null;

        budgetBean= formulationDAO.selectCurrentBudget(deptCode,workplaceCode,accountInnerCode,accountPeriodNo);

        return budgetBean;

    }


	@Override
	public void registerBudget(BudgetBean budgetBean) {
		// TODO Auto-generated method stub
		formulationDAO.insertBudget(budgetBean);
	}

	
}