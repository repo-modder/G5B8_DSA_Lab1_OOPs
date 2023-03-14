package com.gl.itapp.service;

import com.gl.itapp.model.Employee;

public interface CredentialService {
	public String genrateEmailAddress(String firstName, String lastName, String deptName, String company);

	public String genrateCredentials(int maxLength);

	public void displayCredentials(Employee employee);
}
