package io.github.projetopi.pi.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Tratamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nomeTratamento", length = 50, nullable = false)
    private String nomeTratamento;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

}
