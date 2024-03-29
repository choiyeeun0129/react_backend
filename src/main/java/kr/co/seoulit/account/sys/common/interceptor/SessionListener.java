package kr.co.seoulit.account.sys.common.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {
	private int userCount;
	private ServletContext application;

	@Override
	public void sessionCreated(HttpSessionEvent se) { //HttpSessionEvent 객체에 톰캣이 실행될때 자동으로 자동으로 실행될 이벤트를 저장하는 객체
		System.out.println("session객체를 생성하고 있음.");
		HttpSession session = se.getSession();
		application = session.getServletContext();

				if(application.getAttribute("userCount") == null) {
					application.setAttribute("userCount", 1);
				}else {
					userCount = (Integer)application.getAttribute("userCount");
					application.setAttribute("userCount", ++userCount);
				}
		
		System.out.println("접속자 수"+userCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		if(se.getSession().getServletContext().getAttribute("userCount") != null) {
			userCount = (Integer)application.getAttribute("userCount");
			application.setAttribute("userCount", --userCount);
		}
		
		System.out.println("접속자 수"+userCount);
	}
}
