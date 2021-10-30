package com.ct.inbox.service;

import java.util.List;
import java.util.Map;

import com.ct.inbox.model.Notes;

public interface NoteService {


	/**
	 * Copy local Data to new model and Notes that
	 * 
	 * @param patient
	 * @return
	 */
	Notes save(Notes notes);

	/**
	 * Returns Notes send by the User sender ID
	 * 
	 * @param id
	 * @return list of notes
	 */

	List<Notes> getUserSentNotes(int sender_userId);

	/**
	 * Returns Notes send by the User sender ID
	 * 
	 * @param id
	 * @return list of notes
	 */

	List<Notes> getUserRecievedNotes(int receiver_userId);
	
	/*
	 * save the reply
	 * for perticular notes
	 * it will return nothing
	 * */
	void addReply(Notes note);

	/*
	 * disable the notes from user
	 * */
	void deleteNotes(long notesId);
	
	Map<String,Object> getNonReadCount(int receiver_user_id);
	Map<String, Object> messageRead(long notesId);
	
}
