package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Evenement;
import tn.esprit.spring.entities.ParticipationEvenement;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.EvenementRepository;
import tn.esprit.spring.repository.ParticipationEvenementRepository;
@Service
public class EvenementServiceImpl implements EvenementService {
	@Autowired
	EvenementRepository evenementRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	ParticipationEvenementRepository participationEvenementRepository;
		@Override
		public List<Evenement> retrieveAllEvenements() {
			// TODO Auto-generated method stub
			return (List<Evenement>) evenementRepository.findAll() ;
		}

		@Override
		public Evenement addEvenement(Evenement e) {
			// TODO Auto-generated method stub
			return evenementRepository.save(e);
		}

		@Override
		public void deleteEvenement(int id) {
			// TODO Auto-generated method stub
			evenementRepository.deleteById(id);
		}

		@Override
		public Evenement updateEvenement(Evenement e) {
			// TODO Auto-generated method stub
			return evenementRepository.save(e);
		}

		@Override
		public Evenement retrieveEvenement(int id) {
			// TODO Auto-generated method stub
			return evenementRepository.findById(id).get();
		}

		@Override
		public void AssignEntrepriseToEvenement(int ide, int idevenement) {
			// TODO Auto-generated method stub
			Entreprise e= entrepriseRepository.findById(ide).orElse(null);
			Evenement evenement= evenementRepository.findById(idevenement).orElse(null);
			ParticipationEvenement pe= new ParticipationEvenement();
			pe.setEvenements(evenement);
			pe.setEntreprises(e);
                participationEvenementRepository.save(pe);
		}

}
