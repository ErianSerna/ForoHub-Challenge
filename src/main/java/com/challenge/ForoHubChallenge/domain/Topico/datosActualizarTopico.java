package com.challenge.ForoHubChallenge.domain.Topico;

import jakarta.validation.constraints.NotNull;

public record datosActualizarTopico(

        @NotNull
        Long id,
        String titulo,
        String mensaje

) {
}
