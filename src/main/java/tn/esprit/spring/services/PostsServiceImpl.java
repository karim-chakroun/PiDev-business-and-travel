package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.BadWords;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.BadWordsRepo;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.LikeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class PostsServiceImpl implements PostsService {
	@Autowired
	PostRepository postRepository;
	@Autowired
	EmployeeRepository emRepository;
	@Autowired
	BadWordsRepo badwords;
	@Autowired
	LikeRepository LikeRepository;
	//@Override

	@Override
	public List<Post> retrieveAllPosts() {
		 List<Post>listpost= (List<Post>) postRepository.findAll();
		 return listpost; 
		
	}

	@Override
	public void addPosts(Post e,int idUser) {
		
		//e.setDatePost(now);
Employee employee=emRepository.findById(idUser).get();
	String Body = e.getBody();
	String titre=e.getTitre();
	List<BadWords> BadWordss = (List<BadWords>) badwords.findAll();

	boolean checkBody = checkBadWords(BadWordss,Body);
	boolean checkTitle = checkBadWords(BadWordss,titre);
	if(checkBody == true || checkTitle == true)
	{
		System.out.print("Offensive language detected, publication failed.");
	}else if (checkBody == false || checkTitle== false ) {
	
	e.setEmployees(employee);
		 postRepository.save(e);}
	}

	@Override
	public void deletePosts(int id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

	@Override
	public Post updatePosts(Post e,int idpost,int idEmp) {
		Employee client=emRepository.findById(idEmp).get();
		String Body = e.getBody();
		String titre=e.getTitre();
		List<BadWords> BadWordss = (List<BadWords>) badwords.findAll();

		boolean checkBody = checkBadWords(BadWordss,Body);
		boolean checkTitle = checkBadWords(BadWordss,titre);
		if(checkBody == true || checkTitle == true)
		{
			System.out.print("Offensive language detected, publication failed.");
		}else if (checkBody == false && checkTitle== false ) 
		e.setIdPost(idpost);
		return postRepository.save(e);
	}

	@Override
	public Post retrievePosts(int id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).get();
	}
	public boolean checkBadWords(List<BadWords> words, String message) 
	{
		
		int iterator=0;
		for(int i=0 ; i<words.size(); i++)
		{
			if (message.contains(words.get(i).getNom()))
			{
				iterator++; 
			}
		}
		if (iterator>0)
		{
			
			System.out.print("Your review contains offensive language, "+iterator+" inappropriate words found.");
			return true;
		}
		System.out.print("Your review is clean, valid and ready for publication.");
			return false;	
	}

	@Override
	public Employee retrieveBestPosts() {
		 int idEmploye = postRepository.getEmployeWithMostPosts();
		return emRepository.findById(idEmploye).get();
		
	}
	@Override
	public Post retrieveBestPosts1() {
		 int idpost = LikeRepository.getPostsWithMostLikes();
		return postRepository.findById(idpost).get();
		
	}
	
}
