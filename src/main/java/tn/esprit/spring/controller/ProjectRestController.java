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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.services.EntrepriseService;
import tn.esprit.spring.services.IEmployeeService;
import tn.esprit.spring.services.ProjectService;

@RestController
@Api(tags = "Gestion des projects")
@RequestMapping("/project")
public class ProjectRestController {
	@Autowired
	ProjectService projectService;
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	IEmployeeService employeeService;
	// http://localhost:8089/SpringMVC/project/retrieve-all-project
		@ApiOperation(value = "Récupérer la liste des projects")
		@GetMapping("/retrieve-all-project")
		public List<Project> getProject() {
			List<Project> listProject= projectService.retrieveAllProjects();
			return listProject;
		}

		// http://localhost:8089/SpringMVC/project/retrieve-project/1
		@ApiOperation(value = "Récupérer un project par Id")
		@GetMapping("/retrieve-project/{project-id}")
//		@ApiResponses(value = {
//				@ApiResponse(code = 200, message = "Success|OK"),
//				@ApiResponse(code = 401, message = "Not Authorized!"),
//				@ApiResponse(code = 403, message = "Forbidden!"),
//				@ApiResponse(code = 404, message = "Not Found!") })
		public Project retrieveProject(@PathVariable("project-id") int projectId) {
			return projectService.retrieveProject(projectId);
		}

		@PostMapping("/add-project")
		public Project addProject(@RequestBody Project e) {
			return projectService.addProject(e);
		}

		// http://localhost:8089/SpringMVC/project/remove-project/1
		@DeleteMapping("/remove-project/{project-id}")
		public void removeProject(@PathVariable("project-id") int projectId) {
			projectService.deleteProject(projectId);
		}

		// http://localhost:8089/SpringMVC/project/modify-project
		@PutMapping("/modify-project")
		public Project modifyProject(@RequestBody Project p) {
			return projectService.updateProject(p);
		}
}
