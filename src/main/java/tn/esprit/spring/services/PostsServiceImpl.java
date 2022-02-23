package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class PostsServiceImpl implements PostsService {
	@Autowired
	PostRepository postRepository;
	//@Override

	@Override
	public List<Post> retrieveAllPosts() {
		 List<Post>listpost= (List<Post>) postRepository.findAll();
		 return listpost; 
		
	}

	@Override
	public void addPosts(Post e) {
		 postRepository.save(e);
	}

	@Override
	public void deletePosts(int id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

	@Override
	public Post updatePosts(Post e) {
		return postRepository.save(e);
	}

	@Override
	public Post retrievePosts(int id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).get();
	}
	
}
