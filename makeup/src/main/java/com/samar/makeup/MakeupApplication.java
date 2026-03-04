package com.samar.makeup;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samar.makeup.entities.Makeup;
import com.samar.makeup.service.MakeupService;

@SpringBootApplication
public class MakeupApplication implements CommandLineRunner {

	@Autowired
	MakeupService makeupService;
	
	public static void main(String[] args) {
		SpringApplication.run(MakeupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		makeupService.saveMakeup(new Makeup("eyeliner",25.5,new Date()));
		makeupService.saveMakeup(new Makeup("mascara",55.6,new Date()));
		makeupService.saveMakeup(new Makeup("blush",30.5,new Date()));
	}

}
