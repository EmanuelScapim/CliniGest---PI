package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    @Query("select d from Agendamento a join a.dentista d")
    List<Dentista> listarDentistasDosAtendimentos();

    @Query("select p from Agendamento a join a.paciente p")
    List<Paciente> listarPacienteDosAtendimentos();

    @Query("select t from Agendamento a join a.tratamentos t")
    List<Tratamento> listarTratamentoDosAtendimentos();

    @Query("""
            select a from Agendamento
            a where a.paciente.nomePessoa = :nome
            """)
    List<Agendamento> listarAgendamentosPorPaciente(@Param("nome") String nome);

}
