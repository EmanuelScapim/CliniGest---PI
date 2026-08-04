package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnamneseRepository extends JpaRepository<Anamnese, UUID> {
}
