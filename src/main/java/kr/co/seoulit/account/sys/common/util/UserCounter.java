package kr.co.seoulit.account.sys.common.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserCounter implements HttpSessionListener {

	private int userCount;
	private ServletContext application;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) { //HttpSessionEvent 객체에 톰캣이 실행될때 자동으로 자동으로 실행될 이벤트를 저장하는 객체
		if (log.isDebugEnabled()) {
            log.debug(" UserCounter : sessionCreated 시작 ");
		}
		HttpSession session = se.getSession();
		application = session.getServletContext();

				if(application.getAttribute("userCount") == null) {
					application.setAttribute("userCount", 1);
				}else {
					userCount = (Integer)application.getAttribute("userCount");
					application.setAttribute("userCount", ++userCount);
				}
		
		System.out.println("접속자 수"+userCount);
		
		if (log.isDebugEnabled()) {
            log.debug(" UserCounter : sessionCreated 종료 ");
        }
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if (log.isDebugEnabled()) {
            log.debug(" UserCounter : sessionDestroyed 시작 ");
		}
		
		if(se.getSession().getServletContext().getAttribute("userCount") != null) {
			userCount = (Integer)application.getAttribute("userCount");
			application.setAttribute("userCount", --userCount);
		}
		
		System.out.println("접속자 수"+userCount);
		
		if (log.isDebugEnabled()) {
            log.debug(" UserCounter : sessionDestroyed 종료 ");
        }
	}
}
