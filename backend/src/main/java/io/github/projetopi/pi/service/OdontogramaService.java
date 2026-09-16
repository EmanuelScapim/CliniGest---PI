package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Odontograma;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.repository.OdontogramaRepository;
import io.github.projetopi.pi.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OdontogramaService {

    private final OdontogramaRepository odontogramaRepository;
    private final PacienteRepository pacienteRepository;

    public Odontograma cadastrarOdontograma(Odontograma odontograma, UUID pacienteId){
        if(odontogramaRepository.existsByPacienteId(pacienteId)){
            throw new RegistroDuplicadoException("Paciente já possui odontograma vinculado");
        }

        odontograma.setPaciente(buscarPaciente(pacienteId));
        return odontogramaRepository.save(odontograma);
    }

    public List<Odontograma> listarTodos(){
        return odontogramaRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        odontogramaRepository.deleteById(id);
    }

    public void atualizarOdontograma(Odontograma odontograma){
        if(odontograma.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o odontograma exista");
        }

        odontogramaRepository.save(odontograma);
    }

    public Optional<Odontograma> encontrarPorId(UUID id){
        return odontogramaRepository.findById(id);
    }

    private Paciente buscarPaciente(UUID id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
    }

}
