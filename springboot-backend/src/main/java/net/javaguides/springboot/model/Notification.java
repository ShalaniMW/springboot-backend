package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "n_name")
	private String notify_name;

	@Column(name = "n_body")
	private String notify_body;
	
	@Column(name = "date")
	private String notify_date;
	
	public Notification() {
		
	}
	
	public Notification(String notify_name, String notify_body, String notify_date) {
		super();
		this.notify_name = notify_name;
		this.notify_body = notify_body;
		this.notify_date = notify_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotify_name() {
		return notify_name;
	}

	public void setNotify_name(String notify_name) {
		this.notify_name = notify_name;
	}

	public String getNotify_body() {
		return notify_body;
	}

	public void setNotify_body(String notify_body) {
		this.notify_body = notify_body;
	}

	public String getNotify_date() {
		return notify_date;
	}

	public void setNotify_date(String notify_date) {
		this.notify_date = notify_date;
	}

	
}