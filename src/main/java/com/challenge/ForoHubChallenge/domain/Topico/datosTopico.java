package com.challenge.ForoHubChallenge.domain.Topico;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record datosTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha_creacion,
        @NotBlank
        String autor,
        @NotBlank
        String curso

){}
