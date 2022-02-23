package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Complain;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;

@Service
@Slf4j
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	QuizRepository quizRepository;
	
	@Override
	public Question addQuestion(Question back, Integer quiz_id) {
		// TODO Auto-generated method stub
		
		back.setQuizs(quizRepository.findById(quiz_id).get());
		questionRepository.save(back);
		return back;
	}

	@Override
	public Question modifyQuestion(Question back) {
		// TODO Auto-generated method stub
		questionRepository.save(back);
		return back;
	}

	@Override
	public Question findQuestion(Integer back) {
		// TODO Auto-generated method stub
		return questionRepository.findById(back).get();
	}

	@Override
	public List<Question> ListQuestions() {
		// TODO Auto-generated method stub
		 List<Question> lco = (List<Question>) questionRepository.findAll();
		 for (Question question : lco) {
			log.info("this is the body: "+question.getQuestiontext());
		}
		 return lco;
	}

	@Override
	public void deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		questionRepository.deleteById(id);
	}

}
