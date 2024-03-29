package kr.co.seoulit.account.sys.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {

    private String loginPage;
    private String movePage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("loginFilter.init");
    	/*FilterConfig의 메서드 getServletContext()의 리턴타입 ServletContext
    	 * 변수 contextPath는 프로젝트 경로(/Account)만 담겨있다. 
    	 * */
        String contextPath = filterConfig.getServletContext().getContextPath();
        // excludePathList = filterConfig.getInitParameter("excludeLoginFilter");
        loginPage = "loginform";
        // /loginForm.html
        loginPage = loginPage.startsWith("/") ? contextPath + loginPage : contextPath + "/" + loginPage;
        //  /Account33/loginForm.html

        movePage = "hello";
        // /hello.html
        movePage = movePage.startsWith("/") ? contextPath + movePage : contextPath + "/" + movePage;
        //	/Account33/hello.html
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("loginFilter.doFilter");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // .html 파일과 welcome page만 필터링
        if(excludeUrl(request)) { //회원가입이면 true 아니면 false
        	  filterChain.doFilter(request, response);
        }else {
        if (request.getRequestURI().equals("/") || request.getRequestURI().endsWith("form")) { // 
        	// request.getRequestURI() --> /Account/hello.html
            System.out.println("로그인 필터 Start");

            boolean isLoginPage = request.getRequestURI().equals(loginPage); 
            System.out.println("RequestURI : " + request.getRequestURI());
            System.out.println("loginPage : " + loginPage);

            if (isLoginPage && request.getSession().getAttribute("empCode") != null) {
            	System.out.println("Filter1 실행");
                response.sendRedirect(movePage);
                System.out.println(movePage + " 페이지 이동");
                return;
            }
            
            if (!isLoginPage && request.getRequestURI().endsWith("empinsertform")) {
            	System.out.println("Filter2 실행");
                response.sendRedirect(movePage);
                System.out.println("페이지 이동");
                return;
            }

            if (!isLoginPage && request.getSession().getAttribute("empCode") == null) {
            	System.out.println("Filter3 실행");
                response.sendRedirect(loginPage);
                System.out.println("페이지 이동");
                return;
            }

            System.out.println("로그인 필터 End");
        }
        filterChain.doFilter(servletRequest, response);
    }
    }
    
    private boolean excludeUrl(HttpServletRequest request) {
        String uri = request.getRequestURI().toString().trim();         //  request.getRequestURI()는 프로젝트와 파일경로까지 가져온다.
        if(uri.contains(request.getContextPath()+"/hr/empinsertForm")){//회원가입
            return true;
        }else{
            return false;
        }

  }

    @Override
    public void destroy() {

    }
}
