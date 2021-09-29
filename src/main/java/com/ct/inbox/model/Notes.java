package com.ct.inbox.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long notesid;
	private Date date;
	
	private long sender;	
	private long receiver;
	
	
	private String message;
	private boolean urgency;
	
	

}
