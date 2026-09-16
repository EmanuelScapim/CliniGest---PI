package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaValidator {

    private final CpfValidator cpfValidator;

    public void validaCpf(Pessoa pessoa) {
        if (!cpfValidator.isValido(pessoa.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }
}
