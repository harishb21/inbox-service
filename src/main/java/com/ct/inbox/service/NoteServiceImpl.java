package com.ct.inbox.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.inbox.model.Notes;
import com.ct.inbox.model.Staff;
import com.ct.inbox.respository.NotesRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NotesRepository notesRepository;
	@Override
	public List<Notes> getAllNotes(long sender, long receiver) {
		List<Notes> notes = notesRepository.findAllBySenderAndReceiver(sender,receiver);
		return notes;
	}

	@Override
	public Notes save(Notes notes) {
		
		notes.setDate(new Date(System.currentTimeMillis()));
		return notesRepository.save(notes);
		
	}

	@Override
	public Notes getNotes(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
