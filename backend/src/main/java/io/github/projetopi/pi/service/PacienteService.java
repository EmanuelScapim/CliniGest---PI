package io.github.projetopi.pi.service;

import io.github.projetopi.pi.controller.dto.PacienteDTO;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.PacienteRepository;
import io.github.projetopi.pi.validator.PacienteValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteValidador pacienteValidador;

    public Paciente cadastrarPacienteService(Paciente paciente){
        pacienteValidador.validaPaciente(paciente);
        return pacienteRepository.save(paciente);
    }

    public List<PacienteDTO> listarTodosPacientesService(){
        return pacienteRepository.findAll().stream()
                .map(PacienteDTO::listaPacientes)
                .collect(Collectors.toList());
    }

    public List<Paciente> buscarPorNomeOuEmailOuCpfService(String nome, String email, String cpf){

        if(nome != null && email != null && cpf != null){
           return pacienteRepository.findByEmailPessoaAndNomePessoaAndCpf(nome, email, cpf);
        }

        if(nome != null){
            return pacienteRepository.findByNomePessoa(nome);
        }

        if(email != null){
            return pacienteRepository.findByEmailPessoa(email);
        }

        if(cpf != null){
            return pacienteRepository.findByCpf( cpf);
        }

        return pacienteRepository.findAll();
    }

    @Transactional
    public void deletePorEmailService(String email){
        pacienteRepository.deleteByEmailPessoa(email);
    }

    public void atualizarPaciente(Paciente paciente){
        if(paciente.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o paciente exista");
        }
        pacienteValidador.validaPaciente(paciente);
        pacienteRepository.save(paciente);
    }

    public Optional<Paciente> obterPorId(UUID id){
       return pacienteRepository.findById(id);
    }
}
