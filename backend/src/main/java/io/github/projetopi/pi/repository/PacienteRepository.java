package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
}
