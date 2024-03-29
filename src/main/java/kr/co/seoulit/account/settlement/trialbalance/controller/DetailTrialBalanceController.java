package kr.co.seoulit.account.settlement.trialbalance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.account.settlement.trialbalance.service.TrialBalanceService;
import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;


@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class DetailTrialBalanceController {
	@Autowired
    private TrialBalanceService trialBalanceService;
    
	@GetMapping("/detailtrialbalance")
    public HashMap<String, Object> handleRequestInternal(@RequestParam("fromDate") String fromDate,
                                                         @RequestParam("toDate") String toDate) {
		 System.out.println("걸리냐?");
         HashMap<String , Object> map =new HashMap<>();
        ArrayList<DetailTrialBalanceBean> detailTrialBalanceList = trialBalanceService.findDetailTrialBalance(fromDate, toDate);
        map.put("detailTrialBalanceList" ,detailTrialBalanceList);
       
        return map;
    }

}
