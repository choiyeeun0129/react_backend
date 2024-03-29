package kr.co.seoulit.account;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import kr.co.seoulit.account.sys.common.interceptor.LoggerInterceptor;
import kr.co.seoulit.account.sys.common.interceptor.SessionListener;



@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
		
		@Bean
		public FilterRegistrationBean<SiteMeshFilter> siteMeshFilter() {
			FilterRegistrationBean<SiteMeshFilter> filter = new FilterRegistrationBean<SiteMeshFilter>();
			filter.setFilter(new SiteMeshFilter());
			return filter;
		}
		@Bean
		public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
			return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionListener());
		}
		@Bean(name = "multipartResolver")
		public CommonsMultipartResolver multipartResolver() {
		    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		    multipartResolver.setMaxUploadSize(100000);
		    return multipartResolver;
		}

}
