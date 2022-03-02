package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Complain;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Response;
import tn.esprit.spring.entities.Result;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.ResultRepository;

@Service
@Slf4j
public class QuizServiceImpl implements IQuizService {
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ResultRepository resultRepository;
	
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

	@Override
	public void assignQuestionToQuizById(Integer Idquestion, Integer Quizid) {
		Quiz quiz=quizRepository.findById(Quizid).get();
		Question question = questionRepository.findById(Idquestion).get();
		question.setQuizs(quiz);
		questionRepository.save(question);
		
		
		
		
	}

	@Override
	public void assignQuestionToQuizByBody(Integer Idquestion, Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quiz makeQuizaumatique(Integer Id) {
		Quiz quiz=quizRepository.findById(Id).get();
		List<Question> ques= (List<Question>) questionRepository.findAll();
		List<Question> specif1 = (List<Question>) new ArrayList<Question>();
		for (Question question : ques) {
			if(question.getQuizs().getIdQuiz()==Id)
			{
				specif1.add(question);
				
			}
		}
		Set<Question> specif = (Set<Question>) new HashSet<Question>();
		Random random=new Random();	
		for(int i=0;i<3;i++)
		{
			int rand=random.nextInt(specif1.size());
			specif.add(specif1.get(rand));
			specif1.remove(rand);
		}
		quiz.setQuestions(specif);		
		return quiz;
	}

	@Override
	public int getResult(Quiz q,Integer Id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepository.findById(Id).get();
		Date now = new Date();
		int result=0;
		for (Question question : q.getQuestions()) {
			for (Response response : question.getResponses()) {
				if(response.isCorrect()==true)
				{
					result++;
				}
				
			}
		}
		Result res=new Result();
		res.setEmployee(emp);
		res.setQuiz(q);
		res.setCreationdate(now);
		res.setScore(result);
		resultRepository.save(res);
		return result;
	}

}
