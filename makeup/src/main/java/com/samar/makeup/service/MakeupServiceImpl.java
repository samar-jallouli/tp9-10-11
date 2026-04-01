package com.samar.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.samar.makeup.entities.Brand;
import com.samar.makeup.entities.Makeup;
import com.samar.makeup.repos.BrandRepository;
import com.samar.makeup.repos.MakeupRepository;

@Service
public class MakeupServiceImpl implements MakeupService {

	@Autowired
	BrandRepository brandRepository;
	
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

	@Override
	public Page<Makeup> getAllMakeupParPage(int page, int size) {
		return makeupRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Makeup> findByNomMakeup(String nom) {
		return makeupRepository.findBynomMakeup(nom);
	}

	@Override
	public List<Makeup> findByNomMakeupContains(String nom) {
		return makeupRepository.findBynomMakeupContains(nom);
	}

	@Override
	public List<Makeup> findByNomPrix(String nom, Double prix) {
		return makeupRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Makeup> findByBrand(Brand brand) {
		return makeupRepository.findByBrand(brand);
	}

	@Override
	public List<Makeup> findByBrandIdB(Long id) {
		return makeupRepository.findByBrandIdB(id);
	}

	@Override
	public List<Makeup> findByOrderByNomMakeupAsc() {
		return makeupRepository.findByOrderByNomMakeupAsc();
	}

	@Override
    public List<Makeup> trierMakeupNomsPrix() {
        return makeupRepository.trierMakeupNomsPrix();
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

}