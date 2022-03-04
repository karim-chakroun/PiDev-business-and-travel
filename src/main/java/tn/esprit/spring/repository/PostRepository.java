package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.employedto;
@Repository
public interface PostRepository extends CrudRepository <Post, Integer> {


	@Query(value = "SELECT employees_id_employee FROM post GROUP BY employees_id_employee ORDER BY COUNT(id_post) DESC LIMIT 1", nativeQuery = true)
	public int getEmployeWithMostPosts();
	@Query(value = "SELECT employees_id_employee FROM post GROUP BY employees_id_employee ORDER BY COUNT(id_post) DESC ", nativeQuery = true)
	public int getListEmployeWithMostPosts();
	
}
