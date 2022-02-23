package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "SELECT * FROM CLIENT WHERE  email = ?1", nativeQuery = true)
	public Client findByEmailAddress(String email);

	@Query(value = "SELECT * FROM CLIENT WHERE  nom = ?1", nativeQuery = true)
	public Client findByNom(String Nom);


}
