package app.startly.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.startly.controller.*;
import app.startly.domain.*;

@RestController
@RequestMapping("/api/task")
public class TaskEndpoint {
	@Autowired
	TaskService taskService;
	
	@GetMapping("/")
	public Iterable<Task> getTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/{taskId}")
	public Task getTasksById(@PathVariable(value = "taskId") String taskId) {
		return taskService.getTaskById(Long.parseLong(taskId));
	}
	
	@PostMapping("/")
	public Task postTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	@PostMapping("/{customerId}")
	public Task postTaskToCustomer(@PathVariable(value = "customerId") String customerId, @RequestBody Task task) {
		return taskService.addTaskToCustomer(Long.parseLong(customerId), task);
	}
	
	@PutMapping("/{id}") 
	public Task taskService(@PathVariable(value = "id") String taskId, @RequestBody Task taskDetails) {
		return taskService.updateTask(Long.parseLong(taskId), taskDetails);
	}
		
}
