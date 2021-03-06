/**
 * Name: ValidationException
 * 
 * Author: Ivan Miranda Stavenuiter
 * MKNA
 * 
 */

export class ValidationException extends Error {

	constructor(message) {
		super(message);
	}

	// Messages for exceptions
	static get WARNING() { return 'There has been an error on the validation process' };
	
	static get NAME_EMPTY_FIELD() { return 'Name field cannot be empty' };
	static get SURNAME_EMPTY_FIELD() { return 'Surname field cannot be empty' };
	static get USERNAME_EMPTY_FIELD() { return 'Username field cannot be empty' };
	static get PHONE_EMPTY_FIELD() { return 'Phone field cannot be empty' };
	static get EMAIL_EMPTY_FIELD() { return 'Email field cannot be empty' };
	static get PASSWORD_EMPTY_FIELD() { return 'Password field cannot be empty' };
	static get CONFIRM_EMPTY_FIELD() { return 'Confirm field cannot be empty' };
	static get PHONE_NOT_MATCH() { return 'Phone does not match requirements' };
	static get EMAIL_NOT_MATCH() { return 'Email does not match requirements' };
	static get USERNAME_EXISTS() { return 'Username already exists' };
	static get EMAIL_EXISTS() { return 'Email already exists' };
	static get PHONE_EXISTS() { return 'Phone already exists' };
	static get PASSWORD_NOT_MATCH() { return 'Password does not match requirements: one lowercase, one uppercase, one number and one special character. 8 characters length' };
	static get PASSWORD_NOT_EQUAL() { return 'Passwords don\'t match' };
	static get USER_NOT_FOUND() { return 'User not found in the database' };
	
}