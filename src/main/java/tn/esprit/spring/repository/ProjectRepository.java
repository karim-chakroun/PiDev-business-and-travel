package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>{

}
