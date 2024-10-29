package com.utp.eventcompany.controller;

import com.utp.eventcompany.model.EstadoEvento;
import com.utp.eventcompany.model.TipoDocumento;
import com.utp.eventcompany.service.impl.TipoDocumentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listar(){
        List<TipoDocumento> lista = service.listar();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> listarPorId(@PathVariable("id") int id){
        TipoDocumento estado = service.listarPorId(id);
        return ResponseEntity.ok().body(estado);
        // comentar
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> registrar(@RequestBody TipoDocumento objeto){
        TipoDocumento obj= service.registrar(objeto);
        return new ResponseEntity<TipoDocumento>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TipoDocumento> modificar(@RequestBody TipoDocumento obj){
        TipoDocumento estado = service.modificar(obj);
        return ResponseEntity.ok().body(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}
