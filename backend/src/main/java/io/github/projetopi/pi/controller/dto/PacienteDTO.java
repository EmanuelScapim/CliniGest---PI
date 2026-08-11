package io.github.projetopi.pi.controller.dto;

import io.github.projetopi.pi.model.Paciente;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteDTO(
        String nomePacienteDto,
        String cpfPacienteDto,
        String telefonePacienteDto,
        String emailPacienteDto,
        LocalDate dataNascimentoPacienteDto
) {

    public Paciente mapearPaciente(){
        Paciente paciente = new Paciente();
        paciente.setNomePessoa(this.nomePacienteDto);
        paciente.setCpf(this.cpfPacienteDto);
        paciente.setTelefonePessoa(this.telefonePacienteDto);
        paciente.setEmailPessoa(this.emailPacienteDto);
        paciente.setDataNascimento(this.dataNascimentoPacienteDto);

        return paciente;
    }

    public static PacienteDTO listaPacientes(Paciente paciente){
        return new PacienteDTO(
                paciente.getNomePessoa(),
                paciente.getCpf(),
                paciente.getEmailPessoa(),
                paciente.getTelefonePessoa(),
                paciente.getDataNascimento()
        );
    }
}
