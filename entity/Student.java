package com.myDepartment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    @Column(unique = true, nullable = false)
//    private String studentId;
//    private String branch;
//    private String year;
//    private String admissionType;
//    private String mentor;
//    
//    private String mentorId;
//    private short cgpa;
//    private String percentage;
//    private short backlogs;
//    private String contact;
//    @Column(unique = true, nullable = false)
//    private String email;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getStudentId() {
//		return studentId;
//	}
//	public void setStudentId(String studentId) {
//		this.studentId = studentId;
//	}
//	public String getBranch() {
//		return branch;
//	}
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//	public String getYear() {
//		return year;
//	}
//	public void setYear(String year) {
//		this.year = year;
//	}
//	public String getAdmissionType() {
//		return admissionType;
//	}
//	public void setAdmissionType(String admissionType) {
//		this.admissionType = admissionType;
//	}
//	public String getMentor() {
//		return mentor;
//	}
//	public void setMentor(String mentor) {
//		this.mentor = mentor;
//	}
//	public String getMentorId() {
//		return mentorId;
//	}
//	public void setMentorId(String mentorId) {
//		this.mentorId = mentorId;
//	}
//	public short getCgpa() {
//		return cgpa;
//	}
//	public void setCgpa(short cgpa) {
//		this.cgpa = cgpa;
//	}
//	public String getPercentage() {
//		return percentage;
//	}
//	public void setPercentage(String percentage) {
//		this.percentage = percentage;
//	}
//	public short getBacklogs() {
//		return backlogs;
//	}
//	public void setBacklogs(short backlogs) {
//		this.backlogs = backlogs;
//	}
//	public String getContact() {
//		return contact;
//	}
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
    
    
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String studentId;
    private String branch;
    private String year;
    private String mentor;
    private String admissionType;

    // Constructors, getters, and setters

    public Student() {
        // Default constructor
    }

    public Student(String name, String studentId, String branch, String year, String mentor, String admissionType) {
        this.name = name;
        this.studentId = studentId;
        this.branch = branch;
        this.year = year;
        this.mentor = mentor;
        this.admissionType = admissionType;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }
    
	
	

}
