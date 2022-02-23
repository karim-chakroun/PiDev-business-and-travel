package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Complain;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.QuizRepository;

@Service
@Slf4j
public class QuizServiceImpl implements IQuizService {
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;

	@Override
	public Quiz addQuiz(Quiz q, Integer Id) {
		// TODO Auto-generated method stub
		q.setEntreprises(entrepriseRepository.findById(Id).get());
		quizRepository.save(q);
		return q;
		
	}

	@Override
	public Quiz ModifyQuiz(Quiz q, Integer Id) {
		// TODO Auto-generated method stub
		q.setEntreprises(entrepriseRepository.findById(Id).get());
		quizRepository.save(q);
		return q;
	}

	@Override
	public Quiz FindQuiz(Integer Id) {
		// TODO Auto-generated method stub
		return quizRepository.findById(Id).get();
	}

	@Override
	public List<Quiz> GetAllQuizs() {
		List<Quiz> lco = (List<Quiz>) quizRepository.findAll();
		 for (Quiz quiz : lco) {
			log.info("this is the quiz ");
		}
		 return lco;
		
	}

	@Override
	public void deleteQuiz(Integer Id) {
		quizRepository.deleteById(Id);
		log.info("delete with success");
		
	}

}
