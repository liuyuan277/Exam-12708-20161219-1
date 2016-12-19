package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

	String charEncoding = null;
	
    public EncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;

		if (!charEncoding.equals(hreq.getCharacterEncoding())) {
			hreq.setCharacterEncoding(charEncoding);
		}
		hres.setContentType("text/html");
		hres.setCharacterEncoding(charEncoding);

		chain.doFilter(hreq, hres);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		charEncoding = fConfig.getInitParameter("encoding");
		if (charEncoding == null) {
			throw new ServletException("EncodingFilter的编码设置为空！！！");
		} else {
			System.out.println("charSet: " + charEncoding);
		}
	}

}
