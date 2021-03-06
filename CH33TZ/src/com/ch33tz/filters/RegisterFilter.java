package com.ch33tz.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch33tz.logger.JspLogger;

/**
 * Servlet Filter implementation class RegisterFilter
 */
@WebFilter(filterName = "RegisterFilter", urlPatterns = {"/register.jsp"})
public class RegisterFilter implements Filter {
	
	private final static Logger logger = Logger.getLogger(JspLogger.class.getName()); 
	private FilterConfig registerFilterConfig;

    /**
     * Default constructor. 
     */
    public RegisterFilter() {
    	logger.info("Creating RegisterFilter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("Destroying RegisterFilter");
		this.registerFilterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		logger.info("Starting validation on register filter.");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		if (httpServletRequest.getMethod().equals("GET")) {
			logger.info("GET request detected on register page. Bypassing filters.");
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
		
		if (httpServletRequest.getMethod().equals("POST")) {
			
			logger.info("POST request detected on index page. Applying filters against input data.");
			
			Map <String, String> userInput = new HashMap<String, String>();
			
			String name = httpServletRequest.getParameter("name");
			String surname = httpServletRequest.getParameter("surname");
			String username = httpServletRequest.getParameter("username");
			String phone = httpServletRequest.getParameter("phone");
			String email = httpServletRequest.getParameter("email");
			String password = httpServletRequest.getParameter("password");
			String confirm = httpServletRequest.getParameter("confirm");
			String contextPath = "/register.jsp";
			
			name = name != null ? name.trim() : null;
			surname = surname != null ? surname.trim() : null;
			username = username != null ? username.trim() : null;
			phone = phone != null ? phone.trim() : null;
			email = email != null ? email.trim() : null;
			password = password != null ? password.trim() : null;
			confirm = confirm != null ? confirm.trim() : null;
			
			boolean validation = true;
			Cookie nameCookieError = null;
			Cookie surnameCookieError = null;
			Cookie usernameCookieError = null;
			Cookie phoneCookieError = null;
			Cookie emailCookieError = null;
			Cookie passwordCookieError = null;
			Cookie confirmCookieError = null;
			Cookie passwordsNotEqualError = null;
			
			userInput.put("name", name);
			userInput.put("surname", surname);
			userInput.put("username", username);
			userInput.put("phone", phone);
			userInput.put("email", email);
			userInput.put("password", password);
			userInput.put("confirm", confirm);
			httpServletRequest.setAttribute("userInput", userInput);
			
			Pattern pattern;
			Matcher matcher;
			
			try {
				
				if (name == null || name.isEmpty()) {
					logger.warning("Bad input for name. Populating cookie");
					nameCookieError = new Cookie("name", "name");
					nameCookieError.setMaxAge(1);
					httpServletResponse.addCookie(nameCookieError);
					validation = false;
				}
				
				if (surname == null || surname.isEmpty()) {
					logger.warning("Bad input for surname. Populating cookie");
					surnameCookieError = new Cookie("surname", "surname");
					surnameCookieError.setMaxAge(1);
					httpServletResponse.addCookie(surnameCookieError);
					validation = false;
				}
				
				if (username == null || username.isEmpty()) {
					logger.warning("Bad input for username. Populating cookie");
					usernameCookieError = new Cookie("username", "username");
					usernameCookieError.setMaxAge(1);
					httpServletResponse.addCookie(usernameCookieError);
					validation = false;
				}
				
				String phoneRegex = "(^(\\+\\s?([0]{2})\\s?([0-9]{2})\\s?)?([6-7]{1}[0-9]{2}){1}(\\s([0-9]{3}\\s?[0-9]{3}|[0-9]{2}\\s?[0-9]{2}\\s?[0-9]{2})|([0-9]){6})$)";

				if (phone == null || phone.isEmpty()) {
					logger.warning("Bad input for phone. Populating cookie");
					phoneCookieError = new Cookie("phone", "empty");
					phoneCookieError.setMaxAge(1);
					httpServletResponse.addCookie(phoneCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(phoneRegex);
					matcher = pattern.matcher(phone);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for phone. Expression not passed.");
						phoneCookieError = new Cookie("phone", "regex-fail");
						phoneCookieError.setMaxAge(1);
						httpServletResponse.addCookie(phoneCookieError);
						validation = false;
					}
				}
				
				String emailRegex = "^[\\w\\d\\\\\\^\\$\\.\\|\\?\\*\\+\\(\\)\\[\\{\\}\\]\\/\\-!'·%&=¿`´Çç_.;:,]+@[\\w\\d\\.\\-]+\\.[a-z]{2,3}$";
				
				if (email == null || email.isEmpty()) {
					logger.warning("Bad input for email. Populating cookie");
					emailCookieError = new Cookie("email", "empty");
					emailCookieError.setMaxAge(1);
					httpServletResponse.addCookie(emailCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(emailRegex);
					matcher = pattern.matcher(email);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for email. Expression not passed.");
						emailCookieError = new Cookie("email", "regex-fail");
						emailCookieError.setMaxAge(1);
						httpServletResponse.addCookie(emailCookieError);
						validation = false;
					}
				}
				
				String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$)(.{8,})";
				
				if (password == null || password.isEmpty()) {
					logger.warning("Bad input for password. Populating cookie");
					passwordCookieError = new Cookie("password", "empty");
					passwordCookieError.setMaxAge(1);
					httpServletResponse.addCookie(passwordCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(passwordRegex);
					matcher = pattern.matcher(password);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for password. Expression not passed.");
						passwordCookieError = new Cookie("password", "regex-fail");
						passwordCookieError.setMaxAge(1);
						httpServletResponse.addCookie(passwordCookieError);
						validation = false;
					}
				}
				
				if (confirm == null || confirm.isEmpty()) {
					logger.warning("Bad input for confirm. Populating cookie");
					confirmCookieError = new Cookie("confirm", "confirm");
					confirmCookieError.setMaxAge(1);
					httpServletResponse.addCookie(confirmCookieError);
					validation = false;
				}
				
				if (password != null && !password.isEmpty()) {
					
					pattern = Pattern.compile(passwordRegex);
					matcher = pattern.matcher(password);
					
					if (!password.equals(confirm) && matcher.matches()) {
						logger.warning("Password does not match confirmation field.");
						passwordsNotEqualError = new Cookie("password", "not-equal");
						passwordsNotEqualError.setMaxAge(1);
						httpServletResponse.addCookie(passwordsNotEqualError);
						validation = false;
					}
					
				}
				
				if (validation) {
					logger.info("Validation passed on filtering. Forwarding to target page.");
					httpServletRequest.setAttribute("errors", false);
					chain.doFilter(httpServletRequest, httpServletResponse);
				} else {
					logger.info("Validation not passed. Returning to register form from filter.");
					httpServletRequest.setAttribute("errors", true);
		            RequestDispatcher rd = httpServletRequest.getRequestDispatcher(contextPath);
		            rd.forward(httpServletRequest, httpServletResponse);
		            return;
				}
				
			} catch (Exception e) {
				
				logger.severe("Exception detected on register filter");
				logger.severe("Cause of the exception: " + e.getCause());
				logger.severe("Information for the exception: " + e.getMessage());
				
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("RegisterFilter initialization");
		this.registerFilterConfig = fConfig;
	}

}
