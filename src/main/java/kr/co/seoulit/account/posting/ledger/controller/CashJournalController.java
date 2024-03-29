package kr.co.seoulit.account.posting.ledger.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.to.CashJournalBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class CashJournalController {

    @Autowired
    private LedgerService ledgerService;
    
    ModelAndView mav = null;
    ModelMap map = new ModelMap();

    // 현금출납장 조회
    @GetMapping("/cashjournal")
    public HashMap<String, Object> handleRequestInternal(@RequestParam("fromDate") String fromDate,
                                                         @RequestParam("toDate") String toDate
    												         ) {
        HashMap<String ,Object> map = new HashMap<>();
        ArrayList<CashJournalBean> cashJournalList = ledgerService.findCashJournal(fromDate, toDate);
        map.put("cashJournalList",cashJournalList);
        return map;
    }
}
