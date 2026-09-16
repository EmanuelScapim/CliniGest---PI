package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProntuarioDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID pacienteIdDto,

        @NotNull(message = "Campo obrigatório")
        UUID odontogramaIdDto,

        @NotNull(message = "Campo obrigatório")
        UUID anamneseIdDto) {}
