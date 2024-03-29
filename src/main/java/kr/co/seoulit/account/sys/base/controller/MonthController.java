package kr.co.seoulit.account.sys.base.controller;

import kr.co.seoulit.account.sys.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class MonthController {

    @Autowired
    private BaseService baseService;

    @GetMapping("monthData")
    public HashMap<String , Object> findMonth (){
        HashMap<String, Object> map =new HashMap<>();
        map.put("monthList", baseService.findMonth());
        return map;
    }
}
