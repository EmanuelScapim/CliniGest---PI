package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.repository.DentistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DentistaValidator {

    private final DentistaRepository dentistaRepository;

    public void validaDentista(Dentista dentista){
        if(pertenceAOutroDentista(dentistaRepository.findByCpf(dentista.getCpf()), dentista.getId())){
            throw new RegistroDuplicadoException("CPF já cadastrado");
        }

        if(pertenceAOutroDentista(dentistaRepository.findByEmailPessoa(dentista.getEmailPessoa()), dentista.getId())){
            throw new RegistroDuplicadoException("Email já cadastrado");
        }
    }

    private boolean pertenceAOutroDentista(Optional<Dentista> dentistaEncontrado, UUID id) {
        if(dentistaEncontrado.isEmpty()){
            return false;
        }

        if(id == null){
            return true;
        }

        return !id.equals(dentistaEncontrado.get().getId());
    }
}
