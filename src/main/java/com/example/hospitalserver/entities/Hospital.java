package com.example.hospitalserver.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ubication;
	private String telephone;
	private int specializationQuantity;
	private Date createDate;
		
	public Hospital() { }


	public Hospital(String ubication, String telephone, int specializationQuantity, Date createDate) {
		this.ubication = ubication;
		this.telephone = telephone;
		this.specializationQuantity = specializationQuantity;
		this.createDate = createDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUbication() {
		return ubication;
	}


	public void setUbication(String ubication) {
		this.ubication = ubication;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getSpecializationQuantity() {
		return specializationQuantity;
	}


	public void setSpecializationQuantity(int specializationQuantity) {
		this.specializationQuantity = specializationQuantity;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
