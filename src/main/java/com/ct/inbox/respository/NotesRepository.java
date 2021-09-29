package com.ct.inbox.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ct.inbox.model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	@Query(value = "SELECT *  FROM notes WHERE sender = :sender AND receiver =:receiver ", nativeQuery = true)
	List<Notes> findAllBySenderAndReceiver(@Param("sender")long sender,@Param("receiver") long receiver);
	

}
