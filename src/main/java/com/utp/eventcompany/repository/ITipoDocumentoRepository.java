package com.utp.eventcompany.repository;


import com.utp.eventcompany.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
