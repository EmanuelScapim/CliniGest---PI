package io.github.projetopi.pi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_dentista")
@PrimaryKeyJoinColumn(name = "id_dentista", referencedColumnName = "id_pessoa")
@Setter
@Getter
public class Dentista extends Pessoa{

    @Column(name = "cro", length = 6, nullable = false, unique = true)
    private String cro;

    @Column(name = "especialidade", length = 20, nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "dentista")
    private Set<Agendamento> agendamentos = new HashSet<>();

    public Dentista() {
    }

    public Dentista(PessoaBuilder<?, ?> b, String cro, String especialidade, Set<Agendamento> agendamentos) {
        super(b);
        this.cro = cro;
        this.especialidade = especialidade;
        this.agendamentos = agendamentos;
    }

}
