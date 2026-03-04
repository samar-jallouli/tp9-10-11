package com.samar.makeup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.samar.makeup.entities.Brand;
import com.samar.makeup.entities.Makeup;

public interface MakeupService {

	Makeup saveMakeup(Makeup M);
	Makeup updateMakeup(Makeup M);
	void deleteMakeup(Makeup M);
	void deleteMakeupById(Long id);
	Makeup getMakeup(Long id);
	List<Makeup> getAllMakeup();
	List<Makeup> findByNomMakeup(String nom);
	List<Makeup> findByNomMakeupContains(String nom);
	List<Makeup> findByNomPrix (String nom, Double prix);
	List<Makeup> findByBrand (Brand brand);
	List<Makeup> findByBrandIdB(Long id);
	List<Makeup> findByOrderByNomMakeupAsc();
	List<Makeup> trierMakeupNomsPrix();

	
	
	Page<Makeup> getAllMakeupParPage(int page, int size);
}
