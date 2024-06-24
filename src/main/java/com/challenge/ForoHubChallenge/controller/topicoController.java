package com.challenge.ForoHubChallenge.controller;

import com.challenge.ForoHubChallenge.domain.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class topicoController {

    @Autowired
    private topicoRepository repository;

    @PostMapping
    public ResponseEntity<datosRespuestaTopico> registrarTopico(@RequestBody @Valid datosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = repository.save(new Topico(datosTopico));
        datosRespuestaTopico datosRespuestaTopico = new datosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
        //Return 201 Created
        //URL donde encontrar el tópico
        //GET http://localhost:8080/topicos/xx
    }

    @GetMapping
    public ResponseEntity<Page<datosRespuestaTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(repository.findByActivoTrue(paginacion).map(datosRespuestaTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity ActualizarTopico(@RequestBody @Valid datosActualizarTopico datosActualizarTopico){
        Topico topico = repository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new datosActualizarTopico(topico.getId(),topico.getTitulo(), topico.getMensaje()));
    }

    @DeleteMapping("/{id}")
    @Transactional
// El @PathVariable sirve para asignarle lo que llegue del link al método
    //DELETE LOGICO
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional

    public ResponseEntity<datosRespuestaTopico> retornoDatosMedico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        var datosTopico = new datosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }



}
