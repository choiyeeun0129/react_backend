package kr.co.seoulit.account.sys.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.AbstractController;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.sys.base.exception.IdNotFoundException;
import kr.co.seoulit.account.sys.base.exception.PwMissmatchException;
import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.service.BaseServiceImpl;
import kr.co.seoulit.account.sys.base.to.MenuBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberLoginController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("/login")
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

        String viewName = null;
        String periodNo=null;
        HashMap<String, Object> model = new HashMap<>();
        try {
            System.out.println("      @ BaseService의 객체 주소를 가져옴");
            HttpSession session = request.getSession();
            System.out.println("      @ session 생성");
            String empCode = request.getParameter("empCode");
            System.out.println("      @ 로그인 폼에서 파라메터로 받아온 empCode: " + empCode);
            String userPw = request.getParameter("userPw");
            System.out.println("      @ 로그인 폼에서 파라메터로 받아온 userPw: " + userPw);
            String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("      @ 로그인 폼에서 파라메터로 받아온 today: " + today);
//         String deptCode = request.getParameter("deptCode").toUpperCase();
//         System.out.println("      @ 로그인 폼에서 파라메터로 받아온 deptCode: "+deptCode);

            EmployeeBean employeeBean = baseService.findLoginData(empCode, userPw);
            System.out.println(employeeBean.getEmpCode());
            System.out.println("      @ BaseService에서 접근 권한을 얻어옴");
            periodNo=baseService.findPeriodNo(today);     //회계기수를 반환함. 오늘날짜가 period기수정보 테이블에 없으면 null
            System.out.println("today: "+today);
            System.out.println("      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: " + periodNo);

            	System.out.println("여기");
            	System.out.println(today);
            if(periodNo==null) {
               String[] str=today.split("-");   // str={"2020","02","05"}
               System.out.println(str);
               String sdate=str[0]+"-"+"01-01";
               System.out.println(sdate);
               String edate=str[0]+"-"+"12-31";
               System.out.println(edate);
               baseService.registerPeriodNo(sdate,edate);	// sdate=2020-01-01 sdate=2020-12-31
               periodNo=baseService.findPeriodNo(today);	
               //baseService.setEarlyStatements(periodNo); 사용안함
            }
            
            session.setAttribute("periodNo", periodNo);
            
            if (employeeBean != null) {
                System.out.println("      @ 로그인 : " + employeeBean.getEmpName());
                session.setAttribute("empCode", employeeBean.getEmpCode());
                session.setAttribute("empName", employeeBean.getEmpName());
                session.setAttribute("deptCode", employeeBean.getDeptCode());
                session.setAttribute("deptName", employeeBean.getDeptName());
               
//            session.setAttribute("authority", ((ArrayList<MenuBean>)employeeBean.get("menuList")).get(0).getPositionCode());
                session.setAttribute("positionName", employeeBean.getPositionName());
//            session.setAttribute("masterMenuList", employeeBean.get("masterMenuList"));
                viewName = "redirect:hello";
            }
            
            //계정별 메뉴 권한
			/*
			 * ArrayList<AuthorityEmpBean> authorityEmp = baseService.getAuthority(empCode); 
			 * ArrayList<String> list = new ArrayList<String>(); 
			 * for(AuthorityEmpBean obj: authorityEmp){
			 * list.add(obj.getIsAuthority()); } session.setAttribute("list", list);
			 */
            
            // 부서별 메뉴 권한
            System.out.println("부서" + employeeBean.getDeptCode());
            ArrayList<MenuBean> menuList = baseService.findUserMenuList(employeeBean.getDeptCode());
            ArrayList<String> list = new ArrayList<String>();
            for(MenuBean menu : menuList) {
            	list.add(menu.getMenuName());
            }
            String deptCode = employeeBean.getDeptCode();
            session.setAttribute("menuList", list);
            System.out.println("      @ 뷰네임: " + viewName);
		     model.put("deptCode",deptCode); 
        } catch (IdNotFoundException e) {
            model.put("errorCode", -1);
            model.put("errorMsg", /*e.getMessage()*/ "존재하지 않는 계정입니다");
            viewName = "loginform";

        } catch (PwMissmatchException e) {
            model.put("errorCode", -3);
            model.put("errorMsg", /*e.getMessage()*/ "비밀번호가 맞지 않습니다");
            viewName = "loginform";

        } catch (Exception e) {
            e.printStackTrace();
            model.put("errorCode", -4);
            model.put("errorMsg", /*e.getMessage()*/ "예기치 못한 오류 발생");
            viewName = "loginform";
        }

        ModelAndView modelAndView = new ModelAndView(viewName, model); //model엔 null 담음
        return modelAndView;
    }

}