package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "donor")
@Entity(name = "donor")

public class Donor {

	private long donor_id;
	private String donor_name;
	private String donor_city;
	private String donor_state;
	private String donor_address;
	private String donor_contact;
	private String donor_email;
	private String donor_age;
	private String donor_blood_group;
	private String donor_description;
	
	
	public Donor() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDonor_id() {
		return donor_id;
	}

	public String getDonor_name() {
		return donor_name;
	}

	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}

	public String getDonor_city() {
		return donor_city;
	}

	public void setDonor_city(String donor_city) {
		this.donor_city = donor_city;
	}

	public String getDonor_state() {
		return donor_state;
	}

	public void setDonor_state(String donor_state) {
		this.donor_state = donor_state;
	}

	public String getDonor_address() {
		return donor_address;
	}

	public void setDonor_address(String donor_address) {
		this.donor_address = donor_address;
	}

	public String getDonor_contact() {
		return donor_contact;
	}

	public void setDonor_contact(String donor_contact) {
		this.donor_contact = donor_contact;
	}

	public String getDonor_email() {
		return donor_email;
	}

	public void setDonor_email(String donor_email) {
		this.donor_email = donor_email;
	}

	public String getDonor_age() {
		return donor_age;
	}

	public void setDonor_age(String donor_age) {
		this.donor_age = donor_age;
	}

	public String getDonor_blood_group() {
		return donor_blood_group;
	}

	public void setDonor_blood_group(String donor_blood_group) {
		this.donor_blood_group = donor_blood_group;
	}

	public String getDonor_description() {
		return donor_description;
	}

	public void setDonor_description(String donor_description) {
		this.donor_description = donor_description;
	}

	public void setDonor_id(long donor_id) {
		this.donor_id = donor_id;
	}

	public Donor(long donor_id, String donor_name, String donor_city, String donor_state, String donor_address,
			String donor_contact, String donor_email, String donor_age, String donor_blood_group,
			String donor_description) {
		super();
		this.donor_id = donor_id;
		this.donor_name = donor_name;
		this.donor_city = donor_city;
		this.donor_state = donor_state;
		this.donor_address = donor_address;
		this.donor_contact = donor_contact;
		this.donor_email = donor_email;
		this.donor_age = donor_age;
		this.donor_blood_group = donor_blood_group;
		this.donor_description = donor_description;
	}

	@Override
	public String toString() {
		return "Donor [donor_id=" + donor_id + ", donor_name=" + donor_name + ", donor_city=" + donor_city
				+ ", donor_state=" + donor_state + ", donor_address=" + donor_address + ", donor_contact="
				+ donor_contact + ", donor_email=" + donor_email + ", donor_age=" + donor_age + ", donor_blood_group="
				+ donor_blood_group + ", donor_description=" + donor_description + "]";
	}

	
	
	
}
