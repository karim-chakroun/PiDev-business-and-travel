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
import tn.esprit.spring.entities.Task;
import tn.esprit.spring.services.EntrepriseService;
import tn.esprit.spring.services.IEmployeeService;
import tn.esprit.spring.services.ProjectService;
import tn.esprit.spring.services.TaskService;
import tn.esprit.spring.services.TaskService;

@RestController
@Api(tags = "Gestion des tasks")
@RequestMapping("/task")
public class TaskRestController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService projectService;
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	IEmployeeService employeeService;
	// http://localhost:8089/SpringMVC/task/retrieve-all-task
		@ApiOperation(value = "Récupérer la liste des tasks")
		@GetMapping("/retrieve-all-task")
		public List<Task> getTask() {
			List<Task> listTask= taskService.retrieveAllTasks();
			return listTask;
		}

		// http://localhost:8089/SpringMVC/task/retrieve-task/1
		@ApiOperation(value = "Récupérer un task par Id")
		@GetMapping("/retrieve-task/{task-id}")
//		@ApiResponses(value = {
//				@ApiResponse(code = 200, message = "Success|OK"),
//				@ApiResponse(code = 401, message = "Not Authorized!"),
//				@ApiResponse(code = 403, message = "Forbidden!"),
//				@ApiResponse(code = 404, message = "Not Found!") })
		public Task retrieveTask(@PathVariable("task-id") int taskId) {
			return taskService.retrieveTask(taskId);
		}

		@PostMapping("/add-task")
		public Task addTask(@RequestBody Task e) {
			return taskService.addTask(e);
		}

		// http://localhost:8089/SpringMVC/task/remove-task/1
		@DeleteMapping("/remove-task/{task-id}")
		public void removeTask(@PathVariable("task-id") int taskId) {
			taskService.deleteTask(taskId);
		}

		// http://localhost:8089/SpringMVC/task/modify-task
		@PutMapping("/modify-task")
		public Task modifyTask(@RequestBody Task p) {
			return taskService.updateTask(p);
		}
}
