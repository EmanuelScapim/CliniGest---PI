package io.github.projetopi.pi.controller.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

public record DentistaDTO(
        UUID idDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 100, min = 5, message = "O nome não atende os padrões exigidos")
        String nomeDentistaDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 11, min = 11, message = "CPF Fora do padrão")
        @CPF(message = "Cpf inválido")
        String cpfDentistaDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 11, min = 10, message = "Telefone fora do padrão")
        String telefoneDentistaDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 100,min = 8, message = "Email fora do padrão")
        @Email
        String emailDentistaDto,

        @NotNull(message = "Campo obrigatório")
        @Past(message = "A data de nascimento não pode ser no futuro ou presente")
        LocalDate dataNascimentoDentistaDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 12, min = 4, message = "CRO fora do padrão")
        String croDentistaDto,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 20, min = 5, message = "Especialidade fora do padrão")
        String especialidadeDentistaDto) {
}
