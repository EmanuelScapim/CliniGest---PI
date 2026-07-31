package io.github.projetopi.pi.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_tratamento")
public class Tratamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_tratamento", length = 50, nullable = false)
    private String nomeTratamento;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToMany(mappedBy = "tratamentos")
    private Set<Agendamento> agendamentos = new HashSet<>();

}
