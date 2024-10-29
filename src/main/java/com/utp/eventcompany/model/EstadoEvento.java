package com.utp.eventcompany.model;

import jakarta.persistence.*;

@Entity
@Table(name="estadoventos")
public class EstadoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoEvento;

    @Column(name = "estado",nullable = false,length = 50)
    private String estado;

    public Integer getIdEstadoEvento() {
        return idEstadoEvento;
    }

    public void setIdEstadoEvento(Integer idEstadoEvento) {
        this.idEstadoEvento = idEstadoEvento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
