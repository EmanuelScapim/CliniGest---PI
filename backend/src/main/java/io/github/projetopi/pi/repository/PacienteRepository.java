package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    @Query("SELECT p FROM Paciente p WHERE p.nomePessoa LIKE %:termo% OR p.emailPessoa LIKE %:termo%")
    List<Paciente> buscarPorNomeOuEmail(@Param("termo") String termo);

    void deleteByEmailPessoa(String email);
}
