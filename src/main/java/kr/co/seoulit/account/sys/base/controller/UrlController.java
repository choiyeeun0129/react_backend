package kr.co.seoulit.account.sys.base.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.seoulit.account.sys.base.service.BaseService;

@Controller
public class UrlController{

   private HashMap<String, String> urlList;
   @Autowired
   private BaseService baseService;

   @RequestMapping("/url")
   public void Urlcontrol(HttpServletRequest request, HttpServletResponse response) {
      
      if(urlList==null) {
         urlList = new HashMap<>();
         
         response.setContentType("application/json; charset=UTF-8");
         response.setCharacterEncoding("utf-8");
         
         try {
            urlList = baseService.findUrlMapper();
         } catch (Exception error) {
            error.printStackTrace();
         }
      }
      
      String menuCode = request.getParameter("menuCode");
      String url = (request.getContextPath() + urlList.get(menuCode)).toLowerCase();
      
      try {
         response.sendRedirect(url);
      } catch (Exception error) {
         error.printStackTrace();
      }
   }
}