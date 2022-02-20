package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Integer> {
		//@Query("Select COUNT(*) FROM Client c where c.genre = :genre")
	//int nbreByGenre(@Param("genre") Genre genre);

}
