package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.ExclusaoNaoPermitidaException;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.enums.StatusAgendamento;
import io.github.projetopi.pi.repository.AgendamentoRepository;
import io.github.projetopi.pi.repository.PacienteRepository;
import io.github.projetopi.pi.validator.PacienteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private static final Set<StatusAgendamento> STATUS_BLOQUEIA_EXCLUSAO =
            EnumSet.of(StatusAgendamento.AGUARDANDO_CONFIRMACAO, StatusAgendamento.CONFIRMADO);

    private final PacienteRepository pacienteRepository;
    private final PacienteValidator pacienteValidator;
    private final AgendamentoRepository agendamentoRepository;

    public Paciente cadastrarPacienteService(Paciente paciente){
        pacienteValidator.validaPaciente(paciente);
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> pesquisaByExample(String nome, String email, String cpf){

        var paciente = new Paciente();
        paciente.setNomePessoa(nome);
        paciente.setEmailPessoa(email);
        paciente.setCpf(cpf);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Paciente> pacienteExample = Example.of(paciente,matcher);

        return pacienteRepository.findAll(pacienteExample);
    }

    @Transactional
    public void deletarPorId(UUID id){
        if(agendamentoRepository.existsByPacienteIdAndStatusAgendamentoIn(id, STATUS_BLOQUEIA_EXCLUSAO)){
            throw new ExclusaoNaoPermitidaException("Paciente possui agendamento aguardando confirmação ou confirmado e não pode ser excluído");
        }

        pacienteRepository.deleteById(id);
    }

    public void atualizarPaciente(Paciente paciente){
        if(paciente.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o paciente exista");
        }
        pacienteValidator.validaPaciente(paciente);
        pacienteRepository.save(paciente);
    }

    public Optional<Paciente> obterPorId(UUID id){
       return pacienteRepository.findById(id);
    }
}
