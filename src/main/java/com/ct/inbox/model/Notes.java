package com.ct.inbox.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Data
@ToString
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long notesid;
	private Date date;
	
	@OneToOne
	private Staff sender;
	
	@OneToOne
	private Staff receiver;

	private String message;
	private String[] reply;
	
	private boolean urgency;
	private boolean isdeleted;
	private boolean isRead;
	
	
}
