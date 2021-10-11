package com.ct.inbox.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ct.inbox.model.Notes;
import com.ct.inbox.model.Staff;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	@Query(value = "select * FROM notes n INNER JOIN staff_details s on s.user_id = n.sender_user_id INNER Join roles r on s.role_id = r.role_Id where n.sender_user_id = :sender_user_id", nativeQuery = true)
	List<Notes> findAllBySender(int sender_user_id);

//	@Query(value = "select s.user_id, n.notesid, s.first_name, s.last_name, r.role_name, n.date, n.message, n.urgency FROM notes n INNER JOIN staff_details s on s.user_id = n.sender_user_id INNER Join roles r on s.role_id = r.role_Id where n.sender_user_id = :sender_user_id AND n.receiver_user_id = :receiver_user_id", nativeQuery = true)
//	List<Notes> findAll(@Param("sender_user_id")long sender_user_id,@Param("receiver_user_id") long receiver);

	//List<Notes> findAllBySender_User_Id(long sender_user_id);
	

}
