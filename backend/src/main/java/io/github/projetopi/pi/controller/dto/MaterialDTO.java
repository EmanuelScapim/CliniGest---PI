package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record MaterialDTO(
        UUID idDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 50, min = 3, message = "O nome não atende os padrões exigidos")
        String nomeMaterialDto,

        @NotNull(message = "Campo obrigatório")
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        Integer quantidadeMaterialDto) {}
