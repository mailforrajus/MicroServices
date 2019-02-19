package com.cfg.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceRestController {

	@Autowired
	private StudentRepo repo;

	@RequestMapping(value = "/getAllstudentsInfo", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<StudentInfo> getAllStudents() {
		return repo.findAll();
	}
}
