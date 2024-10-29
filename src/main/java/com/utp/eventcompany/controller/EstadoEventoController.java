package com.utp.eventcompany.controller;

import com.utp.eventcompany.exception.ModeloNotFoundException;
import com.utp.eventcompany.model.EstadoEvento;
import com.utp.eventcompany.service.IEstadoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/estadoevento")
public class EstadoEventoController {

    @Autowired
    private IEstadoEventoService service;

    @GetMapping
    public ResponseEntity<List<EstadoEvento>> listar(){
        List<EstadoEvento> lista = service.listar();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEvento> listarPorId(@PathVariable("id") int id){
        EstadoEvento estado = service.listarPorId(id);
        if(estado.getIdEstadoEvento()==null){
            throw new ModeloNotFoundException("Id no encontrado: "+id);
        }
        return ResponseEntity.ok().body(estado);
    }

    @PostMapping
    public ResponseEntity<EstadoEvento> registrar(@RequestBody EstadoEvento estadoEvento){
        EstadoEvento obj= service.registrar(estadoEvento);
        return new ResponseEntity<EstadoEvento>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstadoEvento> modificar(@RequestBody EstadoEvento obj){
        EstadoEvento estado = service.modificar(obj);
        return ResponseEntity.ok().body(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
