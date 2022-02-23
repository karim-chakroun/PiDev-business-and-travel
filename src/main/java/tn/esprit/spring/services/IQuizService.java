package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Quiz;

public interface IQuizService {

	Quiz addQuiz(Quiz q,Integer Id);
	Quiz ModifyQuiz(Quiz q,Integer Id);
	Quiz FindQuiz(Integer Id);
	List<Quiz> GetAllQuizs();
	void deleteQuiz(Integer Id);
	
}
