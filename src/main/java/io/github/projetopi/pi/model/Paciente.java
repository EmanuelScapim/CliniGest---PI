package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(name = "nome_paciente", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf_paciente", length = 11, nullable = false)
    private String cpf;

    @Column(name = "telefone_paciente", length = 11, nullable = false)
    private String telefone;

    @Column(name = "emaill_paciente", length = 50, nullable = false)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
