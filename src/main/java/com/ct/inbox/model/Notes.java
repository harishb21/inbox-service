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

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Data
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
	private boolean urgency;

	@Override
	public String toString() {
		return "Notes [notesid=" + notesid + ", date=" + date + ", sender=" + sender
				+ ", receiver=" + receiver + ", message=" + message + ", urgency=" + urgency + "]";
	}

	
	



}
