package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AnamneseDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID pacienteIdDto,

        @NotBlank(message = "Campo obrigatório")
        String alergiasPacienteDto,

        @NotBlank(message = "Campo obrigatório")
        String historicoMedicoDto,

        @NotBlank(message = "Campo obrigatório")
        String medicamentosDto,

        @NotBlank(message = "Campo obrigatório")
        String detalhesDto) {}
