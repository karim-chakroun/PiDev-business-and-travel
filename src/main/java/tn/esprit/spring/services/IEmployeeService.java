package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Employee;

public interface IEmployeeService {
	List<Employee> retrieveAllEmployees();

	Employee addEmployee(Employee e);

	void deleteEmployee(int id);

	Employee updateEmployee(Employee e);

	Employee retrieveEmployee(int id);

}
