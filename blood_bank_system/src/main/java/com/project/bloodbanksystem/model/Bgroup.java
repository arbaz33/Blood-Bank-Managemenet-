package com.project.bloodbanksystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "bgroup")
@Entity(name = "bgroup")

public class Bgroup {

	private long bgroup_id;
	private String bgroup_name;
	private String bgroup_image;
	
	public Bgroup() {
		
	}

	public String getBgroup_image() {
		return bgroup_image;
	}



	public void setBgroup_image(String bgroup_image) {
		this.bgroup_image = bgroup_image;
	}



	public Bgroup(long bgroup_id, String bgroup_name, String bgroup_image) {
		super();
		this.bgroup_id = bgroup_id;
		this.bgroup_name = bgroup_name;
		this.bgroup_image = bgroup_image;
	}


	@Override
	public String toString() {
		return "Bgroup [bgroup_id=" + bgroup_id + ", bgroup_name=" + bgroup_name + ", bgroup_image=" + bgroup_image
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getBgroup_id() {
		return bgroup_id;
	}


	public void setBgroup_id(long bgroup_id) {
		this.bgroup_id = bgroup_id;
	}


	public String getBgroup_name() {
		return bgroup_name;
	}


	public void setBgroup_name(String bgroup_name) {
		this.bgroup_name = bgroup_name;
	}
	
}
