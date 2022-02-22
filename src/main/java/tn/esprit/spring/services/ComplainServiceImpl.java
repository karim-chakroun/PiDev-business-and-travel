package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Complain;
import tn.esprit.spring.repository.ComplainRepository;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
@Slf4j

public class ComplainServiceImpl implements IComplainService {

	@Autowired
	ComplainRepository coRepository;
	@Autowired
	EmployeeRepository emRepository;
	
	
	@Override
	public Complain addComplain(Complain c , Integer  emp_id) {
		Date now = new Date();
	    c.setDateComplain(now);
	    c.setEmployees(emRepository.findById(emp_id).get());
		coRepository.save(c);
		return c;
	}

	@Override
	public Complain editComplain(Complain c, Integer id) {
		// TODO Auto-generated method stub
	    
		coRepository.save(c);
		return c;
	}

	@Override
	public void deleteComplain(Integer id) {
		coRepository.deleteById(id);
		
	}

	@Override
	public List<Complain> getAllComplains() {
		// TODO Auto-generated method stub
		 List<Complain> lco = (List<Complain>) coRepository.findAll();
		 for (Complain complain : lco) {
			log.info("this is the body: "+complain.getBody());
		}
		 return lco;
	}

	@Override
	public Complain getComplain(Integer id) {
		// TODO Auto-generated method stub
		return coRepository.findById(id).get();
	}

}
