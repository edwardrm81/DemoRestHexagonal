package com.edw.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestJpaApplication implements CommandLineRunner {

	Logger LOG = LoggerFactory.getLogger(DemoRestJpaApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRestJpaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.warn("Hola Mundo 1");
		LOG.info("Hola Mundo 2");
		LOG.error("Hola Mundo 3");
	}

}
