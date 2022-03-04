package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Invitation;


public interface IInvitationService {
	
	List<Invitation> retrieveAllInvitations();

	void addInvitation(List<Invitation> c);

	void deleteInvitation(int id);

	Invitation updateInvitation(Invitation c);

	Invitation retrieveInvitation(int id);

}
