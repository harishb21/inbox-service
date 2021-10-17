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

}
