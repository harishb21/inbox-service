package com.ct.inbox.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public Notes save(Notes notes) {
	
		Staff sender = restTemplate.getForObject("http://USER-SERVICE/employees/"+notes.getSender().getUserId(), Staff.class);
		Staff receiver =restTemplate.getForObject("http://USER-SERVICE/employees/"+notes.getReceiver().getUserId(), Staff.class);
		notes.setSender(sender);
		notes.setReceiver(receiver);
		notes.setIsdeleted(false);
		notes.setReply(new String[] {});
		notes.setDate(new Date(System.currentTimeMillis()));
		return notesRepository.save(notes);
		
	}

	@Override
	public List<Notes> getUserSentNotes(int sender_userid) {
		
		return notesRepository.findAllBySender(sender_userid);
		
			//return new ArrayList<Notes>();
	}
	@Override
	public List<Notes> getUserRecievedNotes(int receiver_user_id) {
//		try {
			log.info(notesRepository.findAllByReceiver(receiver_user_id).toString());
		return notesRepository.findAllByReceiver(receiver_user_id);
//		}
//		catch(Exception e) {
//			return new ArrayList<Notes>();
//		}
	}
	@Override
	public void addReply(Notes note) {
		Notes obj = notesRepository.getById(note.getNotesid());
		obj.setReply(note.getReply());
		notesRepository.save(obj);
		
	}
	@Override
	public void deleteNotes(long notesId) {
		Notes obj = notesRepository.getById(notesId);
		obj.setIsdeleted(true);
		notesRepository.save(obj);
		
	}

	@Override
	public Map<String, Object> getNonReadCount(int receiver_user_id) {
		long count = notesRepository.countByIsRead(receiver_user_id);
		Map<String, Object> response = new HashMap<>();
		response.put("nonreadcount", count);
		return response;
	}

	@Override
	public Map<String, Object> messageRead(long notesId) {
		Notes note= notesRepository.findByNotesid(notesId);
		note.setRead(true);
		notesRepository.save(note);
		
		Map<String, Object> response = new HashMap<>();
		response.put("Message read", new String());
		
		return response;
	}

}
;