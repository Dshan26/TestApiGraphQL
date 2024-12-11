package com.sandoval.test.technicanl.doublev.controller;

import com.sandoval.test.technicanl.doublev.entities.Ticket;
import com.sandoval.test.technicanl.doublev.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketGraphQLController {

  private final TicketService ticketService;

  @Autowired
  public TicketGraphQLController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @QueryMapping
  public List<Ticket> getAllTickets(@Argument int page, @Argument int size) {
    return ticketService.getAllTickets(page, size);
  }

  @QueryMapping
  public Ticket getTicketById(@Argument Long id) {
    return ticketService.getTicketById(id).orElse(null);
  }

  @MutationMapping
  public Ticket createTicket(@Argument String usuario, @Argument String estatus) {
    Ticket ticket = new Ticket();
    ticket.setUsuario(usuario);
    ticket.setEstatus(Ticket.Estatus.valueOf(estatus));
    return ticketService.createTicket(ticket);
  }

  @MutationMapping
  public Ticket updateTicket(@Argument Long id, @Argument String usuario, @Argument String estatus) {
    Ticket ticket = new Ticket();
    ticket.setUsuario(usuario);
    ticket.setEstatus(Ticket.Estatus.valueOf(estatus));
    return ticketService.updateTicket(id, ticket);
  }

  @MutationMapping
  public String deleteTicket(@Argument Long id) {
    ticketService.deleteTicket(id);
    return "Ticket with ID " + id + " deleted successfully.";
  }
}