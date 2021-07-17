package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "drug")
public class DrugModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long drugId;
	
	@Column(name = "genericName")
	private String genericName;
	
	@Column(name = "tradeName")
	private String tradeName;
	
	@Column(name = "manuDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date manuDate;
	
	@Column(name = "expDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expDate;
	
	@Column(name = "unitPrice")
	private int unitPrice;
	
	@Column(name = "storageLocation")
	private String storageLocation;
	
	@Column(name = "bufferStock")
	private int bufferStock;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "department")
	private int department;
	
	@Column(name = "supplierId")
	private int supplierId;
	
	public DrugModel() {}

	public DrugModel(String genericName, String tradeName, Date manuDate, Date expDate, int unitPrice,
			String storageLocation, int bufferStock, int quantity, int department, int supplierId) {
		super();
		this.genericName = genericName;
		this.tradeName = tradeName;
		this.manuDate = manuDate;
		this.expDate = expDate;
		this.unitPrice = unitPrice;
		this.storageLocation = storageLocation;
		this.bufferStock = bufferStock;
		this.quantity = quantity;
		this.department = department;
		this.supplierId = supplierId;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public Date getManuDate() {
		return manuDate;
	}

	public void setManuDate(Date manuDate) {
		this.manuDate = manuDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public int getBufferStock() {
		return bufferStock;
	}

	public void setBufferStock(int bufferStock) {
		this.bufferStock = bufferStock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
}