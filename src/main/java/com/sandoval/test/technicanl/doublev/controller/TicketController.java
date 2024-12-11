package com.sandoval.test.technicanl.doublev.controller;

import com.sandoval.test.technicanl.doublev.entities.Ticket;
import com.sandoval.test.technicanl.doublev.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

  private final TicketService ticketService;

  @Autowired
  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping
  public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.createTicket(ticket));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.updateTicket(id, ticket));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
    ticketService.deleteTicket(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
    return ticketService.getTicketById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Ticket>> getAllTickets(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(ticketService.getAllTickets(page, size));
  }
}

