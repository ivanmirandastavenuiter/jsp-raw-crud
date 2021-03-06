package com.ch33tz.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import com.ch33tz.logger.JspLogger;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/index.jsp"})
public class LoginFilter implements Filter {
	
	private final static Logger logger = Logger.getLogger(JspLogger.class.getName()); 
	private FilterConfig loginFilterConfig;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        logger.info("Creating LoginFilter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("Destroying LoginFilter");
		this.loginFilterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.info("Starting validation on login filter.");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		if (httpServletRequest.getMethod().equals("GET")) {
			logger.info("GET request detected on index page. Bypassing filters.");
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
		
		if (httpServletRequest.getMethod().equals("POST")) {
			
			logger.info("POST request detected on index page. Applying filters against input data.");
			
			Map <String, String> userInput = new HashMap<String, String>();
			String username = httpServletRequest.getParameter("username");
			String password = httpServletRequest.getParameter("pass");
			String contextPath = "/";
			
			username = username != null ? username.trim() : null;
			password = password != null ? password.trim() : null;
			
			userInput.put("username", username);
			userInput.put("password", password);
			httpServletRequest.setAttribute("userInput", userInput);
			
			try {
				
				if (username == null || username.isEmpty()
							|| password == null || password.isEmpty()) {
					
					logger.info("Errors detected on login form. Redirecting to index from filter.");
					
					Cookie usernameCookieError = null;
					Cookie passwordCookieError = null;
					
					if (username == null || username.isEmpty()) {
						logger.warning("Bad input for username. Populating cookie");
						usernameCookieError = new Cookie("username", "username");
						usernameCookieError.setMaxAge(1);
						httpServletResponse.addCookie(usernameCookieError);
					} 
					
					if (password == null || password.isEmpty() ) {
						logger.warning("Bad input for password. Populating cookie");
						passwordCookieError = new Cookie("password", "password");
						passwordCookieError.setMaxAge(1);
						httpServletResponse.addCookie(passwordCookieError);
					}
					
					httpServletRequest.setAttribute("errors", true);
		            RequestDispatcher rd = httpServletRequest.getRequestDispatcher(contextPath);
		            rd.forward(httpServletRequest, httpServletResponse);
		            return;
	
				}
				
				logger.info("Validation passed on filtering. Forwarding to target page.");
				httpServletRequest.setAttribute("errors", false);
				chain.doFilter(httpServletRequest, httpServletResponse);
				
			} catch (Exception e) {
			
				logger.severe("Exception detected on login filter");
				logger.severe("Cause of the exception: " + e.getCause());
				logger.severe("Information for the exception: " + e.getMessage());
				
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("LoginFilter initialization");
		this.loginFilterConfig = fConfig;
	}

}
