package kr.co.seoulit.account.settlement.financialstatements.service;

import java.util.HashMap;

public interface FinancialStatementsService {

	public HashMap<String, Object> findFinancialPosition(String accountPeriodNo, String callResult);

	public HashMap<String, Object> findIncomeStatement(String accountPeriodNo, String callResult);


	public HashMap<String, Object> getMonthIncome(String searchDate);

	public HashMap<String, Object> findCapitalStatement(String accountPeriodNo, String callResult);

	public HashMap<String, Object> findAccountingStatement(String accountPeriodNo, String callResult);


}
