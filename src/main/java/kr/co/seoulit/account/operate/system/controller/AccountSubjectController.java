package kr.co.seoulit.account.operate.system.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.entity.AccountEntity;
import kr.co.seoulit.account.operate.system.service.JpaAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.operate.system.service.SystemService;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.operate.system.to.AccountControlBean;
import kr.co.seoulit.account.operate.system.to.PeriodBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/operate")
public class AccountSubjectController {

	@Autowired
	private SystemService systemService;
	@Autowired
	private JpaAccountService jpaAccountService;

	ModelAndView mav = null;
	ModelMap map = new ModelMap();

	@GetMapping("/account")
	public ArrayList<AccountBean> findAccount(@RequestParam String accountCode, @RequestParam String accountName) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("accountCode", accountCode);
		map.put("accountName", accountName);
		ArrayList<AccountBean> accountBean = systemService.findAccount(map);
		map.put("accountBean", accountBean);
		return accountBean;
	}

	@GetMapping("/accountcontrollist")
	public ArrayList<AccountControlBean> findAccountControlList(
			@RequestParam(value = "accountCode", required = false) String accountCode) {

		ArrayList<AccountControlBean> accountControlList = systemService.findAccountControlList(accountCode);

		return accountControlList;
	}

	@GetMapping("/accountlistbyname")
	public ArrayList<AccountBean> findAccountListByName(@RequestParam String accountName) {

		ArrayList<AccountBean> accountList = systemService.findAccountListByName(accountName);

		return accountList;
	}

//	@GetMapping("/parentaccountlist") // 계정과목조회
//	public HashMap<String, Object> getAccountList() {
//
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("accountCodeList", systemService.findParentAccountList());
//		return map;
//	}

	// 계정과목조회 JPA 구현완료.
	@GetMapping("/parentaccountlist") // 계정과목조회
	public HashMap<String, Object> getAccountList() {
		String accountInnerCode = "%-%";
		String s = "0101-0250"; String v = "0101-1000";
		ArrayList<String> parentAccountInnerCode = new ArrayList<String>();
		parentAccountInnerCode.add(s); parentAccountInnerCode.add(v);

		HashMap<String, Object> map = new HashMap<>();

		System.out.println(jpaAccountService.findParentAccountList(accountInnerCode, parentAccountInnerCode));

		ArrayList<AccountEntity> accountCodeList =  jpaAccountService.findParentAccountList(accountInnerCode, parentAccountInnerCode);
		map.put("accountCodeList",accountCodeList);
		return map;
	}

	// 계정과목상세를 가져옴
	@GetMapping("/detailaccountlist")
	public ArrayList<AccountBean> findDetailAccountList(@RequestParam("code") String code) {
		ArrayList<AccountBean> accountList = systemService.findDetailAccountList(code);
		return accountList;
	}

	@PostMapping("/registerDetailaccountlist")
	public ArrayList<AccountBean> saveDetailAccountList(@RequestParam AccountBean accountBean) {
		System.out.println("accountBean = " + accountBean);
		systemService.registerDetailaccountList(accountBean);
		return null;
	}


	// JPA 구현 실패
//	@GetMapping("/detailaccountlist")
//	public ArrayList<AccountEntity> findDetailAccountList(@RequestParam("code") String code) {
//		String parentAccountInnerCode = "%_%";
//		ArrayList<AccountEntity> accountList = jpaAccountService.findDetailAccountList(code);
//		System.out.println("여기에요!!!!!"+accountList);
//		return accountList;
//	}

//    fromDate: fromDate,
//    toDate: toDate,
//    parentAccount: parentAccount
	@GetMapping("/jouranlaccountlist")
	public ArrayList<AccountBean> findJournalAccountList(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String parentAccountCode) {
		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(parentAccountCode);
		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("parentAccountCode", parentAccountCode);

		ArrayList<AccountBean> accountList = systemService.findJournalAccountList(map);

		return accountList;
	}

	@GetMapping("/accountmodification")
	public void modifyAccount(@RequestParam String accountInnerCode, @RequestParam String accountName) {

		AccountBean accountBean = new AccountBean();

		accountBean.setAccountInnerCode(accountInnerCode);
		accountBean.setAccountName(accountName);

	}

	@GetMapping("/detailbudgetlist")
	public HashMap<String, Object> findDetailBudgetList(@RequestParam("code") String code) {
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<AccountBean> budgetList = systemService.findDetailBudgetList(code);
		map.put("budgetList", budgetList);
		return map;
	}

	@GetMapping("/parentbudgetlist")
	public HashMap<String, Object> findParentBudgetList() {

		HashMap<String, Object> map = new HashMap<>();
		ArrayList<AccountBean> parentBudgetList = systemService.findParentBudgetList();
		map.put("parentBudgetList", parentBudgetList);
		return map;
	}

	@GetMapping("/parentbudgetlist2")
	public ArrayList<AccountBean> findParentBudgetList2(@RequestParam String workplaceCode,
			@RequestParam String deptCode, @RequestParam String accountPeriodNo) {
		System.out.println("workplaceCode:" + workplaceCode);
		System.out.println("deptCode:" + deptCode);
		ArrayList<AccountBean> parentBudgetList = systemService.findParentBudgetList2(workplaceCode, deptCode,
				accountPeriodNo);

		return parentBudgetList;
	}

	@GetMapping("/accountperiodlist")
	public ArrayList<PeriodBean> findAccountPeriodList() {

		ArrayList<PeriodBean> accountPeriodList = systemService.findAccountPeriodList();

		return accountPeriodList;
	}


}
