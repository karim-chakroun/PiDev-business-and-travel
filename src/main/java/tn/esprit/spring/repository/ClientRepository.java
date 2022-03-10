package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Role;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "SELECT * FROM CLIENT WHERE  email = ?1", nativeQuery = true)
	public Client findByEmailAddress(String email);

	@Query(value = "SELECT * FROM CLIENT WHERE  nom = ?1", nativeQuery = true)
	public Client findByNom(String Nom);

	@Query(value = "SELECT r.roles FROM Role r INNER JOIN Client c ON r.id_role=c.rolee_id_role WHERE  c.email = ?1", nativeQuery = true)
	public String findRoleClientByEmail(String email);

}
