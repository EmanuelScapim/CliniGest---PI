package io.github.projetopi.pi.service;

import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente cadastrarPacienteService(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
