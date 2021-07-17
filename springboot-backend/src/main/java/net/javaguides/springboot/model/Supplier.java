package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "suppliers")

public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	
	@Column(name="Supplier_Name")
	private String sName;
	
	@Column(name="Supplier_Address")
	private String sAddress;
	
	@Column(name="ContactNumber")
	private String sNumber;
	
	@Column(name="DrugTypes")
	private String drugType;
	
	public Supplier() {
		
	}

	public Supplier(String sName, String sAddress, String sNumber, String drugType) {
		super();
		this.sName = sName;
		this.sAddress = sAddress;
		this.sNumber = sNumber;
		this.drugType = drugType;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
	
	

}
