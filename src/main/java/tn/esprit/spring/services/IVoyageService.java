package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Participation;
import tn.esprit.spring.entities.Voyage;

public interface IVoyageService {
	
	List<Voyage> RetrieveAllVoyages();
	
	Voyage addVoyage(Voyage v);
	
	void deleteVoyage(int id);
	
	Voyage updateVoyage(Voyage v);
	
	Voyage retrieveVoyage(int id);
	
	Participation addParticipation(int voyageId, int employeeId) throws Exception;
	
	List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(int entrepriseId);

}
