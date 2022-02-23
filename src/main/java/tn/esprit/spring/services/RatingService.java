package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Rating;

public interface RatingService {
	List<Rating> retrieveAllRates();

	Rating addRate(Rating e);

	void deletePosts(int id);

	Rating updateComment(Rating e);


}
