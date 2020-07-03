package app.startly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.startly.domain.*;

@Service
@Transactional
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Task> getAllTasks() {
		System.out.println("Tasks gevonden in database");
		return taskRepository.findAll();
	}

	public Task addTask(Task task) {
		System.out.println("Task toegevoegd aan database");
		return taskRepository.save(task);
	}

	public Task updateTask(long taskId, Task taskDetails) {
		System.out.println("Task updated in Database");
		Task task = taskRepository.findById(taskId).get();
		
		if (taskDetails.getTaskName() != null && taskDetails.getTaskName() != "") {
		task.setTaskName(taskDetails.getTaskName());
		}
		if (taskDetails.getTaskDate() != null && taskDetails.getTaskDate() != "") {
		task.setTaskDate(taskDetails.getTaskDate());
		}
		if (taskDetails.getTaskExplain() != null && taskDetails.getTaskExplain() != "") {
		task.setTaskExplain(taskDetails.getTaskExplain());
		}
		task.setTaskStatus(taskDetails.getTaskStatus());
		task.setTaskDuration(taskDetails.getTaskDuration());
		task.setTaskTimeLeft(taskDetails.getTaskTimeLeft());
		task.setTasktype(taskDetails.getTasktype());
		
		return taskRepository.save(task);
	}

	public Task addTaskToCustomer(Long customerId, Task task) {
		System.out.println("New task added to customer");
		Customer customer = (Customer) customerRepository.findById(customerId).get();
		task.setCustomer(customer);
		
		Task savedTask = taskRepository.save(task);
		
		customer.getTasks().add(savedTask);
		customerRepository.save(customer);
		
		return savedTask;
	}

	public Task getTaskById(Long taskId) {
		System.out.println("Task found by id");
		return taskRepository.findById(taskId).get();
	}

	
//	public Contactpersoon toevoegenContactpersoonMetOpdrachtgever(String opdrachtgeverId, Contactpersoon contactpersoon) {
//	Opdrachtgever opdrachtgever = opdrachtgeverRepository.findById(Long.parseLong(opdrachtgeverId)).get();
//	contactpersoon.setOpdrachtgever(opdrachtgever);
//	System.out.println("Contactpersoon aangemaakt en opdrachtgever aan toegevoegd.");
//	Contactpersoon savedContactpersoon = contactpersoonRepository.save(contactpersoon);
//
//	opdrachtgever.getContactpersonen().add(savedContactpersoon);
//	opdrachtgeverRepository.save(opdrachtgever);
//
//	return savedContactpersoon;
//}
}
