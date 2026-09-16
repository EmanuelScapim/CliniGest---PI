package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.ExclusaoNaoPermitidaException;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TratamentoService {

    private final TratamentoRepository tratamentoRepository;

    public Tratamento cadastrarTratamento(Tratamento tratamento){
        return tratamentoRepository.save(tratamento);
    }

    public List<Tratamento> pesquisaByExample(String nome, String descricao){
        var tratamento = new Tratamento();
        tratamento.setNomeTratamento(nome);
        tratamento.setDescricao(descricao);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Tratamento> tratamentoExample = Example.of(tratamento, matcher);

        return tratamentoRepository.findAll(tratamentoExample);
    }

    @Transactional
    public void deletarPorId(UUID id){
        if(tratamentoRepository.existsAgendamentoVinculado(id)){
            throw new ExclusaoNaoPermitidaException("Tratamento possui agendamento vinculado e não pode ser excluído");
        }

        tratamentoRepository.deleteById(id);
    }

    public void atualizarTratamento(Tratamento tratamento){
        if(tratamento.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o tratamento exista");
        }

        tratamentoRepository.save(tratamento);
    }

    public Optional<Tratamento> encontrarPorId(UUID id){
        return tratamentoRepository.findById(id);
    }

}
