package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;

public interface PostsService {
	List<Post> retrieveAllPosts();

	void addPosts(Post e);

	void deletePosts(int id);

	Post updatePosts(Post e);

	Post retrievePosts(int id);

}
