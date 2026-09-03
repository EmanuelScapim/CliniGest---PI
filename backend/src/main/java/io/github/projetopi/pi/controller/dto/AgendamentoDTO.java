package io.github.projetopi.pi.controller.dto;

import io.github.projetopi.pi.model.enums.StatusAgendamento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record AgendamentoDTO(
        UUID idDto,

        @NotNull(message = "Campo obrigatório")
        UUID pacienteIdDto,

        @NotNull(message = "Campo obrigatório")
        UUID dentistaIdDto,

        @NotEmpty(message = "É necessário informar ao menos um tratamento")
        Set<UUID> tratamentoIdsDto,

        @NotNull(message = "Campo obrigatório")
        Instant dataHoraDto,

        @NotNull(message = "Campo obrigatório")
        StatusAgendamento statusAgendamentoDto,

        @Size(max = 500, message = "A observação não atende os padrões exigidos")
        String observacaoDto) {}
