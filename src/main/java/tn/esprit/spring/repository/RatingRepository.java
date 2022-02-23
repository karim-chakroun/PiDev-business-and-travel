package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Rating;

public interface RatingRepository extends CrudRepository <Rating, Integer> {

}
