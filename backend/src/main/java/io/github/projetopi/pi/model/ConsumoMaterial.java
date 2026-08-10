package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_consumo_material")
@Getter
@Setter
public class ConsumoMaterial {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private  Material material;

    @ManyToOne
    @JoinColumn(name = "id_tratamento", nullable = false)
    private Tratamento tratamento;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private Instant dataCriacao;

    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private Instant dataAtualizacao;

    public ConsumoMaterial() {
    }

    public ConsumoMaterial(UUID id, Material material, Tratamento tratamento, Integer quantidade,
                           Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.material = material;
        this.tratamento = tratamento;
        this.quantidade = quantidade;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
