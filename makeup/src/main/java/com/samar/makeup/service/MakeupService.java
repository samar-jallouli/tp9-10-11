package com.samar.makeup.service;

import java.util.List;

import com.samar.makeup.entities.Makeup;

public interface MakeupService {

	Makeup saveMakeup(Makeup M);
	Makeup updateMakeup(Makeup M);
	void deleteMakeup(Makeup M);
	void deleteMakeupById(Long id);
	Makeup getMakeup(Long id);
	List<Makeup> getAllMakeup();
}
