package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record OdontogramaDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID pacienteIdDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 25, message = "A imagem não atende os padrões exigidos")
        String imgOdontogramaDto) {}
