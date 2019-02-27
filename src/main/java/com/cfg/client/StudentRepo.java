package com.cfg.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentInfo, Integer> {

	
	@Query("From StudentInfo where courseStatus='p'")
	List<StudentInfo> getStudentsUsingStatus();

}
