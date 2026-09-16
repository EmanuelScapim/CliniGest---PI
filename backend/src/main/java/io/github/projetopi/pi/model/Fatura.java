package io.github.projetopi.pi.model;


import io.github.projetopi.pi.model.enums.ModoPagamento;
import io.github.projetopi.pi.model.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_fatura")
@Getter
@Setter
public class Fatura {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agendamento", nullable = false)
    private Agendamento agendamento;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valor_total;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @Column(name = "modo_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private ModoPagamento modoPagamento;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private Instant dataCriacao;

    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private Instant dataAtualizacao;

    public Fatura() {
    }

    public Fatura(UUID id, BigDecimal valor_total, Agendamento agendamento, LocalDate dataEmissao,
                  StatusPagamento statusPagamento, ModoPagamento modoPagamento,
                  Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.valor_total = valor_total;
        this.agendamento = agendamento;
        this.dataEmissao = dataEmissao;
        this.statusPagamento = statusPagamento;
        this.modoPagamento = modoPagamento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
