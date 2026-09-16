package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TratamentoValidator {

    private final TratamentoRepository tratamentoRepository;

    public void validaTratamento(Tratamento tratamento){
        if(pertenceAOutroTratamento(tratamentoRepository.findByNomeTratamentoIgnoreCase(tratamento.getNomeTratamento()), tratamento.getId())){
            throw new RegistroDuplicadoException("Tratamento já cadastrado");
        }
    }

    private boolean pertenceAOutroTratamento(Optional<Tratamento> tratamentoEncontrado, UUID id) {
        if(tratamentoEncontrado.isEmpty()){
            return false;
        }

        if(id == null){
            return true;
        }

        return !id.equals(tratamentoEncontrado.get().getId());
    }
}
