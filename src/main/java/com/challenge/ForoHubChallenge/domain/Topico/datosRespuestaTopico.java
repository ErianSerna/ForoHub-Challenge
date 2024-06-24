package com.challenge.ForoHubChallenge.domain.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record datosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {

    public datosRespuestaTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getAutor(),topico.getCurso());
    }

}
