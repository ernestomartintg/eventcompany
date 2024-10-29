package com.utp.eventcompany.repository;

import com.utp.eventcompany.model.EstadoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoEventoRepository extends JpaRepository<EstadoEvento,Integer> {
}
