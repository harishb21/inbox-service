package com.ct.inbox.service;

import java.util.List;
import java.util.Optional;

import com.ct.inbox.model.Notes;

public interface NoteService {


	/**
	 * Returns All the notes
	 * 
	 * @return
	 */
	List<Notes> getAllNotes(long sender_user_id, long reciever_user_id);

	/**
	 * Copy local Data to new model and Notes that
	 * 
	 * @param patient
	 * @return
	 */
	Notes save(Notes notes);

	/**
	 * Returns Patient From By Searching with notes ID
	 * 
	 * @param id
	 * @return
	 */
	List<Notes> getNotes(long id);

	List<Notes> getUserNotes(long sender);

	List<Notes> allNotes();

	List<Notes> getUserRecievedNotes(int sender_user_id);



}
