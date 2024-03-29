package kr.co.seoulit.account.sys.common.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
   @RequestMapping("/{viewName}")
   public String view(@PathVariable String viewName) {
      System.out.println(viewName + ": start");
      System.out.println("여기는 viewName 찍히는 곳!!" + viewName);
      return viewName;
   }

   @RequestMapping("/{pack}/{viewName}")
   public String packView(@PathVariable String pack, @PathVariable String viewName) {
      System.out.println("ViewController.packView");
      System.out.println(pack + "/" + viewName + ": start");
      System.out.println("여기는 viewName 찍히는 곳!!!" + pack + viewName);
      return pack + "/" + viewName;
   }

   @RequestMapping(value="/")
   public String index() {
      return "redirect:/hello";
   }

}
