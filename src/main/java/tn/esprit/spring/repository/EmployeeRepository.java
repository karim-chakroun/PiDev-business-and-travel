package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//	@Query("SELECT e FROM Employee e JOIN Complains c ON e.idEmployee=c.employee.idEmployee ORDER BY c.SentimentType")
//	List<Employee> EmployeeBySentiment();
}
