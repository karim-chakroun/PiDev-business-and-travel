package tn.esprit.spring.services;


import java.util.List;
import tn.esprit.spring.entities.Complain;

public interface IComplainService {
	
	 Complain addComplain(Complain c,Integer emp_id );
	 Complain editComplain(Complain c, Integer id);
	 void deleteComplain(Integer id);
	 List<Complain> getAllComplains();
	 Complain getComplain(Integer id);
}
