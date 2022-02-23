package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository <Task,Integer>{

}
