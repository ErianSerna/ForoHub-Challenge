package com.challenge.ForoHubChallenge.domain.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private LocalDateTime fecha_creacion;
    private Boolean activo;

    public Topico(datosTopico datos){
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.fecha_creacion = LocalDateTime.now();
    }

    public void actualizarDatos(datosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo()!= null){
            this.titulo = datosActualizarTopico.titulo();

        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico(){
        this.activo = false;
    }
}
