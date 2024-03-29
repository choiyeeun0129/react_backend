package kr.co.seoulit.account.sys.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.util.FileUploadUtil;
import kr.co.seoulit.account.operate.humanresource.service.HumanResourceService;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;
import net.sf.json.JSONObject;

public class ImgFileController{
	protected final Log logger = LogFactory.getLog(this.getClass());
	private HumanResourceService humanResourceService;

	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

	String newFileName = null;

	public ModelAndView modifyImage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("modifyImage 실행!00");
		JSONObject json = new JSONObject();
		String contentType = request.getContentType();

		if (logger.isDebugEnabled()) {
			logger.debug(" ImgFileController : uploadImage 시작 ");
		}
		System.out.println(contentType);
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {

			try {
				newFileName = printPartInfo(request, contentType);
			} catch (IOException | FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {

			humanResourceService.modifyImage(newFileName); // db 연동
			json.put("newFileName", newFileName);
			json.put("errorCode", 1);
			json.put("errorMsg", "데이터 저장 성공");

		} catch (DataAccessException e) {
			logger.fatal(e.getMessage());
			json.put("errorCode", -1);
			json.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} finally {
			try (PrintWriter out = response.getWriter()) {

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(" AccountController : getAccount 종료 ");
		}
		/*
		 * ImgFileUploader img = new ImgFileUploader(); String
		 * name=img.uploadImage(request,response);
		 */
		/* mav = new ModelAndView(name,null); */
		return null;

	}

	public String printPartInfo(HttpServletRequest request, String contentType)
			throws IOException, FileUploadException {

		if (logger.isDebugEnabled()) {
			logger.debug(" ImgFileController : printPartInfo 시작 ");
		}
		Collection<Part> parts = null;

		try {
			parts = request.getParts();
			System.out.println("parts");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("printPartInfo");
		for (Part part : parts) {

			contentType = part.getContentType();

			if (contentType != null) {

				System.out.println("contentType:" + contentType + "<br/>");

				long size = part.getSize();
				System.out.println("size:" + size + "<br/>");
				String filename = part.getSubmittedFileName();
				// 자르기
				String extension = filename.substring(filename.lastIndexOf("."));
				String subName = filename.substring(0, filename.lastIndexOf("."));

				newFileName = subName + "_" + Long.toString(System.currentTimeMillis()) + extension;
				System.out.println("newFileName22222 : " + newFileName);

				if (size > 0) {
					String path1 = "C:\\Users\\user\\eclipse-workspace\\Account71\\src\\main\\webapp\\assets\\img\\emp";
					String path2 = request.getServletContext().getRealPath("/") + "\\upload\\";
					FileUploadUtil.doFileUpload(part, path1, newFileName);
					FileUploadUtil.doFileUpload(part, path2, newFileName);

				}

			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(" ImgFileController : printPartInfo 종료 ");
		}
		return newFileName;

	}
	
	  public ModelAndView findImage(HttpServletRequest request, HttpServletResponse response) { 
		  System.out.println("findImage 실행!00"); 
		  
		  if(logger.isDebugEnabled()) {
	  logger.debug(" ImgFileController : findImage 시작 "); 
	  }
	  
	  JSONObject json = new JSONObject(); 
	  try { 
		  String EMP_CODE = request.getParameter("EMP_CODE"); 
		  EmployeeBean admin = humanResourceService.findImage(EMP_CODE); //db 연동
	  json.put("employeeBean",admin); 
	  json.put("errorCode", 1);
	  json.put("errorMsg", "데이터 저장 성공");
	  
	  }catch (DataAccessException e) { 
	  logger.fatal(e.getMessage());
	  json.put("errorCode", -1); 
	  json.put("errorMsg", e.getMessage());
	  e.printStackTrace(); 
	  }finally { 
	  try 
	  (PrintWriter out = response.getWriter()){
		  out.print(json);
	  
	  } catch (IOException e) { e.printStackTrace(); } } 
	  if(logger.isDebugEnabled()) {
	  logger.debug(" AccountController : findImage 종료 "); } 
	  return null; }
	 
}
