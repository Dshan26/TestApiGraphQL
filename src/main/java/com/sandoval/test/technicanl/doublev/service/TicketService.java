package com.sandoval.test.technicanl.doublev.service;

import com.sandoval.test.technicanl.doublev.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
  Ticket createTicket(Ticket ticket);
  Ticket updateTicket(Long id, Ticket ticket);

  void deleteTicket(Long id);

  Optional<Ticket> getTicketById(Long id);
  List<Ticket> getAllTickets(int page, int size);
}
