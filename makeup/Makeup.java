package com.samar.makeup.entities;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Makeup {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long idMakeup;
	private String nomMakeup;
	private Double prixMakeup;
	private Date dateCreation;
	
	public Makeup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Makeup(String nomMakeup, Double prixMakeup, Date dateCreation) {
		super();
		this.nomMakeup = nomMakeup;
		this.prixMakeup = prixMakeup;
		this.dateCreation = dateCreation;
	}



	public Long getIdMakeup() {
		return idMakeup;
	}
	public void setIdMakeup(Long idMakeup) {
		this.idMakeup = idMakeup;
	}
	public String getNomMakeup() {
		return nomMakeup;
	}
	public void setNomMakeup(String nomMakeup) {
		this.nomMakeup = nomMakeup;
	}
	public Double getPrixMakeup() {
		return prixMakeup;
	}
	public void setPrixMakeup(Double prixMakeup) {
		this.prixMakeup = prixMakeup;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	@Override
	public String toString() {
		return "Makeup [idMakeup=" + idMakeup + ", nomMakeup=" + nomMakeup + ", prixMakeup=" + prixMakeup
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	
	
}
