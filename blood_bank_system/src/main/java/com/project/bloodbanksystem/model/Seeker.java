package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "seeker")
@Entity(name = "seeker")

public class Seeker {

	private long seeker_id;
	private String seeker_name;
	private String seeker_city;
	private String seeker_state;
	private String seeker_address;
	private String seeker_contact;
	private String seeker_email;
	private String seeker_age;
	private String seeker_blood_group;
	private String seeker_description;
	
	
	public Seeker() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSeeker_id() {
		return seeker_id;
	}

	public String getSeeker_name() {
		return seeker_name;
	}

	public void setSeeker_name(String seeker_name) {
		this.seeker_name = seeker_name;
	}

	public String getSeeker_city() {
		return seeker_city;
	}

	public void setSeeker_city(String seeker_city) {
		this.seeker_city = seeker_city;
	}

	public String getSeeker_state() {
		return seeker_state;
	}

	public void setSeeker_state(String seeker_state) {
		this.seeker_state = seeker_state;
	}

	public String getSeeker_address() {
		return seeker_address;
	}

	public void setSeeker_address(String seeker_address) {
		this.seeker_address = seeker_address;
	}

	public String getSeeker_contact() {
		return seeker_contact;
	}

	public void setSeeker_contact(String seeker_contact) {
		this.seeker_contact = seeker_contact;
	}

	public String getSeeker_email() {
		return seeker_email;
	}

	public void setSeeker_email(String seeker_email) {
		this.seeker_email = seeker_email;
	}

	public String getSeeker_age() {
		return seeker_age;
	}

	public void setSeeker_age(String seeker_age) {
		this.seeker_age = seeker_age;
	}

	public String getSeeker_blood_group() {
		return seeker_blood_group;
	}

	public void setSeeker_blood_group(String seeker_blood_group) {
		this.seeker_blood_group = seeker_blood_group;
	}

	public String getSeeker_description() {
		return seeker_description;
	}

	public void setSeeker_description(String seeker_description) {
		this.seeker_description = seeker_description;
	}

	public void setSeeker_id(long seeker_id) {
		this.seeker_id = seeker_id;
	}

	public Seeker(long seeker_id, String seeker_name, String seeker_city, String seeker_state, String seeker_address,
			String seeker_contact, String seeker_email, String seeker_age, String seeker_blood_group,
			String seeker_description) {
		super();
		this.seeker_id = seeker_id;
		this.seeker_name = seeker_name;
		this.seeker_city = seeker_city;
		this.seeker_state = seeker_state;
		this.seeker_address = seeker_address;
		this.seeker_contact = seeker_contact;
		this.seeker_email = seeker_email;
		this.seeker_age = seeker_age;
		this.seeker_blood_group = seeker_blood_group;
		this.seeker_description = seeker_description;
	}

	@Override
	public String toString() {
		return "Seeker [seeker_id=" + seeker_id + ", seeker_name=" + seeker_name + ", seeker_city=" + seeker_city
				+ ", seeker_state=" + seeker_state + ", seeker_address=" + seeker_address + ", seeker_contact="
				+ seeker_contact + ", seeker_email=" + seeker_email + ", seeker_age=" + seeker_age + ", seeker_blood_group="
				+ seeker_blood_group + ", seeker_description=" + seeker_description + "]";
	}

	
	
	
}
