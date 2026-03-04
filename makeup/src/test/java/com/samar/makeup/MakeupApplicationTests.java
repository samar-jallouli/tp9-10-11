package com.samar.makeup;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.samar.makeup.entities.Brand;
import com.samar.makeup.entities.Makeup;
import com.samar.makeup.repos.MakeupRepository;
import com.samar.makeup.service.MakeupService;

@SpringBootTest
class MakeupApplicationTests {

		@Autowired
		private MakeupRepository makeupRepository;
		
		@Autowired
		private MakeupService makeupService;
		
		@Test
		public void testCreateMakeup() {
		Makeup mak = new Makeup("gloss", 22.500, new Date());
		makeupRepository.save(mak);
		}
		
		@Test
		public void testFindMakeup()
		{
		Makeup M = makeupRepository.findById(1L).get();
		System.out.println(M);
		}
		
		@Test
		public void testUpdateMakeup()
		{
		Makeup M = makeupRepository.findById(1L).get();
		M.setPrixMakeup(16.5);
		makeupRepository.save(M);
		System.out.println(M);
		}
		
		@Test
		public void testDeleteMakeup()
		{
		makeupRepository.deleteById(1L);;
		}

		@Test
		public void testListerTousMakeup()
		{
		List<Makeup> mak = makeupRepository.findAll();
		for (Makeup M : mak)
		{
		System.out.println(M);
		}
		}
		
		@Test
		public void testFindByNomMakeupContains()
		{
		Page<Makeup> mak = makeupService.getAllMakeupParPage(0,2);
		System.out.println(mak.getSize());
		System.out.println(mak.getTotalElements());
		System.out.println(mak.getTotalPages());
		mak.getContent().forEach(p -> {System.out.println(p.toString());
		 });
		}

		@Test
		public void testFindMakeupByNom()
		{
		List<Makeup> mak = makeupRepository.findBynomMakeup("blush");
		
		for (Makeup M:mak)
		   System.out.println(M);
		}
		
		@Test
		public void testFindMakeupByNomContains()
		{
		List<Makeup> mak = makeupRepository.findBynomMakeup("b");
		
		for (Makeup M:mak)
		   System.out.println(M);
		}
		
		@Test
		public void testfindByNomPrix()
		{
		List<Makeup> mak = makeupRepository.findByNomPrix("gloss", 22.5);
		for (Makeup m : mak)
		{
		System.out.println(m);
		}
		}

		@Test
		public void testfindByBrand()
		{
		Brand b = new Brand();
		b.setIdB(1L);
		List<Makeup> mak = makeupRepository.findByBrand(b);
		for (Makeup m : mak)
		{
		System.out.println(m);
		}
		}

		@Test
		public void findByBrandIdB()
		{
		List<Makeup> mak = makeupRepository.findByBrandIdB(1L);
		for (Makeup m : mak)
		{
		System.out.println(m);
		}
		 }

		@Test
		public void findByOrderByNomMakeupAsc()
		{
		List<Makeup> mak =makeupRepository.findByOrderByNomMakeupAsc();
		for (Makeup m : mak)
		{
		System.out.println(m);
		}
		}
		
		@Test
		public void trierMakeupNomsPrix()
		{
		List<Makeup> mak = makeupRepository.trierMakeupNomsPrix();
		for (Makeup m : mak)
		{
		System.out.println(m);
		}
		}
		
		
		
		
		
		
}












