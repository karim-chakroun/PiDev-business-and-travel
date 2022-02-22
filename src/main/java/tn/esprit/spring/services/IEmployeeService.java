package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employee;

public interface IEmployeeService {

	
	Employee findEmployee(Long id);
}
