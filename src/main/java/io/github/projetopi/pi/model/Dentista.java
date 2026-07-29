package io.github.projetopi.pi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_dentista")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dentista {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(name = "cro", length = 6, nullable = false)
    private String cro;

    @Column(name = "especialidade", length = 20, nullable = false)
    private String especialidade;

    @Column(name = "email_dentista", length = 50, nullable = false)
    private String emaildentista;

    @Column(name = "cpf_dentista", length = 11, nullable = false)
    private String cpfDentista;

    @Column(name = "telefone_dentista", length = 11, nullable = false)
    private String telefoneDentista;
}
