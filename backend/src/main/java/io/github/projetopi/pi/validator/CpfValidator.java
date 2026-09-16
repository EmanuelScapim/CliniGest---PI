package io.github.projetopi.pi.validator;

import org.springframework.stereotype.Component;

@Component
public class CpfValidator {

    public boolean isValido(String cpf) {
        if (cpf == null) {
            return false;
        }

        String cpfNumerico = cpf.replaceAll("\\D", "");

        if (cpfNumerico.length() != 11) {
            return false;
        }

        int primeiroDigitoVerificador = calculaDigitoVerificador(cpfNumerico, 9);
        int segundoDigitoVerificador = calculaDigitoVerificador(cpfNumerico, 10);

        return primeiroDigitoVerificador == Character.getNumericValue(cpfNumerico.charAt(9))
                && segundoDigitoVerificador == Character.getNumericValue(cpfNumerico.charAt(10));
    }

    private int calculaDigitoVerificador(String cpf, int quantidadeDigitos) {
        int soma = 0;
        int peso = quantidadeDigitos + 1;

        for (int i = 0; i < quantidadeDigitos; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }

        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
