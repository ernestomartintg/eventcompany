package com.utp.eventcompany.service.impl;

import com.utp.eventcompany.model.EstadoEvento;
import com.utp.eventcompany.repository.IEstadoEventoRepository;
import com.utp.eventcompany.service.IEstadoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServicioImpl implements IEstadoEventoService {

    @Autowired
    private IEstadoEventoRepository repo;

    @Override
    public EstadoEvento registrar(EstadoEvento estadoEvento) {
        return repo.save(estadoEvento);
    }

    @Override
    public EstadoEvento modificar(EstadoEvento estadoEvento) {
        return repo.save(estadoEvento);
    }

    @Override
    public List<EstadoEvento> listar() {
        System.out.println(repo.findAll().size());
        return repo.findAll();
    }

    @Override
    public EstadoEvento listarPorId(Integer id) {
        Optional<EstadoEvento> estadoEvento = repo.findById(id);
        return estadoEvento.isPresent() ? estadoEvento.get() : new EstadoEvento();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
