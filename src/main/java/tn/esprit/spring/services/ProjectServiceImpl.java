package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.ParticipationProject;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.entities.Task;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.ParticipationProjectRepository;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.repository.TaskRepository;
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService{
@Autowired
ProjectRepository projectRepository;
@Autowired
EmployeeRepository employeeRepository;
@Autowired
ParticipationProjectRepository participationProjectRepository;
@Autowired
TaskRepository taskRepository;
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

	@Override
	public void AcceptAndAssignProjectToEmployees(int idProject, int idEmployee) {
		// TODO Auto-generated method stub
	Project p= projectRepository.findById(idProject).orElse(null);
		//p.setEtat(Etat.todo);
		Employee e = employeeRepository.findById(idEmployee).orElse(null);
		ParticipationProject pp= new ParticipationProject();
		//pp.setEmployees(e);
		//pp.setProjects(p);
	
		if(participationProjectRepository.nbrParticip(idProject, idEmployee)>1 )
				//log.info("la participation existe");
		//else	
			participationProjectRepository.save(pp);
		//else
	

		//e.getParticipationProjects().add(pp);
	
	
	
		
	}

	@Override
	public void RecjectProject(int idp) {
		// TODO Auto-generated method stub
		Project p= projectRepository.findById(idp).orElse(null);
		
			//p.setEtat(Etat.rejected);
			projectRepository.save(p);
		
		
	}

	@Override
	public void AddPrimeToEmployee(int ide) {
		// TODO Auto-generated method stub
		Employee e= employeeRepository.findById(ide).orElse(null);
		
		int participation= participationProjectRepository.nbreParticipationOfEmployee(ide);
		//float prime= e.getPrime();
		//e.setPrime(prime+100*participation);
		employeeRepository.save(e);	}

	@Override
	public void updateProject(int idp) {
		// TODO Auto-generated method stub
		
	}

	



}
