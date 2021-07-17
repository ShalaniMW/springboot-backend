package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")

public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EqId;
	
	@Column(name= "eqName")
	private String EqName;
	
	@Column(name= "eQuantity")
	private int EQuantity;
	
	@Column(name= "eUprice")
	private int EUprice;
	
	@Column(name= "eStorage")
	private String EStorage;
	
	@Column(name= "trade")
	private String ETrade;
	
	@Column(name= "e_IS_Date")
	private String E_IS_Date;
	
	@Column(name= "e_Ex_Date")
	private String E_Ex_Date;
	
	/*@Column(name= "eq_name")
	private String EqName;
	
	@Column(name= "e_quantity")
	private int EQuantity;
	
	@Column(name= "e_uprice")
	private int EUprice;
	
	@Column(name= "e_storage")
	private String EStorage;
	
	@Column(name= "trade")
	private String ETrade;
	
	@Column(name= "e_is_date")
	private String E_IS_Date;
	
	@Column(name= "e_ex_date")
	private String E_Ex_Date;*/
	
	public Equipment() {
		
	}

	
	public Equipment(String eqName, int eQuantity, int eUprice, String eStorage, String eTrade, String e_IS_Date,
			String e_Ex_Date) {
		super();
		EqName = eqName;
		EQuantity = eQuantity;
		EUprice = eUprice;
		EStorage = eStorage;
		ETrade = eTrade;
		E_IS_Date = e_IS_Date;
		E_Ex_Date = e_Ex_Date;
	}


	public Long getEqId() {
		return EqId;
	}

	public void setEqId(Long eqId) {
		EqId = eqId;
	}

	public String getEqName() {
		return EqName;
	}

	public void setEqName(String eqName) {
		EqName = eqName;
	}

	public int getEQuantity() {
		return EQuantity;
	}

	public void setEQuantity(int eQuantity) {
		EQuantity = eQuantity;
	}

	public int getEUprice() {
		return EUprice;
	}

	public void setEUprice(int eUprice) {
		EUprice = eUprice;
	}

	public String getEStorage() {
		return EStorage;
	}

	public void setEStorage(String eStorage) {
		EStorage = eStorage;
	}

	public String getETrade() {
		return ETrade;
	}

	public void setETrade(String eTrade) {
		ETrade = eTrade;
	}

	public String getE_IS_Date() {
		return E_IS_Date;
	}

	public void setE_IS_Date(String e_IS_Date) {
		E_IS_Date = e_IS_Date;
	}

	public String getE_Ex_Date() {
		return E_Ex_Date;
	}

	public void setE_Ex_Date(String e_Ex_Date) {
		E_Ex_Date = e_Ex_Date;
	}
	

	
}