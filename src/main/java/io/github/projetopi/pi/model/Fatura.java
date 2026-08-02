package io.github.projetopi.pi.model;


import io.github.projetopi.pi.model.enums.ModoPagamento;
import io.github.projetopi.pi.model.enums.StatusPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_fatura")
public class Fatura {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "fatura")
    private Agendamento agendamento;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valor_total;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @Column(name = "modo_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private ModoPagamento modoPagamento;
}
