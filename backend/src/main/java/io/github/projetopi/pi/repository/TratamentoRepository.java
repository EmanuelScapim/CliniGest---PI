package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface TratamentoRepository extends JpaRepository<Tratamento, UUID> {

    @Query("""
            select count(a) > 0 from Agendamento a
            join a.tratamentos t where t.id = :id
            """)
    boolean existsAgendamentoVinculado(@Param("id") UUID id);

    Optional<Tratamento> findByNomeTratamentoIgnoreCase(String nomeTratamento);

}
