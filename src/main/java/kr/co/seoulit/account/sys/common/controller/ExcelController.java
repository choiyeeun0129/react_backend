package kr.co.seoulit.account.sys.common.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;
import kr.co.seoulit.account.sys.base.service.BaseService;

import net.sf.json.JSONObject;
@RestController
@RequestMapping("/base")
public class ExcelController {

	@PostMapping("/excel")
    public void getExcel(@RequestParam String sendData) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@진입");


        //.xls 확장자 지원
        HSSFWorkbook wb = null;
        HSSFSheet sheet = null;
        Row row = null;
        Cell cell = null;

        //.xlsx 확장자 지원
        XSSFWorkbook xssfWb = null;
        XSSFSheet xssfSheet = null;
        XSSFRow xssfRow = null;
        XSSFCell xssfCell = null;

        try {
            System.out.println("츄라이");

            String parameter = sendData.replace("\\", "").replace("[", "").replace("]", "").replace("}\"", "}").replace("\"{", "{");
            System.out.println("합잔데이터"+parameter);

            JSONObject jsonObject = JSONObject.fromObject(parameter);

            System.out.println("jsonObject"+jsonObject);

            int rowNo = 0; // 행 갯수
            // 워크북 생성
            xssfWb = new XSSFWorkbook();
            xssfSheet = xssfWb.createSheet("합계잔액시산표"); // 워크시트 이름

            //헤더용 폰트 스타일
            XSSFFont font = xssfWb.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL); //폰트스타일
            font.setFontHeightInPoints((short)14); //폰트크기
            font.setBold(true); //Bold 유무

            //테이블 타이틀 스타일
            CellStyle cellStyle_Title = xssfWb.createCellStyle();
            cellStyle_Title.setBorderTop(BorderStyle.THIN); //테두리 위쪽
            cellStyle_Title.setBorderBottom(BorderStyle.THIN); //테두리 아래쪽
            cellStyle_Title.setBorderLeft(BorderStyle.THIN); //테두리 왼쪽
            cellStyle_Title.setBorderRight(BorderStyle.THIN); //테두리 오른쪽
            cellStyle_Title.setAlignment(HorizontalAlignment.CENTER);

            cellStyle_Title.setFillForegroundColor(HSSFColor.AQUA.index);
            cellStyle_Title.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            xssfSheet.setColumnWidth(0, (xssfSheet.getColumnWidth(5))+(short)1000);
            xssfSheet.setColumnWidth(1, (xssfSheet.getColumnWidth(5))+(short)1000);
            xssfSheet.setColumnWidth(2, (xssfSheet.getColumnWidth(5))+(short)5300);
            xssfSheet.setColumnWidth(3, (xssfSheet.getColumnWidth(3))+(short)1000); // 3번째 컬럼 넓이 조절
            xssfSheet.setColumnWidth(4, (xssfSheet.getColumnWidth(4))+(short)1000); // 4번째 컬럼 넓이 조절


            cellStyle_Title.setFont(font); // cellStyle에 font를 적용
            cellStyle_Title.setAlignment(HorizontalAlignment.CENTER); // 정렬
            System.out.println("병합쪽");
            //셀병합
            xssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4)); //첫행, 마지막행, 첫열, 마지막열( 0번째 행의 0~8번째 컬럼을 병합한다)
            //타이틀 생성
            xssfRow = xssfSheet.createRow(rowNo++); //행 객체 추가
            xssfCell = xssfRow.createCell((short) 0); // 추가한 행에 셀 객체 추가
            xssfCell.setCellStyle(cellStyle_Title); // 셀에 스타일 지정
            xssfCell.setCellValue("합계잔액시산표"); // 데이터 입력

            CellStyle cellStyle_Body = xssfWb.createCellStyle();
            //cellStyle_Body.setAlignment(HorizontalAlignment.CENTER);
            cellStyle_Body.setAlignment(HorizontalAlignment.LEFT);

            //헤더 생성
            xssfRow = xssfSheet.createRow(rowNo++); //헤더 01
            xssfCell = xssfRow.createCell((short) 0);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("잔액");
            xssfCell = xssfRow.createCell((short) 1);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("합계");
            xssfCell = xssfRow.createCell((short) 2);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("과목");
            xssfCell = xssfRow.createCell((short) 3);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("합계");
            xssfCell = xssfRow.createCell((short) 4);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("잔액");

            System.out.println("반복문 전");

            int cnt=1;
            while(true) {
                if(cnt>1) {
                    System.out.println("반복문cnt진입"+parameter.indexOf(",{"));
                    if(parameter.indexOf(",{")!=-1) {
                        System.out.println("문자열 자르기 진입");
                        parameter = parameter.substring(parameter.indexOf(",{")+1,parameter.lastIndexOf("}")+1);
                        System.out.println("자르기 결과"+parameter);
                        jsonObject = JSONObject.fromObject(parameter);
                    }else{
                        System.out.println("break진입");
                        break;
                    }
                }
                if(cnt>1) {System.out.println("반복한다"+cnt);}
                xssfRow = xssfSheet.createRow(rowNo++); //헤더 01
                xssfCell = xssfRow.createCell((short) 0);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("debitsSumBalance"));
                xssfCell = xssfRow.createCell((short) 1);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("debitsSum"));
                xssfCell = xssfRow.createCell((short) 2);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("accountName"));
                xssfCell = xssfRow.createCell((short) 3);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("creditsSum"));
                xssfCell = xssfRow.createCell((short) 4);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("creditsSumBalance"));


                //테이블 스타일 설정
                CellStyle cellStyle_Table_Center = xssfWb.createCellStyle();
                cellStyle_Table_Center.setBorderTop(BorderStyle.THIN); //테두리 위쪽
                cellStyle_Table_Center.setBorderBottom(BorderStyle.THIN); //테두리 아래쪽
                cellStyle_Table_Center.setBorderLeft(BorderStyle.THIN); //테두리 왼쪽
                cellStyle_Table_Center.setBorderRight(BorderStyle.THIN); //테두리 오른쪽
                cellStyle_Table_Center.setAlignment(HorizontalAlignment.CENTER);
                cnt++;
            }

            String localFile = "C:\\excel\\" + "합계잔액시산표" + ".xlsx";

            File file = new File(localFile);
            FileOutputStream fos = null;
            fos = new FileOutputStream(file);
            xssfWb.write(fos);

            if (xssfWb != null)	xssfWb.close();
            if (fos != null) fos.close();

            //ctx.put("FILENAME", "입고상세출력_"+ mapList.get(0).get("PRINT_DATE"));
            //if(file != null) file.deleteOnExit();
        }
        catch(Exception e){

        }finally{

        }
	}
}