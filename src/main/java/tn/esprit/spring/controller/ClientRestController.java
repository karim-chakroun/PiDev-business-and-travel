package tn.esprit.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.utils.JwtUtil;

import tn.esprit.spring.reponse.ResponseHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.InvitationRepository;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.services.IInvitationService;
@RestController
@Api(tags = "Gestion des clients")
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	IClientService clientService;
	//test
	@Autowired
	IInvitationService invitationService;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepo;
	
	@Autowired
	InvitationRepository invitationRepo;
	
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	Client client;

	
	
	
	
	@GetMapping("/admin")
	public String homeAdmin() {

		return "This is admin page";
	}
	@GetMapping("/user")
	public String homeUser() {
		return "This is user page";
	}
	@GetMapping("/employee")
	public String homeEmployee() {
		return "This is employee page";
	}
	@GetMapping("/entreprise")
	public String homeEntreprise() {
		return "This is entreprise page";
	}


	// http://localhost:8082/SpringMVC/servlet/retrieve-all-clients
	@GetMapping("admin/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {

		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/profile")
	@ResponseBody
	public Client userProfile(HttpServletRequest request) {

		final  String authorizationHeader = request.getHeader("Authorization");

		String jwt = authorizationHeader.substring(7);
		Object email = jwtUtil.extractUsername(jwt);

		client = clientRepository.findByEmailAddress(String.valueOf(email));

		System.out.println(client);
		return client;


	}

	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@ApiOperation(value = "Récupérer un client par Id")
	@GetMapping("/retrieve-client/{client-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
	}
	
	@ApiOperation(value = "forgetPassword")
	@GetMapping("/forgetPassword/{email}")

	public void ResetPassword(@PathVariable("email") String email) {
		 clientService.forgetPassword(email);
	}

	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<Object> addClient(@RequestBody Client c,HttpServletRequest request) {
		
		Entreprise e = new Entreprise();

		Client client1 = clientRepository.findByEmailAddress(c.getEmail());
		if (client1 == null) {
			System.out.println("test1");
			c.setPassword(passwordEncoder.encode(c.getPassword()));
			c.setEnabled(true);
			c.setRole("ROLE_ENTREPRISE");
			
			Client client = clientService.addClient(c);
			
			//set entreprise
			e.setEmail(c.getEmail());
			e.setNomEntreprise(c.getNom());
			entrepriseRepo.save(e);
			
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, client);

		} else {
			System.out.println("test2");
			//throw new IllegalArgumentException("Mail alreasy exists");
			return ResponseHandler.generateResponse("Mail already exists", HttpStatus.MULTI_STATUS, "Mail already exists");
		}
	}
	
	
	@PostMapping("/registerEmp/{inv-id}")
	@ResponseBody
	public ResponseEntity<Object> addClientEmp(@RequestBody Client c,@PathVariable("inv-id") int invId,HttpServletRequest request) {

		Client client1 = clientRepository.findByEmailAddress(c.getEmail());
		Invitation inv = invitationRepo.findById(invId).orElse(null);
		if(inv.getStatus().equalsIgnoreCase("true")) {
			
			if (client1 == null) {
				System.out.println("test1");
				c.setPassword(passwordEncoder.encode(c.getPassword()));
				c.setEnabled(true);
				c.setRole("ROLE_EMPLOYEE");
				Client client = clientService.addClient(c);
				return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, client);

			} else {
				System.out.println("test2");
				//throw new IllegalArgumentException("Mail alreasy exists");
				return ResponseHandler.generateResponse("Mail already exists", HttpStatus.MULTI_STATUS, "Mail already exists");
			}
			
		}
		else {
			return ResponseHandler.generateResponse("you must accept the invitation", HttpStatus.MULTI_STATUS, "you dont have invitation");
			
		}
		
		
		
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client/{client-id}")
	public Client modifyClient(@PathVariable("client-id") Long clientId,@RequestBody Client client) {
		return clientService.updateClient(clientId,client);
	}


}