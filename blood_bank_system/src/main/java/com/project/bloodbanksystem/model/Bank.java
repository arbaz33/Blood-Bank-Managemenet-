package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "bank")
@Entity(name = "bank")

public class Bank {

	private long bank_id;
	private String bank_name;
	private String bank_city;
	private String bank_state;
	private String bank_address;
	private String bank_contact;
	private String bank_email;
	private String bank_pincode;
	
	public Bank() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getBank_id() {
		return bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_city() {
		return bank_city;
	}

	public void setBank_city(String bank_city) {
		this.bank_city = bank_city;
	}

	public String getBank_state() {
		return bank_state;
	}

	public void setBank_state(String bank_state) {
		this.bank_state = bank_state;
	}

	public String getBank_address() {
		return bank_address;
	}

	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}

	public String getBank_contact() {
		return bank_contact;
	}

	public void setBank_contact(String bank_contact) {
		this.bank_contact = bank_contact;
	}

	public String getBank_email() {
		return bank_email;
	}

	public void setBank_email(String bank_email) {
		this.bank_email = bank_email;
	}

	public String getBank_pincode() {
		return bank_pincode;
	}

	public void setBank_pincode(String bank_pincode) {
		this.bank_pincode = bank_pincode;
	}

	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}

	public Bank(long bank_id, String bank_name, String bank_city, String bank_state,
			String bank_address, String bank_contact, String bank_email, String bank_pincode) {
		super();
		this.bank_id = bank_id;
		this.bank_name = bank_name;
		this.bank_city = bank_city;
		this.bank_state = bank_state;
		this.bank_address = bank_address;
		this.bank_contact = bank_contact;
		this.bank_email = bank_email;
		this.bank_pincode = bank_pincode;
	}

	@Override
	public String toString() {
		return "Bank [bank_id=" + bank_id + ", bank_name=" + bank_name + ", bank_city="
				+ bank_city + ", bank_state=" + bank_state + ", bank_address=" + bank_address
				+ ", bank_contact=" + bank_contact + ", bank_email=" + bank_email
				+ ", bank_pincode=" + bank_pincode + "]";
	}
	
	

	
}
