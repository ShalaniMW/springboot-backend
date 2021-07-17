package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;

	
	@Column(name = "e_nic")
	private String nic;

	@Column(name = "e_dateofbirth")
	private String dateofbirth;
	
	@Column(name = "e_department")
	private String department;
	
	@Column(name = "e_desination")
	private String desination;
	
	@Column(name = "contact_number")
	private String contactnumber;
	
	@Column(name = "e_address")
	private String address;
	
	@Column(name = "e_email")
	private String email;
	
	@Column(name = "registration_date")
	private String registrationdate;
	
	public Employee() {
		
	}
	
	public Employee(String fullName, String nic, String dateofbirth,String department,String desination,String contactnumber,String address,String email,String registrationdate) {
		super();
		this.fullName = fullName;
		this.nic = nic;
		this.dateofbirth = dateofbirth;
		this.department = department;
		this.desination = desination;
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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesination() {
		return desination;
	}

	public void setDesination(String desination) {
		this.desination = desination;
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
