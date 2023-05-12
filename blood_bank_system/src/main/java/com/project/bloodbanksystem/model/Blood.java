package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "blood")
@Entity(name = "blood")

public class Blood {

	private long blood_id;
	private String blood_bank_id;
	private String blood_bgroup_id;
	private String blood_quantity;
	private String blood_description;
	
	public Blood() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getBlood_id() {
		return blood_id;
	}

	public String getBlood_bank_id() {
		return blood_bank_id;
	}

	public void setBlood_bank_id(String blood_bank_id) {
		this.blood_bank_id = blood_bank_id;
	}

	public String getBlood_bgroup_id() {
		return blood_bgroup_id;
	}

	public void setBlood_bgroup_id(String blood_bgroup_id) {
		this.blood_bgroup_id = blood_bgroup_id;
	}

	public String getBlood_quantity() {
		return blood_quantity;
	}

	public void setBlood_quantity(String blood_quantity) {
		this.blood_quantity = blood_quantity;
	}

	public String getBlood_description() {
		return blood_description;
	}

	public void setBlood_description(String blood_description) {
		this.blood_description = blood_description;
	}

	public void setBlood_id(long blood_id) {
		this.blood_id = blood_id;
	}

	@Override
	public String toString() {
		return "Blood [blood_id=" + blood_id + ", blood_bank_id=" + blood_bank_id + ", blood_bgroup_id="
				+ blood_bgroup_id + ", blood_quantity=" + blood_quantity + ", blood_description=" + blood_description
				+ "]";
	}

	public Blood(long blood_id, String blood_bank_id, String blood_bgroup_id, String blood_quantity,
			String blood_description) {
		super();
		this.blood_id = blood_id;
		this.blood_bank_id = blood_bank_id;
		this.blood_bgroup_id = blood_bgroup_id;
		this.blood_quantity = blood_quantity;
		this.blood_description = blood_description;
	}
	
}
