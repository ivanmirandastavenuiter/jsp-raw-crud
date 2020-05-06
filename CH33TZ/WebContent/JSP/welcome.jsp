<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.Map, java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="IUTF-8">
<title>Welcome</title>
</head>
<body>

<%
	Logger logger = Logger.getLogger(com.ch33tz.logger.JspLogger.class.getName()); 
	logger.info("Starting validation on target page.");

	//Validation of the user input
	String username = request.getParameter("username").trim();
	String password = request.getParameter("pass").trim();
	String contextPath = "/";
	
	try {
		
		if (username == null || username.isEmpty()
				|| password == null || password.isEmpty()) {
		
			logger.info("Errors detected on target page. Redirecting to index.");
			
			Map<String, String> errors = new HashMap<String, String>();
			
			if (username == null || username.isEmpty()) {
				errors.put("username", "Error on username. Empty.");
			} 
			
			if (password == null || password.isEmpty() ) {
				errors.put("password", "Error on password. Empty.");
			}
			
			request.setAttribute("errors", errors);
		
		    RequestDispatcher rd = request.getRequestDispatcher(contextPath);
		    rd.forward(request, response);
		   	return;
		
		}
		
	} catch (Exception e) {
		
		logger.severe("Exception thrown on validation: " + e.getMessage());
		
	}
	
	Connection conn = null;	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		
		// Driver registration gets autoloaded on JDBC 4.0 compliant versions:
			
		// * mysql-connector-java-5.1.36.jar version or higher
		// * jdk 6 or higher
			
		// However, it only gets loaded after second request. At least, in JSP.
		// This sentence is equivalent to: Class.forName("com.mysql.cj.jdbc.Driver")
		DriverManager.getDrivers(); 
		
		String sql = "SELECT * FROM user WHERE usId = ?";
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch33tz", "root", "");
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, 4);
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			logger.info("User id: " + rs.getString("usId"));
			logger.info("User name: " + rs.getString("usNam"));
			logger.info("User password: " + rs.getString("usPas"));
		}
		
	} catch (Exception e) {
		
		logger.severe("Main exception: " + e.getMessage());
		
	} finally {
		
		try {
			
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
			
		} catch(Exception e) {
			
			logger.severe("Nested exception: " + e.getMessage());
			
		}
		
	}
	
%>

	<h1>Ch33tz</h1>
	
	<p>Building under maintenance</p>

</body>
</html>