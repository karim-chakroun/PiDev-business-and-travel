package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.ParticipationProject;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.ParticipationProjectRepository;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.repository.TaskRepository;
@Slf4j
@Service
@EnableScheduling
public class ProjectServiceImpl implements ProjectService{
@Autowired
ProjectRepository projectRepository;
@Autowired
EmployeeRepository employeeRepository;
@Autowired
ParticipationProjectRepository participationProjectRepository;
@Autowired
TaskRepository taskRepository;
@Autowired
IEmployeeService employeeService;
@Autowired
EntrepriseRepository entrepriseRepository;
	@Override
	public List<Project> retrieveAllProjects() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public void addProject(Project p, int idEntreprise) {
		// TODO Auto-generated method stub
		//p.setEtat(Etat.pending);
		Entreprise entreprise= entrepriseRepository.findById(idEntreprise).orElse(null);
		if(p.getDateDebut().before(p.getDateFin()))
		{p.setEntreprises(entreprise);
			projectRepository.save(p);
		}
		else log.info("la date finale est avantla date debut ");
		
	}

	@Override
	public void deleteProject(int id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	@Override
	public Project updateProject(Project p) {
		// TODO Auto-generated method stub
	//	int idProject=p.getIdProject();
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
		p.setEtat(Etat.todo);
		Employee e = employeeRepository.findById(idEmployee).orElse(null);
		ParticipationProject pp= new ParticipationProject();
		
		pp.setEmployees(e);
		pp.setProjects(p);
		if(participationProjectRepository.nbrParticip(idProject, idEmployee)==1 )
				log.info("la participation existe");
		else
		{
			participationProjectRepository.save(pp);
			updateNbreIntervenantProject();}
		//else
	

		//e.getParticipationProjects().add(pp);
	
	
	
		
	}

	@Override
	public void RecjectProject(int idp) {
		// TODO Auto-generated method stub
		Project p= projectRepository.findById(idp).orElse(null);
		
			p.setEtat(Etat.rejected);
			projectRepository.save(p);
		
		
	}

	@Override
	public void AddPrimeToEmployee(int ide) {
		// TODO Auto-generated method stub
		Employee e= employeeRepository.findById(ide).orElse(null);
		
		int participation= participationProjectRepository.nbreParticipationOfEmployee(ide);
		float prime= e.getPrime();
		e.setPrime(100*participation);
		employeeRepository.save(e);	}
//@Scheduled(cron = "*/5 * * * * *" )
	@Override
	public void updateNbreIntervenantProject() {
		// TODO Auto-generated method stub
		List<ParticipationProject> participation=  retrieveAllParticipations();
		for (ParticipationProject pp :participation)
		{
			int idp= pp.getProjects().getIdProject();
			Project p = projectRepository.findById(idp).orElse(null);
			p.setIntervenant(NbreIntervenant(idp));
			projectRepository.save(p);
		}
		
	}

	@Override
	public List<ParticipationProject> retrieveAllParticipations() {
		// TODO Auto-generated method stub
		return (List<ParticipationProject>) participationProjectRepository.findAll();
	}
//	@Scheduled(cron = "*/5 * * * * *" )
	@Override
	public List<Employee> getEmployeeStar() {
		// TODO Auto-generated method stub
		List<ParticipationProject> employees= retrieveAllParticipations();
for (ParticipationProject pp: employees)
{int idEmployee=pp.getEmployees().getIdEmployee();

Employee employee= employeeRepository.findById(idEmployee).orElse(null);
employee.setNbreProjet(projectRepository.getnbreProjetOfEmployee(idEmployee));
employeeRepository.save(employee);



	}int nbreProject= employeeRepository.getMaxProject();
	List <Employee> employeesWithMaxProjects= employeeRepository.getEmployeeMaxProject(nbreProject);
log.info("**************0"+employeesWithMaxProjects);
return employeesWithMaxProjects;	
	}
//	@Scheduled(cron = "*/5 * * * * *" )
//deux listes secialite et nbre de max participation // specialite seulement
	@Override
	public List<Employee> getEmployeeForProject(int idp) {
		// TODO Auto-generated method stub
		List <Employee> employeesFilter= new ArrayList<Employee>();
		List<Integer> Idemployees= employeeRepository.getEmployeeProjectSpecialite(idp);
for (int ide: Idemployees)		
{Employee e= employeeRepository.findById(ide).orElse(null);
List <Employee> employeeSpecialite= new ArrayList<Employee>();
employeeSpecialite.add(e);
if (getEmployeeStar().contains(e))
employeesFilter.add(e);
else employeesFilter.addAll(employeeSpecialite);
}
return employeesFilter;

	}
	@Scheduled(cron = "*/5 * * * * *" )
	public List<Integer> sizeList()
	{List<Integer> size=new ArrayList();
		for (Project p: retrieveAllProjects())
		{int idp= p.getIdProject();
	int sizee=	getEmployeeForProject(idp).size();
			size.add(sizee);
		}
		log.info("hhhhhhhhhhhhhhhhhhhhhh"+size);
		return size;
		
	}

	

	



}
