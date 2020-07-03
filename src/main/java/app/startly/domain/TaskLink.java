package app.startly.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TaskLink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long taskLinkId;
	private String taskUrl;
	
	public long getTaskLinkId() {
		return taskLinkId;
	}
	public void setTaskLinkId(long taskLinkId) {
		this.taskLinkId = taskLinkId;
	}
	public String getTaskUrl() {
		return taskUrl;
	}
	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}
}
