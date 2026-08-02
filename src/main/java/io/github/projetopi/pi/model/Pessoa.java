package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class  Pessoa {

    @Id
    @Column(name = "id_pessoa", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_pessoa", length = 100, nullable = false)
    private String nomePessoa;

    @Column(name = "cpf", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "telefone_pessoa", length = 11, nullable = false)
    private String telefonePessoa;

    @Column(name = "email_pessoa", length = 50, unique = true, nullable = false)
    private String emailPessoa;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
