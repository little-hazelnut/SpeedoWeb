package edu.csu.speedo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * 字符编码过滤器
 * */
public class EncodingFilter implements Filter {

	String defaultEncoding = "UTF-8";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		defaultEncoding = null;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(defaultEncoding);
	    response.setCharacterEncoding(defaultEncoding);   
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String encoding = filterConfig.getInitParameter("encoding");
		if (encoding != null ) {
			defaultEncoding = encoding;
		}
		

	}

}
