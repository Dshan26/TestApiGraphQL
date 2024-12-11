package com.sandoval.test.technicanl.doublev.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String usuario;

  @Column(nullable = false, updatable = false)
  private LocalDateTime fechaCreacion;

  @Column(nullable = false)
  private LocalDateTime fechaActualizacion;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Estatus estatus;

  public Ticket() {
  }

  public Ticket(Long id, String usuario, LocalDateTime
          fechaCreacion, LocalDateTime fechaActualizacion,
                Estatus estatus) {
    this.id = id;
    this.usuario = usuario;
    this.fechaCreacion = fechaCreacion;
    this.fechaActualizacion = fechaActualizacion;
    this.estatus = estatus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public LocalDateTime getFechaActualizacion() {
    return fechaActualizacion;
  }

  public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

  public Estatus getEstatus() {
    return estatus;
  }

  public void setEstatus(Estatus estatus) {
    this.estatus = estatus;
  }

  public enum Estatus {
    ABIERTO,
    CERRADO
  }

}
