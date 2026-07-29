package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_material", length = 50, nullable = false)
    private String nome;

    @Column(name ="quantidade_material")
    private Integer quantidadeMaterial;
}
