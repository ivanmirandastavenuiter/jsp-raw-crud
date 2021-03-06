<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.security.Key" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.security.Security" %>
<%@ page import="javax.crypto.Cipher" %>
<%@ page import="javax.crypto.KeyGenerator" %>
<%@ page import="javax.crypto.spec.IvParameterSpec" %>
<%@ page import="javax.crypto.spec.SecretKeySpec" %>
<%@ page import="org.bouncycastle.jce.provider.BouncyCastleProvider" %>
<%@ page import="org.bouncycastle.util.encoders.Hex" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://fonts.googleapis.com/css?family=Merriweather&display=swap" rel="stylesheet">
<script type="module" src="Validations/ValidationLogin.mjs"></script>
<style>

	body {
		background: #464c80;
		margin: 0;
		padding: 0;
		height: 100vh;
		width: 100vw;
		font-size: 62.5%; /* This is equivalent to 10px */
		font-family: 'Merriweather', serif;
	}
	
	div.main-container-div {
		height: 100%;
	}
	
	div.register-result-container {
		margin-top: 50px;
	}
	
	div.register-result-message {
		width: 50%;
		margin: 0 auto;
		font-size: 1.6em;
		color: #77d54d;
		border: 1px solid #77d54d;
		border-radius: 20px;
	}
	
	div.register-result-message p {
		text-align: center;
		padding: 5px;
	}

	div.main-content-div {
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	div.form-container-div {
		border-radius: 6px;
		background: #fff;
		width: 500px;
		box-shadow: 1px 1px 25px 1px #000; 
	}

	div.form-container-div form {
		padding: 10px 30px 30px 30px;
		font-size: 1.6em;
	}
	
	div.form-container-div .login-div {
		padding: 10px;
		text-align: center;
		border-radius: 5px 5px 0 0;
	}
	
	div.user-not-found-div {
		width: 400px;
		margin: 0 auto;
		opacity: 0; /* To 1 */
		transition: opacity .5s linear;
		font-size: 1.6em;
		height: 0; /* To auto */
	}
	
	p.user-not-found {
		margin: 0 auto;
		padding: 0; /* To 5 */
		width: 63%;
		font-size: .7em;
		border: 1px solid #e21010;
		color: #e21010;
		text-align: center;
		height: 0; /* To auto */
	}

	div.form-container-div .login-div h1 {
		font-size: 3.5em;
	}

	/* Inside form-container-div */

	.inputs-group-div {
		padding: 15px;
	}

	.inputs-group-div .input-div {
		width: 400px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 0 auto;
	}

	.inputs-group-div .input-div .form-input {
		width: 63%;
		height: 20px;
		font-family: inherit;
		font-size: .8em;
		outline: none;
		border: 1px solid #464c80;
		padding: 5px;
	}

	.inputs-group-div div[class$="wrong-validation-div"] {
		display: flex;
		justify-content: flex-end;
		width: 400px;
		margin: 0 auto;
		opacity: 0;
		transition: opacity .5s linear;
	}

	.inputs-group-div div[class$="wrong-validation-div"] p {
		width: 63%;
		padding: 5px;
		font-size: .7em;
		border: 1px solid #e21010;
		color: #e21010;
	}

	.inputs-group-div .input-div label {
		height: 20px;
		padding: 3px;
	}

	.inputs-group-div .input-div .submit-btn {
		font-family: inherit;
		font-size: .8em;
		margin: 15px auto 5px auto;
		width: 40%;
		padding: 5px;
		color: #fff;
		background: #464c80;
		border-radius: 20px;
		height: 30px;
		border: none;
		transition: background-color .3s linear;
		outline: none;
	}

	.inputs-group-div .register-link-div {
		text-align: center;
	}

	.inputs-group-div .register-link-div span {
		font-size: 0.75em;
		display: block;
		margin-top: 10px;
	}
	
	.inputs-group-div .register-link-div span a {
	  	color: #464c80 !important;
	}

	/* Buttons, boxes and links interactions */

	.inputs-group-div .input-div .submit-btn:hover {
		background:#666dad;
	}

	.inputs-group-div .input-div .submit-btn:active {
		background: #272b50;
		transition: none;
		border: 1.5px solid #bfc4fd;
	}

	.inputs-group-div .input-div .form-input:focus {
		background: #d1d8f1;
		border: 1px solid #000;
	}
	
	.inputs-group-div .form-input:-internal-autofill-selected {
		background-color: #d1d8f1 !important;
		border: 1px solid #000 !important;
	}
	
	.inputs-group-div .input-div .submit-btn:focus {
		background: #272b50;
		transition: none;
		border: 1.5px solid #bfc4fd;
	}
 
	.inputs-group-div .register-link-div span a:visited,
	.inputs-group-div .register-link-div span a:active {
		color: inherit;
	}

</style>
</head>
<body>

	<c:set var = "contextPath" value="${pageContext.request.contextPath}" />
	
	<%
	
		Logger logger = Logger.getLogger(com.ch33tz.logger.JspLogger.class.getName()); 

		if (request.getMethod().equals("POST") && !(boolean)request.getAttribute("errors")) {
			
			logger.info("Starting validation on target page.");
			logger.info("POST request detected on target page. Applying validation against input data.");
	
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			String contextPath = "/";
			boolean validation = true;
			
			try {
				
				username = username != null ? username.trim() : null;
				password = password != null ? password.trim() : null;
				
				if (request.getAttribute("userInput") == null) {
					Map <String, String> userInput = new HashMap<String, String>();
					userInput.put("username", username);
					userInput.put("password", password);
					request.setAttribute("userInput", userInput);
				}
				
				if (username == null || username.isEmpty()
						|| password == null || password.isEmpty()) {
				
					logger.info("Errors detected on target page. Proceeding to generate errors");
					
					Cookie usernameCookieError = null;
					Cookie passwordCookieError = null;
					
					if (username == null || username.isEmpty()) {
						logger.warning("Bad input for username. Populating cookie");
						usernameCookieError = new Cookie("username", "username");
						usernameCookieError.setMaxAge(1);
						response.addCookie(usernameCookieError);
						validation = false;
					} 
					
					if (password == null || password.isEmpty() ) {
						logger.warning("Bad input for password. Populating cookie");
						passwordCookieError = new Cookie("password", "password");
						passwordCookieError.setMaxAge(1);
						response.addCookie(passwordCookieError);
						validation = false;
					}
				
				}
				
			} catch (Exception e) {
				
				logger.severe("Exception thrown while performing validation on target page.");
				logger.severe("Cause of the exception: " + e.getCause());
				logger.severe("Information for the exception: " + e.getMessage());
				
			}
			
			if (validation) {
				
				Connection conn = null;	
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				Map <String, String> userData = new HashMap<String, String>();
				
				try {
					
					// Driver registration gets autoloaded on JDBC 4.0 compliant versions:
						
					// * mysql-connector-java-5.1.36.jar version or higher
					// * jdk 6 or higher
						
					// However, it only gets loaded after second request. At least, in JSP.
					// This sentence is equivalent to: Class.forName("com.mysql.cj.jdbc.Driver")
					DriverManager.getDrivers(); 
					
					String sql = "SELECT * from user U " +
													"JOIN cipher C " +
												    "on U.usId = C.usId " +
												    "WHERE usUse = ?";
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch33tz", "root", "");
					stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					stmt.setString(1, username);
					rs = stmt.executeQuery();

					if (rs.first()) {
						
						String hexKeyBytes = "";
						String hexIvBytes = "";
						String encryptedPassword = "";
						int usId = 0;
						int usIdCipherReference = 0;
						String decryptedPassword = "";
						
						// Decryption process
						try {
							
							Security.addProvider(new BouncyCastleProvider());
							
							hexKeyBytes = rs.getString("ciKey");
							hexIvBytes = rs.getString("ciVec");
							encryptedPassword = rs.getString("usPas");
							usId = Integer.parseInt(rs.getString("U.usId"));
							usIdCipherReference = Integer.parseInt(rs.getString("C.usId"));
							
							Key                     key;
					        Cipher                  outCipher;
					        
					        outCipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
							
							// Key recovery
							byte[] keyBytes = Hex.decode(hexKeyBytes);
							key = new SecretKeySpec(keyBytes, "AES");
							
							logger.info("Key loaded");
							
							// IV vector recovery
							byte[] iv = Hex.decode(hexIvBytes);
							
							logger.info("Vector loaded");
							
							// Decryption initialization
							outCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
							
							byte[] dec = outCipher.doFinal(Hex.decode(encryptedPassword));
							decryptedPassword = new String(dec);
							
							logger.info("Decrypted password value is: " + decryptedPassword);
	
							
						} catch (Exception e) {
							
							logger.severe("Exception thrown while performing data decryption. Check connection or contact admin for more details.");
							logger.severe("Cause of the exception: " + e.getCause());
							logger.severe("Information for the exception: " + e.getMessage());
							
						}
						
						if (usId == usIdCipherReference && password.equals(decryptedPassword)) {
							
							logger.info("User found: " + rs.getString("usUse") + ". Populating user data.");
							
							userData.put("id", Integer.toString(rs.getInt("U.usId")));
							userData.put("name", rs.getString("usNam"));
							userData.put("surname", rs.getString("usSur"));
							userData.put("username", rs.getString("usUse"));
							userData.put("email", rs.getString("usEma"));
							
							logger.info("Redirecting to welcome page...");
							
							request.getSession().setAttribute("user", userData);
							response.sendRedirect(request.getContextPath() + "/JSP/welcome.jsp");
							
						} else {
							logger.warning("User not found. Populating cookie");
							logger.info("Returning to login form.");
							Cookie userNotFoundCookie = new Cookie("error", "user-not-found");
							userNotFoundCookie.setMaxAge(1);
							response.addCookie(userNotFoundCookie);
						}
						
					} else {
						logger.warning("User not found. Populating cookie");
						logger.info("Returning to login form.");
						Cookie userNotFoundCookie = new Cookie("error", "user-not-found");
						userNotFoundCookie.setMaxAge(1);
						response.addCookie(userNotFoundCookie);
					}
					
				} catch (Exception e) {
					
					logger.severe("Exception thrown while executing SQL statement to check user identity.");
					logger.severe("Cause of the exception: " + e.getCause());
					logger.severe("Information for the exception: " + e.getMessage());
					
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
						
						logger.severe("Exception thrown at finally block on closing resources.");
						logger.severe("Cause of the exception: " + e.getCause());
						logger.severe("Information for the exception: " + e.getMessage());
						
					}
					
				}
				
			}
						
		} 
		
	%>
	
	<!-- Main container -->
	<div class="main-container-div">
	
		<!-- Errors container -->
		<c:if test="${ not empty message}">
			<div class="register-result-container">
				<div class="register-result-message">
					<p>${message}</p>
					<c:remove var="message" />
				</div>
			</div>
		</c:if>
	
		<!-- Main content -->
		<div class="main-content-div">
	
			<div class="form-container-div">
		
				<!-- Login div -->
				<div class="login-div">
					<h1>Login</h1>
				</div>
				
				<!-- User not found div -->
				<div class="user-not-found-div">
					<p class="user-not-found"></p>
				</div>
	
				<!-- Form -->
				<form name="loginForm" method="post">
	
					<div class="inputs-group-div">
	
						<!-- Input items -->
						<div class="input-div">
							<label for="username">Username</label>
							<input class="form-input" type="text" name="username" value="${userInput.username}" />
						</div>
	
						<div class="username-wrong-validation-div">
							<p class="username-wrong-validation"></p>
						</div>
					
						<div class="input-div">
							<label for="pass">Password</label>
							<input class="form-input" type="password" name="pass" value="${userInput.password}" />
						</div>
	
						<div class="password-wrong-validation-div">
							<p class="password-wrong-validation"></p>
						</div>
						
						<div class="input-div">
							<input class="submit-btn" type="submit" value="Submit"/>
						</div>
	
						<div class="register-link-div">
							<span><a href="register.jsp">I'm not a user yet</a></span>
						</div>
	
					</div>
				
				</form>
	
			</div>
			
		</div>
		
	</div>
	
</body>
</html>

