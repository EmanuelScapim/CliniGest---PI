package io.github.projetopi.pi.service;


import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.repository.DentistaRepository;
import io.github.projetopi.pi.validator.DentistaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DentistaService {

    private final DentistaRepository dentistaRepository;
    private final DentistaValidator dentistaValidator;

    public Dentista cadastraDeentistaService(Dentista dentista){
        dentistaValidator.validaDentista(dentista);
        return dentistaRepository.save(dentista);
    }

}
