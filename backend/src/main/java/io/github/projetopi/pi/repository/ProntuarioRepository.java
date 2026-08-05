package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProntuarioRepository extends JpaRepository<Prontuario, UUID> {
}
