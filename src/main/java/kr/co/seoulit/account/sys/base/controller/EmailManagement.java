package kr.co.seoulit.account.sys.base.controller;
/*
 * package net.plang.howooaccount.system.base.controller;
 * 
 * import java.util.Properties;
 * 
 * import javax.activation.DataHandler; import javax.activation.FileDataSource;
 * import javax.mail.BodyPart; import javax.mail.Message; import
 * javax.mail.Multipart; import javax.mail.PasswordAuthentication; import
 * javax.mail.Session; import javax.mail.Transport; import
 * javax.mail.internet.InternetAddress; import javax.mail.internet.MimeBodyPart;
 * import javax.mail.internet.MimeMessage; import
 * javax.mail.internet.MimeMultipart; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import net.plang.howooaccount.system.common.servlet.ModelAndView; import
 * net.plang.HoWooAccount.system.common.servlet.controller.AbstractController;
 * 
 * public class EmailManagement extends AbstractController{
 * 
 * @Override public ModelAndView handleRequestInternal(HttpServletRequest
 * request, HttpServletResponse response){ // TODO Auto-generated method stub
 * try {
 * 
 * String slipNo=request.getParameter("slipNo"); String
 * email=request.getParameter("email"); String
 * emailOption=request.getParameter("emailOption");
 * 
 * String host = null; final String username = "js"; // 발송 메일 주소 final String
 * password = "1111"; // 발송 메일 비밀번호 String pdfBaseUrl =
 * "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\HoWooAccount\\resources\\reportform"
 * +slipNo+".pdf"; // 본인 pdf 파일 저장 위치로 경로 변경하세요!
 * 
 * int port=0;
 * 
 * if(emailOption.equals("naver.com")) { port=465; host = "smtp.naver.com"; }
 * else if(emailOption.equals("gmail.com")) { port=587; host = "smtp.gmail.com";
 * //구글 포트번호 보안때문에 해결 안됨. }
 * 
 * String recipient = email+"@"+emailOption; // 받는 사람의 이메일
 * System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+email+"@"+emailOption);
 * String subject = "전표번호 : " +slipNo + "의 상세내용입니다"; // 이메일 제목 String body =
 * "확인 후 회신바랍니다"; // 이메일 내용
 * 
 * Properties props = System.getProperties();
 * 
 * props.put("mail.smtp.host", host); props.put("mail.smtp.port", port);
 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.ssl.enable",
 * "true");
 * 
 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
 * String un = username; String pw = password;
 * 
 * protected PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication(un, pw); } }); session.setDebug(true);
 * 
 * Message msg = new MimeMessage(session); msg.setFrom(new
 * InternetAddress("seoulittest1@naver.com","HoWooAccount")); // 2번째 문자열은 발송자
 * 이름입니다. 변경하세요 msg.setRecipient(Message.RecipientType.TO, new
 * InternetAddress(recipient)); msg.setSubject(subject);
 * 
 * // 파일첨부를 위한 Multipart Multipart multipart = new MimeMultipart();
 * 
 * // BodyPart를 생성 BodyPart bodyPart = new MimeBodyPart();
 * bodyPart.setText(body);
 * 
 * // Multipart에 BodyPart를 붙인다. multipart.addBodyPart(bodyPart);
 * 
 * // 이미지를 첨부한다. bodyPart = new MimeBodyPart(); String filename = pdfBaseUrl;
 * 
 * // 첨부할 파일 경로 FileDataSource source = new FileDataSource(filename);
 * bodyPart.setDataHandler(new DataHandler(source));
 * multipart.addBodyPart(bodyPart);
 * 
 * 
 * bodyPart.setFileName(slipNo + ".pdf"); // 첨부할 파일의 이름을 바꿔서 보낼수 있음
 * 
 * bodyPart.setHeader("Content-ID", "image_id");
 * 
 * // 이메일 메시지의 내용에 Multipart를 붙인다. msg.setContent(multipart);
 * Transport.send(msg); }catch(Exception e) {
 * System.out.println("PDF발송 중 에러  : "+e.getMessage()); } return null; } }
 */