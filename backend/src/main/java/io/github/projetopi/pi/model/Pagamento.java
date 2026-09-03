package io.github.projetopi.pi.model;

import io.github.projetopi.pi.model.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_pagamento")
@Getter
@Setter
public class Pagamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fatura", nullable = false)
    private Fatura fatura;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "num_fatura", length = 40, nullable = false)
    private String numFatura;

    @Column(name = "num_boleto", length = 48, nullable = false)
    private String numBoleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusPagamento status;

    public Pagamento() {
    }

    public Pagamento(UUID id, Fatura fatura, LocalDate dataPagamento, BigDecimal valor,
                      String numFatura, String numBoleto, StatusPagamento status) {
        this.id = id;
        this.fatura = fatura;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.numFatura = numFatura;
        this.numBoleto = numBoleto;
        this.status = status;
    }
}
