package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Task;
import tn.esprit.spring.repository.CommentRepository;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository CommentRepository;
	@Override
	public List<Comment> retrieveAllComment() {
		// TODO Auto-generated method stub
		return  (List<Comment>) CommentRepository.findAll();
		}

	@Override
	public void addComment(Comment e) {
		// TODO Auto-generated method stub
		CommentRepository.save(e);
	}

	@Override
	public void deletePosts(int id) {
		
		CommentRepository.deleteById(id);
	}

	@Override
	public Comment updateComment(Comment e) {
		// TODO Auto-generated method stub
		return CommentRepository.save(e);
	}
	//@Override
	//public List<Comment> retrieveCooment(int id) {
		// TODO Auto-generated method stub
		//return (List<Comment>)CommentRepository.findAllById(id).get();

	@Override
	public List retrieveCooment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	//}

}
