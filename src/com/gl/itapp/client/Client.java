package com.gl.itapp.client;

import java.util.Scanner;

import com.gl.itapp.model.Employee;
import com.gl.itapp.service.CredentialService;
import com.gl.itapp.service.CredentialServceImpl;

public class Client {

	public static void main(String[] args) {
		
		String firstName = "Harshit";
		String lastName = "Kumar";
		
		Employee employee = new Employee(firstName, lastName);
		employee.setCompany("abc");
		
		CredentialService credentialService = new CredentialServceImpl();
		System.out.println("Please enter the department from the following ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			employee.setDepartment("tech");
			break;
		case 2:
			employee.setDepartment("adm");
			break;
		case 3:
			employee.setDepartment("hr");
			break;
		case 4:
			employee.setDepartment("legal");
			break;
		default: {
			System.err.println("Enter a valid option");
			System.exit(0);

		}
		}

		String generatedEmail = credentialService.genrateEmailAddress(employee.getFirstName().toLowerCase(),
				employee.getLastName().toLowerCase(), employee.getDepartment().toLowerCase(),employee.getCompany().toLowerCase());
		String generatedPassword = credentialService.genrateCredentials(12);
		
		employee.setEmail(generatedEmail);
		employee.setPassword(generatedPassword);
		
		credentialService.displayCredentials(employee);
		
	}
}
