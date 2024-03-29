package kr.co.seoulit.account.budget.formulation.service;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;

import java.util.ArrayList;

public interface JpaBudgetService {
    void save(BudgetEntity budgetEntity);
    ArrayList<BudgetEntity> findBudget(BudgetEntity budgetEntity);
}

