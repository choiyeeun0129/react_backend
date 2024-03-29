package kr.co.seoulit.account.settlement.financialstatements.controller;

import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class MonthIncomeController {

    @Autowired
    private FinancialStatementsService financialStatementsService;

    @GetMapping("/monthIncomeStatements")
    public HashMap<String , Object> findMonthIncome(@RequestParam("searchDate") String searchDate){
        HashMap<String , Object> map =new HashMap<>();
        try {
            HashMap<String ,Object> monthIncomeList = financialStatementsService.getMonthIncome(searchDate);
            map.put("monthIncomeList", monthIncomeList);

        }catch (Exception e){
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
        }
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@킴상@@@@@@@@@@@@@@@@@@@@@@@");
    	System.out.println(searchDate);
    	System.out.println(map);
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@킴상@@@@@@@@@@@@@@@@@@@@@@@");
        return map;
    }

}
