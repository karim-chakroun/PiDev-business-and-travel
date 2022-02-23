package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Task;
import tn.esprit.spring.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
@Autowired
TaskRepository taskRepository;
	@Override
	public List<Task> retrieveAllTasks() {
		// TODO Auto-generated method stub
		return (List<Task>) taskRepository.findAll();
	}

	@Override
	public Task addTask(Task t) {
		// TODO Auto-generated method stub
		return taskRepository.save(t);
	}

	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}

	@Override
	public Task updateTask(Task t) {
		// TODO Auto-generated method stub
		return taskRepository.save(t);
	}

	@Override
	public Task retrieveTask(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).get();
	}

}
