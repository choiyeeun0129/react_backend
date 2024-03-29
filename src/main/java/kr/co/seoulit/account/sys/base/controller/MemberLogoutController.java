package kr.co.seoulit.account.sys.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MemberLogoutController {
	
	@RequestMapping("/logout")
    public ModelAndView logoutController(HttpServletRequest request, HttpServletResponse response) {
        
        ModelAndView modelAndView = new ModelAndView("redirect:loginform"); //veiwName값 들어가 있음
        HttpSession session = request.getSession();
        session.invalidate(); // 세션을 없애고 세션에 속해있는 값들을 모두 없앤다.
        System.out.println("		@ :session 종료: 사용자가 로그 아웃 하였습니다");
        
        return modelAndView;
    }

}
