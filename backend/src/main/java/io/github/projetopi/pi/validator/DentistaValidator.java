package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.repository.DentistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DentistaValidator {

    private final DentistaRepository dentistaRepository;

    public void validaDentista(Dentista dentista){
        if(dentistaExiste(dentista)){
            throw new  RegistroDuplicadoException("Dentista já cadastrado");
        }
    }

    private boolean dentistaExiste(Dentista dentista) {
            Optional<Dentista> dentistaEncontrado = dentistaRepository.findByEmailPessoaAndNomePessoaAndCpfAndDataNascimentoAndCroAndEspecialidade(
                    dentista.getEmailPessoa(),
                    dentista.getNomePessoa(),
                    dentista.getCpf(),
                    dentista.getDataNascimento(),
                    dentista.getCro(),
                    dentista.getEspecialidade()
            );

            if(dentista.getId() == null){
                return dentistaEncontrado.isPresent();
            }

            return dentistaEncontrado.isPresent() &&  !dentista.getId().equals(dentistaEncontrado.get().getId()) ;
        }
    }
