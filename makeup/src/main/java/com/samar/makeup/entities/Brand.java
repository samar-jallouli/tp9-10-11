package com.samar.makeup.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idB;
	private String nomB;
	private String descriptionB;
	
	@OneToMany (mappedBy ="brand")
	private List<Makeup> makeup;
	
	public Brand() {
		super();
	
	}
	public Long getIdB() {
		return idB;
	}
	public void setIdB(Long idB) {
		this.idB = idB;
	}
	public String getNomB() {
		return nomB;
	}
	public void setNomB(String nomB) {
		this.nomB = nomB;
	}
	public String getDescriptionB() {
		return descriptionB;
	}
	public void setDescriptionB(String descriptionB) {
		this.descriptionB = descriptionB;
	}
	public List<Makeup> getMakeup() {
		return makeup;
	}
	public void setMakeup(List<Makeup> makeup) {
		this.makeup = makeup;
	}
	
	
}
