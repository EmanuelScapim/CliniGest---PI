package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface DentistaRepository extends JpaRepository<Dentista, UUID> {

    public Optional<Dentista> findByEmailPessoaAndNomePessoaAndCpfAndDataNascimentoAndCroAndEspecialidade(String email,
                                                                                    String nome,
                                                                                    String cpf,
                                                                                    LocalDate dataNascimento,
                                                                                    String cro,
                                                                                    String especialidade);

}
