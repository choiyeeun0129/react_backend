package kr.co.seoulit.account.sys.base.service;

import kr.co.seoulit.account.operate.humanresource.mapper.EmployeeMapper;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;
import kr.co.seoulit.account.operate.system.mapper.AuthorityGroupMapper;
import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.sys.base.exception.DeptCodeNotFoundException;
import kr.co.seoulit.account.sys.base.exception.IdNotFoundException;
import kr.co.seoulit.account.sys.base.exception.PwMissmatchException;
import kr.co.seoulit.account.sys.base.mapper.*;
import kr.co.seoulit.account.sys.base.to.*;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.sl.ServiceLocator;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactory;
import net.sf.jasperreports.engine.query.QueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRProperties;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@Transactional
public class BaseServiceImpl implements BaseService {

	@Autowired
	private PeriodNoMapper periodNoMapper;
	@Autowired
	private MenuMapper menuDAO;
	@Autowired
	private EmployeeMapper employeeDAO;
	@Autowired
	private PeriodMapper periodDAO;
	@Autowired
	private CodeMapper codeDAO;
	@Autowired
	private DetailCodeMapper detailCodeDAO;
	@Autowired
	private AuthorityGroupMapper authorityDAO;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BoardMapper boardDAO;

	@Autowired
	private MonthMapper monthMapper;


	@Override
	public HashMap<String, String> findUrlMapper() {

		HashMap<String, String> map = new HashMap<>();

		for(MenuBean menubean: menuDAO.selectAllMenuList()) {
			map.put(menubean.getMenuCode(), menubean.getUrl());
		}

		return map;
	}

	public void modifyEarlyStatements(String periodNo) {


		periodDAO.updateEarlyStatements(periodNo);

	}


	public String findPeriodNo(String today) {

		String periodNo=null;
		periodNo = periodDAO.getPeriodNo(today);

		return periodNo;
	}


	public void registerPeriodNo(String sdate,String edate) {

		periodDAO.insertPeriodNo(sdate,edate);

	}

	//리포트 테스트중

	public ArrayList<IreportBean> findIreportData(HttpServletRequest request, HttpServletResponse response,
												  String slipNo) {

		ArrayList<IreportBean> reportDataList = null;
		HashMap<String, Object> parameters = new HashMap<>();
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("      @ DB 접근 : getReportData");
		try {
			DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/ac2");
			Connection conn = dataSource.getConnection();

			parameters.put("slip_no", slipNo);

			String path = "/resources/reportform/report11.jasper";
			String rPath = request.getServletContext().getRealPath(path); //C부터 실제경로
			System.out.println(rPath); //C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Account\resources\reportform\report11.jasper

			InputStream inputStream = new FileInputStream(rPath); //호출
			// 아이리포트의 xml을 전부 읽어옴
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			// 인자값은 (읽어들인 jrml파일, 외부에서 입력받는값_where조건절에 파라미터값으로 받는게 있다면, db연동)
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

			System.out.println("Ireport 시작1");

			/////////////reportDataList = baseCodeApplicationService.getIreportData(slipNo);
			ServletOutputStream out = response.getOutputStream(); //반환
			// 화면이동없이 pdf보기 요청만 처리했음. 띄워주는 화면은 jsp가 아니므로 마임타입 변환
			response.setContentType("application/pdf");

			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\dev\\account\\pdf\\" + slipNo + ".pdf");

			// 강제출력해서 화면에 보여지게됨
			out.flush();
		}catch (Exception e) {
			System.out.println("  @에러발생");
		}

		return null;
	}

	@Override
	public EmployeeBean findLoginData(String empCode, String userPw) throws IdNotFoundException, DeptCodeNotFoundException, PwMissmatchException {

		EmployeeBean employeeBean;

		try {
			employeeBean = employeeDAO.selectEmployee(empCode);

			if (employeeBean == null)
				throw new IdNotFoundException("존재 하지 않는 계정입니다.");
			else {
				if (!employeeBean.getUserPw().equals(userPw))
					throw new PwMissmatchException("비밀번호가 틀립니다.");

			}
		} catch (DataAccessException e) {
			throw e;
		}
		return employeeBean;
	}

	@Override
	public ArrayList<MenuBean> findUserMenuList(String deptCode) {

		System.out.println("여기까진실행");
		ArrayList<MenuBean> menuList = null;
		menuList = menuDAO.selectMenuNameList(deptCode);

		return menuList;
	}

	@Override
	public ArrayList<DetailCodeBean> findDetailCodeList(HashMap<String, Object> map) {

		ArrayList<DetailCodeBean> datailCondeList = null;
		datailCondeList = detailCodeDAO.selectDetailCodeList(map);
		System.out.println("임플ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ리먼트");
		return datailCondeList;
	}

	@Override
	public ArrayList<CodeBean> findCodeList() {

		ArrayList<CodeBean> codeList = null;
		codeList = codeDAO.selectCodeList();

		return codeList;
	}

