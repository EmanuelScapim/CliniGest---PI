package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteDTO(
        UUID idDTO,

        @NotBlank(message = "Campo obrigatorio")
        @Size(max = 100,  min = 5, message = "O nome não atende os padrões exigidos")
        String nomePacienteDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 11, message = "CPF não existente")
        @CPF
        String cpfPacienteDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 11,min = 10 ,message = "Numero não existe")
        String telefonePacienteDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 100,min = 8, message = "Campo fora do padrão")
        @Email
        String emailPacienteDto,

        @NotNull
        @Past(message = "A data não pode ser do futuro")
        LocalDate dataNascimentoPacienteDto
) {}
