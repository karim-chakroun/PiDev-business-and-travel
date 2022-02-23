package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>{
	@Query(value="select  COUNT(employees_id_employee)  from participation_project p where p.projects_id_project=:idProject ",nativeQuery = true)

	int getNbreIntervenant(@Param("idProject") int idProject);

}
