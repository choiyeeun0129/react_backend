package kr.co.seoulit.account.sys.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class encodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("encodingFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String uri = request.getRequestURI();
        String ext = uri.substring(uri.lastIndexOf(".") > -1 ? uri.lastIndexOf(".") : 0);

        switch (ext) {
            case ".do":
                response.setContentType("application/json; charset=UTF-8");
                break;
            case ".js":
                response.setContentType("text/javascript; charset=UTF-8");
                break;
            default:
                response.setContentType("text/html; charset=UTF-8");
        }

        response.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
