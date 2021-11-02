package com.ct.inbox.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.inbox.model.Staff;
import com.ct.inbox.service.InboxService;



@RestController
@RequestMapping(value = "/inbox/")
public class InboxController {

	
	
	@Autowired
	private InboxService inboxService;
	
	@GetMapping("physicians")
	public ResponseEntity<?> getAllPhysicians(){
		try{
			return new ResponseEntity<List<Staff>>(inboxService.getAllPhysicians(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
