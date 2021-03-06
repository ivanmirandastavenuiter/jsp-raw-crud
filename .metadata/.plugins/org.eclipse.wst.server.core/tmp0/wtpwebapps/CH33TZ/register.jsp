<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
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
<title>Register</title>
<link href="https://fonts.googleapis.com/css?family=Merriweather&display=swap" rel="stylesheet">
<script type="module" src="Validations/ValidationRegister.mjs"></script>
<style>

	body {
		background: #464c80;
		margin: 0;
		padding: 0;
		height: 100%;
		font-size: 62.5%; /* This is equivalent to 10px */
		font-family: 'Merriweather', serif;
	}

	div.main-container-div {
		height: 150%;
		display: flex;
		justify-content: center;
	}

	div.form-container-div {
		margin: 100px;
		border-radius: 6px;
		background: #fff;
		width: 500px;
		box-shadow: 1px 1px 25px 1px #000; 
	}

	div.form-container-div form {
		padding: 10px 30px 30px 30px;
		font-size: 1.6em;
	}
	
	div.form-container-div .register-div {
		padding: 10px;
		text-align: center;
		border-radius: 5px 5px 0 0;
	}

	div.form-container-div .register-div h1 {
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

	.inputs-group-div .login-back-link-div {
		text-align: center;
	}

	.inputs-group-div .login-back-link-div span {
		color: #464c80;
		font-size: 0.75em;
		display: block;
		margin-top: 10px;
	}
	
	.inputs-group-div .login-back-link-div span a {
		color: #464c80;
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
 
	.inputs-group-div .login-back-link-div span a:visited,
	.inputs-group-div .login-back-link-div span a:active {
		color: inherit;
	}

</style>
</head>
<body>

	<% 
		if (request.getMethod().equals("POST") && !(boolean)request.getAttribute("errors")) {
			
			Logger logger = Logger.getLogger(com.ch33tz.logger.JspLogger.class.getName()); 
			logger.info("Starting validation on register target page.");
			
			logger.info("POST request detected on target page. Applying validation against input data.");
			
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String username = request.getParameter("username");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirm = request.getParameter("confirm");
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
			
			Map <String, String> userInput = null;
			
			if (request.getAttribute("userInput") == null) {
				userInput = new HashMap<String, String>();
				userInput.put("name", name);
				userInput.put("surname", surname);
				userInput.put("username", username);
				userInput.put("phone", phone);
				userInput.put("email", email);
				userInput.put("password", password);
				userInput.put("confirm", confirm);
				request.setAttribute("userInput", userInput);
			} else {
				if (request.getAttribute("userInput") instanceof HashMap) {
					userInput = (HashMap<String, String>)request.getAttribute("userInput"); // Corregir el warning del cast
				}
			}
			
			Pattern pattern;
			Matcher matcher;
			
			// First validations block
			try {
				
				if (name == null || name.isEmpty()) {
					logger.warning("Bad input for name. Populating cookie");
					nameCookieError = new Cookie("name", "name");
					nameCookieError.setMaxAge(1);
					response.addCookie(nameCookieError);
					validation = false;
				}
				
				if (surname == null || surname.isEmpty()) {
					logger.warning("Bad input for surname. Populating cookie");
					surnameCookieError = new Cookie("surname", "surname");
					surnameCookieError.setMaxAge(1);
					response.addCookie(surnameCookieError);
					validation = false;
				}
				
				if (username == null || username.isEmpty()) {
					logger.warning("Bad input for username. Populating cookie");
					usernameCookieError = new Cookie("username", "username");
					usernameCookieError.setMaxAge(1);
					response.addCookie(usernameCookieError);
					validation = false;
				}
				
				String phoneRegex = "(^(\\+\\s?([0]{2})\\s?([0-9]{2})\\s?)?([6-7]{1}[0-9]{2}){1}(\\s([0-9]{3}\\s?[0-9]{3}|[0-9]{2}\\s?[0-9]{2}\\s?[0-9]{2})|([0-9]){6})$)";

				if (phone == null || phone.isEmpty()) {
					logger.warning("Bad input for phone. Populating cookie");
					phoneCookieError = new Cookie("phone", "empty");
					phoneCookieError.setMaxAge(1);
					response.addCookie(phoneCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(phoneRegex);
					matcher = pattern.matcher(phone);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for phone. Expression not passed.");
						phoneCookieError = new Cookie("phone", "regex-fail");
						phoneCookieError.setMaxAge(1);
						response.addCookie(phoneCookieError);
						validation = false;
					}
				}
				
				String emailRegex = "^[\\w\\d\\\\\\^\\$\\.\\|\\?\\*\\+\\(\\)\\[\\{\\}\\]\\/\\-!'Â·%&=Â¿`Â´Ã‡Ã§_.;:,]+@[\\w\\d\\.\\-]+\\.[a-z]{2,3}$";
				
				if (email == null || email.isEmpty()) {
					logger.warning("Bad input for email. Populating cookie");
					emailCookieError = new Cookie("email", "empty");
					emailCookieError.setMaxAge(1);
					response.addCookie(emailCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(emailRegex);
					matcher = pattern.matcher(email);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for email. Expression not passed.");
						emailCookieError = new Cookie("email", "regex-fail");
						emailCookieError.setMaxAge(1);
						response.addCookie(emailCookieError);
						validation = false;
					}
				}
				
				String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$)(.{8,})";
				
				if (password == null || password.isEmpty()) {
					logger.warning("Bad input for password. Populating cookie");
					passwordCookieError = new Cookie("password", "empty");
					passwordCookieError.setMaxAge(1);
					response.addCookie(passwordCookieError);
					validation = false;
				} else {
					
					pattern = Pattern.compile(passwordRegex);
					matcher = pattern.matcher(password);
					
					if (!matcher.matches()) {
						logger.warning("Bad input for password. Expression not passed.");
						passwordCookieError = new Cookie("password", "regex-fail");
						passwordCookieError.setMaxAge(1);
						response.addCookie(passwordCookieError);
						validation = false;
					}
				}
				
				if (confirm == null || confirm.isEmpty()) {
					logger.warning("Bad input for confirm. Populating cookie");
					confirmCookieError = new Cookie("confirm", "confirm");
					confirmCookieError.setMaxAge(1);
					response.addCookie(confirmCookieError);
					validation = false;
				}
				
				if (password != null && !password.isEmpty()) {
					pattern = Pattern.compile(passwordRegex);
					matcher = pattern.matcher(password);
					
					if (!password.equals(confirm) && matcher.matches()) {
						logger.warning("Password does not match confirmation field.");
						passwordsNotEqualError = new Cookie("password", "not-equal");
						passwordsNotEqualError.setMaxAge(1);
						response.addCookie(passwordsNotEqualError);
						validation = false;
					}
				}
				
			} catch (Exception e) {
				
				logger.severe("Exception thrown while checking initial validation");
				logger.severe("Cause of the exception: " + e.getCause());
				logger.severe("Information for the exception: " + e.getMessage());
				
			}
			
			// Unique usernames, emails and phones
			String usernameSql = "SELECT usUse FROM user WHERE usUse = ?";
			String emailSql = "SELECT usEma FROM user WHERE usEma = ?";
			String phoneSql = "SELECT usPho FROM user WHERE usPho = ?";
			Connection conn = null;	
			PreparedStatement usernameStmt = null;
			PreparedStatement emailStmt = null;
			PreparedStatement phoneStmt = null;
			ResultSet rs = null;
			
			// JS Injection validation block
			if (validation) {
				
				String injectionRegex = "((<[^>]*(>|$))|(&lt;?(?!&gt;?)(.*(&gt;?){1}|.*$))|(&#0*60(?!&#0*62)(.*(&#0*62){1}|.*$))|(&#x0*3c(?!&#x0*3e)(.*(&#x0*3e){1}|.*$)))";
				String userInputValue = "";
				String[] dangerousTags = {"<", ">", "&lt;", "&gt;", "&lt", "&gt", "&#60", "&#62", "&#x3c", "&#x3e"};
				String regex = "";
				
				pattern = Pattern.compile(injectionRegex);
				
				try {
					
					// Validation for potential JS injections
					for (String userInputKey : userInput.keySet()) {
						
						logger.info("Sanitizing values for preventing JS injections. Current key is: " + userInputKey);
						
						userInputValue = userInput.get(userInputKey);
						matcher = pattern.matcher(userInputValue);
						
						if (matcher.find()) {
							
							logger.warning("Injection pattern matched. Looking for exact match.");
							
							for (String currentTag : dangerousTags) {
								
								userInputValue = userInput.get(userInputKey);
								
								if (userInputValue.indexOf(currentTag) > -1) {
									
									if (currentTag.equals("&#60") || currentTag.equals("&#62")) {
										
										logger.warning("Injection detected. Cleaning. Type: &#60");
										
										regex = "&#0*6(0|2)";
										userInput.put(userInputKey, userInputValue.replaceAll(regex, ""));
										
									} else if (currentTag.equals("&#x3c") || currentTag.equals("&#x3e")) {
										
										logger.warning("Injection detected. Cleaning. Type: &#x3c");
										
										regex = "&#x0*3(c|e)";
										userInput.put(userInputKey, userInputValue.replaceAll(regex, ""));
										
									} else {
										
										logger.info("Injection detected. Cleaning. Type: normal");
										userInput.put(userInputKey, userInputValue.replaceAll(currentTag, ""));
										
									}
									
								} else if (currentTag.length() >= 2 && 
										   currentTag.substring(0, 2).equals("&#") && 
										   userInputValue.indexOf(currentTag.substring(0, 2)) > -1) {
									
									logger.warning("Overflow detected");
									
									if (userInputValue.indexOf("60") > -1 || userInputValue.indexOf("62") > -1) {
										if ((userInputValue.indexOf("6") - userInputValue.indexOf("#")) > 1) {
											logger.warning("Injection detected. Cleaning. Type: overflow on &#60");
											regex = "&#0*6(0|2)";
											userInput.put(userInputKey, userInputValue.replaceAll(regex, ""));
										}
									}
									
									if (userInputValue.indexOf("3c") > -1 || userInputValue.indexOf("3e") > -1) {
										if ((userInputValue.indexOf("3") - userInputValue.indexOf("x")) > 1) {
											logger.info("Injection detected. Cleaning. Type: overflow on &#x3c");
											regex = "&#x0*3(c|e)";
											userInput.put(userInputKey, userInputValue.replaceAll(regex, ""));
										}
									}
									
								}
								
							}
							
						}
						
					}
					
				} catch (Exception e) {
					
					logger.severe("Exception thrown on injection controls block.");
					logger.severe("Cause of the exception: " + e.getCause());
					logger.severe("Information for the exception: " + e.getMessage());
					
				}
				
				// Repeated values validation block
				try {
					
					logger.info("Starting validation for possible repeated values");
					
					DriverManager.getDrivers(); 
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch33tz", "root", "");
					usernameStmt = conn.prepareStatement(usernameSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					usernameStmt.setString(1, username);
					rs = usernameStmt.executeQuery();
					
					if (rs.first()) {
						logger.warning("Bad input for username. Username already exists.");
						usernameCookieError = new Cookie("username", "exists");
						usernameCookieError.setMaxAge(1);
						response.addCookie(usernameCookieError);
						validation = false;
					}
					
					emailStmt = conn.prepareStatement(emailSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					emailStmt.setString(1, email);
					rs = emailStmt.executeQuery();
					
					if (rs.first()) {
						logger.warning("Bad input for email. Email already exists.");
						emailCookieError = new Cookie("email", "exists");
						emailCookieError.setMaxAge(1);
						response.addCookie(emailCookieError);
						validation = false;
					}
					
					phoneStmt = conn.prepareStatement(phoneSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					phoneStmt.setString(1, phone);
					rs = phoneStmt.executeQuery();
					
					if (rs.first()) {
						logger.warning("Bad input for phone. Phone already exists");
						phoneCookieError = new Cookie("phone", "exists");
						phoneCookieError.setMaxAge(1);
						response.addCookie(phoneCookieError);
						validation = false;
					}
					
				} catch(Exception e) {
					
					logger.severe("Exception thrown on repeated values controls block.");
					logger.severe("Cause of the exception: " + e.getCause());
					logger.severe("Information for the exception: " + e.getMessage());
					
				} finally {
					
					try {
						
						if (usernameStmt != null) {
							usernameStmt.close();
						}
						
						if (emailStmt != null) {
							emailStmt.close();
						}
						
						if (phoneStmt != null) {
							phoneStmt.close();
						}
						
					} catch(Exception e) {
						
						logger.severe("Exception thrown when closing resources for repeated values checks.");
						logger.severe("Cause of the exception: " + e.getCause());
						logger.severe("Information for the exception: " + e.getMessage());
						
					}
					
				}
				
			}
			
			
			// SQL Statement performing
			if (validation) {
				
				logger.info("Validation passed. Performing user registration.");
				
				PreparedStatement stmt = null;
				int result;
				String message = "";
				
				try {
					
					String hexKeyBytes = "";
					String hexIvBytes = "";
					
					// Encryption process
					try {
						
						Security.addProvider(new BouncyCastleProvider());
						
						// Translation to hex
						byte[] passwordBytes = password.getBytes();
						StringBuilder sb = new StringBuilder();
					    for (byte b : passwordBytes) {
					        sb.append(String.format("%02X ", b));
					    }
					    
					    logger.info("Bytes from original password to hexadecimal: " + sb.toString());
					    
					    Key                     key;
				        Cipher                  inCipher;
				        
				        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "BC");
				        keyGenerator.init(256);
				        key = keyGenerator.generateKey();
				        
				        // Key to hex
				        byte[] keyBytes = Hex.encode(key.getEncoded());
        				hexKeyBytes = new String(keyBytes); 
        				
        				logger.info("Encrypted key value in hexadecimal: " + hexKeyBytes);
        				
        				inCipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        		        
        		        // IV generation
        		        SecureRandom randomSecureRandom = new SecureRandom();
        		        byte[] iv = new byte[inCipher.getBlockSize()];
        		        randomSecureRandom.nextBytes(iv);
        		        
        		        hexIvBytes = new String(Hex.encode(iv));
        		        
        		        logger.info("Encrypted IV vector in hexadecimal: " + hexIvBytes);
        		        
        		        // Encryption initalization
        		        inCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        		        
        		        byte[] enc = inCipher.doFinal(Hex.decode(sb.toString()));
        		        userInput.put("password", new String(Hex.encode(enc)));
        		        
        		        logger.info("Encrypted password value in hexadecimal: " + new String(Hex.encode(enc)));
						
					} catch (Exception e) {
						
						logger.severe("Exception thrown on encryption process.");
						logger.severe("Cause of the exception: " + e.getCause());
						logger.severe("Information for the exception: " + e.getMessage());
						
					}
					
					String defaultRole = "user";
					String sql = "INSERT INTO user(usNam, usSur, usUse, usEma, usPho, usPas, usRol) VALUES(?, ?, ?, ?, ?, ?, ?)";
					stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					stmt.setString(1, userInput.get("name"));
					stmt.setString(2, userInput.get("surname"));
					stmt.setString(3, userInput.get("username"));
					stmt.setString(4, userInput.get("email"));
					stmt.setString(5, userInput.get("phone"));
					stmt.setString(6, userInput.get("password"));
					stmt.setString(7, defaultRole);
					
					result = stmt.executeUpdate();

					if (result > 0) {
						
						String usId = "";
						
						try {
							
							// Id retrieval
							sql = "SELECT usId FROM user WHERE usUse = ? AND usPas = ?";
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ch33tz", "root", "");
							stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1, userInput.get("username"));
							stmt.setString(2, userInput.get("password"));
							rs = stmt.executeQuery();
							
							if (rs.first()) {
								usId = Integer.toString(rs.getInt("usId"));
							} else {
								message = "Something went wrong while retreiving user id on encrypted data storage."
										+ " Check connection or admin for more details.";
								logger.warning(message);
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath());
							}
							
							// Keys storage
							sql = "INSERT INTO cipher(ciKey, ciVec, usId) VALUES (?, ?, ?)";
							stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1, hexKeyBytes);
							stmt.setString(2, hexIvBytes);
							stmt.setString(3, usId);
							
							result = stmt.executeUpdate();
							
							if (result > 0) {
								message = "User successfully registered into database";
								logger.info(message);
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath());
							} else {
								message = "Something went wrong while inserting encrypted data. Check connection or admin for more details.";
								logger.warning(message);
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath());
							}
							
						} catch (Exception e) {
							
							logger.severe("Exception thrown on encrypted keys storage.");
							logger.severe("Cause of the exception: " + e.getCause());
							logger.severe("Information for the exception: " + e.getMessage());
							
						}
						
					} else {
						message = "Something went wrong while inserting on database. Check connection or admin for more details.";
						logger.warning(message);
						request.getSession().setAttribute("message", message);
						response.sendRedirect(request.getContextPath());
					}
					
				} catch (Exception e) {
					
					logger.severe("Exception thrown on SQL registration statement.");
					logger.severe("Cause of the exception: " + e.getCause());
					logger.severe("Information for the exception: " + e.getMessage());
					
				} finally {
					
					try {
						
						if (stmt != null) {
							stmt.close();
						}
						
						if (conn != null) {
							conn.close();
						}
						
						if (rs != null) {
							rs.close();
						}
						
					} catch(Exception e) {
						
						logger.severe("Exception thrown when closing resources for registration.");
						logger.severe("Cause of the exception: " + e.getCause());
						logger.severe("Information for the exception: " + e.getMessage());
						
					}
					
				}
				
			} else {
				logger.warning("Validation not passed. Returning to register form from target page.");
			}
			
		}
		
	%>

	<!-- Main container -->
	<div class="main-container-div">

		<div class="form-container-div">
	
			<!-- Register div -->
			<div class="register-div">
				<h1>Register</h1>
			</div>

			<!-- Form -->
			<form name="registerForm" method="post">

				<div class="inputs-group-div">
				
					<!-- Input item -->
					<div class="input-div">
						<label for="name">Name</label>
						<input class="form-input" type="text" name="name" value="${userInput.name}" />
					</div>

					<!-- Error item -->
					<div class="name-wrong-validation-div">
						<p class="name-wrong-validation"><span></span></p>
					</div>
					
					<!-- Input item -->
					<div class="input-div">
						<label for="surname">Surname</label>
						<input class="form-input" type="text" name="surname" value="${userInput.surname}" />
					</div>

					<!-- Error item -->
					<div class="surname-wrong-validation-div">
						<p class="surname-wrong-validation"><span></span></p>
					</div>
					
					<!-- Input item -->
					<div class="input-div">
						<label for="username">Username</label>
						<input class="form-input" type="text" name="username" value="${userInput.username}" />
					</div>

					<!-- Error item -->
					<div class="username-wrong-validation-div">
						<p class="username-wrong-validation"><span></span></p>
					</div>
				
					<!-- Input item -->
					<div class="input-div">
						<label for="phone">Phone</label>
						<input class="form-input" type="text" name="phone" value="${userInput.phone}" />
					</div>

					<!-- Error item -->
					<div class="phone-wrong-validation-div">
						<p class="phone-wrong-validation"><span></span></p>
					</div>
					
					<!-- Input item -->
					<div class="input-div">
						<label for="email">Email</label>
						<input class="form-input" type="text" name="email" value="${userInput.email}" />
					</div>

					<!-- Error item -->
					<div class="email-wrong-validation-div">
						<p class="email-wrong-validation"><span></span></p>
					</div>
					
					<!-- Input item -->
					<div class="input-div">
						<label for="password">Password</label>
						<input class="form-input" type="password" name="password" value="${userInput.password}" />
					</div>

					<!-- Error item -->
					<div class="password-wrong-validation-div">
						<p class="password-wrong-validation"><span></span></p>
					</div>
					
					<!-- Input item -->
					<div class="input-div">
						<label for="confirm">Confirm</label>
						<input class="form-input" type="password" name="confirm" value="${userInput.confirm}" />
					</div>

					<!-- Error item -->
					<div class="confirm-wrong-validation-div">
						<p class="confirm-wrong-validation"><span></span></p>
					</div>
										
					<div class="input-div">
						<input class="submit-btn" type="submit" value="Register"/>
					</div>

					<div class="login-back-link-div">
						<span><a href="./index.jsp">Back to login</a></span>
					</div>

				</div>
			
			</form>

		</div>
		
	</div>
	
</body>
</html>

