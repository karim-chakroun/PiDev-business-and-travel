package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Like;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.likes;
import tn.esprit.spring.repository.LikeRepository;
//import tn.esprit.spring.repository.likeRepository;
//import tn.esprit.spring.repository.LikeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	PostRepository postRepository;
	@Autowired
	LikeRepository likeRepository;
	@Override
	public List<Like> retrieveAllRates() {
		// TODO Auto-generated method stub
		return  (List<Like>) likeRepository.findAll();
	}

	@Override
	public Like addRate(Like e) {
		likeRepository.save(e);
		return null;
	}

	@Override
	public void deletePosts(int id) {
		// TODO Auto-generated method stub
		likeRepository.deleteById(id);
		
	}

	@Override
	public Like updateComment(Like e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Post retrievePostWithMostLikes() {
		 int idpost = likeRepository.getPostsWithMostLikes();
		return postRepository.findById(idpost).get();
		
	}

	@Override
	public List<likes> retrieveListPostWithMostLikes() {
		
		return (List<likes>) likeRepository.getListPostsWithMostLikes();
		
		
			
	}
		}


