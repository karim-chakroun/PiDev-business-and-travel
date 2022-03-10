package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{
@Autowired
EntrepriseRepository entrepriseRepository;
	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		// TODO Auto-generated method stub
		return (List<Entreprise>) entrepriseRepository.findAll() ;
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		// TODO Auto-generated method stub
		return entrepriseRepository.save(e);
	}

	@Override
	public void deleteEntreprise(int id) {
		// TODO Auto-generated method stub
		entrepriseRepository.deleteById(id);
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		// TODO Auto-generated method stub
		return entrepriseRepository.save(e);
	}

	@Override
	public Entreprise retrieveEntreprise(int id) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findById(id).get();
	}

}
