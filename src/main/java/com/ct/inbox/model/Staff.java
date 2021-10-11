package com.ct.inbox.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "staff_details")
public class Staff extends User {


//	private long staffId;

	private Integer role;

	private Integer empId;

//	private String title;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private Date birthDate;

//	private String username;
//	private String password;
//	private boolean deleted;
//	private boolean active;

//	@CreationTimestamp
//	private java.util.Date createdOn;
//
//	@UpdateTimestamp
//	private java.util.Date updatedOn;
	
	
}
