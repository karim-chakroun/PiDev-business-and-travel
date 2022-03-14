package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Task;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository CommentRepository;
	@Autowired
	EmployeeRepository emRepository;
	@Autowired
	PostRepository postRepository;
	@Override
	public List<Comment> retrieveAllComment() {
		// TODO Auto-generated method stub
		return  (List<Comment>) CommentRepository.findAll();
		}

	@Override
	public void addComment1(Comment e) {
		// TODO Auto-generated method stub
		//Date now = new Date();
		//e.setDateComment(now);
		//e.setEmployees(emRepository.findById(idPost).get());
		CommentRepository.save(e);
	}

	@Override
	public void deletePosts(int id) {
		
		CommentRepository.deleteById(id);
	}

	@Override
	public void updateComment(Comment e,int id) {
		// TODO Auto-generated method stub
		
		e.setIdComment(id);
		CommentRepository.save(e);
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

	@Override
	
	public void addComment(Comment e,int idpost,int iduser) {
		// TODO Auto-generated method stub
		//Date now = new Date();
		//e.setDateComment(now);
		Post p = postRepository.findById(idpost).orElse(null);
		Employee c=emRepository.findById(iduser).orElse(null);
		//p.getComments().add(e);
		e.setPosts(p);
		e.setEmployees(c);
		CommentRepository.save(e);
		
	}

	//}

}
