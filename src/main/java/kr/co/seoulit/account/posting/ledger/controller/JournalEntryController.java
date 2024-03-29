package kr.co.seoulit.account.posting.ledger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.service.LedgerServiceImpl;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/posting")
public class JournalEntryController {
	
    @Autowired
    private LedgerService ledgerService;

    @RequestMapping("/findRangedJournalList2")
	public ArrayList<JournalBean> findRangedJournalList(@RequestParam String fromDate,
											  @RequestParam String toDate) {

            ArrayList<JournalBean> journalList = ledgerService.findRangedJournalList(fromDate, toDate);
  
            return journalList;
    }
    
    @RequestMapping("/findJournalDetailList2")
    public ArrayList<JournalDetailBean> findJournalDetailList(@RequestParam String journalNo) {

            ArrayList<JournalDetailBean> journalDetailList = ledgerService.findJournalDetailList(journalNo);

            return journalDetailList;
    }
}
