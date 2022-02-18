package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired
EmployeeRepository employeeRepository;
	@Override
	public List<Employee> retrieveAllEmployees() {
		// TODO Auto-generated method stub
		return  (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}

	@Override
	public Employee retrieveEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

}
