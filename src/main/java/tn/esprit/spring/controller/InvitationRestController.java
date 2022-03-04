package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.Parser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.services.IInvitationService;
import tn.esprit.spring.utils.xlsParser;

@RestController
@Api(tags = "Gestion des invitation")
@RequestMapping("/Invitation")
public class InvitationRestController {
	
	List<Invitation> parser = new  xlsParser().parser();
	
	
	@Autowired
	IInvitationService invitationService;
	
	@PostMapping("/add-Invitations")
	public void ajouterListeInvitations(@RequestBody List<Invitation> inv){
		invitationService.addInvitation(inv);
	}
	
	@PostMapping("/add-InvitationsExcel")
	public void ajouterListeInvitationsFromExcel(){
		invitationService.addInvitation(parser);
	}
	
	@ApiOperation(value = "Récupérer invitation")
	@GetMapping("/retrieve-invitation/{inv-id}")
	public Invitation retrieveInvitation(@PathVariable("inv-id") int invId) {
		xlsParser xls = new xlsParser();
		xls.parser();
		System.out.println("xlssss test test"+ xlsParser.nbrows);
		return invitationService.retrieveInvitation(invId);
	}

}
