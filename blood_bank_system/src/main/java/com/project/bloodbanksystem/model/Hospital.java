package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "hospital")
@Entity(name = "hospital")

public class Hospital {

	private long hospital_id;
	private String hospital_name;
	private String hospital_city;
	private String hospital_state;
	private String hospital_address;
	private String hospital_contact;
	private String hospital_email;
	private String hospital_pincode;
	
	public Hospital() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getHospital_id() {
		return hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_city() {
		return hospital_city;
	}

	public void setHospital_city(String hospital_city) {
		this.hospital_city = hospital_city;
	}

	public String getHospital_state() {
		return hospital_state;
	}

	public void setHospital_state(String hospital_state) {
		this.hospital_state = hospital_state;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public String getHospital_contact() {
		return hospital_contact;
	}

	public void setHospital_contact(String hospital_contact) {
		this.hospital_contact = hospital_contact;
	}

	public String getHospital_email() {
		return hospital_email;
	}

	public void setHospital_email(String hospital_email) {
		this.hospital_email = hospital_email;
	}

	public String getHospital_pincode() {
		return hospital_pincode;
	}

	public void setHospital_pincode(String hospital_pincode) {
		this.hospital_pincode = hospital_pincode;
	}

	public void setHospital_id(long hospital_id) {
		this.hospital_id = hospital_id;
	}

	public Hospital(long hospital_id, String hospital_name, String hospital_city, String hospital_state,
			String hospital_address, String hospital_contact, String hospital_email, String hospital_pincode) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.hospital_city = hospital_city;
		this.hospital_state = hospital_state;
		this.hospital_address = hospital_address;
		this.hospital_contact = hospital_contact;
		this.hospital_email = hospital_email;
		this.hospital_pincode = hospital_pincode;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", hospital_city="
				+ hospital_city + ", hospital_state=" + hospital_state + ", hospital_address=" + hospital_address
				+ ", hospital_contact=" + hospital_contact + ", hospital_email=" + hospital_email
				+ ", hospital_pincode=" + hospital_pincode + "]";
	}
	
	

	
}
