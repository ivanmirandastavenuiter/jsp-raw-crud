/**
 * Name: ValidationLogin
 * 
 * Author: Ivan Miranda Stavenuiter
 * MKNA
 * 
 */

import { ValidationException } from '../Exceptions/ValidationException.mjs';
import { ValidationFormException } from '../Exceptions/ValidationFormException.mjs';

document.addEventListener("DOMContentLoaded", function() {
	
	var availableCookies = document.cookie;
	
	var loginForm = document.getElementsByName("loginForm")[0];
	var submit = false;
	var validation = true;
	
	var username = document.getElementsByName("username")[0];
	var pass = document.getElementsByName("pass")[0];
	var wrongUsernameNode = document.getElementsByClassName("username-wrong-validation")[0];
	var wrongPassNode = document.getElementsByClassName("password-wrong-validation")[0];
	var inputNodes = document.getElementsByClassName("form-input");
	
	var inputsMap = new Map();
	inputsMap.set(username, wrongUsernameNode)
			 .set(pass, wrongPassNode);
	
	// Main function on submit
	loginForm.onsubmit = function(e) {
		
		e.preventDefault();
		
		try {
			
			validation = true;
			inputsMap.forEach(validateInputs);

			if (!validation) {
				return false;
			} else {
				this.submit();
			}
			
		} catch (err) {
			
			console.log('Exception thrown by parent try/catch block: ');
			console.log('Name: ' + err.name);
			console.log('Description: ' + err.message);
			console.log('Stack: ' + err.stack);
			
		}
		
	};
	
	// Function triggered on submit
	function validateInputs(value, key, map) {
		
		try {
			
			submit = true;
			
			if (key.name === 'username' && key.value.trim() === '') {
				
				throw new ValidationFormException(ValidationException.WARNING, 
												  ValidationException.USERNAME_EMPTY_FIELD,
												  value);
				
			} else if (key.name === 'pass' && key.value.trim() === '') {
				
				throw new ValidationFormException(ValidationException.WARNING, 
												  ValidationException.PASSWORD_EMPTY_FIELD,
												  value);
				
			}

		} catch(validationFormException) {
			
			if (validationFormException instanceof ValidationFormException) {
				validationFormException.handleLoginErrorOnSubmit();
				validation = false;
			} else {
				throw validationFormException;
			}
				
		}
		
	}
	
	// This check values after submit
	function validateInputsAfterSubmit(value, key, map) {
		
		key.onkeyup = function() {
			
			try {
				
				let resetNode = (value) => {
					value.innerText = '';	
					value.parentElement.style.transition = 'none';
					value.parentElement.style.opacity = 0;
				}
				
				if (submit) {
					
					let descriptionType = value.className.substring(0,4);
					
					if (descriptionType === 'user') {
						
						if (key.value.trim().length > 0) {
							resetNode(value);
						} else {
							throw new ValidationFormException(ValidationException.WARNING, 
															  ValidationException.USERNAME_EMPTY_FIELD,
															  value);
						}
						
					}
					
					if (descriptionType === 'pass') {
						
						if (key.value.trim().length > 0) {
							resetNode(value);
						} else {
							throw new ValidationFormException(ValidationException.WARNING, 
															  ValidationException.PASSWORD_EMPTY_FIELD,
															  value);
						}
						
					}
					
				}
				
			} catch(validationFormException) {
				
				if (validationFormException instanceof ValidationFormException) {
					validationFormException.handleLoginErrorAfterSubmit();
					validation = false;
				} else {
					throw validationFormException;
				}
					
			}
			
		}
	}
	
	inputsMap.forEach(validateInputsAfterSubmit);
	
	// Control errors from server if detected
	var controlErrorsFromServer = () => {
		
		try { 
			
			let errorsArray = [];
			let usernameWrongMessageNode = document.querySelector("p.username-wrong-validation");
			let passwordWrongMessageNode = document.querySelector("p.password-wrong-validation");
			let userNotFoundMessageNode = document.querySelector("p.user-not-found");
			
			submit = true;
			
			errorsArray.push(getCookie('username'));
			errorsArray.push(getCookie('password'));
			errorsArray.push(getCookie('error'));
			
			var errorsList = (value, key, map) => {
				
				try {
					
					if (value.trim() === "username") {
						
						throw new ValidationFormException(ValidationException.WARNING, 
								  ValidationException.USERNAME_EMPTY_FIELD,
								  usernameWrongMessageNode);
						
					}
					
					if (value.trim() === "password") {
						
						throw new ValidationFormException(ValidationException.WARNING, 
								  ValidationException.PASSWORD_EMPTY_FIELD,
								  passwordWrongMessageNode);
						
					}
					
					if (value.trim() === "user-not-found") {
						
						throw new ValidationFormException(ValidationException.WARNING, 
								  ValidationException.USER_NOT_FOUND,
								  userNotFoundMessageNode);
						
					}
					
				} catch(validationFormException){
					if (validationFormException instanceof ValidationFormException) {
						if (value.trim() === "user-not-found") {
							validationFormException.handleUserNotFoundError();
						} else {
							validationFormException.handleLoginErrorAfterSubmit();
						}
					} else {
						throw validationFormException;
					}
					
				}
				
			}
			
			errorsArray.forEach(errorsList);
			
		} catch(err) {
			
			console.log('Exception thrown while performing control over server data.');
			console.log('Name: ' + err.name);
			console.log('Description: ' + err.message);
			console.log('Stack: ' + err.stack);
				
		} 
		
	}

	// Snippet to get cookies by name
	var getCookie = (cookieName) => {
			
		let cookieNameStartingIndex = availableCookies.indexOf(cookieName);
		let cookieValueStartingIndex = cookieNameStartingIndex + cookieName.length + 1;
		let charIndex = cookieValueStartingIndex;
		let endIndex = availableCookies.length;
		let cookieValue = '';
		
		if (cookieNameStartingIndex != -1) {
			
			while(availableCookies.charAt(charIndex) != ";" && charIndex != endIndex) {
				cookieValue += availableCookies.charAt(charIndex);
				charIndex++;
			}
			
			return cookieValue.trim();
		
		} else {
			
			return 'Cookie not found';
			
		}
		
	}
	
	// If cookies detected, validation thrown
	if (availableCookies != undefined && availableCookies != '') {
		controlErrorsFromServer();
	}
	
});

	

	


	


