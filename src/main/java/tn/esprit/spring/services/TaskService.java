package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.entities.Task;

public interface TaskService {
	List<Task> retrieveAllTasks();

	Task addTask(Task t);

	void deleteTask(int id);

	Task updateTask(Task t);

	Task retrieveTask(int id);
	void addAndassignTaskToEmployee(int idTask, int idEmployee);
	void addAndassignTaskToProject(Task t, int idProject);
	int nbreTaskOfProject(int idp);
	int nbreTaskEtatOfProject(int idProject);
	void getProject();
	//List<Task> modifyEtat(Task t);
	
}
