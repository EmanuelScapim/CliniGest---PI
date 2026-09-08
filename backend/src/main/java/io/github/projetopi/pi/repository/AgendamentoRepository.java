package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.model.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    boolean existsByPacienteIdAndStatusAgendamentoIn(UUID pacienteId, Collection<StatusAgendamento> status);

    boolean existsByDentistaIdAndStatusAgendamentoIn(UUID dentistaId, Collection<StatusAgendamento> status);

    @Query("""
            select count(a) > 0 from Agendamento a
            where a.dentista.id = :dentistaId
            and a.statusAgendamento in :status
            and (:agendamentoId is null or a.id <> :agendamentoId)
            and a.dataHoraFim > :inicioComTolerancia
            and a.dataHora < :fimComTolerancia
            """)
    boolean existsConflitoHorarioDentista(@Param("dentistaId") UUID dentistaId,
                                           @Param("status") Collection<StatusAgendamento> status,
                                           @Param("agendamentoId") UUID agendamentoId,
                                           @Param("inicioComTolerancia") Instant inicioComTolerancia,
                                           @Param("fimComTolerancia") Instant fimComTolerancia);

    @Query("""
            select count(a) > 0 from Agendamento a
            where a.paciente.id = :pacienteId
            and a.statusAgendamento in :status
            and (:agendamentoId is null or a.id <> :agendamentoId)
            and a.dataHoraFim > :inicioComTolerancia
            and a.dataHora < :fimComTolerancia
            """)
    boolean existsConflitoHorarioPaciente(@Param("pacienteId") UUID pacienteId,
                                           @Param("status") Collection<StatusAgendamento> status,
                                           @Param("agendamentoId") UUID agendamentoId,
                                           @Param("inicioComTolerancia") Instant inicioComTolerancia,
                                           @Param("fimComTolerancia") Instant fimComTolerancia);

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

    @Query("""
            select a from Agendamento
            a where a.dentista.nomePessoa = :nome
            """)
    List<Agendamento> listarAgendamentosPorDentista(@Param("nome") String nome);


}
