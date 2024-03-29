package kr.co.seoulit.account.settlement.financialstatements.controller;
import java.util.HashMap;
import java.util.ArrayList;

import kr.co.seoulit.account.settlement.financialstatements.to.CapitalStatementBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;
import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;

@CrossOrigin("*")
@RestController
@Log4j2
@RequestMapping("/settlement")
public class CapitalStatementController {
    @Autowired
    private FinancialStatementsService financialStatementsService;


    @GetMapping("/capitalstatement")
    public HashMap<String, Object> handleRequestInternal(@RequestParam("accountPeriodNo") String accountPeriodNo,
                                                         @RequestParam("callResult") String callResult) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            HashMap<String ,Object> capitalList = financialStatementsService.findCapitalStatement(accountPeriodNo, callResult);
            map.put("capitalList", capitalList);
        }catch (Exception e){
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
        }
        System.out.println("============자본변동표==========");
        System.out.println(map);
        System.out.println("============자본변동표==========");
        return map;
    }
}
