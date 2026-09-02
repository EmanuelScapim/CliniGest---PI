package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Anamnese;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.AnamneseRepository;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnamneseService {

    private final AnamneseRepository anamneseRepository;
    private final PacienteRepository pacienteRepository;

    public Anamnese cadastrarAnamnese(Anamnese anamnese, UUID pacienteId){
        if(anamneseRepository.existsByPacienteId(pacienteId)){
            throw new RegistroDuplicadoException("Paciente já possui anamnese vinculada");
        }

        anamnese.setId(UUID.randomUUID());
        anamnese.setPaciente(buscarPaciente(pacienteId));
        return anamneseRepository.save(anamnese);
    }

    public List<Anamnese> listarTodas(){
        return anamneseRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        anamneseRepository.deleteById(id);
    }

    public void atualizarAnamnese(Anamnese anamnese){
        if(anamnese.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que a anamnese exista");
        }

        anamneseRepository.save(anamnese);
    }

    public Optional<Anamnese> encontrarPorId(UUID id){
        return anamneseRepository.findById(id);
    }

    private Paciente buscarPaciente(UUID id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
    }

}
