package io.github.projetopi.pi.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CpfValidatorTest {

    private final CpfValidator cpfValidator = new CpfValidator();

    @ParameterizedTest
    @ValueSource(strings = {"52998224725", "529.982.247-25", "11144477735"})
    void deveAceitarCpfComDigitosVerificadoresCorretos(String cpf) {
        assertTrue(cpfValidator.isValido(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {"52998224700", "12345678900", "111111111", "123456789012", ""})
    void deveRejeitarCpfComDigitosVerificadoresIncorretosOuTamanhoInvalido(String cpf) {
        assertFalse(cpfValidator.isValido(cpf));
    }

    @Test
    void deveRejeitarCpfNulo() {
        assertFalse(cpfValidator.isValido(null));
    }
}
