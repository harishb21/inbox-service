package com.ct.inbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.inbox.model.Notes;
import com.ct.inbox.service.NoteService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(value = "*")
@RestController
@Slf4j
public class NotesController {
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/notes/sent/{sender_user_id}")
	public List<Notes> UserSendNotes(@PathVariable int sender_user_id) {
		log.info("Iam in notes controller get allUserNotes");
		return noteService.getUserSentNotes(sender_user_id);
	}
	
	@GetMapping("/notes/recieved/{receiver_user_id}")
	public List<Notes> allRecievedNotes(@PathVariable int receiver_user_id) {
		return noteService.getUserRecievedNotes(receiver_user_id);
	}
	/**
	 * Validating Data and Sending to DB
	 * 
	 * @param newnotes
	 * @return
	 */
	@PostMapping("notes/save")
	public ResponseEntity<?> newNotes( @RequestBody Notes notes) {
		log.info(notes.getSender().getUserId().toString());
		Notes response = noteService.save(notes);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	/*
	 * sending reply to the dadabase
	 */
	@PutMapping(value ="notes/reply",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addReply(@RequestBody Notes notes){
		try {
			noteService.addReply(notes);
			return new ResponseEntity<String>("Reply send",HttpStatus.OK);
			}
		catch(Exception e) {
			return new ResponseEntity<String>("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@DeleteMapping("notes/delete/{notesId}")
	public ResponseEntity<?> deleteNotes(@PathVariable long notesId){
		try {
			noteService.deleteNotes(notesId);
			return new ResponseEntity<String>("Notes Deleted..!",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
