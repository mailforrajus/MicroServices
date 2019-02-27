package com.cfg.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudentInfo {

	@Id
	private int studentId;

	@Column
	private String studentName;

	@Column
	private String courseStatus;

	public StudentInfo() {
		super();
	}

	public StudentInfo(int studentId, String studentName, String courseStatus) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseStatus = courseStatus;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

}