	@Override
	public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeBean> codeList2) {

		for (CodeBean code : codeList) {
			switch (code.getStatus()) {
				case "insert":
					codeDAO.insertCode(code);
					break;
				case "update":
					codeDAO.updateCode(code);
					break;
				case "normal":
					break;
				case "delete":
					codeDAO.deleteCode(code.getDivisionCodeNo());
			}
		}
		ArrayList<DetailCodeBean> DetailcodeList = codeList2;
		for (DetailCodeBean codeDetailBean : DetailcodeList) {
			switch (codeDetailBean.getStatus()) {
				case "insert":
					detailCodeDAO.insertDetailCode(codeDetailBean);
					break;
				case "update":
					detailCodeDAO.updateDetailCode(codeDetailBean);
					break;
				case "delete":
					detailCodeDAO.deleteDetailCode(codeDetailBean.getDetailCode());
			}
		}
	}

	public void findIreportTotalData(HttpServletRequest request, HttpServletResponse response) {


		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		System.out.println("      @ DB 접근 : getReportData");
		try {

			Connection conn = dataSource.getConnection();

			String path = "http://localhost/ireport/totalTrialBalance.jrxml";

			URL url = new URL(path);
			URLConnection connection = url.openConnection();

			// 아이리포트의 xml을 전부 읽어옴
			JasperReport jasperReport = JasperCompileManager.compileReport(connection.getInputStream());
			// 리포트 포멧(*.jrxml)  ==> 리포트로 변환(*.jasper)
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn);
			//JasperFillManager는 jasperPrint 객체 반환
			// (리포터, 파라미터, connection)




			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			// html문서의 인코딩 방식을 지정
			System.out.println("Ireport 시작2 :" +out);
			System.out.println("Ireport 시작3 :" +jasperPrint);

			JasperExportManager.exportReportToPdfStream(jasperPrint, out);

			out.flush();   // 버퍼 및 OutputStream 정리(비우기)

			System.out.println("      @ DB 커밋");
		} catch (Exception e) {

			System.out.println(e+ "      @ DB 롤백");
		}

	}

	@Override
	public void findIreportData3(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		HashMap<String, Object> parameters = new HashMap<>();
		System.out.println("      @ DB 접근 : getReportData");
		try {
			DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/ac2");
			Connection conn = dataSource.getConnection();

			String path = "/resources/ireport/financStatus.jrxml";
			String rPath = request.getServletContext().getRealPath(path);
			System.out.println(rPath);
			// 아이리포트의 xml을 전부 읽어옴
			System.out.println(request.getParameter("from"));
			System.out.println(request.getParameter("to"));

			parameters.put("param_1", request.getParameter("from"));
			parameters.put("param_2", request.getParameter("to"));
			//parameters.put("param_3", OracleTypes.NUMBER);
			//parameters.put("param_4", OracleTypes.VARCHAR);
			parameters.put("ORACLE_REF_CURSOR", OracleTypes.CURSOR);

			JRProperties.setProperty(QueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX+"plsql"
					,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
			JRPropertiesUtil jrPropertiesUtil = JRPropertiesUtil.getInstance(jasperReportsContext);
			jrPropertiesUtil.setProperty("net.sf.jasperreports.query.executer.factory.plsql", "net.sf.jasperreports.engine.query.PlSqlQueryExecuterFactory");

			JasperReport jasperReport = JasperCompileManager.compileReport(rPath);


			jasperReport.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "<query language>", "<value>");

			jasperReport.setProperty( "net.sf.jasperreports.query.executer.factory.plsql"
					,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");





			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conn);

			System.out.println("Ireport 시작3");

			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			out.flush();

		} catch (Exception e) {
			System.out.println("      @ 에러발생");
		}
	}

	@Override
	public void findIreportData4(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		HashMap<String, Object> parameters = new HashMap<>();
		System.out.println("      @ DB 접근 : getReportData");
		try {
			DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/ac2");
			Connection conn = dataSource.getConnection();

			String path = "/resources/ireport/imTotalTrialBalance.jrxml";
			String rPath = request.getServletContext().getRealPath(path);
			System.out.println(rPath);
			// 아이리포트의 xml을 전부 읽어옴
			System.out.println(request.getParameter("from"));
			System.out.println(request.getParameter("to"));

			parameters.put("param_1", request.getParameter("from"));
			parameters.put("param_2", request.getParameter("to"));
			//parameters.put("param_3", OracleTypes.NUMBER);
			//parameters.put("param_4", OracleTypes.VARCHAR);
			parameters.put("ORACLE_REF_CURSOR", OracleTypes.CURSOR);

			JRProperties.setProperty(QueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX+"plsql"
					,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
			JRPropertiesUtil jrPropertiesUtil = JRPropertiesUtil.getInstance(jasperReportsContext);
			jrPropertiesUtil.setProperty("net.sf.jasperreports.query.executer.factory.plsql", "net.sf.jasperreports.engine.query.PlSqlQueryExecuterFactory");

			JasperReport jasperReport = JasperCompileManager.compileReport(rPath);


			jasperReport.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "<query language>", "<value>");

			jasperReport.setProperty( "net.sf.jasperreports.query.executer.factory.plsql"
					,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");





			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conn);

			System.out.println("Ireport 시작4");
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			out.flush();

		} catch (Exception e) {
			System.out.println("      @ 에러발생");
		}
	}

	@Override
	public ArrayList<AuthorityEmpBean> findAuthority(String empCode) {

		ArrayList<AuthorityEmpBean> authorityEmp = null;
		authorityEmp = authorityDAO.selectAuthorityEmp(empCode);

		return authorityEmp;
	}

	@Override
	public void findIreportDataincome(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("      @ DB 접근 : getReportDataincome");
		try {
			Connection conn = dataSource.getConnection();

			String path = "https://account71.s3.ap-northeast-2.amazonaws.com/ireport/incomeStatementPdf.jrxml";

			URL url = new URL(path);
			URLConnection connection = url.openConnection();

			// 아이리포트의 xml을 전부 읽어옴
			JasperReport jasperReport = JasperCompileManager.compileReport(connection.getInputStream());
			// 리포트 포멧(*.jrxml)  ==> 리포트로 변환(*.jasper)
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn);
			//JasperFillManager는 jasperPrint 객체 반환
			// (리포터, 파라미터, connection)

			System.out.println("Ireportincome 시작");

			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline");
			// html문서의 인코딩 방식을 지정
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			out.flush();   // 버퍼 및 OutputStream 정리(비우기)

		} catch (Exception e) {
			System.out.println("      @ 에러발생");
		}
	}

	@Override
	public void findIreportDatafinance(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("      @ DB 접근 : getReportDataincome");
		try {

			Connection conn = dataSource.getConnection();

			String path = "http://localhost/ireport/financialPositionPdf.jrxml";

			URL url = new URL(path);
			URLConnection connection = url.openConnection();

			// 아이리포트의 xml을 전부 읽어옴
			JasperReport jasperReport = JasperCompileManager.compileReport(connection.getInputStream());
			// 리포트 포멧(*.jrxml)  ==> 리포트로 변환(*.jasper)
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn);
			//JasperFillManager는 jasperPrint 객체 반환
			// (리포터, 파라미터, connection)

			System.out.println("Ireportincome 시작");


			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			// html문서의 인코딩 방식을 지정
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			out.flush();   // 버퍼 및 OutputStream 정리(비우기)

			System.out.println("      @ DB 커밋");
		} catch (Exception e) {

			System.out.println("      @ DB 롤백");
		}
	}

	@Override
	public ArrayList<BoardBean> findParentboardList() {
		System.out.println("서비스 임플 호출@@@@@@@@@@");
		ArrayList<BoardBean> accountList = null;
		accountList = boardDAO.selectParentBoardList();
		return accountList;
	}

	@Override
	public ArrayList<BoardBean> findDetailboardList(String id) {
		ArrayList<BoardBean> accountList = null;
		accountList = boardDAO.selectDetailBoardList(id);
		return accountList;
	}
	@Override
	public ArrayList<BoardBean> findDetailboardList1(String id) {
		ArrayList<BoardBean> accountList = null;
		accountList = boardDAO.selectDetailBoardList1(id);
		return accountList;
	}

	@Override
	@Transactional
	public void deleteBoard(String id) {
		boardDAO.deleteBoardList(id);
		System.out.println("서비스다아ㅏ아아");

	}

	@Override
	public void updateLookup(String id) {
		boardDAO.updateLookup(id);

	}

	@Override
	public void insertBoard(BoardBean boardbean) throws Exception {

		boardDAO.insertBoard(boardbean);



	}

	@Override
	public void boardModify(BoardBean boardbean) {
		boardDAO.boardModify(boardbean);

	}

	@Override
	public ArrayList<BoardBean> showreply(String id) {
		// TODO Auto-generated method stub
		ArrayList<BoardBean> replyList = null;
		replyList = boardDAO.selectreplyList(id);
		System.out.println("댓글 서비스@@@@@@@@@@@@@@@@@");
		return replyList;
	}

	@Override
	public void insertReBoard(BoardBean boardbean) {


		boardDAO.insertReBoard(boardbean);

	}

	@Override
	public void deletereBoard(String rid) {
		// TODO Auto-generated method stub

		boardDAO.deleteReBoard(rid);

	}

	@Override
	public void boardReModify(BoardBean boardbean) {
		// TODO Auto-generated method stub
		boardDAO.modifyReBoard(boardbean);
	}

	@Override
	public void fileInsert(BoardBean boardBean) throws Exception{
		boardDAO.fileInsert(boardBean);
	}

	@Override
	public List<PeriodNoBean> findPeriodNo(){
		return periodNoMapper.findPeriodNo();
	}

	@Override
	public List<MonthBean> findMonth() {return monthMapper.findMonth();}

	@Override
	public PeriodNoBean findTPeriodNo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return periodNoMapper.selectPeriodNo(map);
	}
	
}

