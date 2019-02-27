package com.cfg.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class SpringCloudConfigClientApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		List<StudentInfo> studentsList = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		int id = 1;
		for (int i = 0; i < 10; i++) {
			studentsList.add(new StudentInfo(id, "Govind", "p"));
			id++;
		}
		System.out.println("Total list size " + studentsList.size());
		repo.saveAll(studentsList);

		long endTime = System.currentTimeMillis();
		System.out.println("Completed in " + (endTime - startTime) / 1000);

	}

}
