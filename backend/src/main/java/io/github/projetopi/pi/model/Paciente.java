package io.github.projetopi.pi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_paciente")
@PrimaryKeyJoinColumn(name = "id_paciente", referencedColumnName = "id_pessoa")
@Getter
@Setter
public class Paciente extends Pessoa {

    @OneToOne(mappedBy = "paciente")
    private Anamnese anamnese;

    @OneToOne(mappedBy = "paciente")
    private Odontograma odontograma;

    @OneToMany(mappedBy = "paciente")
    private Set<Agendamento> agendamento = new HashSet<>();

    @OneToOne(mappedBy = "paciente")
    private Prontuario prontuario;

    public Paciente() {
    }

    public Paciente(Anamnese anamnese, Odontograma odontograma, Set<Agendamento> agendamento, Prontuario prontuario) {
        this.anamnese = anamnese;
        this.odontograma = odontograma;
        this.agendamento = agendamento;
        this.prontuario = prontuario;
    }

    public Paciente(PessoaBuilder<?, ?> b, Anamnese anamnese, Odontograma odontograma, Set<Agendamento> agendamento, Prontuario prontuario) {
        super(b);
        this.anamnese = anamnese;
        this.odontograma = odontograma;
        this.agendamento = agendamento;
        this.prontuario = prontuario;
    }
}
