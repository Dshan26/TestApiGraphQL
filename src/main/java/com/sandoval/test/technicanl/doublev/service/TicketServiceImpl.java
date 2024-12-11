package com.sandoval.test.technicanl.doublev.service;

import com.sandoval.test.technicanl.doublev.entities.Ticket;
import com.sandoval.test.technicanl.doublev.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  private final TicketRepository ticketRepository;

  public TicketServiceImpl(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @Override
  public Ticket createTicket(Ticket ticket) {
    ticket.setFechaCreacion(LocalDateTime.now());
    ticket.setFechaActualizacion(LocalDateTime.now());
    return ticketRepository.save(ticket);
  }

  @Override
  public Ticket updateTicket(Long id, Ticket ticket) {
    return ticketRepository.findById(id).map(existingTicket -> {
      existingTicket.setUsuario(ticket.getUsuario());
      existingTicket.setEstatus(ticket.getEstatus());
      existingTicket.setFechaActualizacion(LocalDateTime.now());
      return ticketRepository.save(existingTicket);
    }).orElseThrow(() -> new IllegalArgumentException("Ticket not found with id: " + id));
  }

  @Override
  public void deleteTicket(Long id) {
    if (ticketRepository.existsById(id)) {
      ticketRepository.deleteById(id);
    } else {
      throw new IllegalArgumentException("Ticket not found with id: " + id);
    }
  }

  @Override
  public Optional<Ticket> getTicketById(Long id) {
    return ticketRepository.findById(id);
  }

  @Override
  public List<Ticket> getAllTickets(int page, int size) {
    return ticketRepository.findAll(PageRequest.of(page, size)).getContent();
  }


}
