package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
