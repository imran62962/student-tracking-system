package com.myDepartment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity    
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String regId;
	private String y20it101;
    private String y20it102;
    private String y20it103;
    private String y20itl101;
    private String y20itl102;
    private String y20itl103;
    private String y20itl104;

    // Constructors, getters, and setters
    public Marks() {}

    public Marks(String regId, String y20it101, String y20it102, String y20it103, String y20itl101,
			String y20itl102, String y20itl103, String y20itl104) {
		
		this.regId = regId;
		this.y20it101 = y20it101;
		this.y20it102 = y20it102;
		this.y20it103 = y20it103;
		this.y20itl101 = y20itl101;
		this.y20itl102 = y20itl102;
		this.y20itl103 = y20itl103;
		this.y20itl104 = y20itl104;
	}
    public String getRegId() {
		return regId;
	}

	public void setRegId(String regid) {
		this.regId = regid;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getY20it101() {
		return y20it101;
	}

	public void setY20it101(String y20it101) {
		this.y20it101 = y20it101;
	}

	public String getY20it102() {
		return y20it102;
	}

	public void setY20it102(String y20it102) {
		this.y20it102 = y20it102;
	}

	public String getY20it103() {
		return y20it103;
	}

	public void setY20it103(String y20it103) {
		this.y20it103 = y20it103;
	}

	public String getY20itl101() {
		return y20itl101;
	}

	public void setY20itl101(String y20itl101) {
		this.y20itl101 = y20itl101;
	}

	public String getY20itl102() {
		return y20itl102;
	}

	public void setY20itl102(String y20itl102) {
		this.y20itl102 = y20itl102;
	}

	public String getY20itl103() {
		return y20itl103;
	}

	public void setY20itl103(String y20itl103) {
		this.y20itl103 = y20itl103;
	}

	public String getY20itl104() {
		return y20itl104;
	}

	public void setY20itl104(String y20itl104) {
		this.y20itl104 = y20itl104;
	}

    
	
	

}
