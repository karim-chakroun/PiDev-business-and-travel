package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseService {
	List<Entreprise> retrieveAllEntreprises();

	Entreprise addEntreprise(Entreprise e);

	void deleteEntreprise(int id);

	Entreprise updateEntreprise(Entreprise e);

	Entreprise retrieveEntreprise(int id);

}
