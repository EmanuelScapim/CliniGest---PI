package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Anamnese;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.Pessoa;
import io.github.projetopi.pi.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AnamneseRepository extends JpaRepository<Anamnese, UUID> {

    @Query("select p from Anamnese a join a.paciente p")
    List<Paciente> listarPacientesAnamnese();

    @Query("select p from Anamnese a join a.prontuario p")
    List<Prontuario> listarProntuarioAnamnese();

    @Query("""
            select a from Anamnese
            a where a.paciente.nomePessoa = :nome
            """)
    Pessoa anamnesePorPessoa(@Param("nome") String nome);
}
