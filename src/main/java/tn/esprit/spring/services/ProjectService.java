package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Project;

public interface ProjectService {
	List<Project> retrieveAllProjects();

	Project addProject(Project p);

	void deleteProject(int id);

	Project updateProject(Project p);

	Project retrieveProject(int id);
	int NbreIntervenant(int idProject);
}
