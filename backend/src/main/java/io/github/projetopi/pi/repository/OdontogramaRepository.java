package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Odontograma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OdontogramaRepository extends JpaRepository<Odontograma, UUID> {
}
