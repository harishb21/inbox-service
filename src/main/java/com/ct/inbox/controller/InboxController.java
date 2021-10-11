package com.ct.inbox.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.inbox.model.Notes;
import com.ct.inbox.model.Staff;
import com.ct.inbox.service.InboxService;
import com.ct.inbox.service.NoteService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(value = "*")
@RestController
@Slf4j
public class InboxController {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private InboxService inboxService;
	
	@GetMapping("/inbox/physicians")
	public ResponseEntity<?> getAllPhysicians(){
		try{
			return new ResponseEntity<List<Staff>>(inboxService.getAllPhysicians(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/inbox/notes/{sender_user_id}/{receiver_user_id}")
	public List<Notes> allUsersNotes(@PathVariable long sender_user_id, @PathVariable long receiver_user_id) {
		log.info("Iam in notes inbox controller get allUserNotes");
		return noteService.getAllNotes(sender_user_id,receiver_user_id);
	}
	
	@GetMapping("/inbox/notes/recieved/{sender_user_id}")
	public List<Notes> allRecievedNotes(@PathVariable int sender_user_id) {
		return noteService.getUserRecievedNotes(sender_user_id);
	}

	/**
	 * Validating Data and Sending to DB
	 * 
	 * @param newnotes
	 * @return
	 */
	@PostMapping("/inbox/notes")
	public ResponseEntity<?> newNotes( @RequestBody Notes notes) {
		log.info(notes.getSender().getUserId().toString());
		Notes response = noteService.save(notes);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * Return notes Based on their ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/inbox/notes/{id}")
	public List<Notes> getOneNote(@PathVariable long id) {
		log.info("I am in controller");
		List<Notes> notes = noteService.getNotes(id);
		return notes;
	}
	
	@GetMapping("/inbox/all")
	public List<Notes> notes(){
		return noteService.allNotes();
	}


}
