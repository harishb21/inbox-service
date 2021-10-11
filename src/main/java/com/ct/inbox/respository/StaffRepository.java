package com.ct.inbox.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.inbox.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
