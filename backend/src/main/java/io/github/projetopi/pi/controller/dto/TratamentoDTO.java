package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record TratamentoDTO(
        UUID idDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 50, min = 3, message = "O nome não atende os padrões exigidos")
        String nomeTratamentoDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 500, min = 5, message = "A descrição não atende os padrões exigidos")
        String descricaoDto,

        @NotNull(message = "Campo obrigatório")
        @Positive(message = "O valor deve ser maior que zero")
        BigDecimal valorDto) {}
