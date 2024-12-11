package com.sandoval.test.technicanl.doublev.repository;

import com.sandoval.test.technicanl.doublev.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
