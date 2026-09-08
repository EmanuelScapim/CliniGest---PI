package io.github.projetopi.pi.service;

import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.repository.AgendamentoRepository;
import io.github.projetopi.pi.repository.DentistaRepository;
import io.github.projetopi.pi.repository.PacienteRepository;
import io.github.projetopi.pi.repository.TratamentoRepository;
import io.github.projetopi.pi.validator.AgendamentoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PacienteRepository pacienteRepository;
    private final DentistaRepository dentistaRepository;
    private final TratamentoRepository tratamentoRepository;
    private final AgendamentoValidator agendamentoValidator;

    public Agendamento cadastrarAgendamento(Agendamento agendamento, UUID pacienteId, UUID dentistaId, Set<UUID> tratamentoIds){
        agendamento.setPaciente(buscarPaciente(pacienteId));
        agendamento.setDentista(buscarDentista(dentistaId));
        agendamento.setTratamentos(buscarTratamentos(tratamentoIds));
        agendamentoValidator.validaConflito(agendamento);
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> pesquisar(String pacienteNome, String dentistaNome){
        if(pacienteNome != null){
            return agendamentoRepository.listarAgendamentosPorPaciente(pacienteNome);
        }

        if(dentistaNome != null){
            return agendamentoRepository.listarAgendamentosPorDentista(dentistaNome);
        }

        return agendamentoRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        agendamentoRepository.deleteById(id);
    }

    public void atualizarAgendamento(Agendamento agendamento, UUID pacienteId, UUID dentistaId, Set<UUID> tratamentoIds){
        if(agendamento.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o agendamento exista");
        }

        agendamento.setPaciente(buscarPaciente(pacienteId));
        agendamento.setDentista(buscarDentista(dentistaId));
        agendamento.setTratamentos(buscarTratamentos(tratamentoIds));
        agendamentoValidator.validaConflito(agendamento);
        agendamentoRepository.save(agendamento);
    }

    public Optional<Agendamento> encontrarPorId(UUID id){
        return agendamentoRepository.findById(id);
    }

    private Paciente buscarPaciente(UUID id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
    }

    private Dentista buscarDentista(UUID id){
        return dentistaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dentista não encontrado"));
    }

    private Set<Tratamento> buscarTratamentos(Set<UUID> tratamentoIds){
        Set<Tratamento> tratamentos = new HashSet<>(tratamentoRepository.findAllById(tratamentoIds));

        if(tratamentos.size() != tratamentoIds.size()){
            throw new IllegalArgumentException("Um ou mais tratamentos não foram encontrados");
        }

        return tratamentos;
    }

}
