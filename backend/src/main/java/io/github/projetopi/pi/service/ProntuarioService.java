package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Anamnese;
import io.github.projetopi.pi.model.Odontograma;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.Prontuario;
import io.github.projetopi.pi.repository.AnamneseRepository;
import io.github.projetopi.pi.repository.OdontogramaRepository;
import io.github.projetopi.pi.repository.PacienteRepository;
import io.github.projetopi.pi.repository.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final OdontogramaRepository odontogramaRepository;
    private final AnamneseRepository anamneseRepository;

    public Prontuario cadastrarProntuario(Prontuario prontuario, UUID pacienteId, UUID odontogramaId, UUID anamneseId){
        if(prontuarioRepository.existsByPacienteId(pacienteId)){
            throw new RegistroDuplicadoException("Paciente já possui prontuário vinculado");
        }

        prontuario.setId(UUID.randomUUID());
        prontuario.setPaciente(buscarPaciente(pacienteId));
        prontuario.setOdontograma(buscarOdontograma(odontogramaId));
        prontuario.setAnamnese(buscarAnamnese(anamneseId));
        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> listarTodos(){
        return prontuarioRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        prontuarioRepository.deleteById(id);
    }

    public void atualizarProntuario(Prontuario prontuario, UUID odontogramaId, UUID anamneseId){
        if(prontuario.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o prontuário exista");
        }

        prontuario.setOdontograma(buscarOdontograma(odontogramaId));
        prontuario.setAnamnese(buscarAnamnese(anamneseId));
        prontuarioRepository.save(prontuario);
    }

    public Optional<Prontuario> encontrarPorId(UUID id){
        return prontuarioRepository.findById(id);
    }

    private Paciente buscarPaciente(UUID id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
    }

    private Odontograma buscarOdontograma(UUID id){
        return odontogramaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Odontograma não encontrado"));
    }

    private Anamnese buscarAnamnese(UUID id){
        return anamneseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Anamnese não encontrada"));
    }

}
