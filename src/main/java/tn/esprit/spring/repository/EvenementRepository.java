package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Evenement;
@Repository
public interface EvenementRepository extends CrudRepository <Evenement, Integer>{

}
