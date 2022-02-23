package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.services.PostsService;

@RestController
@Api(tags = "Gestion des post")
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	PostsService postxervice;
	
	@GetMapping("/retrive-posts")
	public List<Post> getEmployees() {
		List<Post> listPost = postxervice.retrieveAllPosts();
		return listPost;
	}
	@DeleteMapping("/remove-post/{employee-id}")
	public void removeEmployee(@PathVariable("employee-id") int employeeId) {
		postxervice.deletePosts(employeeId);
	}
		@PostMapping("/add-post")
		public void AddPost(@RequestBody Post p)
		{
			postxervice.addPosts(p);
		}
		
	}
	
	


