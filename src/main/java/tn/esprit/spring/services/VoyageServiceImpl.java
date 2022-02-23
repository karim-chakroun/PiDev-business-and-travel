package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;

@Service
@Slf4j
public class VoyageServiceImpl implements IVoyageService{
	
	@Autowired
	VoyageRepository voyageRepository;
	
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
		Voyage v= voyageRepository.findById(id).get();
		return v;
	}

	
}
