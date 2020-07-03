package app.startly.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

	private String customerName;
	private String profileImage;
	private String userName;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private Set<Task> tasks = new HashSet<Task>();
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task task) {
		task.setCustomer(this);
		tasks.add(task);
	}
	
	public Set<Task> getTasks(String date) {
		Set<Task> tasksDate = new HashSet<Task>();
		
		for (Task task: tasks) {
			if (task.getTaskDate().equals(date)) {
				tasksDate.add(task);
			}
		}
		return tasksDate;
	}
	
}
