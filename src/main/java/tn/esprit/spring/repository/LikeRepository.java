package tn.esprit.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Like;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.likes;
//import tn.esprit.spring.entities.like;
@Repository
public interface LikeRepository extends CrudRepository <Like, Integer> {

	
	@Query(value ="SELECT posts_id_post FROM likes GROUP BY posts_id_post ORDER BY COUNT(likes.id) DESC LIMIT 1", nativeQuery = true)
	public int getPostsWithMostLikes();
	@Query(value ="SELECT * FROM likes GROUP BY posts_id_post ORDER BY COUNT(likes.id) DESC ", nativeQuery = true)
	public Set<likes> getListPostsWithMostLikes();
}
