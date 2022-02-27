package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.ParticipationProject;
import tn.esprit.spring.entities.Project;

public interface ProjectService {
	List<Project> retrieveAllProjects();

	void addProject(Project p, int idEntreprise);

	void deleteProject(int id);

	Project updateProject(Project p);

	Project retrieveProject(int id);
	int NbreIntervenant(int idProject);
	void AcceptAndAssignProjectToEmployees(int idProject, int idEmployee);
	void RecjectProject(int idp);
	void AddPrimeToEmployee(int ide);
	void updateNbreIntervenantProject();
	List<ParticipationProject> retrieveAllParticipations();
	// retouner l employee qui a participe le plus dans les projets
	List<Employee> getEmployeeStar();
	//choisir le meilleur employee pour un projet suivant la specialite et le nbre de projet 
	List<Employee> getEmployeeForProject(int idp);
	//void AssignEmployeeFiltree(int ide);
	
}