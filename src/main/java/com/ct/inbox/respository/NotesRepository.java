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

	@Query(value = "select * FROM notes n INNER JOIN staff_details s on s.user_id = n.receiver_user_id INNER Join roles r on s.role_id = r.role_Id where n.receiver_user_id = :receiver_user_id", nativeQuery = true)
	List<Notes> findAllByReceiver(@Param("receiver_user_id") int receiver_user_id);


	

}
