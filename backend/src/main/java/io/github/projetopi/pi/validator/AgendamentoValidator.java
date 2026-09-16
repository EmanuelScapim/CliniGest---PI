package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.enums.StatusAgendamento;
import io.github.projetopi.pi.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AgendamentoValidator {

    private static final Set<StatusAgendamento> STATUS_CONSIDERADOS_NO_CONFLITO =
            EnumSet.of(StatusAgendamento.AGUARDANDO_CONFIRMACAO, StatusAgendamento.CONFIRMADO);

    private static final Duration INTERVALO_MINIMO = Duration.ofMinutes(10);

    private final AgendamentoRepository agendamentoRepository;

    public void validaConflito(Agendamento agendamento){
        if(!agendamento.getDataHora().isBefore(agendamento.getDataHoraFim())){
            throw new IllegalArgumentException("A data/hora de início deve ser anterior à data/hora de fim");
        }

        Instant inicioComTolerancia = agendamento.getDataHora().minus(INTERVALO_MINIMO);
        Instant fimComTolerancia = agendamento.getDataHoraFim().plus(INTERVALO_MINIMO);

        if(agendamentoRepository.existsConflitoHorarioDentista(agendamento.getDentista().getId(), STATUS_CONSIDERADOS_NO_CONFLITO,
                agendamento.getId(), inicioComTolerancia, fimComTolerancia)){
            throw new RegistroDuplicadoException("Dentista já possui agendamento nesse horário");
        }

        if(agendamentoRepository.existsConflitoHorarioPaciente(agendamento.getPaciente().getId(), STATUS_CONSIDERADOS_NO_CONFLITO,
                agendamento.getId(), inicioComTolerancia, fimComTolerancia)){
            throw new RegistroDuplicadoException("Paciente já possui agendamento nesse horário");
        }
    }
}
