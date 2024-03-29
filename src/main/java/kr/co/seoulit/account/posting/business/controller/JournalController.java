package kr.co.seoulit.account.posting.business.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.service.JpaSlipService;
import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.sys.common.util.BeanCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class JournalController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    JpaSlipService jpaSlipService;

    @GetMapping("/singlejournallist")
    public ArrayList<JournalBean> findSingleJournalList(@RequestParam("slipNo") String slipNo) {
        ArrayList<JournalBean> journalList = businessService.findSingleJournalList(slipNo);

        return journalList;
    }

    
    @GetMapping("/rangedjournallist")
    public ArrayList<JournalBean> findRangedJournalList(@RequestParam("startDate") String fromDate,
                                                         @RequestParam("endDate") String toDate) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fromDate", fromDate);
        map.put("toDate", toDate);
        map.put("expenseReport", null);
        map.put("reportingDate", null);
        ArrayList<JournalBean> journalList = businessService.findRangedJournalList(map);

        return journalList;
    }


    @DeleteMapping("/journalremoval")
    public void removeJournal(@RequestParam String journalNo) {
        System.out.println("여기 슬립엔티티 슬립넘버있어요!!!!!!!!!!!+"+journalNo);
        JournalEntity entity = new JournalEntity();
        entity.setJournalNo(journalNo);
        jpaSlipService.removeJournal(entity.getJournalNo());
}
   
//    @PostMapping("/modifyJournal")
//	public void modifyJournal(@RequestBody JSONObject jourData) {
//		String slipNo = ((JSONObject) jourData.get("jourData")).get("slipNo").toString();
//		Object journalObj = ((JSONObject) jourData.get("jourData")).get("journalObj");
//
//		JSONArray journalObjs = JSONArray.fromObject(journalObj);
//		System.out.println(journalObjs);//JSONArray까지 변환 시킴
//
//		ArrayList<JournalBean> journalBeanList = new ArrayList<>();
//
//		for (Object journalObjt : journalObjs) {
//            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalBean.class);
//            //System.out.println(((JSONObject) journalObjt).getString("status"));
//            journalBean.setStatus(((JSONObject) journalObjt).getString("status"));
//            journalBeanList.add(journalBean);
//        }
//		businessService.modifyJournal(slipNo, journalBeanList);
//	}
    @PostMapping("/modifyJournal")
	public void modifyJournal(@RequestBody JournalBean jourData) {
    	System.out.println(jourData);
//		String slipNo = ((JSONObject) jourData.get("jourData")).get("slipNo").toString();
//		Object journalObj = ((JSONObject) jourData.get("jourData")).get("journalObj");
//
//		JSONArray journalObjs = JSONArray.fromObject(journalObj);
//		System.out.println(journalObjs);//JSONArray까지 변환 시킴
//
//		ArrayList<JournalBean> journalBeanList = new ArrayList<>();
//
//		for (Object journalObjt : journalObjs) {
//            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalBean.class);
//            //System.out.println(((JSONObject) journalObjt).getString("status"));
//            journalBean.setStatus(((JSONObject) journalObjt).getString("status"));
//            journalBeanList.add(journalBean);
//        }
//		businessService.modifyJournal(slipNo, journalBeanList);
	}
    
    /*이전 modifyJournal
    @GetMapping("modifyJournal")
    public void modifyJournal(@RequestParam String slipNo,
                              @RequestParam JSONArray journalObj) {

        JSONArray journalObjs = JSONArray.fromObject(journalObj);

        ArrayList<JournalBean> journalBeanList = new ArrayList<>();

        for (Object journalObjt : journalObjs) {
            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalBean.class);
            journalBean.setStatus(((JSONObject) journalObjt).getString("status"));
            journalBeanList.add(journalBean);
        }
        businessService.modifyJournal(slipNo, journalBeanList);

    }*/

    /*@PostMapping("/updateJournalList")
    public void updateJournalList(@RequestBody HashMap<String , ArrayList<JournalBean>> journalList){

        businessService.updateJournalList(journalList);
    }*/
    
    @PutMapping("/updateJournalList")
    public void updateJournalList (@RequestBody JSONObject jourData) {
    	String slipNo = ((JSONObject) jourData.get("jourData")).get("slipNo").toString();
		Object journalObj = ((JSONObject) jourData.get("jourData")).get("journalObj");
		JSONArray journalObjs = JSONArray.fromObject(journalObj);
		System.out.println(journalObjs);//JSONArray까지 변환 시킴

		ArrayList<JournalBean> journalBeanList = new ArrayList<>();

		for (Object journalObjt : journalObjs) {
            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalBean.class);
            //System.out.println(((JSONObject) journalObjt).getString("status"));
            journalBean.setStatus(((JSONObject) journalObjt).getString("status"));
            journalBeanList.add(journalBean);
        }
		businessService.updateJournal(slipNo, journalBeanList);
		
    }
    
    @GetMapping("/approvalJournalList")
    public ArrayList<JournalBean> findApprovalJournalList(@RequestParam String slipNo) {

        ArrayList<JournalBean> approvalJournalList = businessService.findApprovalJournalList(slipNo);

        return approvalJournalList;
    }
}