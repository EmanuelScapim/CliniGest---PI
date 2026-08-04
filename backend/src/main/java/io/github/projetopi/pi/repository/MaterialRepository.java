package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
}
