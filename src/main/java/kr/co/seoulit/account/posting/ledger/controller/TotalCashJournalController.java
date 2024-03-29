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
import org.springframework.web.servlet.mvc.AbstractController;

import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.service.LedgerServiceImpl;
import kr.co.seoulit.account.posting.ledger.to.CashJournalBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/posting")
public class TotalCashJournalController {

    @Autowired
    private LedgerService ledgerService;

    @RequestMapping("/ledgerbyaccount")
    public ArrayList<CashJournalBean> handleRequestInternal(@RequestParam String year,
    												        @RequestParam String account) {

            ArrayList<CashJournalBean> cashJournalList = ledgerService.findTotalCashJournal(year, account);
   
            return cashJournalList;
    }

}
