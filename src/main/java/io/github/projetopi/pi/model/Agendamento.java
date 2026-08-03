package io.github.projetopi.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.projetopi.pi.model.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_agendamento")
@Setter
@Getter
public class Agendamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_dentista", nullable = false)
    private Dentista dentista;

    @ManyToMany
    @JoinTable(name = "tb_agendamento_tratamento",
            joinColumns = @JoinColumn(name = "id_agendamento"),
            inverseJoinColumns = @JoinColumn(name = "id_tratamento")
    )
    private Set<Tratamento> tratamentos = new HashSet<>();

    @CreationTimestamp
    @Column(name = "data_hora", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", length = 30, nullable = false)
    private StatusAgendamento statusAgendamento;

    @Column(name = "Observacao", columnDefinition = "TEXT")
    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_fatura", nullable = false)
    private Fatura fatura;


    public Agendamento() {
    }

    public Agendamento(UUID id, Paciente paciente, Dentista dentista, Instant dataHora, String observacao, Fatura fatura, StatusAgendamento statusAgendamento, Set<Tratamento> tratamentos) {
        this.id = id;
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataHora = dataHora;
        this.observacao = observacao;
        this.fatura = fatura;
        this.statusAgendamento = statusAgendamento;
        this.tratamentos = tratamentos;
    }
}
