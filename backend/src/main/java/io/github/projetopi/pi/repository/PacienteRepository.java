package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    void deleteByEmailPessoa(String email);

    Optional<Paciente> findByEmailPessoaAndNomePessoaAndCpfAndDataNascimento(String email,
                                                            String nome,
                                                            String cpf,
                                                            LocalDate dataNascimento);
}
