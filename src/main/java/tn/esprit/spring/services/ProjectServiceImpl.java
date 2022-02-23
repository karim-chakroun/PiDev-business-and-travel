package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Project;
import tn.esprit.spring.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
@Autowired
ProjectRepository projectRepository;
	@Override
	public List<Project> retrieveAllProjects() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Project addProject(Project p) {
		// TODO Auto-generated method stub
		//p.setEtat(Etat.pending);
		return projectRepository.save(p);
	}

	@Override
	public void deleteProject(int id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	@Override
	public Project updateProject(Project p) {
		// TODO Auto-generated method stub
		//int idProject=p.getIdProject();
		//p.setIntervenant(projectRepository.getNbreIntervenant(idProject));
		return projectRepository.save(p);
	}

	@Override
	public Project retrieveProject(int id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}

	@Override
	public int NbreIntervenant(int idProject) {
		// TODO Auto-generated method stub

		return projectRepository.getNbreIntervenant(idProject);
		}

}
