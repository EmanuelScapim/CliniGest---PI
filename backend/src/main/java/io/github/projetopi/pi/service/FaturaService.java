package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.Fatura;
import io.github.projetopi.pi.repository.AgendamentoRepository;
import io.github.projetopi.pi.repository.FaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FaturaService {

    private final FaturaRepository faturaRepository;
    private final AgendamentoRepository agendamentoRepository;

    public Fatura cadastrarFatura(Fatura fatura, UUID agendamentoId){
        Agendamento agendamento = buscarAgendamento(agendamentoId);

        if(agendamento.getFatura() != null){
            throw new RegistroDuplicadoException("Agendamento já possui fatura vinculada");
        }

        fatura.setAgendamento(agendamento);
        return faturaRepository.save(fatura);
    }

    public List<Fatura> listarTodas(){
        return faturaRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        faturaRepository.deleteById(id);
    }

    public void atualizarFatura(Fatura fatura){
        if(fatura.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que a fatura exista");
        }

        faturaRepository.save(fatura);
    }

    public Optional<Fatura> encontrarPorId(UUID id){
        return faturaRepository.findById(id);
    }

    private Agendamento buscarAgendamento(UUID id){
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
    }

}
