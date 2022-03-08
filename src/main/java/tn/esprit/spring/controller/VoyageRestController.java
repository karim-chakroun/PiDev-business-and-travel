package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Participation;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.services.IVoyageService;

@RestController
@Api(tags = "Gestion des voyages")
@RequestMapping("/voyage")
public class VoyageRestController {

	@Autowired
	IVoyageService voyageService;
	
	// http://localhost:8089/SpringMVC/voyage/retrieve-all-voyages
		@ApiOperation(value = "Récupérer la liste des voyages")
		@GetMapping("/retrieve-all-voyages")
		public List<Voyage> getVoyage() {
			List<Voyage> listVoyage = voyageService.RetrieveAllVoyages();
			return listVoyage;
		}
		
    // http://localhost:8089/SpringMVC/voyage/add-voyage	
		@PostMapping("/add-voyage")
		public Voyage addVoyage(@RequestBody Voyage v) {
			return voyageService.addVoyage(v);
		}
		
		// http://localhost:8089/SpringMVC/voyage/remove-voyage/{voyage-id}
		@DeleteMapping("/remove-voyage/{voyage-id}")
		public void removeVoyage(@PathVariable("voyage-id") int voyageId) {
			voyageService.deleteVoyage(voyageId);
		}
		
		// http://localhost:8089/SpringMVC/voyage/modify-voyage
		@PutMapping("/modify-voyage")
		public Voyage modifyVoyage(@RequestBody Voyage voyage) {
			return voyageService.updateVoyage(voyage);
		}
		
		// http://localhost:8089/SpringMVC/voyage/retrieve-voyage/8
		@ApiOperation(value = "Récupérer une voyage par Id")
		@GetMapping("/retrieve-voyage/{voyage-id}")
		public Voyage retrieveVoyage(@PathVariable("voyage-id") int voyageId) {
			return voyageService.retrieveVoyage(voyageId);
		}
		// http://localhost:8089/SpringMVC/voyage/add-voyage	
				@PostMapping("/add-participation/{voyageId}/{employeeId}")
				public void addPartcipation(@PathVariable("voyageId") int voyageId,@PathVariable("employeeId") int employeeId) throws Exception {
					 voyageService.addParticipation(voyageId, employeeId);
				}
				
				@GetMapping("/retrieve-employeeaffectedbyentreprise/{entrepriseId}")
				public List<Employee> findEmployeeAffectedToVoyageByEntrepriseId(@PathVariable("entrepriseId") int entrepriseId ){
					return voyageService.findEmployeeAffectedToVoyageByEntrepriseId(entrepriseId);
				}
				@PostMapping("/add-vote/{voyageId}/{employeeId}/{note}")
				public void addVote(@PathVariable("voyageId") int voyageId,@PathVariable("employeeId") int employeeId,@PathVariable("note") int note)  {
					 voyageService.voterVoyage(voyageId, employeeId, note);
				}
				@GetMapping("/getMoyenneNote/{voyageId}")
				public Float getMoyenne(@PathVariable("voyageId") int voyageId ){
					return voyageService.getMoyenneVote(voyageId);
				}
						
}
