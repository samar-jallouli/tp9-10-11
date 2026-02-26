package com.samar.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samar.makeup.entities.Makeup;
import com.samar.makeup.repos.MakeupRepository;

@Service
public class MakeupServiceImpl implements MakeupService {

	@Autowired
	MakeupRepository makeupRepository;
	
	@Override
	public Makeup saveMakeup(Makeup M) {
		return makeupRepository.save(M);
	}

	@Override
	public Makeup updateMakeup(Makeup M) {
		return makeupRepository.save(M);
	}

	@Override
	public void deleteMakeup(Makeup M) {
		makeupRepository.delete(M);
		
	}

	@Override
	public void deleteMakeupById(Long id) {
		makeupRepository.deleteById(id);
		
	}

	@Override
	public Makeup getMakeup(Long id) {
		return makeupRepository.findById(id).get();
	}

	@Override
	public List<Makeup> getAllMakeup() {
		return makeupRepository.findAll();
	}

}
