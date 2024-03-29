package kr.co.seoulit.account.sys.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.operate.system.to.PeriodBean;
import kr.co.seoulit.account.sys.base.to.*;
import kr.co.seoulit.account.sys.base.to.DetailCodeBean;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.sys.base.exception.DeptCodeNotFoundException;
import kr.co.seoulit.account.sys.base.exception.IdNotFoundException;
import kr.co.seoulit.account.sys.base.exception.PwMissmatchException;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;

public interface BaseService {

	public EmployeeBean findLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException;

	public ArrayList<MenuBean> findUserMenuList(String deptCode);

	public ArrayList<DetailCodeBean> findDetailCodeList(HashMap<String, Object> map);

	public ArrayList<CodeBean> findCodeList();

	public ArrayList<IreportBean> findIreportData(HttpServletRequest request, HttpServletResponse response, String slipNo);

	public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeBean> codeList2);

	public String findPeriodNo(String today);

	public void registerPeriodNo(String sdate, String edate);

	public void modifyEarlyStatements(String periodNo);

	public ArrayList<AuthorityEmpBean> findAuthority(String empCode);

	public void findIreportData3(HttpServletRequest request, HttpServletResponse response);

	public void findIreportData4(HttpServletRequest request, HttpServletResponse response);

	public void findIreportDataincome(HttpServletRequest request, HttpServletResponse response);

	public void findIreportDatafinance(HttpServletRequest request, HttpServletResponse response);

	public HashMap<String, String> findUrlMapper();

	public void findIreportTotalData(HttpServletRequest request, HttpServletResponse response);

	public ArrayList<BoardBean> findParentboardList();

	public ArrayList<BoardBean> findDetailboardList(String id);

	public ArrayList<BoardBean> findDetailboardList1(String id);

	public void deleteBoard(String id);

	public void updateLookup(String id);

	public void insertBoard(BoardBean boardbean) throws Exception;

	public void boardModify(BoardBean boardbean);

	public ArrayList<BoardBean> showreply(String id);

	public void insertReBoard(BoardBean boardbean);

	public void deletereBoard(String rid);

	public void boardReModify(BoardBean boardbean);

	public void fileInsert(BoardBean boardBean) throws Exception;
//	public void fileInsert(BoardFIleBean boardFIleBean) throws Exception;

	public List<PeriodNoBean> findPeriodNo();
	
	public PeriodNoBean findTPeriodNo(HashMap<String, Object> map);

    public List<MonthBean> findMonth();
}
