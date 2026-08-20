package io.github.projetopi.pi.validator;


import io.github.projetopi.pi.exeptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PacienteValidador {

    private  final PacienteRepository pacienteRepository;

    public void validaPaciente(Paciente paciente){
        if(pacienteExisteCadastrado(paciente)){
            throw new RegistroDuplicadoException("Paciente já cadastrado");
        }
    }

    private boolean pacienteExisteCadastrado(Paciente paciente){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByEmailPessoaAndNomePessoaAndCpfAndDataNascimento(
                paciente.getEmailPessoa(),
                paciente.getNomePessoa(),
                paciente.getCpf(),
                paciente.getDataNascimento()
        );

        if(paciente.getId() == null){
            return pacienteEncontrado.isPresent();
        }

        return pacienteEncontrado.isPresent() &&  !paciente.getId().equals(pacienteEncontrado.get().getId()) ;
    }
}
