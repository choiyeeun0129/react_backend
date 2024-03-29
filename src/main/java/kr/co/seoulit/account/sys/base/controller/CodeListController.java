package kr.co.seoulit.account.sys.base.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.service.BaseServiceImpl;
import kr.co.seoulit.account.sys.base.to.CodeBean;
import kr.co.seoulit.account.sys.base.to.DetailCodeBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import net.sf.json.JSONObject;

@CrossOrigin("*")
@RestController
@RequestMapping("/base")
public class CodeListController{
	
	@Autowired
    private BaseService baseService;
	   
	@GetMapping("/detailcodelist")
 public ArrayList<DetailCodeBean> findDetailCodeList(@RequestParam String divisionCodeNo) {
     
		System.out.println(divisionCodeNo);
         HashMap<String, Object> map = new HashMap<>();
        
         map.put("divisionCodeNo", divisionCodeNo);
//         if (detailCodeName != null) //detailCodeName 입력 시
//             param.put("detailCodeName", detailCodeName); //param에 값 담음

         ArrayList<DetailCodeBean> detailCodeList = baseService.findDetailCodeList(map);
         System.out.println("컨트롤ㄹ러ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ");
       System.out.println(detailCodeList);//이제 이건 찍히는데
       
     return detailCodeList;

 }
	@GetMapping("/codelist")
 public ArrayList<CodeBean> findCodeList() {
     
         ArrayList<CodeBean> codeList = baseService.findCodeList();

         
     return codeList;
 }
	@GetMapping("/batchCodeProcess")
 public void batchCodeProcess(@RequestParam String batchList,@RequestParam String batchList2) {

         ObjectMapper mapper = new ObjectMapper();
         try {
         ArrayList<CodeBean> codeList = mapper.readValue(batchList, new TypeReference<ArrayList<CodeBean>>() {
         });

         ArrayList<DetailCodeBean> codeList2;
			
				
					codeList2 = mapper.readValue(batchList2,
					        new TypeReference<ArrayList<DetailCodeBean>>() {
					        });
					baseService.batchCodeProcess(codeList, codeList2);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
	
 

}}
