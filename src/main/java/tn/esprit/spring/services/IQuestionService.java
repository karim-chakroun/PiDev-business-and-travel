package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Question;

public interface IQuestionService {
	Question addQuestion(Question back,  Integer  emp_id);
	Question modifyQuestion(Question back);
	Question findQuestion(Integer back);
	List<Question> ListQuestions();
	void deleteQuestion(Integer id);
}
