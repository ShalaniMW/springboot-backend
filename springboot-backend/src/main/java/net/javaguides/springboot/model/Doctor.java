package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;

	
	@Column(name = "d_nic")
	private String nic;

	@Column(name = "d_specialization")
	private String specialization;
	
	@Column(name = "d_department")
	private String department;
	
	@Column(name = "contact_number")
	private String contactnumber;
	
	@Column(name = "d_address")
	private String address;
	
	@Column(name = "d_email")
	private String email;
	
	@Column(name = "registration_date")
	private String registrationdate;
	
	public Doctor() {
		
	}
	
	public Doctor(String fullName, String nic, String specialization,String department,String contactnumber,String address,String email,String registrationdate) {
		super();
		this.fullName = fullName;
		this.nic = nic;
		this.specialization = specialization;
		this.department = department;
		this.contactnumber = contactnumber;
		this.address = address;
		this.email = email;
		this.registrationdate = registrationdate;
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}