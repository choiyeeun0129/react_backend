package kr.co.seoulit.account.settlement.financialstatements.controller;

import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@CrossOrigin("*")
@Log4j2
@RestController
@RequestMapping("/settlement")
public class AccountingStatementController {

	@Autowired
  private FinancialStatementsService financialStatementsService;


	@GetMapping("/accounting")
    public HashMap<String, Object> handleRequestInternal(@RequestParam("accountPeriodNo") String accountPeriodNo,
		     								             @RequestParam("callResult") String callResult) {

		HashMap<String, Object> map = new HashMap<>();

		try {
			HashMap<String , Object> accountingList = financialStatementsService.findAccountingStatement(accountPeriodNo , callResult);
			map.put("accountingList" , accountingList);
		}catch (Exception e){
			map.put("errorCode", -1);
			map.put("errorMsg", e.getMessage());
		}
		System.out.println("============결산자료==========");
		System.out.println(map);
		System.out.println("============결산자료==========");
        return map;
    }

}


