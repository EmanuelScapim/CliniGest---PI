package io.github.projetopi.pi.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_consumo_material")
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
}
