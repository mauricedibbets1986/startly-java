package app.startly.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long taskId;
	private String taskName;
	private String taskExplain;
	private ArrayList<TaskLink> taskLinksList = new ArrayList<TaskLink>();
	private TaskStatus taskStatus;
	private double taskDuration;
	private double taskTimeLeft;
	private TaskType tasktype;
	private String taskDate;
	
	
	@ManyToOne
	private Customer customer;
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskExplain() {
		return taskExplain;
	}
	public void setTaskExplain(String taskExplain) {
		this.taskExplain = taskExplain;
	}
	public ArrayList<TaskLink> getTaskLinksList() {
		return taskLinksList;
	}
	public void setTaskLinksList(ArrayList<TaskLink> taskLinksList) {
		this.taskLinksList = taskLinksList;
	}
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public double getTaskDuration() {
		return taskDuration;
	}
	public void setTaskDuration(double taskDuration) {
		this.taskDuration = taskDuration;
	}
	public double getTaskTimeLeft() {
		return taskTimeLeft;
	}
	public void setTaskTimeLeft(double taskTimeLeft) {
		this.taskTimeLeft = taskTimeLeft;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public TaskType getTasktype() {
		return tasktype;
	}
	public void setTasktype(TaskType tasktype) {
		this.tasktype = tasktype;
	}
	
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
