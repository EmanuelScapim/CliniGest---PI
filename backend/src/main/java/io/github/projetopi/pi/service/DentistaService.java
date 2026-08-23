package io.github.projetopi.pi.service;


import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.repository.DentistaRepository;
import io.github.projetopi.pi.validator.DentistaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DentistaService {

    private final DentistaRepository dentistaRepository;
    private final DentistaValidator dentistaValidator;

    public Dentista cadastraDeentistaService(Dentista dentista){
        dentistaValidator.validaDentista(dentista);
        return dentistaRepository.save(dentista);
    }

    public List<Dentista> pesquisaByExample(String nome,
                                            String cpf,
                                            String cro,
                                            String email,
                                            String especialidade){
        var dentista = new Dentista();
        dentista.setNomePessoa(nome);
        dentista.setCpf(cpf);
        dentista.setCro(cro);
        dentista.setEmailPessoa(email);
        dentista.setEspecialidade(especialidade);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Dentista> dentistaExample = Example.of(dentista, matcher);

        return dentistaRepository.findAll(dentistaExample);
    }

    public void deletarDentistaPorCpfOuId(String cpf,
                                          String cro,
                                          String email,
                                          String nome){
        var dentista = new Dentista();
        dentista.setCpf(cpf);
        dentista.setCro(cro);
        dentista.setEmailPessoa(email);
        dentista.setNomePessoa(nome);

        ExampleMatcher matcher =ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        List<Dentista> dentistaEncotrado= dentistaRepository.findAll(Example.of(dentista, matcher));
        dentistaRepository.deleteAll(dentistaEncotrado);
    }

}
