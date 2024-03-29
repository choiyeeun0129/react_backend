package kr.co.seoulit.account.sys.base.controller;

import kr.co.seoulit.account.posting.business.to.SlipBean;
import kr.co.seoulit.account.sys.base.entity.PeriodEntity;
import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.service.JpaPeriodService;
import kr.co.seoulit.account.sys.base.to.PeriodNoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class PeriodNoController {

	@Autowired
	private BaseService baseService;
	@Autowired
	private JpaPeriodService jpaPeriodService;

	@GetMapping("/periodNoList")
	public HashMap<String, Object> findPeriodNo() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("periodNoList", baseService.findPeriodNo());
		return map;
	}

	// ====== JPA 구현 / PeriodNo조회 ======
//	@GetMapping("/periodNoList")
//	public HashMap<String, Object> findPeriodNo() {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("periodNoList", jpaPeriodService.findPeriodNo());
//		return map;
//	}

//	@GetMapping("/tPeriodNoList")
//	public PeriodNoBean findPeriodNo(@RequestParam("yearFirst") String yearFirst,
//			@RequestParam("yearLast") String yearLast) {
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.out.println("여기 걸림");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("yearFirst", yearFirst);
//		map.put("yearLast", yearLast);
//		PeriodNoBean PeriodNoBean = baseService.findTPeriodNo(map);
//		return PeriodNoBean;
//	}

	// JPA 구현. 회계기수일련번호 조회 구현.
	@GetMapping("/tPeriodNoList")
	public PeriodEntity findPeriodNo(@RequestParam("yearFirst") String yearFirst,
			@RequestParam("yearLast") String yearLast) {

		PeriodEntity periodEntity = jpaPeriodService.findTPeriodNo(yearFirst, yearLast);
		return periodEntity;
	}
}