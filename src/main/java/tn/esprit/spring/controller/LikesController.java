package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.likes;
import tn.esprit.spring.services.LikeService;
import tn.esprit.spring.services.PostsService;

@RestController
@Api(tags = "Gestion des like")
@RequestMapping("/like")
public class LikesController {
	@Autowired
	PostsService postxervice;
	@Autowired
	LikeService likesservice;
	@GetMapping("/retrive-Posts-with-most-likes")
	public Post getMostPosts() {
		Post post =likesservice.retrievePostWithMostLikes() ;
		return post;
	
}
	@GetMapping("/retrive-list-Posts-with-most-likes")
	public List<likes> getMostLikesPosts() {
		List<likes> post =likesservice.retrieveListPostWithMostLikes() ;
		return post;
	
}
	

}
