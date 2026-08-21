package io.github.projetopi.pi.controller.dto;

import io.github.projetopi.pi.model.Paciente;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteDTO(
        UUID idDTO,
        String nomePacienteDto,
        String cpfPacienteDto,
        String telefonePacienteDto,
        String emailPacienteDto,
        LocalDate dataNascimentoPacienteDto
) {}
