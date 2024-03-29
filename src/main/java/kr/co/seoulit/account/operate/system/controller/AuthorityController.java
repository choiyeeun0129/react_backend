package kr.co.seoulit.account.operate.system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.operate.system.service.SystemService;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.operate.system.to.AuthorityMenuBean;

@RestController
@RequestMapping("/operate")
public class AuthorityController {

	@Autowired
	private SystemService systemService;

	@GetMapping("/authorityemp")
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(@RequestParam String deptCode) {
       
        	
            ArrayList<AuthorityEmpBean> authorityEmp = systemService.findAuthorityEmp(deptCode);
           
        return authorityEmp;
    }
	
	@GetMapping("/authoritygroupmodification")
    public void modifyAuthorityGroup(@RequestParam String authority,
    								 @RequestParam String deptCode) {
        
     
        	Gson gson = new Gson();
			ArrayList<AuthorityEmpBean> authorityEmpBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityEmpBean>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityGroup(authorityEmpBean , deptCode);
           
 
    }
	@GetMapping("/authoritygroupcode")
    public ArrayList<AuthorityEmpBean> findAuthorityGroupCode() {
      
        	
            ArrayList<AuthorityEmpBean> findAuthorityGroupCode = systemService.findAuthorityGroupCode();
   
        return findAuthorityGroupCode;
    }

	@GetMapping("/additionauthoritygroup")
    public void addAuthorityGroup(@RequestParam String addAuthority,
			 							  @RequestParam String nextGroupCode) {
       
        	
		systemService.addAuthorityGroup(addAuthority,nextGroupCode);
             
        
    }

	@GetMapping("/authoritygroupremoval")
    public void removeAuthorityGroup(@RequestParam String groupCode) {
       
        	
		systemService.removeAuthorityGroup(groupCode);

    }
	@GetMapping("/authoritygroup")
    public ArrayList<AuthorityMenuBean> findAuthorityGroup() {
     
            ArrayList<AuthorityMenuBean> authorityGroup = systemService.findAuthorityGroup();
   
        return authorityGroup;
    }

	@GetMapping("/authoritymenu")
    public ArrayList<AuthorityMenuBean> findAuthorityMenu(@RequestParam String menuName) {

            ArrayList<AuthorityMenuBean> authorityMenu = systemService.findAuthorityMenu(menuName);

        return authorityMenu;
    }

	@GetMapping("/authoritymenumodification")
    public void modifyAuthorityMenu(@RequestParam String authority,@RequestParam String deptCode) {
        
  
        	Gson gson = new Gson();
			ArrayList<AuthorityMenuBean> authorityMenuBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityMenuBean>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityMenu(authorityMenuBean , deptCode);
       
    }
}
