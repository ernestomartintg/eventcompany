package com.utp.eventcompany.service.impl;

import com.utp.eventcompany.model.TipoDocumento;
import com.utp.eventcompany.repository.ITipoDocumentoRepository;
import com.utp.eventcompany.service.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

    @Autowired
    private ITipoDocumentoRepository repo;

    @Override
    public TipoDocumento registrar(TipoDocumento obj) {
        return repo.save(obj);
    }

    @Override
    public TipoDocumento modificar(TipoDocumento obj) {
        return repo.save(obj);
    }

    @Override
    public List<TipoDocumento> listar() {
        return repo.findAll();
    }

    @Override
    public TipoDocumento listarPorId(Integer id) {
        Optional<TipoDocumento> obj = repo.findById(id);
        return obj.orElse(new TipoDocumento());
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
