package com.samar.makeup;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.samar.makeup.entities.Makeup;
import com.samar.makeup.repos.MakeupRepository;

@SpringBootTest
class MakeupApplicationTests {

		@Autowired
		private MakeupRepository makeupRepository;
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




}
