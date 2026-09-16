package io.github.projetopi.pi.controller.dto;

import io.github.projetopi.pi.model.enums.ModoPagamento;
import io.github.projetopi.pi.model.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record FaturaDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID agendamentoIdDto,

        @NotNull(message = "Campo obrigatório")
        @Positive(message = "O valor deve ser maior que zero")
        BigDecimal valorTotalDto,

        @NotNull(message = "Campo obrigatório")
        @PastOrPresent(message = "A data de emissão não pode ser no futuro")
        LocalDate dataEmissaoDto,

        @NotNull(message = "Campo obrigatório")
        StatusPagamento statusPagamentoDto,

        @NotNull(message = "Campo obrigatório")
        ModoPagamento modoPagamentoDto) {}
