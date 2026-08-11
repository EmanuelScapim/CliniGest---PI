package io.github.projetopi.pi.service;

import io.github.projetopi.pi.controller.dto.PacienteDTO;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente cadastrarPacienteService(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<PacienteDTO> listarTodosPacientesService(){
        return pacienteRepository.findAll().stream()
                .map(PacienteDTO::listaPacientes)
                .collect(Collectors.toList());
    }

    public List<PacienteDTO> buscarPorNomeOuEmailService(String termo){
        return pacienteRepository.buscarPorNomeOuEmail(termo).stream()
                .map(PacienteDTO::listaPacientes)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePorEmailService(String email){
        pacienteRepository.deleteByEmailPessoa(email);
    }
}
