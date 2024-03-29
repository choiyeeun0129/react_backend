package kr.co.seoulit.account.sys.base.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.account.sys.base.to.BoardFIleBean;
import org.apache.catalina.connector.Response;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.to.BoardBean;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/base")
public class BoardController {
	@Autowired
	private BaseService baseService;

	@GetMapping("/boardlist")
	public ArrayList<BoardBean> findParentboardList() {
		System.out.println("컨트롤러 호출@@@@@@@@@@@@@@");
		return baseService.findParentboardList();
	}

	@GetMapping("/boardDetailList")
	public ArrayList<BoardBean> findDetailBoardList(@RequestParam String id) throws Exception {
		baseService.updateLookup(id);

		return baseService.findDetailboardList(id);
	}
	@GetMapping("/boardDetailList1")
	public ArrayList<BoardBean> findDetailBoardList1(@RequestParam String id) throws Exception {
		baseService.updateLookup(id);

		return baseService.findDetailboardList1(id);
	}
	@GetMapping("/boardreplyList")
	public ArrayList<BoardBean> boardRelpyList(@RequestParam String id) {

		ArrayList<BoardBean> replybean = baseService.showreply(id);
		System.out.println(replybean+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return   replybean;
	}
	@GetMapping("/boardDelete")
	public void deleteBoard(@RequestParam String id) {
		System.out.println("컨트롤러는왓다2222222222222222222222222222");
		baseService.deleteBoard(id);
	}

	@PostMapping("/boardreg")
	public ModelAndView insertData(
			@RequestParam("title") String title
			,@RequestParam("writtenBy") String writtenBy
			,@RequestParam("contents")String contents,
			@RequestPart MultipartFile files,
			MultipartHttpServletRequest multipartHttpServletRequest)throws Exception {


		ModelAndView mav=new ModelAndView("redirect:/base/board");
		BoardBean boardbean = new BoardBean();
		BoardFIleBean boardFIleBean = new BoardFIleBean();
		boardbean.setTitle(title);
		boardbean.setWrittenBy(writtenBy);
		boardbean.setContents(contents);
		System.out.println("작성자:"+writtenBy+"@@@제목:"+title+"@@@내용 :"+contents+"@@@@@@@@@@@@@");
		if(files.isEmpty()){
			baseService.insertBoard(boardbean);
		}else{
			String filename = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(filename).toLowerCase();
			File destinationFile;
			String destnationFileName;
			String fileUrl = "C:\\project\\real_project\\src\\main\\webapp\\assets\\uploadFiles\\";

			do{
				destnationFileName = RandomStringUtils.randomAlphanumeric(32)+"."+fileNameExtension;
				destinationFile = new File(fileUrl + destnationFileName);
				System.out.println(boardbean.getId());
				System.out.println(boardbean.getBoardId());
				System.out.println(destnationFileName);
				System.out.println(filename);
				System.out.println(fileUrl);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);


			boardbean.setFileId();
			boardbean.setBoardId();
			boardbean.setFileName(destnationFileName);
			boardbean.setFileOriName(filename);
			boardbean.setFileUrl(fileUrl);

			baseService.insertBoard(boardbean);
			baseService.fileInsert(boardbean);
//			baseService.fileInsert(boardFIleBean);
		}
		return mav;
	}

	@PostMapping("/boardModify")
	public ModelAndView boardModify(
			@RequestParam("id")String id
			,@RequestParam("title") String title
			,@RequestParam("contents")String contents) {

		ModelAndView mav=new ModelAndView("redirect:/base/board");
		BoardBean boardbean = new BoardBean();
		boardbean.setTitle(title);
		boardbean.setId(id);
		boardbean.setContents(contents);
		System.out.println("@@글번호"+id+"@@@제목:"+title+"@@@내용 :"+contents+"@@@@@@@@@@@@@");
		baseService.boardModify(boardbean);
		return mav;
	}

	@PostMapping("/board_re_insert")
	public Map<String, Object> insertreply(
			@RequestParam("reply") String reply
			,@RequestParam("id") String id
			,@RequestParam("writer")String writer) {
		HashMap<String, Object> map = new HashMap<>();
		BoardBean boardbean = new BoardBean();
		boardbean.setBid(id);
		boardbean.setReContents(reply);
		boardbean.setReWritter(writer);
		map.put("Msg","성공ㅎㅎ");
//		   SYSTEM.OUT.PRINTLN("작성자:"+WRITTENBY+"@@@제목:"+TITLE+"@@@내용 :"+CONTENTS+"@@@@@@@@@@@@@");
		baseService.insertReBoard(boardbean);
		return map;
	}

	@GetMapping("replyDelete")
	public void redeleteBoard(@RequestParam String rid) {
		baseService.deletereBoard(rid);

	}
	@PostMapping("/board_re_modify")
	public void boardModify(
			@RequestParam("rid")String id
			,@RequestParam("recontents")String contents) {

		BoardBean boardbean = new BoardBean();
		boardbean.setRid(id);
		boardbean.setReContents(contents);
		System.out.println(id+contents+"@@@@@@@@@");
		baseService.boardReModify(boardbean);

	}

	@ResponseBody
	@GetMapping("/downloadFile")
	public HttpServletResponse fileDown(
//			@RequestParam String fileOriName,
			 @RequestParam String fileName
			, HttpServletResponse response) throws Exception {

		System.out.println("@@@@@@@@@@@"+fileName);
//		System.out.println("@@@@@@@@@@@"+fileOriName);
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:/project/real_project/src/main/webapp/assets/uploadFiles/" + fileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();

		return response;
	}


}
