package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Result;

public interface IResultService {
	List<Result> GetAllResults();
}
