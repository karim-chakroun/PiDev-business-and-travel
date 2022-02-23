package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;

public interface CommentService {
	List<Comment> retrieveAllComment();

	void addComment(Comment e);

	void deletePosts(int id);

	Comment updateComment(Comment e);
	public List retrieveCooment(int id) ;

	
}
