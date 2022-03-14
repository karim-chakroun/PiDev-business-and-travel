package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.likes;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.LikeRepository;
//import tn.esprit.spring.repository.likesRepository;
//import tn.esprit.spring.repository.likesRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	PostRepository postRepository;
	@Autowired
	LikeRepository likesRepository;
	@Autowired
	EmployeeRepository emRepository;
	@Override
	public List<likes> retrieveAllRates() {
		// TODO Auto-generated method stub
		return  (List<likes>) likesRepository.findAll();
	}

	@Override
	public likes addRate(likes e,int id,int iduser) {
		Post p = postRepository.findById(id).orElse(null);
		Employee c=emRepository.findById(iduser).orElse(null);
		//p.getComments().add(e);
		e.setPosts(p);
		e.setEmployees(c);
		likesRepository.save(e);
		return null;
	}

	@Override
	public void deletePosts(int id) {
		// TODO Auto-generated method stub
		likesRepository.deleteById(id);
		
	}

	@Override
	public likes updateComment(likes e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Post retrievePostWithMostlikess() {
		 int idpost= likesRepository.getPostsWithMostLikes();
		return postRepository.findById(idpost).get();
		
	}

	@Override
	public List<likes> retrieveListPostWithMostlikess() {
		
		return (List<likes>) likesRepository.getListPostsWithMostLikes();	
			
	}
		}

