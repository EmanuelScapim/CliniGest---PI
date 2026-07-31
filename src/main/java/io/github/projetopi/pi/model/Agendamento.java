package io.github.projetopi.pi.model;

import io.github.projetopi.pi.model.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_agendamento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_dentista", nullable = false)
    private Dentista dentista;

    @ManyToMany
    @JoinTable(name = "tb_agendamento_tratamento",
            joinColumns = @JoinColumn(name = "id_agendamento"),
            inverseJoinColumns = @JoinColumn(name = "id_tratamento")
    )
    Set<Tratamento> tratamentos = new HashSet<>();
    private Instant dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", length = 30, nullable = false)
    private StatusAgendamento statusAgendamento;

    @Column(name = "Observacao", columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_fatura", nullable = false)
    private Fatura fatura;
}
