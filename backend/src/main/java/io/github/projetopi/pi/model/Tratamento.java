package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_tratamento")
@Getter
@Setter
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

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @OneToMany(mappedBy = "tratamento")
    private Set<ConsumoMaterial> consumo = new HashSet<>();

    public Tratamento() {
    }

    public Tratamento(UUID id, String nomeTratamento, String descricao, Set<Agendamento> agendamentos, BigDecimal valor, Set<ConsumoMaterial> consumo) {
        this.id = id;
        this.nomeTratamento = nomeTratamento;
        this.descricao = descricao;
        this.agendamentos = agendamentos;
        this.valor = valor;
        this.consumo = consumo;
    }
}
