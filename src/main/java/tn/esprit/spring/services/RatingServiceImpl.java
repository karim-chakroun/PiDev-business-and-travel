package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Rating;
import tn.esprit.spring.repository.RatingRepository;

public class RatingServiceImpl implements RatingService{
	RatingRepository ratingRepository;
	@Override
	public List<Rating> retrieveAllRates() {
		// TODO Auto-generated method stub
		return  (List<Rating>) ratingRepository.findAll();
	}

	@Override
	public Rating addRate(Rating e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePosts(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rating updateComment(Rating e) {
		// TODO Auto-generated method stub
		return null;
	}

}
