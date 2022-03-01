package tn.esprit.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Participation;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.ParticipationRepository;
import tn.esprit.spring.repository.VoyageRepository;

@Service
@Slf4j
public class VoyageServiceImpl implements IVoyageService{
	
	@Autowired
	VoyageRepository voyageRepository;
	@Autowired
	ParticipationRepository participationRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Override
	public List<Voyage> RetrieveAllVoyages() {
	   List<Voyage> listVoyage= voyageRepository.findAll();
	   for(Voyage v:listVoyage)
	  {
		log.info("Voyage:" + v.getDepVille()+ v.getDesVille());
	  }
	  return listVoyage;
	}

	@Override
	public Voyage addVoyage(Voyage v) {
		voyageRepository.save(v);
		return v;
	}

	@Override
	public void deleteVoyage(int id) {
		voyageRepository.deleteById(id);
		
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
		voyageRepository.save(v);
		return v;
	}

	@Override
	public Voyage retrieveVoyage(int id) {
		Voyage v= voyageRepository.findById(id).orElseThrow(()->new IllegalArgumentException("no voyage with id ="+id));
		return v;
	}

	@Override
	public Participation addParticipation(int voyageId, int employeeId) throws Exception {
		Voyage v= voyageRepository.findById(voyageId).orElseThrow(()->new IllegalArgumentException("no voyage with id ="+voyageId));
		Employee e= employeeRepository.findById(employeeId).orElseThrow(()->new IllegalArgumentException("no employee with id="+employeeId));
		List<Participation> listOfParticipation=e.getParticipation().stream().filter(p->{
			if(p.getVoyages().getDateRetour().before(v.getDateDep()) ||  p.getVoyages().getDateDep().after(v.getDateRetour())){
				return false;
			}
			return true;
		}).collect(Collectors.toList());
		if(listOfParticipation.size()>0){
			throw new Exception("Employe posséde un voyage déja");
		}
		Participation participation = new Participation();
		participation.setEmployees(e);
		participation.setVoyages(v);
		return participationRepository.save(participation);
	}

	@Override
	public List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(int entrepriseId) {
		Entreprise entreprise=entrepriseRepository.findById(entrepriseId).orElseThrow(()->new IllegalArgumentException("No entreprise found with id = "+entrepriseId));
		return entreprise.getEmployees().stream().filter(e->
			 e.getParticipation().size()>0
		).collect(Collectors.toList());
	}

	
}
