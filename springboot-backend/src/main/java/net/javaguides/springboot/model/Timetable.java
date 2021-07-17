package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shiftID;
	
	@Column(name = "monday")
	private String Monday;
	
	@Column(name = "tuesday")
	private String Tuesday;
	
	@Column(name = "wednesday")
	private String Wednesday;
	
	@Column(name = "thursday")
	private String Thursday;
	
	@Column(name = "friday")
	private String Friday;
	
	@Column(name = "saturday")
	private String Saturday;
	
	@Column(name = "sunnday")
	private String Sunday;
	
	
	public Timetable() {
		
	}
	
	
	public Timetable(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday,
			String sunday) {
		super();
		Monday = monday;
		Tuesday = tuesday;
		Wednesday = wednesday;
		Thursday = thursday;
		Friday = friday;
		Saturday = saturday;
		Sunday = sunday;
	}
	
	public long getShiftID() {
		return shiftID;
	}
	public void setShiftID(long shiftID) {
		this.shiftID = shiftID;
	}
	public String getMonday() {
		return Monday;
	}
	public void setMonday(String monday) {
		Monday = monday;
	}
	public String getTuesday() {
		return Tuesday;
	}
	public void setTuesday(String tuesday) {
		Tuesday = tuesday;
	}
	public String getWednesday() {
		return Wednesday;
	}
	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}
	public String getThursday() {
		return Thursday;
	}
	public void setThursday(String thursday) {
		Thursday = thursday;
	}
	public String getFriday() {
		return Friday;
	}
	public void setFriday(String friday) {
		Friday = friday;
	}
	public String getSaturday() {
		return Saturday;
	}
	public void setSaturday(String saturday) {
		Saturday = saturday;
	}
	public String getSunday() {
		return Sunday;
	}
	public void setSunday(String sunday) {
		Sunday = sunday;
	}
	
	
	
}
