package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	@Column(name="NIC")
	private String NIC;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Phone_Number")
	private String phone;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Date_of_birth")
	private String DOB;
	
	@Column(name="ServiceType")
	private String serveType;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Payments")
	private String payment;
	
	public Patient(){
		
	}
	
	public Patient(String NIC, String name, String address, String phone, String email, String gender, String dOB,
			String serveType, String date, String payment) {
		super();
		this.NIC = NIC;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		DOB = dOB;
		this.serveType = serveType;
		this.date = date;
		this.payment = payment;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getServeType() {
		return serveType;
	}
	public void setServeType(String serveType) {
		this.serveType = serveType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	


}
