package com.ct.inbox.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.annotations.Check;

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
	@NotNull(message="Sender Must Required")
	private Staff sender;
	
	@NotNull(message = "receievr Required")
	@OneToOne
	private Staff receiver;

	@Check(constraints = "message<200")
	private String message;
	
	private String[] reply;
	
	@DefaultValue(value = "false")
	private boolean urgency;
	@DefaultValue(value = "false")
	private boolean isdeleted;
	@DefaultValue(value = "false")
	private boolean isRead;
	
	
}
