package kr.co.seoulit.account.budget.formulation.repository;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.entity.BudgetProductPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, BudgetProductPK>{

    ArrayList<BudgetEntity> findByDeptCodeAndWorkplaceCodeAndAccountInnerCodeAndAccountPeriodNoAndBudgetingCode(String deptCode, String workplaceCode, String accountInnerCode, String accountPeriodNo, String budgetingCode);
}
