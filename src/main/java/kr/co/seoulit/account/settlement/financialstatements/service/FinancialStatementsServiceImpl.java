package kr.co.seoulit.account.settlement.financialstatements.service;

import java.util.HashMap;

import kr.co.seoulit.account.settlement.financialstatements.mapper.CapitalStatementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.account.settlement.financialstatements.mapper.FinancialPositionMapper;
import kr.co.seoulit.account.settlement.financialstatements.mapper.IncomeStatementMapper;
import kr.co.seoulit.account.settlement.financialstatements.mapper.AccountingMapper;

@Service
public class FinancialStatementsServiceImpl implements FinancialStatementsService{

    @Autowired
    private FinancialPositionMapper financialPositionDAO;
    @Autowired
    private IncomeStatementMapper incomeStatementDAO;
    @Autowired
    private CapitalStatementMapper capitalStatementDAO;
    @Autowired
    private AccountingMapper accountingStatementDAO;


    @Override
    public HashMap<String, Object> findFinancialPosition(String accountPeriodNo , String callResult) {

        HashMap<String , Object> map = new HashMap<>();
        map.put("accountPeriodNo", accountPeriodNo);
        map.put("callResult" , callResult);
        financialPositionDAO.selectcallFinancialPosition(map);

        return map;
    }

    @Override
    public HashMap<String, Object> getMonthIncome(String searchDate){
        HashMap<String , Object> map= new HashMap<>();
        String year = searchDate.substring(0,4);
        map.put("year" , year);
        incomeStatementDAO.callMonthIncomeStatement(map);
        return map;
    }

    @Override
    public HashMap<String, Object> findIncomeStatement(String accountPeriodNo, String callResult) {

        HashMap<String, Object> map =new HashMap<>();
        map.put("accountPeriodNo", accountPeriodNo);
        map.put("callResult", callResult);
        incomeStatementDAO.selectcallIncomeStatement(map);

        return map;
    }
    @Override
    public HashMap<String, Object> findCapitalStatement(String accountPeriodNo , String callResult) {

        HashMap<String , Object> map = new HashMap<>();
        map.put("accountPeriodNo", accountPeriodNo);
        map.put("callResult" , callResult);
        capitalStatementDAO.selectcallCapitalStatement(map);
        return map;
    }

    @Override
    public HashMap<String, Object> findAccountingStatement(String accountPeriodNo , String callResult) {

        HashMap<String , Object> map = new HashMap<>();
        map.put("accountPeriodNo", accountPeriodNo);
        map.put("callResult" , callResult);
        accountingStatementDAO.selectcallAccountingStatement(map);
        return map;
    }


}
