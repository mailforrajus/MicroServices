package com.cfg.client;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceRestController {

	@Autowired
	private StudentRepo repo;

	@RequestMapping(value = "/getAllstudentsInfo", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@Cacheable("getAllstudentsInfo")
	public List<StudentInfo> getAllStudents() {
		return repo.findAll();
	}

	@RequestMapping(value = "/updateAllStudentsInfo")
	public String updateAllStudents() {

		long startTime = System.currentTimeMillis();
		process(repo.getStudentsUsingStatus());
		long endTime = System.currentTimeMillis();
		return "completed in " + (endTime - startTime) / 1000;
	}

	/**
	 * using multi threading to proceess records
	 * 
	 * @param studentsUsingStatus
	 */
	private void process(List<StudentInfo> studentsUsingStatus) {

		ExecutorService ex = Executors.newFixedThreadPool(5);
		CompletionService<String> c = new ExecutorCompletionService<String>(ex);
		long time1 = System.currentTimeMillis();

		for (StudentInfo studentInfo : studentsUsingStatus) {
			c.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					studentInfo.setCourseStatus("C");
					repo.save(studentInfo);
					return null;
				}
			});

		}
	}
}
