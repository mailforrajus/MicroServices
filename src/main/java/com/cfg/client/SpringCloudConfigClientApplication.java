package com.cfg.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudConfigClientApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		StudentInfo s = new StudentInfo(101, "Govind");
		StudentInfo s1 = new StudentInfo(102, "UMA");
		StudentInfo s2 = new StudentInfo(103, "Raju");
		StudentInfo s3 = new StudentInfo(104, "Madhu");
		StudentInfo s4 = new StudentInfo(105, "Achari");
		StudentInfo s5 = new StudentInfo(106, "Rajgovind");

		List<StudentInfo> studentsList = new ArrayList<>();
		studentsList.add(s);
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);
		studentsList.add(s4);
		studentsList.add(s5);
		repo.saveAll(studentsList);
		System.out.println("Completed");

	}

}
