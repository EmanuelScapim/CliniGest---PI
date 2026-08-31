package io.github.projetopi.pi.validator;


import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PacienteValidator {

    private  final PacienteRepository pacienteRepository;

    public void validaPaciente(Paciente paciente){
        if(pertenceAOutroPaciente(pacienteRepository.findByCpf(paciente.getCpf()), paciente.getId())){
            throw new RegistroDuplicadoException("CPF já cadastrado");
        }

        if(pertenceAOutroPaciente(pacienteRepository.findByEmailPessoa(paciente.getEmailPessoa()), paciente.getId())){
            throw new RegistroDuplicadoException("Email já cadastrado");
        }
    }

    private boolean pertenceAOutroPaciente(Optional<Paciente> pacienteEncontrado, UUID id){
        if(pacienteEncontrado.isEmpty()){
            return false;
        }

        if(id == null){
            return true;
        }

        return !id.equals(pacienteEncontrado.get().getId());
    }
}
