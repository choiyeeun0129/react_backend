package kr.co.seoulit.account.posting.business.controller;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.account.posting.business.service.JpaSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.service.BusinessServiceImpl;
import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.posting.business.to.SlipBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.util.BeanCreator;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import com.google.gson.Gson;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class SlipController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	JpaSlipService jpaSlipService;

	ModelAndView mav = null;
	ModelMap map = new ModelMap();



	// ====================전표 조회 ======================
	@GetMapping("/rangedsliplist")
	public ArrayList<SlipBean> findRangedSlipList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate, @RequestParam("slipStatus") String slipStatus) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("slipStatus", slipStatus);
		ArrayList<SlipBean> slipFormList = businessService.findRangedSlipList(map);
		System.out.println(slipFormList);
		return slipFormList;
	}

	// JPA 전표조회 구현 실패. SQL 내부표기익셉션 확인바람.
//	@GetMapping("/rangedsliplist")
//	public ArrayList<SlipEntity> findRangedSlipList(@RequestParam("startDate") String startDate,
//												  @RequestParam("endDate") String endDate, @RequestParam("slipStatus") String slipStatus) {
//		ArrayList<SlipEntity> slipFormList = jpaSlipService.findRangedSlipList(startDate,endDate,slipStatus);
//		return slipFormList;
//	}

	// ====================전표 삭제======================
	@DeleteMapping("/deleteSlip")
	public void removeSlip(@RequestParam String slipNo) {
		businessService.removeSlip(slipNo);
	}

// ====================전표 삭제 JPA Journal삭제 생각안함. FK부터 지워야됨.======================

//	@DeleteMapping("/deleteSlip")
//	public void removeSlip(@RequestParam String slipNo){
//		System.out.println("여기 슬립엔티티 슬립넘버있어요!!!!!!!!!!!+"+slipNo);
//		SlipEntity test = new SlipEntity();
//		test.setSlipNo(slipNo);
//		jpaSlipService.removeSlip(test.getSlipNo());
//}

	// =======================전표 저장==========================
	@PostMapping("/registerslip")
	public void registerSlip(@RequestBody SlipBean slipBean) {
		System.out.println("======================slipBean======================" + slipBean);
		slipBean.setSlipStatus(slipBean.getSlipStatus());
		businessService.registerSlip(slipBean);
	}

	// =======================전표 수정==========================
	@PutMapping("/updateSlip")
	public void updateSlip(@RequestBody SlipBean slipBean) {

		businessService.updateSlip(slipBean);
	}

	// =======================전표 승인 요청==========================
	@PatchMapping("/approvalSlipRequest")
	public void approvalSlipRequest(@RequestBody SlipBean slipBean) {
		businessService.approvalSlipRequest(slipBean);

	}
	//=======================전표 승인 완료==========================
	@PatchMapping("/approvalslip")
	public void modifyapproveSlip(@RequestBody SlipBean slipBean) {
		businessService.modifyapproveSlip(slipBean);
	}
//병합
	@GetMapping("/approvalsliplist")
	public ArrayList<SlipBean> findApprovalSlipList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate, @RequestParam("slipStatus") String status) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("status", status);
		ArrayList<SlipBean> approvalSlipList = businessService.findApprovalSlipList(map);

		return approvalSlipList;
	}


	@GetMapping("/findSlip")
	public ArrayList<SlipBean> findSlip(@RequestParam String slipNo) {

		return businessService.findSlip(slipNo);
	}

	@GetMapping("/accountingsettlementstatus")
	public HashMap<String, Object> findAccountingSettlementStatus(@RequestParam String accountPeriodNo,
			@RequestParam String callResult) {
		JSONObject json = new JSONObject();
		HashMap<String, Object> params = new HashMap<>();

		params.put("accountPeriodNo", accountPeriodNo);
		params.put("callResult", callResult);

		json.put("errorCode", 0);
		json.put("errorMsg", "데이터 조회 성공");

		businessService.findAccountingSettlementStatus(params);

		return params;
	}

}