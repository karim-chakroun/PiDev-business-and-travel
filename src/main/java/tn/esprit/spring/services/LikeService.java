package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Like;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.likes;

public interface LikeService {
	List<Like> retrieveAllRates();

	Like addRate(Like e);

	void deletePosts(int id);

	Like updateComment(Like e);

	Post retrievePostWithMostLikes();
	List<likes> retrieveListPostWithMostLikes();


}
