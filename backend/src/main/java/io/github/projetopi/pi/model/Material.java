package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_material")
@Getter
@Setter
public class Material {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_material", length = 50, nullable = false)
    private String nome;

    @Column(name ="quantidade_material")
    private Integer quantidadeMaterial;

    @OneToMany(mappedBy = "material")
    private Set<ConsumoMaterial> consumo = new HashSet<>();

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private Instant dataCriacao;

    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private Instant dataAtualizacao;

    public Material() {
    }

    public Material(UUID id, String nome, Integer quantidadeMaterial, Set<ConsumoMaterial> consumo,
                    Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.quantidadeMaterial = quantidadeMaterial;
        this.consumo = consumo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
