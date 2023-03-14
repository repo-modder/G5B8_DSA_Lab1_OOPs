package com.gl.itapp.service;

import com.gl.itapp.model.Employee;

import java.lang.Math;
import java.util.Random;

public class CredentialServceImpl implements CredentialService {

	private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBER = "0123456789";
	private static final String SPECIAL_CHARS = "!@#$%^&*()_";
	
	private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHARS;
    private static final Random random = new Random();

	@Override
	public String genrateEmailAddress(String firstName, String lastName, String deptName, String company) {
		return firstName + lastName + "@" + deptName + "."+company+".com";
	}

	@Override
	public String genrateCredentials(int maxLength) {
	
		StringBuilder passwordBuilder = new StringBuilder(maxLength);
		//atleast one lower case
		passwordBuilder.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));
        
        //atleast one upper case
        passwordBuilder.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));
        
        //atleast one number case
        passwordBuilder.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
        
        //atleast one special character case
        passwordBuilder.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        
        //fill the rest of the password with random characters
        for(int i = 4; i < maxLength; i++ ){
        	passwordBuilder.append(PASSWORD_ALLOW_BASE.charAt(random.nextInt(PASSWORD_ALLOW_BASE.length())));
        }

        //shuffle the characters in the password
        char[] passwordChars = passwordBuilder.toString().toCharArray();
        for (int i = 0; i < passwordChars.length; i++) {
        	
        	int j = random.nextInt(passwordChars.length);
        	char temp = passwordChars[j];
        	passwordChars[j] = passwordChars[i];
        	passwordChars[i] = temp;
        }
        
        return new String(passwordChars);
	}

	@Override
	public void displayCredentials(Employee employee) {
		System.out.printf("Dear %s your generated credentials are as follows\n", employee.getFirstName());
		System.out.printf("Email\t---> %s\n", employee.getEmail());
		System.out.printf("Password---> %s\n", employee.getPassword());
	}
	
}
