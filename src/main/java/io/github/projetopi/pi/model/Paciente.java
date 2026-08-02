package io.github.projetopi.pi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Paciente extends Pessoa {

    @OneToOne(mappedBy = "paciente")
    private Anamnese anamnese;

    @OneToOne(mappedBy = "paciente")
    private Odontograma odontograma;

    @OneToMany(mappedBy = "paciente")
    private Set<Agendamento> agendamento = new HashSet<>();

    @OneToOne(mappedBy = "paciente")
    private Prontuario prontuario;
}
