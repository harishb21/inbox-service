package com.ct.inbox.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.inbox.model.Notes;
import com.ct.inbox.model.Staff;
import com.ct.inbox.respository.NotesRepository;
import com.ct.inbox.respository.StaffRepository;
import com.sun.tools.sjavac.Log;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NotesRepository notesRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<Notes> getAllNotes(long sender, long receiver) {
		
		List<Notes> notes = notesRepository.findAll();
		log.info(notes.toString());
		return notes;
	}

	@Override
	public Notes save(Notes notes) {
	
		Staff sender = restTemplate.getForObject("http://USER-SERVICE/employees/"+notes.getSender().getUserId(), Staff.class);
		Staff receiver =restTemplate.getForObject("http://USER-SERVICE/employees/"+notes.getReceiver().getUserId(), Staff.class);
		notes.setSender(sender);
		notes.setReceiver(receiver);
		notes.setDate(new Date(System.currentTimeMillis()));
		return notesRepository.save(notes);
		
	}

	@Override
	public List<Notes> getNotes(long id) {
		//Notes note = notesRepository.findById(id);
	
		return null;
	}

	@Override
	public List<Notes> getUserNotes(long sender) {
		// TODO Auto-generated method stub
		//List<Notes> notes = notesRepository.findAllBySender_User_Id(sender);
		//log.info(notes.toString());
		return null;
	}

	@Override
	public List<Notes> allNotes() {
		notesRepository.findAll().stream().forEach(System.out::println);
		return notesRepository.findAll();
	}

	@Override
	public List<Notes> getUserRecievedNotes(int sender_user_id) {
		return notesRepository.findAllBySender(sender_user_id);
	}

	

}
