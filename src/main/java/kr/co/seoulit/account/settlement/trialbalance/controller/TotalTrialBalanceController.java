package kr.co.seoulit.account.settlement.trialbalance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.account.posting.ledger.to.GeneralLedgerBean;
import kr.co.seoulit.account.settlement.trialbalance.service.TrialBalanceService;
import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class TotalTrialBalanceController {

	@Autowired
	private TrialBalanceService trialBalanceService;

//	@PostMapping("/totaltrialbalance")
//	public HashMap<String, Object> finddoClosing(@RequestParam("accountPeriodNo") String accountPeriodNo,
//			                                     @RequestParam("callResult") String callResult) {
//
//		HashMap<String,Object> params = new HashMap<>();
//		params.put("accountPeriodNo",accountPeriodNo);
//		params.put("callResult",callResult);
//
//
//             HashMap<String, Object> closingResult = trialBalanceService.findEarlyStatements(params);
//
//           return closingResult;
//	}

	@GetMapping("/earlyStatements")
	public HashMap<String, Object> finddoClosing(@RequestParam String accountPeriodNo,
			@RequestParam String callResult) {
		System.out.println(accountPeriodNo);
		System.out.println(callResult);
		HashMap<String, Object> params = new HashMap<>();
		params.put("accountPeriodNo", accountPeriodNo);
		params.put("callResult", callResult);

		HashMap<String, Object> closingResult = trialBalanceService.findEarlyStatements(params);

		return closingResult;
		
	}
//
//	@GetMapping("/searchTotalTrialBalance")
//	public HashMap<String, Object> searchTotalTrialBalance(@RequestParam("accountPeriodNo") String accountPeriodNo) {
//
//		HashMap<String, Object> map = new HashMap<>();
//		try {
//			HashMap<String, Object> totaltrialList = trialBalanceService.searchTotalTrialBalance(accountPeriodNo);
//			map.put("accountPeriodNo", accountPeriodNo);
//		} catch (Exception e2) {
//			map.put("errorCode", -1);
//			map.put("errorMsg", e2.getMessage());
//		}
//
//		return map;
//	}

	@GetMapping("/searchTotalTrialBalance")
	public ArrayList<TotalTrialBalanceBean> searchTotalTrialBalance(@RequestParam String accountPeriodNo) {
		System.out.println(accountPeriodNo);
		HashMap<String, Object> map = new HashMap<>();
		map.put("accountPeriodNo", accountPeriodNo);
		ArrayList<TotalTrialBalanceBean> totaltrialList = trialBalanceService.searchTotalTrialBalance(map);

		return totaltrialList;
	}

	@GetMapping("/totaltrialbalance")
	public HashMap<String, Object> findTotalTrialBalance(@RequestParam("accountPeriodNo") String accountPeriodNo,
			@RequestParam("callResult") String callResult) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			HashMap<String, Object> totaltrialList = trialBalanceService.findTotalTrialBalance(accountPeriodNo,
					callResult);
			map.put("totaltrialList", totaltrialList);
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}

		return map;
	}

	@PostMapping("/totaltrialbalancecancle")
	public void findcancelClosing(@RequestParam String accountPeriodNo, @RequestParam String callResult) {

		trialBalanceService.findchangeAccountingSettlement(accountPeriodNo, callResult);
	}

}
