package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ConsumoMaterialDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID materialIdDto,

        @NotNull(message = "Campo obrigatório")
        UUID tratamentoIdDto,

        @NotNull(message = "Campo obrigatório")
        @Positive(message = "A quantidade deve ser maior que zero")
        Integer quantidadeDto) {}
