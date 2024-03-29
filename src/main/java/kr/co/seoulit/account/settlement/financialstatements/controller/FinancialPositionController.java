package kr.co.seoulit.account.settlement.financialstatements.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class FinancialPositionController {

	 @Autowired
    private FinancialStatementsService financialStatementsService;
	
  
	 @GetMapping("/financialposition")
    public HashMap<String, Object> handleRequestInternal(@RequestParam("accountPeriodNo") String accountPeriodNo,
    								          			 @RequestParam("callResult") String callResult) {
      System.out.println(accountPeriodNo);
      System.out.println(callResult);
    	HashMap<String, Object> map = new HashMap<>();

		try {
			HashMap<String ,Object> financialPositionList = financialStatementsService.findFinancialPosition(accountPeriodNo, callResult);

			map.put("financialPositionList", financialPositionList);
		}catch (Exception e){
			map.put("errorCode", -1);
			map.put("errorMsg", e.getMessage());
		}
		System.out.println(map);
        return map;
    }

}