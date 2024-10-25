package com.accenture.lkm.business.bean;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ToDoBean {
	
	private Integer id;
	private String task;
	private String description;
	private Date insertTime;
	private boolean done;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "ToDoBean [id=" + id + ", task=" + task + ", description=" + description + ", insertTime=" + insertTime
				+ ", done=" + done + "]";
	}
	
	
	
	
	
	

}
