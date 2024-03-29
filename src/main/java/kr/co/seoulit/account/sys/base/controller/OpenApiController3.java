package kr.co.seoulit.account.sys.base.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.sf.json.JSONObject;

public class OpenApiController3 extends AbstractController {

   @Override
   public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>();
        BufferedReader br = null;
        PrintWriter out = null;
        String result=null;

            // gson 라이브러리
            Gson gson = new GsonBuilder().serializeNulls().create(); // 속성값이 null 인 속성도 json 변환
              try{            
                    out = response.getWriter();
                    String year = request.getParameter("year");
         			String month = request.getParameter("month");
         			
         			System.out.println("요청연도 : "+year);
         			System.out.println("요청월 : "+month);
         			
                     String urlstr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?solYear="+year+"&solMonth="+month+"&ServiceKey="
                           +"Pdni0WEWWEuBXB7jeyiQ4SR13hAIYmU6XUrWJuu7VejgoJErAhJB241HQ2kHYlDCs2%2F1iKUDKGVZx64QYMmvdw%3D%3D&_type=json";
                     URL url = new URL(urlstr);
                     HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
                     urlconnection.setRequestMethod("GET");
                     br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
                     result ="";
                     String line;
                     while((line=br.readLine()) != null) {
                         result = result+line;
                     }
                     
                     map.put("OpenAPI", result);
                     map.put("error_code", 0);   
                    map.put("error_msg", "성공");
System.out.println("@"+result);
                     out.println(gson.toJson(map));
      }catch (UnsupportedEncodingException e) {
   map.put("error-code", -1);   
   map.put("error-msg", "내부서버오류");
         e.printStackTrace();
      }catch(IOException e) {
      map.put("error-code", -1);   
      map.put("error-msg", "내부서버오류");   
      e.printStackTrace();
      }catch(Exception e) {
         map.put("error-code", -1);   
         map.put("error-msg", "내부서버오류");   
         e.printStackTrace();

      }finally { 
         map.put("error-code", 0);   
         map.put("error-msg", "성공");
            
      }
      
      return null;
   }

}